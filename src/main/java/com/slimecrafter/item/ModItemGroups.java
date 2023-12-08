package com.slimecrafter.item;

import com.slimecrafter.Main;
import com.slimecrafter.block.ModBlocks;
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
                        entries.add(ModBlocks.SLIMIUM_ORE_BLOCK);
                        entries.add(ModBlocks.DEEPSLATE_SLIMIUM_ORE_BLOCK);
                    }).build());

    public static void registerItemGroups(){
        Main.LOGGER.info("Registering ItemGroups for " + Main.MOD_ID);
    }
}
