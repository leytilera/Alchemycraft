package ley.modding.alchemycraft.block;

import ley.modding.tileralib.api.IRegistry;
import net.minecraft.block.Block;

public class ACBlocks {

    public static Block alchemyore;
    public static Block fireore;
    public static Block waterore;
    public static Block earthore;
    public static Block airore;

    public static void register(IRegistry reg) {

        alchemyore = reg.registerBlock(new BlockOre(BlockOre.Type.ALCHEMY));
        fireore = reg.registerBlock(new BlockOre(BlockOre.Type.FIRE));
        waterore = reg.registerBlock(new BlockOre(BlockOre.Type.WATER));
        earthore = reg.registerBlock(new BlockOre(BlockOre.Type.EARTH));
        airore = reg.registerBlock(new BlockOre(BlockOre.Type.AIR));

    }

}
