package com.slimecrafter;

import com.slimecrafter.block.ModBlocks;
import com.slimecrafter.block.entity.ModBlockEntities;
import com.slimecrafter.item.ModItemGroups;
import com.slimecrafter.item.ModItems;
import com.slimecrafter.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("slimecrafter");
	public static final String MOD_ID = "slimecrafter";



	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();

		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlocks();


		//Generation
		ModWorldGeneration.generateModWorldGen();

	}
}