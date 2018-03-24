package com.svnyster.cakeorium.item.tool;

import com.svnyster.cakeorium.item.ItemBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemEdible extends ItemBase {
    /**
     * The amount this food item heals the player.
     */
    private final int healAmount;
    private final float saturationModifier;
    /**
     * Number of ticks to run while 'EnumAction'ing until result.
     */
    private final int initialItemUseDuration;
    private int itemUseDuration;
    /**
     * If this field is true, the food can be consumed even if the player don't need to eat.
     */
    private boolean alwaysEdible;
    /**
     * represents the potion effect that will occurr upon eating this food. Set by setPotionEffect
     */
    private PotionEffect potionId;
    /**
     * probably of the set potion effect occurring
     */
    private float potionEffectProbability;

    ItemEdible(String name, int amount, float saturation, int duration) {
        super(name);
        this.initialItemUseDuration = duration;
        this.itemUseDuration = duration;
        this.healAmount = amount;
        this.saturationModifier = saturation;

    }

    public ItemEdible(ToolMaterial material, String name, int amount) {
        this(name, amount, 0.6F, 32);
    }

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        stack.damageItem(2, entityLiving);

        if (entityLiving instanceof EntityPlayer) {
            EntityPlayer entityplayer = (EntityPlayer) entityLiving;
            entityplayer.getFoodStats().addStats(this.healAmount, this.saturationModifier);
            worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.getObjectUseStats(this));
        }

        return stack;
    }

    private void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if (!worldIn.isRemote && this.potionId != null && worldIn.rand.nextFloat() < this.potionEffectProbability) {
            player.addPotionEffect(new PotionEffect(this.potionId));
        }
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack) {
        return this.itemUseDuration;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.EAT;
    }

    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        if (playerIn.canEat(this.alwaysEdible)) {
            playerIn.setActiveHand(hand);
            this.itemUseDuration = this.initialItemUseDuration;
            return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
        } else {
            this.itemUseDuration = 0;
            return new ActionResult(EnumActionResult.PASS, itemStackIn);
        }
    }

    public int getHealAmount(ItemStack stack) {
        return this.healAmount;
    }

    public float getSaturationModifier(ItemStack stack) {
        return this.saturationModifier;
    }

    public ItemEdible setPotionEffect(PotionEffect p_185070_1_, float p_185070_2_) {
        this.potionId = p_185070_1_;
        this.potionEffectProbability = p_185070_2_;
        return this;
    }

    /**
     * Set the field 'alwaysEdible' to true, and make the food edible even if the player don't need to eat.
     */
    public ItemEdible setAlwaysEdible() {
        this.alwaysEdible = true;
        return this;
    }
}
