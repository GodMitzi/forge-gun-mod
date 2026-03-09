package com.gunmod.client;

import com.gunmod.network.NetworkHandler;
import com.gunmod.network.ReloadPacket;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = "gunmod", value = net.minecraftforge.api.distmarker.Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    public static void onClientSetup(FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(ClientSetup.class);
        ClientRegistry.registerKeyBinding(KeyBindings.RELOAD);
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        if (Minecraft.getInstance().screen != null) return;

        while (KeyBindings.RELOAD.consumeClick()) {
            NetworkHandler.CHANNEL.sendToServer(new ReloadPacket());
        }
    }

    @SubscribeEvent
    public static void onRenderOverlay(RenderGuiOverlayEvent.Post event) {
        GunOverlay.render(event);
    }
}
