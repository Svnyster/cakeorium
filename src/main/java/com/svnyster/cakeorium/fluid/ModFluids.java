package com.svnyster.cakeorium.fluid;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static net.minecraft.block.BlockLiquid.LEVEL;

public class ModFluids {
    public static FluidBase moltenCakeorium;
    public static BlockFluidClassicBase moltenBlockCakeorium;

    public static void preInit() {
        moltenCakeorium = register(new FluidBase("cakeorium", 0xFF97491A));
        moltenBlockCakeorium = register(new BlockFluidClassicBase("moltenCakeorium", moltenCakeorium, Material.LAVA));

    }

    public static void renderFluids() {
        moltenBlockCakeorium.render();
    }

    private static <T extends Fluid> T register(T fluid) {
        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);

        return fluid;
    }

    private static <T extends BlockFluidClassic> T register(T blockFluid) {
        GameRegistry.register(blockFluid);
        return blockFluid;
    }
}
