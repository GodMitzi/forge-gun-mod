package com.gunmod;

import com.gunmod.init.ModEntities;
import com.gunmod.init.ModItems;
import com.gunmod.init.ModSounds;
import com.gunmod.init.ModTabs;
import com.gunmod.network.NetworkHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GunMod.MOD_ID)
public class GunMod {
    public static final String MOD_ID = "gunmod";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public GunMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModEntities.register(modEventBus);
        ModSounds.register(modEventBus);
        ModTabs.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        NetworkHandler.register();
        LOGGER.info("Gun Mod common setup complete!");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // Add items to creative tabs if needed
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Gun Mod server starting!");
    }
}
