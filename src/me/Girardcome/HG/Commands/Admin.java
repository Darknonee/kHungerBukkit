package me.Girardcome.HG.Commands;


import me.Girardcome.HG.Main.Main;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Admin
  implements CommandExecutor
{
  public Main plugin;
  
  public Admin(Main plugin)
  {
    this.plugin = plugin;
  }
  
  public boolean onCommand(CommandSender sender, Command arg1, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage(ChatColor.RED + "Cela doit etre un joueur !");
      return false;
    }
    if (!sender.hasPermission("hg.command.start"))
    {
    	sender.sendMessage((String) plugin.getConfig().get("NoPerm"));
    	return false;
    }
    Player p = (Player)sender;
    if ((p.isOp()) && (p.getGameMode() == GameMode.CREATIVE))
    {
      p.setGameMode(GameMode.SURVIVAL);
      p.sendMessage("§aVous êtes maintenant en mode §6Survie");
      p.showPlayer(p);
    }
    else if ((p.isOp()) && (p.getGameMode() == GameMode.SURVIVAL))
    {
      p.setGameMode(GameMode.CREATIVE);
      p.sendMessage("§aVous êtes maintenant en mode §6Créatif");
      p.hidePlayer(p);
    }
    return false;
  }
}