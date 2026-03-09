package com.gunmod.init;

import com.gunmod.GunMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GunMod.MODID);

    public static final RegistryObject<SoundEvent> GUN_SHOOT = SOUNDS.register("gun_shoot",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GunMod.MODID, "gun_shoot")));
    public static final RegistryObject<SoundEvent> GUN_RELOAD = SOUNDS.register("gun_reload",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GunMod.MODID, "gun_reload")));
    public static final RegistryObject<SoundEvent> CLICK = SOUNDS.register("click",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GunMod.MODID, "click")));
}
