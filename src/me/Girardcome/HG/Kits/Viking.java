package me.Girardcome.HG.Kits;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class Viking
  implements Listener
{
  public Main plugin;

  public Viking(Main plugin)
  {
    this.plugin = plugin;
  }
  @EventHandler
  public void onDamage(EntityDamageByEntityEvent event)
  {
    if (((event.getDamager() instanceof Player)))
    {
        ItemStack kititem = ((HumanEntity) event.getDamager()).getEnderChest().getItem(1);
        if ((kititem != null) && 
          (kititem.getType() == Material.EMERALD))
        {
          if (kititem.getItemMeta().getDisplayName()
            .equalsIgnoreCase("Viking")) {
      ItemStack item = ((Player)event.getDamager()).getItemInHand();
      if ((item != null) && (item.getType().name().contains("AXE"))) {
        event.setDamage(event.getDamage() + 3.0D);
      }
    }
  }
    }
  }
}