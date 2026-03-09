package main.java.software.bernie.geckolib3.core.event.predicate;

import software.bernie.geckolib3.core.controller.AnimationController;

/**
 * Minimal stub for animation event used in predicates.
 */
public class AnimationEvent<E> {
    private final AnimationController<E> controller;

    public AnimationEvent(AnimationController<E> controller) {
        this.controller = controller;
    }

    public AnimationController<E> getController() {
        return controller;
    }
}
