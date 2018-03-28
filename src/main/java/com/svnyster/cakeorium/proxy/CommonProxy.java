package com.svnyster.cakeorium.proxy;

import com.svnyster.cakeorium.Cakeorium;
import com.svnyster.cakeorium.fluid.ModFluids;
import com.svnyster.cakeorium.integration.ModIntegration;
import com.svnyster.cakeorium.item.ModItems;
import com.svnyster.cakeorium.recipe.ModRecipes;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Level;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        FMLLog.log(Cakeorium.NAME, Level.INFO, Cakeorium.NAME + " is loading...");
        ModItems.preInit();
        ModFluids.preInit();
        ModIntegration.preInit();
    }

    public void init(FMLInitializationEvent event) {
        ModRecipes.init();
    }

    public void postInit(FMLPostInitializationEvent event) {
        FMLLog.log(Cakeorium.NAME, Level.INFO, Cakeorium.NAME + " loaded successfully!");
    }

    public void registerItemRenderer(Item item, int meta, String id) {

    }

    public void registerBlockFluidClassicRenderer(BlockFluidClassic item) {

    }
}
