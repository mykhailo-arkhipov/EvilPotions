public enum Effects {
    // 25 effects from best to worst
    // 14 good
    INVISIBILITY("Invisibility", 120d),
    FIRE_AURA("Fire Aura", 50d),
    ELVEN_GAZE("Elven gaze", 49d),
    NIGHT_VISION("Night Vision", 20d),
    TELEKINESIS("Telekinesis", 15d),
    WATER_BREATHING("Water Breathing", 14d),
    STRENGTH_INCREASED("Strength increased", 12d),
    SPEED_INCREASED("Speed icreased", 11d),
    LUCK("Luck", 10d),
    LEVITATION("Levitation", 9d),
    REGENERATION("Regeneration", 6d),
    JUMP_BOOST("Jump Boost", 2d),
    HEALING("Healing", 1d),
    HEROISM("Heroism", 0.1d),
    // 11 bad
    DIARRHEA("Diarrhea",0.2d),
    BLOATING("Bloating", 2d),
    ELECTRIC_SHOCK("Electric Shock", 2.4d),
    UNLUCK("Unluck", 3d),
    BAD_MOOD("Bad mood", 4d),
    SLOWNESS("Slowness", 5d),
    BALDNESS("Baldness", 5d),
    POISON("Poison", 9d),
    LIMB_NUMBNESS("Limb numbness", 15d),
    BLINDNESS("Blindness", 29d),
    EYE_WORMS("EYE_WORMS", 121d);



    private final String effectName;
    private final double price;
    Effects(String effectName, double price){
        this.effectName = effectName;
        this.price = price;
    }
    public String getEffectName(){
        return effectName;
    }
    public double getEffectPrice(){
        return price;
    }
}
