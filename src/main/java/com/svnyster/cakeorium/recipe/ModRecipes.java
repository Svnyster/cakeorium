package com.svnyster.cakeorium.recipe;

import com.svnyster.cakeorium.item.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
    public static void init() {
        //GameRegistry.addSmelting(Items.CAKE, new ItemStack(ModItems.cakeoriumIngot), 0.2F);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cakeoriumIngot), Items.IRON_INGOT, Items.CAKE);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cakeoriumAxe), "CC", "CS", " S", 'C', ModItems.cakeoriumIngot, 'S', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cakeoriumHoe), "CC", " S", " S", 'C', ModItems.cakeoriumIngot, 'S', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cakeoriumPickaxe), "CCC", " S ", " S ", 'C', ModItems.cakeoriumIngot, 'S', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cakeoriumShovel), "C", "S", "S", 'C', ModItems.cakeoriumIngot, 'S', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cakeoriumSword), "C", "C", "S", 'C', ModItems.cakeoriumIngot, 'S', Items.STICK);
    }
}
