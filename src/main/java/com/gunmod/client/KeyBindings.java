package com.gunmod.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
    public static final KeyMapping RELOAD = new KeyMapping("key.gunmod.reload", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_R, "key.categories.gunmod");
}
