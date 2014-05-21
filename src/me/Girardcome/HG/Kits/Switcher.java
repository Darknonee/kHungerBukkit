package me.Girardcome.HG.Kits;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class Switcher
  implements Listener
{
  public Main plugin;

  public Switcher(Main plugin)
  {
    this.plugin = plugin;
  }
  @EventHandler
  public void Switcher2(EntityDamageByEntityEvent e) {
    if (((e.getDamager() instanceof Snowball)) && ((e.getEntity() instanceof Player))) {
      Snowball s = (Snowball)e.getDamager();
      if ((s.getShooter() instanceof Player)) {
        Player shooter = (Player)s.getShooter();
        Location shooterLoc = shooter.getLocation();
        ItemStack kititem = shooter.getEnderChest().getItem(1);
        if ((kititem != null) && 
          (kititem.getType() == Material.EMERALD))
        {
          if (kititem.getItemMeta().getDisplayName()
            .equalsIgnoreCase("Switcher")) {
          shooter.teleport(e.getEntity().getLocation());
          e.getEntity().teleport(shooterLoc);
        }
      }
    }
  }
 
  }
}