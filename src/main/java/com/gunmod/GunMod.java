package com.gunmod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(GunMod.MOD_ID)
public class GunMod {
    public static final String MOD_ID = "gunmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public GunMod(FMLJavaModLoadingContext context) {
        var modEventBus = context.getModBusGroup();

        FMLCommonSetupEvent.getBus(modEventBus).addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Gun Mod setup complete!");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID)
    public static class ServerEvents {
        @SubscribeEvent
        public static void onServerStarting(ServerStartingEvent event) {
            LOGGER.info("Gun Mod server starting!");
        }
    }
}
