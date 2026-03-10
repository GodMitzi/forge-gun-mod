package com.gunmod.item;

import net.minecraft.world.item.Item;

public class AmmoItem extends Item {
    private final AmmoType ammoType;
    private final int stackSize;

    public AmmoItem(AmmoType ammoType, int stackSize, Properties properties) {
        super(properties);
        this.ammoType = ammoType;
        this.stackSize = stackSize;
    }

    public AmmoType getAmmoType() {
        return ammoType;
    }

    public int getStackSize() {
        return stackSize;
    }
}
