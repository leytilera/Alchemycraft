package ley.modding.alchemycraft.items;

import ley.modding.alchemycraft.Alchemycraft;
import ley.modding.alchemycraft.alchemy.Element;
import ley.modding.alchemycraft.alchemy.ElementManager;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemElement extends Item {

    static IIcon[] icons;

    public ItemElement() {
        setUnlocalizedName("element");
        setTextureName(Alchemycraft.MODID + ":" + "element");
        setHasSubtypes(true);
        setCreativeTab(Alchemycraft.tab);
    }

    @Override
    public IIcon getIconFromDamage(int meta) {
        if (meta < 0 || meta >= icons.length) {
            return itemIcon;
        }
        return icons[meta];
    }

    @Override
    public void registerIcons(IIconRegister reg) {
        icons = new IIcon[ElementManager.elements.size()];
        for (Element e : ElementManager.elements) {
            icons[e.num] = reg.registerIcon(Alchemycraft.MODID + ":" + e.texture);
        }
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (Element e : ElementManager.elements) {
            list.add(new ItemStack(this, 1, e.num));
        }
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        if (stack.getItemDamage() < 0 || stack.getItemDamage() >= ElementManager.elements.size())
            return super.getItemStackDisplayName(stack);
        return ElementManager.elements.get(stack.getItemDamage()).name;
    }

    @Override
    public boolean onEntityItemUpdate(EntityItem entity) {
        if (!entity.worldObj.isRemote && entity.age > 200) {

            AxisAlignedBB region = AxisAlignedBB.getBoundingBox(entity.posX - 1, entity.posY - 1, entity.posZ - 1, entity.posX + 1, entity.posY + 1, entity.posZ + 1);
            List<Entity> list = entity.worldObj.getEntitiesWithinAABBExcludingEntity(entity, region);
            for (Entity e : list) {
                if (e instanceof EntityItem && !e.isDead) {
                    EntityItem ei = (EntityItem) e;
                    if (ei.getEntityItem().getItem() instanceof ItemElement) {
                        Element e1 = getElementFromStack(entity.getEntityItem());
                        Element e2 = getElementFromStack(ei.getEntityItem());

                        List<Element> res = ElementManager.combine(e1, e2);

                        if (res.size() == 2 && res.contains(e1) && res.contains(e2)) {
                            continue;
                        }

                        entity.getEntityItem().stackSize--;
                        ei.getEntityItem().stackSize--;

                        if (entity.getEntityItem().stackSize <= 0) {
                            entity.setDead();
                        }
                        if (ei.getEntityItem().stackSize <= 0) {
                            ei.setDead();
                        }

                        for (Element el : res) {
                            ItemStack element = new ItemStack(this, 1, el.num);
                            EntityItem ent = new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, element);
                            entity.worldObj.spawnEntityInWorld(ent);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    Element getElementFromStack(ItemStack stack) {
        if (stack.getItem() instanceof ItemElement) {
            int meta = stack.getItemDamage();
            if (meta >= 0 && meta < ElementManager.elements.size()) {
                return ElementManager.elements.get(meta);
            }
        }
        return null;
    }

}
