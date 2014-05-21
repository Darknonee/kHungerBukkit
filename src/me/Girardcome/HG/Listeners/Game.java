package me.Girardcome.HG.Listeners;

import java.util.HashMap;

import me.Girardcome.HG.Main.Main;
import me.Girardcome.HG.Managers.FeastManager;
import me.Girardcome.HG.Misc.Kit;
import me.Girardcome.HG.Misc.KitManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Game implements Listener {

	public Main plugin;

	public Game(Main plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		if(plugin.isGameStarted == true) {
			e.setQuitMessage(null);
		}
	}
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		final Player killed = event.getEntity().getPlayer();
		final Player killere = event.getEntity().getKiller();
		final String killedname = killed.getName();
		if (killed.getGameMode() == GameMode.CREATIVE) {
			return;
		}
		HashMap<String, Kit> kits = KitManager.getKitHashmap();
		String kit = kits.get(killed.getName()).name();
		if (!kits.containsKey(killed.getName())) {
			kit = "None";
		}
		if (kit == null) {
			kit = "None";
		}

		if (killed.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.LAVA) {
			event.setDeathMessage(ChatColor.AQUA + killedname + "(" + kit + ")"
					+ " a joué(e) trop près de la piscine de lave !");
		}

		int random = (int) FeastManager.randomInt(1, 2);
		if (killed.getLastDamageCause() == null || killed.getLastDamageCause().getCause() == null)
			return;
		if (killed.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FALL) {
			if (random == 1)
				event.setDeathMessage(ChatColor.AQUA + killedname + "(" + kit
						+ ")" + " est mort(e) d'une chute !");
			else
				event.setDeathMessage(ChatColor.AQUA + killedname + "(" + kit
						+ ")"
						+ " a apparemment jamais entendu parler d'escaliers !");
		} else if (killed.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.CONTACT)
			event.setDeathMessage(ChatColor.AQUA + killedname + "(" + kit + ")"
					+ " est mort piqué(e) !");
		else if (killed.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.STARVATION)
			event.setDeathMessage(ChatColor.AQUA + killedname + "(" + kit + ")"
					+ " est mort(e) de faim !");
		else if (killed.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.LAVA) {
			if (random == 1)
				event.setDeathMessage(ChatColor.AQUA + killedname + "(" + kit
						+ ")" + " a joué(e) trop près de la piscine de lave !");
			else
				event.setDeathMessage(ChatColor.AQUA + killedname + "(" + kit
						+ ")" + " a tenter de nager dans la lave !");
		} else if (killed.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FIRE)
			event.setDeathMessage(ChatColor.AQUA + killedname + "(" + kit + ")"
					+ " est mort(e) brulé(e) vif !");
		else if (killed.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.SUICIDE)
			event.setDeathMessage(ChatColor.AQUA + killedname + "(" + kit + ")"
					+ " suicided.");
		else if (event.getDeathMessage().contains("Ghast"))
			event.setDeathMessage(ChatColor.AQUA + killedname + "(" + kit + ")"
					+ " a couru(e) dans le §6Forcefield §2!");
		else {
			event.setDeathMessage(ChatColor.AQUA + event.getDeathMessage()
					+ ".");
		}
		if ((killere instanceof Player)) {
			Player killer = event.getEntity().getKiller();
			String killername = killer.getName();
			event.setDeathMessage(ChatColor.AQUA + killedname + "("
					+ getPlayerKit(killed) + ")" + " a été tué par "
					+ killername + "(" + getPlayerKit(killer) + ")");
		}
		if (killed.isOp() || killed.hasPermission("unyhg.mod")) {
			killed.setGameMode(GameMode.CREATIVE);
			for (Player pl : Bukkit.getOnlinePlayers()) {
				if (!pl.getGameMode().equals(GameMode.CREATIVE)) {
					pl.hidePlayer(killed);
				}
			}
			killed.sendMessage("§5Vous êtes maintenant invisible pour les MOD+ et autres");
			killed.sendMessage("§cVous êtes en mode créatif et en invisible car vous êtes mort.");
		} else {
			killed.kickPlayer("Vous avez perdu(e) ! " + ChatColor.AQUA
					+ event.getDeathMessage());
		}
		plugin.Check();
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			@Override
			public void run() {
				if(!killere.hasPermission("hg.mod")) {
				Bukkit.broadcastMessage("§e" + killed.getName() + " left the game");
			}
			
		}}, 10L);
	}

	private String getPlayerKit(Player killed) {
		HashMap<String, Kit> kits = KitManager.getKitHashmap();
		String kit = kits.get(killed.getName()).name();
		if (!kits.containsKey(killed.getName())) {
			kit = "None";
		}
		if (kit == null) {
			kit = "None";
		}
		return kit;
	}
	

}
