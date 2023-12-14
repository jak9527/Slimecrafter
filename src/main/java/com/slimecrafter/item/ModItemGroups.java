package com.slimecrafter.item;

import com.slimecrafter.Main;
import com.slimecrafter.block.ModBlocks;
import com.slimecrafter.block.custom.Putrefier;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MOD_INGREDIENTS = Registry.register(Registries.ITEM_GROUP, new Identifier(Main.MOD_ID, "mod_ingredients"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.mod_ingredients"))
                    .icon(() -> new ItemStack(ModItems.SLIMIUM_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_SLIMIUM);
                        entries.add(ModItems.SLIMIUM_INGOT);
                        entries.add(ModItems.REINFORCED_SLIMIUM_INGOT);
                        entries.add(ModBlocks.SLIMIUM_ORE_BLOCK);
                        entries.add(ModBlocks.DEEPSLATE_SLIMIUM_ORE_BLOCK);
                        entries.add(ModBlocks.SLIMIUM_BLOCK);
                    }).build());

    public static final ItemGroup MOD_TOOLS = Registry.register(Registries.ITEM_GROUP, new Identifier(Main.MOD_ID, "mod_tools"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.mod_tools"))
                    .icon(() -> new ItemStack(ModItems.JUMPAMATRON)).entries((displayContext, entries) -> {
                        entries.add(ModItems.JUMPAMATRON);

                        entries.add(ModItems.SLIMIUM_HELMET);
                        entries.add(ModItems.SLIMIUM_CHESTPLATE);
                        entries.add(ModItems.SLIMIUM_LEGGINGS);
                        entries.add(ModItems.SLIMIUM_BOOTS);

                        entries.add(ModItems.REINFORCED_SLIMIUM_HELMET);
                        entries.add(ModItems.REINFORCED_SLIMIUM_CHESTPLATE);
                        entries.add(ModItems.REINFORCED_SLIMIUM_LEGGINGS);
                        entries.add(ModItems.REINFORCED_SLIMIUM_BOOTS);
                    }).build());

    public static final ItemGroup MOD_BLOCKS = Registry.register(Registries.ITEM_GROUP, new Identifier(Main.MOD_ID, "mod_blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.mod_blocks"))
                    .icon(() -> new ItemStack(ModBlocks.SLIMIUM_BLOCK)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.SLIMIUM_BLOCK);
                        entries.add(ModBlocks.SLIMIUM_SLAB);
                        entries.add(ModBlocks.SLIMIUM_STAIRS);
                        entries.add(ModBlocks.SLIMIUM_TRAP_DOOR);
                        entries.add(ModBlocks.SLIMIUM_BUTTON);
                        entries.add(ModBlocks.SLIMIUM_FENCE);
                        entries.add(ModBlocks.SLIMIUM_FENCE_GATE);
                        entries.add(ModBlocks.SLIMIUM_DOOR);
                        entries.add(ModBlocks.SLIMIUM_WALL);
                        entries.add(ModBlocks.PUTREFIER);
                    }).build());

    public static void registerItemGroups(){
        Main.LOGGER.info("Registering ItemGroups for " + Main.MOD_ID);
    }
}
