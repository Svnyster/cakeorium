package com.svnyster.cakeorium.fluid;

import com.svnyster.cakeorium.Cakeorium;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidBase extends Fluid {
    private final int fluidColor;

    public FluidBase(String name, ResourceLocation still, ResourceLocation flowing, int color) {
        super(name, still, flowing);
        this.fluidColor = color;
        setUnlocalizedName(name);
    }

    public FluidBase(String name, ResourceLocation still, ResourceLocation flowing) {
        this(name, still, flowing, 0xFFFFFFFF);
    }

    public FluidBase(String name, int color) {
        this(name, new ResourceLocation(Cakeorium.MODID, "blocks/fluids/molten_metal"), new ResourceLocation(Cakeorium.MODID, "blocks/fluids/molten_metal_flow"), color);
    }

    public FluidBase(String name) {
        this(name, new ResourceLocation(Cakeorium.MODID, "blocks/fluids/molten_metal"), new ResourceLocation(Cakeorium.MODID, "blocks/fluids/molten_metal_flow"), 0xFFFFFFFF);
    }

    @Override
    public int getColor() {
        return fluidColor;
    }
}
