package com.stevenrummler.cosmere_collection;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.EnumSet;

public class EatSandGoal extends Goal {
    private final MobEntity mob;
    private final World world;
    private int timer;

    public EatSandGoal(MobEntity mob) {
        this.mob = mob;
        this.world = mob.world;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
    }

    public boolean canStart() {
        if (this.mob.getRandom().nextInt(this.mob.isBaby() ? 50 : 1000) != 0) {
            return false;
        } else {
            BlockPos blockPos = this.mob.getBlockPos();
            return this.world.getBlockState(blockPos.down()).isOf(CosmereCollection.WHITE_SAND_BLOCK);
        }
    }

    public void start() {
        this.timer = this.getTickCount(40);
        this.world.sendEntityStatus(this.mob, (byte)10);
        this.mob.getNavigation().stop();
    }

    public void stop() {
        this.timer = 0;
    }

    public boolean shouldContinue() {
        return this.timer > 0;
    }

    public int getTimer() {
        return this.timer;
    }

    public void tick() {
        this.timer = Math.max(0, this.timer - 1);
        if (this.timer == this.getTickCount(4)) {
            BlockPos blockPos = this.mob.getBlockPos();

            BlockPos blockPos2 = blockPos.down();
            if (this.world.getBlockState(blockPos2).isOf(CosmereCollection.WHITE_SAND_BLOCK)) {
                if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                    this.world.syncWorldEvent(2001, blockPos2, Block.getRawIdFromState(CosmereCollection.WHITE_SAND_BLOCK.getDefaultState()));
                    this.world.setBlockState(blockPos2, CosmereCollection.DARK_SAND_BLOCK.getDefaultState());
                }

                ((TerhaEntity) this.mob).onEatingSand();
                this.mob.emitGameEvent(GameEvent.EAT, this.mob.getCameraBlockPos());
            }


        }
    }
}
