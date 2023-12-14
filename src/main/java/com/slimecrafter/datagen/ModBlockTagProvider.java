package com.slimecrafter.datagen;

import com.slimecrafter.block.ModBlocks;
import com.slimecrafter.util.ModTags;
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
        //Ores
        getOrCreateTagBuilder(ModTags.Blocks.ORE)
                .add(ModBlocks.SLIMIUM_ORE_BLOCK)
                .add(ModBlocks.DEEPSLATE_SLIMIUM_ORE_BLOCK)
                .forceAddTag(BlockTags.COAL_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES);

        //Pickaxe Mineable
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SLIMIUM_BLOCK)
                .add(ModBlocks.SLIMIUM_ORE_BLOCK)
                .add(ModBlocks.DEEPSLATE_SLIMIUM_ORE_BLOCK)
                .add(ModBlocks.SLIMIUM_WALL)
                .add(ModBlocks.SLIMIUM_FENCE_GATE)
                .add(ModBlocks.SLIMIUM_FENCE)
                .add(ModBlocks.SLIMIUM_BUTTON)
                .add(ModBlocks.SLIMIUM_DOOR)
                .add(ModBlocks.SLIMIUM_PRESSURE_PLATE)
                .add(ModBlocks.SLIMIUM_SLAB)
                .add(ModBlocks.SLIMIUM_STAIRS)
                .add(ModBlocks.SLIMIUM_TRAP_DOOR);

        //Axe Mineable
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE);

        //Shovel Mineable
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE);

        //Hoe Mineable
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE);

        //Mining Levels
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SLIMIUM_BLOCK)
                .add(ModBlocks.SLIMIUM_WALL)
                .add(ModBlocks.SLIMIUM_FENCE_GATE)
                .add(ModBlocks.SLIMIUM_FENCE)
                .add(ModBlocks.SLIMIUM_BUTTON)
                .add(ModBlocks.SLIMIUM_DOOR)
                .add(ModBlocks.SLIMIUM_PRESSURE_PLATE)
                .add(ModBlocks.SLIMIUM_SLAB)
                .add(ModBlocks.SLIMIUM_STAIRS)
                .add(ModBlocks.SLIMIUM_TRAP_DOOR);;
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SLIMIUM_ORE_BLOCK)
                .add(ModBlocks.DEEPSLATE_SLIMIUM_ORE_BLOCK);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")));

        //Block shapes
        //Fences
        getOrCreateTagBuilder(BlockTags.FENCES)
            .add(ModBlocks.SLIMIUM_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.SLIMIUM_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.SLIMIUM_WALL);

    }
}
