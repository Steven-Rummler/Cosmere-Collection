package com.stevenrummler.cosmere_collection;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.FluidTags;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;

import java.util.Random;

public class WhiteSandBlock extends FallingBlock {
    public WhiteSandBlock(Settings settings) {
        super(settings);
    }
}
