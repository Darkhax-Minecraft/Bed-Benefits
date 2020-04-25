package net.darkhax.bedbenefits;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;

public class Configuration {
    
    private final ForgeConfigSpec spec;
    
    private final BooleanValue restoreHealth;
    private final DoubleValue healAmount;
    private final BooleanValue removeBadEffects;
    private final BooleanValue removePositiveEffects;
    
    public Configuration() {
        
        final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        
        // General Configs
        builder.comment("General settings for the mod.");
        builder.push("general");
        
        this.restoreHealth = builder.define("restore-health", true);
        this.healAmount = builder.defineInRange("restore-health-amount", 10d, 0d, Double.MAX_VALUE);
        this.removeBadEffects = builder.define("remove-bad-effects", true);
        this.removePositiveEffects = builder.define("remove-positive-effects", true);
        
        builder.pop();
        this.spec = builder.build();
    }
    
    public ForgeConfigSpec getSpec () {
        
        return this.spec;
    }
    
    public boolean shouldRestoreHealth () {
        
        return this.restoreHealth.get();
    }
    
    public double getHealthAmount () {
        
        return this.healAmount.get();
    }
    
    public boolean shouldClearBadEffects () {
        
        return this.removeBadEffects.get();
    }
    
    public boolean shouldClearGoodEffects () {
        
        return this.removePositiveEffects.get();
    }
}