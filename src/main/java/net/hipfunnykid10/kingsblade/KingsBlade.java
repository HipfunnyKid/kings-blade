package net.hipfunnykid10.kingsblade;

import net.fabricmc.api.ModInitializer;

import net.hipfunnykid10.kingsblade.block.ModBlocks;
import net.hipfunnykid10.kingsblade.item.ModItemGroups;
import net.hipfunnykid10.kingsblade.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KingsBlade implements ModInitializer {
	public static final String MOD_ID = "kingsblade";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItems.registerModRecipes();
	}
}