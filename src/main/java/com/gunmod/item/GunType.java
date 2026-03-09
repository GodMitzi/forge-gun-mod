package com.gunmod.item;

import com.gunmod.GunMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

/**
 * Defines the different gun types and their behavior parameters.
 */
public enum GunType {
    BASIC_PISTOL("basic_pistol", AmmoType.SMALL, 12, 6, 0.2f, 1, 0.6f, false, false, 0f),
    REVOLVER("revolver", AmmoType.SMALL, 6, 10, 0.3f, 1, 0.8f, false, false, 0f),
    DESERT_EAGLE("desert_eagle", AmmoType.SMALL, 7, 18, 0.35f, 1, 1.1f, false, false, 0f),

    ASSAULT_RIFLE("assault_rifle", AmmoType.LARGE, 30, 4, 0.15f, 1, 0.5f, true, false, 0f),
    SNIPER_RIFLE("sniper_rifle", AmmoType.LARGE, 5, 30, 0.05f, 1, 2.0f, false, false, 0f),
    SHOTGUN("shotgun", AmmoType.LARGE, 8, 20, 0.4f, 8, 0.9f, false, false, 0f),

    MINIGUN("minigun", AmmoType.HEAVY, 100, 2, 0.2f, 1, 0.4f, true, false, 0f),
    ROCKET_LAUNCHER("rocket_launcher", AmmoType.HEAVY, 1, 40, 0.25f, 1, 1.2f, false, true, 3f),
    GRENADE_LAUNCHER("grenade_launcher", AmmoType.HEAVY, 1, 25, 0.35f, 1, 1.0f, false, true, 2.5f),
    FLAMETHROWER("flamethrower", AmmoType.HEAVY, 200, 1, 0.15f, 1, 0.4f, true, false, 0f);

    private final String id;
    private final AmmoType ammoType;
    private final int magazineSize;
    private final int cooldownTicks;
    private final float damage;
    private final int pellets;
    private final float spread;
    private final boolean automatic;
    private final boolean explosive;
    private final float explosionRadius;

    GunType(String id, AmmoType ammoType, int magazineSize, int cooldownTicks, float damage, int pellets, float spread, boolean automatic, boolean explosive, float explosionRadius) {
        this.id = id;
        this.ammoType = ammoType;
        this.magazineSize = magazineSize;
        this.cooldownTicks = cooldownTicks;
        this.damage = damage;
        this.pellets = pellets;
        this.spread = spread;
        this.automatic = automatic;
        this.explosive = explosive;
        this.explosionRadius = explosionRadius;
    }

    public String getId() {
        return id;
    }

    public AmmoType getAmmoType() {
        return ammoType;
    }

    public int getMagazineSize() {
        return magazineSize;
    }

    public int getCooldownTicks() {
        return cooldownTicks;
    }

    public float getDamage() {
        return damage;
    }

    public int getPellets() {
        return pellets;
    }

    public float getSpread() {
        return spread;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public boolean isExplosive() {
        return explosive;
    }

    public float getExplosionRadius() {
        return explosionRadius;
    }

    public TagKey<Item> getAmmoTag() {
        return ammoType.getTag();
    }

    public ResourceLocation getTextureLocation() {
        return new ResourceLocation(GunMod.MODID, "item/" + id);
    }
}

