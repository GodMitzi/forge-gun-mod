package com.gunmod.network;

import com.gunmod.GunMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class NetworkHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(GunMod.MODID, "network"))
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .simpleChannel();

    private static int packetId = 0;

    public static void register() {
        CHANNEL.registerMessage(packetId++, ReloadPacket.class, ReloadPacket::encode, ReloadPacket::decode, ReloadPacket::handle);
    }
}
