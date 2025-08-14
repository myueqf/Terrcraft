package io.github.myueqf;

import net.fabricmc.api.ModInitializer;
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
        LOGGER.info("    猫猫探头～");
        LOGGER.info("(=^-ω-^=)   ");
        LOGGER.info("============");
    }
}
