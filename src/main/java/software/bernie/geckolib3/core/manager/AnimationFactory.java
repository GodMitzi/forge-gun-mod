package main.java.software.bernie.geckolib3.core.manager;

import software.bernie.geckolib3.core.IAnimatable;

/**
 * Minimal stub for GeckoLib animation factory.
 */
public class AnimationFactory {
    private final IAnimatable animatable;

    public AnimationFactory(IAnimatable animatable) {
        this.animatable = animatable;
    }

    public IAnimatable getAnimatable() {
        return animatable;
    }
}
