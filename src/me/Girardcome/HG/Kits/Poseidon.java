package me.Girardcome.HG.Kits;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Poseidon
  implements Listener
{
  public Main plugin;

  public Poseidon(Main plugin)
  {
    this.plugin = plugin;
  }
  @EventHandler
  public void onPoseidon(PlayerMoveEvent event) {
 	    Player p = event.getPlayer();
        if (plugin.isGameStarted == true)  {
            ItemStack kititem = p.getEnderChest().getItem(1);
            if ((kititem != null) && 
              (kititem.getType() == Material.EMERALD))
            {
              if (kititem.getItemMeta().getDisplayName()
                .equalsIgnoreCase("poseidon")) {
 	    Material b = event.getPlayer().getLocation().getBlock().getType();
 	    PotionEffect stre = PotionEffectType.INCREASE_DAMAGE.createEffect(100, 0);
 	    PotionEffect speed = PotionEffectType.SPEED.createEffect(100, 1);
 	     if ((b == Material.WATER) || (b == Material.STATIONARY_WATER)){
 	      p.addPotionEffect(speed, true);
 	      p.addPotionEffect(stre, true);
 	    }
  }
  }
}
  }
  }