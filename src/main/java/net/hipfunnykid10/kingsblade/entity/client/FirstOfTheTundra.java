
package net.hipfunnykid10.kingsblade.entity.client;

import net.hipfunnykid10.kingsblade.entity.animation.ModAnimations;
import net.hipfunnykid10.kingsblade.entity.custom.FirstOfTheTundraEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class FirstOfTheTundra<T extends FirstOfTheTundraEntity> extends SinglePartEntityModel<T> {
	private final ModelPart firstofthetundra;
	private final ModelPart Head;
	public FirstOfTheTundra(ModelPart root) {
		this.firstofthetundra = root.getChild("firstofthetundra");
		this.Head = firstofthetundra.getChild("Body").getChild("Head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData firstofthetundra = modelPartData.addChild("firstofthetundra", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Body = firstofthetundra.addChild("Body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -32.0F, -2.75F));

		ModelPartData Belly_r1 = Body.addChild("Belly_r1", ModelPartBuilder.create().uv(106, 73).cuboid(-12.0F, -5.0F, -8.5F, 24.0F, 10.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 10.0F, -0.75F, 0.0F, 0.0F, 0.0F));

		ModelPartData Torso_r1 = Body.addChild("Torso_r1", ModelPartBuilder.create().uv(0, 73).cuboid(-19.0F, -15.0F, -15.0F, 38.0F, 30.0F, 30.0F, new Dilation(-0.003F)), ModelTransform.of(0.0F, -10.0F, 0.75F, 0.0F, 0.0F, 0.0F));

		ModelPartData BackSnow = Body.addChild("BackSnow", ModelPartBuilder.create().uv(1, 75).cuboid(-9.8824F, -19.3031F, -18.8827F, 0.0F, 20.0F, 7.0F, new Dilation(0.0F))
		.uv(1, 75).cuboid(9.1176F, -20.3031F, -4.8827F, 0.0F, 20.0F, 7.0F, new Dilation(0.0F))
		.uv(1, 75).cuboid(-14.8824F, -16.3031F, -0.8827F, 0.0F, 20.0F, 7.0F, new Dilation(0.0F))
		.uv(1, 75).cuboid(-3.8824F, -18.3031F, -0.8827F, 0.0F, 20.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.1176F, -21.6969F, 15.6327F));

		ModelPartData Icecicle_r1 = BackSnow.addChild("Icecicle_r1", ModelPartBuilder.create().uv(1, 75).cuboid(-12.0F, -5.0F, -13.5F, 0.0F, 20.0F, 7.0F, new Dilation(0.0F))
		.uv(1, 75).cuboid(0.0F, -7.0F, -3.5F, 0.0F, 20.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(2.1176F, -11.3031F, -23.3827F, 0.0F, 3.1416F, 0.0F));

		ModelPartData Icecicle_r2 = BackSnow.addChild("Icecicle_r2", ModelPartBuilder.create().uv(1, 75).cuboid(2.0F, -13.0F, 5.5F, 0.0F, 20.0F, 7.0F, new Dilation(0.0F))
		.uv(1, 75).cuboid(7.0F, -12.0F, 16.5F, 0.0F, 20.0F, 7.0F, new Dilation(0.0F))
		.uv(1, 75).cuboid(15.0F, -13.0F, 26.5F, 0.0F, 20.0F, 7.0F, new Dilation(0.0F))
		.uv(1, 75).cuboid(22.0F, -12.0F, 16.5F, 0.0F, 20.0F, 7.0F, new Dilation(0.0F))
		.uv(1, 75).cuboid(2.0F, -13.0F, 30.5F, 0.0F, 20.0F, 7.0F, new Dilation(0.0F))
		.uv(1, 75).cuboid(29.0F, -11.0F, 23.5F, 0.0F, 20.0F, 7.0F, new Dilation(0.0F))
		.uv(1, 75).cuboid(14.0F, -13.0F, 9.5F, 0.0F, 20.0F, 7.0F, new Dilation(0.0F))
		.uv(1, 75).cuboid(29.0F, -11.0F, 10.5F, 0.0F, 20.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-14.8824F, -13.3031F, 2.6173F, -1.5708F, 0.0F, 0.0F));

		ModelPartData Icecicle_r3 = BackSnow.addChild("Icecicle_r3", ModelPartBuilder.create().uv(15, 75).cuboid(7.0F, -10.0F, -3.5F, 0.0F, 20.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(4.1176F, -10.3031F, 10.6173F, -0.846F, 0.0F, 0.0F));

		ModelPartData Icecicle_r4 = BackSnow.addChild("Icecicle_r4", ModelPartBuilder.create().uv(15, 75).cuboid(1.0F, -8.0F, -3.5F, 0.0F, 20.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-9.8824F, -8.9771F, 9.12F, -0.846F, 0.0F, 0.0F));

		ModelPartData SnowVolume_r1 = BackSnow.addChild("SnowVolume_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-17.0F, -20.0F, -11.5F, 34.0F, 35.0F, 38.0F, new Dilation(0.0F)), ModelTransform.of(0.1176F, 8.6969F, -16.3827F, 0.0F, 0.0F, 0.0F));

		ModelPartData Head = Body.addChild("Head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -11.0F, -13.25F));

		ModelPartData Head_r1 = Head.addChild("Head_r1", ModelPartBuilder.create().uv(171, 67).cuboid(-7.0F, -5.0F, -5.0F, 14.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, -6.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData Mouth = Head.addChild("Mouth", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, 1.0F));

		ModelPartData Mouth_r1 = Mouth.addChild("Mouth_r1", ModelPartBuilder.create().uv(184, 130).cuboid(-7.0F, -10.0F, -5.0F, 14.0F, 14.0F, 10.0F, new Dilation(0.002F)), ModelTransform.of(0.0F, 5.0F, -7.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData ClosedEyes = Head.addChild("ClosedEyes", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -0.5F, -10.0F));

		ModelPartData ClosedEyes_r1 = ClosedEyes.addChild("ClosedEyes_r1", ModelPartBuilder.create().uv(154, 67).cuboid(-6.0F, 1.0F, -5.0F, 12.0F, 3.0F, 0.0F, new Dilation(0.002F)), ModelTransform.of(0.0F, -2.5F, 5.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData BallOfPAIN = Body.addChild("BallOfPAIN", ModelPartBuilder.create(), ModelTransform.pivot(-1.5909F, -11.5414F, 12.2481F));

		ModelPartData BallSpike_r1 = BallOfPAIN.addChild("BallSpike_r1", ModelPartBuilder.create().uv(6, 80).cuboid(0.0F, -8.5F, 0.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.4091F, -3.9547F, 0.3274F, -3.098F, 0.0F, 0.0F));

		ModelPartData BallSpike_r2 = BallOfPAIN.addChild("BallSpike_r2", ModelPartBuilder.create().uv(6, 80).cuboid(0.0F, -5.5F, -1.0F, 0.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.4091F, 0.0414F, 0.5019F, 0.0436F, 0.0F, 0.0F));

		ModelPartData BallSpike_r3 = BallOfPAIN.addChild("BallSpike_r3", ModelPartBuilder.create().uv(6, 80).cuboid(1.5F, -5.0F, -1.0F, 0.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(6, 80).cuboid(-1.5F, -5.0F, -1.0F, 0.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0909F, 0.0414F, 0.0019F, 0.0F, -1.5708F, 1.5708F));

		ModelPartData BallSpike_r4 = BallOfPAIN.addChild("BallSpike_r4", ModelPartBuilder.create().uv(6, 80).cuboid(-1.5F, -5.0F, -1.0F, 0.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(6, 80).cuboid(1.5F, -5.0F, -1.0F, 0.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0909F, 0.0414F, 0.0019F, 0.0F, -1.5708F, -1.5708F));

		ModelPartData BallSpike_r5 = BallOfPAIN.addChild("BallSpike_r5", ModelPartBuilder.create().uv(6, 80).cuboid(-1.5F, -6.0F, -1.0F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F))
		.uv(6, 80).cuboid(1.5F, -6.0F, -1.0F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0909F, 0.0414F, 0.0019F, 1.5708F, 0.0F, 0.0F));

		ModelPartData BallSpike_r6 = BallOfPAIN.addChild("BallSpike_r6", ModelPartBuilder.create().uv(6, 80).cuboid(-1.5F, -6.0F, -1.0F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F))
		.uv(6, 80).cuboid(1.5F, -6.0F, -1.0F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0909F, 0.0414F, 0.0019F, -1.5708F, 0.0F, 0.0F));

		ModelPartData Snowball_r1 = BallOfPAIN.addChild("Snowball_r1", ModelPartBuilder.create().uv(33, 33).cuboid(-17.0F, -27.0F, 4.5F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(14.5909F, 24.5414F, -6.9981F, 0.0F, 0.0F, 0.0F));

		ModelPartData RightStick = Body.addChild("RightStick", ModelPartBuilder.create(), ModelTransform.pivot(-11.1075F, -19.6109F, -8.1646F));

		ModelPartData RightStick_r1 = RightStick.addChild("RightStick_r1", ModelPartBuilder.create().uv(116, -29).cuboid(-0.7855F, -31.4406F, -3.4646F, 0.0F, 38.0F, 29.0F, new Dilation(0.0F)), ModelTransform.of(-3.476F, -1.3261F, 0.6792F, 0.5204F, 0.5296F, -0.3444F));

		ModelPartData LeftStick = Body.addChild("LeftStick", ModelPartBuilder.create(), ModelTransform.pivot(13.6134F, -19.4729F, -5.215F));

		ModelPartData LeftStick_r1 = LeftStick.addChild("LeftStick_r1", ModelPartBuilder.create().uv(116, -29).mirrored().cuboid(0.0F, -34.0F, -4.5F, 0.0F, 38.0F, 29.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.5204F, -0.5296F, 0.3444F));

		ModelPartData LeftLeg = firstofthetundra.addChild("LeftLeg", ModelPartBuilder.create().uv(170, 100).cuboid(-6.0F, 0.0381F, -3.8716F, 10.0F, 20.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(10.0F, -20.0381F, -5.1284F));

		ModelPartData RightLeg = firstofthetundra.addChild("RightLeg", ModelPartBuilder.create().uv(180, 34).cuboid(-4.5774F, -0.9591F, -0.2796F, 10.0F, 20.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(-9.3968F, -19.5124F, -8.8883F));

		ModelPartData LeftShoulder = firstofthetundra.addChild("LeftShoulder", ModelPartBuilder.create().uv(118, 164).cuboid(-2.0F, -5.0F, -5.0F, 12.0F, 30.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(21.0F, -50.0F, -2.0F));

		ModelPartData LeftArm = LeftShoulder.addChild("LeftArm", ModelPartBuilder.create().uv(0, 133).cuboid(-16.5614F, -7.409F, -9.0425F, 17.0F, 31.0F, 14.0F, new Dilation(0.0F))
		.uv(0, 178).mirrored().cuboid(-2.5534F, -26.986F, -2.1273F, 16.0F, 42.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(12.7874F, 26.385F, 2.1904F));

		ModelPartData LFurtherFinger = LeftArm.addChild("LFurtherFinger", ModelPartBuilder.create(), ModelTransform.pivot(-1.0989F, 22.0638F, 1.8619F));

		ModelPartData LFurtherClaw_r1 = LFurtherFinger.addChild("LFurtherClaw_r1", ModelPartBuilder.create().uv(0, 58).mirrored().cuboid(1.1379F, -5.573F, -16.0705F, 0.0F, 8.0F, 15.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.1737F, -0.4604F, -1.3179F, 2.9671F, -1.5345F, -2.9215F));

		ModelPartData LFurtherFinger_r1 = LFurtherFinger.addChild("LFurtherFinger_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-2.443F, -2.573F, -8.0705F, 5.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(1.1737F, -0.4604F, -0.3179F, 2.9671F, -1.5345F, -2.9215F));

		ModelPartData LCloserFinger = LeftArm.addChild("LCloserFinger", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5404F, -3.75F, -8.418F, 5.0F, 5.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 58).mirrored().cuboid(0.0404F, -6.75F, -15.082F, 0.0F, 8.0F, 15.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-11.8278F, 22.7804F, -7.1084F));

		ModelPartData LMiddleFinger = LeftArm.addChild("LMiddleFinger", ModelPartBuilder.create(), ModelTransform.pivot(0.0673F, 21.7804F, -8.6889F));

		ModelPartData LMiddleClaw_r1 = LMiddleFinger.addChild("LMiddleClaw_r1", ModelPartBuilder.create().uv(0, 58).mirrored().cuboid(0.9379F, -5.573F, -15.7344F, 0.0F, 8.0F, 15.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.9925F, -0.177F, 1.2329F, 0.0F, -0.7345F, 0.0F));

		ModelPartData LMiddleFinger_r1 = LMiddleFinger.addChild("LMiddleFinger_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-2.443F, -2.573F, -8.0705F, 5.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0075F, -0.177F, 1.2329F, 0.0F, -0.7345F, 0.0F));

		ModelPartData RightShoulder = firstofthetundra.addChild("RightShoulder", ModelPartBuilder.create().uv(162, 164).cuboid(-12.5F, -5.0F, -5.0F, 12.0F, 30.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(-18.5F, -50.0F, -2.0F));

		ModelPartData RightArm = RightShoulder.addChild("RightArm", ModelPartBuilder.create().uv(122, 119).cuboid(-9.4568F, -3.5551F, -6.1119F, 17.0F, 31.0F, 14.0F, new Dilation(0.0F))
		.uv(0, 178).cuboid(-23.0432F, -22.9449F, -0.8881F, 16.0F, 42.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.2691F, 22.5311F, -0.7402F));

		ModelPartData RCloserFinger = RightArm.addChild("RCloserFinger", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0016F, -3.6654F, -9.4063F, 5.0F, 5.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 58).cuboid(0.4175F, -6.6654F, -16.0702F, 0.0F, 8.0F, 15.0F, new Dilation(0.0F)), ModelTransform.pivot(1.3517F, 25.5498F, -5.1896F));

		ModelPartData RMiddleFinger = RightArm.addChild("RMiddleFinger", ModelPartBuilder.create(), ModelTransform.pivot(-8.0128F, 24.771F, -3.8863F));

		ModelPartData RMiddleClaw_r1 = RMiddleFinger.addChild("RMiddleClaw_r1", ModelPartBuilder.create().uv(0, 58).cuboid(-0.6379F, -5.573F, -15.7344F, 0.0F, 8.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(0.9198F, -0.3136F, -0.6391F, 0.0F, 0.9599F, 0.0F));

		ModelPartData RMiddleFinger_r1 = RMiddleFinger.addChild("RMiddleFinger_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-2.557F, -2.573F, -8.0705F, 5.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-0.0802F, -0.3136F, -0.6391F, 0.0F, 0.9599F, 0.0F));

		ModelPartData RFurtherFinger = RightArm.addChild("RFurtherFinger", ModelPartBuilder.create(), ModelTransform.pivot(-7.9337F, 24.1825F, 5.0706F));

		ModelPartData RFurtherClaw_r1 = RFurtherFinger.addChild("RFurtherClaw_r1", ModelPartBuilder.create().uv(0, 58).cuboid(-0.1379F, -5.573F, -16.0705F, 0.0F, 8.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(-0.1593F, 0.2748F, -0.596F, 2.9671F, 1.491F, 2.9941F));

		ModelPartData RFurtherFinger_r1 = RFurtherFinger.addChild("RFurtherFinger_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-2.557F, -2.573F, -8.0705F, 5.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-1.1593F, 0.2748F, -0.596F, 2.9671F, 1.491F, 2.9941F));
		return TexturedModelData.of(modelData, 256, 256);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		firstofthetundra.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return firstofthetundra;
	}

	@Override
	public void setAngles(FirstOfTheTundraEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.AWAKE, limbSwing, limbSwingAmount, 2f,2.5f);
		this.updateAnimation(entity.awakenAnimationState, ModAnimations.AWAKE, ageInTicks, 0.2f);
	}

	private void setHeadAngles(float headYaw,float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 25.0F);

		this.Head.yaw = headYaw * 0.017453292F;
		this.Head.pitch = headPitch * 0.017453292F;
	}
}