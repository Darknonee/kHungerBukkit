package me.Girardcome.HG.Commands;

import java.util.ArrayList;

import me.Girardcome.HG.Main.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Girardcome.HG.Misc.Kit;
import me.Girardcome.HG.Misc.KitManager;

public class Randoms implements CommandExecutor
{
  public Main plugin;
  
  public Randoms(Main plugin)
  {
    this.plugin = plugin;
  }
  
  
  public boolean onCommand(CommandSender sender, Command arg1, String label, String[] args)
  {
    Player p = (Player) sender;
    if (args.length == 0)
    {
    	
    	java.util.Random random = new java.util.Random();
    	ArrayList<Kit> kits = new ArrayList<Kit>();
    	for(Kit kit : Kit.values()){
    		if(plugin.hasPermission(p.getUniqueId().toString(), "hg.kits." + kit.name())){
    			kits.add(kit);
    		}
    	}
    	if(kits.size() <= 0){
    		p.sendMessage("§cVous n'avez aucun Kit !");
    		return true;
    	}
    	Integer next = random.nextInt(kits.size());
    	Kit kit = kits.get(next);
    	KitManager.setKit(p, kit);
    	p.sendMessage("§aVous êtes maintenant " + kit.name().substring(0, 1).toUpperCase() + kit.name().substring(1));
      return true;
    }
    if (plugin.isGameStarted == true)
    {
      p.sendMessage(ChatColor.RED + "La partie à déjà commencer");
      return true;
    }
    return true;
  }
}
