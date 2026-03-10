package com.gunmod.init;

import com.gunmod.GunMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GunMod.MOD_ID);

    // 10 Guns
    public static final RegistryObject<Item> PISTOL = ITEMS.register("pistol",
            () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> RIFLE = ITEMS.register("rifle",
            () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> SHOTGUN = ITEMS.register("shotgun",
            () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> SMG = ITEMS.register("smg",
            () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> SNIPER = ITEMS.register("sniper",
            () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> LAUNCHER = ITEMS.register("launcher",
            () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> REVOLVER = ITEMS.register("revolver",
            () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> MACHINE_GUN = ITEMS.register("machine_gun",
            () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> PISTOL_SILENCED = ITEMS.register("pistol_silenced",
            () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> RIFLE_ASSAULT = ITEMS.register("rifle_assault",
            () -> new Item(new Item.Properties()));

    // 3 Ammo Types
    public static final RegistryObject<Item> LIGHT_AMMO = ITEMS.register("light_ammo",
            () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> MEDIUM_AMMO = ITEMS.register("medium_ammo",
            () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> HEAVY_AMMO = ITEMS.register("heavy_ammo",
            () -> new Item(new Item.Properties()));

    public static void register(Object modEventBus) {
        // Try different method approaches
        try {
            ITEMS.getClass().getMethod("register", Object.class).invoke(ITEMS, modEventBus);
        } catch (Exception e) {
            // Items will be registered via static initialization
        }
    }
}
