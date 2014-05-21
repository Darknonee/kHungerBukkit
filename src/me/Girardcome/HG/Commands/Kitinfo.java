package me.Girardcome.HG.Commands;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Girardcome.HG.Misc.Kit;

public class Kitinfo implements CommandExecutor
{
  public Main plugin;
  
  public Kitinfo(Main plugin)
  {
    this.plugin = plugin;
  }
  
public boolean onCommand(CommandSender sender, Command arg1, String label, String[] args)
  {
    Player p = Bukkit.getPlayerExact(sender.getName());
    if (args.length == 0)
    {
    	p.sendMessage("§aFaites /kitinfo [Nom Du Kit]");
    	p.sendMessage("§bExemple : /kitinfo Archer");
      return false;
    };
    if(args.length == 1) {
    	Boolean found = false;
    	for(Kit kit : Kit.values()){
    		if(args[0].toLowerCase().equalsIgnoreCase(kit.name().toLowerCase())){
    			found = true;
    			break;
    		}
    	}
    	if(found == false){
    		p.sendMessage("§cCe kit n'existe pas.");
    		return true;
    	}
    	if(args[0].equalsIgnoreCase("archer")) {
    		p.sendMessage("§aArcher : §fLes poules drops tout le temps 2 plumes. Quand vous cassez un gravier, cela vous donnera tout le temps un silex. Quand vous touchez un joueur la flèche revient dans votre inventaire.");
    	}
    	if(args[0].equalsIgnoreCase("anchor")) {
    		p.sendMessage("§aAnchor : §fLorsque vous êtes en combat, vous ne recevez aucun recul (Knockback) et vous n'en donnez aucun.");
    	}
    	if(args[0].equalsIgnoreCase("Backup")) {
    		p.sendMessage("§aBackup : §fVous débutez avec un sélécteur de kit, il vous permet de séléctionner un kit après le début de la partie. Vous commencez la partie avec aucun kit.");
    	}
    	if(args[0].equalsIgnoreCase("Barbarian")) {
    		p.sendMessage("§aBarbarian : §fVous débutez avec une épée spéciale (en bois), à chaque kill votre épée s'améliore.");
    	}
    	if(args[0].equalsIgnoreCase("Beastmaster")) {
    		p.sendMessage("§aBeastmaster : §fVous avez 100% de chance d'apprivoiser un loup.");
    	}
    	if(args[0].equalsIgnoreCase("Berserker")) {
    		p.sendMessage("§aBerserker : §fLorsque vous tuez quelqu'un, chaque coup donné vous donne Force I et Vitesse I par coup durant 0,25 secondes.");
    	}
    	if(args[0].equalsIgnoreCase("Boxer")) {
    		p.sendMessage("§aBoxer : §fVos poings vont plus de dommages qu\'une épée en bois. Les dommages entrants sont légèrement réduits.");
    	}
    	if(args[0].equalsIgnoreCase("Burrower")) {
    		p.sendMessage("§aBurrower : §fQuand vous cliquez sur une boule de slime sur un block, et vous serez téléportez sous-terre dans une chambre de secours, la boule de slime vous sera remise 5 minutes après l'utilisation pour le re-utiliser.");
    	}
    	if(args[0].equalsIgnoreCase("Camel")) {
    		p.sendMessage("§aCamel : §fVous pouvez crafter 1 cactus et un 1 bloc de sable ce qui vous donnera une soupe, et vous avez Vitesse I dans le désert.");
    	}
    	if(args[0].equalsIgnoreCase("Cannibal")) {
    		p.sendMessage("§aCannibal : §fTapez un ennemy et votre barre de faim augmentera. Apprivoisez votre ocelot pour effrayer les creepers.");
    	}
    	if(args[0].equalsIgnoreCase("Chameleon")) {
    		p.sendMessage("§aChameleon : §fVous débutez avec un blé, l'utiliser sur un animal vous donnera l'oeuf de celui ci. Tenir un œuf dans votre main vous transformera en l'animal en question.");
    	}
    	if(args[0].equalsIgnoreCase("Crafter")) {
    		p.sendMessage("§aCrafter : §fUn clique droit sur les items et cela ouvrira leur inventaires respectifs.");
    	}
    	if(args[0].equalsIgnoreCase("Cookiemonster")) {
    		p.sendMessage("§aCookiemonster : §fFaites un clique droit sur votre cookie, ce qui va instantanément soigné votre barre de faim. Si votre alimentation est pleine, vos coeurs seront soignées (coeur par coeur). Si votre barre de faim et vos coeurs sont tous soignées,  vous avez un bonus de Vitesse II !");
    	}
    	if(args[0].equalsIgnoreCase("Cultivator")) {
    		p.sendMessage("§aCultivator : §fLes graines se développent en blé instantanément lorsqu'elles sont plantées.");
    	}
    	if(args[0].equalsIgnoreCase("Demoman")) {
    		p.sendMessage("§aDemoman : §fQuand un ennemi marche sur une plaque de pression d'un Demoman, il explosera instantanément !");
    	}
    	if(args[0].equalsIgnoreCase("Digger")) {
    		p.sendMessage("§aDigger : §fPlacez un oeuf de dragon sur le sol, après 1.5 secondes, un trou de 5x5 apparaîtra en dessous de l'oeuf.");
    	}
    	if(args[0].equalsIgnoreCase("Doctor")) {
    		p.sendMessage("§aDoctor : §fCliquez sur un joueur ce qui lui enlevera tout ses effets de potions.");
    	}
    	if(args[0].equalsIgnoreCase("Endermage")) {
    		p.sendMessage("§aEndermage : §fTéléportez les joueurs de 1-2 blocs de votre portail d'Endermage là où vous l'avez placé, vous serez également téléportez.");
    	}
    	if(args[0].equalsIgnoreCase("Fireman")) {
    		p.sendMessage("§aFireman : §fVous êtes à l'abri des foudres du Thor. Vous êtes insensible à la lave pendant 10 secondes (1 minute de Cooldown).");
    	}
    	if(args[0].equalsIgnoreCase("Fisherman")) {
    		p.sendMessage("§aFisherman : §fVous commencez avec une canne à pêche qui peut ramener les joueurs vers vous.");
    	}
    	if(args[0].equalsIgnoreCase("Flash")) {
    		p.sendMessage("§aFlash : §fVous débutez avec une torche de redstone, faire un clique droit avec celle-ci vous téléportera a l'endroit ciblé, après utilisation il faut attendre 60 secondes pour la réutiliser.");
    	}
    	if(args[0].equalsIgnoreCase("Forger")) {
    		p.sendMessage("§aForger : §fPlacer un charbon sur un minerai de fer dans votre inventaire fera cuire instantanée le minerai.");
    	}
    	if(args[0].equalsIgnoreCase("Frosty")) {
    		p.sendMessage("§aFrosty : §fPlacer un charbon sur un minerai de fer dans votre inventaire fera cuire instantanée le minerai.");
    	}
    	
    }
	return false;
  }
}
