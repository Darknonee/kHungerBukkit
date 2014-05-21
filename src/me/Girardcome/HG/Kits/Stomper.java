package me.Girardcome.HG.Kits;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;

public class Stomper
  implements Listener
{
  public Main plugin;

  public Stomper(Main plugin)
  {
    this.plugin = plugin;
  }
	 @EventHandler
	  public void onTributeFall(EntityDamageEvent event) {
	      if (!(event.getEntity() instanceof Player)) {
	      return;
	      }

	      Player player = (Player) event.getEntity();
	      if (event.getCause() == DamageCause.FALL) {

	      if (event.getDamage() > 4) {
	          ItemStack kititem = player.getEnderChest().getItem(1);
	          if ((kititem != null) && 
	            (kititem.getType() == Material.EMERALD))
	          {
	            if (kititem.getItemMeta().getDisplayName()
	              .equalsIgnoreCase("Stomper")) {
	      event.setCancelled(true);
	      player.damage(4);
	      }

	      for (Entity entity : player.getNearbyEntities(5.0D, 5.0D, 5.0D)) {

	      if (entity instanceof Player) {
	      Player target = (Player) entity;
	      double damage = event.getDamage();
	      if (target.isSneaking()) {
	      target.damage(4.0D);;
	      } else {
	      target.damage(damage);
	      }
	      } else if (entity instanceof LivingEntity) {
	      LivingEntity target = (LivingEntity) entity;
	      target.damage(event.getDamage(), player);
	      }
	      }
	      }
	      }
	      }
  }
}