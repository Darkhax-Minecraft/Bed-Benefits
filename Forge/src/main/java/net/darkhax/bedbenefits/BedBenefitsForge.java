package net.darkhax.bedbenefits;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(Constants.MOD_ID)
public class BedBenefitsForge {

    public BedBenefitsForge() {

        BedBenefitsCommon.init(FMLPaths.CONFIGDIR.get());
    }
}