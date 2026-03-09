package com.gunmod.util;

import com.gunmod.item.GunItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Inventory;

/**
 * Utility helpers for managing ammo and reloading.
 */
public class GunUtil {
    public static final String TAG_AMMO = "GunModAmmo";

    public static int getAmmo(ItemStack stack) {
        if (stack.isEmpty()) return 0;
        CompoundTag tag = stack.getTag();
        if (tag == null) return 0;
        return tag.getInt(TAG_AMMO);
    }

    public static void setAmmo(ItemStack stack, int ammo) {
        if (stack.isEmpty()) return;
        stack.getOrCreateTag().putInt(TAG_AMMO, Math.max(0, ammo));
    }

    public static void ensureAmmoSet(ItemStack stack) {
        if (stack.isEmpty() || !(stack.getItem() instanceof GunItem gun)) return;
        CompoundTag tag = stack.getOrCreateTag();
        if (!tag.contains(TAG_AMMO)) {
            tag.putInt(TAG_AMMO, gun.getGunType().getMagazineSize());
        }
    }

    public static boolean reload(Player player, GunItem gunItem, ItemStack gunStack) {
        int current = getAmmo(gunStack);
        int max = gunItem.getGunType().getMagazineSize();
        if (current >= max) return false;

        int needed = max - current;
        TagKey<Item> ammoTag = gunItem.getGunType().getAmmoTag();

        Inventory inv = player.getInventory();
        int added = 0;
        for (int i = 0; i < inv.getContainerSize() && needed > 0; i++) {
            ItemStack slot = inv.getItem(i);
            if (!slot.isEmpty() && slot.is(ammoTag)) {
                int take = Math.min(slot.getCount(), needed);
                slot.shrink(take);
                needed -= take;
                added += take;
            }
        }

        if (added > 0) {
            setAmmo(gunStack, current + added);
            return true;
        }
        return false;
    }
}

