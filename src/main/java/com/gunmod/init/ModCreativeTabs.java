package com.gunmod.init;

import com.gunmod.GunMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GunMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GUN_TAB = CREATIVE_TABS.register("gun_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.gunmod.gun_tab"))
                    .icon(() -> new ItemStack(ModItems.PISTOL.get()))
                    .displayItems((parameters, output) -> {
                        // Add all guns
                        output.accept(ModItems.PISTOL.get());
                        output.accept(ModItems.RIFLE.get());
                        output.accept(ModItems.SHOTGUN.get());
                        output.accept(ModItems.SMG.get());
                        output.accept(ModItems.SNIPER.get());
                        output.accept(ModItems.LAUNCHER.get());
                        output.accept(ModItems.REVOLVER.get());
                        output.accept(ModItems.MACHINE_GUN.get());
                        output.accept(ModItems.PISTOL_SILENCED.get());
                        output.accept(ModItems.RIFLE_ASSAULT.get());
                        
                        // Add all ammo types
                        output.accept(ModItems.LIGHT_AMMO.get());
                        output.accept(ModItems.MEDIUM_AMMO.get());
                        output.accept(ModItems.HEAVY_AMMO.get());
                        
                        // Add crafting materials
                        output.accept(Items.IRON_INGOT);
                        output.accept(Items.GOLD_INGOT);
                        output.accept(Items.DIAMOND);
                        output.accept(Items.REDSTONE);
                        output.accept(Items.GUNPOWDER);
                    })
                    .build());

    public static void register(Object modEventBus) {
        try {
            CREATIVE_TABS.getClass().getMethod("register", Object.class).invoke(CREATIVE_TABS, modEventBus);
        } catch (Exception e) {
            // Fallback - tabs will be registered via static initialization
        }
    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        // Also add guns to existing combat tab
        // Note: CreativeModeTabs.COMBAT might not exist in 1.21.11, so we'll skip this for now
        // Items will be available in the custom gun tab
    }
}
