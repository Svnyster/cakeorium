package com.svnyster.cakeorium;

import com.svnyster.cakeorium.item.ModItems;
import com.svnyster.cakeorium.proxy.CommonProxy;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Cakeorium.MODID, version = Cakeorium.VERSION, useMetadata = true, updateJSON = "https://github.com/Svnyster/cakeorium/versions.json")
public class Cakeorium {
    public static final String MODID = "cakeorium";
    public static final String NAME = "Cakeorium";
    public static final String VERSION = "0.1.0.0";

    public static final Item.ToolMaterial cakeoriumToolMaterial = EnumHelper.addToolMaterial("CAKEORIUM", 2, 250, 6.0F, 2.0F, 14);

    @Mod.Instance(MODID)
    public static Cakeorium instance;

    @SidedProxy(serverSide = "com.svnyster.cakeorium.proxy.CommonProxy", clientSide = "com.svnyster.cakeorium.proxy.ClientProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println(NAME + " is loading...");
        ModItems.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModRecipes.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
