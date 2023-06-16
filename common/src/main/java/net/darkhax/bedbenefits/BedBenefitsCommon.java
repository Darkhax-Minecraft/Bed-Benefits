package net.darkhax.bedbenefits;

import net.darkhax.bedbenefits.config.Config;
import net.darkhax.bookshelf.api.Services;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public class BedBenefitsCommon {

    private final Config config;

    public BedBenefitsCommon() {

        this.config = Config.load();
        Services.EVENTS.addPlayerWakeUpListener(this::onPlayerWakeUp);
    }

    private void onPlayerWakeUp(Player player) {

        if (player instanceof ServerPlayer serverPlayer) {

            if (config.restoreHealth.canApply(serverPlayer)) {

                config.restoreHealth.apply(serverPlayer);
            }

            if (config.sleepOffEffects.canApply(serverPlayer)) {

                config.sleepOffEffects.apply(serverPlayer);
            }
        }
    }
}