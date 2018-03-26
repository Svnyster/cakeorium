package com.svnyster.cakeorium.integration;

import com.svnyster.cakeorium.integration.tconstruct.SmelteryIntegration;
import net.minecraftforge.fml.common.Loader;

public class ModIntegration {
    public static void preInit() {
        // Tinkers' Construct
        if(Loader.isModLoaded("tconstruct")) {
            SmelteryIntegration.preInit();
        }
    }
}
