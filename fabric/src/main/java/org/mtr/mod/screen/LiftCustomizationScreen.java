package org.mtr.mod.screen;

import org.mtr.core.data.EnumHelper;
import org.mtr.core.data.Lift;
import org.mtr.core.tools.Angle;
import org.mtr.mapping.holder.ClickableWidget;
import org.mtr.mapping.holder.Direction;
import org.mtr.mapping.holder.MutableText;
import org.mtr.mapping.holder.Text;
import org.mtr.mapping.mapper.*;
import org.mtr.mod.client.IDrawing;
import org.mtr.mod.data.IGui;
import org.mtr.mod.packet.IPacket;

import java.util.Locale;

public class LiftCustomizationScreen extends ScreenExtension implements IGui, IPacket {

	private LiftStyle liftStyle;
	private Direction liftDirection;

	private final Lift lift;
	private final ButtonWidgetExtension buttonHeightMinus;
	private final ButtonWidgetExtension buttonHeightAdd;
	private final ButtonWidgetExtension buttonWidthMinus;
	private final ButtonWidgetExtension buttonWidthAdd;
	private final ButtonWidgetExtension buttonDepthMinus;
	private final ButtonWidgetExtension buttonDepthAdd;
	private final ButtonWidgetExtension buttonOffsetXMinus;
	private final ButtonWidgetExtension buttonOffsetXAdd;
	private final ButtonWidgetExtension buttonOffsetYMinus;
	private final ButtonWidgetExtension buttonOffsetYAdd;
	private final ButtonWidgetExtension buttonOffsetZMinus;
	private final ButtonWidgetExtension buttonOffsetZAdd;
	private final CheckboxWidgetExtension buttonIsDoubleSided;
	private final ButtonWidgetExtension buttonLiftStyle;
	private final ButtonWidgetExtension buttonRotateAnticlockwise;
	private final ButtonWidgetExtension buttonRotateClockwise;
	private final int width1;
	private final int width2;

	private static final int MIN_DIMENSION = 2;
	private static final int MAX_DIMENSION = 16;
	private static final int MAX_OFFSET = 16;

	public LiftCustomizationScreen(Lift lift) {
		super();
		this.lift = lift;
		liftStyle = EnumHelper.valueOf(LiftStyle.TRANSPARENT, lift.getStyle());
		liftDirection = Direction.fromRotation(lift.getAngle().angleDegrees);

		buttonHeightMinus = new ButtonWidgetExtension(0, 0, 0, SQUARE_SIZE, TextHelper.literal("-"), button -> {
			lift.setHeight(Math.max(MIN_DIMENSION * 2, lift.getHeight() - 1));
			updateControls();
		});
		buttonHeightAdd = new ButtonWidgetExtension(0, 0, 0, SQUARE_SIZE, TextHelper.literal("+"), button -> {
			lift.setHeight(Math.min(MAX_DIMENSION * 2, lift.getHeight() + 1));
			updateControls();
		});
		buttonWidthMinus = new ButtonWidgetExtension(0, 0, 0, SQUARE_SIZE, TextHelper.literal("-"), button -> {
			lift.setWidth(Math.max(MIN_DIMENSION, lift.getWidth() - 1));
			updateControls();
		});
		buttonWidthAdd = new ButtonWidgetExtension(0, 0, 0, SQUARE_SIZE, TextHelper.literal("+"), button -> {
			lift.setWidth(Math.min(MAX_DIMENSION, lift.getWidth() + 1));
			updateControls();
		});
		buttonDepthMinus = new ButtonWidgetExtension(0, 0, 0, SQUARE_SIZE, TextHelper.literal("-"), button -> {
			lift.setDepth(Math.max(MIN_DIMENSION, lift.getDepth() - 1));
			updateControls();
		});
		buttonDepthAdd = new ButtonWidgetExtension(0, 0, 0, SQUARE_SIZE, TextHelper.literal("+"), button -> {
			lift.setDepth(Math.min(MAX_DIMENSION, lift.getDepth() + 1));
			updateControls();
		});
		buttonOffsetXMinus = new ButtonWidgetExtension(0, 0, 0, SQUARE_SIZE, TextHelper.literal("-"), button -> {
			lift.setOffsetX(Math.max(-MAX_OFFSET * 2, lift.getOffsetX() - 1));
			updateControls();
		});
		buttonOffsetXAdd = new ButtonWidgetExtension(0, 0, 0, SQUARE_SIZE, TextHelper.literal("+"), button -> {
			lift.setOffsetX(Math.min(MAX_OFFSET * 2, lift.getOffsetX() + 1));
			updateControls();
		});
		buttonOffsetYMinus = new ButtonWidgetExtension(0, 0, 0, SQUARE_SIZE, TextHelper.literal("-"), button -> {
			lift.setOffsetY(Math.max(-MAX_OFFSET, lift.getOffsetY() - 1));
			updateControls();
		});
		buttonOffsetYAdd = new ButtonWidgetExtension(0, 0, 0, SQUARE_SIZE, TextHelper.literal("+"), button -> {
			lift.setOffsetY(Math.min(MAX_OFFSET, lift.getOffsetY() + 1));
			updateControls();
		});
		buttonOffsetZMinus = new ButtonWidgetExtension(0, 0, 0, SQUARE_SIZE, TextHelper.literal("-"), button -> {
			lift.setOffsetZ(Math.max(-MAX_OFFSET * 2, lift.getOffsetZ() - 1));
			updateControls();
		});
		buttonOffsetZAdd = new ButtonWidgetExtension(0, 0, 0, SQUARE_SIZE, TextHelper.literal("+"), button -> {
			lift.setOffsetZ(Math.min(MAX_OFFSET * 2, lift.getOffsetZ() + 1));
			updateControls();
		});
		final MutableText doubleSidedText = TextHelper.translatable("gui.mtr.lift_is_double_sided");
		final MutableText rotateAnticlockwiseText = TextHelper.translatable("gui.mtr.rotate_anticlockwise");
		final MutableText rotateClockwiseText = TextHelper.translatable("gui.mtr.rotate_clockwise");
		buttonIsDoubleSided = new CheckboxWidgetExtension(0, 0, 0, SQUARE_SIZE, true, lift::setIsDoubleSided);
		buttonIsDoubleSided.setMessage2(new Text(doubleSidedText.data));
		buttonLiftStyle = new ButtonWidgetExtension(0, 0, 0, SQUARE_SIZE, button -> {
			liftStyle = LiftStyle.values()[(liftStyle.ordinal() + 1) % LiftStyle.values().length];
			lift.setStyle(liftStyle.toString());
			updateControls();
		});
		buttonRotateAnticlockwise = new ButtonWidgetExtension(0, 0, 0, SQUARE_SIZE, rotateAnticlockwiseText, button -> {
			liftDirection = liftDirection.rotateYCounterclockwise();
			lift.setAngle(Angle.fromAngle(liftDirection.asRotation()));
		});
		buttonRotateClockwise = new ButtonWidgetExtension(0, 0, 0, SQUARE_SIZE, rotateClockwiseText, button -> {
			liftDirection = liftDirection.rotateYClockwise();
			lift.setAngle(Angle.fromAngle(liftDirection.asRotation()));
		});

		width1 = Math.max(Math.max(SQUARE_SIZE * 3, GraphicsHolder.getTextWidth(doubleSidedText)), Math.max(GraphicsHolder.getTextWidth(rotateAnticlockwiseText), GraphicsHolder.getTextWidth(rotateClockwiseText))) + TEXT_PADDING * 2;
		width2 = width1 + SQUARE_SIZE;
	}

	@Override
	protected void init2() {
		super.init2();

		IDrawing.setPositionAndWidth(buttonHeightMinus, 0, 0, SQUARE_SIZE);
		IDrawing.setPositionAndWidth(buttonHeightAdd, width1, 0, SQUARE_SIZE);
		IDrawing.setPositionAndWidth(buttonWidthMinus, 0, SQUARE_SIZE, SQUARE_SIZE);
		IDrawing.setPositionAndWidth(buttonWidthAdd, width1, SQUARE_SIZE, SQUARE_SIZE);
		IDrawing.setPositionAndWidth(buttonDepthMinus, 0, SQUARE_SIZE * 2, SQUARE_SIZE);
		IDrawing.setPositionAndWidth(buttonDepthAdd, width1, SQUARE_SIZE * 2, SQUARE_SIZE);
		IDrawing.setPositionAndWidth(buttonOffsetXMinus, 0, SQUARE_SIZE * 3, SQUARE_SIZE);
		IDrawing.setPositionAndWidth(buttonOffsetXAdd, width1, SQUARE_SIZE * 3, SQUARE_SIZE);
		IDrawing.setPositionAndWidth(buttonOffsetYMinus, 0, SQUARE_SIZE * 4, SQUARE_SIZE);
		IDrawing.setPositionAndWidth(buttonOffsetYAdd, width1, SQUARE_SIZE * 4, SQUARE_SIZE);
		IDrawing.setPositionAndWidth(buttonOffsetZMinus, 0, SQUARE_SIZE * 5, SQUARE_SIZE);
		IDrawing.setPositionAndWidth(buttonOffsetZAdd, width1, SQUARE_SIZE * 5, SQUARE_SIZE);
		IDrawing.setPositionAndWidth(buttonIsDoubleSided, 0, SQUARE_SIZE * 7, width2);
		IDrawing.setPositionAndWidth(buttonLiftStyle, 0, SQUARE_SIZE * 8, width2);
		IDrawing.setPositionAndWidth(buttonRotateAnticlockwise, 0, SQUARE_SIZE * 9, width2);
		IDrawing.setPositionAndWidth(buttonRotateClockwise, 0, SQUARE_SIZE * 10, width2);

		addChild(new ClickableWidget(buttonHeightMinus));
		addChild(new ClickableWidget(buttonHeightAdd));
		addChild(new ClickableWidget(buttonWidthMinus));
		addChild(new ClickableWidget(buttonWidthAdd));
		addChild(new ClickableWidget(buttonDepthMinus));
		addChild(new ClickableWidget(buttonDepthAdd));
		addChild(new ClickableWidget(buttonOffsetXMinus));
		addChild(new ClickableWidget(buttonOffsetXAdd));
		addChild(new ClickableWidget(buttonOffsetYMinus));
		addChild(new ClickableWidget(buttonOffsetYAdd));
		addChild(new ClickableWidget(buttonOffsetZMinus));
		addChild(new ClickableWidget(buttonOffsetZAdd));
		addChild(new ClickableWidget(buttonIsDoubleSided));
//		addChild(new ClickableWidget(buttonLiftStyle));
		addChild(new ClickableWidget(buttonRotateAnticlockwise));
		addChild(new ClickableWidget(buttonRotateClockwise));
		updateControls();
	}

	@Override
	public void render(GraphicsHolder graphicsHolder, int mouseX, int mouseY, float delta) {
		final GuiDrawing guiDrawing = new GuiDrawing(graphicsHolder);
		guiDrawing.beginDrawingRectangle();
		guiDrawing.drawRectangle(0, 0, width2, height, ARGB_BACKGROUND);
		guiDrawing.finishDrawingRectangle();
		super.render(graphicsHolder, mouseX, mouseY, delta);
		graphicsHolder.drawCenteredText(TextHelper.translatable("tooltip.mtr.rail_action_height", lift.getHeight() / 2F), width2 / 2, TEXT_PADDING, ARGB_WHITE);
		graphicsHolder.drawCenteredText(TextHelper.translatable("tooltip.mtr.rail_action_width", lift.getWidth()), width2 / 2, SQUARE_SIZE + TEXT_PADDING, ARGB_WHITE);
		graphicsHolder.drawCenteredText(TextHelper.translatable("tooltip.mtr.rail_action_depth", lift.getDepth()), width2 / 2, SQUARE_SIZE * 2 + TEXT_PADDING, ARGB_WHITE);
		graphicsHolder.drawCenteredText(TextHelper.translatable("gui.mtr.offset_x", lift.getOffsetX() / 2F), width2 / 2, SQUARE_SIZE * 3 + TEXT_PADDING, ARGB_WHITE);
		graphicsHolder.drawCenteredText(TextHelper.translatable("gui.mtr.offset_y", lift.getOffsetY()), width2 / 2, SQUARE_SIZE * 4 + TEXT_PADDING, ARGB_WHITE);
		graphicsHolder.drawCenteredText(TextHelper.translatable("gui.mtr.offset_z", lift.getOffsetZ() / 2F), width2 / 2, SQUARE_SIZE * 5 + TEXT_PADDING, ARGB_WHITE);
	}

	@Override
	public void onClose2() {
		super.onClose2();
		// TODO
	}

	@Override
	public boolean isPauseScreen2() {
		return false;
	}

	private void updateControls() {
		buttonHeightMinus.active = lift.getHeight() > MIN_DIMENSION * 2;
		buttonHeightAdd.active = lift.getHeight() < MAX_DIMENSION * 2;
		buttonWidthMinus.active = lift.getWidth() > MIN_DIMENSION;
		buttonWidthAdd.active = lift.getWidth() < MAX_DIMENSION;
		buttonDepthMinus.active = lift.getDepth() > MIN_DIMENSION;
		buttonDepthAdd.active = lift.getDepth() < MAX_DIMENSION;
		buttonOffsetXMinus.active = lift.getOffsetX() > -MAX_OFFSET * 2;
		buttonOffsetXAdd.active = lift.getOffsetX() < MAX_OFFSET * 2;
		buttonOffsetYMinus.active = lift.getOffsetY() > -MAX_OFFSET;
		buttonOffsetYAdd.active = lift.getOffsetY() < MAX_OFFSET;
		buttonOffsetZMinus.active = lift.getOffsetZ() > -MAX_OFFSET * 2;
		buttonOffsetZAdd.active = lift.getOffsetZ() < MAX_OFFSET * 2;
		buttonIsDoubleSided.setChecked(lift.getIsDoubleSided());
		buttonLiftStyle.setMessage2(new Text(TextHelper.translatable("gui.mtr.lift_style", TextHelper.translatable("gui.mtr.lift_style_" + lift.getStyle().toLowerCase(Locale.ENGLISH))).data));
	}

	private enum LiftStyle {TRANSPARENT, OPAQUE}
}