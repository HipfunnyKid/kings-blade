package net.hipfunnykid10.kingsblade;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.hipfunnykid10.kingsblade.block.ModBlocks;
import net.hipfunnykid10.kingsblade.entity.ModEntities;
import net.hipfunnykid10.kingsblade.entity.custom.FirstOfTheTundraEntity;
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
		ModEntities.registerModEntities();
		FabricDefaultAttributeRegistry.register(ModEntities.FIRST_OF_THE_TUNDRA, FirstOfTheTundraEntity.createFirstOfTheTundraAttributes());
	}

}