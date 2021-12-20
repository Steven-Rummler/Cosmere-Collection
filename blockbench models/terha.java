// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class custom_model<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "custom_model"), "main");
	private final ModelPart head;
	private final ModelPart tail;
	private final ModelPart body;
	private final ModelPart bb_main;

	public custom_model(ModelPart root) {
		this.head = root.getChild("head");
		this.tail = root.getChild("tail");
		this.body = root.getChild("body");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 11.0F, -16.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition righttusk_r1 = head.addOrReplaceChild("righttusk_r1", CubeListBuilder.create().texOffs(0, 0).addBox(3.0F, -23.4397F, -16.3125F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.0F, -23.4397F, -16.3125F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -19.4397F, -10.3125F, 12.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.57F, 14.3256F, 0.7854F, 0.0F, 0.0F));

		PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -19.0F, -17.25F, 8.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.5F, 14.25F, 0.7854F, 0.0F, 0.0F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 14.0F, 18.0F));

		PartDefinition tail_r1 = tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -5.4778F, 19.2765F, 3.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.57F, -19.6744F, -0.1745F, 0.0F, 0.0F));

		PartDefinition tailclub_r1 = tail.addOrReplaceChild("tailclub_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-35.5129F, -5.1843F, 29.8655F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.57F, -19.6744F, -0.2182F, 0.7854F, -0.1309F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -6.0F, 1.0F, 14.0F, 12.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.5F, -5.5F, -19.0F, 13.0F, 11.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.5F, -4.5F, -2.0F, 11.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.5F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, -8.0F, 6.0F, 5.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -8.0F, 6.0F, 5.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(1.0F, -8.0F, -16.0F, 5.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -8.0F, -16.0F, 5.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, buffer, packedLight, packedOverlay);
		tail.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}
}