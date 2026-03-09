package com.gunmod.item;

import com.gunmod.entity.BulletEntity;
import com.gunmod.entity.ExplosiveProjectileEntity;
import com.gunmod.init.ModEntities;
import com.gunmod.init.ModSounds;
import com.gunmod.item.GunType;
import com.gunmod.util.GunUtil;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Random;

/**
 * Gun item implementation supporting ammo, reloading, and simple shooting logic.
 */
public class GunItem extends Item implements IAnimatable {
    private final GunType gunType;
    private final AnimationFactory factory = new AnimationFactory(this);

    public GunItem(GunType gunType, Properties properties) {
        super(properties);
        this.gunType = gunType;
    }

    public GunType getGunType() {
        return gunType;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        GunUtil.ensureAmmoSet(stack);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity entityLiving, int timeLeft) {
        if (!(entityLiving instanceof Player player)) return;

        if (world.isClientSide) return;

        GunUtil.ensureAmmoSet(stack);
        int ammo = GunUtil.getAmmo(stack);
        if (ammo <= 0) {
            world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.CLICK.get(), SoundSource.PLAYERS, 0.5f, 1f);
            return;
        }

        int cooldown = gunType.getCooldownTicks();
        player.getCooldowns().addCooldown(this, cooldown);

        shoot(player, stack);
        GunUtil.setAmmo(stack, ammo - 1);

        world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.GUN_SHOOT.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
    }

    @Override
    public void onUseTick(Level world, LivingEntity entity, ItemStack stack, int count) {
        if (!(entity instanceof Player player)) return;
        if (world.isClientSide) return;

        if (!gunType.isAutomatic()) return;

        int usedTicks = getUseDuration(stack) - count;
        if (usedTicks % gunType.getCooldownTicks() != 0) return;

        int ammo = GunUtil.getAmmo(stack);
        if (ammo <= 0) {
            world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.CLICK.get(), SoundSource.PLAYERS, 0.5f, 1f);
            return;
        }

        shoot(player, stack);
        GunUtil.setAmmo(stack, ammo - 1);
        world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.GUN_SHOOT.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
    }

    private void shoot(Player player, ItemStack stack) {
        Level world = player.level;
        Vec3 look = player.getLookAngle();
        float spread = gunType.getSpread();
        int pellets = gunType.getPellets();

        if (gunType.isExplosive()) {
            spawnExplosiveProjectile(player, look);
            return;
        }

        for (int i = 0; i < pellets; i++) {
            Vec3 direction = look;
            if (spread > 0) {
                direction = direction.add((randomFloat() - 0.5) * spread, (randomFloat() - 0.5) * spread, (randomFloat() - 0.5) * spread);
            }
            BulletEntity bullet = new BulletEntity(ModEntities.BULLET.get(), world, player);
            bullet.setDeltaMovement(direction.scale(3.0));
            bullet.setBaseDamage(gunType.getDamage());
            bullet.setPos(player.getX(), player.getEyeY() - 0.1, player.getZ());
            world.addFreshEntity(bullet);
        }

        if (gunType == GunType.FLAMETHROWER) {
            // Spray flame particles for visual feedback
            for (int i = 0; i < 10; i++) {
                Vec3 offset = look.add((randomFloat() - 0.5) * 0.3, (randomFloat() - 0.5) * 0.2, (randomFloat() - 0.5) * 0.3);
                world.addParticle(ParticleTypes.FLAME, player.getX() + offset.x, player.getEyeY() + offset.y, player.getZ() + offset.z, 0, 0, 0);
            }
        }
    }

    private void spawnExplosiveProjectile(Player player, Vec3 look) {
        Level world = player.level;
        ExplosiveProjectileEntity projectile = new ExplosiveProjectileEntity(ModEntities.EXPLOSIVE_PROJECTILE.get(), world, player);
        projectile.setDeltaMovement(look.scale(2.5));
        projectile.setExplosionPower(gunType.getExplosionRadius());
        projectile.setPos(player.getX(), player.getEyeY() - 0.1, player.getZ());
        world.addFreshEntity(projectile);
    }

    private static float randomFloat() {
        return (new Random()).nextFloat();
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 20, this::predicate));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
