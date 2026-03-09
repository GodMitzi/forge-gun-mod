package com.gunmod.init;

import com.gunmod.GunMod;
import com.gunmod.entity.BulletEntity;
import com.gunmod.entity.ExplosiveProjectileEntity;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, GunMod.MODID);

    public static final RegistryObject<EntityType<BulletEntity>> BULLET = ENTITIES.register("bullet", () ->
            EntityType.Builder.<BulletEntity>of(BulletEntity::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4)
                    .updateInterval(1)
                    .build(new ResourceLocation(GunMod.MODID, "bullet").toString()));

    public static final RegistryObject<EntityType<ExplosiveProjectileEntity>> EXPLOSIVE_PROJECTILE = ENTITIES.register("explosive_projectile", () ->
            EntityType.Builder.<ExplosiveProjectileEntity>of(ExplosiveProjectileEntity::new, MobCategory.MISC)
                    .sized(0.4F, 0.4F)
                    .clientTrackingRange(4)
                    .updateInterval(1)
                    .build(new ResourceLocation(GunMod.MODID, "explosive_projectile").toString()));
}
