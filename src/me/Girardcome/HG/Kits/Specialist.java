package me.Girardcome.HG.Kits;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Specialist
  implements Listener
{
  public Main plugin;

  public Specialist(Main plugin)
  {
    this.plugin = plugin;
  }
  @EventHandler
  public void Specialist1(EntityDeathEvent e) {
    Player p = (Player)e.getEntity();
    ItemStack kititem = p.getEnderChest().getItem(1);
    if ((kititem != null) && 
      (kititem.getType() == Material.EMERALD))
    {
      if (kititem.getItemMeta().getDisplayName()
        .equalsIgnoreCase("Specialist")) 
      e.setDroppedExp(e.getDroppedExp() * 10);
    	        }
  }
  @EventHandler
  public void Specialist2(PlayerDeathEvent event) {
    if (((event.getEntity() instanceof Player)) && ((event.getEntity().getKiller() instanceof Player))) {
      Player killer = event.getEntity().getKiller();
      ItemStack kititem = killer.getEnderChest().getItem(1);
      if ((kititem != null) && 
        (kititem.getType() == Material.EMERALD))
      {
        if (kititem.getItemMeta().getDisplayName()
          .equalsIgnoreCase("Specialist"))
        killer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.EXP_BOTTLE, 1) }); 
    }
  }
  }

  @EventHandler
  public void Specialist3(PlayerInteractEvent e) {
    Player p = e.getPlayer();
    ItemStack kititem = p.getEnderChest().getItem(1);
    if ((kititem != null) && 
      (kititem.getType() == Material.EMERALD))
    {
      if (kititem.getItemMeta().getDisplayName()
        .equalsIgnoreCase("Specialist") &&
      (p.getItemInHand().getType() == Material.BOOK) && (
      (e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)))
      p.openEnchanting(null, true); 
  }
  }
}