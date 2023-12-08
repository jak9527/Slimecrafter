package com.tutorialmod.item;

import com.tutorialmod.Main;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    // ITEMS
    public static final Item SLIMIUM_INGOT = registerItem("slimium_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_SLIMIUM = registerItem("raw_slimium", new Item(new FabricItemSettings()));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, name), item);
    }

    private static void addItemsToIngredients(FabricItemGroupEntries entries){
        entries.add(SLIMIUM_INGOT);
        entries.add(RAW_SLIMIUM);
    }

    public static void registerModItems(){
        Main.LOGGER.info("registering mod items for " + Main.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredients);
    }
}
