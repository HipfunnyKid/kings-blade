package net.hipfunnykid10.kingsblade.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hipfunnykid10.kingsblade.KingsBlade;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.hipfunnykid10.kingsblade.item.ModItems.*;

public class ModItemGroups {
    public static final ItemGroup KINGSBLADE_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(KingsBlade.MOD_ID, "blade"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.blade")).icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
        entries.add(RUBY);
        entries.add(FIRECRY);
        entries.add(EARTHCRY);
        entries.add(WATERCRY);
        entries.add(GUILDNETHERING);
    }).build());
    public static void registerItemGroups() {
        KingsBlade.LOGGER.info("Registering Item Groups for " +KingsBlade.MOD_ID);
    }
}
