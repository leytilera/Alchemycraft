package ley.modding.alchemycraft.internal;

import ley.modding.tileralib.api.IIngredient;
import net.minecraft.item.ItemStack;

public class StackIngredient implements IIngredient {

    ItemStack stack;
    char key;

    public StackIngredient(ItemStack stack, char key) {
        this.stack = stack;
        this.key = key;
    }

    public StackIngredient(ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public char getKey() {
        return key;
    }

    @Override
    public int getCount() {
        return stack.stackSize;
    }

    @Override
    public Object getIngredient() {
        return stack;
    }
}
