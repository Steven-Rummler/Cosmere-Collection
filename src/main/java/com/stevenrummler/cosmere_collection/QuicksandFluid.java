package com.stevenrummler.cosmere_collection;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class QuicksandFluid extends FlowableFluid {

    @Override
    public Fluid getFlowing() {
        return CosmereCollection.FLOWING_QUICKSAND;
    }

    @Override
    public Fluid getStill() {
        return CosmereCollection.STILL_QUICKSAND;
    }

    @Override
    protected boolean isInfinite() {
        return false;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {

    }

    @Override
    public int getFlowSpeed(WorldView world) {
        return 1;
    }

    @Override
    public int getLevelDecreasePerBlock(WorldView world) {
        return 2;
    }

    @Override
    public int getLevel(FluidState state) {
        CosmereCollection.LOGGER.info("Get level for quicksand called.");
        return 4;
    }

    @Override
    public Item getBucketItem() {
        return CosmereCollection.QUICKSAND_BUCKET;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return false;
    }

    @Override
    public int getTickRate(WorldView world) {
        return 60;
    }

    @Override
    protected float getBlastResistance() {
        return 200;
    }

    @Override
    public BlockState toBlockState(FluidState state) {
        return CosmereCollection.QUICKSAND.getDefaultState();
    }

    @Override
    public boolean isStill(FluidState state) {
        CosmereCollection.LOGGER.info("Is still for quicksand called.");
        return true;
    }

    public static class Flowing extends QuicksandFluid {
        public Flowing() {
        }

        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(new Property[]{LEVEL});
        }

        public int getLevel(FluidState state) {
            return (Integer)state.get(LEVEL);
        }

        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still extends QuicksandFluid {
        public Still() {
        }

        public int getLevel(FluidState state) {
            return 8;
        }

        public boolean isStill(FluidState state) {
            return true;
        }
    }
}
