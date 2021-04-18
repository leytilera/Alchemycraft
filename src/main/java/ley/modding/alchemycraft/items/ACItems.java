package ley.modding.alchemycraft.items;

import ley.modding.tileralib.api.IRegistry;
import net.minecraft.item.Item;

public class ACItems {

    public static Item element;

    public static void register(IRegistry reg) {

        element = reg.registerItem(new ItemElement());

    }

}
