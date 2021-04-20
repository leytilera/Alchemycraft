package ley.modding.alchemycraft;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import ley.modding.alchemycraft.alchemy.ElementManager;
import ley.modding.alchemycraft.block.ACBlocks;
import ley.modding.alchemycraft.event.EventHandler;
import ley.modding.alchemycraft.internal.Registry;
import ley.modding.alchemycraft.items.ACItems;
import ley.modding.alchemycraft.recipes.Recipes;
import ley.modding.alchemycraft.tab.ACTab;
import ley.modding.alchemycraft.worldgen.OreGen;
import ley.modding.tileralib.api.IRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Alchemycraft.MODID, name = Alchemycraft.NAME, version = Alchemycraft.VERSION)
public class Alchemycraft {

    public static final String MODID = "alchemycraft";
    public static final String NAME = "Alchemycraft";
    public static final String VERSION = "1.0";

    public static CreativeTabs tab = new ACTab();


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        try {
            ElementManager.loadElements();
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        IRegistry registry = new Registry();

        ACItems.register(registry);
        ACBlocks.register(registry);
        Recipes.loadRecipes(registry);

        GameRegistry.registerWorldGenerator(new OreGen(), 2);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    }


}
