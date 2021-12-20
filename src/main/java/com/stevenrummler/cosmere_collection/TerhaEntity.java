package com.stevenrummler.cosmere_collection;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class TerhaEntity extends AnimalEntity {
    private static final int MAX_SAND_TIMER = 40;
    private int eatSandTimer;
    private EatSandGoal eatSandGoal;

    protected TerhaEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initGoals() {
        this.eatSandGoal = new EatSandGoal(this);
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.25D));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0D));
        this.goalSelector.add(3, new TemptGoal(this, 1.1D, Ingredient.ofItems(new ItemConvertible[]{Items.WHEAT}), false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.add(5, this.eatSandGoal);
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
    }

    public void onEatingSand() {
        this.setHealth(this.defaultMaxHealth);
        if (this.isBaby()) {
            this.growUp(60);
        }
    }

    protected void mobTick() {
        this.eatSandTimer = this.eatSandGoal.getTimer();
        super.mobTick();
    }

    public void handleStatus(byte status) {
        if (status == 10) {
            this.eatSandTimer = 40;
        } else {
            super.handleStatus(status);
        }

    }

    public float getNeckAngle(float delta) {
        if (this.eatSandTimer <= 0) {
            return 0.0F;
        } else if (this.eatSandTimer >= 4 && this.eatSandTimer <= 36) {
            return 1.0F;
        } else {
            return this.eatSandTimer < 4 ? ((float)this.eatSandTimer - delta) / 4.0F : -((float)(this.eatSandTimer - 40) - delta) / 4.0F;
        }
    }

    public float getHeadAngle(float delta) {
        if (this.eatSandTimer > 4 && this.eatSandTimer <= 36) {
            float f = ((float)(this.eatSandTimer - 4) - delta) / 32.0F;
            return 0.62831855F + 0.21991149F * MathHelper.sin(f * 28.7F);
        } else {
            return this.eatSandTimer > 0 ? 0.62831855F : this.getPitch() * 0.017453292F;
        }
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_COW_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_COW_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        TerhaEntity sheepEntity = (TerhaEntity)entity;
        TerhaEntity sheepEntity2 = CosmereCollection.TERHA.create(world);
        return sheepEntity2;
    }
}
