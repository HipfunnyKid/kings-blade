package net.hipfunnykid10.kingsblade.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hipfunnykid10.kingsblade.KingsBlade;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block CHARRED_BRICKS = registerBlock("charred_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_BRICKS)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(KingsBlade.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
       return Registry.register(Registries.ITEM, new Identifier(KingsBlade.MOD_ID, name),
               new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        KingsBlade.LOGGER.info("Registering ModBlocks for " +KingsBlade.MOD_ID);
    }
}
