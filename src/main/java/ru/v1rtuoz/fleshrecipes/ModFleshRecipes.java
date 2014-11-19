package ru.v1rtuoz.fleshrecipes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.v1rtuoz.fleshrecipes.client.ItemFertilizer;

@Mod(modid = ModFleshRecipes.MODID, version = ModFleshRecipes.VERSION, canBeDeactivated = false)
public class ModFleshRecipes
{
    public static final String MODID = "ru.v1rtuoz.fleshrecipes";
    public static final String PREFIX = "fleshrecipes:";
    public static final String VERSION = "1.0";

    public static final Item fertilizer = new ItemFertilizer();


    @Mod.Instance("ModFleshRecipes")
    public static ModFleshRecipes instance;

    @SidedProxy(clientSide = "ru.v1rtuoz.fleshrecipes.client.ClientProxy", serverSide = "ru.v1rtuoz.fleshrecipes.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("Hello from v1rtuoz");
    }

    @EventHandler
    public void load (FMLInitializationEvent event) {
        Block b;
        GameRegistry.registerItem(fertilizer, fertilizer.getUnlocalizedName());
        GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.coal, 1, 1), 1);
        GameRegistry.addRecipe(new ItemStack(fertilizer),
                "rr",
                "rr",
                'r', Items.rotten_flesh);


    }
}
