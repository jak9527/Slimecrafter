package com.example;

import com.slimecrafter.block.ModBlocks;
import com.slimecrafter.screen.ModScreenHandlers;
import com.slimecrafter.screen.PutrefierScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class ExampleModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SLIMIUM_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SLIMIUM_TRAP_DOOR, RenderLayer.getCutout());

		HandledScreens.register(ModScreenHandlers.PUTREFIER_SCREEN_HANDLER, PutrefierScreen::new);
	}
}