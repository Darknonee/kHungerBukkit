package me.Girardcome.HG.Managers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftingManager
{
  @SuppressWarnings("deprecation")
public static void Recipes()
  {
    ItemStack item = new ItemStack(Material.MUSHROOM_SOUP);
    ShapelessRecipe recipe = new ShapelessRecipe(item);
    recipe.addIngredient(Material.BOWL);
    recipe.addIngredient(1, Material.CACTUS, 0);
    Bukkit.addRecipe(recipe);
    ShapelessRecipe recipe1 = new ShapelessRecipe(item);
    recipe1.addIngredient(Material.BOWL);
    recipe1.addIngredient(1, Material.INK_SACK, 3);
    Bukkit.addRecipe(recipe1);
  }
  
}