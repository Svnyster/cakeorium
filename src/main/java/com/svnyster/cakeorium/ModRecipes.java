package com.svnyster.cakeorium;

import com.svnyster.cakeorium.item.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
    public static void init() {
        GameRegistry.addSmelting(Items.CAKE, new ItemStack(ModItems.cakeorium_ingot), 0.2F);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cakeorium_axe), "CC", "CS", " S", 'C', ModItems.cakeorium_ingot, 'S', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cakeorium_hoe), "CC", " S", " S", 'C', ModItems.cakeorium_ingot, 'S', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cakeorium_pickaxe), "CCC", " S ", " S ", 'C', ModItems.cakeorium_ingot, 'S', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cakeorium_shovel), "C", "S", "S", 'C', ModItems.cakeorium_ingot, 'S', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cakeorium_sword), "C", "C", "S", 'C', ModItems.cakeorium_ingot, 'S', Items.STICK);
    }
}
