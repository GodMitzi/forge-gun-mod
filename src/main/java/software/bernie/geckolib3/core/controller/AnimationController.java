package main.java.software.bernie.geckolib3.core.controller;

import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

import java.util.function.Function;

/**
 * Minimal stub for an animation controller.
 */
public class AnimationController<E> {
    private final String name;
    private final int updateInterval;
    private final Function<AnimationEvent<E>, PlayState> predicate;

    public AnimationController(E animatable, String name, int updateInterval, Function<AnimationEvent<E>, PlayState> predicate) {
        this.name = name;
        this.updateInterval = updateInterval;
        this.predicate = predicate;
    }

    public void setAnimation(AnimationBuilder builder) {
        // No-op: animation system is not implemented in stub.
    }

    public String getName() {
        return name;
    }

    public int getUpdateInterval() {
        return updateInterval;
    }

    public PlayState evaluate(AnimationEvent<E> event) {
        return predicate.apply(event);
    }
}
