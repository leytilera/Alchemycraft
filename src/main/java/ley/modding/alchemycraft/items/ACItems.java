package ley.modding.alchemycraft.items;

import ley.modding.tileralib.api.IRegistry;
import net.minecraft.item.Item;

public class ACItems {

    public static Item element;
    public static Item alchemydust;
    public static Item firedust;
    public static Item waterdust;
    public static Item earthdust;
    public static Item airdust;

    public static void register(IRegistry reg) {

        alchemydust = reg.registerItem(new ItemDust("alchemy"));
        firedust = reg.registerItem(new ItemDust("fire"));
        waterdust = reg.registerItem(new ItemDust("water"));
        earthdust = reg.registerItem(new ItemDust("earth"));
        airdust = reg.registerItem(new ItemDust("air"));
        element = reg.registerItem(new ItemElement());

    }

}
