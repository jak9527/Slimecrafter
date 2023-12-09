package com.slimecrafter.datagen;

import com.slimecrafter.block.ModBlocks;
import com.slimecrafter.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SLIMIUM_ORE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SLIMIUM_ORE_BLOCK);
        BlockStateModelGenerator.BlockTexturePool slimiumPool
                = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SLIMIUM_BLOCK);

        slimiumPool.stairs(ModBlocks.SLIMIUM_STAIRS);
        slimiumPool.slab(ModBlocks.SLIMIUM_SLAB);
        slimiumPool.button(ModBlocks.SLIMIUM_BUTTON);
        slimiumPool.pressurePlate(ModBlocks.SLIMIUM_PRESSURE_PLATE);
        slimiumPool.fence(ModBlocks.SLIMIUM_FENCE);
        slimiumPool.fenceGate(ModBlocks.SLIMIUM_FENCE_GATE);
        slimiumPool.wall(ModBlocks.SLIMIUM_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.SLIMIUM_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.SLIMIUM_TRAP_DOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_SLIMIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.REINFORCED_SLIMIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SLIMIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.JUMPAMATRON, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.SLIMIUM_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SLIMIUM_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SLIMIUM_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SLIMIUM_BOOTS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.REINFORCED_SLIMIUM_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.REINFORCED_SLIMIUM_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.REINFORCED_SLIMIUM_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.REINFORCED_SLIMIUM_BOOTS);
    }
}
