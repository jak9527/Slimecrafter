package com.slimecrafter.item.custom;

import com.slimecrafter.item.ModArmorMaterials;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ModArmorItem extends ArmorItem {
    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    private double bounceVel = 0;

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected){
//        if(!world.isClient()){
            if(entity instanceof PlayerEntity player && hasFullSuit(player)){
                removeFallDamage(player);
            }
//        }
    }

    private void removeFallDamage(PlayerEntity player){
        if(hasMatchingArmor(ModArmorMaterials.SLIMIUM, player)){
            if(player.fallDistance > 0.5){
                player.sendMessage(Text.literal("falling"));
                BlockPos playerBlock = player.getBlockPos();
                Block blockFeet = player.getWorld().getBlockState(playerBlock).getBlock();
                Block belowFeet = player.getWorld().getBlockState(playerBlock.down()).getBlock();
                player.sendMessage(Text.literal("" + belowFeet.toString()));
                player.sendMessage(Text.literal("" + bounceVel));
                if(player.getVelocity().getY() < -0.09){
                    bounceVel = player.getVelocity().getY();
                }
                if(!(bounceableBlock(blockFeet)) || !(bounceableBlock(belowFeet))){
                    player.setVelocity(player.getVelocity().getX(), -bounceVel/2, player.getVelocity().getZ());
                    player.sendMessage(Text.literal("gonna land"));
                    bounceVel = 0;
                    player.fallDistance = 0;
                }
            }

//            if(player.isOnGround()){
//                player.fallDistance = 0;
//            }

            //add bounce
        }
    }

    private boolean bounceableBlock(Block block){
        return block instanceof AirBlock || block instanceof PlantBlock;
        // || block instanceof TallFlowerBlock || block instanceof SnowyBlock || block instanceof PlantBlock
    }

    private boolean hasFullSuit(PlayerEntity player){
        ItemStack helmet = player.getInventory().getArmorStack(3);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack boots = player.getInventory().getArmorStack(0);
        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasMatchingArmor(ArmorMaterial material, PlayerEntity player){
        for(ItemStack armorStack : player.getInventory().armor){
            if(!(armorStack.getItem() instanceof ArmorItem)){
                return false;
            }
        }
        ArmorItem helmet = (ArmorItem) player.getInventory().getArmorStack(3).getItem();
        ArmorItem chestplate = (ArmorItem) player.getInventory().getArmorStack(2).getItem();
        ArmorItem leggings = (ArmorItem) player.getInventory().getArmorStack(1).getItem();
        ArmorItem boots = (ArmorItem) player.getInventory().getArmorStack(0).getItem();

        return helmet.getMaterial() == material && chestplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
