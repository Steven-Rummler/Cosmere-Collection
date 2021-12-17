package com.stevenrummler.cosmere_collection;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class InkedStamp extends Item {
    public InkedStamp(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        String type = this.toString().substring(0, this.toString().length() - 12);
//        user.sendMessage(new LiteralText("Type: "+type), false);
//        user.sendMessage(new LiteralText("Hand: "+hand.name()+" - "+hand), false);
        user.getStackInHand(hand).decrement(1);

        ItemStack stamp = new ItemStack(CosmereCollection.EXPLORER_STAMP);
        if (type == "fighter") stamp = new ItemStack(CosmereCollection.FIGHTER_STAMP);
        else if (type == "miner") stamp = new ItemStack(CosmereCollection.MINER_STAMP);
        user.giveItemStack(stamp);
        switch (type) {
            case "explorer":
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 6000, 2));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 6000, 2));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 6000, 1));
                break;
            case "fighter":
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 6000, 2));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 6000, 2));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 6000, 1));
                break;
            case "miner":
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 6000, 2));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 2));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 6000, 1));
                break;
        }
        return super.use(world, user, hand);
    }
}
