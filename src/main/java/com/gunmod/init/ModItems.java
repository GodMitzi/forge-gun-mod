package com.gunmod.init;

import com.gunmod.GunMod;
import com.gunmod.item.GunItem;
import com.gunmod.item.AmmoItem;
import com.gunmod.item.GunType;
import com.gunmod.item.AmmoType;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GunMod.MOD_ID);

    // 10 Guns
    public static final RegistryObject<Item> PISTOL = ITEMS.register("pistol",
            () -> new GunItem(GunType.PISTOL, AmmoType.LIGHT, new Item.Properties()));
    
    public static final RegistryObject<Item> RIFLE = ITEMS.register("rifle",
            () -> new GunItem(GunType.RIFLE, AmmoType.MEDIUM, new Item.Properties()));
    
    public static final RegistryObject<Item> SHOTGUN = ITEMS.register("shotgun",
            () -> new GunItem(GunType.SHOTGUN, AmmoType.HEAVY, new Item.Properties()));
    
    public static final RegistryObject<Item> SMG = ITEMS.register("smg",
            () -> new GunItem(GunType.SMG, AmmoType.LIGHT, new Item.Properties()));
    
    public static final RegistryObject<Item> SNIPER = ITEMS.register("sniper",
            () -> new GunItem(GunType.SNIPER, AmmoType.HEAVY, new Item.Properties()));
    
    public static final RegistryObject<Item> LAUNCHER = ITEMS.register("launcher",
            () -> new GunItem(GunType.LAUNCHER, AmmoType.HEAVY, new Item.Properties()));
    
    public static final RegistryObject<Item> REVOLVER = ITEMS.register("revolver",
            () -> new GunItem(GunType.REVOLVER, AmmoType.MEDIUM, new Item.Properties()));
    
    public static final RegistryObject<Item> MACHINE_GUN = ITEMS.register("machine_gun",
            () -> new GunItem(GunType.MACHINE_GUN, AmmoType.MEDIUM, new Item.Properties()));
    
    public static final RegistryObject<Item> PISTOL_SILENCED = ITEMS.register("pistol_silenced",
            () -> new GunItem(GunType.PISTOL_SILENCED, AmmoType.LIGHT, new Item.Properties()));
    
    public static final RegistryObject<Item> RIFLE_ASSAULT = ITEMS.register("rifle_assault",
            () -> new GunItem(GunType.RIFLE_ASSAULT, AmmoType.MEDIUM, new Item.Properties()));

    // 3 Ammo Types
    public static final RegistryObject<Item> LIGHT_AMMO = ITEMS.register("light_ammo",
            () -> new AmmoItem(AmmoType.LIGHT, 64, new Item.Properties()));
    
    public static final RegistryObject<Item> MEDIUM_AMMO = ITEMS.register("medium_ammo",
            () -> new AmmoItem(AmmoType.MEDIUM, 32, new Item.Properties()));
    
    public static final RegistryObject<Item> HEAVY_AMMO = ITEMS.register("heavy_ammo",
            () -> new AmmoItem(AmmoType.HEAVY, 16, new Item.Properties()));

    public static void register(Object modEventBus) {
        ITEMS.register((Object) modEventBus);
    }
}
