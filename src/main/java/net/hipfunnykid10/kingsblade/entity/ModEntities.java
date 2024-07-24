package net.hipfunnykid10.kingsblade.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.hipfunnykid10.kingsblade.KingsBlade;
import net.hipfunnykid10.kingsblade.entity.custom.FirstOfTheTundraEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static void registerModEntities() {
        KingsBlade.LOGGER.info("Registering Mod Entities for " + KingsBlade.MOD_ID);
    }
    public static final EntityType<FirstOfTheTundraEntity> FIRST_OF_THE_TUNDRA = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(KingsBlade.MOD_ID, "first_of_the_tundra"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, FirstOfTheTundraEntity::new).dimensions(
                    EntityDimensions.fixed(4f,4f)).build());
}
