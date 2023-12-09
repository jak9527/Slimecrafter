package com.slimecrafter.datagen;

import com.slimecrafter.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider{
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.SLIMIUM_HELMET)
                .add(ModItems.SLIMIUM_CHESTPLATE)
                .add(ModItems.SLIMIUM_LEGGINGS)
                .add(ModItems.SLIMIUM_BOOTS)
                .add(ModItems.REINFORCED_SLIMIUM_HELMET)
                .add(ModItems.REINFORCED_SLIMIUM_CHESTPLATE)
                .add(ModItems.REINFORCED_SLIMIUM_LEGGINGS)
                .add(ModItems.REINFORCED_SLIMIUM_BOOTS);
    }
}
