package me.Girardcome.HG.Commands;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Invincibility implements CommandExecutor
{
  public Main plugin;
  
  public Invincibility(Main plugin)
  {
    this.plugin = plugin;
  }
  public boolean isInvincibilityForced = false;
public boolean onCommand(CommandSender sender, Command arg1, String label, String[] args)
  {
   
    if(args.length == 0) {
       
        if (!(sender instanceof Player)) {
         Player p = (Player) sender;
            if (!p.hasPermission("hg.command.start"))
            {
                String s = (String) plugin.getConfig().get("NoPerm");
                p.sendMessage(s);
                return false;
            } 
            else if(plugin.isGameStarted == false) {
                        p.sendMessage("§cLa partie n'a pas encore commencée !");
                        return false;
                 }
                } else {
        			Player p = Bukkit.getPlayerExact(sender.getName());
        			p.sendMessage("§aL'invincibilitée a été désactivée !");
                    Bukkit.broadcastMessage("§aL'invincibilitée a été désactivée par §c" + p.getName());
                        if(plugin.pretime <= -1) {
                         plugin.forceTimer();
                         plugin.time = 121;
                         isInvincibilityForced = true;
                return true;
                }
                }
       
  }
        return false;
  }
}
