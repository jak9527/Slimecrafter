package com.slimecrafter.datagen;

import com.slimecrafter.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider{
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        //Pickaxe Mineable
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SLIMIUM_BLOCK)
                .add(ModBlocks.SLIMIUM_ORE_BLOCK)
                .add(ModBlocks.DEEPSLATE_SLIMIUM_ORE_BLOCK);

        //Axe Mineable
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE);

        //Shovel Mineable
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE);

        //Hoe Mineable
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE);

        //Mining Levels
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SLIMIUM_BLOCK);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SLIMIUM_ORE_BLOCK)
                .add(ModBlocks.DEEPSLATE_SLIMIUM_ORE_BLOCK);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")));
    }
}
