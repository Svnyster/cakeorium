package com.svnyster.cakeorium.integration.tconstruct;

import com.svnyster.cakeorium.fluid.ModFluids;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInterModComms;

public class SmelteryIntegration {

    public static void preInit() {
        registerFluid(ModFluids.moltenCakeorium, "Cakeorium");
    }

    private static void registerFluid(Fluid fluid, String oreSuffix) {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("fluid", fluid.getName());
        tag.setString("ore", oreSuffix);
        tag.setBoolean("toolforge", false);
        FMLInterModComms.sendMessage("tconstruct", "integrateSmeltery", tag);
    }
}
