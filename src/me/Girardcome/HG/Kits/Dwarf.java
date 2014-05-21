package me.Girardcome.HG.Kits;

import java.util.HashMap;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class Dwarf implements Listener {
	public Main plugin;

	public Dwarf(Main plugin) {
		this.plugin = plugin;
	}

	public int cooldown = 30;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private HashMap<Player, Long> cooldownExpires = new HashMap();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private HashMap<Player, Long> startedSneaking = new HashMap();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onSneak(PlayerToggleSneakEvent event) {
		Player p = event.getPlayer();
		ItemStack kititem = p.getEnderChest().getItem(1);
		if ((kititem != null) && (kititem.getType() == Material.EMERALD)) {
			if (kititem.getItemMeta().getDisplayName()
					.equalsIgnoreCase("dwarf")) {
				if ((cooldownExpires.containsKey(p))
						&& (((Long) cooldownExpires.get(p)).longValue() < System
								.currentTimeMillis()))
					cooldownExpires.remove(p);
				if (event.isSneaking()) {
					startedSneaking.put(p,
							Long.valueOf(System.currentTimeMillis()));
				} else if (startedSneaking.containsKey(p)) {
					cooldownExpires.put(
							p,
							Long.valueOf(System.currentTimeMillis()
									+ cooldown * 1000));
					long sneakingTime = System.currentTimeMillis()
							- ((Long) startedSneaking.remove(p))
									.longValue();
					double knockBack = 0.5D * (sneakingTime / 1000L);
					for (Entity entity : p.getNearbyEntities(knockBack,
							knockBack, knockBack)) {
						if (((entity instanceof Player))
								&& (((Player) entity).isSneaking()))
							continue;
						Vector vector = entity.getLocation().toVector()
								.subtract(p.getLocation().toVector())
								.normalize();
						entity.setVelocity(vector.multiply(knockBack));
						Bukkit.getScheduler().scheduleAsyncRepeatingTask(null,
								new Runnable() {
									public void run() {
										for (Player p : Bukkit
												.getOnlinePlayers()) {
											if (p.isSneaking()) {
												return;
											}
											p.sendMessage("Chargement 10%");
										}
									}
								}, 20L, 20L);

					}
				}
			}
		}
	}
}
