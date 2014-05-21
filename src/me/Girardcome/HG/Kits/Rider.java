package me.Girardcome.HG.Kits;

import java.util.HashMap;
import java.util.Iterator;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Rider
  implements Listener
{
  public Main plugin;

  public Rider(Main plugin)
  {
    this.plugin = plugin;
  }
  @SuppressWarnings({ "unchecked", "rawtypes" })
private HashMap<Player, Horse> horses = new HashMap();
  public String saddleName = "Rider";
  public boolean nameHorse = true;
  public String horseName = "Cheval de §c%s";
  public boolean preventOthersFromUsing = true;
  public boolean modifyHorseStats = true;
  public double jumpStrength = 1.0D;
  public double runSpeed = 1.0D;
  public int horseHealth = 50;
  
  @EventHandler
  public void onInteract(PlayerInteractEvent event)
  {
    if ((event.getAction().name().contains("RIGHT")) && (event.getPlayer().getItemInHand().getType() == Material.SADDLE)) {
      Player p = event.getPlayer();
      ItemStack kititem = p.getEnderChest().getItem(1);
      if ((kititem != null) && 
        (kititem.getType() == Material.EMERALD))
      {
        if (kititem.getItemMeta().getDisplayName()
          .equalsIgnoreCase("Rider")) {
        if (horses.containsKey(p))
        {
          Horse horse = (Horse)horses.remove(p);
          if (!horse.isDead())
          {
            horse.eject();
            horse.leaveVehicle();
            horse.remove();
          }
        }
        else
        {
          Horse horse = (Horse)p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
          horses.put(p, horse);
          if (nameHorse)
          {
            horse.setCustomName(String.format(horseName, new Object[] { p.getName() }));
            horse.setCustomNameVisible(true);
          }
          horse.setBreed(false);
          horse.setTamed(true);
          horse.setDomestication(horse.getMaxDomestication());
          horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
          
          horse.setOwner(p);
          if (modifyHorseStats)
          {
            horse.setJumpStrength(jumpStrength);
            horse.setMaxHealth(horseHealth);
            horse.setHealth(horseHealth);
            horse.setColor(Horse.Color.WHITE);
          }
        }
      }
    }
    }
  }
  
  @EventHandler
  public void onEntityDeath(EntityDeathEvent event)
  {
    if (horses.containsValue(event.getEntity()))
    {
      event.setDroppedExp(0);
      event.getDrops().clear();
      Iterator<Player> itel = horses.keySet().iterator();
      while (itel.hasNext()) {
        if (horses.get(itel.next()) == event.getEntity())
        {
          itel.remove();
          break;
        }
      }
    }
  }
  
  @EventHandler
  public void onRightClick(PlayerInteractEntityEvent event)
  {
    if ((preventOthersFromUsing) && 
      (horses.containsValue(event.getRightClicked()))) {
      for (Player p : horses.keySet()) {
        if ((horses.get(p) == event.getRightClicked()) && 
          (event.getPlayer() != p))
        {
          event.setCancelled(true);
          break;
        }
      }
    }
  }
  @EventHandler
  public void onClick(InventoryClickEvent event)
  {
    if ((event.getCurrentItem() != null) && (event.getCurrentItem().getType() == Material.SADDLE) && 
      (event.getWhoClicked().getVehicle() != null) && 
      (horses.containsValue(event.getWhoClicked().getVehicle()))) {
      event.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onKilled(PlayerDeathEvent event)
  {
	  if(event.getEntity().getKiller() == null || event.getEntity().getKiller().getPlayer() == null){
		  return;
	  }
    if (horses.containsKey(event.getEntity().getKiller().getPlayer()))
    {
      Horse horse = (Horse)horses.remove(event.getEntity().getKiller().getPlayer());
      if (!horse.isDead())
      {
        horse.eject();
        horse.leaveVehicle();
        horse.remove();
      }
    }
  }
  @EventHandler
  public void onDrop(PlayerDropItemEvent event)
  {
	  Player p = event.getPlayer();
      ItemStack kititem = p.getEnderChest().getItem(1);
      if ((kititem != null) && 
        (kititem.getType() == Material.EMERALD))
      {
        if (kititem.getItemMeta().getDisplayName()
          .equalsIgnoreCase("Rider")) {
        	if(event.getItemDrop().getItemStack().getType() == Material.SADDLE)
      event.setCancelled(true);
        }
      }
  }
	    }
  
