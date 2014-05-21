package me.Girardcome.HG.Commands;

import me.Girardcome.HG.Main.Main;
import me.Girardcome.HG.Misc.Kit;
import me.Girardcome.HG.Misc.KitManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KitCommand implements CommandExecutor {
	public Main plugin;

	public KitCommand(Main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command arg1, String label,
			String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
		if (args.length == 0) {
			Kits.showKits(p);
			return true;
		} else if (args.length == 3) {
			String kit = args[2];
			String giveOrRemove = args[0];
			if (giveOrRemove.equalsIgnoreCase("remove")) {
				for (Kit kit2 : Kit.values()) {
					Player target = Bukkit.getServer().getPlayer(args[1]);
					if (kit2.name().toLowerCase().equalsIgnoreCase(kit.toLowerCase())) {
						p.sendMessage("�7Tu as retir� le kit �7" + kit2.name() + " �7� �f"+ target.getName());
						target.sendMessage("�cVotre kit " + kit2.name() + " a �t� retir� !");
						Main.perms.playerRemove(target, "hg.kits." + kit2.name());
						return true;
					}
				}
				//
			} else if (giveOrRemove.equalsIgnoreCase("give")) {
				for (Kit kit2 : Kit.values()) {
					Player target = Bukkit.getServer().getPlayer(args[1]);
					if (kit2.name().toLowerCase().equalsIgnoreCase(kit.toLowerCase())) {
						p.sendMessage("�7Tu as ajout� le kit �7" + kit2.name() + " �7� �f"+ target.getName());
						target.sendMessage("�aLe kit " + kit2.name() + " vous a �t� ajout� !");
						Main.perms.playerAdd(target, "hg.kits." + kit2.name());
						if(!target.hasPermission("hg.kits." + kit2.name())) {
							Bukkit.broadcastMessage("�4" + target.getName() + " have not the permission !");
						} else {
							Bukkit.broadcastMessage("�c" + target.getName() + " have the permission !");
						} 
						return true;
					}
				}
			} else {
				p.sendMessage("�cVous n'avez pas sp�cifiez si vous voulez donner ou retirer le Kit....");
			}
		} else if (args.length == 1) {
			String kit = args[0];
			String kitApply = plugin.getConfig().getString("Messages.KitApply");
			for (Kit kit2 : Kit.values()) {
				String name = kit2.name();
				if (kit2.name().toLowerCase().equalsIgnoreCase(kit.toLowerCase())) {
					Bukkit.broadcastMessage(String.valueOf(sender.hasPermission("hg.kits." + kit2.name())));
					if (sender.hasPermission("hg.kits." + kit2.name())) {
						KitManager.setKit(p, kit2);
						kitApply = kitApply.replace("%kit", name);
						kitApply = kitApply.replace("%e", "�");
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', kitApply));
					}else {
						String noKitPermission = plugin.getConfig().getString("Messages.noKitPermission");
						noKitPermission = noKitPermission.replace("%up", "'");
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', noKitPermission));
					}
					return true;
				}
			}
			String noKitFounded = plugin.getConfig().getString("Messages.noKitFounded").replace("%kit", args[0]).replace("%eh", "�").replace("%up", "'");
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', noKitFounded));
		}
		return true;
	}
		return true;
	}
}