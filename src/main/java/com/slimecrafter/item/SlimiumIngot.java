package com.slimecrafter.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class SlimiumIngot extends Item {

    public SlimiumIngot(Settings settings) {
        super(settings);
    }



//    @Override
//    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){
//
//        return TypedActionResult.success(playerEntity.getStackInHand(hand));
//    }
}
