package me.Girardcome.HG.Kits;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Berserker
  implements Listener
{
  public Main plugin;

  public Berserker(Main plugin)
  {
    this.plugin = plugin;
  }
  @EventHandler
  public void onBerserker1(PlayerDeathEvent event) {
	  Player p = event.getEntity().getKiller();
	    if (p instanceof Player && event.getEntity() instanceof Player && (plugin.isGameStarted == true))  {
	        ItemStack kititem = p.getEnderChest().getItem(1);
	        if ((kititem != null) && 
	          (kititem.getType() == Material.EMERALD))
	        {
	          if (kititem.getItemMeta().getDisplayName()
	            .equalsIgnoreCase("berserker")) {
	        	  p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 40, 1));
	        	  p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 40, 1));	       
	        	  p.sendMessage("§c****SOIF DE SANG****");
  }

  }
	    }
  }
  @EventHandler
  public void onBerserker2(EntityDeathEvent event) {
	  Player p = event.getEntity().getKiller();
	    if (p instanceof Player && (plugin.isGameStarted == true))  {
	        ItemStack kititem = p.getEnderChest().getItem(1);
	        if ((kititem != null) && 
	          (kititem.getType() == Material.EMERALD))
	        {
	          if (kititem.getItemMeta().getDisplayName()
	            .equalsIgnoreCase("berserker")) {
	        	  p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 0));
	        	  p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 40, 0));	       
	        	  p.sendMessage("§c****SOIF DE SANG****");
  }
	        }
	    }
  }
}