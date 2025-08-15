package io.github.myueqf;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class test implements ModInitializer {
    public static final String MOD_ID = "test";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
            Registry.register(
                    Registries.CHUNK_GENERATOR,
                    Identifier.of(MOD_ID, "chunk_generator_2d"),
                    ChunkGenerator2D.CODEC
            );
            /* 夹带私货QwQ */
        LOGGER.info("    __                  __                ___________ ___________");
        LOGGER.info("   / /___ _____  ____  / /_  ____ _____  / ____/ ___// ____/ ___/");
        LOGGER.info("  / / __ `/ __ \\/_  / / __ \\/ __ `/ __ \\/___ \\/ __ \\/___ \\/ __ \\");
        LOGGER.info(" / / /_/ / / / / / /_/ / / / /_/ / / / /___/ / /_/ /___/ / /_/ /");
        LOGGER.info("/_/\\__,_/_/ /_/ /___/_/ /_/\\__,_/_/ /_/_____/\\____/_____/\\____/");
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            LOGGER.info("     猫猫探头～");
            LOGGER.info(" (=^-ω-^=)   ");
            LOGGER.info("=============");
        });
    }
}
