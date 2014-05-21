package me.Girardcome.HG.Kits;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class GraveDigger
  implements Listener
{
  public Main plugin;

  public GraveDigger(Main plugin)
  {
    this.plugin = plugin;
  }
  @EventHandler
  public void onDamage(PlayerDeathEvent event) {
	if(event.getEntity().getKiller() instanceof Player){
        ItemStack kititem = event.getEntity().getKiller().getPlayer().getEnderChest().getItem(1);
        if ((kititem != null) && 
          (kititem.getType() == Material.EMERALD))
        {
          if (kititem.getItemMeta().getDisplayName()
            .equalsIgnoreCase("gravedigger")) {
		  Player k = (Player) event.getEntity();
		  Location loc = k.getLocation();
		  World world = k.getWorld();
		  Location chestLocation = new Location(world, loc.getX(), loc.getY() + 1, loc.getZ());
		  chestLocation.getBlock().setType(Material.CHEST);
		  Chest chest = (Chest) chestLocation.getBlock().getState();
		  
		  ItemStack[] inventoryBefore = k.getInventory().getContents();
		  ItemStack[] chestContents = new ItemStack[inventoryBefore.length];
		  
		  for(int i = 0; i < k.getInventory().getSize(); i++) {
			  chestContents[i] = inventoryBefore[i];
		  }
		  
		  for(int i = 0; i < chest.getInventory().getSize(); i++) {
			  if(chestContents[i] != null) {
				  chest.getInventory().addItem(chestContents[i]);
			  }
		  }
		  event.getDrops().clear();
		  }
  }
	}
}
}