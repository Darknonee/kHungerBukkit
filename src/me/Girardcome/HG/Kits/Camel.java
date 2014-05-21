package me.Girardcome.HG.Kits;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Camel
  implements Listener
{
  public Main plugin;

  public Camel(Main plugin)
  {
    this.plugin = plugin;
  }
  public Camel(Player p) {
    ShapelessRecipe recipe = new ShapelessRecipe(new ItemStack(Material.MUSHROOM_SOUP));
    recipe.addIngredient(Material.CACTUS);
    recipe.addIngredient(Material.SAND);
    
    Bukkit.addRecipe(recipe);
    
    
    ShapelessRecipe recipes = new ShapelessRecipe(new ItemStack(Material.MUSHROOM_SOUP));
    recipes.addIngredient(Material.CACTUS);
    recipes.addIngredient(Material.BOWL);
    Bukkit.addRecipe(recipe);
  }
  @EventHandler
  public void onCamel(PlayerMoveEvent e) {
    Player p = e.getPlayer();
    if (plugin.isGameStarted == true)  {
        ItemStack kititem = p.getEnderChest().getItem(1);
        if ((kititem != null) && 
          (kititem.getType() == Material.EMERALD))
        {
          if (kititem.getItemMeta().getDisplayName()
            .equalsIgnoreCase("camel")) {
    Block b = e.getTo().add(0.0D, -1.0D, 0.0D).getBlock();
      if (b.getType() == Material.SAND)
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 0));
      else
        return;
  }
        }
    }
  }
  }