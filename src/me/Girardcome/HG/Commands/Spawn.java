package me.Girardcome.HG.Commands;

import java.util.Random;

import me.Girardcome.HG.Main.Main;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn
  implements CommandExecutor
{
	  public Main plugin;
	  
	  public Spawn(Main plugin)
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
    if (plugin.isGameStarted == true)
    {
      sender.sendMessage(ChatColor.RED + "La partie à déjà commencée !");
      return false;
    }
    if ((plugin.pretime <= -1) && (sender.isOp())) {
      return true;
    }
    Player p = (Player)sender;
    Location loc = p.getLocation();
    Random rand = new Random();
    loc.setX(rand.nextInt(1001) - 500);
    loc.setZ(rand.nextInt(1001) - 500);
    loc.setY(p.getWorld().getHighestBlockYAt(loc));
    p.teleport(loc);
    return true;
  }
}
