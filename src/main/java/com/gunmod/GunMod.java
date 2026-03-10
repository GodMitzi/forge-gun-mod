package com.gunmod;

import com.gunmod.init.ModItems;
import com.gunmod.init.ModCreativeTabs;
import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(GunMod.MOD_ID)
public class GunMod {
    public static final String MOD_ID = "gunmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public GunMod(FMLJavaModLoadingContext context) {
        var modEventBus = context.getModBusGroup();

        ModItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        FMLCommonSetupEvent.getBus(modEventBus).addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Gun Mod setup complete! 10 guns and 3 ammo types loaded!");
        LOGGER.info("Guns: Pistol, Rifle, Shotgun, SMG, Sniper, Launcher, Revolver, Machine Gun, Silenced Pistol, Assault Rifle");
        LOGGER.info("Ammo: Light, Medium, Heavy");
        LOGGER.info("Creative tab and JSON recipes added!");
    }
}
