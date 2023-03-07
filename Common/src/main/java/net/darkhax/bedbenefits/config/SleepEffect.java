package net.darkhax.bedbenefits.config;

import com.google.gson.annotations.Expose;
import net.darkhax.bedbenefits.Constants;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.food.FoodData;

public class SleepEffect {

    @Expose
    public int requiredFoodAmount = 0;

    public boolean canApply(ServerPlayer player) {

        return player.getFoodData().getFoodLevel() >= this.requiredFoodAmount;
    }

    public void apply(ServerPlayer player) {

        if (this.requiredFoodAmount > 0) {

            final float saturation = player.getFoodData().getSaturationLevel();
            final int food = player.getFoodData().getFoodLevel() - this.requiredFoodAmount;
            
            player.getFoodData().setFoodLevel(food);

            // Prevent saturation level being higher than food level.
            if (saturation > food) {
                player.getFoodData().setSaturation(food);
            }
        }
    }
}
