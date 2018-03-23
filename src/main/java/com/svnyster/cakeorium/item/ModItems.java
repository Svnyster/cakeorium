package com.svnyster.cakeorium.item;

import com.svnyster.cakeorium.Cakeorium;
import com.svnyster.cakeorium.item.tool.ItemEdible;
import com.svnyster.cakeorium.item.tool.ItemEdibleSword;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
    public static ItemBase ingotCakeorium;
    public static ItemEdible cakeoriumSword;

    public static void init() {
        ingotCakeorium = register(new ItemBase("ingotCakeorium").setCreativeTab(CreativeTabs.MATERIALS));
        cakeoriumSword = register(new ItemEdible(Cakeorium.cakeoriumToolMaterial, "cakeoriumSword", 3, 0.6F, false));
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemModelProvider) {
            ((ItemModelProvider)item).registerItemModel(item);
        }

        return item;
    }
}
