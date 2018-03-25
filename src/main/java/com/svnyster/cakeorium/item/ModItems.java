package com.svnyster.cakeorium.item;

import com.svnyster.cakeorium.Cakeorium;
import com.svnyster.cakeorium.item.tool.ItemEdibleAxe;
import com.svnyster.cakeorium.item.tool.ItemEdiblePickaxe;
import com.svnyster.cakeorium.item.tool.ItemEdibleSpade;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
    public static ItemBase cakeorium_ingot;
    public static ItemEdibleAxe cakeorium_axe;
    public static ItemEdibleHoe cakeorium_hoe;
    public static ItemEdiblePickaxe cakeorium_pickaxe;
    public static ItemEdibleSpade cakeorium_shovel;
    public static ItemEdibleSword cakeorium_sword;

    public static void init() {
        cakeorium_axe = register(new ItemEdibleAxe("cakeorium_axe", 2, 0.4F, 8, Cakeorium.cakeoriumToolMaterial, 8.0F, -3.2F));
        cakeorium_hoe = register(new ItemEdibleHoe("cakeorium_hoe", 2, 0.4F, 8, Cakeorium.cakeoriumToolMaterial));
        cakeorium_ingot = register(new ItemBase("cakeorium_ingot").setCreativeTab(CreativeTabs.MATERIALS));
        cakeorium_pickaxe = register(new ItemEdiblePickaxe("cakeorium_pickaxe", 2, 0.4F, 8, Cakeorium.cakeoriumToolMaterial));
        cakeorium_shovel = register(new ItemEdibleSpade("cakeorium_shovel", 2, 0.4F, 8, Cakeorium.cakeoriumToolMaterial));
        cakeorium_sword = register(new ItemEdibleSword("cakeorium_sword", 2, 0.4F, 8, Cakeorium.cakeoriumToolMaterial));
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemModelProvider) {
            ((ItemModelProvider) item).registerItemModel(item);
        }

        return item;
    }
}
