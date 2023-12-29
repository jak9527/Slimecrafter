package com.slimecrafter.screen;

import com.slimecrafter.Main;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<PutrefierScreenHandler> PUTREFIER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(Main.MOD_ID, "putrefier"),
                    new ExtendedScreenHandlerType<>(PutrefierScreenHandler::new));

    public static void RegisterScreenHandlers() {
        Main.LOGGER.info("Registering Screen Handlers for " + Main.MOD_ID);
    }
}
