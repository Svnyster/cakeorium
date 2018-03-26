package com.svnyster.cakeorium.proxy;

import com.svnyster.cakeorium.Cakeorium;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;

import static net.minecraft.block.BlockLiquid.LEVEL;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Cakeorium.MODID + ":" + id, "inventory"));
    }
}
