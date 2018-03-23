package com.svnyster.cakeorium;

import com.svnyster.cakeorium.item.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
    public static void init() {
        GameRegistry.addSmelting(Items.CAKE, new ItemStack(ModItems.ingotCakeorium), 0.2F);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cakeoriumSword), "C", "C", "S", 'C', ModItems.ingotCakeorium, 'S', Items.STICK);
    }
}
