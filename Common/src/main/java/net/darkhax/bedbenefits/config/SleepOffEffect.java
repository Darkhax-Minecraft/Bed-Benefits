package net.darkhax.bedbenefits.config;

import com.google.gson.annotations.Expose;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.HashSet;
import java.util.Set;

public class SleepOffEffect extends SleepEffect {

    /**
     * Should harmful effects be removed when waking up?
     */
    @Expose
    public boolean removeHarmfulEffects = true;

    /**
     * Should beneficial effects be removed when waking up?
     */
    @Expose
    public boolean removeBeneficialEffects = false;

    /**
     * Should neutral effects be removed when waking up?
     */
    @Expose
    public boolean removeNeutralEffects = false;

    @Override
    public void apply(ServerPlayer player) {

        final Set<MobEffect> toClear = new HashSet<>();

        for (final MobEffectInstance effect : player.getActiveEffects()) {

            if (affectsCategory(effect.getEffect().getCategory())) {

                toClear.add(effect.getEffect());
            }
        }

        if (!toClear.isEmpty()) {

            for (final MobEffect effect : toClear) {

                player.removeEffect(effect);
            }

            super.apply(player);
        }
    }

    private boolean affectsCategory(MobEffectCategory category) {

        return (this.removeBeneficialEffects && category == MobEffectCategory.BENEFICIAL) || (this.removeHarmfulEffects && category == MobEffectCategory.HARMFUL) || (this.removeNeutralEffects && category == MobEffectCategory.NEUTRAL);
    }
}