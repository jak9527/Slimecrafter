package com.slimecrafter.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class SlimiumIngot extends Item {

    public SlimiumIngot(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos posClicked = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        assert playerEntity != null;
        if(posClicked.getY() < playerEntity.getY()){
            playerEntity.setVelocity(playerEntity.getVelocity().add(playerEntity.getRotationVec(0).multiply(new Vec3d(-0.5, -0.7, -0.5))));
            playerEntity.playSound(SoundEvents.ENTITY_SLIME_JUMP, 1.0f, 1.0f);
            playerEntity.getItemCooldownManager().set(this, 20);
        }

        if(!context.getWorld().isClient){


        }

        return ActionResult.SUCCESS;
    }

//    @Override
//    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){
//
//        return TypedActionResult.success(playerEntity.getStackInHand(hand));
//    }
}
