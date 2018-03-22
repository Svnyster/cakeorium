package com.svnyster.cakeorium;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Cakeorium.MODID, version = Cakeorium.VERSION, useMetadata = true)
public class Cakeorium
{
    public static final String MODID = "cakeorium";
    public static final String VERSION = "0.1.0.0";

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }
}
