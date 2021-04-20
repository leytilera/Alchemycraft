package ley.modding.alchemycraft.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import ley.modding.alchemycraft.block.ACBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class OreGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.dimensionId == 0) {
            generateSurface(world, random, chunkX * 16, chunkZ * 16, ACBlocks.alchemyore);
            generateSurface(world, random, chunkX * 16, chunkZ * 16, ACBlocks.fireore);
            generateSurface(world, random, chunkX * 16, chunkZ * 16, ACBlocks.waterore);
            generateSurface(world, random, chunkX * 16, chunkZ * 16, ACBlocks.earthore);
            generateSurface(world, random, chunkX * 16, chunkZ * 16, ACBlocks.airore);
        }
    }

    private void generateSurface(World world, Random random, int blockX, int blockZ, Block block) {
        for (int k = 0; k < 16; k++) {
            int randPosX = blockX + random.nextInt(16);
            int randPosY = random.nextInt(64);
            int randPosZ = blockZ + random.nextInt(16);
            (new WorldGenMinable(block, 4)).generate(world, random, randPosX, randPosY, randPosZ);
        }
    }

}
