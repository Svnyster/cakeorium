package com.svnyster.cakeorium;

import com.svnyster.cakeorium.item.ModItems;
import com.svnyster.cakeorium.proxy.CommonProxy;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Level;

@Mod(modid = Cakeorium.MODID, name = "Cakeorium", version = Cakeorium.VERSION, useMetadata = true, updateJSON = "https://github.com/Svnyster/cakeorium/versions.json")
public class Cakeorium {
    public static final String MODID = "cakeorium";
    public static final String NAME = "Cakeorium";
    public static final String VERSION = "1.10.2-0.0.1.0";

    public static final Item.ToolMaterial cakeoriumToolMaterial = EnumHelper.addToolMaterial("CAKEORIUM", 1, 131, 4.0F, 1.0F, 5);

    @Mod.Instance(MODID)
    public static Cakeorium instance;

    @SidedProxy(serverSide = "com.svnyster.cakeorium.proxy.CommonProxy", clientSide = "com.svnyster.cakeorium.proxy.ClientProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        FMLLog.log(NAME, Level.INFO, NAME + " is loading...");
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
