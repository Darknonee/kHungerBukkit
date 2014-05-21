package me.Girardcome.HG.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Messages
  implements CommandExecutor
{

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (args.length == 0)
    {
      sender.sendMessage("§cFaites /m ou /msg ou /w");
    }
    else if (args.length > 1)
    {
      Player player = Bukkit.getPlayer(args[0]);
      if (player == null)
      {
        sender.sendMessage(ChatColor.RED + "Player not online");
        return true;
      }
      String message = "";
      for (int i = 1; i < args.length; i++) {
        message = message + (i > 1 ? " " : "") + args[i];
      }
      sender.sendMessage(message);
      player.sendMessage(ChatColor.GRAY + "<" + sender.getName() + " -> " + player.getName() + "> " + message);
      sender.sendMessage(ChatColor.GRAY + "<" + sender.getName() + " -> " + player.getName() + "> " + message);
    }
    else
    {
      sender.sendMessage(ChatColor.RED + "What is the message?");
    }
    return true;
  }
}
