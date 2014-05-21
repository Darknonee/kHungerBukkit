package me.Girardcome.HG.Kits;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Material;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class Hunter
  implements Listener
{
  public Main plugin;

  public Hunter(Main plugin)
  {
    this.plugin = plugin;
  }
  @SuppressWarnings({ "rawtypes", "unchecked" })
@EventHandler
  public void onDeath(EntityDeathEvent event)
  {
    if (((event.getEntity() instanceof Pig)) && 
      (event.getEntity().getKiller() != null)) {
        final Player p = (Player) event.getEntity().getKiller();
        ItemStack kititem = p.getEnderChest().getItem(1);
        if ((kititem != null) && 
          (kititem.getType() == Material.EMERALD))
        {
          if (kititem.getItemMeta().getDisplayName()
            .equalsIgnoreCase("hunter")) {
      Iterator<ItemStack> itel = event.getDrops().iterator();
      List toAdd = new ArrayList();
      while (itel.hasNext()) {
        ItemStack item = (ItemStack)itel.next();
        if ((item == null) || (
          (item.getType() != Material.PORK)))
          continue;
        else if (item.getType() == Material.PORK)
          toAdd.add(new ItemStack(Material.GRILLED_PORK, item.getAmount()));
        itel.remove();
        event.getDrops().add(item);
      }
    }
  }
}
  }
}

