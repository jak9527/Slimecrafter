package com.slimecrafter.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class Jumpamatron extends Item {
    public Jumpamatron(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        double ratio = 2/calcDistance(user.getPos(), entity.getPos());
        ratio = Math.min(ratio, 1);
        entity.setVelocity(entity.getVelocity()
                .add(user.getRotationVec(0)
                        .multiply(new Vec3d(ratio*-1.2, ratio*-1, ratio*-1.2))));
        user.playSound(SoundEvents.BLOCK_PISTON_EXTEND, SoundCategory.PLAYERS, 1.0f, 1.0f);
        entity.playSound(SoundEvents.ENTITY_SLIME_JUMP, 1.0f, 1.0f);
        user.getItemCooldownManager().set(this, 20);

        stack.damage(1, user,
                playerEntity1 -> playerEntity1.sendToolBreakStatus(playerEntity1.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos posClicked = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        assert playerEntity != null;
        double ratio = 2/calcDistance(playerEntity.getPos(), new Vec3d(posClicked.getX(), posClicked.getY(), posClicked.getZ()));
        ratio = Math.min(ratio, 1);
        playerEntity.setVelocity(playerEntity.getVelocity().
                add(playerEntity.getRotationVec(0).
                        multiply(new Vec3d(ratio*-1.2, ratio*-1, ratio*-1.2))));
        playerEntity.playSound(SoundEvents.BLOCK_PISTON_EXTEND, SoundCategory.PLAYERS, 1.0f, 1.0f);
        context.getWorld().playSound(playerEntity, posClicked, SoundEvents.ENTITY_SLIME_JUMP, SoundCategory.PLAYERS, 1.0f, 1.0f);
        playerEntity.getItemCooldownManager().set(this, 20);

        context.getStack().damage(1, context.getPlayer(),
                playerEntity1 -> playerEntity1.sendToolBreakStatus(playerEntity1.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    private double calcDistance(Vec3d pos1, Vec3d pos2){
        return Math.sqrt(Math.pow((pos1.getX() - pos2.getX()), 2)+
                Math.pow((pos1.getY() - pos2.getY()), 2)+
                Math.pow((pos1.getZ() - pos2.getZ()), 2));
    }
}
