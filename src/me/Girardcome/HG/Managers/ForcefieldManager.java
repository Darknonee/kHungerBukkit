package me.Girardcome.HG.Managers;

import java.util.Random;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ForcefieldManager {

	public static Main plugin;

	public ForcefieldManager(Main plugin) {
		ForcefieldManager.plugin = plugin;
	}

	public static void Forcefield() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					Location loc = p.getLocation();
					if ((loc.getX() > 500.0D) || (loc.getZ() > 500.0D)
							|| (loc.getX() < -500.0D) || (loc.getZ() < -500.0D)
							&& plugin.pretime <= -1) {
						p.sendMessage("§6§lVOUS ETES DANS LE FORCEFIELD !!! COUUURREEEEZZZZZ");
					}
				}
			}
		}, 10L, 5L);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					Location loc = p.getLocation();
					if (plugin.time <= 300 && plugin.isGameStarted == true
							&& plugin.isGameEnded == false && plugin.time != -1) {

					} else if ((loc.getX() > 500.0D) || (loc.getZ() > 500.0D)
							|| (loc.getX() < -500.0D) || (loc.getZ() < -500.0D)
							&& plugin.pretime > -1) {
						Random rand = new Random();
						loc.setX(rand.nextInt(1001) - 500);
						loc.setZ(rand.nextInt(1001) - 500);
						loc.setY(p.getWorld().getHighestBlockYAt(loc));
						p.teleport(loc);
						p.sendMessage("§cVous avez été téléporté(e) car vous avez franchis le forcefield.");
					}
				}
			}
		}, 10L, 10L);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					Location loc = p.getLocation();
					if (plugin.time <= 300 && plugin.isGameStarted == true
							&& plugin.isGameEnded == false && plugin.time != -1) {

					} else if ((loc.getX() > 500.0D) || (loc.getZ() > 500.0D)
							|| (loc.getX() < -500.0D) || (loc.getZ() < -500.0D)
							&& plugin.pretime <= -1) {
						p.damage(4.0D);
					}
				}
			}
		}, 10L, 10L);

		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					Location loc = p.getLocation();
					if (plugin.time <= 300 && plugin.isGameStarted == true
							&& plugin.isGameEnded == false && plugin.time != -1) {

					} else if (((loc.getX() > 475.0D) && (loc.getX() < 500.0D))
							|| ((loc.getZ() > 475.0D) && (loc.getZ() < 500.0D))
							|| ((loc.getX() < -475.0D) && (loc.getX() > -500.0D))
							|| ((loc.getZ() < -475.0D) && (loc.getZ() > -500.0D))
							&& plugin.pretime > -1) {
					}
				}
			}
		}, 10L, 20L);

		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					Location loc = p.getLocation();
					if (plugin.time <= 300 && plugin.isGameStarted == true
							&& plugin.isGameEnded == false && plugin.time != -1) {

					} else if (((loc.getX() > 475.0D) && (loc.getX() < 500.0D))
							|| ((loc.getZ() > 475.0D) && (loc.getZ() < 500.0D))
							|| ((loc.getX() < -475.0D) && (loc.getX() > -500.0D))
							|| ((loc.getZ() < -475.0D) && (loc.getZ() > -500.0D))
							&& plugin.pretime <= -1) {
						p.sendMessage("§6ATTENTION !! Le forcefield est proche !");
					}
				}
			}
		}, 10L, 20L);
	}
}
