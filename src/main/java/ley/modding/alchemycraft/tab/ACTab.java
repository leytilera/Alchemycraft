package ley.modding.alchemycraft.tab;

import ley.modding.alchemycraft.items.ACItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ACTab extends CreativeTabs {

    public ACTab() {
        super("Alchemycraft");
    }

    @Override
    public Item getTabIconItem() {
        return ACItems.alchemydust;
    }
}
