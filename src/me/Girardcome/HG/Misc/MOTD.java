package me.Girardcome.HG.Misc;

import me.Girardcome.HG.Main.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MOTD
  implements Listener
{
  public Main plugin;
  
  public MOTD(Main plugin)
  {
    this.plugin = plugin;
  }
  
  @EventHandler
  public void onServerListPing(ServerListPingEvent event)
  {
	    event.setMotd("§c[§aJCPVP§c] §bPouvez-vous survivre ? \n§ePlugin : 81%");
  }
}
