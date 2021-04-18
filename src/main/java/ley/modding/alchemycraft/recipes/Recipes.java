package ley.modding.alchemycraft.recipes;

import ley.modding.alchemycraft.internal.ItemIngredient;
import ley.modding.alchemycraft.internal.StackIngredient;
import ley.modding.alchemycraft.items.ACItems;
import ley.modding.tileralib.api.IIngredient;
import ley.modding.tileralib.api.IRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Recipes {

    public static void loadRecipes(IRegistry reg) {

        reg.addShapelessRecipe(new ItemStack(ACItems.element, 1, 40), new IIngredient[] {new ItemIngredient(1, ACItems.alchemydust), new ItemIngredient(1, ACItems.firedust)});
        reg.addShapelessRecipe(new ItemStack(ACItems.element, 1, 97), new IIngredient[] {new ItemIngredient(1, ACItems.alchemydust), new ItemIngredient(1, ACItems.waterdust)});
        reg.addShapelessRecipe(new ItemStack(ACItems.element, 1, 107), new IIngredient[] {new ItemIngredient(1, ACItems.alchemydust), new ItemIngredient(1, ACItems.earthdust)});
        reg.addShapelessRecipe(new ItemStack(ACItems.element, 1, 27), new IIngredient[] {new ItemIngredient(1, ACItems.alchemydust), new ItemIngredient(1, ACItems.airdust)});

        reg.addShapelessRecipe(new ItemStack(Items.lava_bucket), new IIngredient[] {new ItemIngredient(1, Items.bucket), new StackIngredient(new ItemStack(ACItems.element, 1, 51))});
        reg.addShapelessRecipe(new ItemStack(Items.water_bucket), new IIngredient[] {new ItemIngredient(1, Items.bucket), new StackIngredient(new ItemStack(ACItems.element, 1, 97))});
        reg.addShapelessRecipe(new ItemStack(Blocks.dirt), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 1, 107))});
        reg.addShapelessRecipe(new ItemStack(Blocks.sand), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 1, 92))});
        reg.addShapelessRecipe(new ItemStack(Blocks.glass), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 1, 109))});
        reg.addShapelessRecipe(new ItemStack(Blocks.log), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 1, 55))});
        reg.addShapelessRecipe(new ItemStack(Blocks.clay), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 1, 34))});
        reg.addShapelessRecipe(new ItemStack(Blocks.ice), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 1, 288))});
        reg.addShapelessRecipe(new ItemStack(Blocks.cactus), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 1, 236))});
        reg.addShapelessRecipe(new ItemStack(Items.diamond), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 9, 153))});
        reg.addShapelessRecipe(new ItemStack(Items.egg), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 1, 117))});
        reg.addShapelessRecipe(new ItemStack(Items.gold_ingot), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 9, 356))});
        reg.addShapelessRecipe(new ItemStack(Items.feather), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 1, 118))});
        reg.addShapelessRecipe(new ItemStack(Items.paper), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 1, 124))});
        reg.addShapelessRecipe(new ItemStack(Items.book), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 1, 126))});
        reg.addShapelessRecipe(new ItemStack(Items.clock), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 1, 326))});
        reg.addShapelessRecipe(new ItemStack(Items.boat), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 1, 67))});
        reg.addShapelessRecipe(new ItemStack(Blocks.sapling), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 1, 41))});
        reg.addShapelessRecipe(new ItemStack(Items.wheat_seeds), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 1, 31))});
        reg.addShapelessRecipe(new ItemStack(Items.gunpowder), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 1, 22))});
        reg.addShapelessRecipe(new ItemStack(Items.coal), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 1, 32))});
        reg.addShapelessRecipe(new ItemStack(Items.sugar), new IIngredient[] {new StackIngredient(new ItemStack(ACItems.element, 1, 42))});

    }

}
