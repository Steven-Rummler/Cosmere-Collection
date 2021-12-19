package com.stevenrummler.cosmere_collection;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class TerhaEntityRenderer extends MobEntityRenderer<TerhaEntity,TerhaEntityModel> {
    public TerhaEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new TerhaEntityModel(context.getPart(CosmereCollectionClient.MODEL_TERHA_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(TerhaEntity entity) {
        return new Identifier("cosmere_collection","textures/entity/terha/terha.png");
    }
}
