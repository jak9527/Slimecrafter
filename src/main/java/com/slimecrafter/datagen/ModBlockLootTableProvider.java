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
        addDrop(ModBlocks.SLIMIUM_BLOCK);
        addDrop(ModBlocks.SLIMIUM_ORE_BLOCK, oreDrops(ModBlocks.SLIMIUM_ORE_BLOCK, ModItems.RAW_SLIMIUM));
        addDrop(ModBlocks.DEEPSLATE_SLIMIUM_ORE_BLOCK, oreDrops(ModBlocks.DEEPSLATE_SLIMIUM_ORE_BLOCK, ModItems.RAW_SLIMIUM));
    }
}
