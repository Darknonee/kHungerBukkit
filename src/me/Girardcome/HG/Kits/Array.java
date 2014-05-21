package me.Girardcome.HG.Kits;

import java.util.HashMap;
import me.Girardcome.HG.Main.Main;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class Array
  implements Listener
{
  public Main plugin;

  public Array(Main plugin)
  {
    this.plugin = plugin;
  }
  @SuppressWarnings({ "unchecked", "rawtypes" })
private transient HashMap<HealArray, Player> beacons = new HashMap();
  private int arrayExpireTime = 30;
  class HealArray
  {
    Block[] blocks;
    long expires;
    
    HealArray() {}
  }
  @EventHandler
  public void ArrayBuilder(BlockPlaceEvent event) {
	  if (plugin.isGameStarted == true)  {
		  Player p = event.getPlayer();
		  if(p.getItemInHand().getType() == Material.BEACON) {
			  ItemStack kititem = p.getEnderChest().getItem(1);
		        if ((kititem != null) && 
		          (kititem.getType() == Material.EMERALD))
		        {
		          if (kititem.getItemMeta().getDisplayName()
		            .equalsIgnoreCase("array")) {
		        	   Block b = event.getBlock();
		        	      HealArray heal = new HealArray();
		        	      heal.expires = (System.currentTimeMillis() + arrayExpireTime * 1000);
		        	      heal.blocks = new Block[3];
		        	      for (int i = 0; i < 3; i++)
		        	      {
		        	        heal.blocks[i] = b;
		        	        if (i != 2) {
		        	          b.setType(Material.FENCE);
		        	        } else {
		        	          b.setType(Material.GLOWSTONE);
		        	        }
		        	        b = b.getRelative(BlockFace.UP);
		        	      }
		        	      beacons.put(heal, event.getPlayer());
		        	    }
		          }
		  }
	  }
  }
}