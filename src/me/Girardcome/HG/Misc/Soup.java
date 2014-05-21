package me.Girardcome.HG.Misc;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Soup implements Listener {
	@EventHandler
	public void onPlayerSoup(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (player.getHealth() != 20.0D) {
			int soup = 7;
			if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
				if (player.getItemInHand().getType() == Material.MUSHROOM_SOUP) {
					player.setHealth(player.getHealth() + soup > player.getMaxHealth() ? player.getMaxHealth() : player.getHealth() + soup);
					event.getPlayer().getItemInHand().setType(Material.BOWL);
				}
			}
		}
	}
}
