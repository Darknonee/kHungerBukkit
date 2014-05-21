package me.Girardcome.HG.Kits;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class Turtle
  implements Listener
{
  public Main plugin;

  public Turtle(Main plugin)
  {
    this.plugin = plugin;
  }
  public boolean needToBlock = true;
  @EventHandler
  public void onTurtleSneak(EntityDamageEvent event)
  {
    if ((event.getEntity() instanceof Player)) {
      Player p = (Player)event.getEntity();
      ItemStack kititem = p.getEnderChest().getItem(1);
      if ((kititem != null) && 
        (kititem.getType() == Material.EMERALD))
      {
        if (kititem.getItemMeta().getDisplayName()
          .equalsIgnoreCase("Turtle") &&
        (p.isSneaking()) && (p.getHealth() > 1.0D)) {
     	 event.setDamage(2.0D);
      }
      }
    }
  }
  @EventHandler
  public void onTurtleSneakBlock(EntityDamageEvent event) {
    if ((event.getEntity() instanceof Player)) {
      Player p = (Player)event.getEntity();
      ItemStack kititem = p.getEnderChest().getItem(1);
      if ((kititem != null) && 
        (kititem.getType() == Material.EMERALD))
      {
        if (kititem.getItemMeta().getDisplayName()
          .equalsIgnoreCase("Turtle") &&
        (p.isSneaking()) && ((!needToBlock) || (p.isBlocking())) && (p.getHealth() > 1.0D)) {
        event.setDamage(1.0D);
      }
    }
    }
  }
  @EventHandler
  public void onTurtle(EntityDamageByEntityEvent event) {
	  Player p = (Player) event.getDamager();
      ItemStack kititem = p.getEnderChest().getItem(1);
      if ((kititem != null) && 
        (kititem.getType() == Material.EMERALD))
      {
        if (kititem.getItemMeta().getDisplayName()
          .equalsIgnoreCase("Turtle")) {
	  if(p instanceof Player) {
		  if(p.isSneaking())
			  event.setCancelled(true);
		  
	  }
	  	    
        }}
  } 
}