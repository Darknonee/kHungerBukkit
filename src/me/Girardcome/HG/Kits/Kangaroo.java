package me.Girardcome.HG.Kits;

import java.util.ArrayList;
import me.Girardcome.HG.Main.Main;
import me.Girardcome.HG.Misc.Kit;
import me.Girardcome.HG.Misc.KitManager;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class Kangaroo
  implements Listener
{
  public Main plugin;

  public Kangaroo(Main plugin)
  {
    this.plugin = plugin;
  }
  ArrayList<Player> kanga = new ArrayList<Player>();
  @EventHandler
  public void onInteract(PlayerInteractEvent event) {
    Player p = event.getPlayer();
    if(KitManager.getKitHashmap().containsKey(p.getName()) && KitManager.getKitHashmap().get(p.getName()).equals(Kit.Kangaroo)){
      if(p.getItemInHand().getType() == Material.FIREWORK) {
      if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
        (event.getAction() == Action.LEFT_CLICK_BLOCK) || 
        (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
        (event.getAction() == Action.RIGHT_CLICK_AIR))
        event.setCancelled(true);
      if (!kanga.contains(p)) {
        if (!p.isSneaking()) {
          p.setFallDistance(-5.0F);
          Vector vector = p.getEyeLocation().getDirection();
          vector.multiply(0.6F);
          vector.setY(1.0F);
          p.setVelocity(vector);
        } else {
          p.setFallDistance(-5.0F);
          Vector vector = p.getEyeLocation().getDirection();
          vector.multiply(1.2F);
          vector.setY(0.8D);
          p.setVelocity(vector);
        }
        kanga.add(p);
      }
      }
    	
    	}
    }
    
   @EventHandler
   public void onMove(PlayerMoveEvent event) {
	    Player p = event.getPlayer();
	    if(KitManager.getKitHashmap().containsKey(p.getName()) && KitManager.getKitHashmap().get(p.getName()).equals(Kit.Kangaroo)){
      if (kanga.contains(p)) {
       Block b = p.getLocation().getBlock();
       if ((b.getType() != Material.AIR) || 
         (b.getRelative(BlockFace.DOWN).getType() != Material.AIR))
         kanga.remove(p);
      }
     }
	      }
   @EventHandler
   public void onDrop(PlayerDropItemEvent event)
   {
	    Player p = event.getPlayer();
	    if(KitManager.getKitHashmap().containsKey(p.getName()) && KitManager.getKitHashmap().get(p.getName()).equals(Kit.Kangaroo)){
      if(event.getItemDrop().getItemStack().getType() == Material.FIREWORK)
       event.setCancelled(true);
	    }
   }
	    
   @EventHandler
   public void onKangaroo3(EntityDamageEvent event)
   {
     if ((event.getEntity() instanceof Player)) {
    	 if (plugin.time > 120)  {
    	    Player p = (Player) event.getEntity();
    	    if(KitManager.getKitHashmap().containsKey(p.getName()) && KitManager.getKitHashmap().get(p.getName()).equals(Kit.Kangaroo)){
       	     if(event.getCause() == EntityDamageEvent.DamageCause.FALL)
       	      {
       	        if (event.getDamage() > 7.0D) {
       	          event.setCancelled(true);
       	          p.damage(7.0D);
       	        }
       	        }
       	      }
    	    }
     }
}
}
