package com.slimecrafter.datagen;

import com.slimecrafter.block.ModBlocks;
import com.slimecrafter.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    protected ModBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    //uncomment and middle click the next line to view all the default block drop generators so you can copy them
    //BlockLootTableGenerator

    @Override
    public void generate() {
        //Self drop
        addDrop(ModBlocks.SLIMIUM_BLOCK);
        //Shapes
        addDrop(ModBlocks.SLIMIUM_FENCE);
        addDrop(ModBlocks.SLIMIUM_BUTTON);
        addDrop(ModBlocks.SLIMIUM_FENCE_GATE);
        addDrop(ModBlocks.SLIMIUM_PRESSURE_PLATE);
        addDrop(ModBlocks.SLIMIUM_STAIRS);
        addDrop(ModBlocks.SLIMIUM_TRAP_DOOR);
        addDrop(ModBlocks.SLIMIUM_WALL);

        addDrop(ModBlocks.SLIMIUM_DOOR, doorDrops(ModBlocks.SLIMIUM_DOOR));
        addDrop(ModBlocks.SLIMIUM_SLAB, slabDrops(ModBlocks.SLIMIUM_SLAB));


        addDrop(ModBlocks.SLIMIUM_ORE_BLOCK, oreDrops(ModBlocks.SLIMIUM_ORE_BLOCK, ModItems.RAW_SLIMIUM));
        addDrop(ModBlocks.DEEPSLATE_SLIMIUM_ORE_BLOCK, oreDrops(ModBlocks.DEEPSLATE_SLIMIUM_ORE_BLOCK, ModItems.RAW_SLIMIUM));
    }
}
