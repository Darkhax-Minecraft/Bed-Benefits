package net.darkhax.bedbenefits;

import net.darkhax.bedbenefits.config.Config;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

import java.nio.file.Path;

public class BedBenefitsCommon {

    private static Config config;

    public static void init(Path configPath) {

        if (config == null) {
            config = Config.load(configPath);
        }

        else {
            throw new IllegalStateException("The mod BedBenefits has already been loaded!");
        }
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