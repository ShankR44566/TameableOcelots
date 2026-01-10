package com.shankr44566.tameableocelots;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TameableOcelots implements ModInitializer {
    public static final String MOD_ID = "tameableocelots";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Tameable Ocelots loaded!");
    }
}
