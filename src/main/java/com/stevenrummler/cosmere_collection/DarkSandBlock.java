package com.stevenrummler.cosmere_collection;

import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;

import java.util.Random;

public class DarkSandBlock extends FallingBlock {
    public DarkSandBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getLightLevel(LightType.SKY,pos.up()) == 15 && world.getRegistryKey().toString().contains("cosmere_collection:taldain_dayside")) {
            world.setBlockState(pos, CosmereCollection.WHITE_SAND_BLOCK.getDefaultState());
        }
    }
}
