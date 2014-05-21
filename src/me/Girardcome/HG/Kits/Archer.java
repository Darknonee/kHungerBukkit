package me.Girardcome.HG.Kits;

import java.util.Iterator;

import me.Girardcome.HG.Main.Main;
import me.Girardcome.HG.Misc.Kit;
import me.Girardcome.HG.Misc.KitManager;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class Archer
  implements Listener
{
  public Main plugin;

  public Archer(Main plugin)
  {
    this.plugin = plugin;
  }
  @EventHandler
  public void onArcherHitPlayer(EntityDamageByEntityEvent e)
  {
	  Player p = (Player) e.getDamager();
	  Player d = (Player) e.getEntity();
	  DamageCause damageCause = d.getLastDamageCause().getCause();
	  if(damageCause == DamageCause.ENTITY_ATTACK && d instanceof Player ){
		 p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
		  
	  }
    /*if (e.getEntity().getType() == EntityType.ARROW) {
      Arrow arrow = (Arrow)e.getEntity();
      if (((Arrow) arrow.getShooter()).getType() == EntityType.PLAYER) {
        Player p = (Player)arrow.getShooter();
        if(KitManager.getKitHashmap().containsKey(p.getName()) && KitManager.getKitHashmap().get(p.getName()).equals(Kit.Archer)){        	
         p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
      }
    }}*/
  }
  @EventHandler
  public void onBlockBreak(BlockBreakEvent event)
  {
	  if (plugin.isGameStarted == true)  {
	  Player p = event.getPlayer();
      if(KitManager.getKitHashmap().containsKey(p.getName()) && KitManager.getKitHashmap().get(p.getName()).equals(Kit.Archer)){  
    if ((event.getBlock().getType() == Material.GRAVEL)) {
      event.getBlock().setType(Material.AIR);
      event.getBlock().getWorld()
        .dropItemNaturally(event.getBlock().getLocation().add(0.5D, 0.0D, 0.5D), new ItemStack(Material.FLINT));
    }}}
  }

  @EventHandler
  public void onDeath(EntityDeathEvent event) {

    if (plugin.isGameStarted == true)  {
    if (event.getEntity().getKiller() != null) {
      Material mat = null;
      if (event.getEntityType() == EntityType.SKELETON)
        mat = Material.ARROW;
      else if (event.getEntityType() == EntityType.CHICKEN)
        mat = Material.FEATHER;
      else
        return;
      Iterator<ItemStack> itel = event.getDrops().iterator();
      while (itel.hasNext()) {
        ItemStack item = (ItemStack)itel.next();
        if ((item == null) || (item.getType() != mat))
          continue;
        itel.remove();
      }
      event.getDrops().add(new ItemStack(mat, 2));
    }
    }
  }
    
  }