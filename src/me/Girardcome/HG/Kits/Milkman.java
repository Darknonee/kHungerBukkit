package me.Girardcome.HG.Kits;

import java.util.HashMap;
import java.util.Random;

import me.Girardcome.HG.Main.Main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Milkman
  implements Listener
{
  public Main plugin;

  public Milkman(Main plugin)
  {
    this.plugin = plugin;
  }
  public int cooldown = 15;
  public String monkCooldownMessage = ChatColor.WHITE + "Vous devez attendre %s secondes";
  @SuppressWarnings("deprecation")
public int monkItemId = Material.BLAZE_ROD.getId();
  @SuppressWarnings({ "unchecked", "rawtypes" })
private transient HashMap<ItemStack, Long> monkStaff = new HashMap();
  public boolean sendThroughInventory = true;

  @SuppressWarnings("deprecation")
@EventHandler
  public void onRightClick(PlayerInteractEntityEvent event) {
	  ItemStack item = event.getPlayer().getItemInHand();
    if (((event.getRightClicked() instanceof Player)) &&  (item.getTypeId() == monkItemId)) {
        Player p = event.getPlayer();
        ItemStack kititem = p.getEnderChest().getItem(1);
        if ((kititem != null) && 
          (kititem.getType() == Material.EMERALD))
        {
          if (kititem.getItemMeta().getDisplayName()
            .equalsIgnoreCase("monk")) {
      long lastUsed = 0L;
      
      if (monkStaff.containsKey(item))
        lastUsed = ((Long)monkStaff.get(item)).longValue();
      if (lastUsed + 1000 * cooldown > System.currentTimeMillis()) {
        event.getPlayer().sendMessage(
          String.format(monkCooldownMessage, new Object[] { 
          Long.valueOf(-((System.currentTimeMillis() - (lastUsed + 1000 * cooldown)) / 1000L)) }));
      } else {
        PlayerInventory inv = ((Player)event.getRightClicked()).getInventory();
        int slot = new Random().nextInt(sendThroughInventory ? 36 : 9);
        ItemStack replaced = inv.getItemInHand();
        if (replaced == null)
          replaced = new ItemStack(0);
        ItemStack replacer = inv.getItem(slot);
        if (replacer == null)
          replacer = new ItemStack(0);
        inv.setItemInHand(replacer);
        inv.setItem(slot, replaced);
        monkStaff.put(item, Long.valueOf(System.currentTimeMillis()));
      }
    }
  }
    }
}
}

