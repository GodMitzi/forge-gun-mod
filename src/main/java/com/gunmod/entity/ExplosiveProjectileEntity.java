package com.gunmod.entity;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

/**
 * A simple explosive projectile entity that detonates on impact.
 */
public class ExplosiveProjectileEntity extends AbstractHurtingProjectile {
    private float explosionPower = 2.5f;
    private int fuse = 40;

    public ExplosiveProjectileEntity(EntityType<? extends ExplosiveProjectileEntity> type, Level world) {
        super(type, world);
    }

    public ExplosiveProjectileEntity(EntityType<? extends ExplosiveProjectileEntity> type, Level world, LivingEntity shooter) {
        super(type, shooter, 0, 0);
        this.setOwner(shooter);
    }

    public ExplosiveProjectileEntity(net.minecraftforge.network.PlayMessages.SpawnEntity packet, Level world) {
        super(ModEntities.EXPLOSIVE_PROJECTILE.get(), world);
    }

    public void setExplosionPower(float power) {
        this.explosionPower = power;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide) {
            if (this.tickCount > fuse) {
                explode();
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        explode();
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        explode();
    }

    private void explode() {
        if (!this.level.isClientSide) {
            this.level.explode(this, this.getX(), this.getY(), this.getZ(), this.explosionPower, Level.ExplosionInteraction.TNT);
            this.discard();
        }
    }

    @Override
    protected void defineSynchedData() {
    }

    @Override
    protected void readAdditionalSaveData(net.minecraft.nbt.CompoundTag compound) {
        this.explosionPower = compound.getFloat("ExplosionPower");
    }

    @Override
    protected void addAdditionalSaveData(net.minecraft.nbt.CompoundTag compound) {
        compound.putFloat("ExplosionPower", this.explosionPower);
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
