package com.tutorialmod.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SlimiumIngot extends Item {

    public SlimiumIngot(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){
        playerEntity.setVelocity(playerEntity.getVelocity().add(0.0, 0.7, 0.0));
        playerEntity.playSound(SoundEvents.ENTITY_SLIME_JUMP, 1.0f, 1.0f);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
