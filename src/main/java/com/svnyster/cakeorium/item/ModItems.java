package com.svnyster.cakeorium.item;

import com.svnyster.cakeorium.Cakeorium;
import com.svnyster.cakeorium.item.tool.ItemEdibleAxe;
import com.svnyster.cakeorium.item.tool.ItemEdiblePickaxe;
import com.svnyster.cakeorium.item.tool.ItemEdibleSpade;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
    public static ItemBase cakeoriumIngot;
    public static ItemEdibleAxe cakeoriumAxe;
    public static ItemEdibleHoe cakeoriumHoe;
    public static ItemEdiblePickaxe cakeoriumPickaxe;
    public static ItemEdibleSpade cakeoriumShovel;
    public static ItemEdibleSword cakeoriumSword;

    public static void preInit() {
        cakeoriumIngot = register(new ItemOre("cakeoriumIngot", "ingotCakeorium").setCreativeTab(CreativeTabs.MATERIALS));

        cakeoriumAxe = register(new ItemEdibleAxe("cakeoriumAxe", 2, 0.4F, 8, Cakeorium.cakeoriumToolMaterial, 8.0F, -3.2F));
        cakeoriumHoe = register(new ItemEdibleHoe("cakeoriumHoe", 2, 0.4F, 8, Cakeorium.cakeoriumToolMaterial));
        cakeoriumPickaxe = register(new ItemEdiblePickaxe("cakeoriumPickaxe", 2, 0.4F, 8, Cakeorium.cakeoriumToolMaterial));
        cakeoriumShovel = register(new ItemEdibleSpade("cakeoriumShovel", 2, 0.4F, 8, Cakeorium.cakeoriumToolMaterial));
        cakeoriumSword = register(new ItemEdibleSword("cakeoriumSword", 2, 0.4F, 8, Cakeorium.cakeoriumToolMaterial));
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemModelProvider) {
            ((ItemModelProvider) item).registerItemModel(item);
        }
        if (item instanceof ItemOreDict) {
            ((ItemOreDict) item).initOreDict();
        }

        return item;
    }
}
