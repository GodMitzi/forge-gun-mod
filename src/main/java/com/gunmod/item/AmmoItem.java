package com.gunmod.item;

import com.gunmod.GunMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class AmmoItem extends Item {
    public enum AmmoType {
        SMALL("small_bullet"),
        LARGE("large_bullet"),
        HEAVY("heavy_ammo");

        private final TagKey<Item> tag;

        AmmoType(String name) {
            this.tag = TagKey.create(net.minecraft.core.registries.Registries.ITEM, new ResourceLocation(GunMod.MODID, name));
        }

        public TagKey<Item> getTag() {
            return tag;
        }
    }

    private final AmmoType type;

    public AmmoItem(Properties properties, AmmoType type) {
        super(properties);
        this.type = type;
    }

    public AmmoType getAmmoType() {
        return type;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return false;
    }
}
