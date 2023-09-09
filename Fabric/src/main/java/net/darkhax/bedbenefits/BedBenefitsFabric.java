package net.darkhax.bedbenefits;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class BedBenefitsFabric implements ModInitializer {

    @Override
    public void onInitialize() {

        BedBenefitsCommon.init(FabricLoader.getInstance().getConfigDir());
    }
}