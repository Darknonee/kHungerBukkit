package me.Girardcome.HG.Kits;

import me.Girardcome.HG.Main.Main;
import me.Girardcome.HG.Misc.Kit;
import me.Girardcome.HG.Misc.KitManager;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Beastmaster
  implements Listener
{
  public Main plugin;

  public Beastmaster(Main plugin)
  {
    this.plugin = plugin;
  }
  @EventHandler
  public void onInteract(PlayerInteractEvent event)
  {
    Player p = event.getPlayer();
    if (plugin.isGameStarted == true)  {
        if(KitManager.getKitHashmap().containsKey(p.getName()) && KitManager.getKitHashmap().get(p.getName()).equals(Kit.Beastmaster)){  
    ItemStack item = p.getItemInHand();
    if ((event.getAction() == Action.RIGHT_CLICK_BLOCK) && (item != null) && (item.getType() == Material.MONSTER_EGG)) {
    	p.getWorld().spawnEntity(        event.getClickedBlock().getRelative(event.getBlockFace()).getLocation(), EntityType.WOLF);
      if (item.getAmount() > 1)
        item.setAmount(item.getAmount() - 1);
      else
        item = null;
      p.setItemInHand(item);
    }
        }
    }
  }
  

  @EventHandler
  public void onMobInteract(PlayerInteractEntityEvent event) {
    Player p = event.getPlayer();
    if (plugin.isGameStarted == true)  {
        if(KitManager.getKitHashmap().containsKey(p.getName()) && KitManager.getKitHashmap().get(p.getName()).equals(Kit.Beastmaster)){  
    ItemStack item = p.getItemInHand();
    if (((event.getRightClicked() instanceof Wolf)) && (item != null) && (item.getType() == Material.BONE) && 
      (!((Wolf)event.getRightClicked()).isTamed())) {
      event.setCancelled(true);
      ((Wolf)event.getRightClicked()).setOwner(p);
      if (item.getAmount() > 1)
        item.setAmount(item.getAmount() - 1);
      else
        item = null;
      p.setItemInHand(item);
    }
  }
    }}
  }
 