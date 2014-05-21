package me.Girardcome.HG.Kits;

import java.util.Collection;

import me.Girardcome.HG.Main.Main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class Doctor implements Listener {
	public Main plugin;

	public Doctor(Main plugin) {
		this.plugin = plugin;
	}

	public boolean heal = false;
	@SuppressWarnings("deprecation")
	public int pairOfForcepsItemId = Material.SHEARS.getId();
	public String pairOfForcepsItemName = ChatColor.WHITE + "Pair of Forceps";
	public double toHeal = 5.0D;

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onRightClick(PlayerInteractEntityEvent event) {
		Player p = event.getPlayer();
		ItemStack kititem = p.getEnderChest().getItem(1);
		if ((kititem != null) && (kititem.getType() == Material.EMERALD)) {
			if (kititem.getItemMeta().getDisplayName()
					.equalsIgnoreCase("doctor")) {
				ItemStack item = event.getPlayer().getItemInHand();
				if (((event.getRightClicked() instanceof LivingEntity))
						&& (pairOfForcepsItemId == item.getTypeId())) {
					LivingEntity lEntity = (LivingEntity) event
							.getRightClicked();
					Collection<PotionEffect> effects = lEntity
							.getActivePotionEffects();
					for (PotionEffect effect : effects)
						lEntity.removePotionEffect(effect.getType());
					if (heal) {
						double health = lEntity.getHealth();
						health += toHeal;
						if (health > lEntity.getMaxHealth())
							health = lEntity.getMaxHealth();
						lEntity.setHealth(health);
					}
				}
			}
		}
	}
}
