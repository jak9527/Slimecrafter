package com.slimecrafter.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class Jumpamatron extends Item {
    public Jumpamatron(Settings settings) {
        super(settings);
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
                        multiply(new Vec3d(ratio*-0.7, ratio*-1, ratio*-0.7))));
        playerEntity.playSound(SoundEvents.BLOCK_PISTON_EXTEND, SoundCategory.PLAYERS, 1.0f, 1.0f);
        context.getWorld().playSound(playerEntity, posClicked, SoundEvents.ENTITY_SLIME_JUMP, SoundCategory.PLAYERS, 1.0f, 1.0f);
        playerEntity.getItemCooldownManager().set(this, 20);

        return ActionResult.SUCCESS;
    }

    private double calcDistance(Vec3d pos1, Vec3d pos2){
        return Math.sqrt(Math.pow((pos1.getX() - pos2.getX()), 2)+
                Math.pow((pos1.getY() - pos2.getY()), 2)+
                Math.pow((pos1.getZ() - pos2.getZ()), 2));
    }
}
