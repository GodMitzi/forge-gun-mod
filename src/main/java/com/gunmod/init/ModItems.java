package com.gunmod.init;

import com.gunmod.GunMod;
import com.gunmod.item.AmmoItem;
import com.gunmod.item.GunItem;
import com.gunmod.item.GunType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GunMod.MODID);

    // Ammo items
    public static final RegistryObject<Item> SMALL_BULLET = ITEMS.register("small_bullet",
            () -> new AmmoItem(new Item.Properties().stacksTo(64).tab(ModTabs.GUN_TAB), AmmoItem.AmmoType.SMALL));
    public static final RegistryObject<Item> LARGE_BULLET = ITEMS.register("large_bullet",
            () -> new AmmoItem(new Item.Properties().stacksTo(64).tab(ModTabs.GUN_TAB), AmmoItem.AmmoType.LARGE));
    public static final RegistryObject<Item> HEAVY_AMMO = ITEMS.register("heavy_ammo",
            () -> new AmmoItem(new Item.Properties().stacksTo(64).tab(ModTabs.GUN_TAB), AmmoItem.AmmoType.HEAVY));

    // Guns
    public static final RegistryObject<Item> BASIC_PISTOL = ITEMS.register("basic_pistol",
            () -> new GunItem(GunType.BASIC_PISTOL, new Item.Properties().stacksTo(1).tab(ModTabs.GUN_TAB)));
    public static final RegistryObject<Item> REVOLVER = ITEMS.register("revolver",
            () -> new GunItem(GunType.REVOLVER, new Item.Properties().stacksTo(1).tab(ModTabs.GUN_TAB)));
    public static final RegistryObject<Item> DESERT_EAGLE = ITEMS.register("desert_eagle",
            () -> new GunItem(GunType.DESERT_EAGLE, new Item.Properties().stacksTo(1).tab(ModTabs.GUN_TAB)));

    public static final RegistryObject<Item> ASSAULT_RIFLE = ITEMS.register("assault_rifle",
            () -> new GunItem(GunType.ASSAULT_RIFLE, new Item.Properties().stacksTo(1).tab(ModTabs.GUN_TAB)));
    public static final RegistryObject<Item> SNIPER_RIFLE = ITEMS.register("sniper_rifle",
            () -> new GunItem(GunType.SNIPER_RIFLE, new Item.Properties().stacksTo(1).tab(ModTabs.GUN_TAB)));
    public static final RegistryObject<Item> SHOTGUN = ITEMS.register("shotgun",
            () -> new GunItem(GunType.SHOTGUN, new Item.Properties().stacksTo(1).tab(ModTabs.GUN_TAB)));

    public static final RegistryObject<Item> MINIGUN = ITEMS.register("minigun",
            () -> new GunItem(GunType.MINIGUN, new Item.Properties().stacksTo(1).tab(ModTabs.GUN_TAB)));
    public static final RegistryObject<Item> ROCKET_LAUNCHER = ITEMS.register("rocket_launcher",
            () -> new GunItem(GunType.ROCKET_LAUNCHER, new Item.Properties().stacksTo(1).tab(ModTabs.GUN_TAB)));
    public static final RegistryObject<Item> GRENADE_LAUNCHER = ITEMS.register("grenade_launcher",
            () -> new GunItem(GunType.GRENADE_LAUNCHER, new Item.Properties().stacksTo(1).tab(ModTabs.GUN_TAB)));
    public static final RegistryObject<Item> FLAMETHROWER = ITEMS.register("flamethrower",
            () -> new GunItem(GunType.FLAMETHROWER, new Item.Properties().stacksTo(1).tab(ModTabs.GUN_TAB)));
}
