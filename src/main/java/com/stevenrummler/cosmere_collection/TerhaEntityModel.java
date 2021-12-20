package com.stevenrummler.cosmere_collection;

import net.fabricmc.fabric.mixin.client.rendering.EntityModelLayersAccessor;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;
import net.minecraft.client.render.model.json.ModelRotation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class TerhaEntityModel extends EntityModel<TerhaEntity> {
    private final ModelPart head;
    private final ModelPart tail;
    private final ModelPart body;
    private final ModelPart bb_main;

    public TerhaEntityModel(ModelPart root) {
        this.head = root.getChild("head");
        this.tail = root.getChild("tail");
        this.body = root.getChild("body");
        this.bb_main = root.getChild("bb_main");
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {

        head.render(matrices, vertices, light, overlay);
        tail.render(matrices, vertices, light, overlay);
        body.render(matrices, vertices, light, overlay);
        bb_main.render(matrices, vertices, light, overlay);
    }

    @Override
    public void setAngles(TerhaEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.head.pivotY = 6.0F + entity.getNeckAngle(headPitch) * 9.0F;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData ModelData = new ModelData();
        ModelPartData ModelPartData = ModelData.getRoot();

        ModelPartData head = ModelPartData.addChild("head", ModelPartBuilder.create(), ModelTransform.of(0.0F, 11.0F, -16.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData righttusk_r1 = head.addChild("righttusk_r1", ModelPartBuilder.create().uv(0, 0).cuboid(3.0F, -23.4397F, -16.3125F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-5.0F, -23.4397F, -16.3125F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-6.0F, -19.4397F, -10.3125F, 12.0F, 1.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.57F, 14.3256F, 0.7854F, 0.0F, 0.0F));

        ModelPartData head_r1 = head.addChild("head_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -19.0F, -17.25F, 8.0F, 6.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.5F, 14.25F, 0.7854F, 0.0F, 0.0F));

        ModelPartData tail = ModelPartData.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 14.0F, 18.0F));

        ModelPartData tail_r1 = tail.addChild("tail_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -5.4778F, 19.2765F, 3.0F, 3.0F, 27.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.57F, -19.6744F, -0.1745F, 0.0F, 0.0F));

        ModelPartData tailclub_r1 = tail.addChild("tailclub_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-35.5129F, -5.1843F, 29.8655F, 5.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.57F, -19.6744F, -0.2182F, 0.7854F, -0.1309F));

        ModelPartData body = ModelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-7.0F, -6.0F, 1.0F, 14.0F, 12.0F, 18.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-6.5F, -5.5F, -19.0F, 13.0F, 11.0F, 17.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-5.5F, -4.5F, -2.0F, 11.0F, 9.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 11.5F, 0.0F));

        ModelPartData bb_main = ModelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(1.0F, -8.0F, 6.0F, 5.0F, 8.0F, 10.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-6.0F, -8.0F, 6.0F, 5.0F, 8.0F, 10.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(1.0F, -8.0F, -16.0F, 5.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-6.0F, -8.0F, -16.0F, 5.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        return TexturedModelData.of(ModelData, 16, 16);
        
//        ModelData modelData = new ModelData();
//        ModelPartData root = modelData.getRoot();
//
//        ModelPartData head = root.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 9.0F, 21.0F));
//
//        ModelPartData righttusk_r1 = head.addChild("righttusk_r1", ModelPartBuilder.create().uv(0, 0).cuboid(3.0F, -7.25F, 6.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F))
//                .uv(0, 0).cuboid(-5.0F, -7.25F, 6.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F))
//                .uv(0, 0).cuboid(-6.0F, -3.25F, -7.0F, 12.0F, 1.0F, 9.0F, new Dilation(0.0F))
//                .uv(0, 0).cuboid(-4.0F, -3.0F, 0.0F, 8.0F, 6.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
//
//        ModelPartData tail = root.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 14.0F, -16.0F));
//
//        ModelPartData tail_r1 = tail.addChild("tail_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -1.5F, -27.0F, 3.0F, 3.0F, 27.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));
//
//        ModelPartData tailclub_r1 = tail.addChild("tailclub_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, -2.0F, -2.5F, 5.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.5F, -26.5F, 0.2182F, -0.7854F, -0.1309F));
//
//        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-7.0F, -6.0F, -19.3333F, 14.0F, 12.0F, 18.0F, new Dilation(0.0F))
//                .uv(0, 0).cuboid(-6.5F, -5.5F, 1.6667F, 13.0F, 11.0F, 17.0F, new Dilation(0.0F))
//                .uv(0, 0).cuboid(-5.5F, -4.5F, -1.3333F, 11.0F, 9.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 11.5F, 2.3333F));
//
//        ModelPartData bb_main = root.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(1.0F, -8.0F, -14.0F, 5.0F, 8.0F, 10.0F, new Dilation(0.0F))
//                .uv(0, 0).cuboid(-6.0F, -8.0F, -14.0F, 5.0F, 8.0F, 10.0F, new Dilation(0.0F))
//                .uv(0, 0).cuboid(1.0F, -8.0F, 10.0F, 5.0F, 8.0F, 8.0F, new Dilation(0.0F))
//                .uv(0, 0).cuboid(-6.0F, -8.0F, 10.0F, 5.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
//
//        return TexturedModelData.of(modelData, 16, 16);
    }
}
