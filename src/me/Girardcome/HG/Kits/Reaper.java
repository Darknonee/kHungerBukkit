package me.Girardcome.HG.Kits;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Reaper
  implements Listener
{
  public Main plugin;

  public Reaper(Main plugin)
  {
    this.plugin = plugin;
  }
  @EventHandler(priority=EventPriority.NORMAL)
  public void onReaper(EntityDamageByEntityEvent e) {
    Player victim = (Player)e.getEntity();
    Player check = (Player)e.getDamager();
    ItemStack kititem = check.getEnderChest().getItem(1);
    if ((kititem != null) && 
      (kititem.getType() == Material.EMERALD))
    {
      if (kititem.getItemMeta().getDisplayName()
        .equalsIgnoreCase("Reaper") &&
      (check.getItemInHand() != null))
    {
      if (check.getItemInHand().getType() == Material.WOOD_HOE)
      {
        victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 150, 1));
      }
    }
    }
  }
  }