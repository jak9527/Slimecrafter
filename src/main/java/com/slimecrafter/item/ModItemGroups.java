package com.slimecrafter.item;

import com.slimecrafter.Main;
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
                    }).build());

    public static void registerItemGroups(){
        Main.LOGGER.info("Registering ItemGroups for " + Main.MOD_ID);
    }
}
