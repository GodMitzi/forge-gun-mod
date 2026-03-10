package com.gunmod.item;

import net.minecraft.world.item.Item;

public class GunItem extends Item {
    private final GunType gunType;
    private final AmmoType ammoType;

    public GunItem(GunType gunType, AmmoType ammoType, Properties properties) {
        super(properties);
        this.gunType = gunType;
        this.ammoType = ammoType;
    }

    public GunType getGunType() {
        return gunType;
    }

    public AmmoType getAmmoType() {
        return ammoType;
    }

    public float getActualDamage() {
        return gunType.getDamage() * ammoType.getDamageMultiplier();
    }
}
