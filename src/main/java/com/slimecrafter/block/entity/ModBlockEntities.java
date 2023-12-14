package com.slimecrafter.block.entity;

import com.slimecrafter.Main;
import com.slimecrafter.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<PutrefierBlockEntity> PUTREFIER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Main.MOD_ID, "putrefier_be"),
                    FabricBlockEntityTypeBuilder.create(PutrefierBlockEntity::new,
                            ModBlocks.PUTREFIER).build());

    public static void registerBlocks() {
        Main.LOGGER.info("Registering Block Entities for " + Main.MOD_ID);


    }

}
