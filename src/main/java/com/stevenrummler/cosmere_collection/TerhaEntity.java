package com.stevenrummler.cosmere_collection;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;

public class TerhaEntity extends MobEntity {
    protected TerhaEntity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }
}
