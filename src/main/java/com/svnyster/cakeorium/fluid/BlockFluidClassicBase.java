package com.svnyster.cakeorium.fluid;

import com.svnyster.cakeorium.Cakeorium;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFluidClassicBase extends BlockFluidClassic {
    protected String name;
    public BlockFluidClassicBase(String name, Fluid fluid, Material material)
    {
        super(fluid, material);
        this.name = name;
        ResourceLocation location = new ResourceLocation(Cakeorium.MODID, name);
        setRegistryName(location);
        setUnlocalizedName(location.toString());
    }

    @Override
    public BlockFluidClassicBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    @SideOnly(Side.CLIENT)
    void render() {
        final ModelResourceLocation fluidModelLocation = new ModelResourceLocation(
                Cakeorium.MODID + ":" + this.name, "fluid");
        ModelLoader.setCustomStateMapper(this, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return fluidModelLocation;
            }
        });    }
}
