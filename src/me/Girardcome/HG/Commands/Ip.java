package me.Girardcome.HG.Commands;

import me.Girardcome.HG.Main.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class Ip
  implements CommandExecutor
{
	Plugin plugin;
  public Ip(Main Main) {
		plugin = Main;
	}

public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3)
  {
	sender.sendMessage("§7IP Désactivée !");
    return false;
  }
}
