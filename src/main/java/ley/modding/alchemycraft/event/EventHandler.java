package ley.modding.alchemycraft.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ley.modding.alchemycraft.items.ItemElement;
import net.minecraftforge.event.entity.item.ItemTossEvent;

public class EventHandler {

    @SubscribeEvent
    public void onItemDrop(ItemTossEvent event) {
        if (event.entityItem.getEntityItem().getItem() instanceof ItemElement) {
            event.entityItem.age = 200;
        }
    }

}
