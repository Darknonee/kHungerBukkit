package me.Girardcome.HG.Kits;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class Tank
  implements Listener
{
  public Main plugin;

  public Tank(Main plugin)
  {
    this.plugin = plugin;
  }
  @EventHandler
  public void tank(PlayerDeathEvent event)
  {
    if ((event.getEntity() instanceof Player)) {
      Player p = event.getEntity();
      Player t = p.getKiller();
      ItemStack kititem = t.getEnderChest().getItem(1);
      if ((kititem != null) && 
        (kititem.getType() == Material.EMERALD))
      {
        if (kititem.getItemMeta().getDisplayName()
          .equalsIgnoreCase("Switcher")) {
        p.getWorld().createExplosion(p.getLocation(), 2.0F, true);
    }
    }
    }

  }
}