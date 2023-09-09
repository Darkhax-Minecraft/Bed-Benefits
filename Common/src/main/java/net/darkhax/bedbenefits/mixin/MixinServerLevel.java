package net.darkhax.bedbenefits.mixin;

import net.darkhax.bedbenefits.BedBenefitsCommon;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ServerLevel.class)
public class MixinServerLevel {

    @Shadow
    private List<ServerPlayer> players;

    @Inject(method = "wakeUpAllPlayers()V", at = @At("HEAD"))
    private void onPlayersWakeUp(CallbackInfo cbi) {

        this.players.stream().filter(LivingEntity::isSleeping).forEach(BedBenefitsCommon::onPlayerWakeUp);
    }
}
