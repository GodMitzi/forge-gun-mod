package com.gunmod.network;

import com.gunmod.init.ModSounds;
import com.gunmod.item.GunItem;
import com.gunmod.util.GunUtil;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ReloadPacket {
    public ReloadPacket() {
    }

    public static void encode(ReloadPacket packet, FriendlyByteBuf buf) {
        // no data
    }

    public static ReloadPacket decode(FriendlyByteBuf buf) {
        return new ReloadPacket();
    }

    public static void handle(ReloadPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            Player player = context.getSender();
            if (player == null) return;

            ItemStack stack = player.getMainHandItem();
            if (stack.getItem() instanceof GunItem gun) {
                boolean reloaded = GunUtil.reload(player, gun, stack);
                if (reloaded) {
                    player.level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.GUN_RELOAD.get(), net.minecraft.sounds.SoundSource.PLAYERS, 1f, 1f);
                }
            }
        });
        context.setPacketHandled(true);
    }
}
