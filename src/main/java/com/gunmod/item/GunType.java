package com.gunmod.item;

public enum GunType {
    PISTOL("pistol", 12, 15, 3.0f, 1, 0.05f, false, false, 0.0f),
    RIFLE("rifle", 30, 20, 5.0f, 1, 0.02f, false, false, 0.0f),
    SHOTGUN("shotgun", 8, 25, 2.5f, 6, 0.15f, false, false, 0.0f),
    SMG("smg", 25, 5, 2.5f, 1, 0.08f, true, false, 0.0f),
    SNIPER("sniper", 5, 40, 8.0f, 1, 0.001f, false, false, 0.0f),
    LAUNCHER("launcher", 1, 60, 15.0f, 1, 0.1f, false, true, 5.0f),
    REVOLVER("revolver", 6, 25, 4.0f, 1, 0.03f, false, false, 0.0f),
    MACHINE_GUN("machine_gun", 100, 2, 3.5f, 1, 0.12f, true, false, 0.0f),
    PISTOL_SILENCED("pistol_silenced", 12, 18, 2.8f, 1, 0.04f, false, false, 0.0f),
    RIFLE_ASSAULT("rifle_assault", 30, 10, 4.5f, 1, 0.03f, true, false, 0.0f);

    private final String id;
    private final int magazineSize;
    private final int cooldownTicks;
    private final float damage;
    private final int pellets;
    private final float spread;
    private final boolean automatic;
    private final boolean explosive;
    private final float explosionRadius;

    GunType(String id, int magazineSize, int cooldownTicks, float damage, int pellets, float spread, boolean automatic, boolean explosive, float explosionRadius) {
        this.id = id;
        this.magazineSize = magazineSize;
        this.cooldownTicks = cooldownTicks;
        this.damage = damage;
        this.pellets = pellets;
        this.spread = spread;
        this.automatic = automatic;
        this.explosive = explosive;
        this.explosionRadius = explosionRadius;
    }

    public String getId() { return id; }
    public int getMagazineSize() { return magazineSize; }
    public int getCooldownTicks() { return cooldownTicks; }
    public float getDamage() { return damage; }
    public int getPellets() { return pellets; }
    public float getSpread() { return spread; }
    public boolean isAutomatic() { return automatic; }
    public boolean isExplosive() { return explosive; }
    public float getExplosionRadius() { return explosionRadius; }
}
