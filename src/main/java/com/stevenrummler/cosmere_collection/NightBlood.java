package com.stevenrummler.cosmere_collection;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class NightBlood extends SwordItem {
    public NightBlood(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

//    @Override
//    public boolean hasGlint(ItemStack stack) {
//        return true;
//    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (world.getTime() % 20 == 0 && entity.isPlayer() && selected) {
            PlayerEntity player = (PlayerEntity) entity;
            if (player.experienceLevel == 0 && player.experienceProgress == 0) {
                player.damage(DamageSource.DROWN, .5f);
            } else {
                player.addExperience(-1);
            }
        }
    }
}
