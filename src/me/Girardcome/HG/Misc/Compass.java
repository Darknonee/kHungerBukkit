package me.Girardcome.HG.Misc;

import me.Girardcome.HG.Main.Main;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class Compass
  implements Listener
{
	  public Main plugin;
	  
	  public Compass(Main plugin)
	  {
	    this.plugin = plugin;
	  }
  @EventHandler
  public void onInteract(PlayerInteractEvent event)
  {
    Player p = event.getPlayer();
    if (p.getInventory().getItemInHand().getType() == Material.COMPASS)
    {
      if (getNearest(p) == null)
      {
        p.setCompassTarget(p.getWorld().getSpawnLocation());
        p.sendMessage(ChatColor.RED + "Aucun joueur à proximité ! La boussole pointe vers le spawn");
        return;
      }
		int distance = (int) p.getLocation().distance(getNearest(p).getLocation());
		  me.Girardcome.HG.Misc.Kit kit = KitManager.getKitHashmap().get(p.getName());
		  String kit2 = "None";
		  if(kit == null){
			  kit2 = "None";
		  }else{
			  kit2 = kit.name();
		  }
      p.setCompassTarget(getNearest(p).getLocation());
      if(p.getGameMode() == GameMode.SURVIVAL) {
      p.sendMessage(ChatColor.YELLOW + "La boussole pointe vers " + getNearest(p).getName());
      } else if(p.getGameMode() == GameMode.CREATIVE) {
      p.sendMessage("§b[§e" + getNearest(p).getName() + " - " + kit2 +" §b] §eest à " +  distance + " blocs");
      }
    }
  }
  
  public Player getNearest(Player p)
  {
    double distance = (1.0D / 0.0D);
    
    Player target = null;
    for (Entity e : p.getNearbyEntities(1000.0D, 1000.0D, 1000.0D)) {
      if ((e instanceof Player))
      {
        Player p1 = (Player)e;
        if (p1.getGameMode() != GameMode.CREATIVE) {
          if (e != p)
          {
            double distanceto = p.getLocation().distance(e.getLocation());
            if (distanceto <= distance) {
              if (distanceto >= 30.0D)
              {
                distance = distanceto;
                target = (Player)e;
              }
            }
          }
        }
      }
    }
    return target;
  }
}
