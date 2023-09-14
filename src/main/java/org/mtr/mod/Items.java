package org.mtr.mod;

import org.mtr.core.data.TransportMode;
import org.mtr.core.tools.DyeColor;
import org.mtr.init.MTR;
import org.mtr.mapping.holder.Identifier;
import org.mtr.mapping.holder.Item;
import org.mtr.mapping.mapper.ItemExtension;
import org.mtr.mapping.mapper.PlaceableOnWaterItemExtension;
import org.mtr.mapping.registry.ItemRegistryObject;
import org.mtr.mapping.registry.Registry;
import org.mtr.mod.data.RailType;
import org.mtr.mod.item.*;

public final class Items {

	static {
		// Brush and dashboards
		BRUSH = Registry.registerItem(new Identifier(MTR.MOD_ID, "brush"), itemSettings -> new Item(new ItemExtension(itemSettings.maxCount(1))), CreativeModeTabs.CORE);
		RAILWAY_DASHBOARD = Registry.registerItem(new Identifier(MTR.MOD_ID, "dashboard"), itemSettings -> new Item(new ItemDashboard(TransportMode.TRAIN, itemSettings)), CreativeModeTabs.CORE);
		BOAT_DASHBOARD = Registry.registerItem(new Identifier(MTR.MOD_ID, "dashboard_2"), itemSettings -> new Item(new ItemDashboard(TransportMode.BOAT, itemSettings)), CreativeModeTabs.CORE);
		CABLE_CAR_DASHBOARD = Registry.registerItem(new Identifier(MTR.MOD_ID, "dashboard_3"), itemSettings -> new Item(new ItemDashboard(TransportMode.CABLE_CAR, itemSettings)), CreativeModeTabs.CORE);
		AIRPLANE_DASHBOARD = Registry.registerItem(new Identifier(MTR.MOD_ID, "dashboard_4"), itemSettings -> new Item(new ItemDashboard(TransportMode.AIRPLANE, itemSettings)), CreativeModeTabs.CORE);

		// Misc
		DRIVER_KEY = Registry.registerItem(new Identifier(MTR.MOD_ID, "driver_key"), itemSettings -> new Item(new ItemExtension(itemSettings.maxCount(1))), CreativeModeTabs.CORE);
		BOAT_NODE = Registry.registerItem(new Identifier(MTR.MOD_ID, "boat_node"), itemSettings -> new Item(new PlaceableOnWaterItemExtension(Blocks.BOAT_NODE.get(), itemSettings)), CreativeModeTabs.CORE);
		RESOURCE_PACK_CREATOR = Registry.registerItem(new Identifier(MTR.MOD_ID, "resource_pack_creator"), itemSettings -> new Item(new ItemResourcePackCreator(itemSettings)), CreativeModeTabs.CORE);

		// Doors
		APG_DOOR = Registry.registerItem(new Identifier(MTR.MOD_ID, "apg_door"), itemSettings -> new Item(new ItemPSDAPGBase(ItemPSDAPGBase.EnumPSDAPGItem.PSD_APG_DOOR, ItemPSDAPGBase.EnumPSDAPGType.APG, itemSettings)), CreativeModeTabs.RAILWAY_FACILITIES);
		APG_GLASS = Registry.registerItem(new Identifier(MTR.MOD_ID, "apg_glass"), itemSettings -> new Item(new ItemPSDAPGBase(ItemPSDAPGBase.EnumPSDAPGItem.PSD_APG_GLASS, ItemPSDAPGBase.EnumPSDAPGType.APG, itemSettings)), CreativeModeTabs.RAILWAY_FACILITIES);
		APG_GLASS_END = Registry.registerItem(new Identifier(MTR.MOD_ID, "apg_glass_end"), itemSettings -> new Item(new ItemPSDAPGBase(ItemPSDAPGBase.EnumPSDAPGItem.PSD_APG_GLASS_END, ItemPSDAPGBase.EnumPSDAPGType.APG, itemSettings)), CreativeModeTabs.RAILWAY_FACILITIES);
		PSD_DOOR_1 = Registry.registerItem(new Identifier(MTR.MOD_ID, "psd_door"), itemSettings -> new Item(new ItemPSDAPGBase(ItemPSDAPGBase.EnumPSDAPGItem.PSD_APG_DOOR, ItemPSDAPGBase.EnumPSDAPGType.PSD_1, itemSettings)), CreativeModeTabs.RAILWAY_FACILITIES);
		PSD_GLASS_1 = Registry.registerItem(new Identifier(MTR.MOD_ID, "psd_glass"), itemSettings -> new Item(new ItemPSDAPGBase(ItemPSDAPGBase.EnumPSDAPGItem.PSD_APG_GLASS, ItemPSDAPGBase.EnumPSDAPGType.PSD_1, itemSettings)), CreativeModeTabs.RAILWAY_FACILITIES);
		PSD_GLASS_END_1 = Registry.registerItem(new Identifier(MTR.MOD_ID, "psd_glass_end"), itemSettings -> new Item(new ItemPSDAPGBase(ItemPSDAPGBase.EnumPSDAPGItem.PSD_APG_GLASS_END, ItemPSDAPGBase.EnumPSDAPGType.PSD_1, itemSettings)), CreativeModeTabs.RAILWAY_FACILITIES);
		PSD_DOOR_2 = Registry.registerItem(new Identifier(MTR.MOD_ID, "psd_door_2"), itemSettings -> new Item(new ItemPSDAPGBase(ItemPSDAPGBase.EnumPSDAPGItem.PSD_APG_DOOR, ItemPSDAPGBase.EnumPSDAPGType.PSD_2, itemSettings)), CreativeModeTabs.RAILWAY_FACILITIES);
		PSD_GLASS_2 = Registry.registerItem(new Identifier(MTR.MOD_ID, "psd_glass_2"), itemSettings -> new Item(new ItemPSDAPGBase(ItemPSDAPGBase.EnumPSDAPGItem.PSD_APG_GLASS, ItemPSDAPGBase.EnumPSDAPGType.PSD_2, itemSettings)), CreativeModeTabs.RAILWAY_FACILITIES);
		PSD_GLASS_END_2 = Registry.registerItem(new Identifier(MTR.MOD_ID, "psd_glass_end_2"), itemSettings -> new Item(new ItemPSDAPGBase(ItemPSDAPGBase.EnumPSDAPGItem.PSD_APG_GLASS_END, ItemPSDAPGBase.EnumPSDAPGType.PSD_2, itemSettings)), CreativeModeTabs.RAILWAY_FACILITIES);

		// Escalators and lifts
		ESCALATOR = Registry.registerItem(new Identifier(MTR.MOD_ID, "escalator"), itemSettings -> new Item(new ItemEscalator(itemSettings)), CreativeModeTabs.ESCALATORS_LIFTS);
		LIFT_BUTTONS_LINK_CONNECTOR = Registry.registerItem(new Identifier(MTR.MOD_ID, "lift_buttons_link_connector"), itemSettings -> new Item(new ItemLiftButtonsLinkModifier(true, itemSettings)), CreativeModeTabs.ESCALATORS_LIFTS);
		LIFT_BUTTONS_LINK_REMOVER = Registry.registerItem(new Identifier(MTR.MOD_ID, "lift_buttons_link_remover"), itemSettings -> new Item(new ItemLiftButtonsLinkModifier(false, itemSettings)), CreativeModeTabs.ESCALATORS_LIFTS);
		LIFT_DOOR_1 = Registry.registerItem(new Identifier(MTR.MOD_ID, "lift_door_1"), itemSettings -> new Item(new ItemPSDAPGBase(ItemPSDAPGBase.EnumPSDAPGItem.PSD_APG_DOOR, ItemPSDAPGBase.EnumPSDAPGType.LIFT_DOOR_1, itemSettings)), CreativeModeTabs.ESCALATORS_LIFTS);
		LIFT_DOOR_ODD_1 = Registry.registerItem(new Identifier(MTR.MOD_ID, "lift_door_odd_1"), itemSettings -> new Item(new ItemPSDAPGBase(ItemPSDAPGBase.EnumPSDAPGItem.PSD_APG_DOOR, ItemPSDAPGBase.EnumPSDAPGType.LIFT_DOOR_ODD_1, itemSettings)), CreativeModeTabs.ESCALATORS_LIFTS);
		LIFT_REFRESHER = Registry.registerItem(new Identifier(MTR.MOD_ID, "lift_refresher"), itemSettings -> new Item(new ItemLiftRefresher(itemSettings)), CreativeModeTabs.ESCALATORS_LIFTS);

		// Rail connectors and remover
		RAIL_CONNECTOR_20 = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_20"), itemSettings -> new Item(new ItemRailModifier(true, false, true, false, RailType.WOODEN, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_20_ONE_WAY = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_20_one_way"), itemSettings -> new Item(new ItemRailModifier(true, false, true, true, RailType.WOODEN, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_40 = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_40"), itemSettings -> new Item(new ItemRailModifier(true, false, true, false, RailType.STONE, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_40_ONE_WAY = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_40_one_way"), itemSettings -> new Item(new ItemRailModifier(true, false, true, true, RailType.STONE, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_60 = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_60"), itemSettings -> new Item(new ItemRailModifier(true, false, true, false, RailType.EMERALD, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_60_ONE_WAY = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_60_one_way"), itemSettings -> new Item(new ItemRailModifier(true, false, true, true, RailType.EMERALD, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_80 = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_80"), itemSettings -> new Item(new ItemRailModifier(true, false, true, false, RailType.IRON, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_80_ONE_WAY = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_80_one_way"), itemSettings -> new Item(new ItemRailModifier(true, false, true, true, RailType.IRON, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_120 = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_120"), itemSettings -> new Item(new ItemRailModifier(true, false, true, false, RailType.OBSIDIAN, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_120_ONE_WAY = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_120_one_way"), itemSettings -> new Item(new ItemRailModifier(true, false, true, true, RailType.OBSIDIAN, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_160 = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_160"), itemSettings -> new Item(new ItemRailModifier(true, false, true, false, RailType.BLAZE, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_160_ONE_WAY = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_160_one_way"), itemSettings -> new Item(new ItemRailModifier(true, false, true, true, RailType.BLAZE, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_200 = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_200"), itemSettings -> new Item(new ItemRailModifier(true, false, true, false, RailType.QUARTZ, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_200_ONE_WAY = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_200_one_way"), itemSettings -> new Item(new ItemRailModifier(true, false, true, true, RailType.QUARTZ, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_300 = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_300"), itemSettings -> new Item(new ItemRailModifier(true, false, true, false, RailType.DIAMOND, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_300_ONE_WAY = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_300_one_way"), itemSettings -> new Item(new ItemRailModifier(true, false, true, true, RailType.DIAMOND, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_PLATFORM = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_platform"), itemSettings -> new Item(new ItemRailModifier(true, true, true, false, RailType.PLATFORM, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_SIDING = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_siding"), itemSettings -> new Item(new ItemRailModifier(true, true, true, false, RailType.SIDING, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_TURN_BACK = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_turn_back"), itemSettings -> new Item(new ItemRailModifier(true, false, true, false, RailType.TURN_BACK, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_CABLE_CAR = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_cable_car"), itemSettings -> new Item(new ItemRailModifier(false, true, false, true, RailType.CABLE_CAR, itemSettings)), CreativeModeTabs.CORE);
		RAIL_CONNECTOR_RUNWAY = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_connector_runway"), itemSettings -> new Item(new ItemRailModifier(false, false, true, true, RailType.RUNWAY, itemSettings)), CreativeModeTabs.CORE);
		RAIL_REMOVER = Registry.registerItem(new Identifier(MTR.MOD_ID, "rail_remover"), itemSettings -> new Item(new ItemRailModifier(itemSettings)), CreativeModeTabs.CORE);

		// Signal connectors
		SIGNAL_CONNECTOR_WHITE = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_connector_white"), itemSettings -> new Item(new ItemSignalModifier(true, DyeColor.WHITE, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_CONNECTOR_ORANGE = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_connector_orange"), itemSettings -> new Item(new ItemSignalModifier(true, DyeColor.ORANGE, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_CONNECTOR_MAGENTA = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_connector_magenta"), itemSettings -> new Item(new ItemSignalModifier(true, DyeColor.MAGENTA, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_CONNECTOR_LIGHT_BLUE = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_connector_light_blue"), itemSettings -> new Item(new ItemSignalModifier(true, DyeColor.LIGHT_BLUE, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_CONNECTOR_YELLOW = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_connector_yellow"), itemSettings -> new Item(new ItemSignalModifier(true, DyeColor.YELLOW, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_CONNECTOR_LIME = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_connector_lime"), itemSettings -> new Item(new ItemSignalModifier(true, DyeColor.LIME, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_CONNECTOR_PINK = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_connector_pink"), itemSettings -> new Item(new ItemSignalModifier(true, DyeColor.PINK, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_CONNECTOR_GRAY = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_connector_gray"), itemSettings -> new Item(new ItemSignalModifier(true, DyeColor.GRAY, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_CONNECTOR_LIGHT_GRAY = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_connector_light_gray"), itemSettings -> new Item(new ItemSignalModifier(true, DyeColor.LIGHT_GRAY, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_CONNECTOR_CYAN = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_connector_cyan"), itemSettings -> new Item(new ItemSignalModifier(true, DyeColor.CYAN, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_CONNECTOR_PURPLE = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_connector_purple"), itemSettings -> new Item(new ItemSignalModifier(true, DyeColor.PURPLE, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_CONNECTOR_BLUE = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_connector_blue"), itemSettings -> new Item(new ItemSignalModifier(true, DyeColor.BLUE, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_CONNECTOR_BROWN = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_connector_brown"), itemSettings -> new Item(new ItemSignalModifier(true, DyeColor.BROWN, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_CONNECTOR_GREEN = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_connector_green"), itemSettings -> new Item(new ItemSignalModifier(true, DyeColor.GREEN, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_CONNECTOR_RED = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_connector_red"), itemSettings -> new Item(new ItemSignalModifier(true, DyeColor.RED, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_CONNECTOR_BLACK = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_connector_black"), itemSettings -> new Item(new ItemSignalModifier(true, DyeColor.BLACK, itemSettings)), CreativeModeTabs.CORE);

		// Signal removers
		SIGNAL_REMOVER_WHITE = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_remover_white"), itemSettings -> new Item(new ItemSignalModifier(false, DyeColor.WHITE, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_REMOVER_ORANGE = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_remover_orange"), itemSettings -> new Item(new ItemSignalModifier(false, DyeColor.ORANGE, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_REMOVER_MAGENTA = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_remover_magenta"), itemSettings -> new Item(new ItemSignalModifier(false, DyeColor.MAGENTA, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_REMOVER_LIGHT_BLUE = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_remover_light_blue"), itemSettings -> new Item(new ItemSignalModifier(false, DyeColor.LIGHT_BLUE, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_REMOVER_YELLOW = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_remover_yellow"), itemSettings -> new Item(new ItemSignalModifier(false, DyeColor.YELLOW, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_REMOVER_LIME = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_remover_lime"), itemSettings -> new Item(new ItemSignalModifier(false, DyeColor.LIME, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_REMOVER_PINK = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_remover_pink"), itemSettings -> new Item(new ItemSignalModifier(false, DyeColor.PINK, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_REMOVER_GRAY = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_remover_gray"), itemSettings -> new Item(new ItemSignalModifier(false, DyeColor.GRAY, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_REMOVER_LIGHT_GRAY = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_remover_light_gray"), itemSettings -> new Item(new ItemSignalModifier(false, DyeColor.LIGHT_GRAY, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_REMOVER_CYAN = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_remover_cyan"), itemSettings -> new Item(new ItemSignalModifier(false, DyeColor.CYAN, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_REMOVER_PURPLE = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_remover_purple"), itemSettings -> new Item(new ItemSignalModifier(false, DyeColor.PURPLE, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_REMOVER_BLUE = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_remover_blue"), itemSettings -> new Item(new ItemSignalModifier(false, DyeColor.BLUE, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_REMOVER_BROWN = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_remover_brown"), itemSettings -> new Item(new ItemSignalModifier(false, DyeColor.BROWN, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_REMOVER_GREEN = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_remover_green"), itemSettings -> new Item(new ItemSignalModifier(false, DyeColor.GREEN, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_REMOVER_RED = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_remover_red"), itemSettings -> new Item(new ItemSignalModifier(false, DyeColor.RED, itemSettings)), CreativeModeTabs.CORE);
		SIGNAL_REMOVER_BLACK = Registry.registerItem(new Identifier(MTR.MOD_ID, "signal_remover_black"), itemSettings -> new Item(new ItemSignalModifier(false, DyeColor.BLACK, itemSettings)), CreativeModeTabs.CORE);

		// Building tools
		BRIDGE_CREATOR_3 = Registry.registerItem(new Identifier(MTR.MOD_ID, "bridge_creator_3"), itemSettings -> new Item(new ItemBridgeCreator(3, itemSettings)), CreativeModeTabs.CORE);
		BRIDGE_CREATOR_5 = Registry.registerItem(new Identifier(MTR.MOD_ID, "bridge_creator_5"), itemSettings -> new Item(new ItemBridgeCreator(5, itemSettings)), CreativeModeTabs.CORE);
		BRIDGE_CREATOR_7 = Registry.registerItem(new Identifier(MTR.MOD_ID, "bridge_creator_7"), itemSettings -> new Item(new ItemBridgeCreator(7, itemSettings)), CreativeModeTabs.CORE);
		BRIDGE_CREATOR_9 = Registry.registerItem(new Identifier(MTR.MOD_ID, "bridge_creator_9"), itemSettings -> new Item(new ItemBridgeCreator(9, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_CREATOR_4_3 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_creator_4_3"), itemSettings -> new Item(new ItemTunnelCreator(4, 3, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_CREATOR_4_5 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_creator_4_5"), itemSettings -> new Item(new ItemTunnelCreator(4, 5, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_CREATOR_4_7 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_creator_4_7"), itemSettings -> new Item(new ItemTunnelCreator(4, 7, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_CREATOR_4_9 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_creator_4_9"), itemSettings -> new Item(new ItemTunnelCreator(4, 9, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_CREATOR_5_3 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_creator_5_3"), itemSettings -> new Item(new ItemTunnelCreator(5, 3, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_CREATOR_5_5 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_creator_5_5"), itemSettings -> new Item(new ItemTunnelCreator(5, 5, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_CREATOR_5_7 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_creator_5_7"), itemSettings -> new Item(new ItemTunnelCreator(5, 7, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_CREATOR_5_9 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_creator_5_9"), itemSettings -> new Item(new ItemTunnelCreator(5, 9, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_CREATOR_6_3 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_creator_6_3"), itemSettings -> new Item(new ItemTunnelCreator(6, 3, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_CREATOR_6_5 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_creator_6_5"), itemSettings -> new Item(new ItemTunnelCreator(6, 5, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_CREATOR_6_7 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_creator_6_7"), itemSettings -> new Item(new ItemTunnelCreator(6, 7, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_CREATOR_6_9 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_creator_6_9"), itemSettings -> new Item(new ItemTunnelCreator(6, 9, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_WALL_CREATOR_4_3 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_wall_creator_4_3"), itemSettings -> new Item(new ItemTunnelWallCreator(4, 3, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_WALL_CREATOR_4_5 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_wall_creator_4_5"), itemSettings -> new Item(new ItemTunnelWallCreator(4, 5, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_WALL_CREATOR_4_7 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_wall_creator_4_7"), itemSettings -> new Item(new ItemTunnelWallCreator(4, 7, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_WALL_CREATOR_4_9 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_wall_creator_4_9"), itemSettings -> new Item(new ItemTunnelWallCreator(4, 9, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_WALL_CREATOR_5_3 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_wall_creator_5_3"), itemSettings -> new Item(new ItemTunnelWallCreator(5, 3, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_WALL_CREATOR_5_5 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_wall_creator_5_5"), itemSettings -> new Item(new ItemTunnelWallCreator(5, 5, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_WALL_CREATOR_5_7 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_wall_creator_5_7"), itemSettings -> new Item(new ItemTunnelWallCreator(5, 7, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_WALL_CREATOR_5_9 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_wall_creator_5_9"), itemSettings -> new Item(new ItemTunnelWallCreator(5, 9, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_WALL_CREATOR_6_3 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_wall_creator_6_3"), itemSettings -> new Item(new ItemTunnelWallCreator(6, 3, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_WALL_CREATOR_6_5 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_wall_creator_6_5"), itemSettings -> new Item(new ItemTunnelWallCreator(6, 5, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_WALL_CREATOR_6_7 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_wall_creator_6_7"), itemSettings -> new Item(new ItemTunnelWallCreator(6, 7, itemSettings)), CreativeModeTabs.CORE);
		TUNNEL_WALL_CREATOR_6_9 = Registry.registerItem(new Identifier(MTR.MOD_ID, "tunnel_wall_creator_6_9"), itemSettings -> new Item(new ItemTunnelWallCreator(6, 9, itemSettings)), CreativeModeTabs.CORE);
	}

	public static final ItemRegistryObject BRUSH;
	public static final ItemRegistryObject AIRPLANE_DASHBOARD;
	public static final ItemRegistryObject APG_DOOR;
	public static final ItemRegistryObject APG_GLASS;
	public static final ItemRegistryObject APG_GLASS_END;
	public static final ItemRegistryObject BOAT_DASHBOARD;
	public static final ItemRegistryObject BOAT_NODE;
	public static final ItemRegistryObject BRIDGE_CREATOR_3;
	public static final ItemRegistryObject BRIDGE_CREATOR_5;
	public static final ItemRegistryObject BRIDGE_CREATOR_7;
	public static final ItemRegistryObject BRIDGE_CREATOR_9;
	public static final ItemRegistryObject CABLE_CAR_DASHBOARD;
	public static final ItemRegistryObject DRIVER_KEY;
	public static final ItemRegistryObject ESCALATOR;
	public static final ItemRegistryObject LIFT_BUTTONS_LINK_CONNECTOR;
	public static final ItemRegistryObject LIFT_BUTTONS_LINK_REMOVER;
	public static final ItemRegistryObject LIFT_DOOR_1;
	public static final ItemRegistryObject LIFT_DOOR_ODD_1;
	public static final ItemRegistryObject LIFT_REFRESHER;
	public static final ItemRegistryObject PSD_DOOR_1;
	public static final ItemRegistryObject PSD_DOOR_2;
	public static final ItemRegistryObject PSD_GLASS_1;
	public static final ItemRegistryObject PSD_GLASS_2;
	public static final ItemRegistryObject PSD_GLASS_END_1;
	public static final ItemRegistryObject PSD_GLASS_END_2;
	public static final ItemRegistryObject RAIL_CONNECTOR_120;
	public static final ItemRegistryObject RAIL_CONNECTOR_120_ONE_WAY;
	public static final ItemRegistryObject RAIL_CONNECTOR_160;
	public static final ItemRegistryObject RAIL_CONNECTOR_160_ONE_WAY;
	public static final ItemRegistryObject RAIL_CONNECTOR_20;
	public static final ItemRegistryObject RAIL_CONNECTOR_20_ONE_WAY;
	public static final ItemRegistryObject RAIL_CONNECTOR_200;
	public static final ItemRegistryObject RAIL_CONNECTOR_200_ONE_WAY;
	public static final ItemRegistryObject RAIL_CONNECTOR_300;
	public static final ItemRegistryObject RAIL_CONNECTOR_300_ONE_WAY;
	public static final ItemRegistryObject RAIL_CONNECTOR_40;
	public static final ItemRegistryObject RAIL_CONNECTOR_40_ONE_WAY;
	public static final ItemRegistryObject RAIL_CONNECTOR_60;
	public static final ItemRegistryObject RAIL_CONNECTOR_60_ONE_WAY;
	public static final ItemRegistryObject RAIL_CONNECTOR_80;
	public static final ItemRegistryObject RAIL_CONNECTOR_80_ONE_WAY;
	public static final ItemRegistryObject RAIL_CONNECTOR_CABLE_CAR;
	public static final ItemRegistryObject RAIL_CONNECTOR_PLATFORM;
	public static final ItemRegistryObject RAIL_CONNECTOR_RUNWAY;
	public static final ItemRegistryObject RAIL_CONNECTOR_SIDING;
	public static final ItemRegistryObject RAIL_CONNECTOR_TURN_BACK;
	public static final ItemRegistryObject RAIL_REMOVER;
	public static final ItemRegistryObject RAILWAY_DASHBOARD;
	public static final ItemRegistryObject RESOURCE_PACK_CREATOR;
	public static final ItemRegistryObject SIGNAL_CONNECTOR_BLACK;
	public static final ItemRegistryObject SIGNAL_CONNECTOR_BLUE;
	public static final ItemRegistryObject SIGNAL_CONNECTOR_BROWN;
	public static final ItemRegistryObject SIGNAL_CONNECTOR_CYAN;
	public static final ItemRegistryObject SIGNAL_CONNECTOR_GRAY;
	public static final ItemRegistryObject SIGNAL_CONNECTOR_GREEN;
	public static final ItemRegistryObject SIGNAL_CONNECTOR_LIGHT_BLUE;
	public static final ItemRegistryObject SIGNAL_CONNECTOR_LIGHT_GRAY;
	public static final ItemRegistryObject SIGNAL_CONNECTOR_LIME;
	public static final ItemRegistryObject SIGNAL_CONNECTOR_MAGENTA;
	public static final ItemRegistryObject SIGNAL_CONNECTOR_ORANGE;
	public static final ItemRegistryObject SIGNAL_CONNECTOR_PINK;
	public static final ItemRegistryObject SIGNAL_CONNECTOR_PURPLE;
	public static final ItemRegistryObject SIGNAL_CONNECTOR_RED;
	public static final ItemRegistryObject SIGNAL_CONNECTOR_WHITE;
	public static final ItemRegistryObject SIGNAL_CONNECTOR_YELLOW;
	public static final ItemRegistryObject SIGNAL_REMOVER_BLACK;
	public static final ItemRegistryObject SIGNAL_REMOVER_BLUE;
	public static final ItemRegistryObject SIGNAL_REMOVER_BROWN;
	public static final ItemRegistryObject SIGNAL_REMOVER_CYAN;
	public static final ItemRegistryObject SIGNAL_REMOVER_GRAY;
	public static final ItemRegistryObject SIGNAL_REMOVER_GREEN;
	public static final ItemRegistryObject SIGNAL_REMOVER_LIGHT_BLUE;
	public static final ItemRegistryObject SIGNAL_REMOVER_LIGHT_GRAY;
	public static final ItemRegistryObject SIGNAL_REMOVER_LIME;
	public static final ItemRegistryObject SIGNAL_REMOVER_MAGENTA;
	public static final ItemRegistryObject SIGNAL_REMOVER_ORANGE;
	public static final ItemRegistryObject SIGNAL_REMOVER_PINK;
	public static final ItemRegistryObject SIGNAL_REMOVER_PURPLE;
	public static final ItemRegistryObject SIGNAL_REMOVER_RED;
	public static final ItemRegistryObject SIGNAL_REMOVER_WHITE;
	public static final ItemRegistryObject SIGNAL_REMOVER_YELLOW;
	public static final ItemRegistryObject TUNNEL_CREATOR_4_3;
	public static final ItemRegistryObject TUNNEL_CREATOR_4_5;
	public static final ItemRegistryObject TUNNEL_CREATOR_4_7;
	public static final ItemRegistryObject TUNNEL_CREATOR_4_9;
	public static final ItemRegistryObject TUNNEL_CREATOR_5_3;
	public static final ItemRegistryObject TUNNEL_CREATOR_5_5;
	public static final ItemRegistryObject TUNNEL_CREATOR_5_7;
	public static final ItemRegistryObject TUNNEL_CREATOR_5_9;
	public static final ItemRegistryObject TUNNEL_CREATOR_6_3;
	public static final ItemRegistryObject TUNNEL_CREATOR_6_5;
	public static final ItemRegistryObject TUNNEL_CREATOR_6_7;
	public static final ItemRegistryObject TUNNEL_CREATOR_6_9;
	public static final ItemRegistryObject TUNNEL_WALL_CREATOR_4_3;
	public static final ItemRegistryObject TUNNEL_WALL_CREATOR_4_5;
	public static final ItemRegistryObject TUNNEL_WALL_CREATOR_4_7;
	public static final ItemRegistryObject TUNNEL_WALL_CREATOR_4_9;
	public static final ItemRegistryObject TUNNEL_WALL_CREATOR_5_3;
	public static final ItemRegistryObject TUNNEL_WALL_CREATOR_5_5;
	public static final ItemRegistryObject TUNNEL_WALL_CREATOR_5_7;
	public static final ItemRegistryObject TUNNEL_WALL_CREATOR_5_9;
	public static final ItemRegistryObject TUNNEL_WALL_CREATOR_6_3;
	public static final ItemRegistryObject TUNNEL_WALL_CREATOR_6_5;
	public static final ItemRegistryObject TUNNEL_WALL_CREATOR_6_7;
	public static final ItemRegistryObject TUNNEL_WALL_CREATOR_6_9;

	public static void init() {
		Init.LOGGER.info("Registering Minecraft Transit Railway items");
	}
}