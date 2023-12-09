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
import net.minecraft.recipe.Ingredient;
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.REINFORCED_SLIMIUM_INGOT, 8)
                .pattern("SSS")
                .pattern("SNS")
                .pattern("SSS")
                .input('S', ModItems.SLIMIUM_INGOT)
                .input('N', Items.NETHERITE_INGOT)
                .criterion(hasItem(ModItems.SLIMIUM_INGOT), conditionsFromItem(ModItems.SLIMIUM_INGOT))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter);

        createStairsRecipe(ModBlocks.SLIMIUM_STAIRS, Ingredient.ofItems(ModItems.SLIMIUM_INGOT))
                .criterion(hasItem(ModItems.SLIMIUM_INGOT), conditionsFromItem(ModItems.SLIMIUM_INGOT))
                .offerTo(exporter);
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SLIMIUM_SLAB, Ingredient.ofItems(ModItems.SLIMIUM_INGOT))
                .criterion(hasItem(ModItems.SLIMIUM_INGOT), conditionsFromItem(ModItems.SLIMIUM_INGOT))
                .offerTo(exporter);;
        offerShapelessRecipe(exporter, ModBlocks.SLIMIUM_BUTTON, ModItems.SLIMIUM_INGOT, "slimium", 1);
        offerPressurePlateRecipe(exporter, ModBlocks.SLIMIUM_PRESSURE_PLATE, ModItems.SLIMIUM_INGOT);
        createFenceRecipe(ModBlocks.SLIMIUM_FENCE, Ingredient.ofItems(ModItems.SLIMIUM_INGOT))
                .criterion(hasItem(ModItems.SLIMIUM_INGOT), conditionsFromItem(ModItems.SLIMIUM_INGOT))
                .offerTo(exporter);;
        createFenceGateRecipe(ModBlocks.SLIMIUM_FENCE_GATE, Ingredient.ofItems(ModItems.SLIMIUM_INGOT))
                .criterion(hasItem(ModItems.SLIMIUM_INGOT), conditionsFromItem(ModItems.SLIMIUM_INGOT))
                .offerTo(exporter);;
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SLIMIUM_WALL, ModItems.SLIMIUM_INGOT);
        createDoorRecipe(ModBlocks.SLIMIUM_DOOR, Ingredient.ofItems(ModItems.SLIMIUM_INGOT))
                .criterion(hasItem(ModItems.SLIMIUM_INGOT), conditionsFromItem(ModItems.SLIMIUM_INGOT))
                .offerTo(exporter);;
        createTrapdoorRecipe(ModBlocks.SLIMIUM_TRAP_DOOR, Ingredient.ofItems(ModItems.SLIMIUM_INGOT))
                .criterion(hasItem(ModItems.SLIMIUM_INGOT), conditionsFromItem(ModItems.SLIMIUM_INGOT))
                .offerTo(exporter);;
    }
}
