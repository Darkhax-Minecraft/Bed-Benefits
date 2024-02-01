package net.darkhax.bedbenefits;

import net.fabricmc.api.ModInitializer;

public class BedBenefitsFabric implements ModInitializer {

    @Override
    public void onInitialize() {

        BedBenefitsCommon.init();
    }
}