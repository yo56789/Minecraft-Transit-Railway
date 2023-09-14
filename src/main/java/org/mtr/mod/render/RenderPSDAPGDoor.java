package org.mtr.mod.render;

import org.mtr.init.MTR;
import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockEntityRenderer;
import org.mtr.mapping.mapper.EntityModelExtension;
import org.mtr.mapping.mapper.GraphicsHolder;
import org.mtr.mapping.mapper.ModelPartExtension;
import org.mtr.mod.block.*;
import org.mtr.mod.data.IGui;

public class RenderPSDAPGDoor<T extends BlockPSDAPGDoorBase.BlockEntityBase> extends BlockEntityRenderer<T> implements IGui, IBlock {

	private final int type;
	private static final ModelSingleCube MODEL_PSD = new ModelSingleCube(36, 18, 0, 0, 0, 16, 16, 2);
	private static final ModelSingleCube MODEL_PSD_END_LEFT_1 = new ModelSingleCube(20, 18, 0, 0, 0, 8, 16, 2);
	private static final ModelSingleCube MODEL_PSD_END_RIGHT_1 = new ModelSingleCube(20, 18, 8, 0, 0, 8, 16, 2);
	private static final ModelSingleCube MODEL_PSD_END_LEFT_2 = new ModelSingleCube(20, 18, 8, 0, 2, 8, 16, 2);
	private static final ModelSingleCube MODEL_PSD_END_RIGHT_2 = new ModelSingleCube(20, 18, 0, 0, 2, 8, 16, 2);
	private static final ModelSingleCube MODEL_PSD_LIGHT_LEFT = new ModelSingleCube(16, 16, 0, -1, 5, 1, 1, 1);
	private static final ModelSingleCube MODEL_PSD_LIGHT_RIGHT = new ModelSingleCube(16, 16, 15, -1, 5, 1, 1, 1);
	private static final ModelSingleCube MODEL_APG_TOP = new ModelSingleCube(34, 9, 0, 8, 1, 16, 8, 1);
	private static final ModelAPGDoorBottom MODEL_APG_BOTTOM = new ModelAPGDoorBottom();
	private static final ModelAPGDoorLight MODEL_APG_LIGHT = new ModelAPGDoorLight();
	private static final ModelSingleCube MODEL_APG_DOOR_LOCKED = new ModelSingleCube(6, 6, 5, 10, 1, 6, 6, 0);
	private static final ModelSingleCube MODEL_PSD_DOOR_LOCKED = new ModelSingleCube(6, 6, 5, 6, 1, 6, 6, 0);
	private static final ModelSingleCube MODEL_LIFT_LEFT = new ModelSingleCube(28, 18, 0, 0, 0, 12, 16, 2);
	private static final ModelSingleCube MODEL_LIFT_RIGHT = new ModelSingleCube(28, 18, 4, 0, 0, 12, 16, 2);

	public RenderPSDAPGDoor(BlockEntityRendererArgument dispatcher, int type) {
		super(dispatcher);
		this.type = type;
	}

	@Override
	public void render(T entity, float tickDelta, GraphicsHolder graphicsHolder, int light, int overlay) {
		final World world = entity.getWorld2();
		if (world == null) {
			return;
		}

		final BlockPos pos = entity.getPos2();
		if (IBlock.getStatePropertySafe(world, pos, BlockPSDAPGDoorBase.TEMP)) {
			return;
		}

		final Direction facing = IBlock.getStatePropertySafe(world, pos, BlockPSDAPGDoorBase.FACING);
		final boolean side = IBlock.getStatePropertySafe(world, pos, BlockPSDAPGDoorBase.SIDE) == EnumSide.RIGHT;
		final boolean half = IBlock.getStatePropertySafe(world, pos, BlockPSDAPGDoorBase.HALF) == DoubleBlockHalf.UPPER;
		final boolean end = IBlock.getStatePropertySafe(world, pos, BlockPSDAPGDoorBase.END);
		final boolean unlocked = IBlock.getStatePropertySafe(world, pos, BlockPSDAPGDoorBase.UNLOCKED);
		final float open = Math.min(entity.getOpen(MinecraftClient.getInstance().getLastFrameDuration()), type >= 3 ? 0.75F : 1);

		final StoredMatrixTransformations storedMatrixTransformations = new StoredMatrixTransformations();
		storedMatrixTransformations.add(graphicsHolderNew -> {
			graphicsHolderNew.translate(0.5 + entity.getPos2().getX(), entity.getPos2().getY(), 0.5 + entity.getPos2().getZ());
			graphicsHolderNew.rotateYDegrees(-facing.asRotation());
			graphicsHolderNew.rotateXDegrees(180);
		});
		final StoredMatrixTransformations storedMatrixTransformationsLight = storedMatrixTransformations.copy();

		switch (type) {
			case 0:
			case 1:
				if (half) {
					RenderTrains.scheduleRender(new Identifier(String.format("mtr:textures/block/light_%s.png", open > 0 ? "on" : "off")), false, open > 0 ? RenderTrains.QueuedRenderLayer.LIGHT : RenderTrains.QueuedRenderLayer.EXTERIOR, graphicsHolderNew -> {
						storedMatrixTransformationsLight.transform(graphicsHolderNew);
						(side ? MODEL_PSD_LIGHT_RIGHT : MODEL_PSD_LIGHT_LEFT).render(graphicsHolderNew, light, overlay, 1, 1, 1, 1);
						graphicsHolderNew.pop();
					});
				}
				if (end) {
					RenderTrains.scheduleRender(new Identifier(String.format("mtr:textures/block/psd_door_end_%s_%s_2_%s.png", half ? "top" : "bottom", side ? "right" : "left", type == 1 ? "2" : "1")), false, RenderTrains.QueuedRenderLayer.EXTERIOR, graphicsHolderNew -> {
						storedMatrixTransformationsLight.transform(graphicsHolderNew);
						graphicsHolderNew.translate(open / 2 * (side ? -1 : 1), 0, 0);
						(side ? MODEL_PSD_END_RIGHT_2 : MODEL_PSD_END_LEFT_2).render(graphicsHolderNew, light, overlay, 1, 1, 1, 1);
						graphicsHolderNew.pop();
					});
				}
				break;
			case 2:
				if (half) {
					final Block block = world.getBlockState(pos.offset(side ? facing.rotateYClockwise() : facing.rotateYCounterclockwise())).getBlock();
					if (block.data instanceof BlockAPGGlass || block.data instanceof BlockAPGGlassEnd) {
						RenderTrains.scheduleRender(new Identifier(String.format("mtr:textures/block/apg_door_light_%s.png", open > 0 ? "on" : "off")), false, open > 0 ? RenderTrains.QueuedRenderLayer.LIGHT_TRANSLUCENT : RenderTrains.QueuedRenderLayer.EXTERIOR, graphicsHolderNew -> {
							storedMatrixTransformationsLight.transform(graphicsHolderNew);
							graphicsHolderNew.translate(side ? -0.515625 : 0.515625, 0, 0);
							graphicsHolderNew.scale(0.5F, 1, 1);
							MODEL_APG_LIGHT.render(graphicsHolderNew, light, overlay, 1, 1, 1, 1);
							graphicsHolderNew.pop();
						});
					}
				}
				break;
		}

		storedMatrixTransformations.add(matricesNew -> matricesNew.translate(open * (side ? -1 : 1), 0, 0));

		switch (type) {
			case 0:
			case 1:
				if (end) {
					RenderTrains.scheduleRender(new Identifier(String.format("mtr:textures/block/psd_door_end_%s_%s_1_%s.png", half ? "top" : "bottom", side ? "right" : "left", type == 1 ? "2" : "1")), false, RenderTrains.QueuedRenderLayer.EXTERIOR, graphicsHolderNew -> {
						storedMatrixTransformations.transform(graphicsHolderNew);
						(side ? MODEL_PSD_END_RIGHT_1 : MODEL_PSD_END_LEFT_1).render(graphicsHolderNew, light, overlay, 1, 1, 1, 1);
						graphicsHolderNew.pop();
					});
				} else {
					RenderTrains.scheduleRender(new Identifier(String.format("mtr:textures/block/psd_door_%s_%s_%s.png", half ? "top" : "bottom", side ? "right" : "left", type == 1 ? "2" : "1")), false, RenderTrains.QueuedRenderLayer.EXTERIOR, graphicsHolderNew -> {
						storedMatrixTransformations.transform(graphicsHolderNew);
						MODEL_PSD.render(graphicsHolderNew, light, overlay, 1, 1, 1, 1);
						graphicsHolderNew.pop();
					});
				}
				if (half && !unlocked) {
					RenderTrains.scheduleRender(new Identifier(MTR.MOD_ID, "textures/block/sign/door_not_in_use.png"), false, RenderTrains.QueuedRenderLayer.EXTERIOR, graphicsHolderNew -> {
						storedMatrixTransformations.transform(graphicsHolderNew);
						if (end) {
							graphicsHolderNew.translate(side ? 0.25 : -0.25, 0, 0);
						}
						MODEL_PSD_DOOR_LOCKED.render(graphicsHolderNew, light, overlay, 1, 1, 1, 1);
						graphicsHolderNew.pop();
					});
				}
				break;
			case 2:
				RenderTrains.scheduleRender(new Identifier(String.format("mtr:textures/block/apg_door_%s_%s.png", half ? "top" : "bottom", side ? "right" : "left")), false, RenderTrains.QueuedRenderLayer.EXTERIOR, graphicsHolderNew -> {
					storedMatrixTransformations.transform(graphicsHolderNew);
					(half ? MODEL_APG_TOP : MODEL_APG_BOTTOM).render(graphicsHolderNew, light, overlay, 1, 1, 1, 1);
					graphicsHolderNew.pop();
				});
				if (half && !unlocked) {
					RenderTrains.scheduleRender(new Identifier(MTR.MOD_ID, "textures/block/sign/door_not_in_use.png"), false, RenderTrains.QueuedRenderLayer.EXTERIOR, graphicsHolderNew -> {
						storedMatrixTransformations.transform(graphicsHolderNew);
						MODEL_APG_DOOR_LOCKED.render(graphicsHolderNew, light, overlay, 1, 1, 1, 1);
						graphicsHolderNew.pop();
					});
				}
				break;
			case 4:
				if (IBlock.getStatePropertySafe(world, pos, ITripleBlock.ODD)) {
					break;
				}
				storedMatrixTransformations.add(matricesNew -> matricesNew.translate(side ? 0.5 : -0.5, 0, 0));
			case 3:
				RenderTrains.scheduleRender(new Identifier(String.format("mtr:textures/block/lift_door_%s_%s_1.png", half ? "top" : "bottom", side ? "right" : "left")), false, RenderTrains.QueuedRenderLayer.EXTERIOR, graphicsHolderNew -> {
					storedMatrixTransformations.transform(graphicsHolderNew);
					(side ? MODEL_LIFT_RIGHT : MODEL_LIFT_LEFT).render(graphicsHolderNew, light, overlay, 1, 1, 1, 1);
					graphicsHolderNew.pop();
				});
				if (half && !unlocked) {
					RenderTrains.scheduleRender(new Identifier(MTR.MOD_ID, "textures/block/sign/door_not_in_use.png"), false, RenderTrains.QueuedRenderLayer.EXTERIOR, graphicsHolderNew -> {
						storedMatrixTransformations.transform(graphicsHolderNew);
						graphicsHolderNew.translate(side ? 0.125 : -0.125, 0, 0);
						MODEL_PSD_DOOR_LOCKED.render(graphicsHolderNew, light, overlay, 1, 1, 1, 1);
						graphicsHolderNew.pop();
					});
				}
				break;
		}
	}

	@Override
	public boolean rendersOutsideBoundingBox(T blockEntity) {
		return true;
	}

	private static class ModelSingleCube extends EntityModelExtension<EntityAbstractMapping> {

		private final ModelPartExtension cube;

		private ModelSingleCube(int textureWidth, int textureHeight, int x, int y, int z, int length, int height, int depth) {
			super(textureWidth, textureHeight);
			cube = createModelPart();
			cube.setTextureUVOffset(0, 0).addCuboid(x - 8, y - 16, z - 8, length, height, depth, 0, false);
			buildModel();
		}

		@Override
		public void render(GraphicsHolder graphicsHolder, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
			cube.render(graphicsHolder, 0, 0, 0, packedLight, packedOverlay);
		}

		@Override
		public void setAngles2(EntityAbstractMapping entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		}
	}

	private static class ModelAPGDoorBottom extends EntityModelExtension<EntityAbstractMapping> {

		private final ModelPartExtension bone;

		private ModelAPGDoorBottom() {
			super(34, 27);

			bone = createModelPart();
			bone.setTextureUVOffset(0, 0).addCuboid(-8, -16, -7, 16, 16, 1, 0, false);
			bone.setTextureUVOffset(0, 17).addCuboid(-8, -6, -8, 16, 6, 1, 0, false);

			final ModelPartExtension cube_r1 = createModelPart();
			cube_r1.setPivot(0, -6, -8);
			bone.addChild(cube_r1);
			cube_r1.setRotation(-0.7854F, 0, 0);
			cube_r1.setTextureUVOffset(0, 24).addCuboid(-8, -2, 0, 16, 2, 1, 0, false);

			buildModel();
		}

		@Override
		public void render(GraphicsHolder graphicsHolder, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
			bone.render(graphicsHolder, 0, 0, 0, packedLight, packedOverlay);
		}

		@Override
		public void setAngles2(EntityAbstractMapping entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		}
	}

	private static class ModelAPGDoorLight extends EntityModelExtension<EntityAbstractMapping> {

		private final ModelPartExtension bone;

		private ModelAPGDoorLight() {
			super(8, 8);

			bone = createModelPart();
			bone.setTextureUVOffset(0, 4).addCuboid(-0.5F, -9, -7, 1, 1, 3, 0.05F, false);

			final ModelPartExtension cube_r1 = createModelPart();
			cube_r1.setPivot(0, -9.05F, -4.95F);
			bone.addChild(cube_r1);
			cube_r1.setRotation(0.3927F, 0, 0);
			cube_r1.setTextureUVOffset(0, 0).addCuboid(-0.5F, 0.05F, -3.05F, 1, 1, 3, 0.05F, false);

			buildModel();
		}

		@Override
		public void render(GraphicsHolder graphicsHolder, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
			bone.render(graphicsHolder, 0, 0, 0, packedLight, packedOverlay);
		}

		@Override
		public void setAngles2(EntityAbstractMapping entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		}
	}
}