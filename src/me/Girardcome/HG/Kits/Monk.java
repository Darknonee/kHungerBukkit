package me.Girardcome.HG.Kits;

import java.util.HashMap;
import java.util.Random;

import me.Girardcome.HG.Main.Main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Monk
  implements Listener
{
  public Main plugin;

  public Monk(Main plugin)
  {
    this.plugin = plugin;
  }
  public int monkcdown = 30;
  public String monkmonkcdownMessage = ChatColor.RED + "Attendez un peu...";
  @SuppressWarnings("deprecation")
public int monkItemId = Material.BLAZE_ROD.getId();
private transient HashMap<ItemStack, Long> monkStaff = new HashMap<ItemStack, Long>();
  public boolean sendThroughInventory = true;
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void onRightClick2(PlayerInteractEntityEvent event)
  {
    ItemStack item = event.getPlayer().getItemInHand();
    if (((event.getRightClicked() instanceof Player)) && (item.getTypeId() == monkItemId))
    {
        ItemStack kititem = event.getPlayer().getEnderChest().getItem(1);
        if ((kititem != null) && 
          (kititem.getType() == Material.EMERALD))
        {
          if (kititem.getItemMeta().getDisplayName()
            .equalsIgnoreCase("Monk")) {
      long lastUsed = 0L;
      if (monkStaff.containsKey(item)) {
        lastUsed = ((Long)monkStaff.get(item)).longValue();
      }
      if (lastUsed + 1000 * monkcdown > System.currentTimeMillis())
      {
        event.getPlayer().sendMessage(
          String.format(monkmonkcdownMessage, new Object[] {
          Long.valueOf(-((System.currentTimeMillis() - (lastUsed + 1000 * monkcdown)) / 1000L)) }));
      }
      else
      {
        PlayerInventory inv = ((Player)event.getRightClicked()).getInventory();
        int slot = new Random().nextInt(sendThroughInventory ? 36 : 9);
        ItemStack replaced = inv.getItemInHand();
        if (replaced == null) {
          replaced = new ItemStack(0);
        }
        ItemStack replacer = inv.getItem(slot);
        if (replacer == null) {
          replacer = new ItemStack(0);
        }
        inv.setItemInHand(replacer);
        inv.setItem(slot, replaced);
        monkStaff.put(item, Long.valueOf(System.currentTimeMillis()));
      }
    }
    }
    }
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void onMonk2(EntityDamageByEntityEvent event) {
	  Player p = (Player) event.getDamager();
	    ItemStack item = p.getItemInHand();
	    if (((event.getDamager() instanceof Player)) && (item.getTypeId() == monkItemId))
	    {
	        ItemStack kititem = p.getEnderChest().getItem(1);
	        if ((kititem != null) && 
	          (kititem.getType() == Material.EMERALD))
	        {
	          if (kititem.getItemMeta().getDisplayName()
	            .equalsIgnoreCase("camel")) {
	        long lastUsed = 0L;
	        if (monkStaff.containsKey(item)) {
	          lastUsed = ((Long)monkStaff.get(item)).longValue();
	        }
	        if (lastUsed + 1000 * monkcdown > System.currentTimeMillis())
	        {
	          p.sendMessage(
	            String.format(monkmonkcdownMessage, new Object[] {
	            Long.valueOf(-((System.currentTimeMillis() - (lastUsed + 1000 * monkcdown)) / 1000L)) }));
		      }
		      else
		      { 
		    	  PlayerInventory inv = ((HumanEntity) event.getEntity()).getInventory();
			        int slot = new Random().nextInt(sendThroughInventory ? 36 : 9);
			        ItemStack replaced = inv.getItemInHand();
			        if (replaced == null) {
			          replaced = new ItemStack(0);
			        }
			        ItemStack replacer = inv.getItem(slot);
			        if (replacer == null) {
			          replacer = new ItemStack(0);
			        }
			        inv.setItemInHand(replacer);
			        inv.setItem(slot, replaced);
			        monkStaff.put(new ItemStack(Material.BLAZE_ROD), Long.valueOf(System.currentTimeMillis()));
  }
}
	    }
	    }
  }
  }