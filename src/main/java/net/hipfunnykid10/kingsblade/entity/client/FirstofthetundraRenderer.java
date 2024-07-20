package net.hipfunnykid10.kingsblade.entity.client;

import net.hipfunnykid10.kingsblade.KingsBlade;
import net.hipfunnykid10.kingsblade.entity.custom.FirstOfTheTundraEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class FirstOfTheTundraRenderer extends MobEntityRenderer<FirstOfTheTundraEntity, FirstOfTheTundra<FirstOfTheTundraEntity>> {
    private static final Identifier TEXTURE = new Identifier(KingsBlade.MOD_ID,"textures/entity/firsttundra.png");

    public FirstOfTheTundraRenderer(EntityRendererFactory.Context context) {
        super(context, new FirstOfTheTundra<>(context.getPart(ModModelLayers.FIRST_OF_THE_TUNDRA)),4f);
    }

    @Override
    public Identifier getTexture(FirstOfTheTundraEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(FirstOfTheTundraEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
