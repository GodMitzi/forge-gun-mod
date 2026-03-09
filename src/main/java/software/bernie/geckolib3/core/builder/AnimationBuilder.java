package main.java.software.bernie.geckolib3.core.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Minimal stub for building animations.
 */
public class AnimationBuilder {
    private final List<String> animations = new ArrayList<>();

    public AnimationBuilder addAnimation(String name, boolean loop) {
        animations.add(name + (loop ? " (loop)" : ""));
        return this;
    }

    public List<String> getAnimations() {
        return animations;
    }
}
