package me.Girardcome.HG.Misc;

import java.util.ArrayList;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class KitSelector implements Listener, CommandExecutor {
	public Main plugin;

	// TODO
	public KitSelector(Main plugin) {
		this.plugin = plugin;
		createInventories();
	}

	public static KitSelector instance;
	public static Inventory inv;
	public static Inventory otherskits;
	public static Inventory archerkit;
	public static Inventory anchorkit;
	public static Inventory beastmasterkit;
	public static Inventory berserkerkit;
	public static Inventory boxerkit;
	public static Inventory camelkit;
	public static Inventory cannibalkit;
	public static Inventory chameleonkit;
	public static Inventory chemistkit;
	public static Inventory cookiemonsterkit;
	public static Inventory cultivatorkit;
	public static Inventory demomankit;
	public static Inventory diggerkit;
	public static Inventory doctorkit;
	public static Inventory dwarfkit;
	public static Inventory endermagekit;
	public static Inventory firemankit;
	public static Inventory fishermankit;
	public static Inventory flashkit;
	public static Inventory forgerkit;
	public static Inventory frostykit;
	public static Inventory gamblerkit;
	public static Inventory grandpakit;
	public static Inventory gravediggerkit;
	public static Inventory hermitkit;
	public static Inventory hulkkit;
	public static Inventory hunterkit;
	public static Inventory jackhammerkit;
	public static Inventory jumperkit;
	public static Inventory kangarookit;
	public static Inventory kayakit;
	public static Inventory launcherkit;
	public static Inventory levitatorkit;
	public static Inventory lumberjackkit;
	public static Inventory minerkit;
	public static Inventory monsterkit;
	public static Inventory necrokit;
	public static Inventory phantomkit;
	static ItemStack paper = new ItemStack(Material.EMPTY_MAP);
	{
		ItemMeta cpet = paper.getItemMeta();
		cpet.setDisplayName("§6Afficher l'icône du kit");
		paper.setItemMeta(cpet);
	}
	ItemStack book = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = book.getItemMeta();
		cpet.setDisplayName("§eDescription");
		book.setItemMeta(cpet);
	}
	ItemStack compass = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = compass.getItemMeta();
		cpet.setDisplayName("§9Strategies");
		compass.setItemMeta(cpet);
	}
	ItemStack emerald = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = emerald.getItemMeta();
		cpet.setDisplayName("§9Strategies");
		emerald.setItemMeta(cpet);
	}
	static ItemStack leftcarpet = new ItemStack(Material.CARPET, 1, (short) 8);
	{
		ItemMeta cpet = leftcarpet.getItemMeta();
		cpet.setDisplayName(" ");
		leftcarpet.setItemMeta(cpet);
	}
	static ItemStack rightcarpet = new ItemStack(Material.CARPET);
	{
		ItemMeta cpet = rightcarpet.getItemMeta();
		cpet.setDisplayName(" ");
		rightcarpet.setItemMeta(cpet);
	}
	static ItemStack thinglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = thinglass.getItemMeta();
		cpet.setDisplayName(" ");
		thinglass.setItemMeta(cpet);
	}
	static ItemStack anchorglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = anchorglass.getItemMeta();
		cpet.setDisplayName("§0");
		anchorglass.setItemMeta(cpet);
	}
	static ItemStack archerglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = archerglass.getItemMeta();
		cpet.setDisplayName("§1");
		archerglass.setItemMeta(cpet);
	}
	static ItemStack beastmasterglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = beastmasterglass.getItemMeta();
		cpet.setDisplayName("§2");
		beastmasterglass.setItemMeta(cpet);
	}
	static ItemStack berserkerglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = berserkerglass.getItemMeta();
		cpet.setDisplayName("§3");
		berserkerglass.setItemMeta(cpet);
	}
	static ItemStack boxerglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = boxerglass.getItemMeta();
		cpet.setDisplayName("§4");
		boxerglass.setItemMeta(cpet);
	}
	static ItemStack cannibalglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = cannibalglass.getItemMeta();
		cpet.setDisplayName("§5");
		cannibalglass.setItemMeta(cpet);
	}
	static ItemStack chemistglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = chemistglass.getItemMeta();
		cpet.setDisplayName("§6");
		chemistglass.setItemMeta(cpet);
	}
	static ItemStack cookiemonsterglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = cookiemonsterglass.getItemMeta();
		cpet.setDisplayName("§7");
		cookiemonsterglass.setItemMeta(cpet);
	}
	static ItemStack cultivatorglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = cultivatorglass.getItemMeta();
		cpet.setDisplayName("§8");
		cultivatorglass.setItemMeta(cpet);
	}
	static ItemStack demomanglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = demomanglass.getItemMeta();
		cpet.setDisplayName("§9");
		demomanglass.setItemMeta(cpet);
	}
	static ItemStack diggerglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = diggerglass.getItemMeta();
		cpet.setDisplayName("§a");
		diggerglass.setItemMeta(cpet);
	}
	static ItemStack doctorglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = doctorglass.getItemMeta();
		cpet.setDisplayName("§b");
		doctorglass.setItemMeta(cpet);
	}
	static ItemStack dwarfglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = dwarfglass.getItemMeta();
		cpet.setDisplayName("§c");
		dwarfglass.setItemMeta(cpet);
	}
	static ItemStack endermageglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = endermageglass.getItemMeta();
		cpet.setDisplayName("§d");
		endermageglass.setItemMeta(cpet);
	}
	static ItemStack firemanglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = firemanglass.getItemMeta();
		cpet.setDisplayName("§e");
		firemanglass.setItemMeta(cpet);
	}
	static ItemStack fishermanglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = fishermanglass.getItemMeta();
		cpet.setDisplayName("§f");
		fishermanglass.setItemMeta(cpet);
	}
	static ItemStack forgerglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = forgerglass.getItemMeta();
		cpet.setDisplayName("§k");
		forgerglass.setItemMeta(cpet);
	}
	static ItemStack frostyglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = frostyglass.getItemMeta();
		cpet.setDisplayName("§l");
		frostyglass.setItemMeta(cpet);
	}
	static ItemStack grandpaglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = grandpaglass.getItemMeta();
		cpet.setDisplayName("§n");
		grandpaglass.setItemMeta(cpet);
	}
	static ItemStack hermitglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = hermitglass.getItemMeta();
		cpet.setDisplayName("§o");
		hermitglass.setItemMeta(cpet);
	}
	static ItemStack hunterglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = hunterglass.getItemMeta();
		cpet.setDisplayName("§k ");
		hunterglass.setItemMeta(cpet);
	}
	static ItemStack jumperglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = jumperglass.getItemMeta();
		cpet.setDisplayName("§f ");
		jumperglass.setItemMeta(cpet);
	}
	static ItemStack kangarooglass = new ItemStack(Material.THIN_GLASS);
	{
		ItemMeta cpet = kangarooglass.getItemMeta();
		cpet.setDisplayName("§a ");
		kangarooglass.setItemMeta(cpet);
	}
	static ItemStack powder = new ItemStack(Material.SULPHUR);
	{
		ItemMeta cpet = powder.getItemMeta();
		cpet.setDisplayName(" ");
		powder.setItemMeta(cpet);
	}
	static ItemStack Anchor = new ItemStack(Material.ANVIL);
	{
		ItemMeta cpet = Anchor.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fAnchor");
		cc.add("§fVous ne prenez pas de recul, et vous");
		cc.add("§fn'en donnez pas.");
		cpet.setLore(cc);
		Anchor.setItemMeta(cpet);
	}
	static ItemStack Archer = new ItemStack(Material.BOW);
	{
		ItemMeta cpet = Archer.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fArcher");
		cc.add("§fVous commencez la partie avec un arc");
		cc.add("§fet 10 flèches, vous fabriquez des flèches facilement");
		cpet.setLore(cc);
		Archer.setItemMeta(cpet);
	}
	static ItemStack Beastmaster = new ItemStack(Material.MONSTER_EGG);
	{
		ItemMeta cpet = Beastmaster.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fBeastmaster");
		cc.add("§fVous commencez avec 3 oeufs de loup, et 4 os,");
		cc.add("§fvous avez 100% de chance de capturer vos loups.");
		cpet.setLore(cc);
		Beastmaster.setItemMeta(cpet);
	}
	static ItemStack Berserker = new ItemStack(Material.IRON_SWORD);
	{
		ItemMeta cpet = Berserker.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fBerserker");
		cc.add("§fVous avez Force I et Vitesse I pendant 0.25 secondes,");
		cc.add("§fà chaque coup porter sur un joueur.");
		cpet.setLore(cc);
		Berserker.setItemMeta(cpet);
	}
	static ItemStack Boxer = new ItemStack(Material.STONE_SWORD);
	{
		ItemMeta cpet = Boxer.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fBoxer");
		cc.add("§fVos mains font presque autant de dégâts qu'une");
		cc.add("§fépée en pierre. Les dommages entrant sont légèrement réduit.");
		cpet.setLore(cc);
		Boxer.setItemMeta(cpet);
	}
	static ItemStack Burrower = new ItemStack(Material.SLIME_BALL);
	{
		ItemMeta cpet = Burrower.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fBurrower");
		cc.add("§fCréez votre propre salle de panique personelle");
		cc.add("§fen un instant.");
		cpet.setLore(cc);
		Burrower.setItemMeta(cpet);
	}
	static ItemStack Camel = new ItemStack(Material.CACTUS);
	{
		ItemMeta cpet = Camel.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fCamel");
		cc.add("§fLe désert est votre maison, vous donnant des");
		cc.add("§favantages dans les déserts.");
		cpet.setLore(cc);
		Camel.setItemMeta(cpet);
	}
	static ItemStack Cannibal = new ItemStack(Material.RAW_CHICKEN);
	{
		ItemMeta cpet = Cannibal.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fCannibal");
		cc.add("§fLes dommages causés est nourrisant pour vous, ils");
		cc.add("§font un effet (Faim II) sur vos adversaires.");
		cpet.setLore(cc);
		Cannibal.setItemMeta(cpet);
	}
	static ItemStack Chameleon = new ItemStack(Material.MONSTER_EGG);
	{
		ItemMeta cpet = Chameleon.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fChameleon");
		cc.add("§fAttrapez un spawner de mob, and tenez le dans votre");
		cc.add("§fmain pour se déguiser comme ce dernier.");
		cpet.setLore(cc);
		Chameleon.setItemMeta(cpet);
	}
	@SuppressWarnings("deprecation")
	static ItemStack Chemist = new ItemStack(373, 1, (short) 16428);
	{
		ItemMeta cpet = Chemist.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fChemist");
		cc.add("§fAttrapez un spawner de mob, and tenez le dans votre");
		cc.add("§fmain pour se déguiser comme ce dernier.");
		cpet.setLore(cc);
		Chemist.setItemMeta(cpet);
	}
	static ItemStack Cookiemonster = new ItemStack(Material.COOKIE);
	{
		ItemMeta cpet = Cookiemonster.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fCookiemonster");
		cc.add("§fUtilisez vos cookies pour vous soigner, restaurer");
		cc.add("§fla faim, ou de recevoir un bonus d'effet de Vitesse.");
		cpet.setLore(cc);
		Cookiemonster.setItemMeta(cpet);
	}
	static ItemStack Cultivator = new ItemStack(Material.WHEAT);
	{
		ItemMeta cpet = Cultivator.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fCultivator");
		cc.add("§fLe blé et les plantes grandissent instantanément");
		cc.add("§florsque ils sont plantés.");
		cpet.setLore(cc);
		Cultivator.setItemMeta(cpet);
	}
	static ItemStack Demoman = new ItemStack(Material.GRAVEL);
	{
		ItemMeta cpet = Demoman.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fDemoman");
		cc.add("§fPlaque de pression au dessus d'un gravier = BOOM.");
		cpet.setLore(cc);
		Demoman.setItemMeta(cpet);
	}
	static ItemStack Digger = new ItemStack(Material.DRAGON_EGG);
	{
		ItemMeta cpet = Digger.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fDigger");
		cc.add("§fUtilisez votre pouvoir de creuser pour créer");
		cc.add("§fun énorme trou.");
		cpet.setLore(cc);
		Digger.setItemMeta(cpet);
	}
	static ItemStack Doctor = new ItemStack(Material.SHEARS);
	{
		ItemMeta cpet = Doctor.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fDoctor");
		cc.add("§fDiagnostiquez les joueurs et retirez leurs");
		cc.add("§feffets de potions.");
		cpet.setLore(cc);
		Doctor.setItemMeta(cpet);
	}
	static ItemStack Dwarf = new ItemStack(Material.DIAMOND_CHESTPLATE);
	{
		ItemMeta cpet = Dwarf.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fDwarf");
		cc.add("§fAccroupissez - vous (Shift) et bloquez pour charger");
		cc.add("§fvotre barre, relachez tout et cela propulsera tout les");
		cc.add("§fjoueurs qui seront autour de vous.");
		cpet.setLore(cc);
		Dwarf.setItemMeta(cpet);
	}
	static ItemStack Endermage = new ItemStack(Material.PORTAL);
	{
		ItemMeta cpet = Endermage.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fEndermage");
		cc.add("§fPosez votre portail pour téléporter tout les joueurs");
		cc.add("§fdans un rayon de 5 blocs la où vous avez poser votre portail.");
		cc.add("§fjoueurs qui seront autour de vous.");
		cpet.setLore(cc);
		Endermage.setItemMeta(cpet);
	}
	static ItemStack Fireman = new ItemStack(Material.WATER_BUCKET);
	{
		ItemMeta cpet = Fireman.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fFireman");
		cc.add("§fRéfugiez - vous dans la lave, le feu, aux foudres.");
		cc.add("§fVous commencez avec un seau d'eau.");
		cpet.setLore(cc);
		Fireman.setItemMeta(cpet);
	}
	static ItemStack Fisherman = new ItemStack(Material.FISHING_ROD);
	{
		ItemMeta cpet = Fisherman.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fFisherman");
		cc.add("§fCommencez avec une canne à pêche qui pourra");
		cc.add("§framener les joueurs vers vous.");
		cpet.setLore(cc);
		Fisherman.setItemMeta(cpet);
	}
	static ItemStack Flash = new ItemStack(Material.REDSTONE_TORCH_ON);
	{
		ItemMeta cpet = Flash.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fFlash");
		cc.add("§fTéléportez vous instanténement à l'endroit où");
		cc.add("§fvous regardez.");
		cpet.setLore(cc);
		Flash.setItemMeta(cpet);
	}
	static ItemStack Forger = new ItemStack(Material.COAL);
	{
		ItemMeta cpet = Forger.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fForger");
		cc.add("§fTransformez vos minerais de fer en lingots");
		cc.add("§fde fer à l'aide vos charbon dans votre inventaire.");
		cpet.setLore(cc);
		Forger.setItemMeta(cpet);
	}
	static ItemStack Frosty = new ItemStack(Material.SNOW_BLOCK);
	{
		ItemMeta cpet = Frosty.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fFrosty");
		cc.add("§fCourrez dans la neige pour obtenir de la vitesse.");
		cpet.setLore(cc);
		Frosty.setItemMeta(cpet);
	}
	static ItemStack Gambler = new ItemStack(Material.STONE_BUTTON);
	{
		ItemMeta cpet = Gambler.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fGambler");
		cc.add("§fPlacez un bouton et obtenez un cadeau. Vas-t-il vous");
		cc.add("§faider, ou vous faire du mal ?");
		cpet.setLore(cc);
		Gambler.setItemMeta(cpet);
	}
	static ItemStack GrandPa = new ItemStack(Material.STICK);
	{
		ItemMeta cpet = GrandPa.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fGrandPa");
		cc.add("§fCommencez la partie avec un bâton Recul II");
		cpet.setLore(cc);
		GrandPa.setItemMeta(cpet);
	}
	static ItemStack Hermit = new ItemStack(Material.MUSHROOM_SOUP);
	{
		ItemMeta cpet = Hermit.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fHermit");
		cc.add("§fQuand la partie commence, vous atterissez à des");
		cc.add("§fendroits que vous voulez être !");
		cpet.setLore(cc);
		Hermit.setItemMeta(cpet);
	}
	static ItemStack GraveDigger = new ItemStack(Material.CHEST);
	{
		ItemMeta cpet = GraveDigger.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fGraveDigger");
		cc.add("§fLe stuff des joueurs que vous tuez est déposer");
		cc.add("§fdans leur cercueil (coffre).");
		cpet.setLore(cc);
		GraveDigger.setItemMeta(cpet);
	}
	static ItemStack Hunter = new ItemStack(Material.RAW_BEEF);
	{
		ItemMeta cpet = Hunter.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fHunter");
		cc.add("§fTuez des cochons vous donnera toujours 2 tranches");
		cc.add("§fde porcs cuit.");
		cpet.setLore(cc);
		Hunter.setItemMeta(cpet);
	}
	static ItemStack Hulk = new ItemStack(Material.EMERALD_BLOCK);
	{
		ItemMeta cpet = Hulk.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fHulk");
		cc.add("§fPrenez vos joueurs et jetez les comme du caca.");
		cpet.setLore(cc);
		Hulk.setItemMeta(cpet);
	}
	static ItemStack Jackhammer = new ItemStack(Material.STONE_AXE);
	{
		ItemMeta cpet = Jackhammer.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fJackhammer");
		cc.add("§fCasser un bloc dégageras le passage de haut en bas.");
		cpet.setLore(cc);
		Jackhammer.setItemMeta(cpet);
	}
	static ItemStack Jumper = new ItemStack(Material.ENDER_PEARL);
	{
		ItemMeta cpet = Jumper.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fJumper");
		cc.add("§fVous commencez avec 5 boules d'Ender. Vous ne perdez");
		cc.add("§faucun dommage d'atterissage lorsque vous en lancez une.");
		cpet.setLore(cc);
		Jumper.setItemMeta(cpet);
	}
	static ItemStack Kangaroo = new ItemStack(Material.FIREWORK);
	{
		ItemMeta cpet = Kangaroo.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fKangaroo");
		cc.add("§fVous commencez avec une fusée qui vous permet de");
		cc.add("§ffaire des double sauts !");
		cpet.setLore(cc);
		Kangaroo.setItemMeta(cpet);
	}
	static ItemStack Kaya = new ItemStack(Material.GRASS);
	{
		ItemMeta cpet = Kaya.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fKaya");
		cc.add("§fLes blocs d'herbes disparraissent quand un");
		cc.add("§fjoueurs marche dessus.");
		cpet.setLore(cc);
		Kaya.setItemMeta(cpet);
	}
	static ItemStack Miner = new ItemStack(Material.STONE_AXE);
	{
		ItemMeta cpet = Miner.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fMiner");
		cc.add("§fVous commencez avec une pioche. Mangez une pomme");
		cc.add("§fjusqu'a être rassasié et minez !");
		cpet.setLore(cc);
		Miner.setItemMeta(cpet);
	}
	static ItemStack Monster = new ItemStack(Material.SKULL);
	{
		ItemMeta cpet = Monster.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fMonster");
		cc.add("§fLes monstres ne vous attaquent pas, sauf");
		cc.add("§fsi vous les attaquez en premier.");
		cpet.setLore(cc);
		Monster.setItemMeta(cpet);
	}
	ItemStack Necro = new ItemStack(Material.BONE);
	{
		ItemMeta cpet = Necro.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fNecro");
		cc.add("§fLes squelettes sont tués en un coup, et vous");
		cc.add("§fdonnent toujours deux os.");
		cpet.setLore(cc);
		Necro.setItemMeta(cpet);
	}
	ItemStack neo = new ItemStack(Material.ARROW);
	{
		ItemMeta cpet = neo.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fneo");
		cc.add("§fLes projectiles sont renvoyés à la même vitesse");
		cc.add("§fqu'ils sont venus");
		cpet.setLore(cc);
		neo.setItemMeta(cpet);
	}
	ItemStack Salvager = new ItemStack(Material.ANVIL);
	{
		ItemMeta cpet = Salvager.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fSalvager");
		cc.add("§fFaites un clique droit sur vos outils/armures et");
		cc.add("§frecevez les matériaux de constructions.");
		cpet.setLore(cc);
		Salvager.setItemMeta(cpet);
	}
	@SuppressWarnings("deprecation")
	ItemStack Scout = new ItemStack(373, 1, (short) 16386);
	{
		ItemMeta cpet = Scout.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fScout");
		cc.add("§fVous commencez avec 2 potions de splash");
		cc.add("§fde Vitesse I qui se régénèrent au fil du temps.");
		cpet.setLore(cc);
		Scout.setItemMeta(cpet);
	}
	ItemStack Launcher = new ItemStack(Material.SPONGE);
	{
		ItemMeta cpet = Launcher.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fLauncher");
		cc.add("§fVous commencez avec 20 éponges et utilisez les");
		cc.add("§fpour propulsez vos ennemis et vous même !");
		cpet.setLore(cc);
		Launcher.setItemMeta(cpet);
	}
	ItemStack Levitator = new ItemStack(Material.TORCH);
	{
		ItemMeta cpet = Levitator.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fLevitator");
		cc.add("§fLévitez les blocs et utilisez les comme des");
		cc.add("§fprojectiles sur vos adversaires.");
		cpet.setLore(cc);
		Levitator.setItemMeta(cpet);
	}
	ItemStack LumberJack = new ItemStack(Material.WOOD_AXE);
	{
		ItemMeta cpet = LumberJack.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fLumberJack");
		cc.add("§fVous commencez avec une hache en bois. Coupez la");
		cc.add("§fracine d'un arbre et tout tombe.");
		cpet.setLore(cc);
		LumberJack.setItemMeta(cpet);
	}
	ItemStack Phantom = new ItemStack(Material.FEATHER);
	{
		ItemMeta cpet = Phantom.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fPhantom");
		cc.add("§fUtilisez votre plume pour obtenir la possibilitée");
		cc.add("§fde voler pendant 5 secondes");
		cpet.setLore(cc);
		Phantom.setItemMeta(cpet);
	}
	ItemStack Pickpocket = new ItemStack(Material.BLAZE_ROD);
	{
		ItemMeta cpet = Pickpocket.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fPickpocket");
		cc.add("§fOuvrez l'inventaire d'un autre joueur pour piquer ses affaires");
		cpet.setLore(cc);
		Pickpocket.setItemMeta(cpet);
	}
	ItemStack Poseidon = new ItemStack(Material.WATER);
	{
		ItemMeta cpet = Poseidon.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fPoseidon");
		cc.add("§fVous avez Force I et Vitesse II dans l'eau, vous ne serez");
		cc.add("§fpas noyez en vous déplaçant dans l'eau.");
		cpet.setLore(cc);
		Poseidon.setItemMeta(cpet);
	}
	ItemStack Pyro = new ItemStack(Material.FIREBALL);
	{
		ItemMeta cpet = Pyro.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fPyro");
		cc.add("§fVous commencez avec 5 boule de feu et un briquet.");
		cpet.setLore(cc);
		Pyro.setItemMeta(cpet);
	}
	ItemStack Reaper = new ItemStack(Material.WOOD_HOE);
	{
		ItemMeta cpet = Reaper.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fReaper");
		cc.add("§fMaudissez vos ennemis avec votre houe de la mort !");
		cpet.setLore(cc);
		Reaper.setItemMeta(cpet);
	}
	ItemStack Rider = new ItemStack(Material.SADDLE);
	{
		ItemMeta cpet = Rider.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fRider");
		cc.add("§fMontez sur n'importe quelle animal passif avec votre selle !");
		cpet.setLore(cc);
		Rider.setItemMeta(cpet);
	}
	ItemStack Scorch = new ItemStack(Material.BLAZE_POWDER);
	{
		ItemMeta cpet = Scorch.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fScorch");
		cc.add("§fMettez vos bottes de feu, et tenez dans votre main");
		cc.add("§fpour laisser une trainée de feu partout où vous marchez.");
		cpet.setLore(cc);
		Scorch.setItemMeta(cpet);
	}
	ItemStack Seeker = new ItemStack(Material.EYE_OF_ENDER);
	{
		ItemMeta cpet = Seeker.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fSeeker");
		cc.add("§fTransformez les blocs en vers pour découvrire tout les");
		cc.add("§fminerais cachés autour de vous.");
		cpet.setLore(cc);
		Seeker.setItemMeta(cpet);
	}
	ItemStack Snail = new ItemStack(Material.SOUL_SAND);
	{
		ItemMeta cpet = Snail.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fSnail");
		cc.add("§fVous avez 1 chance sur 3 d'infligez Lenteur II");
		cc.add("§fà vos adversaires !");
		cpet.setLore(cc);
		Snail.setItemMeta(cpet);
	}
	ItemStack Specialist = new ItemStack(Material.EXP_BOTTLE);
	{
		ItemMeta cpet = Specialist.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fSpecialist");
		cc.add("§fQuand vous tuez un joueur, vous avez une potion d'XP");
		cc.add("§fdans votre inventaire, et une table d'enchament portable.");
		cc.add("§fLancez une potion d'XP vous donnera le double d'expérience !");
		cpet.setLore(cc);
		Specialist.setItemMeta(cpet);
	}
	ItemStack Spectre = new ItemStack(Material.REDSTONE);
	{
		ItemMeta cpet = Spectre.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fSpectre");
		cc.add("§fDevenez invisible et surprenez vos ennemis !");
		cpet.setLore(cc);
		Spectre.setItemMeta(cpet);
	}
	ItemStack Spiderman = new ItemStack(Material.SNOW_BALL);
	{
		ItemMeta cpet = Spiderman.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fSpiderman");
		cc.add("§fJetez des boules de neige pour créer des");
		cc.add("§ftoiles d'araignée la où ils atterissent.");
		cpet.setLore(cc);
		Spiderman.setItemMeta(cpet);
	}
	ItemStack Spy = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = Spy.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fSpy");
		cc.add("§fLa boussole vous donne les coordonées exacte");
		cc.add("§fdes joueurs. Vous êtes alerté des joueurs à proximité.");
		cpet.setLore(cc);
		Spy.setItemMeta(cpet);
	}
	ItemStack Stomper = new ItemStack(Material.ANVIL);
	{
		ItemMeta cpet = Stomper.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fStomper");
		cc.add("§fSauter de haut sur les joueurs dans les environs pour");
		cc.add("§fleurs infliger des dégâts massifs.");
		cpet.setLore(cc);
		Stomper.setItemMeta(cpet);
	}
	ItemStack Surprise = new ItemStack(Material.ENDER_CHEST);
	{
		ItemMeta cpet = Surprise.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fSurprise");
		cc.add("§fRecevez un kit aléatoire parmis tout vos kits.");
		cc.add("§f(même ce que vous ne possez pas !)");
		cpet.setLore(cc);
		Surprise.setItemMeta(cpet);
	}
	ItemStack Switcher = new ItemStack(Material.SNOW_BALL);
	{
		ItemMeta cpet = Switcher.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fSwitcher");
		cc.add("§fChangez de place avec d'autres joueurs et monstres");
		cc.add("§fen leurs lançant une boule de neige.");
		cpet.setLore(cc);
		Switcher.setItemMeta(cpet);
	}
	ItemStack Tank = new ItemStack(Material.TNT);
	{
		ItemMeta cpet = Tank.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fTank");
		cc.add("§fQuand vous tuez un joueur, créera une petite explosion.");
		cc.add("§fVous êtes à l'abri de tout dégâts d'explosion.");
		cpet.setLore(cc);
		Tank.setItemMeta(cpet);
	}
	ItemStack Tarzan = new ItemStack(Material.VINE);
	{
		ItemMeta cpet = Tarzan.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fTarzan");
		cc.add("§fLes lianes apparaissent autour de vous et vous donne");
		cc.add("§fassez d'espace pour de nouvelles tactiques.");
		cpet.setLore(cc);
		Tarzan.setItemMeta(cpet);
	}
	ItemStack Thermo = new ItemStack(Material.DAYLIGHT_DETECTOR);
	{
		ItemMeta cpet = Thermo.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fThermo");
		cc.add("§fTransformez le liquide à leur contrepartie.");
		cpet.setLore(cc);
		Thermo.setItemMeta(cpet);
	}
	ItemStack Thor = new ItemStack(Material.WOOD_AXE);
	{
		ItemMeta cpet = Thor.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fThor");
		cc.add("§fInvoquez la foudre avec votre puissante hache !");
		cpet.setLore(cc);
		Thor.setItemMeta(cpet);
	}
	ItemStack Timelord = new ItemStack(Material.WATCH);
	{
		ItemMeta cpet = Timelord.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fTimelord");
		cc.add("§fFaites un clique droit sur votre montre pour arrêter");
		cc.add("§fle temps autour de vous, ce qui piège vos ennemis");
		cpet.setLore(cc);
		Timelord.setItemMeta(cpet);
	}
	ItemStack Turtle = new ItemStack(Material.DIAMOND_CHESTPLATE);
	{
		ItemMeta cpet = Turtle.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fTurtle");
		cc.add("§fAccroupissez - vous pour prendre un minimum de dommages.");
		cc.add("§fMais vous ne pouvez pas attaquer en restant accroupi !");
		cpet.setLore(cc);
		Turtle.setItemMeta(cpet);
	}
	@SuppressWarnings("deprecation")
	ItemStack Vampire = new ItemStack(373, 1, (short) 16389);
	{
		ItemMeta cpet = Vampire.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fVampire");
		cc.add("§fTuez et obtenez de la santé, vous êtes soigné des");
		cc.add("§fdégâts instantés !");
		cpet.setLore(cc);
		Vampire.setItemMeta(cpet);
	}
	@SuppressWarnings("deprecation")
	ItemStack Urgal = new ItemStack(373, 1, (short) 16393);
	{
		ItemMeta cpet = Urgal.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fUrgal");
		cc.add("§fVous commencez avec 3 potions de splash de Force I.");
		cpet.setLore(cc);
		Urgal.setItemMeta(cpet);
	}
	ItemStack Viking = new ItemStack(Material.IRON_AXE);
	{
		ItemMeta cpet = Viking.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fViking");
		cc.add("§fInfligez des dégâts supplémentaires avec vos haches.");
		cpet.setLore(cc);
		Viking.setItemMeta(cpet);
	}
	ItemStack Viper = new ItemStack(Material.SPIDER_EYE);
	{
		ItemMeta cpet = Viper.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fViper");
		cc.add("§fVous avez 1 chance sur 3 d'infligez Poison I");
		cc.add("§fà vos adversaires !");
		cpet.setLore(cc);
		Viper.setItemMeta(cpet);
	}
	ItemStack Vulture = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = Vulture.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fVulture");
		cc.add("§fVous êtes informé des lieux de morts des joueurs et");
		cc.add("§fencore plus d'info, et pariez sur qui vas mourrir pour");
		cc.add("§fdu stuff !");
		cpet.setLore(cc);
		Vulture.setItemMeta(cpet);
	}
	ItemStack Werewolf = new ItemStack(Material.WATCH);
	{
		ItemMeta cpet = Werewolf.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fWerewolf");
		cc.add("§fVous avez Resistance I et Vitesse I la nuit, mais");
		cc.add("§fvous êtes faible au jour !");
		cpet.setLore(cc);
		Werewolf.setItemMeta(cpet);
	}
	ItemStack Wisp = new ItemStack(Material.MAGMA_CREAM);
	{
		ItemMeta cpet = Wisp.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fWisp");
		cc.add("§fDésorientez vos ennemis grâce à vos clones !");
		cpet.setLore(cc);
		Wisp.setItemMeta(cpet);
	}
	ItemStack Worm = new ItemStack(Material.DIRT);
	{
		ItemMeta cpet = Worm.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§fWorm");
		cc.add("§fCasser les blocs de terre instantanémenet, les dégâts");
		cc.add("§fde chutes sont réduites lorsque vous atterissez sur de la terre.");
		cpet.setLore(cc);
		Worm.setItemMeta(cpet);
	}
	ItemStack anchordesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = anchordesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit Anchor est très simple, quand vous avez le kit,");
		cc.add("§fvous ne recevrez pas de recul et quand vous attaquez un");
		cc.add("§fmob ou un joueur, ils n'auront également pas de recul.");
		cc.add("§fToutefois, ce kit a aussi un inconvénient, vous ne pouvez");
		cc.add("§fpas porter de bottes quand vous êtes Anchor, et quand vous");
		cc.add("§fmarchez cela fera un son d'une enclume, aussi vous ne serez");
		cc.add("§fas proteger des projectiles. (Remarque : Le son de l'enclume");
		cc.add("§fest pour des raisons de sécurité contre les personnes qui");
		cc.add("§futilisent un hack §cAnti-Knockback§f.");
		cpet.setLore(cc);
		anchordesc.setItemMeta(cpet);
	}
	ItemStack anchorstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = anchorstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fQuand vous tapez un joueur, il ne recevra");
		cc.add("§f pas de recul, de cette façon, il ne pourra");
		cc.add("§f s'échapper tant que vous le tapez.");
		cc.add(" ");
		cc.add("§fTuez les joueurs qui sont dans leurs tours,");
		cc.add("§fvous ne recevrez aucun recul !");
		cc.add("§fAssurez - vous que vous pouvez vous battre");
		cc.add("§fcontre les joueurssans leur faire de recul,");
		cc.add("§fou utilisez un projectile, ce qui donnera");
		cc.add("§fun recul à l'adversaire.");
		cpet.setLore(cc);
		anchorstrat.setItemMeta(cpet);
	}
	ItemStack anchorabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = anchorabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fVous ne prenez aucun recul, et vous n'en donnez aucun.");
		cc.add("§fLes projectiles seront toujours capable de vous");
		cc.add("§fbasculer !");
		cpet.setLore(cc);
		anchorabilities.setItemMeta(cpet);
	}
	// ARCHER
	ItemStack archerdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = archerdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit archer vous permet de tuer les joueurs à");
		cc.add("§flongue distance, sans être trop prêt d'un stomper");
		cc.add("§fpour éviter qu'il vous piétine ! Ce kit est super");
		cc.add("§fdans l'ensemble car il est utile pour le début,");
		cc.add("§fmilieu et fin de jeu pour exterminer les joueurs");
		cc.add("§fqui sont dans une tour. Si vous touchez un joueur");
		cc.add("§favec votre flèche en visant à l'arc, la flèche");
		cc.add("§frevient dans votre inventaire !");
		cpet.setLore(cc);
		archerdesc.setItemMeta(cpet);
	}
	ItemStack archerstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = archerstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fVous pouvez vous faire une tour, et ensuite");
		cc.add("§futiliser votre arc et vos flèches pour tuer");
		cc.add("§fles joueurs autours de vous !");
		cc.add("§cFaite une tour sécurisée avec des blocs qui");
		cc.add("§cvous protégerons de sauter hors de votre tour.");
		cc.add(" ");
		cc.add("§fTouchez un Stomper ou un Endermage au bon moment");
		cc.add("§ffaite les tomber et peut être ensuite il pourra");
		cc.add("§fmourire !");
		cc.add("§cMettez des blocs devant vous pour faire en sorte");
		cc.add("§cqu'il ne vous tire pas dessus.");
		cc.add(" ");
		cc.add("§fFaite équipe avec un Fletcher pour obtenir facilement");
		cc.add("§fdu silex et des plumes pour vous faire plus de flèches !");
		cc.add(" ");
		cc.add("§fJouer dans une grande équipe, vous permettera d'avoir une");
		cc.add("§fvariété de formats d'attaque pour exterminer l'ennemi !");
		cpet.setLore(cc);
		archerstrat.setItemMeta(cpet);
	}
	ItemStack archerabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = archerabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fLes poulets drop toujours 2 plumes.");
		cc.add("§fLe gravier vous donne toujour 1 silex.");
		cc.add("§fLes flèches reviennent dans votre inventaire");
		cc.add("§florsque vous touchez un joueur.");
		cpet.setLore(cc);
		archerabilities.setItemMeta(cpet);
	}
	ItemStack archericon = new ItemStack(Material.BOW);
	{
		ItemMeta cpet = archericon.getItemMeta();
		cpet.setDisplayName("§fUn arc");
		archericon.setItemMeta(cpet);
	}
	ItemStack archericon2 = new ItemStack(Material.ARROW, 10);
	{
		ItemMeta cpet = archericon2.getItemMeta();
		cpet.setDisplayName("§f10 flèches");
		archericon2.setItemMeta(cpet);
	}
	// //////
	// beastmaster
	ItemStack beastmasterdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = beastmasterdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit Beastmaster vous permet d'apprivoiser vos");
		cc.add("§floups avec les 4 os en début de partie ce qui leurs");
		cc.add("§fdonneront Vitesse I ou Régénération I. Les loups");
		cc.add("§fpeuvent être très utiles en combat de 1 contre 1,");
		cc.add("§fet souvent cela peut vous donner la victoire sur");
		cc.add("§fvotre ennemi dans des combats ! Vous avez également");
		cc.add("§f100% de chance d'apprivoiser vos loups.");
		cpet.setLore(cc);
		beastmasterdesc.setItemMeta(cpet);
	}
	ItemStack beastmasterstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = beastmasterstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fVos chiens vous aideront à protégerer le Feast,");
		cc.add("§fce qui vous permettra de prendre tout le");
		cc.add("§fcontenu des coffres du Feast pendant que vos");
		cc.add("§fchiens essaient de tuer les ennemis autour de vous.");
		cc.add(" ");
		cc.add("§fNe pas apprivoiser vos loups pendant les 2 minutes");
		cc.add("§fd'invincibilitées ! Il serais possible que d'autre");
		cc.add("§fjoueurs les tues.");
		cc.add(" ");
		cc.add("§fQuand vous tapez quelqu'un, vos loups attaqueront");
		cc.add("§fce dernier. Ce qui vous permet de vous refill ou de");
		cc.add("§fvous enfuir.");
		cc.add("§cAttaquez le joueur à la place de vos chiens. Une fois");
		cc.add("§cque le joueur est mort, vos chiens s'arrêtent.");
		cpet.setLore(cc);
		beastmasterstrat.setItemMeta(cpet);
	}
	ItemStack beastmasterabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = beastmasterabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§f100% de chance d'apprivoisenement.");
		cpet.setLore(cc);
		beastmasterabilities.setItemMeta(cpet);
	}
	ItemStack beastmastericon = new ItemStack(Material.MONSTER_EGG, 3);
	{
		ItemMeta cpet = beastmastericon.getItemMeta();
		cpet.setDisplayName("§f3 oeufs de loup");
		beastmastericon.setItemMeta(cpet);
	}
	ItemStack beastmastericon2 = new ItemStack(Material.BONE, 4);
	{
		ItemMeta cpet = beastmastericon2.getItemMeta();
		cpet.setDisplayName("§f4 os");
		beastmastericon2.setItemMeta(cpet);
	}
	ItemStack signkit = new ItemStack(Material.SIGN);
	{
		ItemMeta cpet = signkit.getItemMeta();
		cpet.setDisplayName("§fVous commencez avec");
		signkit.setItemMeta(cpet);
	}
	ItemStack playkit = new ItemStack(Material.FIRE);
	{
		ItemMeta cpet = playkit.getItemMeta();
		cpet.setDisplayName("§fJouer avec ce kit !");
		playkit.setItemMeta(cpet);
	}
	// berserker
	ItemStack berserkerdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = berserkerdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit berserker n'est pas pour les faibles !");
		cc.add("§fVous avez Force I et Vitesse I pendant 0.25 secondes");
		cc.add("§fà chaque coup porter sur un joueur. Cela vous permet");
		cc.add("§fd'avoir un avantage sur un ennemi ou une équipe en");
		cc.add("§ffrappant sur plusieurs cibles (joueurs), continuez");
		cc.add("§fà vous battre tant que vous avez vos effets de");
		cc.add("§fpotions (Vitesse I & Force I) !");
		cpet.setLore(cc);
		berserkerdesc.setItemMeta(cpet);
	}
	ItemStack berserkerstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = berserkerstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fLorsque vous êtes en combat, et que vous courrez");
		cc.add("§fpour trouver un mob pour le frapper, vous pourrez");
		cc.add("§favoir l'avantage en tuant les mobs pour ensuite");
		cc.add("§fvous retourner vers votre ennemis avec votre");
		cc.add("§fSoif de sang !");
		cc.add("§cSi vous voyez un Berserker qui attaque un mob, COURREZ !");
		cc.add(" ");
		cc.add("§fLorsque vous combattez une équipe, concentrez - vous");
		cc.add("§fà tapper sur plusieurs adversaires. Puis vous aurez");
		cc.add("§fvos potions de Force et Vitesse actifs, et vous serez");
		cc.add("§fen mesure de les battres facilement.");
		cc.add(" ");
		cc.add("§fExcellent au feast, le bonus de Force I peut vraiment");
		cc.add("§fs'avérer bénéfique en cas de situations-clés ou combats.");
		cpet.setLore(cc);
		berserkerstrat.setItemMeta(cpet);
	}
	ItemStack berserkerabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = berserkerabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fLorsque vous frappez un joueur ou un mob, vous avez");
		cc.add("§f0.25 secondes de Force I et Vitesse I");
		cpet.setLore(cc);
		berserkerabilities.setItemMeta(cpet);
	}
	// boxer
	ItemStack boxerdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = boxerdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit Boxer est excellent car il est polyvalent.");
		cc.add("§fC'est excellent en début de partie, vous donnant");
		cc.add("§fun gros avantage sur vos adversaires, et brillant");
		cc.add("§fen fin de partie car les coups arrivant sont");
		cc.add("§fréduits et peut souvent vous sauver la vie !");
		cpet.setLore(cc);
		boxerdesc.setItemMeta(cpet);
	}
	ItemStack boxerstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = boxerstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fFaite un massacre en début de partie, en tuant");
		cc.add("§fdes joueurs avec vos poings. Les joueurs seront");
		cc.add("§fsurpris et souvent impressioné de votre force !");
		cc.add(" ");
		cc.add("§fVous êtes avantagé en combat contre votre ennemmi,");
		cc.add("§cpuisque les dégâts reçus vos sont réduit d'un demi coeur.");
		cc.add("§cEssayez de mettre des combos ou des coups critiques pour");
		cc.add("§fcompenser la réduction des dommages du Boxer.");
		cc.add(" ");
		cc.add("§fLa réduction des dégâts au faest peut vraiment faire");
		cc.add("§fla différence entre tuer le dernier joueur pour ensuite");
		cc.add("§fvider tout les coffres, ou mourrir !");
		cc.add(" ");
		cc.add("§fAssurez-vous que vous ne tenez pas d'item quand vous");
		cc.add("§fattaquez, si vous en tenez un, les coups ne seront pas");
		cc.add("§fégale à une épée en pierre !");
		cpet.setLore(cc);
		boxerstrat.setItemMeta(cpet);
	}
	ItemStack boxerabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = boxerabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fVos poings font autant de dégâts qu'une épée en pierre.");
		cc.add("§fLes dommages entrant sont réduit d'un demi coeur.");
		cpet.setLore(cc);
		boxerabilities.setItemMeta(cpet);
	}
	// camel
	ItemStack cameldesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = cameldesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit camel vous donne des avantages dans les");
		cc.add("§fdéserts, ce qui fait le meilleur biome pour un");
		cc.add("§fchameau (Camel), vous êtes en mesure de faire");
		cc.add("§fdu jus de cactus avec seulement 1 Cactus.");
		cc.add("§fVous bénéficiez d'un effet de potion de");
		cc.add("§fVitesse I quand vous marchez dans les déserts.");
		cpet.setLore(cc);
		cameldesc.setItemMeta(cpet);
	}
	ItemStack camelstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = camelstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fAllez aux déserts aulieu des biomes marécages,");
		cc.add("§fpour éviter de vous faire tuer par des joueurs.");
		cc.add(" ");
		cc.add("§fPoursuivez n'importe quelle joueur dans un désert,");
		cc.add("§fou posez des cactus pour le faire ralentir en,");
		cc.add("§céspérant qu'il touche le cactus.");
		cpet.setLore(cc);
		camelstrat.setItemMeta(cpet);
	}
	ItemStack camelabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = camelabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fVous pouvez utiliser une recette spéciale :");
		cc.add("§f1 Cactus + 1 bloc de sable = 1 jus de cactus.");
		cc.add("§fVous avez Vitesse I dans les déserts.");
		cpet.setLore(cc);
		camelabilities.setItemMeta(cpet);
	}
	// cannibal
	ItemStack cannibaldesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = cannibaldesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit cannibal est vital pour les combattants");
		cc.add("§faffammés ! Avec Cannibal, à chaque fois que vous");
		cc.add("§finfligez des dommages à un joueur, votre bar de");
		cc.add("§ffaim boost. Quand vous infligez des dégâts sur");
		cc.add("§fdes joueurs, ils reçoivent Hunger II (Faim II).");
		cc.add("§fVous commencez avec un poisson cru et un oeuf");
		cc.add("§fd'ocelot, utilisez le poisson cru comme aliment");
		cc.add("§fou pour apprivoiser votre ocelot pour fuire les");
		cc.add("§fcreepers.");
		cpet.setLore(cc);
		cannibaldesc.setItemMeta(cpet);
	}
	ItemStack cannibalstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = cannibalstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fVous n'aurez jamais faim, aussi longtemps que");
		cc.add("§fvous trouver des joueurs. Il suffit simplement");
		cc.add("§fde les frapper plusieurs pour que votre bar de");
		cc.add("§ffaim augmente instantanément.");
		cc.add(" ");
		cc.add("§fLes ocelots apprivoisés effraient les creepers.");
		cc.add("§cParfois il vous faut plus d'un poisson cru pour");
		cc.add("§capprivoiser votre ocelot.");
		cc.add(" ");
		cc.add("§fLes poissons crus peuvent être cuits, donnant");
		cc.add("§fune autre façon d'obetenir de la nourriture");
		cc.add("§florsque vous ne pouvez pas trouver de joueurs.");
		cc.add(" ");
		cc.add("§fChassez les joueurs n'est jamais un problème,");
		cc.add("§fils vont perdre de la faim rapidement vous serez");
		cc.add("§fet vous gagnerez tout le temps de la faim.");
		cc.add("§cEssayez pas de fuir, essayez de les attaquer !");
		cc.add(" ");
		cc.add("§fRendez les joueurs mourire de faim est toujours");
		cc.add("§fune bonne façon de regarder les gens mourire.");
		cpet.setLore(cc);
		cannibalstrat.setItemMeta(cpet);
	}
	ItemStack cannibalabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = cannibalabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fFrapper un ennemi et votre barre de faim augmente.");
		cc.add("§fApprivoisez votre/vos ocelot(s) pour effrayer les");
		cc.add("§fcreepers.");
		cpet.setLore(cc);
		cannibalabilities.setItemMeta(cpet);
	}
	// chameleon
	ItemStack chameleondesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = chameleondesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit chameleon est très sournois ! Si vous");
		cc.add("§faimez vous cacher autour de la nature, alors");
		cc.add("§fce kit est fait pour vous ! Vouc commencez avec");
		cc.add("§fun blé que vous pouvez utiliser sur n'importe");
		cc.add("§fquel mob pour être comme ce dernier, et cela");
		cc.add("§fdrop un oeuf de mob. Vous ne verrez pas le");
		cc.add("§fchangement de vous même, mais dès que vous");
		cc.add("§fprenez cet oeuf dans votre main, vous serez");
		cc.add("§falerté dans le chat par exemple :");
		cc.add("§aVous êtes déguisé en mouton.");
		cc.add("§fQuand vous êtes attaqué, vous perdez votre");
		cc.add("§fdéguisement pendant quelques secondes, mais");
		cc.add("§faprès cela, vous redevenez le mob que vous etait.");
		cc.add("§fAussi, quand vous êtes déguisé, les joueurs ne");
		cc.add("§fpeuvent pas vous pister (avec la bousse) !");
		cpet.setLore(cc);
		chameleondesc.setItemMeta(cpet);
	}
	ItemStack chameleonstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = chameleonstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fDéguisez-vous en mouton, les joueurs ne vous");
		cc.add("§ftueront pas des moutons car ils sont un peu");
		cc.add("§finutiles dans la partie.");
		cc.add("§cSi vous voyez un mouton suspect, alors la chance");
		cc.add("§cvous diras que c'est un chameleon ! Frappez le pour");
		cc.add("§cêtes sûr !");
		cc.add(" ");
		cc.add("§fDéguisez - vous en calamar, sautez dans une piscine");
		cc.add("§fd'eau avec d'autres calamars et beaucoup de joueurs");
		cc.add("§fvont vous entourer, mais ne sauront pas que vous êtes");
		cc.add("§fun calamar.");
		cc.add(" ");
		cc.add("§fLorsque vous êtes déguisé, vous n'aurez pas de pseudo.");
		cc.add("§fCeci est très utile lorsque vous voulez attaquer les");
		cc.add("§fjoueurs par derrière, même si vous courrez vous n'aurez");
		cc.add("§fpas de pseudo au dessus de votre tête.");
		cc.add(" ");
		cc.add("§fC'est énorme pour surprendre vos adversaires, ils ne");
		cc.add("§fseront pas soupçonner qu'un mouton les attaque !");
		cc.add(" ");
		cc.add("§fDéguisez vous en Endermano ou en un poulet au feast, et");
		cc.add("§fvidez tout les coffres !");
		cpet.setLore(cc);
		chameleonstrat.setItemMeta(cpet);
	}
	ItemStack chameleonabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = chameleonabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fUtilisez votre blé sur les mobs pour obtenir leur oeuf.");
		cc.add("§fTenez l'oeuf pour vous déguiser en ce dernier, si vous");
		cc.add("§fêtes toucher par un joueur, vous perdez votre déguisement");
		cc.add("§fpendant quelques secondes.");
		cpet.setLore(cc);
		chameleonabilities.setItemMeta(cpet);
	}
	ItemStack chameleonicon2 = new ItemStack(Material.WHEAT);
	{
		ItemMeta cpet = chameleonicon2.getItemMeta();
		cpet.setDisplayName("§cBlé");
		chameleonicon2.setItemMeta(cpet);
	}
	// chemist
	ItemStack chemistdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = chemistdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit chemist est un bon kit d'attaque.");
		cc.add("§fVous commencez avec trois potions de splash,");
		cc.add("§fPoison II (0:16), Dégâts Instantanés II et");
		cc.add("§fFaibless (3:00). Utilisez ces potions sur");
		cc.add("§fvos ennemis pour gagner un minimum d'avantage");
		cc.add("§ftôt ou tard dans la partie !");
		cpet.setLore(cc);
		chemistdesc.setItemMeta(cpet);
	}
	ItemStack chemiststrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = chemiststrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fEn utilisant vos potions est la clé de ce kit.");
		cc.add("§fLes dommages sont utile au Feast, la faiblesse");
		cc.add("§fest aussi excellent contre les Urgal ou autres kits");
		cc.add("§cbasés sur la force, et le poison est bon pour une");
		cc.add("§cbonne attaque !");
		cc.add(" ");
		cc.add("§fGarder vos potions jusqu'au Feast est bonne idée");
		cc.add("§favec ce kit, ces 3 potions sont excellents et vous");
		cc.add("§fdonne un excellent avantage sur vos victimes.");
		cc.add(" ");
		cc.add("§fFaire équipe avec un Urgal = Potions dominantes !");
		cpet.setLore(cc);
		chemiststrat.setItemMeta(cpet);
	}
	ItemStack chemistabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = chemistabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fAucunes.");
		cpet.setLore(cc);
		chemistabilities.setItemMeta(cpet);
	}
	@SuppressWarnings("deprecation")
	ItemStack chemisticon = new ItemStack(373, 1, (short) 16420);
	{
		ItemMeta cpet = chemisticon.getItemMeta();
		cpet.setDisplayName("§fPoison II");
		chemisticon.setItemMeta(cpet);
	}
	@SuppressWarnings("deprecation")
	ItemStack chemisticon2 = new ItemStack(373, 1, (short) 16428);
	{
		ItemMeta cpet = chemisticon2.getItemMeta();
		cpet.setDisplayName("§fDégâts Instantanés II");
		chemisticon2.setItemMeta(cpet);
	}
	@SuppressWarnings("deprecation")
	ItemStack chemisticon3 = new ItemStack(373, 1, (short) 16458);
	{
		ItemMeta cpet = chemisticon3.getItemMeta();
		cpet.setDisplayName("§fFaiblesse I");
		chemisticon3.setItemMeta(cpet);
	}
	// cookiemonster
	ItemStack cookiemonsterdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = cookiemonsterdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit cookiemonster vous donne 25% de chance");
		cc.add("§fd'obtenir des biscuits en cassant de l'herbe.");
		cc.add("§fLorsque votre santé est faible, vos cookie");
		cc.add("§faugemente instantément votre santé. Si votre");
		cc.add("§fsanté est pleine, et votre faim est faible,");
		cc.add("§fvotre faim augmente instantanément. Si votre");
		cc.add("§fsanté et votre faim sont pleins, alors vous");
		cc.add("§faurez un bonus de Vitesse II. Les cookies");
		cc.add("§frégènérent respective sur un coeur/faim.");
		cpet.setLore(cc);
		cookiemonsterdesc.setItemMeta(cpet);
	}
	ItemStack cookiemonsterstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = cookiemonsterstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fObtenez des cookie pour rétablire une bar de faim");
		cc.add("§fpar cookie. Si vous mourrez de faim, mangez vos");
		cc.add("§fcookies pour vous régénerer votre faim. Si votre");
		cc.add("§csanté et votre faim sont remplis, vous obtenez un");
		cc.add("§cbonous de Vitesse II pendant 5 secondes. Utilisez");
		cc.add("§fcet avantage pour vous échappez !");
		cc.add("§cContinuez à frapper votre ennemi, ils trouveront qu'il");
		cc.add(" ");
		cc.add("§fSi vous manquez de soupes, vous pouvez utiliser vos");
		cc.add("§fcookies comme une source alternative de santé instantanée.");
		cc.add("§fLes cookies s'entre stack aussi ! (Seulement si il guérit");
		cc.add("§fvotre faim).");
		cc.add(" ");
		cc.add("§fDistribuer certains de vos cookies pour vos coéquipiers,");
		cc.add("§fils ne recevront pas le même effet que vous mais cela vas");
		cc.add("§fa restaurer leurs faims !");
		cc.add(" ");
		cc.add("§fAu feast, vous pouvez utiliser des cookies pour vous guérir.");
		cc.add("§fCe coeur ou deux peut souvent faire la différence entra la vie");
		cc.add("§fet la mort.");
		cc.add(" ");
		cpet.setLore(cc);
		cookiemonsterstrat.setItemMeta(cpet);
	}
	ItemStack cookiemonsterabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = cookiemonsterabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fFaites un clique droit sur un cookie pour vous");
		cc.add("§fremplir instantanément votre bar de faim. Si");
		cc.add("§fvotre barre de faim est pleine, votre santé va");
		cc.add("§faugmenter d'un coeur. Si les deux sont pleins,");
		cc.add("§fvous recevrez un boost de Vitesse II pour 5 secondes.");
		cpet.setLore(cc);
		cookiemonsterabilities.setItemMeta(cpet);
	}
	// cultivator
	ItemStack cultivatordesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = cultivatordesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit cultivator vous permet de développer");
		cc.add("§finstanténement du blé, des arbres en plaçant");
		cc.add("§fdes graines sur la terre sarclée, et de placer");
		cc.add("§fdes pousses sur de la terre normale. Ce kit est");
		cc.add("§fexcellent en équipe ou seul pour chaque partie.");
		cpet.setLore(cc);
		cultivatordesc.setItemMeta(cpet);
	}
	ItemStack cultivatorstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = cultivatorstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fObtenez 2-3 graines, faites une houe, sarclez la");
		cc.add("§fterre et planter une graine. Continuez de planter");
		cc.add("§fdes graines pour avoir encore plus de blé, et");
		cc.add("§fensuite vous pourrez faire du pain.");
		cc.add(" ");
		cc.add("§fObtenez une pousse, plantez la, puis vous aurez une");
		cc.add("§fgrande quantité de bois.");
		cc.add(" ");
		cc.add("§fC'est une nécessité pour une équipe en Hunger Games");
		cc.add(" ");
		cc.add("§fPlantez une pousse en combat, et votre ennemi seras");
		cc.add("§fétouffé dans l'arbre.");
		cpet.setLore(cc);
		cultivatorstrat.setItemMeta(cpet);
	}
	ItemStack cultivatorabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = cultivatorabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fLes graines se développent en blé instanténement");
		cc.add("§florsqu'ils sont plantées.");
		cc.add("§fLes plantes poussent dans les arbres instantanément");
		cc.add("§florsque'ils sont plantées.");
		cpet.setLore(cc);
		cultivatorabilities.setItemMeta(cpet);
	}
	// demoman
	ItemStack demomandesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = demomandesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit demoman est génial pour se défendre.");
		cc.add("§fVos victimes et ennemis ne soupçonneront pas");
		cc.add("§fqu'une plaque de pression les tueront ! ");
		cc.add("§fL'explosion est un peu plus grande qu'une TNT.");
		cpet.setLore(cc);
		demomandesc.setItemMeta(cpet);
	}
	ItemStack demomanstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = demomanstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fPlacez un de vos pièges dans une grotte ou mine.");
		cc.add("§fPuis, quand un ennemi marchera sur cette dernière,");
		cc.add("§fcela déclanchera une explosion ! Ils mourront !");
		cc.add("§cSi vous voyez une plaque de pression, cassez la");
		cc.add("§cavec votre pioche en pierre.");
		cc.add(" ");
		cc.add("§fUtilisez vos pièges de Demoman pour miner, ou obtenez");
		cc.add("§cde la pierre (cobblestone) sans avoir à faire une pioche.");
		cpet.setLore(cc);
		demomanstrat.setItemMeta(cpet);
	}
	ItemStack demomanabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = demomanabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fQuand un ennemi marche sur le piège d'un Demoman,");
		cc.add("§fils déclanchera une explosion qui tuera ce dernier.");
		cpet.setLore(cc);
		demomanabilities.setItemMeta(cpet);
	}
	ItemStack demoman = new ItemStack(Material.GRAVEL, 6);
	{
		ItemMeta cpet = demoman.getItemMeta();
		cpet.setDisplayName("§f6 Bloc de graviers");
		demoman.setItemMeta(cpet);
	}
	ItemStack demoman2 = new ItemStack(Material.STONE_PLATE, 6);
	{
		ItemMeta cpet = demoman2.getItemMeta();
		cpet.setDisplayName("§f6 plaques de pressions");
		demoman2.setItemMeta(cpet);
	}
	// digger
	ItemStack diggerdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = diggerdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit Digger vous donne 6 oeufs de dragon,");
		cc.add("§fune fois que vous avez placer l'oeuf de");
		cc.add("§fdragon, vous un peu plus d'une seconde");
		cc.add("§f(Croyez moi, c'est assez !) pour dégager de");
		cc.add("§fla avant qu'un trou de 5x5 apparaît directement");
		cc.add("§fla où vous avez placé l'oeuf de dragon. Ce kit");
		cc.add("§fest parfait pour piéger vos ennemis.");
		cpet.setLore(cc);
		diggerdesc.setItemMeta(cpet);
	}
	ItemStack diggerstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = diggerstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fTout en étant suivi, placez un oeuf de dragon devant");
		cc.add("§fvous pour créer un trou de votre disciple qui vas");
		cc.add("§fsurement y tomber dedans, ce qui vous permet de");
		cc.add("§fvous refill et de revenir dans le combat.");
		cc.add("§cRegardez tout le temps les joueurs qui ont un oeuf");
		cc.add("§cde dragon dans leurs mains, vous pourrez tomber dans");
		cc.add("§cleurs trous et perdre leur trace si vous êtes coincé !");
		cc.add(" ");
		cc.add("§fAprès avoir piéger quelqu'un, vous pouvez placez de la");
		cc.add("§flave sur lui ou bien l'abattre avec un arc et des flèches.");
		cc.add("§cToujours s'assurer de disposer des blocs au cas où vous");
		cc.add("§cdéfendre contre de la lave ou des flèches !");
		cc.add(" ");
		cc.add("§fSi vous ne trouvez personne qui est proche, placez un oeuf de");
		cc.add("§fdragon pour essayer de les trouver sous terres.");
		cc.add("§cSi vous êtes proche du sol, soyez sure d'être accroupi pour vous");
		cc.add("§ccacher des Digger !");
		cpet.setLore(cc);
		diggerstrat.setItemMeta(cpet);
	}
	ItemStack diggerabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = diggerabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fPlacez un oeuf de dragon, après 1.5 seconde un trou");
		cc.add("§fde 5x5 apparaîtra la où vous avez placer l'oeuf.");
		cpet.setLore(cc);
		diggerabilities.setItemMeta(cpet);
	}
	ItemStack digger = new ItemStack(Material.DRAGON_EGG, 6);
	{
		ItemMeta cpet = digger.getItemMeta();
		cpet.setDisplayName("§f6 Oeufs de dragon");
		digger.setItemMeta(cpet);
	}
	// doctor
	ItemStack doctordesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = doctordesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit Doctor vous donnera une paire de");
		cc.add("§fpinces (cisailles) que vous pourrez cliquer");
		cc.add("§favec sur un joueur pour lui retirer ses");
		cc.add("§feffets de potions actifs");
		cpet.setLore(cc);
		doctordesc.setItemMeta(cpet);
	}
	ItemStack doctorstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = doctorstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fFaites un clique droit sur un Berserker pour lui");
		cc.add("§fenlever ses effets de potions, puis laissez vos");
		cc.add("§fcoéquipiers le tuer !");
		cc.add("§cFaites toujours attention aux personnes avec des");
		cc.add("§ccisailles qui pourraient emporter vos effets de");
		cc.add("§cpotions actifs.");
		cpet.setLore(cc);
		doctorstrat.setItemMeta(cpet);
	}
	ItemStack doctorabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = doctorabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fUn clique droit sur une personne avec vos cisailles");
		cc.add("§fvas retirer ses effets de potions actifs.");
		cpet.setLore(cc);
		doctorabilities.setItemMeta(cpet);
	}
	ItemStack doctor = new ItemStack(Material.SHEARS);
	{
		ItemMeta cpet = doctor.getItemMeta();
		cpet.setDisplayName("§fUne paire de cisailles");
		doctor.setItemMeta(cpet);
	}
	// dwarf
	ItemStack dwarfdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = dwarfdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit dwarf vous permet de vous accroupir et de");
		cc.add("§fbloquer au même moment puis cela vous permettra de");
		cc.add("§fcharger votre de bar de propulsation, une fois que");
		cc.add("§frelachez tout, les joueurs qui sont autour de vous");
		cc.add("§fseront propulser en fonction du temps de chargement.");
		cpet.setLore(cc);
		dwarfdesc.setItemMeta(cpet);
	}
	ItemStack dwarfstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = dwarfstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fAttirez les joueurs sur des montagnes/tours, puis");
		cc.add("§fchargez votre bar de propulsation et faites tomber");
		cc.add("§fles joueurs avec votre propulasation et regardez");
		cc.add("§fles tomber !");
		cc.add("§cToujours s'assurez de ne pas vous mettre sur le côté");
		cc.add("§cd'une tour contre un Dwarf, ils pourras vous propulser.");
		cpet.setLore(cc);
		dwarfstrat.setItemMeta(cpet);
	}
	ItemStack dwarfabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = dwarfabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fAcrroupissez - vous et bloquez pendant un moment,");
		cc.add("§fpuis relachez et tout les joueurs autours de vous");
		cc.add("§fseront propulser ! (30 secondes de cooldown)");
		cpet.setLore(cc);
		dwarfabilities.setItemMeta(cpet);
	}
	// endermage
	ItemStack endermagedesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = endermagedesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit endermage est très pratique, idéal pour");
		cc.add("§fdécamper des campeur qui sont au niveau de la");
		cc.add("§fbedrock ! Quand vous posez votre portail, vous");
		cc.add("§fêtes téléporté à l'endroit où vous l'avez placé,");
		cc.add("§fainsi que tout les joueurs autours de 5 blocs et");
		cc.add("§fvous avez 5 secondes d'invincibilité.");
		cpet.setLore(cc);
		endermagedesc.setItemMeta(cpet);
	}
	ItemStack endermagestrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = endermagestrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fSi un coéquipier tombe dans un ravin, vous pouvez");
		cc.add("§futilisez votre portail pour le téléporter vers");
		cc.add("§fvous pour le faire remonter à la surface.");
		cc.add(" ");
		cc.add("§fSinon, combattez et téléportez les joueurs qui minent.");
		cc.add("§fDe cette façon, il n'est pas nécessaire d'obtenir des");
		cc.add("§fmatériaux (minerais de fer, charbons...) !");
		cc.add(" ");
		cc.add("§fLorsque vous voyez une équie, ce kit est");
		cc.add("§fgéniale puisque vous serez en mensure de téléporter");
		cc.add("§fl'équipe et les sortir plus facilement. ");
		cc.add(" ");
		cc.add("§fQuelqu'un campe au niveau de la bedrock ? Pas de");
		cc.add("§fproblèmes. Téléportez le à vous et préparez vous");
		cc.add("§fà un combat loyal !");
		cpet.setLore(cc);
		endermagestrat.setItemMeta(cpet);
	}
	ItemStack endermageabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = endermageabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fTéléportez les joueurs de 1-2 blocs de votre portail à");
		cc.add("§fl'endroit où vous l'avez placer, ce qui vous inclut !");
		cpet.setLore(cc);
		endermageabilities.setItemMeta(cpet);
	}
	ItemStack endermage = new ItemStack(Material.PORTAL);
	{
		ItemMeta cpet = endermage.getItemMeta();
		cpet.setDisplayName("§fUn portail");
		endermage.setItemMeta(cpet);
	}
	// fireman
	ItemStack firemandesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = firemandesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit Fireman est un kit très équilibré et utile.");
		cc.add("§fLe seau d'eau peut être utilisé pour monter sur");
		cc.add("§fles grandes collines, faire un MLG Water, ou échanger");
		cc.add("§fou le changer en lave mortele ! L'immunitdé de Thor");
		cc.add("§fest aussi extrêmement utile, car le kit Thor peut être");
		cc.add("§ffastidieux à tuer ! Le kit fireman accorde quelques");
		cc.add("§fsecondes d'immunité dans la lave, aussi longtemps qu'il");
		cc.add("§ffaudra jusqu'a ce que vous vous noyez !");
		cpet.setLore(cc);
		firemandesc.setItemMeta(cpet);
	}
	ItemStack firemanstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = firemanstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fUtilisez votre seau d'eau pour vous déplacer sur les");
		cc.add("§fcollines et les ravins facilement, sans casser de blocs.");
		cc.add(" ");
		cc.add("§fUtilisez votre seau d'eau pour faire des MLG Water.");
		cc.add(" ");
		cc.add("§fRetirez l'eau du seau pour y mettre de la lave. Utilisez");
		cc.add("§fla lave comme une arme d'aide pour achever vos ennemis.");
		cc.add(" ");
		cc.add("§fAttaquez les Thor facilement grâce à votre immunité");
		cc.add("§fde la foudre du kit Thor.");
		cc.add(" ");
		cc.add("§fSautez, nagez dans la lave lorsque vous êtes poursuivis,");
		cc.add("§fils ne pourront pas vous suivre la où vous allez !");
		cpet.setLore(cc);
		firemanstrat.setItemMeta(cpet);
	}
	ItemStack firemanabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = firemanabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fVous êtes à l'abri des foudres du kit Thor.");
		cc.add("§fVous êtes à l'abri de la lave pendant quelques secondes.");
		cpet.setLore(cc);
		firemanabilities.setItemMeta(cpet);
	}
	ItemStack fireman = new ItemStack(Material.WATER_BUCKET);
	{
		ItemMeta cpet = fireman.getItemMeta();
		cpet.setDisplayName("§fUn seau d'eau");
		fireman.setItemMeta(cpet);
	}
	// fisherman
	ItemStack fishermandesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = fishermandesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit Fisherman vous permet de commencer avec");
		cc.add("§fune canne à pêche qui peut récuperer des poissons");
		cc.add("§fcrus et cuit, et de ramener les joueurs vers vous.");
		cc.add("§fFaites un clique droit une fois avec votre canne à");
		cc.add("§fpêche et une fois que le filet à toucher un joueur,");
		cc.add("§fre-cliquez une deuxième fois pour le ramener vers vous !");
		cpet.setLore(cc);
		fishermandesc.setItemMeta(cpet);
	}
	ItemStack fishermanstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = fishermanstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fPêchez et ramenez les joueurs qui courrent vers vous.");
		cc.add("§fLorsque vous faites une tour, pêchez les joueurs qui sont");
		cc.add("§fégalement entrain de faire une tour, puis ramenez les");
		cc.add("§fvers vous et tapez les directement pour les faire tomber");
		cc.add("§f de votre tour !");
		cc.add(" ");
		cc.add("§fUtilisez votre canne à pêche pour attraper des poitons dans");
		cc.add("§fdes petits lacs des dans des dépôts d'eau.");
		cc.add(" ");
		cc.add("§fFaites une tour, et utlisez votre canne à pêche pour frapper");
		cc.add("§fles joueurs au moment où ils se font une tour !");
		cpet.setLore(cc);
		fishermanstrat.setItemMeta(cpet);
	}
	ItemStack fishermanabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = fishermanabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fRamener les joueurs vers vous.");
		cpet.setLore(cc);
		fishermanabilities.setItemMeta(cpet);
	}
	ItemStack fisherman = new ItemStack(Material.FISHING_ROD);
	{
		ItemMeta cpet = fisherman.getItemMeta();
		cpet.setDisplayName("§fUne canne à pêche");
		fisherman.setItemMeta(cpet);
	}
	// flash
	ItemStack flashdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = flashdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit Flahs vous permet de vous téléporter");
		cc.add("§finstantanément à l'endroit où vous regardez avec");
		cc.add("§fune torche de redstone. Une fois que vous êtes");
		cc.add("§ftéléporté, vous avez Faiblesse I. Par exemple, si");
		cc.add("§fvous êtes téléporté à 60 blocs, vous aurez 30 secondes");
		cc.add("§fde Faiblesse I. Une fois téléporté, une foudre");
		cc.add("§fva frapper à l'endroit où vous vous êtes téléporté, et");
		cc.add("§fun effet de téléportation (comme un Enderman) suivra");
		cc.add("§fla où vous vous êtes téléporté. Votre torche de");
		cc.add("§fredstone s'éteindra quand vous l'aurez utilisé, et quand");
		cc.add("§fle cooldown terminé, elle se rallume.");
		cpet.setLore(cc);
		flashdesc.setItemMeta(cpet);
	}
	ItemStack flashstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = flashstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fTéléportez vous sur une tour et tapez les ennemis dans la");
		cc.add("§ftour, assurez-vous que vous visez au milieu de la tour pour");
		cc.add("§féviter de ne pas tomber !");
		cc.add("§cFaite une bordure autour de votre plate-forme pour s'assurer");
		cc.add("§fque vous ne soyez pas désarçonné, le Flash a une faiblesse");
		cc.add("§fjuste après leur téléportation, profitez - en pour le tuer !");
		cc.add(" ");
		cc.add("§fTéléportez vous en face de l'adversaire que vous poursuivez,");
		cc.add("§fet attaquez le !");
		cc.add("§cNe jamais courir tout droit, faites des zig zag.");
		cpet.setLore(cc);
		flashstrat.setItemMeta(cpet);
	}
	ItemStack flashabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = flashabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fFaites un clique droit la où vous regardez pour vous");
		cc.add("§ftéléporter à cette endroit, 2:30 minutes de cooldown,");
		cc.add("§fvous avez également la moitié de la distance de votre");
		cc.add("§ftéléportation en potion de faiblesse I.");
		cpet.setLore(cc);
		flashabilities.setItemMeta(cpet);
	}
	ItemStack flash = new ItemStack(Material.REDSTONE_TORCH_ON);
	{
		ItemMeta cpet = flash.getItemMeta();
		cpet.setDisplayName("§fUne torche de redstone");
		flash.setItemMeta(cpet);
	}
	// forger
	ItemStack forgerdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = forgerdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit forger vous donne la possibilité de fondre");
		cc.add("§finstantanément du minerais si vous assez de charbons");
		cc.add("§fpour tous les faires fondres. En cliquant sur le");
		cc.add("§fcharbon sur un minerai dans votre inventaire, il sera");
		cc.add("§fimmédiatement fondu en un lingot à un 1 charbon :");
		cc.add("§f1 lingot, donc en utilisant 15 charbons sur 35");
		cc.add("§fminerais de fer, il sera transformer par 15 lingots");
		cc.add("§fde fer et 20 minerai de fer.");
		cpet.setLore(cc);
		forgerdesc.setItemMeta(cpet);
	}
	ItemStack forgerstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = forgerstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fFaites équipe avec un mineur pour qu'il minte plus vite le");
		cc.add("§fcharbon, le minerai et forgez !");
		cc.add(" ");
		cc.add("§fTuez les joueurs qui minent et prenez leurs charbons et leurs");
		cc.add("§fminerais de fer, vous pourrez forger et vous faire de nouveaux");
		cc.add("§fitems.");
		cpet.setLore(cc);
		forgerstrat.setItemMeta(cpet);
	}
	ItemStack forgerabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = forgerabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fCliquez sur un minerai et sur un charbon dans votre");
		cc.add("§finventaire et il sera fondu immédiatement, en");
		cc.add("§fconsommant 1 charbon pour chaque minerai.");
		cpet.setLore(cc);
		forgerabilities.setItemMeta(cpet);
	}
	ItemStack forger = new ItemStack(Material.COAL, 3);
	{
		ItemMeta cpet = forger.getItemMeta();
		cpet.setDisplayName("§f3 Charbons");
		forger.setItemMeta(cpet);
	}
	// frosty
	ItemStack frostydesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = frostydesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit frosty vous donne un avantage énrorme sur");
		cc.add("§fles autres quand vous êtes sur la neige. Le joueur");
		cc.add("§fpeut également apoorter l'avantage à l'extérieur du");
		cc.add("§fbiome neige avec des boules de neige. Ce kit donne");
		cc.add("§fun avantage de toute partie qui s'oppose également au");
		cc.add("§fkit Poseidon.");
		cpet.setLore(cc);
		frostydesc.setItemMeta(cpet);
	}
	ItemStack frostystrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = frostystrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fRestez dans un biome neige autant que possible pour");
		cc.add("§ftoujours avoir l'avantage sur les joueurs qui viennent");
		cc.add("§fvers vous.");
		cc.add(" ");
		cc.add("§fJetez des boules de neige sur un endroit pour être plus");
		cc.add("§frapide que les autres.");
		cc.add(" ");
		cc.add("§fQuand un poseidon place son seau d'eau, utilisez une boule");
		cc.add("§fde neige pour geler l'eau et se débarrasser de ses effets.");
		cc.add(" ");
		cc.add("§fObtenez plusieurs stack de boules de neige, une fois que");
		cc.add("§fvous quittez le biome.");
		cc.add(" ");
		cc.add("§fFaire de la neige au Feast après que vous commencez à prendre");
		cc.add("§fassez d'avantages.");
		cpet.setLore(cc);
		frostystrat.setItemMeta(cpet);
	}
	ItemStack frostyabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = frostyabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fTransformez l'eau en glace lorsque vous jetez");
		cc.add("§fune boule de neige sur cette dernière.");
		cc.add(" ");
		cc.add("§fLorsque vous êtes sur la neige, vous obtenez");
		cc.add("§fun effet de potion : Vitesse II  qui dure une");
		cc.add("§faprès avoir quitter le biome neige.");
		cc.add(" ");
		cc.add("§fLancez une boule de neige qui va produire une");
		cc.add("§fpetite plateforme de neige au dessus du blocs");
		cc.add("§fvisé.");
		cpet.setLore(cc);
		frostyabilities.setItemMeta(cpet);
	}
	ItemStack frosty = new ItemStack(Material.SNOW_BALL, 5);
	{
		ItemMeta cpet = frosty.getItemMeta();
		cpet.setDisplayName("§f5 boules de neige");
		frosty.setItemMeta(cpet);
	}
	// gambler
	ItemStack gamblerdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = gamblerdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§aPour utiliser Gambler, placez un bouton sur un bloc,");
		cc.add("§apuis appuyez sur le bouton !");
		cc.add("§fLe kit Gambler est parfait pour les gens qui aiment");
		cc.add("§fles choses au hasard ! Les effets comprennent :");
		cc.add("§fLenteur, Poison, Mort instantée (1/1000 chance),");
		cc.add("§fFaim, Faiblesse, Force, Armure en diamant (1/1000 chance),");
		cc.add("§fRégénération, Boost de Faim et Vitesse.");
		cpet.setLore(cc);
		gamblerdesc.setItemMeta(cpet);
	}
	ItemStack gamblerstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = gamblerstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fUtilisez le bouton instantanément quand vous spawnez.");
		cc.add("§fDe cette façon, si vous obtenez un effet négatif, il");
		cc.add("§fn'est pas très grave vus que êtes invincible pendant");
		cc.add("§f2 minutes. N'oubliez pas de prendre tout le temp le");
		cc.add("§fbouton avec vous !");
		cc.add(" ");
		cc.add("§fUtilisez le bouton avant de vous battre, vous pouvez");
		cc.add("§fobtenir de la force, la vitesse ou de la régénération");
		cc.add("§fqui peut vraiment vous aider dans un combat !");
		cc.add(" ");
		cc.add("§fGambler puet être un bon kit d'équipe, si avez un effet");
		cc.add("§fnégatif, votre équipe peut vous aider. Effet positif et");
		cc.add("§fallez droit au but !");
		cpet.setLore(cc);
		gamblerstrat.setItemMeta(cpet);
	}
	ItemStack gamblerabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = gamblerabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fDes chances de gagner plusieurs effets, le hasard");
		cc.add("§fest équilibré car vous obtenez soit un effet positif");
		cc.add("§fsoit négatif !");
		cpet.setLore(cc);
		gamblerabilities.setItemMeta(cpet);
	}
	ItemStack gambler = new ItemStack(Material.STONE_BUTTON);
	{
		ItemMeta cpet = gambler.getItemMeta();
		cpet.setDisplayName("§fUn bouton");
		gambler.setItemMeta(cpet);
	}
	// grandpa
	ItemStack grandpadesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = grandpadesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit GrandPa est vraiment utile surtout sur");
		cc.add("§les collines, ou quand vous voulez restez seul !");
		cc.add("§fLe bâton a Recul II, qui envoi vos ennemis loin");
		cc.add("§fquand ils viennent vous voir.");
		cpet.setLore(cc);
		grandpadesc.setItemMeta(cpet);
	}
	ItemStack grandpastrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = grandpastrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fLorsque vous êtes dans un environnement vallonné,");
		cc.add("§fvous pouvez attirer quelqu'un vers vous puis les");
		cc.add("§ffrapper avec votre bâton. Les chances sont qu'ils");
		cc.add("§fvont être repoussés très loin, jusqu'a tomber de");
		cc.add("§fleur mort.");
		cc.add(" ");
		cc.add("§fUtilisez votre bâton (Recul II) pour gagner du");
		cc.add("§ftemps a vous refill des soupes, ou de trier votre");
		cc.add("§finventaire.");
		cc.add(" ");
		cc.add("§fLorsque vous êtes dans une équipe, le kit GrandPa");
		cc.add("§fpeut être très utile pour rattraper les ennemisqui");
		cc.add("§fne cessent de courrir.");
		cpet.setLore(cc);
		grandpastrat.setItemMeta(cpet);
	}
	ItemStack grandpaabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = grandpaabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fAucunes");
		cpet.setLore(cc);
		grandpaabilities.setItemMeta(cpet);
	}
	ItemStack grandpa = new ItemStack(Material.STICK);
	{
		grandpa.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
		ItemMeta cpet = grandpa.getItemMeta();
		cpet.setDisplayName("§fUn bâton (Recul II)");
		grandpa.setItemMeta(cpet);
	}
	// gravedigger
	ItemStack gravediggerdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = gravediggerdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit gravedigger vous permet de gérer très");
		cc.add("§fefficacement votre inventaire. Le coffre qui spawn");
		cc.add("§fquand vous tuez un joueur, est rès pratique car");
		cc.add("§fvous serez en mesure de choisir les items que");
		cc.add("§fvous voulez prendre. Très pratique quand les joueurs");
		cc.add("§fjettent beaucoup d'items.");
		cpet.setLore(cc);
		gravediggerdesc.setItemMeta(cpet);
	}
	ItemStack gravediggerstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = gravediggerstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fEn tuant des gens, vous pouvez facilement séléctionner");
		cc.add("§fles items que vous voulez dans leur cercueil (coffre).");
		cc.add(" ");
		cc.add("§fSi vous jouez dans une équipe, vos coéquipiers penvent");
		cc.add("§fégalement choisir quels items ils veulent dans le coffre.");
		cc.add(" ");
		cc.add("§fLe coffre peut souvent être une source de distraction");
		cc.add("§fpour les joueurs. Dans certains cas, les gens vont aller");
		cc.add("§ffouiner dans le coffre pour voir ce qu'il ya dedans.");
		cc.add("§fProfitez en pour les attaquer.");
		cpet.setLore(cc);
		gravediggerstrat.setItemMeta(cpet);
	}
	ItemStack gravediggerabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = gravediggerabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fLorsque vous tuez un joueur, leurs items sont stockés");
		cc.add("§fdans un coffre.");
		cpet.setLore(cc);
		gravediggerabilities.setItemMeta(cpet);
	}
	// hermit
	ItemStack hermitdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = hermitdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit hermit est très utile pour les personnes");
		cc.add("§fqui préfèrent commencer avec des soupes. Le kit");
		cc.add("§fHermit va essayer de vous placer à n'importe quel");
		cc.add("§fbiome à soupe aussi loin que possible. Dans cet");
		cc.add("§fordre : Marais > Jungle > Désert. Si aucun de ces");
		cc.add("§fbiomes sont disponibles, vous commencerez à 300 blocs");
		cc.add("§fdu spawn.");
		cpet.setLore(cc);
		hermitdesc.setItemMeta(cpet);
	}
	ItemStack hermitstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = hermitstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fIl vous permet d'obtenir facilement des items tels que");
		cc.add("§fle bois, le fer et sans avoir quelqu'un autour de vous.");
		cc.add(" ");
		cc.add("§fVous disposez d'une distance de sécurité, car il faudra");
		cc.add("§fque les joueurs prennent environ 2 minutes pour arriver à");
		cc.add("§f300 blocs du spawn !");
		cpet.setLore(cc);
		hermitstrat.setItemMeta(cpet);
	}
	ItemStack hermitabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = hermitabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fVous spawnez sur le plus loin biome marrécage, sinon, dans");
		cc.add("§fle plus loin biome jungle sinon dans le plus loin biome désert,");
		cc.add("§fsinon vous spawnez à 300 blocs du spawn !");
		cpet.setLore(cc);
		hermitabilities.setItemMeta(cpet);
	}
	// hulk
	ItemStack hulkdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = hulkdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit hulk est excellent à la fois pour");
		cc.add("§fs'échapper et pour piéger vos adversaires.");
		cc.add("§fEn fesant un clique droit sur un joeur avec");
		cc.add("§fses mains, un Hulk peut utiliser sa puissante");
		cc.add("§fforce. Avec un simple clique gauche, la victime");
		cc.add("§fest ensuite propulsée dans les airs.");
		cpet.setLore(cc);
		hulkdesc.setItemMeta(cpet);
	}
	ItemStack hulkstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = hulkstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fEchappez vous des attaques d'autres joueurs en les");
		cc.add("§fjetant dans les airs !");
		cc.add(" ");
		cc.add("§fJetez les joueurs dans la lave ou sur des pièges,");
		cc.add("§fHulk et Demoman sont une conbinaison parfaite !");
		cpet.setLore(cc);
		hulkstrat.setItemMeta(cpet);
	}
	ItemStack hulkabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = hulkabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fRamassez les joueurs en leur cliquand dessus (clique droit) et");
		cc.add("§fjetez les par un clique gauche avec votre slot vide !");
		cpet.setLore(cc);
		hulkabilities.setItemMeta(cpet);
	}
	// hunter
	ItemStack hunterdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = hunterdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit hunter est assez chouette et utile quand");
		cc.add("§fvous êtes entouré de cochons. Ce kit permet de");
		cc.add("§fgagner du temps, puisque vous n'aurez pas à faire");
		cc.add("§fcuire la viande crue que les cochons drop !");
		cpet.setLore(cc);
		hunterdesc.setItemMeta(cpet);
	}
	ItemStack hunterstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = hunterstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fEn début, ou milieu de partie, avoir de la nourriture");
		cc.add("§fest toujours un élément clé dans les Hunger Games.");
		cc.add("§fTuer des cochons permet d'économiser beaucoup de temps,");
		cc.add("§fcar cela vous nourrit et permet d'économiser le temps");
		cc.add("§fde cuisson.");
		cc.add(" ");
		cc.add("§fHunter dans une équipe vous permettra de distribuer");
		cc.add("§fde la viande de cochon cuit à vos coéquipiers, encore");
		cc.add("§fune fois, vous gagnez du temps sur la viande de cochon.");
		cpet.setLore(cc);
		hunterstrat.setItemMeta(cpet);
	}
	ItemStack hunterabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = hunterabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fLes cochons drop toujours une viande de porc cuit.");
		cpet.setLore(cc);
		hunterabilities.setItemMeta(cpet);
	}
	// jackhammer
	ItemStack jackhammerdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = jackhammerdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit jackhammer vous donne la possibilité de");
		cc.add("§fcasser les blocs au dessus de vous en cassant à");
		cc.add("§fla racine de ce dernier avec votre hache en pierre.");
		cc.add("§fDès que vous cassez un bloc, tout les blocs ci-dessus");
		cc.add("§fvont commencer à disparaître jusqu'au ciel. Ou utiliser");
		cc.add("§fAprès 5 utilisations le cooldown débutera.");
		cpet.setLore(cc);
		jackhammerdesc.setItemMeta(cpet);
	}
	ItemStack jackhammerstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = jackhammerstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fSi vous voyez une personne sur un bloc flottant,");
		cc.add("§fbriser un bloc en dessous du bloc flottant et");
		cc.add("§fattendez pour que cela fasse effet afin que le");
		cc.add("§fbloc flottant disparaît pour que vous admirez");
		cc.add("§fla chutte du joueur.");
		cc.add(" ");
		cc.add("§fCoincé sous terre et vous voulez remonter ? Il vous");
		cc.add("§fsuffit d'utiliser votre hache en pierre et de casser");
		cc.add("§fun bloc pour que vous liberer un passage et de remonter.");
		cpet.setLore(cc);
		jackhammerstrat.setItemMeta(cpet);
	}
	ItemStack jackhammerabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = jackhammerabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fBriser un bloc en regardant vers le haut pour causer la");
		cc.add("§fdisparition de tout les blocs jusqu'au ciel.");
		cc.add(" ");
		cc.add("§fBriser un bloc en regardant vers le bat pour causer la");
		cc.add("§fdisparition de tout les blocs jusqu'à la bedrock.");
		cpet.setLore(cc);
		jackhammerabilities.setItemMeta(cpet);
	}
	ItemStack jackhammer = new ItemStack(Material.STONE_AXE);
	{
		ItemMeta cpet = jackhammer.getItemMeta();
		cpet.setDisplayName("§fUne hache en pierre");
		jackhammer.setItemMeta(cpet);
	}
	// jumper
	ItemStack jumperdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = jumperdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit jumper est excellent pour se rendre à");
		cc.add("§fdes endroits plus rapide que tout le monde, ou");
		cc.add("§fd'échapper à des moments difficiles. Ce kit est");
		cc.add("§futile, dans tout les aspects du jeu ! Quand vous");
		cc.add("§fjetez une perle d'Ender, vous ne prendrez aucun");
		cc.add("§fdommages causés par lé téléportation, et une");
		cc.add("§fplate-forme de 4x4 apparaîtra sous vos pieds,");
		cc.add("§fd'une durée de 5 secondes et cela sécurisera");
		cc.add("§fvotre atterrissage partout où vous allez.");
		cpet.setLore(cc);
		jumperdesc.setItemMeta(cpet);
	}
	ItemStack jumperstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = jumperstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fSi il ya un village PNJ x blocs du spawn, vous");
		cc.add("§fpouvez utiliser vos perles d'Ender pendant");
		cc.add("§fl'invincibilité pour y arriver avant tout le");
		cc.add("§fmonde.");
		cc.add(" ");
		cc.add("§fUtilisez vos perles d'Ender pour vous échapper");
		cc.add("§frapidement d'un combat si vous vous entez en");
		cc.add("§fgrande difficultée, de cette façon vous pourrez");
		cc.add("§fvous refill ou tout simplement s'échapper.");
		cc.add(" ");
		cc.add("§fDonnez à un coéquipier certains de vos perles");
		cc.add("§fd'Ender. C'est une autre méthode efficace de");
		cc.add("§fs'échapper en utilisant bien le kit.");
		cc.add(" ");
		cc.add("§fAllez au Feast rapidement avec vos perles d'Ender.");
		cc.add(" ");
		cc.add("§fEssayez et lancez une de vos perles d'Ender");
		cc.add("§fsur une tour, de cette façon vous gagnerez du temps");
		cc.add("§fà construire une tour en dessous de l'adversaire.");
		cpet.setLore(cc);
		jumperstrat.setItemMeta(cpet);
	}
	ItemStack jumperabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = jumperabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fAucunes");
		cpet.setLore(cc);
		jumperabilities.setItemMeta(cpet);
	}
	ItemStack jumper = new ItemStack(Material.ENDER_PEARL, 5);
	{
		ItemMeta cpet = jumper.getItemMeta();
		cpet.setDisplayName("§f5 Perles d'Ender");
		jumper.setItemMeta(cpet);
	}
	// kangaroo
	ItemStack kangaroodesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = kangaroodesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit kangaroo vous permet de faire de grand");
		cc.add("§fsauts en fesant un clique droit sur votre fusée.");
		cc.add("§fCela vous permet d'échapper à des endroits étroits");
		cc.add("§fplus facilement ou de vous échapper des combats");
		cc.add("§fquand vous êtes en grande difficulté. Vous ne");
		cc.add("§fprendrez que 3.5 coeurs de dégâts de chutes.");
		cpet.setLore(cc);
		kangaroodesc.setItemMeta(cpet);
	}
	ItemStack kangaroostrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = kangaroostrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fCombattre un ennemi, mais vous êtes en difficulté ?");
		cc.add("§fCourrez vers un arbre et sautez avec votre fusée pour");
		cc.add("§fensuite si vous voulez vous refill.");
		cc.add(" ");
		cc.add("§fVous voulez aller au fond d'un ravin, et de");
		cc.add("§fprendre des dégâts de chute minimale ?");
		cc.add("§fAvec le kit Kangaroo vous prendrez que 3.5");
		cc.add("§fcoeurs de dégâts de chutes.");
		cc.add(" ");
		cc.add("§fUtilisez votre double saut pour faire coups");
		cc.add("§fsupplémentaires, et des coups critiques sur");
		cc.add("§fvos ennemis quand vous vous combattez.");
		cpet.setLore(cc);
		kangaroostrat.setItemMeta(cpet);
	}
	ItemStack kangarooabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = kangarooabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fUn clique droit sur votre fusée vous permet de");
		cc.add("§ffaire un double saut.");
		cpet.setLore(cc);
		kangarooabilities.setItemMeta(cpet);
	}
	ItemStack kangaroo = new ItemStack(Material.FIREWORK);
	{
		ItemMeta cpet = kangaroo.getItemMeta();
		cpet.setDisplayName("§fUne fusée");
		kangaroo.setItemMeta(cpet);
	}
	// kaya
	ItemStack kayadesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = kayadesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit kaya est génial pour les pièges de");
		cc.add("§fplantation et des victimes sans méfiance !");
		cc.add("§fEn étant Kaya, vous pouvez utiliser les blocs");
		cc.add("§fd'herbes pour faire tomber les gens de très loin,");
		cc.add("§fou dans la lave. Vous pouvez créer des blocs");
		cc.add("§fd'herbe avec de la terre et des graines.");
		cpet.setLore(cc);
		kayadesc.setItemMeta(cpet);
	}
	ItemStack kayastrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = kayastrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fPlacez des blocs d'herbe sur un ravin. Une");
		cc.add("§fvictime marchera dessus et tombera à leur");
		cc.add("§fmort, vous pouvez aller dans son lieu de mort");
		cc.add("§fpour y collécter ses items !");
		cc.add(" ");
		cc.add("§fPlacez des blocs d'herbe au dessus ou dans");
		cc.add("§fvotre base, faites un très profond trou en");
		cc.add("§fdessous pour que les gens tombent à leur mort.");
		cc.add(" ");
		cc.add("§fCela fonctionne très bien avec quelque kits :");
		cc.add("§fFireman, piège de lave. Demoman, piège d'explosion.");
		cc.add("§fCultivator, des graines pour vous permettre de faire");
		cc.add("§fplus de blocs d'herbe");
		cpet.setLore(cc);
		kayastrat.setItemMeta(cpet);
	}
	ItemStack kayaabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = kayaabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fLes blocs d'herbe disparaissent quand un ennemi");
		cc.add("§fmarche dessus.");
		cc.add(" ");
		cc.add("§fFabriquez des blocs d'herbe de Kaya en combinant");
		cc.add("§fdes graines et de la terre dans une table de craft.");
		cpet.setLore(cc);
		kayaabilities.setItemMeta(cpet);
	}
	ItemStack kaya = new ItemStack(Material.GRASS, 16);
	{
		ItemMeta cpet = kaya.getItemMeta();
		cpet.setDisplayName("§f16 Blocs de Kaya");
		kaya.setItemMeta(cpet);
	}
	// launcher
	ItemStack launcherdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = launcherdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit Launcher vous donne 20 éponges, et");
		cc.add("§fquand quelqu'un marche dessus sa va l'ejecter");
		cc.add("§faussi loin qu'il le faut. Placer les éponges en");
		cc.add("§fdiagonales, vous propulseras sur le côté.");
		cc.add("§fEmpiler les éponges une à une, augmente la");
		cc.add("§fpuissance de la lancée. Toute personne qui est");
		cc.add("§fpropulsé par les éponges sera protégé des");
		cc.add("§fdommages de chute.");
		cpet.setLore(cc);
		launcherdesc.setItemMeta(cpet);
	}
	ItemStack launcherstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = launcherstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fConstruisez une plateforme et propulsez vos");
		cc.add("§fcoéquipiers dans les tours, il n'y a aucun");
		cc.add("§frisque, car ils ne prennet pas de dégâts");
		cc.add("§fde chute !");
		cc.add(" ");
		cc.add("§fFaites une plateforme au feast et laissez");
		cc.add("§fvotre coéquipiers qui est stomper, pour");
		cc.add("§fpietiner les adversaires au feast !");
		cpet.setLore(cc);
		launcherstrat.setItemMeta(cpet);
	}
	ItemStack launcherabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = launcherabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fPropulsez les joueurs qui marchent sur vos éponges");
		cc.add("§fils seront tout de même protégés contre les dégâts");
		cc.add("§fde chutes entrant.");
		cpet.setLore(cc);
		launcherabilities.setItemMeta(cpet);
	}
	ItemStack launcher = new ItemStack(Material.SPONGE, 20);
	{
		ItemMeta cpet = launcher.getItemMeta();
		cpet.setDisplayName("§f20 Éponges");
		launcher.setItemMeta(cpet);
	}
	// levitator
	ItemStack levitatordesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = levitatordesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit levitator vous permettra de ramasser");
		cc.add("§fdes blocs avec votre baguette de lévitateur,");
		cc.add("§fce qui vous permet de viser avec le bloc. Faire");
		cc.add("§fun clique gauche dans l'air lancera le bloque que");
		cc.add("§fvous maintenez. Quiconque se fait toucher par le");
		cc.add("§fbloc, il prendra des dégâts. Remarque :  Certains");
		cc.add("§fblocs peuvent avoir des effets supplémentaires");
		cc.add("§florsque vous les lancez sur vos ennemis !");
		cpet.setLore(cc);
		levitatordesc.setItemMeta(cpet);
	}
	ItemStack levitatorstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = levitatorstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fVisez les joueurs dans les tours, et explosez-les.");
		cc.add(" ");
		cc.add("§fLes blocs s'explosent en touchant un autre bloc.");
		cpet.setLore(cc);
		levitatorstrat.setItemMeta(cpet);
	}
	ItemStack levitatorabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = levitatorabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fVous pouvez vous procurze des blocs en faisant un");
		cc.add("§fclique droit avec torche magique sur ce bloc et");
		cc.add("§ffaites un clique gauche le propulser !");
		cpet.setLore(cc);
		levitatorabilities.setItemMeta(cpet);
	}
	ItemStack levitator = new ItemStack(Material.TORCH);
	{
		ItemMeta cpet = levitator.getItemMeta();
		cpet.setDisplayName("§fUne torche spéciale");
		levitator.setItemMeta(cpet);
	}
	// lumberjack
	ItemStack lumberjackdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = lumberjackdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit lumberjack est efficace en début de jeu");
		cc.add("§fou dans la jungle. Votre hache (Incassable I),");
		cc.add("§fpeut être utilisé pour faire tomber tout les");
		cc.add("§fblocs de bois en creusant par la racine.");
		cpet.setLore(cc);
		lumberjackdesc.setItemMeta(cpet);
	}
	ItemStack lumberjackstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = lumberjackstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fDans la jungle, vous pouvez cassez la racine d'un");
		cc.add("§fgrand arbre (baobab), pour avoir un maximum de bois");
		cc.add("§fle plus rapidement possible.");
		cc.add(" ");
		cc.add("§fEn début de partie, vous pouvez facilement avoir");
		cc.add("§ftout un arbre et d'avoir une épée en pierre le plus");
		cc.add("§frapidement possible.");
		cpet.setLore(cc);
		lumberjackstrat.setItemMeta(cpet);
	}
	ItemStack lumberjackabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = lumberjackabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fCassez la racine d'un arbre, et récuperer tout les");
		cc.add("§fblocs d'arbre qui tombent au même moment !");
		cpet.setLore(cc);
		lumberjackabilities.setItemMeta(cpet);
	}
	ItemStack lumberjack = new ItemStack(Material.WOOD_AXE);
	{
		ItemMeta cpet = lumberjack.getItemMeta();
		cpet.setDisplayName("§fUne hache en bois");
		lumberjack.setItemMeta(cpet);
	}
	// miner
	ItemStack minerdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = minerdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit miner est pour les joueurs qui veulent");
		cc.add("§fobtenir du fer plus rapidement. Le boost de");
		cc.add("§fvitesse est vraiment utile quand vous minez !");
		cc.add("§fMangez une pomme quand votre santé est au max");
		cc.add("§fet votre faim au max et puis minez.");
		cpet.setLore(cc);
		minerdesc.setItemMeta(cpet);
	}
	ItemStack minerstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = minerstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fObtenez 2 bois, et explorer directement dans des");
		cc.add("§fgrottes. Prenez un peu de charbon, du fer et");
		cc.add("§ffaites fondre le fer. Puis dominez la partie !");
		cc.add(" ");
		cc.add("§fUtilisez le boost de vitesse, de cette façon vous");
		cc.add("§fminerez plus facilement et plus rapidement en début");
		cc.add("§fde partie.");
		cc.add(" ");
		cc.add("§fCe kit est excellent en équipe, car il vous permet");
		cc.add("§fd'être full fer le plus rapidement possible.");
		cpet.setLore(cc);
		minerstrat.setItemMeta(cpet);
	}
	ItemStack minerabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = minerabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fMangez une pomme en ayant votre santé et votre");
		cc.add("§ffaim au max et minez vous aurez un Boost de Vitesse !");
		cpet.setLore(cc);
		minerabilities.setItemMeta(cpet);
	}
	ItemStack miner = new ItemStack(Material.STONE_PICKAXE);
	{
		miner.addEnchantment(Enchantment.DIG_SPEED, 1);
		ItemMeta cpet = miner.getItemMeta();
		cpet.setDisplayName("§fUne pioche en pierre");
		miner.setItemMeta(cpet);
	}
	ItemStack miner2 = new ItemStack(Material.APPLE, 5);
	{
		ItemMeta cpet = miner2.getItemMeta();
		cpet.setDisplayName("§f5 pommes");
		miner2.setItemMeta(cpet);
	}
	// monster
	ItemStack monsterdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = monsterdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit monster est un kit parfait pour miner");
		cc.add("§fen toute sécurité, ou attaquer pendant la nuit");
		cc.add("§fsans être dérangé !");
		cpet.setLore(cc);
		monsterdesc.setItemMeta(cpet);
	}
	ItemStack monsterstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = monsterstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fMinez sans être attaqué par un monstre. Ceci");
		cc.add("§fvous permet de miner facilement dans les grandes");
		cc.add("§fgrottes ou dans des ravins sans vous faire attaqué");
		cc.add("§fpar un monstre.");
		cc.add(" ");
		cc.add("§fNe vous inquiétez pas des torches, les monstres ne");
		cc.add("§fvont tout de même ne pas vous attaquer !");
		cc.add(" ");
		cc.add("§fFaites vous une base dans des mob-spawners, de cette");
		cc.add("§ffaçon, quand un joueur viendra vous attaquer, il sera");
		cc.add("§fattaqué par les monstre du spawner et admirez !");
		cc.add(" ");
		cc.add("§fLes combats durant la nuit, les ennemis attaqueront");
		cc.add("§fvos ennemis mais pas vous.");
		cpet.setLore(cc);
		monsterstrat.setItemMeta(cpet);
	}
	ItemStack monsterabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = monsterabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fLes monstres ne vous attaque pas sauf si");
		cc.add("§fvous les provoquez.");
		cpet.setLore(cc);
		monsterabilities.setItemMeta(cpet);
	}
	// necro
	ItemStack necrodesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = necrodesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit Necro complimente et fonctionne vraiment");
		cc.add("§favec le kit Beastmaster. Cependant, avec Necro");
		cc.add("§fvous pouvez utiliser les os pour faire pousser");
		cc.add("§fplus vite la nourriture, ce kit est vraiment utile.");
		cpet.setLore(cc);
		necrodesc.setItemMeta(cpet);
	}
	ItemStack necrostrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = necrostrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fEn tuant des squelettes, vous pouvez utiliser");
		cc.add("§f2 os pour faire 2 pains. Utilisez-le pour vous");
		cc.add("§falimenter ou pour un coéquipier.");
		cc.add(" ");
		cc.add("§fFaites équipe avec un Beastmaster pour l'aider");
		cc.add("§fà avoir plus d'os et d'apprivoiser plus de loups.");
		cc.add(" ");
		cc.add("§fOu, utilisez les os pour vous même, pour apprivoiser");
		cc.add("§fdes loups pour vous !");
		cpet.setLore(cc);
		necrostrat.setItemMeta(cpet);
	}
	ItemStack necroabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = necroabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fLes squelettes sont tués en un coup.");
		cpet.setLore(cc);
		necroabilities.setItemMeta(cpet);
	}
	// phantom
	ItemStack phantomdesc = new ItemStack(Material.BOOK);
	{
		ItemMeta cpet = phantomdesc.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§eDescription");
		cc.add("§fLe kit phantom vous donnera une plume que vous");
		cc.add("§fpouvez l'utiliser pour obtenir 5 secondes de vol,");
		cc.add("§fce kit est très bruyant quand vous volez.");
		cc.add("§fLe kit informe les personnes proches de vous que");
		cc.add("§fvous n'utilisez pas de hack pour fly. Si vous");
		cc.add("§frecevez des dégâts de chutes après votre temps de");
		cc.add("§fvol, ces derniers seront doublés.");
		cpet.setLore(cc);
		phantomdesc.setItemMeta(cpet);
	}
	ItemStack phantomstrat = new ItemStack(Material.COMPASS);
	{
		ItemMeta cpet = phantomstrat.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§9Stratégies");
		cc.add("§fVoler dans des tours et bousculez les joueurs");
		cc.add("§fjusqu'a ce qu'ils tombent de leurs tours.");
		cc.add(" ");
		cc.add("§fQuand vous volez, assurez-vous d'atterire sur le");
		cc.add("§fsol avant que le temps soit écoulé.");
		cpet.setLore(cc);
		phantomstrat.setItemMeta(cpet);
	}
	ItemStack phantomabilities = new ItemStack(Material.EMERALD);
	{
		ItemMeta cpet = phantomabilities.getItemMeta();
		ArrayList<String> cc = new ArrayList();
		cpet.setDisplayName("§aCapacités");
		cc.add("§fFaites un clique droit sur votre plume pour");
		cc.add("§fobtenir 5 secondes de vol, 60 secondes de");
		cc.add("§fcooldown après que votre temps de vol.");
		cpet.setLore(cc);
		phantomabilities.setItemMeta(cpet);
	}
	ItemStack phantom = new ItemStack(Material.FEATHER);
	{
		ItemMeta cpet = phantom.getItemMeta();
		cpet.setDisplayName("§fUne plume");
		phantom.setItemMeta(cpet);
	}

	@EventHandler
	public void onInv3(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getInventory().getItemInHand().getType() == Material.CHEST) {
			if ((e.getAction() != Action.RIGHT_CLICK_AIR)
					&& (e.getAction() != Action.RIGHT_CLICK_BLOCK)
					&& (e.getAction() != Action.LEFT_CLICK_AIR)
					&& (e.getAction() == Action.LEFT_CLICK_BLOCK)) {
			}
			if (p.getItemInHand().getItemMeta() != null
					&& p.getItemInHand().getItemMeta().getDisplayName() != null
					&& ChatColor.stripColor(
							p.getInventory().getItemInHand().getItemMeta()
									.getDisplayName()).equalsIgnoreCase(
							"Kit Sélécteur")) {
				InvPage1(p);
			}
		}
	}

	public static void InvPage1(Player p) {
		inv = Bukkit.createInventory(null, 54, "             §fVos kits: "
				+ getAmountOwnedKits(p) + "/" + Kit.values().length);
		inv.setItem(0, leftcarpet);
		inv.setItem(1, thinglass);
		inv.setItem(2, thinglass);
		inv.setItem(3, thinglass);
		inv.setItem(4, powder);
		inv.setItem(5, thinglass);
		inv.setItem(6, thinglass);
		inv.setItem(7, thinglass);
		inv.setItem(8, rightcarpet);
		if (p.hasPermission("hg.kits.anchor")) {
			inv.addItem(Anchor);
		}
		if (p.hasPermission("hg.kits.archer")) {
			inv.addItem(Archer);
		}
		if (p.hasPermission("hg.kits.beastmaster")) {
			inv.addItem(Beastmaster);
		}
		if (p.hasPermission("hg.kits.berserker")) {
			inv.addItem(Berserker);
		}
		if (p.hasPermission("hg.kits.boxer")) {
			inv.addItem(Boxer);
		}
		if (p.hasPermission("hg.kits.cannibal")) {
			inv.addItem(Cannibal);
		}
		if (p.hasPermission("hg.kits.chemist")) {
			inv.addItem(Chemist);
		}
		if (p.hasPermission("hg.kits.cookiemonster")) {
			inv.addItem(Cookiemonster);
		}
		if (p.hasPermission("hg.kits.cultivator")) {
			inv.addItem(Cultivator);
		}
		if (p.hasPermission("hg.kits.demoman")) {
			inv.addItem(Demoman);
		}
		if (p.hasPermission("hg.kits.digger")) {
			inv.addItem(Digger);
		}
		if (p.hasPermission("hg.kits.doctor")) {
			inv.addItem(Doctor);
		}
		if (p.hasPermission("hg.kits.dwarf")) {
			inv.addItem(Dwarf);
		}
		if (p.hasPermission("hg.kits.endermage")) {
			inv.addItem(Endermage);
		}
		if (p.hasPermission("hg.kits.fireman")) {
			inv.addItem(Fireman);
		}
		if (p.hasPermission("hg.kits.fisherman")) {
			inv.addItem(Fisherman);
		}
		if (p.hasPermission("hg.kits.forger")) {
			inv.addItem(Forger);
		}
		if (p.hasPermission("hg.kits.frosty")) {
			inv.addItem(Frosty);
		}
		if (p.hasPermission("hg.kits.grandpa")) {
			inv.addItem(GrandPa);
		}
		if (p.hasPermission("hg.kits.hermit")) {
			inv.addItem(Hermit);
		}
		if (p.hasPermission("hg.kits.hunter")) {
			inv.addItem(Hunter);
		}
		if (p.hasPermission("hg.kits.jumper")) {
			inv.addItem(Jumper);
		}
		if (p.hasPermission("hg.kits.kangaroo")) {
			inv.addItem(Kangaroo);
		}
		inv.addItem(anchorglass);
		inv.addItem(archerglass);
		inv.addItem(beastmasterglass);
		inv.addItem(berserkerglass);
		inv.addItem(boxerglass);
		inv.addItem(cannibalglass);
		inv.addItem(chemistglass);
		inv.addItem(cookiemonsterglass);
		inv.addItem(cultivatorglass);
		inv.addItem(demomanglass);
		inv.addItem(diggerglass);
		inv.addItem(doctorglass);
		inv.addItem(dwarfglass);
		inv.addItem(endermageglass);
		inv.addItem(firemanglass);
		inv.addItem(fishermanglass);
		inv.addItem(forgerglass);
		inv.addItem(frostyglass);
		inv.addItem(grandpaglass);
		inv.addItem(hermitglass);
		inv.addItem(hunterglass);
		inv.addItem(jumperglass);
		inv.addItem(kangarooglass);
		inv.setItem(35, thinglass);
		inv.setItem(36, thinglass);
		inv.setItem(37, thinglass);
		inv.setItem(38, thinglass);
		inv.setItem(39, thinglass);
		inv.setItem(40, thinglass);
		inv.setItem(41, thinglass);
		inv.setItem(42, thinglass);
		inv.setItem(43, thinglass);
		inv.setItem(44, thinglass);
		inv.setItem(45, thinglass);
		inv.setItem(46, thinglass);
		inv.setItem(47, thinglass);
		inv.setItem(48, thinglass);
		inv.setItem(49, thinglass);
		inv.setItem(50, thinglass);
		inv.setItem(51, thinglass);
		inv.setItem(52, thinglass);
		inv.setItem(53, thinglass);
		p.openInventory(inv);
	}

	// TODO
	public void createInventories() {
		otherskits = Bukkit.createInventory(null, 54, "§fVos kits");
		otherskits.setItem(0, leftcarpet);
		otherskits.setItem(1, thinglass);
		otherskits.setItem(2, thinglass);
		otherskits.setItem(3, thinglass);
		otherskits.setItem(4, powder);
		otherskits.setItem(5, thinglass);
		otherskits.setItem(6, thinglass);
		otherskits.setItem(7, thinglass);
		otherskits.setItem(8, rightcarpet);
		otherskits.addItem(Seeker);
		otherskits.addItem(Snail);
		otherskits.addItem(Specialist);
		otherskits.addItem(Spectre);
		otherskits.addItem(Spiderman);
		otherskits.addItem(Spy);
		otherskits.addItem(Stomper);
		otherskits.addItem(Surprise);
		otherskits.addItem(Switcher);
		otherskits.addItem(Tank);
		otherskits.addItem(Tarzan);
		otherskits.addItem(Thermo);
		otherskits.addItem(Thor);
		otherskits.addItem(Timelord);
		otherskits.addItem(Turtle);
		otherskits.addItem(Urgal);
		otherskits.addItem(Vampire);
		otherskits.addItem(Viking);
		otherskits.addItem(Viper);
		otherskits.addItem(Vulture);
		otherskits.addItem(Werewolf);
		otherskits.addItem(Wisp);
		otherskits.addItem(Worm);
		anchorkit = Bukkit.createInventory(null, 54, "§fLe kit Anchor");
		anchorkit.setItem(0, leftcarpet);
		anchorkit.setItem(1, thinglass);
		anchorkit.setItem(2, thinglass);
		anchorkit.setItem(3, thinglass);
		anchorkit.setItem(4, powder);
		anchorkit.setItem(5, thinglass);
		anchorkit.setItem(6, thinglass);
		anchorkit.setItem(7, thinglass);
		anchorkit.setItem(8, rightcarpet);
		anchorkit.setItem(9, thinglass);
		anchorkit.setItem(10, thinglass);
		anchorkit.setItem(11, thinglass);
		anchorkit.setItem(12, thinglass);
		anchorkit.setItem(13, thinglass);
		anchorkit.setItem(14, thinglass);
		anchorkit.setItem(15, thinglass);
		anchorkit.setItem(16, thinglass);
		anchorkit.setItem(17, thinglass);
		anchorkit.setItem(18, thinglass);
		anchorkit.setItem(19, thinglass);
		anchorkit.setItem(20, thinglass);
		anchorkit.setItem(21, anchordesc);
		anchorkit.setItem(22, thinglass);
		anchorkit.setItem(23, anchorstrat);
		anchorkit.setItem(24, thinglass);
		anchorkit.setItem(25, anchorabilities);
		anchorkit.setItem(26, thinglass);
		anchorkit.setItem(27, thinglass);
		anchorkit.setItem(28, thinglass);
		anchorkit.setItem(29, thinglass);
		anchorkit.setItem(30, thinglass);
		anchorkit.setItem(31, thinglass);
		anchorkit.setItem(32, thinglass);
		anchorkit.setItem(33, thinglass);
		anchorkit.setItem(34, thinglass);
		anchorkit.setItem(35, thinglass);
		anchorkit.setItem(36, signkit);
		anchorkit.setItem(37, thinglass);
		anchorkit.setItem(38, thinglass);
		anchorkit.setItem(39, thinglass);
		anchorkit.setItem(40, thinglass);
		anchorkit.setItem(41, thinglass);
		anchorkit.setItem(42, thinglass);
		anchorkit.setItem(43, thinglass);
		anchorkit.setItem(44, playkit);
		anchorkit.setItem(45, thinglass);
		anchorkit.setItem(46, thinglass);
		anchorkit.setItem(47, thinglass);
		anchorkit.setItem(48, thinglass);
		anchorkit.setItem(49, thinglass);
		anchorkit.setItem(50, thinglass);
		anchorkit.setItem(51, thinglass);
		anchorkit.setItem(52, thinglass);
		anchorkit.setItem(53, thinglass);
		archerkit = Bukkit.createInventory(null, 54, "§fLe kit Archer");
		archerkit.setItem(0, leftcarpet);
		archerkit.setItem(1, thinglass);
		archerkit.setItem(2, thinglass);
		archerkit.setItem(3, thinglass);
		archerkit.setItem(4, powder);
		archerkit.setItem(5, thinglass);
		archerkit.setItem(6, thinglass);
		archerkit.setItem(7, thinglass);
		archerkit.setItem(8, rightcarpet);
		archerkit.setItem(9, thinglass);
		archerkit.setItem(10, thinglass);
		archerkit.setItem(11, thinglass);
		archerkit.setItem(12, thinglass);
		archerkit.setItem(13, thinglass);
		archerkit.setItem(14, thinglass);
		archerkit.setItem(15, thinglass);
		archerkit.setItem(16, thinglass);
		archerkit.setItem(17, thinglass);
		archerkit.setItem(18, thinglass);
		archerkit.setItem(19, thinglass);
		archerkit.setItem(20, thinglass);
		archerkit.setItem(21, archerdesc);
		archerkit.setItem(22, thinglass);
		archerkit.setItem(23, archerstrat);
		archerkit.setItem(24, thinglass);
		archerkit.setItem(25, archerabilities);
		archerkit.setItem(26, thinglass);
		archerkit.setItem(27, thinglass);
		archerkit.setItem(28, thinglass);
		archerkit.setItem(29, thinglass);
		archerkit.setItem(30, thinglass);
		archerkit.setItem(31, thinglass);
		archerkit.setItem(32, thinglass);
		archerkit.setItem(33, thinglass);
		archerkit.setItem(34, thinglass);
		archerkit.setItem(35, thinglass);
		archerkit.setItem(36, signkit);
		archerkit.setItem(37, thinglass);
		archerkit.setItem(38, thinglass);
		archerkit.setItem(39, thinglass);
		archerkit.setItem(40, thinglass);
		archerkit.setItem(41, thinglass);
		archerkit.setItem(42, thinglass);
		archerkit.setItem(43, thinglass);
		archerkit.setItem(44, playkit);
		archerkit.setItem(45, archericon);
		archerkit.setItem(46, archericon2);
		archerkit.setItem(47, thinglass);
		archerkit.setItem(48, thinglass);
		archerkit.setItem(49, thinglass);
		archerkit.setItem(50, thinglass);
		archerkit.setItem(51, thinglass);
		archerkit.setItem(52, thinglass);
		archerkit.setItem(53, thinglass);
		beastmasterkit = Bukkit.createInventory(null, 54,
				"§fLe kit Beastmaster");
		beastmasterkit.setItem(0, leftcarpet);
		beastmasterkit.setItem(1, thinglass);
		beastmasterkit.setItem(2, thinglass);
		beastmasterkit.setItem(3, thinglass);
		beastmasterkit.setItem(4, powder);
		beastmasterkit.setItem(5, thinglass);
		beastmasterkit.setItem(6, thinglass);
		beastmasterkit.setItem(7, thinglass);
		beastmasterkit.setItem(8, rightcarpet);
		beastmasterkit.setItem(9, thinglass);
		beastmasterkit.setItem(10, thinglass);
		beastmasterkit.setItem(11, thinglass);
		beastmasterkit.setItem(12, thinglass);
		beastmasterkit.setItem(13, thinglass);
		beastmasterkit.setItem(14, thinglass);
		beastmasterkit.setItem(15, thinglass);
		beastmasterkit.setItem(16, thinglass);
		beastmasterkit.setItem(17, thinglass);
		beastmasterkit.setItem(18, thinglass);
		beastmasterkit.setItem(19, thinglass);
		beastmasterkit.setItem(20, thinglass);
		beastmasterkit.setItem(21, beastmasterdesc);
		beastmasterkit.setItem(22, thinglass);
		beastmasterkit.setItem(23, beastmasterstrat);
		beastmasterkit.setItem(24, thinglass);
		beastmasterkit.setItem(25, beastmasterabilities);
		beastmasterkit.setItem(26, thinglass);
		beastmasterkit.setItem(27, thinglass);
		beastmasterkit.setItem(28, thinglass);
		beastmasterkit.setItem(29, thinglass);
		beastmasterkit.setItem(30, thinglass);
		beastmasterkit.setItem(31, thinglass);
		beastmasterkit.setItem(32, thinglass);
		beastmasterkit.setItem(33, thinglass);
		beastmasterkit.setItem(34, thinglass);
		beastmasterkit.setItem(35, thinglass);
		beastmasterkit.setItem(36, signkit);
		beastmasterkit.setItem(37, thinglass);
		beastmasterkit.setItem(38, thinglass);
		beastmasterkit.setItem(39, thinglass);
		beastmasterkit.setItem(40, thinglass);
		beastmasterkit.setItem(41, thinglass);
		beastmasterkit.setItem(42, thinglass);
		beastmasterkit.setItem(43, thinglass);
		beastmasterkit.setItem(44, playkit);
		beastmasterkit.setItem(45, beastmastericon);
		beastmasterkit.setItem(46, beastmastericon2);
		beastmasterkit.setItem(47, thinglass);
		beastmasterkit.setItem(48, thinglass);
		beastmasterkit.setItem(49, thinglass);
		beastmasterkit.setItem(50, thinglass);
		beastmasterkit.setItem(51, thinglass);
		beastmasterkit.setItem(52, thinglass);
		beastmasterkit.setItem(53, thinglass);
		berserkerkit = Bukkit.createInventory(null, 54, "§fLe kit Berserker");
		berserkerkit.setItem(0, leftcarpet);
		berserkerkit.setItem(1, thinglass);
		berserkerkit.setItem(2, thinglass);
		berserkerkit.setItem(3, thinglass);
		berserkerkit.setItem(4, powder);
		berserkerkit.setItem(5, thinglass);
		berserkerkit.setItem(6, thinglass);
		berserkerkit.setItem(7, thinglass);
		berserkerkit.setItem(8, rightcarpet);
		berserkerkit.setItem(9, thinglass);
		berserkerkit.setItem(10, thinglass);
		berserkerkit.setItem(11, thinglass);
		berserkerkit.setItem(12, thinglass);
		berserkerkit.setItem(13, thinglass);
		berserkerkit.setItem(14, thinglass);
		berserkerkit.setItem(15, thinglass);
		berserkerkit.setItem(16, thinglass);
		berserkerkit.setItem(17, thinglass);
		berserkerkit.setItem(18, thinglass);
		berserkerkit.setItem(19, thinglass);
		berserkerkit.setItem(20, thinglass);
		berserkerkit.setItem(21, berserkerdesc);
		berserkerkit.setItem(22, thinglass);
		berserkerkit.setItem(23, berserkerstrat);
		berserkerkit.setItem(24, thinglass);
		berserkerkit.setItem(25, berserkerabilities);
		berserkerkit.setItem(26, thinglass);
		berserkerkit.setItem(27, thinglass);
		berserkerkit.setItem(28, thinglass);
		berserkerkit.setItem(29, thinglass);
		berserkerkit.setItem(30, thinglass);
		berserkerkit.setItem(31, thinglass);
		berserkerkit.setItem(32, thinglass);
		berserkerkit.setItem(33, thinglass);
		berserkerkit.setItem(34, thinglass);
		berserkerkit.setItem(35, thinglass);
		berserkerkit.setItem(36, signkit);
		berserkerkit.setItem(37, thinglass);
		berserkerkit.setItem(38, thinglass);
		berserkerkit.setItem(39, thinglass);
		berserkerkit.setItem(40, thinglass);
		berserkerkit.setItem(41, thinglass);
		berserkerkit.setItem(42, thinglass);
		berserkerkit.setItem(43, thinglass);
		berserkerkit.setItem(44, playkit);
		berserkerkit.setItem(45, thinglass);
		berserkerkit.setItem(46, thinglass);
		berserkerkit.setItem(47, thinglass);
		berserkerkit.setItem(48, thinglass);
		berserkerkit.setItem(49, thinglass);
		berserkerkit.setItem(50, thinglass);
		berserkerkit.setItem(51, thinglass);
		berserkerkit.setItem(52, thinglass);
		berserkerkit.setItem(53, thinglass);
		camelkit = Bukkit.createInventory(null, 54, "§fLe kit camel");
		camelkit.setItem(0, leftcarpet);
		camelkit.setItem(1, thinglass);
		camelkit.setItem(2, thinglass);
		camelkit.setItem(3, thinglass);
		camelkit.setItem(4, powder);
		camelkit.setItem(5, thinglass);
		camelkit.setItem(6, thinglass);
		camelkit.setItem(7, thinglass);
		camelkit.setItem(8, rightcarpet);
		camelkit.setItem(9, thinglass);
		camelkit.setItem(10, thinglass);
		camelkit.setItem(11, thinglass);
		camelkit.setItem(12, thinglass);
		camelkit.setItem(13, thinglass);
		camelkit.setItem(14, thinglass);
		camelkit.setItem(15, thinglass);
		camelkit.setItem(16, thinglass);
		camelkit.setItem(17, thinglass);
		camelkit.setItem(18, thinglass);
		camelkit.setItem(19, thinglass);
		camelkit.setItem(20, thinglass);
		camelkit.setItem(21, cameldesc);
		camelkit.setItem(22, thinglass);
		camelkit.setItem(23, camelstrat);
		camelkit.setItem(24, thinglass);
		camelkit.setItem(25, camelabilities);
		camelkit.setItem(26, thinglass);
		camelkit.setItem(27, thinglass);
		camelkit.setItem(28, thinglass);
		camelkit.setItem(29, thinglass);
		camelkit.setItem(30, thinglass);
		camelkit.setItem(31, thinglass);
		camelkit.setItem(32, thinglass);
		camelkit.setItem(33, thinglass);
		camelkit.setItem(34, thinglass);
		camelkit.setItem(35, thinglass);
		camelkit.setItem(36, signkit);
		camelkit.setItem(37, thinglass);
		camelkit.setItem(38, thinglass);
		camelkit.setItem(39, thinglass);
		camelkit.setItem(40, thinglass);
		camelkit.setItem(41, thinglass);
		camelkit.setItem(42, thinglass);
		camelkit.setItem(43, thinglass);
		camelkit.setItem(44, playkit);
		camelkit.setItem(45, thinglass);
		camelkit.setItem(46, thinglass);
		camelkit.setItem(47, thinglass);
		camelkit.setItem(48, thinglass);
		camelkit.setItem(49, thinglass);
		camelkit.setItem(50, thinglass);
		camelkit.setItem(51, thinglass);
		camelkit.setItem(52, thinglass);
		camelkit.setItem(53, thinglass);
		boxerkit = Bukkit.createInventory(null, 54, "§fLe kit boxer");
		boxerkit.setItem(0, leftcarpet);
		boxerkit.setItem(1, thinglass);
		boxerkit.setItem(2, thinglass);
		boxerkit.setItem(3, thinglass);
		boxerkit.setItem(4, powder);
		boxerkit.setItem(5, thinglass);
		boxerkit.setItem(6, thinglass);
		boxerkit.setItem(7, thinglass);
		boxerkit.setItem(8, rightcarpet);
		boxerkit.setItem(9, thinglass);
		boxerkit.setItem(10, thinglass);
		boxerkit.setItem(11, thinglass);
		boxerkit.setItem(12, thinglass);
		boxerkit.setItem(13, thinglass);
		boxerkit.setItem(14, thinglass);
		boxerkit.setItem(15, thinglass);
		boxerkit.setItem(16, thinglass);
		boxerkit.setItem(17, thinglass);
		boxerkit.setItem(18, thinglass);
		boxerkit.setItem(19, thinglass);
		boxerkit.setItem(20, thinglass);
		boxerkit.setItem(21, boxerdesc);
		boxerkit.setItem(22, thinglass);
		boxerkit.setItem(23, boxerstrat);
		boxerkit.setItem(24, thinglass);
		boxerkit.setItem(25, boxerabilities);
		boxerkit.setItem(26, thinglass);
		boxerkit.setItem(27, thinglass);
		boxerkit.setItem(28, thinglass);
		boxerkit.setItem(29, thinglass);
		boxerkit.setItem(30, thinglass);
		boxerkit.setItem(31, thinglass);
		boxerkit.setItem(32, thinglass);
		boxerkit.setItem(33, thinglass);
		boxerkit.setItem(34, thinglass);
		boxerkit.setItem(35, thinglass);
		boxerkit.setItem(36, signkit);
		boxerkit.setItem(37, thinglass);
		boxerkit.setItem(38, thinglass);
		boxerkit.setItem(39, thinglass);
		boxerkit.setItem(40, thinglass);
		boxerkit.setItem(41, thinglass);
		boxerkit.setItem(42, thinglass);
		boxerkit.setItem(43, thinglass);
		boxerkit.setItem(44, playkit);
		boxerkit.setItem(45, thinglass);
		boxerkit.setItem(46, thinglass);
		boxerkit.setItem(47, thinglass);
		boxerkit.setItem(48, thinglass);
		boxerkit.setItem(49, thinglass);
		boxerkit.setItem(50, thinglass);
		boxerkit.setItem(51, thinglass);
		boxerkit.setItem(52, thinglass);
		boxerkit.setItem(53, thinglass);
		cannibalkit = Bukkit.createInventory(null, 54, "§fLe kit cannibal");
		cannibalkit.setItem(0, leftcarpet);
		cannibalkit.setItem(1, thinglass);
		cannibalkit.setItem(2, thinglass);
		cannibalkit.setItem(3, thinglass);
		cannibalkit.setItem(4, powder);
		cannibalkit.setItem(5, thinglass);
		cannibalkit.setItem(6, thinglass);
		cannibalkit.setItem(7, thinglass);
		cannibalkit.setItem(8, rightcarpet);
		cannibalkit.setItem(9, thinglass);
		cannibalkit.setItem(10, thinglass);
		cannibalkit.setItem(11, thinglass);
		cannibalkit.setItem(12, thinglass);
		cannibalkit.setItem(13, thinglass);
		cannibalkit.setItem(14, thinglass);
		cannibalkit.setItem(15, thinglass);
		cannibalkit.setItem(16, thinglass);
		cannibalkit.setItem(17, thinglass);
		cannibalkit.setItem(18, thinglass);
		cannibalkit.setItem(19, thinglass);
		cannibalkit.setItem(20, thinglass);
		cannibalkit.setItem(21, cannibaldesc);
		cannibalkit.setItem(22, thinglass);
		cannibalkit.setItem(23, cannibalstrat);
		cannibalkit.setItem(24, thinglass);
		cannibalkit.setItem(25, cannibalabilities);
		cannibalkit.setItem(26, thinglass);
		cannibalkit.setItem(27, thinglass);
		cannibalkit.setItem(28, thinglass);
		cannibalkit.setItem(29, thinglass);
		cannibalkit.setItem(30, thinglass);
		cannibalkit.setItem(31, thinglass);
		cannibalkit.setItem(32, thinglass);
		cannibalkit.setItem(33, thinglass);
		cannibalkit.setItem(34, thinglass);
		cannibalkit.setItem(35, thinglass);
		cannibalkit.setItem(36, signkit);
		cannibalkit.setItem(37, thinglass);
		cannibalkit.setItem(38, thinglass);
		cannibalkit.setItem(39, thinglass);
		cannibalkit.setItem(40, thinglass);
		cannibalkit.setItem(41, thinglass);
		cannibalkit.setItem(42, thinglass);
		cannibalkit.setItem(43, thinglass);
		cannibalkit.setItem(44, playkit);
		cannibalkit.setItem(45, thinglass);
		cannibalkit.setItem(46, thinglass);
		cannibalkit.setItem(47, thinglass);
		cannibalkit.setItem(48, thinglass);
		cannibalkit.setItem(49, thinglass);
		cannibalkit.setItem(50, thinglass);
		cannibalkit.setItem(51, thinglass);
		cannibalkit.setItem(52, thinglass);
		cannibalkit.setItem(53, thinglass);
		chameleonkit = Bukkit.createInventory(null, 54, "§fLe kit chameleon");
		chameleonkit.setItem(0, leftcarpet);
		chameleonkit.setItem(1, thinglass);
		chameleonkit.setItem(2, thinglass);
		chameleonkit.setItem(3, thinglass);
		chameleonkit.setItem(4, powder);
		chameleonkit.setItem(5, thinglass);
		chameleonkit.setItem(6, thinglass);
		chameleonkit.setItem(7, thinglass);
		chameleonkit.setItem(8, rightcarpet);
		chameleonkit.setItem(9, thinglass);
		chameleonkit.setItem(10, thinglass);
		chameleonkit.setItem(11, thinglass);
		chameleonkit.setItem(12, thinglass);
		chameleonkit.setItem(13, thinglass);
		chameleonkit.setItem(14, thinglass);
		chameleonkit.setItem(15, thinglass);
		chameleonkit.setItem(16, thinglass);
		chameleonkit.setItem(17, thinglass);
		chameleonkit.setItem(18, thinglass);
		chameleonkit.setItem(19, thinglass);
		chameleonkit.setItem(20, thinglass);
		chameleonkit.setItem(21, chameleondesc);
		chameleonkit.setItem(22, thinglass);
		chameleonkit.setItem(23, chameleonstrat);
		chameleonkit.setItem(24, thinglass);
		chameleonkit.setItem(25, chameleonabilities);
		chameleonkit.setItem(26, thinglass);
		chameleonkit.setItem(27, thinglass);
		chameleonkit.setItem(28, thinglass);
		chameleonkit.setItem(29, thinglass);
		chameleonkit.setItem(30, thinglass);
		chameleonkit.setItem(31, thinglass);
		chameleonkit.setItem(32, thinglass);
		chameleonkit.setItem(33, thinglass);
		chameleonkit.setItem(34, thinglass);
		chameleonkit.setItem(35, thinglass);
		chameleonkit.setItem(36, signkit);
		chameleonkit.setItem(37, thinglass);
		chameleonkit.setItem(38, thinglass);
		chameleonkit.setItem(39, thinglass);
		chameleonkit.setItem(40, thinglass);
		chameleonkit.setItem(41, thinglass);
		chameleonkit.setItem(42, thinglass);
		chameleonkit.setItem(43, thinglass);
		chameleonkit.setItem(44, playkit);
		chameleonkit.setItem(45, chameleonicon2);
		chameleonkit.setItem(46, thinglass);
		chameleonkit.setItem(47, thinglass);
		chameleonkit.setItem(48, thinglass);
		chameleonkit.setItem(49, thinglass);
		chameleonkit.setItem(50, thinglass);
		chameleonkit.setItem(51, thinglass);
		chameleonkit.setItem(52, thinglass);
		chameleonkit.setItem(53, thinglass);
		chemistkit = Bukkit.createInventory(null, 54, "§fLe kit chemist");
		chemistkit.setItem(0, leftcarpet);
		chemistkit.setItem(1, thinglass);
		chemistkit.setItem(2, thinglass);
		chemistkit.setItem(3, thinglass);
		chemistkit.setItem(4, powder);
		chemistkit.setItem(5, thinglass);
		chemistkit.setItem(6, thinglass);
		chemistkit.setItem(7, thinglass);
		chemistkit.setItem(8, rightcarpet);
		chemistkit.setItem(9, thinglass);
		chemistkit.setItem(10, thinglass);
		chemistkit.setItem(11, thinglass);
		chemistkit.setItem(12, thinglass);
		chemistkit.setItem(13, thinglass);
		chemistkit.setItem(14, thinglass);
		chemistkit.setItem(15, thinglass);
		chemistkit.setItem(16, thinglass);
		chemistkit.setItem(17, thinglass);
		chemistkit.setItem(18, thinglass);
		chemistkit.setItem(19, thinglass);
		chemistkit.setItem(20, thinglass);
		chemistkit.setItem(21, chemistdesc);
		chemistkit.setItem(22, thinglass);
		chemistkit.setItem(23, chemiststrat);
		chemistkit.setItem(24, thinglass);
		chemistkit.setItem(25, chemistabilities);
		chemistkit.setItem(26, thinglass);
		chemistkit.setItem(27, thinglass);
		chemistkit.setItem(28, thinglass);
		chemistkit.setItem(29, thinglass);
		chemistkit.setItem(30, thinglass);
		chemistkit.setItem(31, thinglass);
		chemistkit.setItem(32, thinglass);
		chemistkit.setItem(33, thinglass);
		chemistkit.setItem(34, thinglass);
		chemistkit.setItem(35, thinglass);
		chemistkit.setItem(36, signkit);
		chemistkit.setItem(37, thinglass);
		chemistkit.setItem(38, thinglass);
		chemistkit.setItem(39, thinglass);
		chemistkit.setItem(40, thinglass);
		chemistkit.setItem(41, thinglass);
		chemistkit.setItem(42, thinglass);
		chemistkit.setItem(43, thinglass);
		chemistkit.setItem(44, playkit);
		chemistkit.setItem(45, chemisticon);
		chemistkit.setItem(46, chemisticon2);
		chemistkit.setItem(47, chemisticon3);
		chemistkit.setItem(48, thinglass);
		chemistkit.setItem(49, thinglass);
		chemistkit.setItem(50, thinglass);
		chemistkit.setItem(51, thinglass);
		chemistkit.setItem(52, thinglass);
		chemistkit.setItem(53, thinglass);
		cookiemonsterkit = Bukkit.createInventory(null, 54,
				"§fLe kit cookiemonster");
		cookiemonsterkit.setItem(0, leftcarpet);
		cookiemonsterkit.setItem(1, thinglass);
		cookiemonsterkit.setItem(2, thinglass);
		cookiemonsterkit.setItem(3, thinglass);
		cookiemonsterkit.setItem(4, powder);
		cookiemonsterkit.setItem(5, thinglass);
		cookiemonsterkit.setItem(6, thinglass);
		cookiemonsterkit.setItem(7, thinglass);
		cookiemonsterkit.setItem(8, rightcarpet);
		cookiemonsterkit.setItem(9, thinglass);
		cookiemonsterkit.setItem(10, thinglass);
		cookiemonsterkit.setItem(11, thinglass);
		cookiemonsterkit.setItem(12, thinglass);
		cookiemonsterkit.setItem(13, thinglass);
		cookiemonsterkit.setItem(14, thinglass);
		cookiemonsterkit.setItem(15, thinglass);
		cookiemonsterkit.setItem(16, thinglass);
		cookiemonsterkit.setItem(17, thinglass);
		cookiemonsterkit.setItem(18, thinglass);
		cookiemonsterkit.setItem(19, thinglass);
		cookiemonsterkit.setItem(20, thinglass);
		cookiemonsterkit.setItem(21, cookiemonsterdesc);
		cookiemonsterkit.setItem(22, thinglass);
		cookiemonsterkit.setItem(23, cookiemonsterstrat);
		cookiemonsterkit.setItem(24, thinglass);
		cookiemonsterkit.setItem(25, cookiemonsterabilities);
		cookiemonsterkit.setItem(26, thinglass);
		cookiemonsterkit.setItem(27, thinglass);
		cookiemonsterkit.setItem(28, thinglass);
		cookiemonsterkit.setItem(29, thinglass);
		cookiemonsterkit.setItem(30, thinglass);
		cookiemonsterkit.setItem(31, thinglass);
		cookiemonsterkit.setItem(32, thinglass);
		cookiemonsterkit.setItem(33, thinglass);
		cookiemonsterkit.setItem(34, thinglass);
		cookiemonsterkit.setItem(35, thinglass);
		cookiemonsterkit.setItem(36, signkit);
		cookiemonsterkit.setItem(37, thinglass);
		cookiemonsterkit.setItem(38, thinglass);
		cookiemonsterkit.setItem(39, thinglass);
		cookiemonsterkit.setItem(40, thinglass);
		cookiemonsterkit.setItem(41, thinglass);
		cookiemonsterkit.setItem(42, thinglass);
		cookiemonsterkit.setItem(43, thinglass);
		cookiemonsterkit.setItem(44, playkit);
		cookiemonsterkit.setItem(45, thinglass);
		cookiemonsterkit.setItem(46, thinglass);
		cookiemonsterkit.setItem(47, thinglass);
		cookiemonsterkit.setItem(48, thinglass);
		cookiemonsterkit.setItem(49, thinglass);
		cookiemonsterkit.setItem(50, thinglass);
		cookiemonsterkit.setItem(51, thinglass);
		cookiemonsterkit.setItem(52, thinglass);
		cookiemonsterkit.setItem(53, thinglass);
		cultivatorkit = Bukkit.createInventory(null, 54, "§fLe kit cultivator");
		cultivatorkit.setItem(0, leftcarpet);
		cultivatorkit.setItem(1, thinglass);
		cultivatorkit.setItem(2, thinglass);
		cultivatorkit.setItem(3, thinglass);
		cultivatorkit.setItem(4, powder);
		cultivatorkit.setItem(5, thinglass);
		cultivatorkit.setItem(6, thinglass);
		cultivatorkit.setItem(7, thinglass);
		cultivatorkit.setItem(8, rightcarpet);
		cultivatorkit.setItem(9, thinglass);
		cultivatorkit.setItem(10, thinglass);
		cultivatorkit.setItem(11, thinglass);
		cultivatorkit.setItem(12, thinglass);
		cultivatorkit.setItem(13, thinglass);
		cultivatorkit.setItem(14, thinglass);
		cultivatorkit.setItem(15, thinglass);
		cultivatorkit.setItem(16, thinglass);
		cultivatorkit.setItem(17, thinglass);
		cultivatorkit.setItem(18, thinglass);
		cultivatorkit.setItem(19, thinglass);
		cultivatorkit.setItem(20, thinglass);
		cultivatorkit.setItem(21, cultivatordesc);
		cultivatorkit.setItem(22, thinglass);
		cultivatorkit.setItem(23, cultivatorstrat);
		cultivatorkit.setItem(24, thinglass);
		cultivatorkit.setItem(25, cultivatorabilities);
		cultivatorkit.setItem(26, thinglass);
		cultivatorkit.setItem(27, thinglass);
		cultivatorkit.setItem(28, thinglass);
		cultivatorkit.setItem(29, thinglass);
		cultivatorkit.setItem(30, thinglass);
		cultivatorkit.setItem(31, thinglass);
		cultivatorkit.setItem(32, thinglass);
		cultivatorkit.setItem(33, thinglass);
		cultivatorkit.setItem(34, thinglass);
		cultivatorkit.setItem(35, thinglass);
		cultivatorkit.setItem(36, signkit);
		cultivatorkit.setItem(37, thinglass);
		cultivatorkit.setItem(38, thinglass);
		cultivatorkit.setItem(39, thinglass);
		cultivatorkit.setItem(40, thinglass);
		cultivatorkit.setItem(41, thinglass);
		cultivatorkit.setItem(42, thinglass);
		cultivatorkit.setItem(43, thinglass);
		cultivatorkit.setItem(44, playkit);
		cultivatorkit.setItem(45, thinglass);
		cultivatorkit.setItem(46, thinglass);
		cultivatorkit.setItem(47, thinglass);
		cultivatorkit.setItem(48, thinglass);
		cultivatorkit.setItem(49, thinglass);
		cultivatorkit.setItem(50, thinglass);
		cultivatorkit.setItem(51, thinglass);
		cultivatorkit.setItem(52, thinglass);
		cultivatorkit.setItem(53, thinglass);
		demomankit = Bukkit.createInventory(null, 54, "§fLe kit demoman");
		demomankit.setItem(0, leftcarpet);
		demomankit.setItem(1, thinglass);
		demomankit.setItem(2, thinglass);
		demomankit.setItem(3, thinglass);
		demomankit.setItem(4, powder);
		demomankit.setItem(5, thinglass);
		demomankit.setItem(6, thinglass);
		demomankit.setItem(7, thinglass);
		demomankit.setItem(8, rightcarpet);
		demomankit.setItem(9, thinglass);
		demomankit.setItem(10, thinglass);
		demomankit.setItem(11, thinglass);
		demomankit.setItem(12, thinglass);
		demomankit.setItem(13, thinglass);
		demomankit.setItem(14, thinglass);
		demomankit.setItem(15, thinglass);
		demomankit.setItem(16, thinglass);
		demomankit.setItem(17, thinglass);
		demomankit.setItem(18, thinglass);
		demomankit.setItem(19, thinglass);
		demomankit.setItem(20, thinglass);
		demomankit.setItem(21, demomandesc);
		demomankit.setItem(22, thinglass);
		demomankit.setItem(23, demomanstrat);
		demomankit.setItem(24, thinglass);
		demomankit.setItem(25, demomanabilities);
		demomankit.setItem(26, thinglass);
		demomankit.setItem(27, thinglass);
		demomankit.setItem(28, thinglass);
		demomankit.setItem(29, thinglass);
		demomankit.setItem(30, thinglass);
		demomankit.setItem(31, thinglass);
		demomankit.setItem(32, thinglass);
		demomankit.setItem(33, thinglass);
		demomankit.setItem(34, thinglass);
		demomankit.setItem(35, thinglass);
		demomankit.setItem(36, signkit);
		demomankit.setItem(37, thinglass);
		demomankit.setItem(38, thinglass);
		demomankit.setItem(39, thinglass);
		demomankit.setItem(40, thinglass);
		demomankit.setItem(41, thinglass);
		demomankit.setItem(42, thinglass);
		demomankit.setItem(43, thinglass);
		demomankit.setItem(44, playkit);
		demomankit.setItem(45, demoman);
		demomankit.setItem(46, demoman2);
		demomankit.setItem(47, thinglass);
		demomankit.setItem(48, thinglass);
		demomankit.setItem(49, thinglass);
		demomankit.setItem(50, thinglass);
		demomankit.setItem(51, thinglass);
		demomankit.setItem(52, thinglass);
		demomankit.setItem(53, thinglass);
		diggerkit = Bukkit.createInventory(null, 54, "§fLe kit digger");
		diggerkit.setItem(0, leftcarpet);
		diggerkit.setItem(1, thinglass);
		diggerkit.setItem(2, thinglass);
		diggerkit.setItem(3, thinglass);
		diggerkit.setItem(4, powder);
		diggerkit.setItem(5, thinglass);
		diggerkit.setItem(6, thinglass);
		diggerkit.setItem(7, thinglass);
		diggerkit.setItem(8, rightcarpet);
		diggerkit.setItem(9, thinglass);
		diggerkit.setItem(10, thinglass);
		diggerkit.setItem(11, thinglass);
		diggerkit.setItem(12, thinglass);
		diggerkit.setItem(13, thinglass);
		diggerkit.setItem(14, thinglass);
		diggerkit.setItem(15, thinglass);
		diggerkit.setItem(16, thinglass);
		diggerkit.setItem(17, thinglass);
		diggerkit.setItem(18, thinglass);
		diggerkit.setItem(19, thinglass);
		diggerkit.setItem(20, thinglass);
		diggerkit.setItem(21, diggerdesc);
		diggerkit.setItem(22, thinglass);
		diggerkit.setItem(23, diggerstrat);
		diggerkit.setItem(24, thinglass);
		diggerkit.setItem(25, diggerabilities);
		diggerkit.setItem(26, thinglass);
		diggerkit.setItem(27, thinglass);
		diggerkit.setItem(28, thinglass);
		diggerkit.setItem(29, thinglass);
		diggerkit.setItem(30, thinglass);
		diggerkit.setItem(31, thinglass);
		diggerkit.setItem(32, thinglass);
		diggerkit.setItem(33, thinglass);
		diggerkit.setItem(34, thinglass);
		diggerkit.setItem(35, thinglass);
		diggerkit.setItem(36, signkit);
		diggerkit.setItem(37, thinglass);
		diggerkit.setItem(38, thinglass);
		diggerkit.setItem(39, thinglass);
		diggerkit.setItem(40, thinglass);
		diggerkit.setItem(41, thinglass);
		diggerkit.setItem(42, thinglass);
		diggerkit.setItem(43, thinglass);
		diggerkit.setItem(44, playkit);
		diggerkit.setItem(45, digger);
		diggerkit.setItem(46, thinglass);
		diggerkit.setItem(47, thinglass);
		diggerkit.setItem(48, thinglass);
		diggerkit.setItem(49, thinglass);
		diggerkit.setItem(50, thinglass);
		diggerkit.setItem(51, thinglass);
		diggerkit.setItem(52, thinglass);
		diggerkit.setItem(53, thinglass);
		doctorkit = Bukkit.createInventory(null, 54, "§fLe kit doctor");
		doctorkit.setItem(0, leftcarpet);
		doctorkit.setItem(1, thinglass);
		doctorkit.setItem(2, thinglass);
		doctorkit.setItem(3, thinglass);
		doctorkit.setItem(4, powder);
		doctorkit.setItem(5, thinglass);
		doctorkit.setItem(6, thinglass);
		doctorkit.setItem(7, thinglass);
		doctorkit.setItem(8, rightcarpet);
		doctorkit.setItem(9, thinglass);
		doctorkit.setItem(10, thinglass);
		doctorkit.setItem(11, thinglass);
		doctorkit.setItem(12, thinglass);
		doctorkit.setItem(13, thinglass);
		doctorkit.setItem(14, thinglass);
		doctorkit.setItem(15, thinglass);
		doctorkit.setItem(16, thinglass);
		doctorkit.setItem(17, thinglass);
		doctorkit.setItem(18, thinglass);
		doctorkit.setItem(19, thinglass);
		doctorkit.setItem(20, thinglass);
		doctorkit.setItem(21, doctordesc);
		doctorkit.setItem(22, thinglass);
		doctorkit.setItem(23, doctorstrat);
		doctorkit.setItem(24, thinglass);
		doctorkit.setItem(25, doctorabilities);
		doctorkit.setItem(26, thinglass);
		doctorkit.setItem(27, thinglass);
		doctorkit.setItem(28, thinglass);
		doctorkit.setItem(29, thinglass);
		doctorkit.setItem(30, thinglass);
		doctorkit.setItem(31, thinglass);
		doctorkit.setItem(32, thinglass);
		doctorkit.setItem(33, thinglass);
		doctorkit.setItem(34, thinglass);
		doctorkit.setItem(35, thinglass);
		doctorkit.setItem(36, signkit);
		doctorkit.setItem(37, thinglass);
		doctorkit.setItem(38, thinglass);
		doctorkit.setItem(39, thinglass);
		doctorkit.setItem(40, thinglass);
		doctorkit.setItem(41, thinglass);
		doctorkit.setItem(42, thinglass);
		doctorkit.setItem(43, thinglass);
		doctorkit.setItem(44, playkit);
		doctorkit.setItem(45, doctor);
		doctorkit.setItem(46, thinglass);
		doctorkit.setItem(47, thinglass);
		doctorkit.setItem(48, thinglass);
		doctorkit.setItem(49, thinglass);
		doctorkit.setItem(50, thinglass);
		doctorkit.setItem(51, thinglass);
		doctorkit.setItem(52, thinglass);
		doctorkit.setItem(53, thinglass);
		dwarfkit = Bukkit.createInventory(null, 54, "§fLe kit dwarf");
		dwarfkit.setItem(0, leftcarpet);
		dwarfkit.setItem(1, thinglass);
		dwarfkit.setItem(2, thinglass);
		dwarfkit.setItem(3, thinglass);
		dwarfkit.setItem(4, powder);
		dwarfkit.setItem(5, thinglass);
		dwarfkit.setItem(6, thinglass);
		dwarfkit.setItem(7, thinglass);
		dwarfkit.setItem(8, rightcarpet);
		dwarfkit.setItem(9, thinglass);
		dwarfkit.setItem(10, thinglass);
		dwarfkit.setItem(11, thinglass);
		dwarfkit.setItem(12, thinglass);
		dwarfkit.setItem(13, thinglass);
		dwarfkit.setItem(14, thinglass);
		dwarfkit.setItem(15, thinglass);
		dwarfkit.setItem(16, thinglass);
		dwarfkit.setItem(17, thinglass);
		dwarfkit.setItem(18, thinglass);
		dwarfkit.setItem(19, thinglass);
		dwarfkit.setItem(20, thinglass);
		dwarfkit.setItem(21, dwarfdesc);
		dwarfkit.setItem(22, thinglass);
		dwarfkit.setItem(23, dwarfstrat);
		dwarfkit.setItem(24, thinglass);
		dwarfkit.setItem(25, dwarfabilities);
		dwarfkit.setItem(26, thinglass);
		dwarfkit.setItem(27, thinglass);
		dwarfkit.setItem(28, thinglass);
		dwarfkit.setItem(29, thinglass);
		dwarfkit.setItem(30, thinglass);
		dwarfkit.setItem(31, thinglass);
		dwarfkit.setItem(32, thinglass);
		dwarfkit.setItem(33, thinglass);
		dwarfkit.setItem(34, thinglass);
		dwarfkit.setItem(35, thinglass);
		dwarfkit.setItem(36, signkit);
		dwarfkit.setItem(37, thinglass);
		dwarfkit.setItem(38, thinglass);
		dwarfkit.setItem(39, thinglass);
		dwarfkit.setItem(40, thinglass);
		dwarfkit.setItem(41, thinglass);
		dwarfkit.setItem(42, thinglass);
		dwarfkit.setItem(43, thinglass);
		dwarfkit.setItem(44, playkit);
		dwarfkit.setItem(45, thinglass);
		dwarfkit.setItem(46, thinglass);
		dwarfkit.setItem(47, thinglass);
		dwarfkit.setItem(48, thinglass);
		dwarfkit.setItem(49, thinglass);
		dwarfkit.setItem(50, thinglass);
		dwarfkit.setItem(51, thinglass);
		dwarfkit.setItem(52, thinglass);
		dwarfkit.setItem(53, thinglass);
		endermagekit = Bukkit.createInventory(null, 54, "§fLe kit endermage");
		endermagekit.setItem(0, leftcarpet);
		endermagekit.setItem(1, thinglass);
		endermagekit.setItem(2, thinglass);
		endermagekit.setItem(3, thinglass);
		endermagekit.setItem(4, powder);
		endermagekit.setItem(5, thinglass);
		endermagekit.setItem(6, thinglass);
		endermagekit.setItem(7, thinglass);
		endermagekit.setItem(8, rightcarpet);
		endermagekit.setItem(9, thinglass);
		endermagekit.setItem(10, thinglass);
		endermagekit.setItem(11, thinglass);
		endermagekit.setItem(12, thinglass);
		endermagekit.setItem(13, thinglass);
		endermagekit.setItem(14, thinglass);
		endermagekit.setItem(15, thinglass);
		endermagekit.setItem(16, thinglass);
		endermagekit.setItem(17, thinglass);
		endermagekit.setItem(18, thinglass);
		endermagekit.setItem(19, thinglass);
		endermagekit.setItem(20, thinglass);
		endermagekit.setItem(21, endermagedesc);
		endermagekit.setItem(22, thinglass);
		endermagekit.setItem(23, endermagestrat);
		endermagekit.setItem(24, thinglass);
		endermagekit.setItem(25, endermageabilities);
		endermagekit.setItem(26, thinglass);
		endermagekit.setItem(27, thinglass);
		endermagekit.setItem(28, thinglass);
		endermagekit.setItem(29, thinglass);
		endermagekit.setItem(30, thinglass);
		endermagekit.setItem(31, thinglass);
		endermagekit.setItem(32, thinglass);
		endermagekit.setItem(33, thinglass);
		endermagekit.setItem(34, thinglass);
		endermagekit.setItem(35, thinglass);
		endermagekit.setItem(36, signkit);
		endermagekit.setItem(37, thinglass);
		endermagekit.setItem(38, thinglass);
		endermagekit.setItem(39, thinglass);
		endermagekit.setItem(40, thinglass);
		endermagekit.setItem(41, thinglass);
		endermagekit.setItem(42, thinglass);
		endermagekit.setItem(43, thinglass);
		endermagekit.setItem(44, playkit);
		endermagekit.setItem(45, endermage);
		endermagekit.setItem(46, thinglass);
		endermagekit.setItem(47, thinglass);
		endermagekit.setItem(48, thinglass);
		endermagekit.setItem(49, thinglass);
		endermagekit.setItem(50, thinglass);
		endermagekit.setItem(51, thinglass);
		endermagekit.setItem(52, thinglass);
		endermagekit.setItem(53, thinglass);
		firemankit = Bukkit.createInventory(null, 54, "§fLe kit fireman");
		firemankit.setItem(0, leftcarpet);
		firemankit.setItem(1, thinglass);
		firemankit.setItem(2, thinglass);
		firemankit.setItem(3, thinglass);
		firemankit.setItem(4, powder);
		firemankit.setItem(5, thinglass);
		firemankit.setItem(6, thinglass);
		firemankit.setItem(7, thinglass);
		firemankit.setItem(8, rightcarpet);
		firemankit.setItem(9, thinglass);
		firemankit.setItem(10, thinglass);
		firemankit.setItem(11, thinglass);
		firemankit.setItem(12, thinglass);
		firemankit.setItem(13, thinglass);
		firemankit.setItem(14, thinglass);
		firemankit.setItem(15, thinglass);
		firemankit.setItem(16, thinglass);
		firemankit.setItem(17, thinglass);
		firemankit.setItem(18, thinglass);
		firemankit.setItem(19, thinglass);
		firemankit.setItem(20, thinglass);
		firemankit.setItem(21, firemandesc);
		firemankit.setItem(22, thinglass);
		firemankit.setItem(23, firemanstrat);
		firemankit.setItem(24, thinglass);
		firemankit.setItem(25, firemanabilities);
		firemankit.setItem(26, thinglass);
		firemankit.setItem(27, thinglass);
		firemankit.setItem(28, thinglass);
		firemankit.setItem(29, thinglass);
		firemankit.setItem(30, thinglass);
		firemankit.setItem(31, thinglass);
		firemankit.setItem(32, thinglass);
		firemankit.setItem(33, thinglass);
		firemankit.setItem(34, thinglass);
		firemankit.setItem(35, thinglass);
		firemankit.setItem(36, signkit);
		firemankit.setItem(37, thinglass);
		firemankit.setItem(38, thinglass);
		firemankit.setItem(39, thinglass);
		firemankit.setItem(40, thinglass);
		firemankit.setItem(41, thinglass);
		firemankit.setItem(42, thinglass);
		firemankit.setItem(43, thinglass);
		firemankit.setItem(44, playkit);
		firemankit.setItem(45, fireman);
		firemankit.setItem(46, thinglass);
		firemankit.setItem(47, thinglass);
		firemankit.setItem(48, thinglass);
		firemankit.setItem(49, thinglass);
		firemankit.setItem(50, thinglass);
		firemankit.setItem(51, thinglass);
		firemankit.setItem(52, thinglass);
		firemankit.setItem(53, thinglass);
		fishermankit = Bukkit.createInventory(null, 54, "§fLe kit fisherman");
		fishermankit.setItem(0, leftcarpet);
		fishermankit.setItem(1, thinglass);
		fishermankit.setItem(2, thinglass);
		fishermankit.setItem(3, thinglass);
		fishermankit.setItem(4, powder);
		fishermankit.setItem(5, thinglass);
		fishermankit.setItem(6, thinglass);
		fishermankit.setItem(7, thinglass);
		fishermankit.setItem(8, rightcarpet);
		fishermankit.setItem(9, thinglass);
		fishermankit.setItem(10, thinglass);
		fishermankit.setItem(11, thinglass);
		fishermankit.setItem(12, thinglass);
		fishermankit.setItem(13, thinglass);
		fishermankit.setItem(14, thinglass);
		fishermankit.setItem(15, thinglass);
		fishermankit.setItem(16, thinglass);
		fishermankit.setItem(17, thinglass);
		fishermankit.setItem(18, thinglass);
		fishermankit.setItem(19, thinglass);
		fishermankit.setItem(20, thinglass);
		fishermankit.setItem(21, fishermandesc);
		fishermankit.setItem(22, thinglass);
		fishermankit.setItem(23, fishermanstrat);
		fishermankit.setItem(24, thinglass);
		fishermankit.setItem(25, fishermanabilities);
		fishermankit.setItem(26, thinglass);
		fishermankit.setItem(27, thinglass);
		fishermankit.setItem(28, thinglass);
		fishermankit.setItem(29, thinglass);
		fishermankit.setItem(30, thinglass);
		fishermankit.setItem(31, thinglass);
		fishermankit.setItem(32, thinglass);
		fishermankit.setItem(33, thinglass);
		fishermankit.setItem(34, thinglass);
		fishermankit.setItem(35, thinglass);
		fishermankit.setItem(36, signkit);
		fishermankit.setItem(37, thinglass);
		fishermankit.setItem(38, thinglass);
		fishermankit.setItem(39, thinglass);
		fishermankit.setItem(40, thinglass);
		fishermankit.setItem(41, thinglass);
		fishermankit.setItem(42, thinglass);
		fishermankit.setItem(43, thinglass);
		fishermankit.setItem(44, playkit);
		fishermankit.setItem(45, fisherman);
		fishermankit.setItem(46, thinglass);
		fishermankit.setItem(47, thinglass);
		fishermankit.setItem(48, thinglass);
		fishermankit.setItem(49, thinglass);
		fishermankit.setItem(50, thinglass);
		fishermankit.setItem(51, thinglass);
		fishermankit.setItem(52, thinglass);
		fishermankit.setItem(53, thinglass);
		flashkit = Bukkit.createInventory(null, 54, "§fLe kit flash");
		flashkit.setItem(0, leftcarpet);
		flashkit.setItem(1, thinglass);
		flashkit.setItem(2, thinglass);
		flashkit.setItem(3, thinglass);
		flashkit.setItem(4, powder);
		flashkit.setItem(5, thinglass);
		flashkit.setItem(6, thinglass);
		flashkit.setItem(7, thinglass);
		flashkit.setItem(8, rightcarpet);
		flashkit.setItem(9, thinglass);
		flashkit.setItem(10, thinglass);
		flashkit.setItem(11, thinglass);
		flashkit.setItem(12, thinglass);
		flashkit.setItem(13, thinglass);
		flashkit.setItem(14, thinglass);
		flashkit.setItem(15, thinglass);
		flashkit.setItem(16, thinglass);
		flashkit.setItem(17, thinglass);
		flashkit.setItem(18, thinglass);
		flashkit.setItem(19, thinglass);
		flashkit.setItem(20, thinglass);
		flashkit.setItem(21, flashdesc);
		flashkit.setItem(22, thinglass);
		flashkit.setItem(23, flashstrat);
		flashkit.setItem(24, thinglass);
		flashkit.setItem(25, flashabilities);
		flashkit.setItem(26, thinglass);
		flashkit.setItem(27, thinglass);
		flashkit.setItem(28, thinglass);
		flashkit.setItem(29, thinglass);
		flashkit.setItem(30, thinglass);
		flashkit.setItem(31, thinglass);
		flashkit.setItem(32, thinglass);
		flashkit.setItem(33, thinglass);
		flashkit.setItem(34, thinglass);
		flashkit.setItem(35, thinglass);
		flashkit.setItem(36, signkit);
		flashkit.setItem(37, thinglass);
		flashkit.setItem(38, thinglass);
		flashkit.setItem(39, thinglass);
		flashkit.setItem(40, thinglass);
		flashkit.setItem(41, thinglass);
		flashkit.setItem(42, thinglass);
		flashkit.setItem(43, thinglass);
		flashkit.setItem(44, playkit);
		flashkit.setItem(45, flash);
		flashkit.setItem(46, thinglass);
		flashkit.setItem(47, thinglass);
		flashkit.setItem(48, thinglass);
		flashkit.setItem(49, thinglass);
		flashkit.setItem(50, thinglass);
		flashkit.setItem(51, thinglass);
		flashkit.setItem(52, thinglass);
		flashkit.setItem(53, thinglass);
		forgerkit = Bukkit.createInventory(null, 54, "§fLe kit forger");
		forgerkit.setItem(0, leftcarpet);
		forgerkit.setItem(1, thinglass);
		forgerkit.setItem(2, thinglass);
		forgerkit.setItem(3, thinglass);
		forgerkit.setItem(4, powder);
		forgerkit.setItem(5, thinglass);
		forgerkit.setItem(6, thinglass);
		forgerkit.setItem(7, thinglass);
		forgerkit.setItem(8, rightcarpet);
		forgerkit.setItem(9, thinglass);
		forgerkit.setItem(10, thinglass);
		forgerkit.setItem(11, thinglass);
		forgerkit.setItem(12, thinglass);
		forgerkit.setItem(13, thinglass);
		forgerkit.setItem(14, thinglass);
		forgerkit.setItem(15, thinglass);
		forgerkit.setItem(16, thinglass);
		forgerkit.setItem(17, thinglass);
		forgerkit.setItem(18, thinglass);
		forgerkit.setItem(19, thinglass);
		forgerkit.setItem(20, thinglass);
		forgerkit.setItem(21, forgerdesc);
		forgerkit.setItem(22, thinglass);
		forgerkit.setItem(23, forgerstrat);
		forgerkit.setItem(24, thinglass);
		forgerkit.setItem(25, forgerabilities);
		forgerkit.setItem(26, thinglass);
		forgerkit.setItem(27, thinglass);
		forgerkit.setItem(28, thinglass);
		forgerkit.setItem(29, thinglass);
		forgerkit.setItem(30, thinglass);
		forgerkit.setItem(31, thinglass);
		forgerkit.setItem(32, thinglass);
		forgerkit.setItem(33, thinglass);
		forgerkit.setItem(34, thinglass);
		forgerkit.setItem(35, thinglass);
		forgerkit.setItem(36, signkit);
		forgerkit.setItem(37, thinglass);
		forgerkit.setItem(38, thinglass);
		forgerkit.setItem(39, thinglass);
		forgerkit.setItem(40, thinglass);
		forgerkit.setItem(41, thinglass);
		forgerkit.setItem(42, thinglass);
		forgerkit.setItem(43, thinglass);
		forgerkit.setItem(44, playkit);
		forgerkit.setItem(45, forger);
		forgerkit.setItem(46, thinglass);
		forgerkit.setItem(47, thinglass);
		forgerkit.setItem(48, thinglass);
		forgerkit.setItem(49, thinglass);
		forgerkit.setItem(50, thinglass);
		forgerkit.setItem(51, thinglass);
		forgerkit.setItem(52, thinglass);
		forgerkit.setItem(53, thinglass);
		frostykit = Bukkit.createInventory(null, 54, "§fLe kit frosty");
		frostykit.setItem(0, leftcarpet);
		frostykit.setItem(1, thinglass);
		frostykit.setItem(2, thinglass);
		frostykit.setItem(3, thinglass);
		frostykit.setItem(4, powder);
		frostykit.setItem(5, thinglass);
		frostykit.setItem(6, thinglass);
		frostykit.setItem(7, thinglass);
		frostykit.setItem(8, rightcarpet);
		frostykit.setItem(9, thinglass);
		frostykit.setItem(10, thinglass);
		frostykit.setItem(11, thinglass);
		frostykit.setItem(12, thinglass);
		frostykit.setItem(13, thinglass);
		frostykit.setItem(14, thinglass);
		frostykit.setItem(15, thinglass);
		frostykit.setItem(16, thinglass);
		frostykit.setItem(17, thinglass);
		frostykit.setItem(18, thinglass);
		frostykit.setItem(19, thinglass);
		frostykit.setItem(20, thinglass);
		frostykit.setItem(21, frostydesc);
		frostykit.setItem(22, thinglass);
		frostykit.setItem(23, frostystrat);
		frostykit.setItem(24, thinglass);
		frostykit.setItem(25, frostyabilities);
		frostykit.setItem(26, thinglass);
		frostykit.setItem(27, thinglass);
		frostykit.setItem(28, thinglass);
		frostykit.setItem(29, thinglass);
		frostykit.setItem(30, thinglass);
		frostykit.setItem(31, thinglass);
		frostykit.setItem(32, thinglass);
		frostykit.setItem(33, thinglass);
		frostykit.setItem(34, thinglass);
		frostykit.setItem(35, thinglass);
		frostykit.setItem(36, signkit);
		frostykit.setItem(37, thinglass);
		frostykit.setItem(38, thinglass);
		frostykit.setItem(39, thinglass);
		frostykit.setItem(40, thinglass);
		frostykit.setItem(41, thinglass);
		frostykit.setItem(42, thinglass);
		frostykit.setItem(43, thinglass);
		frostykit.setItem(44, playkit);
		frostykit.setItem(45, frosty);
		frostykit.setItem(46, thinglass);
		frostykit.setItem(47, thinglass);
		frostykit.setItem(48, thinglass);
		frostykit.setItem(49, thinglass);
		frostykit.setItem(50, thinglass);
		frostykit.setItem(51, thinglass);
		frostykit.setItem(52, thinglass);
		frostykit.setItem(53, thinglass);
		gamblerkit = Bukkit.createInventory(null, 54, "§fLe kit gambler");
		gamblerkit.setItem(0, leftcarpet);
		gamblerkit.setItem(1, thinglass);
		gamblerkit.setItem(2, thinglass);
		gamblerkit.setItem(3, thinglass);
		gamblerkit.setItem(4, powder);
		gamblerkit.setItem(5, thinglass);
		gamblerkit.setItem(6, thinglass);
		gamblerkit.setItem(7, thinglass);
		gamblerkit.setItem(8, rightcarpet);
		gamblerkit.setItem(9, thinglass);
		gamblerkit.setItem(10, thinglass);
		gamblerkit.setItem(11, thinglass);
		gamblerkit.setItem(12, thinglass);
		gamblerkit.setItem(13, thinglass);
		gamblerkit.setItem(14, thinglass);
		gamblerkit.setItem(15, thinglass);
		gamblerkit.setItem(16, thinglass);
		gamblerkit.setItem(17, thinglass);
		gamblerkit.setItem(18, thinglass);
		gamblerkit.setItem(19, thinglass);
		gamblerkit.setItem(20, thinglass);
		gamblerkit.setItem(21, gamblerdesc);
		gamblerkit.setItem(22, thinglass);
		gamblerkit.setItem(23, gamblerstrat);
		gamblerkit.setItem(24, thinglass);
		gamblerkit.setItem(25, gamblerabilities);
		gamblerkit.setItem(26, thinglass);
		gamblerkit.setItem(27, thinglass);
		gamblerkit.setItem(28, thinglass);
		gamblerkit.setItem(29, thinglass);
		gamblerkit.setItem(30, thinglass);
		gamblerkit.setItem(31, thinglass);
		gamblerkit.setItem(32, thinglass);
		gamblerkit.setItem(33, thinglass);
		gamblerkit.setItem(34, thinglass);
		gamblerkit.setItem(35, thinglass);
		gamblerkit.setItem(36, signkit);
		gamblerkit.setItem(37, thinglass);
		gamblerkit.setItem(38, thinglass);
		gamblerkit.setItem(39, thinglass);
		gamblerkit.setItem(40, thinglass);
		gamblerkit.setItem(41, thinglass);
		gamblerkit.setItem(42, thinglass);
		gamblerkit.setItem(43, thinglass);
		gamblerkit.setItem(44, playkit);
		gamblerkit.setItem(45, gambler);
		gamblerkit.setItem(46, thinglass);
		gamblerkit.setItem(47, thinglass);
		gamblerkit.setItem(48, thinglass);
		gamblerkit.setItem(49, thinglass);
		gamblerkit.setItem(50, thinglass);
		gamblerkit.setItem(51, thinglass);
		gamblerkit.setItem(52, thinglass);
		gamblerkit.setItem(53, thinglass);
		grandpakit = Bukkit.createInventory(null, 54, "§fLe kit grandpa");
		grandpakit.setItem(0, leftcarpet);
		grandpakit.setItem(1, thinglass);
		grandpakit.setItem(2, thinglass);
		grandpakit.setItem(3, thinglass);
		grandpakit.setItem(4, powder);
		grandpakit.setItem(5, thinglass);
		grandpakit.setItem(6, thinglass);
		grandpakit.setItem(7, thinglass);
		grandpakit.setItem(8, rightcarpet);
		grandpakit.setItem(9, thinglass);
		grandpakit.setItem(10, thinglass);
		grandpakit.setItem(11, thinglass);
		grandpakit.setItem(12, thinglass);
		grandpakit.setItem(13, thinglass);
		grandpakit.setItem(14, thinglass);
		grandpakit.setItem(15, thinglass);
		grandpakit.setItem(16, thinglass);
		grandpakit.setItem(17, thinglass);
		grandpakit.setItem(18, thinglass);
		grandpakit.setItem(19, thinglass);
		grandpakit.setItem(20, thinglass);
		grandpakit.setItem(21, grandpadesc);
		grandpakit.setItem(22, thinglass);
		grandpakit.setItem(23, grandpastrat);
		grandpakit.setItem(24, thinglass);
		grandpakit.setItem(25, grandpaabilities);
		grandpakit.setItem(26, thinglass);
		grandpakit.setItem(27, thinglass);
		grandpakit.setItem(28, thinglass);
		grandpakit.setItem(29, thinglass);
		grandpakit.setItem(30, thinglass);
		grandpakit.setItem(31, thinglass);
		grandpakit.setItem(32, thinglass);
		grandpakit.setItem(33, thinglass);
		grandpakit.setItem(34, thinglass);
		grandpakit.setItem(35, thinglass);
		grandpakit.setItem(36, signkit);
		grandpakit.setItem(37, thinglass);
		grandpakit.setItem(38, thinglass);
		grandpakit.setItem(39, thinglass);
		grandpakit.setItem(40, thinglass);
		grandpakit.setItem(41, thinglass);
		grandpakit.setItem(42, thinglass);
		grandpakit.setItem(43, thinglass);
		grandpakit.setItem(44, playkit);
		grandpakit.setItem(45, grandpa);
		grandpakit.setItem(46, thinglass);
		grandpakit.setItem(47, thinglass);
		grandpakit.setItem(48, thinglass);
		grandpakit.setItem(49, thinglass);
		grandpakit.setItem(50, thinglass);
		grandpakit.setItem(51, thinglass);
		grandpakit.setItem(52, thinglass);
		grandpakit.setItem(53, thinglass);
		gravediggerkit = Bukkit.createInventory(null, 54,
				"§fLe kit gravedigger");
		gravediggerkit.setItem(0, leftcarpet);
		gravediggerkit.setItem(1, thinglass);
		gravediggerkit.setItem(2, thinglass);
		gravediggerkit.setItem(3, thinglass);
		gravediggerkit.setItem(4, powder);
		gravediggerkit.setItem(5, thinglass);
		gravediggerkit.setItem(6, thinglass);
		gravediggerkit.setItem(7, thinglass);
		gravediggerkit.setItem(8, rightcarpet);
		gravediggerkit.setItem(9, thinglass);
		gravediggerkit.setItem(10, thinglass);
		gravediggerkit.setItem(11, thinglass);
		gravediggerkit.setItem(12, thinglass);
		gravediggerkit.setItem(13, thinglass);
		gravediggerkit.setItem(14, thinglass);
		gravediggerkit.setItem(15, thinglass);
		gravediggerkit.setItem(16, thinglass);
		gravediggerkit.setItem(17, thinglass);
		gravediggerkit.setItem(18, thinglass);
		gravediggerkit.setItem(19, thinglass);
		gravediggerkit.setItem(20, thinglass);
		gravediggerkit.setItem(21, gravediggerdesc);
		gravediggerkit.setItem(22, thinglass);
		gravediggerkit.setItem(23, gravediggerstrat);
		gravediggerkit.setItem(24, thinglass);
		gravediggerkit.setItem(25, gravediggerabilities);
		gravediggerkit.setItem(26, thinglass);
		gravediggerkit.setItem(27, thinglass);
		gravediggerkit.setItem(28, thinglass);
		gravediggerkit.setItem(29, thinglass);
		gravediggerkit.setItem(30, thinglass);
		gravediggerkit.setItem(31, thinglass);
		gravediggerkit.setItem(32, thinglass);
		gravediggerkit.setItem(33, thinglass);
		gravediggerkit.setItem(34, thinglass);
		gravediggerkit.setItem(35, thinglass);
		gravediggerkit.setItem(36, signkit);
		gravediggerkit.setItem(37, thinglass);
		gravediggerkit.setItem(38, thinglass);
		gravediggerkit.setItem(39, thinglass);
		gravediggerkit.setItem(40, thinglass);
		gravediggerkit.setItem(41, thinglass);
		gravediggerkit.setItem(42, thinglass);
		gravediggerkit.setItem(43, thinglass);
		gravediggerkit.setItem(44, playkit);
		gravediggerkit.setItem(45, thinglass);
		gravediggerkit.setItem(46, thinglass);
		gravediggerkit.setItem(47, thinglass);
		gravediggerkit.setItem(48, thinglass);
		gravediggerkit.setItem(49, thinglass);
		gravediggerkit.setItem(50, thinglass);
		gravediggerkit.setItem(51, thinglass);
		gravediggerkit.setItem(52, thinglass);
		gravediggerkit.setItem(53, thinglass);
		hermitkit = Bukkit.createInventory(null, 54, "§fLe kit hermit");
		hermitkit.setItem(0, leftcarpet);
		hermitkit.setItem(1, thinglass);
		hermitkit.setItem(2, thinglass);
		hermitkit.setItem(3, thinglass);
		hermitkit.setItem(4, powder);
		hermitkit.setItem(5, thinglass);
		hermitkit.setItem(6, thinglass);
		hermitkit.setItem(7, thinglass);
		hermitkit.setItem(8, rightcarpet);
		hermitkit.setItem(9, thinglass);
		hermitkit.setItem(10, thinglass);
		hermitkit.setItem(11, thinglass);
		hermitkit.setItem(12, thinglass);
		hermitkit.setItem(13, thinglass);
		hermitkit.setItem(14, thinglass);
		hermitkit.setItem(15, thinglass);
		hermitkit.setItem(16, thinglass);
		hermitkit.setItem(17, thinglass);
		hermitkit.setItem(18, thinglass);
		hermitkit.setItem(19, thinglass);
		hermitkit.setItem(20, thinglass);
		hermitkit.setItem(21, hermitdesc);
		hermitkit.setItem(22, thinglass);
		hermitkit.setItem(23, hermitstrat);
		hermitkit.setItem(24, thinglass);
		hermitkit.setItem(25, hermitabilities);
		hermitkit.setItem(26, thinglass);
		hermitkit.setItem(27, thinglass);
		hermitkit.setItem(28, thinglass);
		hermitkit.setItem(29, thinglass);
		hermitkit.setItem(30, thinglass);
		hermitkit.setItem(31, thinglass);
		hermitkit.setItem(32, thinglass);
		hermitkit.setItem(33, thinglass);
		hermitkit.setItem(34, thinglass);
		hermitkit.setItem(35, thinglass);
		hermitkit.setItem(36, signkit);
		hermitkit.setItem(37, thinglass);
		hermitkit.setItem(38, thinglass);
		hermitkit.setItem(39, thinglass);
		hermitkit.setItem(40, thinglass);
		hermitkit.setItem(41, thinglass);
		hermitkit.setItem(42, thinglass);
		hermitkit.setItem(43, thinglass);
		hermitkit.setItem(44, playkit);
		hermitkit.setItem(45, thinglass);
		hermitkit.setItem(46, thinglass);
		hermitkit.setItem(47, thinglass);
		hermitkit.setItem(48, thinglass);
		hermitkit.setItem(49, thinglass);
		hermitkit.setItem(50, thinglass);
		hermitkit.setItem(51, thinglass);
		hermitkit.setItem(52, thinglass);
		hermitkit.setItem(53, thinglass);
		hulkkit = Bukkit.createInventory(null, 54, "§fLe kit hulk");
		hulkkit.setItem(0, leftcarpet);
		hulkkit.setItem(1, thinglass);
		hulkkit.setItem(2, thinglass);
		hulkkit.setItem(3, thinglass);
		hulkkit.setItem(4, powder);
		hulkkit.setItem(5, thinglass);
		hulkkit.setItem(6, thinglass);
		hulkkit.setItem(7, thinglass);
		hulkkit.setItem(8, rightcarpet);
		hulkkit.setItem(9, thinglass);
		hulkkit.setItem(10, thinglass);
		hulkkit.setItem(11, thinglass);
		hulkkit.setItem(12, thinglass);
		hulkkit.setItem(13, thinglass);
		hulkkit.setItem(14, thinglass);
		hulkkit.setItem(15, thinglass);
		hulkkit.setItem(16, thinglass);
		hulkkit.setItem(17, thinglass);
		hulkkit.setItem(18, thinglass);
		hulkkit.setItem(19, thinglass);
		hulkkit.setItem(20, thinglass);
		hulkkit.setItem(21, hulkdesc);
		hulkkit.setItem(22, thinglass);
		hulkkit.setItem(23, hulkstrat);
		hulkkit.setItem(24, thinglass);
		hulkkit.setItem(25, hulkabilities);
		hulkkit.setItem(26, thinglass);
		hulkkit.setItem(27, thinglass);
		hulkkit.setItem(28, thinglass);
		hulkkit.setItem(29, thinglass);
		hulkkit.setItem(30, thinglass);
		hulkkit.setItem(31, thinglass);
		hulkkit.setItem(32, thinglass);
		hulkkit.setItem(33, thinglass);
		hulkkit.setItem(34, thinglass);
		hulkkit.setItem(35, thinglass);
		hulkkit.setItem(36, signkit);
		hulkkit.setItem(37, thinglass);
		hulkkit.setItem(38, thinglass);
		hulkkit.setItem(39, thinglass);
		hulkkit.setItem(40, thinglass);
		hulkkit.setItem(41, thinglass);
		hulkkit.setItem(42, thinglass);
		hulkkit.setItem(43, thinglass);
		hulkkit.setItem(44, playkit);
		hulkkit.setItem(45, thinglass);
		hulkkit.setItem(46, thinglass);
		hulkkit.setItem(47, thinglass);
		hulkkit.setItem(48, thinglass);
		hulkkit.setItem(49, thinglass);
		hulkkit.setItem(50, thinglass);
		hulkkit.setItem(51, thinglass);
		hulkkit.setItem(52, thinglass);
		hulkkit.setItem(53, thinglass);
		hunterkit = Bukkit.createInventory(null, 54, "§fLe kit hunter");
		hunterkit.setItem(0, leftcarpet);
		hunterkit.setItem(1, thinglass);
		hunterkit.setItem(2, thinglass);
		hunterkit.setItem(3, thinglass);
		hunterkit.setItem(4, powder);
		hunterkit.setItem(5, thinglass);
		hunterkit.setItem(6, thinglass);
		hunterkit.setItem(7, thinglass);
		hunterkit.setItem(8, rightcarpet);
		hunterkit.setItem(9, thinglass);
		hunterkit.setItem(10, thinglass);
		hunterkit.setItem(11, thinglass);
		hunterkit.setItem(12, thinglass);
		hunterkit.setItem(13, thinglass);
		hunterkit.setItem(14, thinglass);
		hunterkit.setItem(15, thinglass);
		hunterkit.setItem(16, thinglass);
		hunterkit.setItem(17, thinglass);
		hunterkit.setItem(18, thinglass);
		hunterkit.setItem(19, thinglass);
		hunterkit.setItem(20, thinglass);
		hunterkit.setItem(21, hunterdesc);
		hunterkit.setItem(22, thinglass);
		hunterkit.setItem(23, hunterstrat);
		hunterkit.setItem(24, thinglass);
		hunterkit.setItem(25, hunterabilities);
		hunterkit.setItem(26, thinglass);
		hunterkit.setItem(27, thinglass);
		hunterkit.setItem(28, thinglass);
		hunterkit.setItem(29, thinglass);
		hunterkit.setItem(30, thinglass);
		hunterkit.setItem(31, thinglass);
		hunterkit.setItem(32, thinglass);
		hunterkit.setItem(33, thinglass);
		hunterkit.setItem(34, thinglass);
		hunterkit.setItem(35, thinglass);
		hunterkit.setItem(36, signkit);
		hunterkit.setItem(37, thinglass);
		hunterkit.setItem(38, thinglass);
		hunterkit.setItem(39, thinglass);
		hunterkit.setItem(40, thinglass);
		hunterkit.setItem(41, thinglass);
		hunterkit.setItem(42, thinglass);
		hunterkit.setItem(43, thinglass);
		hunterkit.setItem(44, playkit);
		hunterkit.setItem(45, thinglass);
		hunterkit.setItem(46, thinglass);
		hunterkit.setItem(47, thinglass);
		hunterkit.setItem(48, thinglass);
		hunterkit.setItem(49, thinglass);
		hunterkit.setItem(50, thinglass);
		hunterkit.setItem(51, thinglass);
		hunterkit.setItem(52, thinglass);
		hunterkit.setItem(53, thinglass);
		jackhammerkit = Bukkit.createInventory(null, 54, "§fLe kit jackhammer");
		jackhammerkit.setItem(0, leftcarpet);
		jackhammerkit.setItem(1, thinglass);
		jackhammerkit.setItem(2, thinglass);
		jackhammerkit.setItem(3, thinglass);
		jackhammerkit.setItem(4, powder);
		jackhammerkit.setItem(5, thinglass);
		jackhammerkit.setItem(6, thinglass);
		jackhammerkit.setItem(7, thinglass);
		jackhammerkit.setItem(8, rightcarpet);
		jackhammerkit.setItem(9, thinglass);
		jackhammerkit.setItem(10, thinglass);
		jackhammerkit.setItem(11, thinglass);
		jackhammerkit.setItem(12, thinglass);
		jackhammerkit.setItem(13, thinglass);
		jackhammerkit.setItem(14, thinglass);
		jackhammerkit.setItem(15, thinglass);
		jackhammerkit.setItem(16, thinglass);
		jackhammerkit.setItem(17, thinglass);
		jackhammerkit.setItem(18, thinglass);
		jackhammerkit.setItem(19, thinglass);
		jackhammerkit.setItem(20, thinglass);
		jackhammerkit.setItem(21, jackhammerdesc);
		jackhammerkit.setItem(22, thinglass);
		jackhammerkit.setItem(23, jackhammerstrat);
		jackhammerkit.setItem(24, thinglass);
		jackhammerkit.setItem(25, jackhammerabilities);
		jackhammerkit.setItem(26, thinglass);
		jackhammerkit.setItem(27, thinglass);
		jackhammerkit.setItem(28, thinglass);
		jackhammerkit.setItem(29, thinglass);
		jackhammerkit.setItem(30, thinglass);
		jackhammerkit.setItem(31, thinglass);
		jackhammerkit.setItem(32, thinglass);
		jackhammerkit.setItem(33, thinglass);
		jackhammerkit.setItem(34, thinglass);
		jackhammerkit.setItem(35, thinglass);
		jackhammerkit.setItem(36, signkit);
		jackhammerkit.setItem(37, thinglass);
		jackhammerkit.setItem(38, thinglass);
		jackhammerkit.setItem(39, thinglass);
		jackhammerkit.setItem(40, thinglass);
		jackhammerkit.setItem(41, thinglass);
		jackhammerkit.setItem(42, thinglass);
		jackhammerkit.setItem(43, thinglass);
		jackhammerkit.setItem(44, playkit);
		jackhammerkit.setItem(45, jackhammer);
		jackhammerkit.setItem(46, thinglass);
		jackhammerkit.setItem(47, thinglass);
		jackhammerkit.setItem(48, thinglass);
		jackhammerkit.setItem(49, thinglass);
		jackhammerkit.setItem(50, thinglass);
		jackhammerkit.setItem(51, thinglass);
		jackhammerkit.setItem(52, thinglass);
		jackhammerkit.setItem(53, thinglass);
		jumperkit = Bukkit.createInventory(null, 54, "§fLe kit jumper");
		jumperkit.setItem(0, leftcarpet);
		jumperkit.setItem(1, thinglass);
		jumperkit.setItem(2, thinglass);
		jumperkit.setItem(3, thinglass);
		jumperkit.setItem(4, powder);
		jumperkit.setItem(5, thinglass);
		jumperkit.setItem(6, thinglass);
		jumperkit.setItem(7, thinglass);
		jumperkit.setItem(8, rightcarpet);
		jumperkit.setItem(9, thinglass);
		jumperkit.setItem(10, thinglass);
		jumperkit.setItem(11, thinglass);
		jumperkit.setItem(12, thinglass);
		jumperkit.setItem(13, thinglass);
		jumperkit.setItem(14, thinglass);
		jumperkit.setItem(15, thinglass);
		jumperkit.setItem(16, thinglass);
		jumperkit.setItem(17, thinglass);
		jumperkit.setItem(18, thinglass);
		jumperkit.setItem(19, thinglass);
		jumperkit.setItem(20, thinglass);
		jumperkit.setItem(21, jumperdesc);
		jumperkit.setItem(22, thinglass);
		jumperkit.setItem(23, jumperstrat);
		jumperkit.setItem(24, thinglass);
		jumperkit.setItem(25, jumperabilities);
		jumperkit.setItem(26, thinglass);
		jumperkit.setItem(27, thinglass);
		jumperkit.setItem(28, thinglass);
		jumperkit.setItem(29, thinglass);
		jumperkit.setItem(30, thinglass);
		jumperkit.setItem(31, thinglass);
		jumperkit.setItem(32, thinglass);
		jumperkit.setItem(33, thinglass);
		jumperkit.setItem(34, thinglass);
		jumperkit.setItem(35, thinglass);
		jumperkit.setItem(36, signkit);
		jumperkit.setItem(37, thinglass);
		jumperkit.setItem(38, thinglass);
		jumperkit.setItem(39, thinglass);
		jumperkit.setItem(40, thinglass);
		jumperkit.setItem(41, thinglass);
		jumperkit.setItem(42, thinglass);
		jumperkit.setItem(43, thinglass);
		jumperkit.setItem(44, playkit);
		jumperkit.setItem(45, jumper);
		jumperkit.setItem(46, thinglass);
		jumperkit.setItem(47, thinglass);
		jumperkit.setItem(48, thinglass);
		jumperkit.setItem(49, thinglass);
		jumperkit.setItem(50, thinglass);
		jumperkit.setItem(51, thinglass);
		jumperkit.setItem(52, thinglass);
		jumperkit.setItem(53, thinglass);
		kangarookit = Bukkit.createInventory(null, 54, "§fLe kit kangaroo");
		kangarookit.setItem(0, leftcarpet);
		kangarookit.setItem(1, thinglass);
		kangarookit.setItem(2, thinglass);
		kangarookit.setItem(3, thinglass);
		kangarookit.setItem(4, powder);
		kangarookit.setItem(5, thinglass);
		kangarookit.setItem(6, thinglass);
		kangarookit.setItem(7, thinglass);
		kangarookit.setItem(8, rightcarpet);
		kangarookit.setItem(9, thinglass);
		kangarookit.setItem(10, thinglass);
		kangarookit.setItem(11, thinglass);
		kangarookit.setItem(12, thinglass);
		kangarookit.setItem(13, thinglass);
		kangarookit.setItem(14, thinglass);
		kangarookit.setItem(15, thinglass);
		kangarookit.setItem(16, thinglass);
		kangarookit.setItem(17, thinglass);
		kangarookit.setItem(18, thinglass);
		kangarookit.setItem(19, thinglass);
		kangarookit.setItem(20, thinglass);
		kangarookit.setItem(21, kangaroodesc);
		kangarookit.setItem(22, thinglass);
		kangarookit.setItem(23, kangaroostrat);
		kangarookit.setItem(24, thinglass);
		kangarookit.setItem(25, kangarooabilities);
		kangarookit.setItem(26, thinglass);
		kangarookit.setItem(27, thinglass);
		kangarookit.setItem(28, thinglass);
		kangarookit.setItem(29, thinglass);
		kangarookit.setItem(30, thinglass);
		kangarookit.setItem(31, thinglass);
		kangarookit.setItem(32, thinglass);
		kangarookit.setItem(33, thinglass);
		kangarookit.setItem(34, thinglass);
		kangarookit.setItem(35, thinglass);
		kangarookit.setItem(36, signkit);
		kangarookit.setItem(37, thinglass);
		kangarookit.setItem(38, thinglass);
		kangarookit.setItem(39, thinglass);
		kangarookit.setItem(40, thinglass);
		kangarookit.setItem(41, thinglass);
		kangarookit.setItem(42, thinglass);
		kangarookit.setItem(43, thinglass);
		kangarookit.setItem(44, playkit);
		kangarookit.setItem(45, kangaroo);
		kangarookit.setItem(46, thinglass);
		kangarookit.setItem(47, thinglass);
		kangarookit.setItem(48, thinglass);
		kangarookit.setItem(49, thinglass);
		kangarookit.setItem(50, thinglass);
		kangarookit.setItem(51, thinglass);
		kangarookit.setItem(52, thinglass);
		kangarookit.setItem(53, thinglass);
		kayakit = Bukkit.createInventory(null, 54, "§fLe kit kaya");
		kayakit.setItem(0, leftcarpet);
		kayakit.setItem(1, thinglass);
		kayakit.setItem(2, thinglass);
		kayakit.setItem(3, thinglass);
		kayakit.setItem(4, powder);
		kayakit.setItem(5, thinglass);
		kayakit.setItem(6, thinglass);
		kayakit.setItem(7, thinglass);
		kayakit.setItem(8, rightcarpet);
		kayakit.setItem(9, thinglass);
		kayakit.setItem(10, thinglass);
		kayakit.setItem(11, thinglass);
		kayakit.setItem(12, thinglass);
		kayakit.setItem(13, thinglass);
		kayakit.setItem(14, thinglass);
		kayakit.setItem(15, thinglass);
		kayakit.setItem(16, thinglass);
		kayakit.setItem(17, thinglass);
		kayakit.setItem(18, thinglass);
		kayakit.setItem(19, thinglass);
		kayakit.setItem(20, thinglass);
		kayakit.setItem(21, kayadesc);
		kayakit.setItem(22, thinglass);
		kayakit.setItem(23, kayastrat);
		kayakit.setItem(24, thinglass);
		kayakit.setItem(25, kayaabilities);
		kayakit.setItem(26, thinglass);
		kayakit.setItem(27, thinglass);
		kayakit.setItem(28, thinglass);
		kayakit.setItem(29, thinglass);
		kayakit.setItem(30, thinglass);
		kayakit.setItem(31, thinglass);
		kayakit.setItem(32, thinglass);
		kayakit.setItem(33, thinglass);
		kayakit.setItem(34, thinglass);
		kayakit.setItem(35, thinglass);
		kayakit.setItem(36, signkit);
		kayakit.setItem(37, thinglass);
		kayakit.setItem(38, thinglass);
		kayakit.setItem(39, thinglass);
		kayakit.setItem(40, thinglass);
		kayakit.setItem(41, thinglass);
		kayakit.setItem(42, thinglass);
		kayakit.setItem(43, thinglass);
		kayakit.setItem(44, playkit);
		kayakit.setItem(45, kaya);
		kayakit.setItem(46, thinglass);
		kayakit.setItem(47, thinglass);
		kayakit.setItem(48, thinglass);
		kayakit.setItem(49, thinglass);
		kayakit.setItem(50, thinglass);
		kayakit.setItem(51, thinglass);
		kayakit.setItem(52, thinglass);
		kayakit.setItem(53, thinglass);
		launcherkit = Bukkit.createInventory(null, 54, "§fLe kit launcher");
		launcherkit.setItem(0, leftcarpet);
		launcherkit.setItem(1, thinglass);
		launcherkit.setItem(2, thinglass);
		launcherkit.setItem(3, thinglass);
		launcherkit.setItem(4, powder);
		launcherkit.setItem(5, thinglass);
		launcherkit.setItem(6, thinglass);
		launcherkit.setItem(7, thinglass);
		launcherkit.setItem(8, rightcarpet);
		launcherkit.setItem(9, thinglass);
		launcherkit.setItem(10, thinglass);
		launcherkit.setItem(11, thinglass);
		launcherkit.setItem(12, thinglass);
		launcherkit.setItem(13, thinglass);
		launcherkit.setItem(14, thinglass);
		launcherkit.setItem(15, thinglass);
		launcherkit.setItem(16, thinglass);
		launcherkit.setItem(17, thinglass);
		launcherkit.setItem(18, thinglass);
		launcherkit.setItem(19, thinglass);
		launcherkit.setItem(20, thinglass);
		launcherkit.setItem(21, launcherdesc);
		launcherkit.setItem(22, thinglass);
		launcherkit.setItem(23, launcherstrat);
		launcherkit.setItem(24, thinglass);
		launcherkit.setItem(25, launcherabilities);
		launcherkit.setItem(26, thinglass);
		launcherkit.setItem(27, thinglass);
		launcherkit.setItem(28, thinglass);
		launcherkit.setItem(29, thinglass);
		launcherkit.setItem(30, thinglass);
		launcherkit.setItem(31, thinglass);
		launcherkit.setItem(32, thinglass);
		launcherkit.setItem(33, thinglass);
		launcherkit.setItem(34, thinglass);
		launcherkit.setItem(35, thinglass);
		launcherkit.setItem(36, signkit);
		launcherkit.setItem(37, thinglass);
		launcherkit.setItem(38, thinglass);
		launcherkit.setItem(39, thinglass);
		launcherkit.setItem(40, thinglass);
		launcherkit.setItem(41, thinglass);
		launcherkit.setItem(42, thinglass);
		launcherkit.setItem(43, thinglass);
		launcherkit.setItem(44, playkit);
		launcherkit.setItem(45, launcher);
		launcherkit.setItem(46, thinglass);
		launcherkit.setItem(47, thinglass);
		launcherkit.setItem(48, thinglass);
		launcherkit.setItem(49, thinglass);
		launcherkit.setItem(50, thinglass);
		launcherkit.setItem(51, thinglass);
		launcherkit.setItem(52, thinglass);
		launcherkit.setItem(53, thinglass);
		levitatorkit = Bukkit.createInventory(null, 54, "§fLe kit levitator");
		levitatorkit.setItem(0, leftcarpet);
		levitatorkit.setItem(1, thinglass);
		levitatorkit.setItem(2, thinglass);
		levitatorkit.setItem(3, thinglass);
		levitatorkit.setItem(4, powder);
		levitatorkit.setItem(5, thinglass);
		levitatorkit.setItem(6, thinglass);
		levitatorkit.setItem(7, thinglass);
		levitatorkit.setItem(8, rightcarpet);
		levitatorkit.setItem(9, thinglass);
		levitatorkit.setItem(10, thinglass);
		levitatorkit.setItem(11, thinglass);
		levitatorkit.setItem(12, thinglass);
		levitatorkit.setItem(13, thinglass);
		levitatorkit.setItem(14, thinglass);
		levitatorkit.setItem(15, thinglass);
		levitatorkit.setItem(16, thinglass);
		levitatorkit.setItem(17, thinglass);
		levitatorkit.setItem(18, thinglass);
		levitatorkit.setItem(19, thinglass);
		levitatorkit.setItem(20, thinglass);
		levitatorkit.setItem(21, levitatordesc);
		levitatorkit.setItem(22, thinglass);
		levitatorkit.setItem(23, levitatorstrat);
		levitatorkit.setItem(24, thinglass);
		levitatorkit.setItem(25, levitatorabilities);
		levitatorkit.setItem(26, thinglass);
		levitatorkit.setItem(27, thinglass);
		levitatorkit.setItem(28, thinglass);
		levitatorkit.setItem(29, thinglass);
		levitatorkit.setItem(30, thinglass);
		levitatorkit.setItem(31, thinglass);
		levitatorkit.setItem(32, thinglass);
		levitatorkit.setItem(33, thinglass);
		levitatorkit.setItem(34, thinglass);
		levitatorkit.setItem(35, thinglass);
		levitatorkit.setItem(36, signkit);
		levitatorkit.setItem(37, thinglass);
		levitatorkit.setItem(38, thinglass);
		levitatorkit.setItem(39, thinglass);
		levitatorkit.setItem(40, thinglass);
		levitatorkit.setItem(41, thinglass);
		levitatorkit.setItem(42, thinglass);
		levitatorkit.setItem(43, thinglass);
		levitatorkit.setItem(44, playkit);
		levitatorkit.setItem(45, levitator);
		levitatorkit.setItem(46, thinglass);
		levitatorkit.setItem(47, thinglass);
		levitatorkit.setItem(48, thinglass);
		levitatorkit.setItem(49, thinglass);
		levitatorkit.setItem(50, thinglass);
		levitatorkit.setItem(51, thinglass);
		levitatorkit.setItem(52, thinglass);
		levitatorkit.setItem(53, thinglass);
		lumberjackkit = Bukkit.createInventory(null, 54, "§fLe kit lumberjack");
		lumberjackkit.setItem(0, leftcarpet);
		lumberjackkit.setItem(1, thinglass);
		lumberjackkit.setItem(2, thinglass);
		lumberjackkit.setItem(3, thinglass);
		lumberjackkit.setItem(4, powder);
		lumberjackkit.setItem(5, thinglass);
		lumberjackkit.setItem(6, thinglass);
		lumberjackkit.setItem(7, thinglass);
		lumberjackkit.setItem(8, rightcarpet);
		lumberjackkit.setItem(9, thinglass);
		lumberjackkit.setItem(10, thinglass);
		lumberjackkit.setItem(11, thinglass);
		lumberjackkit.setItem(12, thinglass);
		lumberjackkit.setItem(13, thinglass);
		lumberjackkit.setItem(14, thinglass);
		lumberjackkit.setItem(15, thinglass);
		lumberjackkit.setItem(16, thinglass);
		lumberjackkit.setItem(17, thinglass);
		lumberjackkit.setItem(18, thinglass);
		lumberjackkit.setItem(19, thinglass);
		lumberjackkit.setItem(20, thinglass);
		lumberjackkit.setItem(21, lumberjackdesc);
		lumberjackkit.setItem(22, thinglass);
		lumberjackkit.setItem(23, lumberjackstrat);
		lumberjackkit.setItem(24, thinglass);
		lumberjackkit.setItem(25, lumberjackabilities);
		lumberjackkit.setItem(26, thinglass);
		lumberjackkit.setItem(27, thinglass);
		lumberjackkit.setItem(28, thinglass);
		lumberjackkit.setItem(29, thinglass);
		lumberjackkit.setItem(30, thinglass);
		lumberjackkit.setItem(31, thinglass);
		lumberjackkit.setItem(32, thinglass);
		lumberjackkit.setItem(33, thinglass);
		lumberjackkit.setItem(34, thinglass);
		lumberjackkit.setItem(35, thinglass);
		lumberjackkit.setItem(36, signkit);
		lumberjackkit.setItem(37, thinglass);
		lumberjackkit.setItem(38, thinglass);
		lumberjackkit.setItem(39, thinglass);
		lumberjackkit.setItem(40, thinglass);
		lumberjackkit.setItem(41, thinglass);
		lumberjackkit.setItem(42, thinglass);
		lumberjackkit.setItem(43, thinglass);
		lumberjackkit.setItem(44, playkit);
		lumberjackkit.setItem(45, lumberjack);
		lumberjackkit.setItem(46, thinglass);
		lumberjackkit.setItem(47, thinglass);
		lumberjackkit.setItem(48, thinglass);
		lumberjackkit.setItem(49, thinglass);
		lumberjackkit.setItem(50, thinglass);
		lumberjackkit.setItem(51, thinglass);
		lumberjackkit.setItem(52, thinglass);
		lumberjackkit.setItem(53, thinglass);
		minerkit = Bukkit.createInventory(null, 54, "§fLe kit miner");
		minerkit.setItem(0, leftcarpet);
		minerkit.setItem(1, thinglass);
		minerkit.setItem(2, thinglass);
		minerkit.setItem(3, thinglass);
		minerkit.setItem(4, powder);
		minerkit.setItem(5, thinglass);
		minerkit.setItem(6, thinglass);
		minerkit.setItem(7, thinglass);
		minerkit.setItem(8, rightcarpet);
		minerkit.setItem(9, thinglass);
		minerkit.setItem(10, thinglass);
		minerkit.setItem(11, thinglass);
		minerkit.setItem(12, thinglass);
		minerkit.setItem(13, thinglass);
		minerkit.setItem(14, thinglass);
		minerkit.setItem(15, thinglass);
		minerkit.setItem(16, thinglass);
		minerkit.setItem(17, thinglass);
		minerkit.setItem(18, thinglass);
		minerkit.setItem(19, thinglass);
		minerkit.setItem(20, thinglass);
		minerkit.setItem(21, minerdesc);
		minerkit.setItem(22, thinglass);
		minerkit.setItem(23, minerstrat);
		minerkit.setItem(24, thinglass);
		minerkit.setItem(25, minerabilities);
		minerkit.setItem(26, thinglass);
		minerkit.setItem(27, thinglass);
		minerkit.setItem(28, thinglass);
		minerkit.setItem(29, thinglass);
		minerkit.setItem(30, thinglass);
		minerkit.setItem(31, thinglass);
		minerkit.setItem(32, thinglass);
		minerkit.setItem(33, thinglass);
		minerkit.setItem(34, thinglass);
		minerkit.setItem(35, thinglass);
		minerkit.setItem(36, signkit);
		minerkit.setItem(37, thinglass);
		minerkit.setItem(38, thinglass);
		minerkit.setItem(39, thinglass);
		minerkit.setItem(40, thinglass);
		minerkit.setItem(41, thinglass);
		minerkit.setItem(42, thinglass);
		minerkit.setItem(43, thinglass);
		minerkit.setItem(44, playkit);
		minerkit.setItem(45, miner);
		minerkit.setItem(46, thinglass);
		minerkit.setItem(47, thinglass);
		minerkit.setItem(48, thinglass);
		minerkit.setItem(49, thinglass);
		minerkit.setItem(50, thinglass);
		minerkit.setItem(51, thinglass);
		minerkit.setItem(52, thinglass);
		minerkit.setItem(53, thinglass);
		monsterkit = Bukkit.createInventory(null, 54, "§fLe kit monster");
		monsterkit.setItem(0, leftcarpet);
		monsterkit.setItem(1, thinglass);
		monsterkit.setItem(2, thinglass);
		monsterkit.setItem(3, thinglass);
		monsterkit.setItem(4, powder);
		monsterkit.setItem(5, thinglass);
		monsterkit.setItem(6, thinglass);
		monsterkit.setItem(7, thinglass);
		monsterkit.setItem(8, rightcarpet);
		monsterkit.setItem(9, thinglass);
		monsterkit.setItem(10, thinglass);
		monsterkit.setItem(11, thinglass);
		monsterkit.setItem(12, thinglass);
		monsterkit.setItem(13, thinglass);
		monsterkit.setItem(14, thinglass);
		monsterkit.setItem(15, thinglass);
		monsterkit.setItem(16, thinglass);
		monsterkit.setItem(17, thinglass);
		monsterkit.setItem(18, thinglass);
		monsterkit.setItem(19, thinglass);
		monsterkit.setItem(20, thinglass);
		monsterkit.setItem(21, monsterdesc);
		monsterkit.setItem(22, thinglass);
		monsterkit.setItem(23, monsterstrat);
		monsterkit.setItem(24, thinglass);
		monsterkit.setItem(25, monsterabilities);
		monsterkit.setItem(26, thinglass);
		monsterkit.setItem(27, thinglass);
		monsterkit.setItem(28, thinglass);
		monsterkit.setItem(29, thinglass);
		monsterkit.setItem(30, thinglass);
		monsterkit.setItem(31, thinglass);
		monsterkit.setItem(32, thinglass);
		monsterkit.setItem(33, thinglass);
		monsterkit.setItem(34, thinglass);
		monsterkit.setItem(35, thinglass);
		monsterkit.setItem(36, signkit);
		monsterkit.setItem(37, thinglass);
		monsterkit.setItem(38, thinglass);
		monsterkit.setItem(39, thinglass);
		monsterkit.setItem(40, thinglass);
		monsterkit.setItem(41, thinglass);
		monsterkit.setItem(42, thinglass);
		monsterkit.setItem(43, thinglass);
		monsterkit.setItem(44, playkit);
		monsterkit.setItem(45, thinglass);
		monsterkit.setItem(46, thinglass);
		monsterkit.setItem(47, thinglass);
		monsterkit.setItem(48, thinglass);
		monsterkit.setItem(49, thinglass);
		monsterkit.setItem(50, thinglass);
		monsterkit.setItem(51, thinglass);
		monsterkit.setItem(52, thinglass);
		monsterkit.setItem(53, thinglass);
		necrokit = Bukkit.createInventory(null, 54, "§fLe kit necro");
		necrokit.setItem(0, leftcarpet);
		necrokit.setItem(1, thinglass);
		necrokit.setItem(2, thinglass);
		necrokit.setItem(3, thinglass);
		necrokit.setItem(4, powder);
		necrokit.setItem(5, thinglass);
		necrokit.setItem(6, thinglass);
		necrokit.setItem(7, thinglass);
		necrokit.setItem(8, rightcarpet);
		necrokit.setItem(9, thinglass);
		necrokit.setItem(10, thinglass);
		necrokit.setItem(11, thinglass);
		necrokit.setItem(12, thinglass);
		necrokit.setItem(13, thinglass);
		necrokit.setItem(14, thinglass);
		necrokit.setItem(15, thinglass);
		necrokit.setItem(16, thinglass);
		necrokit.setItem(17, thinglass);
		necrokit.setItem(18, thinglass);
		necrokit.setItem(19, thinglass);
		necrokit.setItem(20, thinglass);
		necrokit.setItem(21, necrodesc);
		necrokit.setItem(22, thinglass);
		necrokit.setItem(23, necrostrat);
		necrokit.setItem(24, thinglass);
		necrokit.setItem(25, necroabilities);
		necrokit.setItem(26, thinglass);
		necrokit.setItem(27, thinglass);
		necrokit.setItem(28, thinglass);
		necrokit.setItem(29, thinglass);
		necrokit.setItem(30, thinglass);
		necrokit.setItem(31, thinglass);
		necrokit.setItem(32, thinglass);
		necrokit.setItem(33, thinglass);
		necrokit.setItem(34, thinglass);
		necrokit.setItem(35, thinglass);
		necrokit.setItem(36, signkit);
		necrokit.setItem(37, thinglass);
		necrokit.setItem(38, thinglass);
		necrokit.setItem(39, thinglass);
		necrokit.setItem(40, thinglass);
		necrokit.setItem(41, thinglass);
		necrokit.setItem(42, thinglass);
		necrokit.setItem(43, thinglass);
		necrokit.setItem(44, playkit);
		necrokit.setItem(45, thinglass);
		necrokit.setItem(46, thinglass);
		necrokit.setItem(47, thinglass);
		necrokit.setItem(48, thinglass);
		necrokit.setItem(49, thinglass);
		necrokit.setItem(50, thinglass);
		necrokit.setItem(51, thinglass);
		necrokit.setItem(52, thinglass);
		necrokit.setItem(53, thinglass);
		// TODO
	}

	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if ((e.getInventory().getName().equals(inv.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(anchorkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(archerkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(berserkerkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(beastmasterkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(boxerkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(camelkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(cannibalkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(chameleonkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(chemistkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(cookiemonsterkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(cultivatorkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(demomankit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(diggerkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(dwarfkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(endermagekit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(firemankit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(fishermankit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(flashkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}

		if ((e.getInventory().getName().equals(forgerkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(frostykit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(gamblerkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(grandpakit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(gravediggerkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(hermitkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(hulkkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(hunterkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(jackhammerkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(jumperkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(kangarookit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(kayakit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur"))
			e.setCancelled(true);
		if ((e.getInventory().getName().equals(launcherkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(levitatorkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(lumberjackkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(monsterkit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		if ((e.getInventory().getName().equals(necrokit.getName()))
				&& ChatColor.stripColor(
						p.getInventory().getItemInHand().getItemMeta()
								.getDisplayName()).equalsIgnoreCase(
						"Kit Sélécteur")) {
			e.setCancelled(true);
		}
		// INVENTAIRE
		if (e.getCurrentItem() == null)
			return;
		if (e.getCurrentItem().equals(rightcarpet)) {

			p.openInventory(otherskits);
		}
		if (e.getCurrentItem().equals(Anchor)) {

			p.openInventory(anchorkit);
		}
		if (e.getCurrentItem().equals(Beastmaster)) {

			p.openInventory(beastmasterkit);
		}
		if (e.getCurrentItem().equals(Archer)) {

			p.openInventory(archerkit);
		}
		if (e.getCurrentItem().equals(Berserker)) {

			p.openInventory(berserkerkit);
		}
		if (e.getCurrentItem().equals(Boxer)) {

			p.openInventory(boxerkit);
		}
		if (e.getCurrentItem().equals(Camel)) {

			p.openInventory(camelkit);
		}
		if (e.getCurrentItem().equals(Cannibal)) {

			p.openInventory(cannibalkit);
		}

		if (e.getCurrentItem().equals(Chameleon)) {

			p.openInventory(chameleonkit);
		}
		if (e.getCurrentItem().equals(Chemist)) {

			p.openInventory(chemistkit);
		}
		if (e.getCurrentItem().equals(Cookiemonster)) {

			p.openInventory(cookiemonsterkit);
		}
		if (e.getCurrentItem().equals(Cultivator)) {

			p.openInventory(cultivatorkit);
		}
		if (e.getCurrentItem().equals(Demoman)) {

			p.openInventory(demomankit);
		}
		if (e.getCurrentItem().equals(Digger)) {

			p.openInventory(diggerkit);
		}
		if (e.getCurrentItem().equals(Doctor)) {

			p.openInventory(doctorkit);
		}
		if (e.getCurrentItem().equals(Dwarf)) {

			p.openInventory(dwarfkit);
		}
		if (e.getCurrentItem().equals(Endermage)) {

			p.openInventory(endermagekit);
		}
		if (e.getCurrentItem().equals(Fireman)) {

			p.openInventory(firemankit);
		}
		if (e.getCurrentItem().equals(Fisherman)) {

			p.openInventory(fishermankit);
		}
		if (e.getCurrentItem().equals(Flash)) {

			p.openInventory(flashkit);
		}
		if (e.getCurrentItem().equals(Forger)) {

			p.openInventory(forgerkit);
		}
		if (e.getCurrentItem().equals(Frosty)) {

			p.openInventory(frostykit);
		}
		if (e.getCurrentItem().equals(Gambler)) {

			p.openInventory(gamblerkit);
		}
		if (e.getCurrentItem().equals(GrandPa)) {

			p.openInventory(grandpakit);
		}
		if (e.getCurrentItem().equals(GraveDigger)) {

			p.openInventory(gravediggerkit);
		}
		if (e.getCurrentItem().equals(Hermit)) {

			p.openInventory(hermitkit);
		}
		if (e.getCurrentItem().equals(Hulk)) {

			p.openInventory(hulkkit);
		}
		if (e.getCurrentItem().equals(Hunter)) {

			p.openInventory(hunterkit);
		}
		if (e.getCurrentItem().equals(Jackhammer)) {

			p.openInventory(jackhammerkit);
		}
		if (e.getCurrentItem().equals(Jumper)) {

			p.openInventory(jumperkit);
		}
		if (e.getCurrentItem().equals(Kangaroo)) {

			p.openInventory(kangarookit);
		}
		if (e.getCurrentItem().equals(Kaya)) {

			p.openInventory(kayakit);
		}
		if (e.getCurrentItem().equals(Launcher)) {

			p.openInventory(launcherkit);
		}
		if (e.getCurrentItem().equals(Levitator)) {

			p.openInventory(levitatorkit);
		}
		if (e.getCurrentItem().equals(LumberJack)) {

			p.openInventory(lumberjackkit);
		}
		if (e.getCurrentItem().equals(Miner)) {

			p.openInventory(minerkit);
		}
		if (e.getCurrentItem().equals(Monster)) {

			p.openInventory(monsterkit);
		}
		if (e.getCurrentItem().equals(Necro)) {

			p.openInventory(necrokit);
		}
		// INVENTAIRE2
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(beastmasterkit.getName())) {

			p.performCommand("kit beastmaster");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(anchorkit.getName())) {

			p.performCommand("kit anchor");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(archerkit.getName())) {

			p.performCommand("kit archer");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(berserkerkit.getName())) {

			p.performCommand("kit berserker");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(boxerkit.getName())) {

			p.performCommand("kit boxer");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(camelkit.getName())) {

			p.performCommand("kit camel");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(cannibalkit.getName())) {

			p.performCommand("kit cannibal");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(chameleonkit.getName())) {

			p.performCommand("kit chameleon");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(chemistkit.getName())) {

			p.performCommand("kit chemist");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName()
						.equals(cookiemonsterkit.getName())) {

			p.performCommand("kit cookiemonster");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(cultivatorkit.getName())) {

			p.performCommand("kit cultivator");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(demomankit.getName())) {

			p.performCommand("kit demoman");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(diggerkit.getName())) {

			p.performCommand("kit digger");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(doctorkit.getName())) {

			p.performCommand("kit doctor");
			p.closeInventory();
			return;
		}

		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(dwarfkit.getName())) {

			p.performCommand("kit dwarf");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(endermagekit.getName())) {

			p.performCommand("kit endermage");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(firemankit.getName())) {

			p.performCommand("kit fireman");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(fishermankit.getName())) {

			p.performCommand("kit fisherman");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(flashkit.getName())) {

			p.performCommand("kit flash");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(forgerkit.getName())) {

			p.performCommand("kit forger");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(frostykit.getName())) {

			p.performCommand("kit frosty");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(gamblerkit.getName())) {

			p.performCommand("kit gambler");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(grandpakit.getName())) {

			p.performCommand("kit grandpa");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(gravediggerkit.getName())) {

			p.performCommand("kit gravedigger");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(hermitkit.getName())) {

			p.performCommand("kit hermit");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(hulkkit.getName())) {

			p.performCommand("kit hulk");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(hunterkit.getName())) {

			p.performCommand("kit hunter");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(jackhammerkit.getName())) {

			p.performCommand("kit jackhammer");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(jumperkit.getName())) {

			p.performCommand("kit jumper");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(kangarookit.getName())) {

			p.performCommand("kit kangaroo");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(kayakit.getName())) {

			p.performCommand("kit kaya");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(launcherkit.getName())) {

			p.performCommand("kit launcher");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(levitatorkit.getName())) {

			p.performCommand("kit levitator");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(lumberjackkit.getName())) {

			p.performCommand("kit LumberJack");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(minerkit.getName())) {

			p.performCommand("kit miner");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(monsterkit.getName())) {

			p.performCommand("kit monster");
			p.closeInventory();
			return;
		}
		if (e.getCurrentItem().getType() == Material.FIRE
				&& e.getInventory().getName().equals(necrokit.getName())) {
			p.performCommand("kit necro");
			p.closeInventory();
			return;
		}
		// INVENTAIRE3
	}

	// TODO
	public void openInv(Player player) {
		Inventory inv = Bukkit.createInventory(player, 27,
				"             §fVos kits: " + getAmountOwnedKits(player) + "/"
						+ Kit.values().length);
		player.openInventory(inv);
	}

	public static Integer getAmountOwnedKits(Player p) {
		Integer owned = 0;
		for (me.Girardcome.HG.Misc.Kit str : me.Girardcome.HG.Misc.Kit.values()) {
			if (p.hasPermission("hg.kits." + str.name())) {
				owned++;
			}
		}
		return owned;
	}//i do it really wrongly and it was when i was a noobie on coding xD
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		Player p = (Player) arg0;
		if (arg1.getName().equalsIgnoreCase("open")) {
			InvPage1(p);
		}
		return false;
	}

	public static KitSelector getKitSelector() {
		return instance;
	}

}