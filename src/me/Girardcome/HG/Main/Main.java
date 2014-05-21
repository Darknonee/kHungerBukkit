package me.Girardcome.HG.Main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.Girardcome.HG.Commands.Admin;
import me.Girardcome.HG.Commands.Invincibility;
import me.Girardcome.HG.Commands.Ip;
import me.Girardcome.HG.Commands.KitCommand;
import me.Girardcome.HG.Commands.Kitinfo;
import me.Girardcome.HG.Commands.Kits;
import me.Girardcome.HG.Commands.Randoms;
import me.Girardcome.HG.Commands.Spawn;
import me.Girardcome.HG.Commands.Status;
import me.Girardcome.HG.Listeners.Game;
import me.Girardcome.HG.Listeners.PlayerListener;
import me.Girardcome.HG.Listeners.PreGame;
import me.Girardcome.HG.Managers.CraftingManager;
import me.Girardcome.HG.Misc.Compass;
import me.Girardcome.HG.Misc.KitManager;
import me.Girardcome.HG.Misc.Vanish;
import me.Girardcome.HG.Commands.Start;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Difficulty;
import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Main extends JavaPlugin implements Listener {
	BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	public Main Main;
	int task;
	public int time = -1;
	public int pretime = 180;
	public int invincibiltyTime = 122;
	public int PreGameTimerTask;
	public int TimerTask;
	public boolean isGameStarted = false;
	public boolean isFirstFiveMinutes = false;
	public boolean isFeastEarly = false;
	public boolean isGameEnded = false;
	public boolean isInvincibilityDisabled = false;
	public boolean isInvincibilityEnded = false;
	public boolean countdown = false;
	public int TimeBeforeShutdown = 0;
	public Location feast = null;
	public Map<String, String> playerKits = new HashMap();
	public ArrayList<Player> alive = new ArrayList();
	public HashMap<String, String> winner = new HashMap();
	public List<String> kits = new ArrayList<String>();
	public List<String> allKits = new ArrayList<String>();
	File playerDataFile;
	FileConfiguration playerData;
	ScoreboardManager manager = Bukkit.getScoreboardManager();
	public Scoreboard board = manager.getNewScoreboard();
	
	public void onEnable() {
		File directory = new File(getDataFolder().toString());
		if (!directory.exists()){
			directory.mkdir();
		}
		playerDataFile = new File(getDataFolder() + "\\dataplayers.yml");
		playerData = YamlConfiguration.loadConfiguration(playerDataFile);

		CraftingManager.Recipes();
		// Enregistrement des événements
		for (String kitName : getConfig().getStringList("Kits")) {
			kits.add(kitName);
		}
		for (String kitName : getConfig().getStringList("allKits")) {
			allKits.add(kitName);
		}
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(this, this);
		pm.registerEvents(new PlayerListener(this), this);
		pm.registerEvents(new KitManager(this), this);
		pm.registerEvents(new PreGame(this), this);
		pm.registerEvents(new Game(this), this);
		pm.registerEvents(new Compass(this), this);
		//pm.registerEvents(new KitSelector(this), this);
		pm.registerEvents(new Vanish(), this);
		/*pm.registerEvents(new Soup(), this);
		pm.registerEvents(new MOTD(this), this);
		pm.registerEvents(new Poseidon(this), this);
		pm.registerEvents(new Demon(this), this);
		pm.registerEvents(new Boxer(), this);
		pm.registerEvents(new Camel(this), this);
		pm.registerEvents(new Archer(this), this);
		pm.registerEvents(new Beastmaster(this), this);
		pm.registerEvents(new Berserker(this), this);
		pm.registerEvents(new Burrower(this), this);
		pm.registerEvents(new Cannibal(this), this);
		pm.registerEvents(new Cookiemonster(this), this);
		pm.registerEvents(new Doctor(this), this);
		pm.registerEvents(new Dwarf(this), this);
		pm.registerEvents(new Fisherman(this), this);
		pm.registerEvents(new Forger(this), this);
		pm.registerEvents(new Hunter(this), this);
		pm.registerEvents(new Kangaroo(this), this);
		pm.registerEvents(new Milkman(this), this);
		pm.registerEvents(new Rider(this), this);
		pm.registerEvents(new Worm(this), this);
		pm.registerEvents(new Array(this), this);
		*/
		// Commandes
		getCommand("start").setExecutor(new Start(this));
		getCommand("Vanish").setExecutor(new Vanish());
		getCommand("ip").setExecutor(new Ip(this));
		getCommand("spawn").setExecutor(new Spawn(this));
		getCommand("kit").setExecutor(new KitCommand(this));
		getCommand("admin").setExecutor(new Admin(this));
		getCommand("kitinfo").setExecutor(new Kitinfo(this));
		getCommand("random").setExecutor(new Randoms(this));
		getCommand("invincibility").setExecutor(new Invincibility(this));
		getCommand("status").setExecutor(new Status(this));
		getCommand("kits").setExecutor(new Kits(this));

		// Autres
		saveDefaultConfig();
		Bukkit.getConsoleSender().sendMessage("JCPVP is enabled");
		Bukkit.getWorld("world").setSpawnLocation(0, 85, 0);
		Bukkit.getServer().setDefaultGameMode(GameMode.SURVIVAL);
		Bukkit.getServer().setSpawnRadius(0);
		Bukkit.getServer().getWorld("world").setDifficulty(Difficulty.HARD);
	}
	public void addPermission(String uuid, String permission) {
		List<String> permissions = playerData.getStringList(uuid);
		if (!permissions.contains(permission)) {
			permissions.add(permission);
		}
		playerData.set(uuid, permissions);
		try {
			playerData.save(playerDataFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removePermission(String uuid, String permission) {
		List<String> permissions = playerData.getStringList(uuid);
		permissions.remove(permission);
		playerData.set(uuid, permissions);
		try {
			playerData.save(playerDataFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean hasPermission(String uuid, String permission) {
		List<String> permissions = playerData.getStringList(uuid);
		return permissions.contains(permission);
	}
	public void Start() {

		Bukkit.getServer().broadcastMessage("§cLe tournoi a commencé !");
		if(Bukkit.getOnlinePlayers().length == 1) {
		Bukkit.getServer().broadcastMessage("§cIl y a 1 participant");
		} else {
			Bukkit.getServer().broadcastMessage("§cIl y a " + Bukkit.getOnlinePlayers().length + " participants");
		}
		Bukkit.getServer().broadcastMessage("§cTous les participants sont invincibles pendant 2 minutes");
		Bukkit.getServer().broadcastMessage("§cBonne chance !");
		isGameStarted = true;
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.setAllowFlight(false);
			p.teleport(p.getWorld().getSpawnLocation());
			p.getInventory().clear();
			p.setGameMode(GameMode.SURVIVAL);
			p.setHealth(20);
			p.setFoodLevel(20);
			KitManager.GiveKits();
			p.getInventory().addItem(new ItemStack(Material.COMPASS));
		}
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						isFirstFiveMinutes = true;
					}

				}, 5 * 60 * 20L);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			public void run() {
				isFeastEarly = true;
			}

		}, 15 * 60 * 20L);
	}

	public boolean forceTimer() {
		Bukkit.getScheduler().cancelTask(TimerTask);
		isInvincibilityDisabled = true;
		pretime = -1;
		return true;

	}
		public void invTimer() {
			
			Objective o = board.getObjective("test2");
				if(o != null) {
				    o.unregister();
				}

				o = board.registerNewObjective("test2", "dummy");
	        o.setDisplaySlot(DisplaySlot.SIDEBAR);
	        final Objective o2 = o;
			TimerTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
					public void run() {
						int temps = invincibiltyTime;
			             int minutes = (int) Math.floor(temps / 60);
			             int secondes = temps % 60;
						if (invincibiltyTime == 0) {
							for(Player online : Bukkit.getOnlinePlayers()){
					        	 online.getScoreboard();
					        	}
							Bukkit.getServer().broadcastMessage("§cL'invincibilité est désactivée !");
							Bukkit.getScheduler().cancelTask(TimerTask);
							invincibiltyTime = -1;
							isInvincibilityEnded = true;
							return;
						}
						if(invincibiltyTime == 1) {
							Bukkit.getServer().broadcastMessage("§cL'invincibilité s'enlevera dans 1 seconde");
						} else
						if ((invincibiltyTime == 2) || (invincibiltyTime == 3)
								|| (invincibiltyTime == 4) || (invincibiltyTime == 5)
								|| (invincibiltyTime == 10) || (invincibiltyTime == 15)
								|| (invincibiltyTime == 30) || (invincibiltyTime == 45)) {
							Bukkit.getServer().broadcastMessage("§cL'invincibilité s'enlevera dans " + invincibiltyTime + " secondes");
						} else if (invincibiltyTime == 60) {
							Bukkit.getServer().broadcastMessage("§cL'invincibilité s'enlevera dans 1 minute");
						} else if (invincibiltyTime == 120) {
							Bukkit.getServer().broadcastMessage("§cL'invincibilité s'enlevera dans 2 minutes");
				             o2.setDisplayName(String.format("§cDébute dans : %02d:%02d", minutes, secondes));
						}
						invincibiltyTime--;
					}
				}, 0, 20);
			 for(Player online : Bukkit.getOnlinePlayers()){
	        	  Score score = o.getScore(online);
	        	  score.setScore(6); //Example
	        	}
		}
		public void PreGameTimer() {
			Objective o = board.getObjective("test1");
			if(o != null) {
			    o.unregister();
			}

			o = board.registerNewObjective("test1", "dummy");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        final Objective o2 = o;
	        o.setDisplaySlot(DisplaySlot.SIDEBAR);
			PreGameTimerTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
					public void run() {
			        	 int temps = pretime;
			             int minutes = (int) Math.floor(temps / 60);
			             int secondes = temps % 60;
			             o2.setDisplayName(String.format("§cDébute dans : %02d:%02d", minutes, secondes));
						if (pretime == 0) {
							if ((Bukkit.getOnlinePlayers().length == 0) || (Bukkit.getOnlinePlayers().length == 10)) {
								Bukkit.getServer().broadcastMessage("§cLa partie débute à 10 participants de connectés !");
								add();
								return;
							}
							Start();
							Bukkit.getScheduler().cancelTask(PreGameTimerTask);
							invTimer();
							pretime = -1;
							return;
						}
						if(pretime == 1) {
							Bukkit.getServer().broadcastMessage("§cLa partie commence dans 1 seconde");
						}
						if ((pretime == 2) || (pretime == 3)
								|| (pretime == 4) || (pretime == 5)
								|| (pretime == 10) || (pretime == 15)
								|| (pretime == 30)) {
							Bukkit.getServer().broadcastMessage("§cLa partie commence dans " + pretime + " secondes");
						} else if (pretime == 60) {
							Bukkit.getServer().broadcastMessage("§cLa partie commence dans 1 minute");
						} else if ((pretime == 120) || (pretime == 180)
								|| (pretime == 240)) {
							int tijd = pretime / 60;
							Bukkit.getServer().broadcastMessage("§cLa partie commence dans " + tijd + " minutes");
						} else if (pretime == 181) {
							Bukkit.broadcastMessage("");
						}
						pretime--;
					}
				}, 0, 20);
			 for(Player online : Bukkit.getOnlinePlayers()){
	        	  Score score = o.getScore(online);
	        	  score.setScore(6); //Example
	        	}
		}
		public void Check() {
			if (time > 0) {
				alive.clear();
				for (Player p : Bukkit.getOnlinePlayers()) {
					if (p.getGameMode() != GameMode.CREATIVE) {
						alive.add(p);
					} else if (p.getGameMode() == GameMode.CREATIVE) {
						alive.remove(p);
					}
				}
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							Bukkit.getServer().broadcastMessage(
									"§b" + alive.size() + " joueurs restants.");
						}
					}, 1);
			if (alive.size() == 1 || alive.size() == 0) {
				if (isGameStarted == true) {
					isGameEnded = true;
					shutDown();
				} else {
					// Check();
				}
			}
		}
	}

	public void shutDown() {
		Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			public void run() {
				Bukkit.getScheduler().cancelTask(TimerTask);
				Bukkit.getScheduler().cancelTask(PreGameTimerTask);
				time = -1;
				pretime = -1;
			}
		}, 5);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					if (winner.containsKey(p.getName())) {
						Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getName() + " a gagné(e) !");
					}
				}
			}
		}, 20, 40);
		forceTimer();
		time = 121;
		for (Player p1 : Bukkit.getOnlinePlayers()) {
			if (p1.getGameMode() == GameMode.CREATIVE) {
				return;
			}
			Location l = p1.getLocation();
			Location loc = new Location(l.getWorld(), l.getX() + 15, l.getY(), l.getZ() + 15);
			Firework firework = (Firework) p1.getWorld().spawn(loc, Firework.class);
			FireworkMeta data = firework.getFireworkMeta();
			data.addEffects(new FireworkEffect[] { FireworkEffect.builder()
					.withColor(Color.GREEN)
					.with(FireworkEffect.Type.BALL_LARGE).build() });
			data.addEffects(new FireworkEffect[] { FireworkEffect.builder()
					.withColor(Color.RED).with(FireworkEffect.Type.BALL_LARGE)
					.build() });
			data.addEffects(new FireworkEffect[] { FireworkEffect.builder()
					.withColor(Color.AQUA).with(FireworkEffect.Type.BALL_LARGE)
					.build() });
			data.addEffects(new FireworkEffect[] { FireworkEffect.builder()
					.withColor(Color.FUCHSIA)
					.with(FireworkEffect.Type.BALL_LARGE).build() });
			data.addEffects(new FireworkEffect[] { FireworkEffect.builder()
					.withColor(Color.ORANGE)
					.with(FireworkEffect.Type.BALL_LARGE).build() });
			data.setPower(2);
			firework.setFireworkMeta(data);
			Location pLoc = p1.getLocation();

			Location winnerLoc = new Location(p1.getWorld(), pLoc.getBlockX(), 110.0D, pLoc.getBlockZ());
			for (int x = -2; x < 2; x++) {
				for (int z = -2; z < 2; z++) {
					Block b = winnerLoc.clone().add(x, -2.0D, z).getBlock();
					Block b2 = winnerLoc.clone().add(x, -1.0D, z).getBlock();

					b.setType(Material.GLASS);
					b2.setType(Material.CAKE_BLOCK);
				}
			}
			p1.teleport(winnerLoc);
			winner.put(p1.getName(), null);
			//Could just an ArrayList ^?
		}
		Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			public void run() {
				isGameStarted = false;
				for (Player p : Bukkit.getOnlinePlayers()) {
					p.kickPlayer(p.getName() + ChatColor.RED + " à gagner la partie !\nLe serveur redémarre !");
					TimeBeforeShutdown++;
					if (TimeBeforeShutdown == 45) {
						// rollback("world");
						File mapDelete = new File("/world/");
						suppr(mapDelete);
					}
				}

			}
		}, 300L);
	}

	@EventHandler
	public void onJoi2(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		if (time > 0) {
			p.kickPlayer("§cHardcore Games en cours!");
		}
	}

	@EventHandler
	public void onLeaveEvent(PlayerQuitEvent event) {
		if (winner.containsKey(event.getPlayer().getName())) {
			winner.remove(event.getPlayer().getName());
		}
	}

	public void add() {
		pretime = 30;
	}

	public void ClearInv(Player p) {
		p.getInventory().clear();
		for (PotionEffect pe : p.getActivePotionEffects()) {
			p.getActivePotionEffects().remove(pe.getType());
		}
		p.setGameMode(GameMode.SURVIVAL);
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
	}

	public static void suppr(File r) {
		File[] fileList = r.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isDirectory()) {
				suppr(fileList[i]);
				System.out.println(fileList[i].delete());
			} else {
				System.out.println(fileList[i].delete());
			}
		}
		Bukkit.getServer().shutdown();
	}
	
}