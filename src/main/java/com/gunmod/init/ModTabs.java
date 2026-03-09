package com.gunmod.init;

import com.gunmod.GunMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GunMod.MODID);

    public static final RegistryObject<CreativeModeTab> GUN_TAB = TABS.register("guns", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> new ItemStack(ModItems.BASIC_PISTOL.get()))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.BASIC_PISTOL.get());
                output.accept(ModItems.REVOLVER.get());
                output.accept(ModItems.DESERT_EAGLE.get());
                output.accept(ModItems.ASSAULT_RIFLE.get());
                output.accept(ModItems.SNIPER_RIFLE.get());
                output.accept(ModItems.SHOTGUN.get());
                output.accept(ModItems.MINIGUN.get());
                output.accept(ModItems.ROCKET_LAUNCHER.get());
                output.accept(ModItems.GRENADE_LAUNCHER.get());
                output.accept(ModItems.FLAMETHROWER.get());
                output.accept(ModItems.SMALL_BULLET.get());
                output.accept(ModItems.LARGE_BULLET.get());
                output.accept(ModItems.HEAVY_AMMO.get());
            }).build());
}
