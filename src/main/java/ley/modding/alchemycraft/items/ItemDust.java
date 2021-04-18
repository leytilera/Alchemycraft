package ley.modding.alchemycraft.items;

import ley.modding.alchemycraft.Alchemycraft;
import net.minecraft.item.Item;

public class ItemDust extends Item {

    public ItemDust(String id) {
        setUnlocalizedName(id);
        setTextureName(Alchemycraft.MODID + ":" + id);
        setCreativeTab(Alchemycraft.tab);
    }

}
