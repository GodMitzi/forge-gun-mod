package main.java.software.bernie.geckolib3.core.manager;

import software.bernie.geckolib3.core.controller.AnimationController;

import java.util.ArrayList;
import java.util.List;

/**
 * Minimal stub to hold animation controllers.
 */
public class AnimationData {
    private final List<AnimationController<?>> controllers = new ArrayList<>();

    public void addAnimationController(AnimationController<?> controller) {
        controllers.add(controller);
    }

    public Iterable<AnimationController<?>> getAnimationControllers() {
        return controllers;
    }
}
