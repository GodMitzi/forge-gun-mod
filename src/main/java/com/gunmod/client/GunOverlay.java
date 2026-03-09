package com.gunmod.client;

import com.gunmod.item.GunItem;
import com.gunmod.util.GunUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;

public class GunOverlay {
    public static void render(RenderGuiOverlayEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        ItemStack stack = mc.player.getMainHandItem();
        if (!(stack.getItem() instanceof GunItem gun)) return;

        int width = event.getWindow().getGuiScaledWidth();
        int height = event.getWindow().getGuiScaledHeight();
        int centerX = width / 2;
        int centerY = height / 2;

        boolean aiming = mc.player.isUsingItem();
        int ammo = GunUtil.getAmmo(stack);
        int maxAmmo = gun.getGunType().getMagazineSize();

        float baseSpread = gun.getGunType().getSpread();
        float spread = aiming ? baseSpread * 0.5f : baseSpread;
        int radius = Math.max(2, (int) (spread * 15));

        GuiGraphics gui = event.getGuiGraphics();
        PoseStack stackPose = gui.pose();

        // Crosshair circle
        gui.fill(centerX - radius, centerY - 1, centerX + radius, centerY + 1, 0x80FFFFFF);
        gui.fill(centerX - 1, centerY - radius, centerX + 1, centerY + radius, 0x80FFFFFF);

        // Ammo display
        String ammoText = ammo + " / " + maxAmmo;
        gui.drawString(mc.font, ammoText, 10, height - 20, 0xFFFFFF, false);

        if (aiming) {
            gui.drawString(mc.font, "AIM", 10, height - 35, 0xFFAAAAFF, false);
        }
    }
}
