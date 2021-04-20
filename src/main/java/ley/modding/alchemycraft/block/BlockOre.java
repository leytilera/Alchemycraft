package ley.modding.alchemycraft.block;

import ley.modding.alchemycraft.Alchemycraft;
import ley.modding.alchemycraft.items.ACItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockOre extends Block {

    static IIcon alchemy;
    static IIcon fire;
    static IIcon water;
    static IIcon earth;
    static IIcon air;

    Type type;

    protected BlockOre(Type type) {
        super(Material.rock);
        this.type = type;
        setBlockName(type + "ore");
        setHardness(1.0F);
        setResistance(5.0F);
        setStepSound(soundTypeStone);
        setCreativeTab(Alchemycraft.tab);
    }

    @Override
    public int quantityDropped(Random rand) {
        return rand.nextInt(3) + 2;
    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        alchemy = reg.registerIcon(Alchemycraft.MODID + ":alchemyore");
        fire = reg.registerIcon(Alchemycraft.MODID + ":fireore");
        water = reg.registerIcon(Alchemycraft.MODID + ":waterore");
        earth = reg.registerIcon(Alchemycraft.MODID + ":earthore");
        air = reg.registerIcon(Alchemycraft.MODID + ":airore");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        switch (type) {
            case FIRE: return fire;
            case WATER: return water;
            case EARTH: return earth;
            case AIR: return air;
            default: return alchemy;
        }
    }

    @Override
    protected boolean canSilkHarvest() {
        return false;
    }

    @Override
    public Item getItemDropped(int meta, Random rand, int par3) {
        switch (type) {
            case FIRE: return ACItems.firedust;
            case WATER: return ACItems.waterdust;
            case EARTH: return ACItems.earthdust;
            case AIR: return ACItems.airdust;
            default: return ACItems.alchemydust;
        }
    }

    @Override
    public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
        super.onBlockPlacedBy(p_149689_1_, p_149689_2_, p_149689_3_, p_149689_4_, p_149689_5_, p_149689_6_);
    }

    public enum Type {
        ALCHEMY,
        FIRE,
        WATER,
        EARTH,
        AIR;


        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

}
