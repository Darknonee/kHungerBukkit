package me.Girardcome.HG.Kits;

import java.util.Random;

import me.Girardcome.HG.Main.Main;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Burrower
implements Listener
{
public Main plugin;

public Burrower(Main plugin)
{
  this.plugin = plugin;
}
	  public int addX = 0;
	  public int addZ = 0;
	  public int giveBackItemDelay = 300;
	  public int groundBlockData = 0;
	  public int groundBlockId = 45;
	  public int itemData = 0;
	  @SuppressWarnings("deprecation")
	public int itemId = Material.SLIME_BALL.getId();
	  public String messageNotHighEnough = ChatColor.RED + "§lVous etes trop prêt du vide !";
	  public int mustBeHigherThen = 10;
	  public boolean randomCords = false;
	  public int roofBlockData = 0;
	  public int roofBlockId = 45;
	  public int roomHeight = 2;
	  public int roomWidth = 2;
	  public boolean teleportHeightRelativeToCurrentPos = false;
	  public int teleportToY = 10;
	  public int wallsBlockData = 0;
	  public int wallsBlockId = 45;

	@SuppressWarnings("deprecation")
	@EventHandler
	  public void onInteract(PlayerInteractEvent event) { 
		  ItemStack item = event.getItem();
		  Player p = event.getPlayer();
	        ItemStack kititem = p.getEnderChest().getItem(1);
	        if ((kititem != null) && 
	          (kititem.getType() == Material.EMERALD))
	        {
	          if (kititem.getItemMeta().getDisplayName()
	            .equalsIgnoreCase("burrower")) {
	    if ((event.getAction().name().contains("RIGHT")) && (item != null) && 
	      (item.getTypeId() == itemId) && (item.getDurability() == itemData)) {
	      if (p.getLocation().getY() > mustBeHigherThen) {
	        int x = addX;
	        int z = addZ;
	        if (randomCords) {
	          x = new Random().nextInt(addX * 2) - addX;
	          z = new Random().nextInt(addZ * 2) - addZ;
	        }
	        item.setAmount(item.getAmount() - 1);
	        if (item.getAmount() == 0)
	          p.setItemInHand(new ItemStack(0));
	        Location loc = p.getLocation().clone().add(x, 0.0D, z);
	        if (teleportHeightRelativeToCurrentPos)
	          loc.setY(loc.getY() - teleportToY);
	        else
	          loc.setY(teleportToY);
	        loc = loc.add(0.5D, 0.0D, 0.5D);
	        for (int bX = -roomWidth; bX <= roomWidth; bX++) {
	          for (int bZ = -roomWidth; bZ <= roomWidth; bZ++) {
	            for (int bY = -1; bY <= roomHeight; bY++) {
	              Block b = loc.clone().add(bX, bY, bZ).getBlock();
	              if (bY == roomHeight)
	                b.setTypeIdAndData(roofBlockId, (byte)roofBlockData, false);
	              else if (bY == -1)
	                b.setTypeIdAndData(groundBlockId, (byte)groundBlockData, false);
	              else if ((bX == -roomWidth) || (bZ == -roomWidth) || (bX == roomWidth) || (bZ == roomWidth))
	                b.setTypeIdAndData(wallsBlockId, (byte)wallsBlockData, false);
	              else
	                b.setType(Material.AIR);
	            }
	          }
	        }
	        p.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 9);
	        p.getWorld().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 0.0F);
	        p.teleport(loc);
	        p.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 9);
	        p.getWorld().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 0.0F);
	      } else {
	        p.sendMessage(messageNotHighEnough);
	      }
	    }
	          }
	    } }

}

