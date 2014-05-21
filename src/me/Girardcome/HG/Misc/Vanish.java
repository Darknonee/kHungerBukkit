package me.Girardcome.HG.Misc;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Vanish
  implements CommandExecutor, Listener
{
  @SuppressWarnings({ "unchecked", "rawtypes" })
public List<Player> vanish = new ArrayList();
  
  public void onJoin(PlayerJoinEvent event)
  {
    Player p = event.getPlayer();
    event.setJoinMessage(null);
    if (p.isOp())
    {
      for (Player op : Bukkit.getOnlinePlayers()) {
        if (!op.isOp()) {
          op.hidePlayer(event.getPlayer());
        }
      }
      p.setGameMode(GameMode.CREATIVE);
      p.sendMessage(ChatColor.GREEN + 
        "You are invisible because you're op, /show to Girardcomee yourself visible");
    }
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage(ChatColor.RED + "Vous n'êtes pas un joueur !");
      return false;
    }
    Player p = (Player)sender;
    if (vanish.contains(p))
    {
      for (Player p1 : Bukkit.getOnlinePlayers()) {
        p1.showPlayer(p);
      }
      vanish.remove(p);
      p.sendMessage(ChatColor.GREEN + "Vous êtes maintenant §cvisible §aà tout le monde !");
      return true;
    }
    if (!vanish.contains(p))
    {
      for (Player p1 : Bukkit.getOnlinePlayers()) {
        if (!p1.isOp()) {
          p1.hidePlayer(p);
        }
      }
      vanish.add(p);
      p.sendMessage(ChatColor.GREEN + 
        "Vous êtes maintenant §6invisible §apour tout les joueurs !");
    }
    return true;
  }
}
