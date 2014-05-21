package me.Girardcome.HG.Commands;


import me.Girardcome.HG.Main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Start
  implements CommandExecutor
{
	  public Main plugin;
	  
	  public Start(Main plugin)
	  {
	    this.plugin = plugin;
	  }
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if (plugin.isGameStarted == true)
    {
    	sender.sendMessage("§cLa partie a déjà commencée !");
    	return false;
    }
    if (!sender.hasPermission("hg.command.start"))
    {
    	sender.sendMessage((String) plugin.getConfig().get("NoPerm"));
    	return false;
    }
    if(Bukkit.getOnlinePlayers().length <= 1){
        if (sender.hasPermission("hg.command.start")) {
        	sender.sendMessage(ChatColor.RED + "Vous ne pouvez pas commencer la partie avec un seul joueur !");
          }
          return false;
    	
    }
    if (args.length > 1)
    {
      sender.sendMessage(ChatColor.RED + "Un seul argument suffit !");
      return false;
    }
    if (args.length == 1) {
      try
      {
        int newtime = Integer.parseInt(args[0]);
        plugin.pretime = newtime;
        Bukkit.getServer().broadcastMessage(ChatColor.RED + "Le décompte a été changé à " + newtime + " par " + sender.getName());
        return true;
      }
      catch (Exception e)
      {
        sender.sendMessage(ChatColor.RED + args[0] + " n'est pas un chiffre ou un nombre.");
        return false;
      }
    }
    plugin.Start();
    plugin.pretime = -1;
    Bukkit.getScheduler().cancelTask(plugin.PreGameTimerTask);
    plugin.invTimer();
    return false;
  }
}
