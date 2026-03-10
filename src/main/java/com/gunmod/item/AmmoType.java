package com.gunmod.item;

public enum AmmoType {
    LIGHT("light", 1.0f, 0.5f),
    MEDIUM("medium", 1.5f, 1.0f),
    HEAVY("heavy", 2.0f, 1.5f);

    private final String id;
    private final float damageMultiplier;
    private final float penetration;

    AmmoType(String id, float damageMultiplier, float penetration) {
        this.id = id;
        this.damageMultiplier = damageMultiplier;
        this.penetration = penetration;
    }

    public String getId() { return id; }
    public float getDamageMultiplier() { return damageMultiplier; }
    public float getPenetration() { return penetration; }
}
