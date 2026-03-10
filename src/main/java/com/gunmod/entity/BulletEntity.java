package com.gunmod.entity;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

/**
 * Simple bullet entity that behaves like an arrow but without being retrievable.
 */
public class BulletEntity extends AbstractArrow {
    public BulletEntity(EntityType<? extends BulletEntity> type, Level world) {
        super(type, world);
        this.pickup = AbstractArrow.Pickup.DISALLOWED;
    }

    public BulletEntity(EntityType<? extends BulletEntity> type, Level world, LivingEntity shooter) {
        super(type, shooter, 0, 0);
        this.setOwner(shooter);
        this.pickup = AbstractArrow.Pickup.DISALLOWED;
    }

    public BulletEntity(Level world) {
        super(ModEntities.BULLET.get(), world);
        this.pickup = AbstractArrow.Pickup.DISALLOWED;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide && this.tickCount > 80) {
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(net.minecraft.world.phys.EntityHitResult result) {
        super.onHitEntity(result);
        this.discard();
    }

    @Override
    protected Item getPickupItem() {
        return null;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
