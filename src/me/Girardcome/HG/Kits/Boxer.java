package me.Girardcome.HG.Kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Boxer
  implements Listener
{
  @EventHandler
  public void onDamage(EntityDamageByEntityEvent event)
  {
    if ((event.getDamager() instanceof Player)) {
      Player p = (Player)event.getDamager();
      if (p.getEnderChest().getItem(1) != null)
      {
        if (p.getEnderChest().getItem(1).getItemMeta().getDisplayName()
          .equalsIgnoreCase("boxer")) {
          event.setDamage(5.0D);
        }
      }
    }
    if ((event.getEntity() instanceof Player)) {
      Player damaged = (Player)event.getEntity();
      if (damaged.getEnderChest().getItem(1) != null)
      {
        if (damaged.getEnderChest().getItem(1).getItemMeta()
          .getDisplayName().equalsIgnoreCase("boxer"))
          event.setDamage(event.getDamage() - 1.0D);
      }
    }
  }
}