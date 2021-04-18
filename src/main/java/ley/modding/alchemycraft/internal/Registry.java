package ley.modding.alchemycraft.internal;

import cpw.mods.fml.common.registry.GameRegistry;
import ley.modding.alchemycraft.Alchemycraft;
import ley.modding.tileralib.api.IIngredient;
import ley.modding.tileralib.api.IRegistry;
import ley.modding.tileralib.api.ITEProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.*;

public class Registry implements IRegistry {

    Map<String, Item> items;
    Map<String, Block> blocks;

    public Registry() {
        items = new HashMap<String, Item>();
        blocks = new HashMap<String, Block>();
    }

    @Override
    public String getModID() {
        return Alchemycraft.MODID;
    }

    @Override
    public Item getItem(String id) {
        if (items.containsKey(id)) {
            return items.get(id);
        }
        return GameRegistry.findItem(getModID(), id);
    }

    @Override
    public Block getBlock(String id) {
        if (blocks.containsKey(id)) {
            return blocks.get(id);
        }
        return GameRegistry.findBlock(getModID(), id);
    }

    @Override
    public void addShapedRecipe(ItemStack output, String[] pattern, IIngredient[] ingredients) {
        List<Object> objects = new ArrayList<Object>(Arrays.asList(pattern));
        for (IIngredient i : ingredients) {
            objects.add(i.getKey());
            objects.add(i.getIngredient());
        }
        GameRegistry.addShapedRecipe(output, objects.toArray());
    }

    @Override
    public void addShapelessRecipe(ItemStack output, IIngredient[] input) {
        List<Object> objects = new ArrayList<Object>();
        for (IIngredient ing : input) {
            for (int i = 0; i < ing.getCount(); i++) {
                objects.add(ing.getIngredient());
            }
        }
        GameRegistry.addShapelessRecipe(output, objects.toArray());
    }

    @Override
    public Item registerItem(Item item) {
        if (item != null) {
            String id = item.getUnlocalizedName().toLowerCase().split("\\.")[1];
            items.put(id, item);
            GameRegistry.registerItem(item, id, getModID());
            return item;
        }
        return null;
    }

    @Override
    public Block registerBlock(Block block) {
        if (block != null) {
            String id = block.getUnlocalizedName().toLowerCase().split("\\.")[1];
            blocks.put(id, block);
            GameRegistry.registerBlock(block, id);
            if (block instanceof ITEProvider) {
                GameRegistry.registerTileEntity(((ITEProvider) block).getTEClass(),id);
            }
            return block;
        }
        return null;
    }

}
