package me.Girardcome.HG.Listeners;

import java.util.ArrayList;
import java.util.List;

import me.Girardcome.HG.Commands.Kits;
import me.Girardcome.HG.Main.Main;
import me.Girardcome.HG.Misc.BossBar;
import me.Girardcome.HG.Misc.KitManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
//import org.bukkit.inventory.ItemStack;
//import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.util.BlockIterator;
public class PlayerListener
  implements Listener
{

  public Main plugin;
  
public PlayerListener(Main plugin)
{
	this.plugin = plugin;
}
  @EventHandler 
  public void onJoin(PlayerJoinEvent event) {
	  Player p = event.getPlayer();
	  if(Bukkit.getOnlinePlayers().length >= 1) {
		  plugin.PreGameTimer();
		  p.setScoreboard(plugin.board);
	  }
	  if(plugin.isGameStarted == false) {
		 for (Object kitName : plugin.kits.toArray()) {
		       String kitNameString = String.valueOf(kitName);
		       String permission = "hg.kits." + kitNameString;
		       plugin.addPermission(p.getUniqueId().toString(), permission);
		}
		 if (p.isOp() == true) {
		 for (Object kitName : plugin.allKits.toArray()) {
		       String kitNameString = String.valueOf(kitName);
		       String permission = "hg.kits." + kitNameString;
		       plugin.addPermission(p.getUniqueId().toString(), permission);
		}
		 }
		  event.setJoinMessage(null);
	  } else  if(plugin.isGameStarted == true && plugin.isFirstFiveMinutes == true) {
		  if(p.hasPermission("hg.vip")) {
			  if(!p.hasPlayedBefore()) {
				  Bukkit.broadcastMessage("§6Bienvenue à §7§o" + p.getName() + " !");
			  	}
		  event.setJoinMessage("§e" + p.getName() + " joined the game.");
		  } else if(plugin.isGameStarted == true && !p.hasPermission("hg.vip")) {
			  p.kickPlayer("En cours. §bPour rentrer dans le serveur dans les 5 premières minutes, achetez le §aVIP §bsur §fwww.LVPvP.fr");
		  }
	  }
	  
  }
  @EventHandler
  public void onLeave(PlayerQuitEvent event) {
    if (plugin.isGameEnded == true) {
      event.setQuitMessage(null);
    }
  }
  @EventHandler
  public void onKick(PlayerKickEvent event) {
    event.setLeaveMessage(null);
  }
  @EventHandler
  public void onPlayerMove(PlayerMoveEvent event) {
	  Player p = event.getPlayer();
	  	    p.setScoreboard(plugin.board);
  }
  @EventHandler
  public void chat(AsyncPlayerChatEvent e) {
	  Player p = e.getPlayer();
	  if((plugin.pretime > -1)){ 
	  if(p.isOp()) {
		  e.setCancelled(false);
		  e.setFormat("§f<§c" + p.getName() + "§f> " + e.getMessage());
	  }
		  if(!KitManager.getKitHashmap().containsKey(p.getName())){
			  e.setCancelled(true);
			  Kits.showKits(p);
		  }
		  for(Player pl : e.getRecipients()) {
			  if(!KitManager.getKitHashmap().containsKey(p.getName())){
				  e.getRecipients().remove(pl.getName());
			  }
			  
		  }
	  }
  }
  @EventHandler
  public void onDamage(EntityDamageEvent event) {
    if (event.getCause() == EntityDamageEvent.DamageCause.VOID && plugin.isInvincibilityDisabled == false){
      event.getEntity().teleport(
        event.getEntity().getWorld().getSpawnLocation());
    }
    if(plugin.isInvincibilityDisabled == false){
    	event.setCancelled(true);
    }
    else{
    	event.setCancelled(false);
    }
}
  @EventHandler
  public void bossBar(final PlayerMoveEvent e){
	  Player pl = getTarget(e.getPlayer(), 2);
	  if(pl == null) return;
	  if(plugin.pretime <= -1) {
		  me.Girardcome.HG.Misc.Kit kit = KitManager.getKitHashmap().get(pl.getName());
		  String kit2 = "None";
		  if(kit == null){
			  kit2 = "None";
		  }else{
			  kit2 = kit.name();
		  }
		  BossBar.setMessage(e.getPlayer(), pl.getName() + " - " + kit2);
	  Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
		  public void run(){
			  BossBar.removeBar(e.getPlayer());
		  }
	  }, 40L);
	  }
	  
  }
  Player getTarget(Player pl, Integer range) {
      List<Entity> nearbyE = pl.getNearbyEntities(range,
              range, range);
      ArrayList<LivingEntity> livingE = new ArrayList<LivingEntity>();

      for (Entity e : nearbyE) {
          if (e instanceof Player) {
              livingE.add((LivingEntity) e);
          }
      }

      Player target = null;
      BlockIterator bItr = new BlockIterator(pl, range);
      Block block;
      Location loc;
      int bx, by, bz;
      double ex, ey, ez;
      while (bItr.hasNext()) {
              block = bItr.next();
              bx = block.getX();
              by = block.getY();
              bz = block.getZ();
                      for (LivingEntity e : livingE) {
                              loc = e.getLocation();
                              ex = loc.getX();
                              ey = loc.getY();
                              ez = loc.getZ();
                              if ((bx-.75 <= ex && ex <= bx+1.75) && (bz-.75 <= ez && ez <= bz+1.75) && (by-1 <= ey && ey <= by+2.5)) {
                                      // entity is close enough, set target and stop
                                      target = (Player) e;
                                      break;
                              }
                      }
              }
      return target;

          }
  
  // Débute dans <min>:<sec>
// Joueurs <nombreDeJoueurs>
  
 @EventHandler
  public void onPlayerJoinBook(PlayerJoinEvent event){
      Player player = event.getPlayer();
    	  ItemStack bookItem = new ItemStack(Material.WRITTEN_BOOK, 1);
    	  BookMeta metaData = (BookMeta) bookItem.getItemMeta();
    	  metaData.setTitle("§4§lHardcore Games");
    	  metaData.setAuthor("§cgirardcome");
    	  metaData.addPage("§4       Hardcore Games\n \n§9Objectif du jeu : \n§0Dans les HG, le but est d'être le dernier survivant. Vous devez chercher et tuer vos enemies, ou de créer des équipes afin d'améliorer vos chances !\n \n§4Tournez la page");
    	  metaData.addPage("§9Les kits :\n§0Chaque joueur commence avec 4 kits gratuits. Ces kits changenet tout les mois pour permettre aux joueurs d'essayer différents kits.\n \n§4Tournez la page");
    	  metaData.addPage("§9Les soupes :\n§0Les soupes régènent instantanément 3.5 coeurs lorsque vous faite un clique droit sur votre soupe. Cela permet de durer plus longtemps dans les combats. 3 recettes existes dans §cHardcore Games !\n \n§4Tournez la page");
    	  metaData.addPage("§9Recettes de soupe\n§4Soupe aux champignons\n§0Champignon rouge et brun sur le dessus d'un bol.\n§4Lait au Chocolat\n§0Graines de cacao sur le dessus d'un bol.\n§4Jus de Cactus\n§01 Cactus de chaque côté d'un bol.\n \n§4Tournez la page");
    	  metaData.addPage("§9Le Feast :\n§0Cette partie est importante dans l'Hunger Games. Au Feast, il y a des armures, potions, TNT, Ender perles, nourritures sont tous stockés dans des coffres.\n§4Les coordonnées du Feast sont annoncés !\n \n§4Tournez la page");
    	  metaData.addPage("§0Soyez prudent lorsque vous vous approchez à l'emplacement du Feast. D'autres joueurs voudront l'obtenir, alors vous devez lez tuer ou vous fuyez !\n \n§4Tournez la page");
    	  metaData.addPage("§9Fin de jeu :\n§0Certaines parties durent très longtemps, et nous ne voulons pas les joueurs restent sur le serveur pendant 1000 ans... A 50 minutes de jeu, tout les joueurs seront téléportés dans une fosse pour combattre !\n \n§4Tournez la page");
    	  bookItem.setItemMeta(metaData);
    	  player.getInventory().setItem(4, bookItem);
    	  player.getInventory().setItem(0, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(1, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(2, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(3, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(5, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(6, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(7, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(8, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(9, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(10, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(11, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(12, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(13, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(14, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(15, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(16, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(17, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(18, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(19, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(20, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(21, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(22, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(23, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(24, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(25, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(26, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(27, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(28, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(29, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(30, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(31, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(32, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(33, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(34, new ItemStack(Material.THIN_GLASS));
    	  player.getInventory().setItem(35, new ItemStack(Material.THIN_GLASS));
    	  }
 
/*  @EventHandler
  public void respawn(final PlayerRespawnEvent e){
	  Random random = new Random();
	  Integer x = random.nextInt(475 * 2);
	  x = x - 475;
	  Integer z = random.nextInt(475 * 2);
	  z = z - 475;
	  World w = e.getPlayer().getLocation().getWorld();
	  Integer y = w.getHighestBlockAt(x, z).getLocation().getBlockY() + 2;
	  Location loc = new Location(w,x,y,z);
	  e.setRespawnLocation(loc);
  }*/
  
  }