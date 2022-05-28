package net.darkhax.bedbenefits.config;

import com.google.gson.annotations.Expose;
import net.minecraft.server.level.ServerPlayer;

public class HealingSleepEffect extends SleepEffect {

    /**
     * The amount of health to heal.
     */
    @Expose
    public float healAmount = 10f;

    @Override
    public void apply(ServerPlayer player) {

        super.apply(player);
        player.heal(healAmount);
    }

    @Override
    public boolean canApply(ServerPlayer player) {

        return healAmount > 0 && player.getHealth() < player.getMaxHealth() && super.canApply(player);
    }
}