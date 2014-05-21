package me.Girardcome.HG.Kits;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class Fireman
  implements Listener
{
  public Main plugin;

  public Fireman(Main plugin)
  {
    this.plugin = plugin;
  }
	 
  @EventHandler
  public void onFireman(EntityDamageEvent event) {
      if(event.getEntity() instanceof Player) {
    	    Player p = (Player)event.getEntity();
      if ((event.getCause() == EntityDamageEvent.DamageCause.FIRE) || (event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) || 
     (event.getCause() == EntityDamageEvent.DamageCause.LIGHTNING) || (event.getCause() == EntityDamageEvent.DamageCause.LAVA)) {
          ItemStack kititem = p.getEnderChest().getItem(1);
          if ((kititem != null) && 
            (kititem.getType() == Material.EMERALD))
          {
            if (kititem.getItemMeta().getDisplayName()
              .equalsIgnoreCase("Fireman")) {
      event.setCancelled(true);
      p.setFireTicks(0);
    }
          }
      }
  }
  }
  }