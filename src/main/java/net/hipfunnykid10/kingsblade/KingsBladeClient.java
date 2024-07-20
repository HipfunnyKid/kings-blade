package net.hipfunnykid10.kingsblade;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.hipfunnykid10.kingsblade.entity.ModEntities;
import net.hipfunnykid10.kingsblade.entity.client.FirstOfTheTundra;
import net.hipfunnykid10.kingsblade.entity.client.FirstOfTheTundraRenderer;
import net.hipfunnykid10.kingsblade.entity.client.ModModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class KingsBladeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(){
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.FIRST_OF_THE_TUNDRA, FirstOfTheTundra::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.FIRST_OF_THE_TUNDRA, FirstOfTheTundraRenderer::new);
    }
}
