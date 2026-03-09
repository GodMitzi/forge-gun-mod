package main.java.software.bernie.geckolib3.core;

/**
 * Minimal GeckoLib stub interface to satisfy mod compilation.
 */
public interface IAnimatable {
    AnimationFactory getFactory();
    void registerControllers(AnimationData data);
}
