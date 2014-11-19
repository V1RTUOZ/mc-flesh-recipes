package ru.v1rtuoz.fleshrecipes.client;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.v1rtuoz.fleshrecipes.ModFleshRecipes;


public class ItemFertilizer extends Item {
    public static final String NAME = "fertilizer";

    public ItemFertilizer() {
        setUnlocalizedName(NAME);
        setCreativeTab(CreativeTabs.tabMaterials);
        setMaxStackSize(64);
        setTextureName(ModFleshRecipes.PREFIX + NAME);
    }

    /**
     * Returns true if the item can be used on the given entity, e.g. shears on sheep.
     *
     * @param itemStack
     * @param player
     * @param target
     */
    @Override
    public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase target) {
        if (!target.worldObj.isRemote) {
            if (target instanceof EntityCreeper) {
                EntityCreeper creeper = (EntityCreeper) target;
                creeper.motionY = 1.5D;
                creeper.motionX = -1 + Math.random() * 2;
                creeper.motionZ = -1+ Math.random() * 2;
            }
        }
        return false;
        //return super.itemInteractionForEntity(itemStack, player, target);
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     *
     * @param itemStack
     * @param player
     * @param world
     * @param x
     * @param y
     * @param z
     * @param p_77648_7_
     * @param p_77648_8_
     * @param p_77648_9_
     * @param p_77648_10_
     */
    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (!player.canPlayerEdit(x, y, z, p_77648_7_, itemStack))
        {
            return false;
        }
        else {
            if (ItemDye.applyBonemeal(itemStack, world, x, y, z, player)) {
                if (!world.isRemote) {
                    world.playAuxSFX(2005, x, y, z, 0);
                }

                return true;
            }
        }
        return super.onItemUse(itemStack, player, world, x, y, z, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
    }
}
