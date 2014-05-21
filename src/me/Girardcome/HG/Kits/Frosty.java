package me.Girardcome.HG.Kits;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Frosty
  implements Listener
{
  public Main plugin;

  public Frosty(Main plugin)
  {
    this.plugin = plugin;
  }
  @EventHandler
  public void onCamel(PlayerMoveEvent e) {
    Player p = e.getPlayer();
    if (plugin.isGameStarted == true)  {
        ItemStack kititem = p.getEnderChest().getItem(1);
        if ((kititem != null) && 
          (kititem.getType() == Material.EMERALD))
        {
          if (kititem.getItemMeta().getDisplayName()
            .equalsIgnoreCase("camel")) {
    Block b = e.getTo().add(0.0D, -1.0D, 0.0D).getBlock();
      if (b.getType() == Material.SNOW || b.getType() == Material.SNOW_BALL)
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 0));
      else
        return;
  }
        }
    }
  }
  }