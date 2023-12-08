package com.slimecrafter.datagen;

import com.slimecrafter.block.ModBlocks;
import com.slimecrafter.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static List<ItemConvertible> SLIMIUM_SMELTABLES = List.of(
            ModItems.RAW_SLIMIUM, ModBlocks.DEEPSLATE_SLIMIUM_ORE_BLOCK, ModBlocks.SLIMIUM_ORE_BLOCK
    );

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, SLIMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.SLIMIUM_INGOT,
                0.4f, 200, "slimium");
        offerBlasting(exporter, SLIMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.SLIMIUM_INGOT,
                0.4f, 100, "slimium");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SLIMIUM_INGOT,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.SLIMIUM_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.JUMPAMATRON, 1)
                .pattern("SPS")
                .pattern("SRS")
                .pattern(" GT")
                .input('S', ModItems.SLIMIUM_INGOT)
                .input('P', Blocks.STICKY_PISTON)
                .input('R', Items.REDSTONE)
                .input('G', Items.GOLD_INGOT)
                .input('T', Blocks.TRIPWIRE_HOOK)
                .criterion(hasItem(ModItems.SLIMIUM_INGOT), conditionsFromItem(ModItems.SLIMIUM_INGOT))
                .offerTo(exporter);
    }
}
