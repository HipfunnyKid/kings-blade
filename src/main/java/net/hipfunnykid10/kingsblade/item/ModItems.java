package net.hipfunnykid10.kingsblade.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hipfunnykid10.kingsblade.KingsBlade;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item FIRECRY = registerItem("firecry", new Item(new FabricItemSettings()));
    public static final Item EARTHCRY = registerItem("earthcry", new Item(new FabricItemSettings()));
    public static final Item WATERCRY = registerItem("watercry", new Item(new FabricItemSettings()));
    public static final Item GUILDNETHERING = registerItem("guildednetheriteingot", new Item(new FabricItemSettings()));
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {

    }


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(KingsBlade.MOD_ID, name), item);
    }
    public static void registerModItems() {
        KingsBlade.LOGGER.info("Registering Mod Items for " + KingsBlade.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
