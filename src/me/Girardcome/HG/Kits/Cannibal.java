package me.Girardcome.HG.Kits;

import java.util.Random;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Cannibal
  implements Listener
{
  public Main plugin;

  public Cannibal(Main plugin)
  {
    this.plugin = plugin;
  }
  public int addHunger = 2;
  public int chance = 3;
  public int multiplier = 0;
  public int potionLength = 5;

  @EventHandler
  public void onEntityDamage(EntityDamageByEntityEvent event) { 
	  if (event.isCancelled())
      return;
    if (((event.getEntity() instanceof Player)) && ((event.getEntity() instanceof Player))) {
  	  Player p = (Player) event.getEntity();
      ItemStack kititem = p.getEnderChest().getItem(1);
      if ((kititem != null) && 
        (kititem.getType() == Material.EMERALD))
      {
        if (kititem.getItemMeta().getDisplayName()
          .equalsIgnoreCase("cannibal")) {
      LivingEntity entity = (LivingEntity)event.getEntity();
      if (new Random().nextInt(chance) == 0) {
        entity.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, potionLength * 20, multiplier), true);
        int hunger = p.getFoodLevel();
        hunger += addHunger;
        if (hunger > 20)
          hunger = 20;
        p.setFoodLevel(hunger);
      }
    }
  }
      }
  }
}