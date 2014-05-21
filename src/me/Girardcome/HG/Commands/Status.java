package me.Girardcome.HG.Commands;

import me.Girardcome.HG.Main.Main;
import me.Girardcome.HG.Misc.KitManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
public class Status
  implements CommandExecutor
{
	Main plugin;
  public Status(Main Main) {
		plugin = Main;
	}
  public static Inventory inv;
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
	  Player p = (Player) sender;
    if ((args.length == 1) && ((sender instanceof Player))) {
        if (!sender.hasPermission("hg.command.status"))
        {
        	sender.sendMessage((String) plugin.getConfig().get("NoPerm"));
        	return false;
        }
        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null) {
          sender.sendMessage("§cLe joueur séléctionné(e) est introuvable!");
        }
        else {
        	  ItemStack tutorial = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        	  ItemMeta tutmeta = tutorial.getItemMeta();
        	  tutmeta.setDisplayName("§7" + target.getName());
        	  tutorial.setItemMeta(tutmeta);
        	  
        	  ItemStack thinglass = new ItemStack(Material.THIN_GLASS);
        	  ItemMeta thinmeta = thinglass.getItemMeta();
        	  thinmeta.setDisplayName(" ");
        	  thinglass.setItemMeta(thinmeta);
        	  
        	  ItemStack paper = new ItemStack(Material.PAPER);
        	  ItemMeta papermeta = paper.getItemMeta();
        	  papermeta.setDisplayName("§aNombre de Kills");
        	  paper.setItemMeta(papermeta);
        	  
        	  inv = Bukkit.createInventory(null, 54, "§9Les informations sur §c" + target.getName());
        	  inv.setItem(0, thinglass);
        	  inv.setItem(1, thinglass);
        	  inv.setItem(2, thinglass);
        	  inv.setItem(3, thinglass);
        	  inv.setItem(4, thinglass);
        	  inv.setItem(5, thinglass);
        	  inv.setItem(6, thinglass);
        	  inv.setItem(7, thinglass);
        	  inv.setItem(8, thinglass);
        	  inv.setItem(9, thinglass);
        	  inv.setItem(10, thinglass);
        	  inv.setItem(11, thinglass);
        	  inv.setItem(12, thinglass);
        	  inv.setItem(13, tutorial);
        	  inv.setItem(14, thinglass);
        	  inv.setItem(15, thinglass);
        	  inv.setItem(16, thinglass);
        	  inv.setItem(17, thinglass);
        	  inv.setItem(18, thinglass);
              inv.setItem(19, thinglass);
        	  inv.setItem(20, thinglass);
        	  inv.setItem(21, thinglass);
        	  inv.setItem(22, thinglass);
        	  inv.setItem(23, thinglass);
        	  inv.setItem(24, thinglass);
        	  inv.setItem(25, thinglass);
        	  inv.setItem(26, thinglass);
        	  inv.setItem(27, thinglass);
        	  if(plugin.isGameStarted == true) {
        	  inv.setItem(28, paper);
        	  } else if(plugin.isGameStarted == false) {
              inv.setItem(28, thinglass);
        	  }
        	  inv.setItem(29, thinglass);
        	  if(KitManager.getKitHashmap().containsKey(p.getName())) {
        	  inv.setItem(30, paper);
        	  } else if(!KitManager.getKitHashmap().containsKey(p.getName())) {
              inv.setItem(30, thinglass);
        	  }
        	  inv.setItem(31, thinglass);
        	  inv.setItem(32, thinglass);
        	  inv.setItem(33, thinglass);
        	  inv.setItem(34, thinglass);
        	  inv.setItem(35, thinglass);
        	  inv.setItem(36, thinglass);
        	  inv.setItem(37, thinglass);
        	  inv.setItem(38, thinglass);
        	  inv.setItem(39, thinglass);
        	  inv.setItem(40, thinglass);
        	  inv.setItem(41, thinglass);
        	  inv.setItem(42, thinglass);
        	  inv.setItem(43, thinglass);
        	  inv.setItem(44, thinglass);
        	  inv.setItem(45, thinglass);
        	  inv.setItem(46, thinglass);
        	  inv.setItem(47, thinglass);
        	  inv.setItem(48, thinglass);
        	  inv.setItem(49, thinglass);
        	  inv.setItem(50, thinglass);
        	  inv.setItem(51, thinglass);
          	  inv.setItem(52, thinglass);
          	  inv.setItem(53, thinglass);
        	  p.openInventory(inv);
          sender.sendMessage("§b---===[§7Les informations sur §c" + target.getName() + "§b]===---");
          sender.sendMessage("§aKit : §7" + KitManager.getKitHashmap().get(target.getName()));
          sender.sendMessage("§aIP : §7" + target.getAddress().getHostString());
          String rank = "Défaut";
          if(target.hasPermission("hg.grade.Vip")) rank = "VIP";
          if(target.hasPermission("hg.grade.MVP")) rank = "MVP";
          if(target.hasPermission("hg.grade.PRO")) rank = "PRO";
          if(target.hasPermission("hg.grade.Mod")) rank = "MOD";
          if(target.hasPermission("hg.grade.Modplus")) rank = "MOD+";
          if(target.hasPermission("hg.grade.Admin")) rank = "ADMIN";
          sender.sendMessage("§aGrade : §7 " + rank);
          //Check the number of kills he do on this game
		  int kills = plugin.getConfig().getInt("players." + target.getName() + ".kill");
		  plugin.saveConfig();
          sender.sendMessage("§aKills : §7" + kills);
          
        }
        return true;
      }
    return false;
  }
}
