package me.Girardcome.HG.Kits;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Worm
  implements Listener
{
  public Main plugin;

  public Worm(Main plugin)
  {
    this.plugin = plugin;
  } 
  @EventHandler
  public void onWorm(PlayerInteractEvent e) {
	  Player p = e.getPlayer();
	  if(e.getAction().name().contains("LEFT") && p.getItemInHand().getType() == Material.AIR) {
		    ItemStack kititem = p.getEnderChest().getItem(1);
		    if ((kititem != null) && 
		      (kititem.getType() == Material.EMERALD))
		    {
		      if (kititem.getItemMeta().getDisplayName()
		        .equalsIgnoreCase("worm")) {
	      p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 60, 3));
	      p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 60, 3));
	  }
  }
	  }}
  }