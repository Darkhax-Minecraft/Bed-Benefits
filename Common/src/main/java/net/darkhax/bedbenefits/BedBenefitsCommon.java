package net.darkhax.bedbenefits;

import net.darkhax.bedbenefits.config.Config;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public class BedBenefitsCommon {

    public static Config config;

    public static void init() {

        config = Config.load();
    }

    public static void onPlayerWakeUp(Player player) {

        if (config != null && player instanceof ServerPlayer serverPlayer) {

            if (config.restoreHealth.canApply(serverPlayer)) {

                config.restoreHealth.apply(serverPlayer);
            }

            if (config.sleepOffEffects.canApply(serverPlayer)) {

                config.sleepOffEffects.apply(serverPlayer);
            }
        }
    }
}