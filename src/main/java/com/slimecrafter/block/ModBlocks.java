package com.slimecrafter.block;

import com.slimecrafter.Main;
import com.slimecrafter.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block SLIMIUM_ORE_BLOCK = registerBlock("slimium_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_ORE).sounds(BlockSoundGroup.SLIME)));
    public static final Block DEEPSLATE_SLIMIUM_ORE_BLOCK = registerBlock("deepslate_slimium_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_GOLD_ORE).sounds(BlockSoundGroup.SLIME)));
    public static final Block SLIMIUM_BLOCK = registerBlock("slimium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));

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
