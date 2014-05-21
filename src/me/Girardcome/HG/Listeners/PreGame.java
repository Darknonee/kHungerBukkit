package me.Girardcome.HG.Listeners;

import me.Girardcome.HG.Main.Main;

import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PreGame implements Listener {
	public Main plugin;

	public PreGame(Main plugin) {
		this.plugin = plugin;
	}

	// Tout les événements désactivés avant le commencement de la partie
	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		Player p = event.getPlayer();
		if (plugin.isGameStarted == false) {
			if (p.getGameMode() == GameMode.CREATIVE) {
				event.setCancelled(false);
			} else {
				event.setCancelled(true);
			}
		}
		if (plugin.isGameStarted == true) {
			if (p.getGameMode() == GameMode.CREATIVE) {
				event.setCancelled(true);
			} else {
				event.setCancelled(false);
			}
		}
	}

	@EventHandler
	public void onHunger(FoodLevelChangeEvent event) {
		if (plugin.isGameStarted == false) {
			event.setCancelled(true);
		} else {
			event.setCancelled(true);
		}
		if (plugin.isInvincibilityEnded == true) {
			event.setCancelled(false);
		}
	}

	@EventHandler
	public void onPickup(PlayerPickupItemEvent event) {
		Player p = event.getPlayer();
		if (plugin.isGameStarted == false) {
			if (p.getGameMode() == GameMode.CREATIVE) {
				event.setCancelled(false);
			} else {
				event.setCancelled(true);
			}
		}
		if (plugin.isGameStarted == true) {
			if (p.getGameMode() == GameMode.CREATIVE) {
				event.setCancelled(true);
			} else {
				event.setCancelled(false);
			}
		}
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		Entity p = event.getEntity();
		Entity d = event.getDamager();
		if(d instanceof Player) { //SI L'ATTAQUANT FRAPPE UN JOUEUR
			if(((Player) d).getGameMode() == GameMode.CREATIVE) {
				event.setCancelled(true);
			}
			if(plugin.isGameStarted == false) {
				event.setCancelled(true);
			} else if(plugin.isGameStarted == true && plugin.isInvincibilityEnded == false) {
				event.setCancelled(true);
			} else if(plugin.isGameStarted == true && plugin.isInvincibilityEnded == true) {
				event.setCancelled(false);
			}
		} else if(d instanceof Monster) { //SI L'ATTAQUANT FRAPPE UN MOB
			if(((Player) d).getGameMode() == GameMode.CREATIVE) {
				event.setCancelled(true);
			}
			if(plugin.isGameStarted == false) { 
				event.setCancelled(true);
			} else if(plugin.isGameStarted == true && plugin.isInvincibilityEnded == false) {
				event.setCancelled(false);
			} else if(plugin.isGameStarted == true && plugin.isInvincibilityEnded == true) {
				event.setCancelled(false);
			}
		} else if(p instanceof Monster) { //SI LE JOUEUR SE FAIT FRAPPER PAR UN MOB
			if(plugin.isGameStarted == false) {
				event.setCancelled(true);
			} else if(plugin.isGameStarted == true && plugin.isInvincibilityEnded == false) {
				event.setCancelled(true);
			} else if(plugin.isGameStarted == true && plugin.isInvincibilityEnded == true) {
				event.setCancelled(false);
			}
		} else if(p instanceof Player) { //SI LE JOUEUR SE FAIT FRAPPER PAR UN JOUEUR
			if(plugin.isGameStarted == false) {
				event.setCancelled(true);
			} else if(plugin.isGameStarted == true && plugin.isInvincibilityEnded == false) {
				event.setCancelled(true);
			} else if(plugin.isGameStarted == true && plugin.isInvincibilityEnded == true) {
				event.setCancelled(false);
			}
		}
	}

	@EventHandler
	public void onDamaged(EntityDamageEvent event) {
		if(plugin.isGameStarted == false) {
			event.setCancelled(true);
		} else if(plugin.isGameStarted == true && plugin.isInvincibilityEnded == true) {
			event.setCancelled(false);
		}
	}

	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		if ((plugin.isGameStarted == false)) {
			if (event.getPlayer().getGameMode() == GameMode.CREATIVE) {
				event.setCancelled(false);
			} else {
				event.setCancelled(true);
			}

		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBreak(BlockPlaceEvent event) {
		if (plugin.isGameStarted == false) {
			if (event.getPlayer().getGameMode() == GameMode.CREATIVE) {
				event.setCancelled(false);
			} else {
				if (event.getPlayer().getGameMode() == GameMode.SURVIVAL) {
					event.setCancelled(true);
					event.getPlayer().updateInventory();
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBreaks(BlockPlaceEvent event) {
		if (plugin.isGameStarted == false) {
			if (event.getPlayer().getGameMode() == GameMode.CREATIVE) {
				event.setCancelled(false);
			} else {
				if (event.getPlayer().getGameMode() == GameMode.SURVIVAL) {
					event.setCancelled(true);
					event.getPlayer().updateInventory();
				}
			}
		}
	}
}