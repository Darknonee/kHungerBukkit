package me.Girardcome.HG.Kits;

import java.util.Random;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Snail
  implements Listener
{
  public Main plugin;

  public Snail(Main plugin)
  {
    this.plugin = plugin;
  }
  @EventHandler
  public void onSnail(EntityDamageByEntityEvent event) {
    if (((event.getEntity() instanceof Player)) && 
      ((event.getDamager() instanceof Player))) {
      Player victime = (Player)event.getEntity();
      Player joueur = (Player)event.getDamager();
      ItemStack kititem = joueur.getEnderChest().getItem(1);
      if ((kititem != null) && 
        (kititem.getType() == Material.EMERALD))
      {
        if (kititem.getItemMeta().getDisplayName()
          .equalsIgnoreCase("camel")) {
        Random rand = new Random();
        if (rand.nextInt(100) <= 33)
          victime.addPotionEffect(
            new PotionEffect(PotionEffectType.SLOW, 80, 1), true);
      }
    }
  }
  }
  }