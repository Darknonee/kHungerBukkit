package me.Girardcome.HG.Commands;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kits implements CommandExecutor
{
  static Main plugin;
  
  public Kits(Main plugin)
  {
    Kits.plugin = plugin;
  }
  
public boolean onCommand(CommandSender sender, Command arg1, String label, String[] args)
  {
    Player p = Bukkit.getPlayerExact(sender.getName());
    if (args.length == 0)
    {
    	if (plugin.isGameStarted == true)
        {
          p.sendMessage(ChatColor.RED + "La partie à déjà commencer");
          return false;
        }
		showKits(p);
      return false;
    }
    else if(args.length >= 1)
    {
    	p.sendMessage("§aPour selectionner un kit : /kit <Nom de Votre kit>");
    }

    return false;
    }
    public static void showKits(Player p) {
  	  String owned = "";
    	String unowned = "";
    	for(me.Girardcome.HG.Misc.Kit str : me.Girardcome.HG.Misc.Kit.values()){
    		if(plugin.hasPermission(p.getUniqueId().toString(), "hg.kits." + str.name())){
    			owned = owned + str.name() + ", ";
    		}else{
    			unowned = unowned + str.name() + ", ";
    		}
    	}
    	p.sendMessage("§aVos kits: §f" + owned);
    	p.sendMessage("§aAutres kits: §f" + unowned);
    }
}
