package me.Girardcome.HG.Kits;

import me.Girardcome.HG.Main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Demon
  implements Listener
{
  public Main plugin;

  public Demon(Main plugin)
  {
    this.plugin = plugin;
  }
  @EventHandler
  public void onDamage(EntityDamageByEntityEvent event) {
    if (((event.getEntity() instanceof Player)) && 
      ((event.getDamager() instanceof Player))) {
      Player p = (Player)event.getDamager();
      Player e = (Player)event.getEntity();
      if (p.getEnderChest().getItem(1) != null)
      {
        if (p.getEnderChest().getItem(1).getItemMeta().getDisplayName()
          .equalsIgnoreCase("demon")) {
          if (plugin.time < 120) {
            return;
          }
          e.addPotionEffect(
            new PotionEffect(PotionEffectType.CONFUSION, 400, 1));
        }
      }
    }
  }
}