package com.slimecrafter.block;

import com.slimecrafter.Main;
import com.slimecrafter.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block SLIMIUM_ORE_BLOCK = registerBlock("slimium_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.GOLD_ORE).sounds(BlockSoundGroup.SLIME),
                    UniformIntProvider.create(1,3)));
    public static final Block DEEPSLATE_SLIMIUM_ORE_BLOCK = registerBlock("deepslate_slimium_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_GOLD_ORE).sounds(BlockSoundGroup.SLIME),
                    UniformIntProvider.create(1,3)));

    //Slimium block and its shaped equivalents
    public static final Block SLIMIUM_BLOCK = registerBlock("slimium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
    public static final Block SLIMIUM_STAIRS = registerBlock("slimium_stairs",
            new StairsBlock(ModBlocks.SLIMIUM_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
    public static final Block SLIMIUM_SLAB = registerBlock("slimium_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
    public static final Block SLIMIUM_BUTTON = registerBlock("slimium_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK), BlockSetType.STONE, 10, true));
    public static final Block SLIMIUM_PRESSURE_PLATE = registerBlock("slimium_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK), BlockSetType.IRON));
    public static final Block SLIMIUM_FENCE = registerBlock("slimium_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
    public static final Block SLIMIUM_FENCE_GATE = registerBlock("slimium_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK), WoodType.OAK));
    public static final Block SLIMIUM_WALL = registerBlock("slimium_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
    public static final Block SLIMIUM_DOOR = registerBlock("slimium_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK), BlockSetType.IRON));
    public static final Block SLIMIUM_TRAP_DOOR = registerBlock("slimium_trap_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK), BlockSetType.IRON));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Main.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        Main.LOGGER.info("Registering  mod blocks for " + Main.MOD_ID);
    }
}
