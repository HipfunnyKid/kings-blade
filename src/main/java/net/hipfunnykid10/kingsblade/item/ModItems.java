package net.hipfunnykid10.kingsblade.item;

import net.hipfunnykid10.kingsblade.KingsBlade;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(KingsBlade.MOD_ID, name), item);
    }
    public static void registerModItems() {
        KingsBlade.LOGGER.info("Registering Mod Items for " + KingsBlade.MOD_ID);
    }
}
