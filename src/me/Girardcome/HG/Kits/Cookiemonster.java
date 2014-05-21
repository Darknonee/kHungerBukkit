package me.Girardcome.HG.Kits;

import java.util.HashMap;
import java.util.Random;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Cookiemonster
  implements Listener
{
  public Main plugin;

  public Cookiemonster(Main plugin)
  {
    this.plugin = plugin;
  }
  public int oneChanceInWhatOfCookies = 4;
  public int delayInMillisecondsBetweenCookies = 500;
  @SuppressWarnings({ "unchecked", "rawtypes" })
private HashMap<Player, Long> cookieExpires = new HashMap();

  @SuppressWarnings("deprecation")
@EventHandler
  public void onChomp(PlayerInteractEvent event) { if (event.getAction().name().contains("RIGHT")) {
      Player p = event.getPlayer();
      ItemStack kititem = p.getEnderChest().getItem(1);
      if ((kititem != null) && 
        (kititem.getType() == Material.EMERALD))
      {
        if (kititem.getItemMeta().getDisplayName()
          .equalsIgnoreCase("cookiemonster")) {
      if (((!cookieExpires.containsKey(p)) || (((Long)cookieExpires.get(p)).longValue() < System.currentTimeMillis())) && (event.getItem() != null) && (event.getItem().getType() == Material.COOKIE)) {
        event.setCancelled(true);
        if (p.getHealth() < 20.0D) {
          double hp = p.getHealth() + 1.0D;
          if (hp > 20.0D)
            hp = 20.0D;
          p.setHealth(hp);
        } else if (p.getFoodLevel() < 20) {
          p.setFoodLevel(p.getFoodLevel() + 1);
        } else {
          p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1), true);
        }
        event.getItem().setAmount(event.getItem().getAmount() - 1);
        if (event.getItem().getAmount() == 0)
          p.setItemInHand(new ItemStack(0));
        cookieExpires.put(p, Long.valueOf(System.currentTimeMillis() + delayInMillisecondsBetweenCookies));
      }
    } }
}
  }
  @EventHandler
  public void onDamage(BlockDamageEvent event) {
      Player p = event.getPlayer();
      ItemStack kititem = p.getEnderChest().getItem(1);
      if ((kititem != null) && 
        (kititem.getType() == Material.EMERALD))
      {
        if (kititem.getItemMeta().getDisplayName()
          .equalsIgnoreCase("cookiemonster")) { 
     if (event.getBlock().getType() == Material.LONG_GRASS && (new Random().nextInt(oneChanceInWhatOfCookies) == 0)) {
      Location loc = event.getBlock().getLocation().clone();
      loc.getWorld().dropItemNaturally(loc.add(0.5D, 0.0D, 0.5D), new ItemStack(Material.COOKIE));
    }
  }
}
  }
}