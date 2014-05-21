package me.Girardcome.HG.Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.Girardcome.HG.Managers.FeastManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
public class KitManager
  implements Listener
{
  public static Plugin plugin;
  public static HashMap<String, Kit> kits = new HashMap<String, Kit>();
  public static List<Player> Stomper = new ArrayList();
  public static List<Player> poseidon = new ArrayList();
  
  public KitManager(Plugin instance){
	  plugin = instance;
  }
  public static void setKit(Player p, Kit kit){
	  
	  if(kit == null){
		  kits.remove(p.getName());
		  
	  }else{
		  kits.put(p.getName(), kit);
	  }
	  
  }
  static Boolean itemsgiven = false;
  public static void GiveKits()
  {
	  if(itemsgiven) return;
	  itemsgiven = true;
    for (Player p : Bukkit.getOnlinePlayers())
    {
    	Kit kit = kits.get(p.getName());
    	if(kit == null){
    		setKit(p, Kit.None);
    		None(p);
    	}
    	else{     if (kit.equals(Kit.Archer)) {
            Archer(p);
          } else if (kit.equals(Kit.Array)) {
            Array(p);
          } else if (kit.equals(Kit.Beastmaster)) {
            Beastmaster(p);
          } else if (kit.equals(Kit.Docter)) {
            Doctor(p);
          } else if (kit.equals(Kit.Fireman)) {
            Fireman(p);
          } else if (kit.equals(Kit.Fisherman)) {
            Fisherman(p);
          } else if (kit.equals(Kit.Flash)) {
            Flash(p);
          } else if (kit.equals(Kit.Forger)) {
            Forger(p);
          } else if (kit.equals(Kit.Frosty)) {
            Frosty(p);
          } else if (kit.equals(Kit.Jumper)) {
            Jumper(p);
          } else if (kit.equals(Kit.Kangaroo)) {
            Kangaroo(p);
          } else if (kit.equals(Kit.Milkman)) {
            Milkman(p);
          } else if (kit.equals(Kit.Monk)) {
            Monk(p);
          } else if (kit.equals(Kit.Phantom)) {
            Phantom(p);
          } else if (kit.equals(Kit.Reaper)) {
            Miner(p);
          } else if (kit.equals(Kit.Rider)) {
            Rider(p);
          } else if (kit.equals(Kit.Specialist)) {
            Miner(p);
          } else if (kit.equals(Kit.Spectre)) {
            Miner(p);
          } else if (kit.equals(Kit.Switcher)) {
                Miner(p);
          } else if (kit.equals(Kit.Tank)) {
                Miner(p);
          } else if (kit.equals(Kit.Thor)) {
                Miner(p);
          } else if (kit.equals(Kit.Viking)) {
                Miner(p);
          } else if (kit.equals(Kit.Viper)) {
                Miner(p);
          } else if (kit.equals(Kit.Worm)) {
                Miner(p);
            }
    	
           	}
    }
  }
  public static void Frosty(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
        	p.getInventory().addItem(new ItemStack(Material.SNOW_BALL, 5));
        }
      }, 5L);
  }
  public static void None(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
        	p.getInventory().addItem(new ItemStack(Material.WOOD_SWORD));
        }
      }, 5L);
  }
public static HashMap<String, Kit> getKitHashmap(){
	  return kits;
  }
  
  public static void Miner(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack miner = new ItemStack(Material.STONE_PICKAXE);
          miner.addEnchantment(Enchantment.DURABILITY, 2);
          miner.addEnchantment(Enchantment.DIG_SPEED, 1);
          ItemMeta minerim = miner.getItemMeta();
          minerim.setDisplayName("Miner's Pickaxe");
          miner.setItemMeta(minerim);
          p.getInventory().addItem(new ItemStack[] { miner });
        }
      }, 5L);
  }
  
  public static void Chemist(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack pot1 = new ItemStack(373, 1, (short)16428);
          ItemStack pot2 = new ItemStack(373, 1, (short)16420);
          ItemStack pot3 = new ItemStack(373, 1, (short)16456);
          p.getInventory().addItem(new ItemStack[] { pot1, pot2, pot3 });
        }
      }, 5L);
  }
  
  public static void Crafter(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack miner = new ItemStack(Material.BLAZE_POWDER);
          ItemMeta minerim = miner.getItemMeta();
          minerim.setDisplayName("§bAtelier portatif");
          miner.setItemMeta(minerim);
          ItemStack four = new ItemStack(Material.NETHER_STAR);
          ItemMeta fourim = four.getItemMeta();
          fourim.setDisplayName("§bFourneau portatif");
          four.setItemMeta(fourim);
          p.getInventory().addItem(new ItemStack[] { miner, four });
        }
      }, 5L);
  }
  public static void Phantom(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
        	p.getInventory().addItem(new ItemStack(Material.FEATHER));
        }
      }, 5L);
  }
  
  public static void Archer(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack bow = new ItemStack(Material.BOW);
          ItemStack arrow = new ItemStack(Material.ARROW, 10);
          p.getInventory().addItem(new ItemStack[] { bow, arrow });
        }
      }, 5L);
  }
  
  public static void Beastmaster(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack monster = new ItemStack(Material.MONSTER_EGG, 3);
          ItemStack bone = new ItemStack(Material.BONE, 4);
          p.getInventory().addItem(new ItemStack[] { monster, bone });
        }
      }, 5L);
  }
  
  public static void Burrower(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack monster = new ItemStack(Material.SLIME_BALL, 5);
          ItemMeta fourim = monster.getItemMeta();
          fourim.setDisplayName("§aBurrower");
          monster.setItemMeta(fourim);
          p.getInventory().addItem(new ItemStack[] { monster });
        }
      }, 5L);
  }
  
  public static void Barbarian(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack barbarian = new ItemStack(
            Material.STONE_SWORD);
          p.getInventory().addItem(new ItemStack[] { barbarian });
        }
      }, 5L);
  }
  
  public static void Demoman(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack plate = new ItemStack(Material.STONE_PLATE, 6);
          ItemStack gravel = new ItemStack(Material.GRAVEL, 6);
          p.getInventory().addItem(new ItemStack[] { gravel, plate });
        }
      }, 5L);
  }
  
  public static void Digger(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack plate = new ItemStack(Material.DRAGON_EGG, 6);
          p.getInventory().addItem(new ItemStack[] { plate });
        }
      }, 5L);
  }
  
  public static void Doctor(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack barbarian = new ItemStack(
            Material.SHEARS);
          p.getInventory().addItem(new ItemStack[] { barbarian });
        }
      }, 5L);
  }
  
  public static void Endermage(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack barbarian = new ItemStack(
            Material.PORTAL);
          p.getInventory().addItem(new ItemStack[] { barbarian });
        }
      }, 5L);
  }
  
  public static void Fireman(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack barbarian = new ItemStack(
            Material.WATER_BUCKET);
          p.getInventory().addItem(new ItemStack[] { barbarian });
        }
      }, 5L);
  }
  
  public static void Fisherman(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack plate = new ItemStack(Material.FISHING_ROD);
          p.getInventory().addItem(new ItemStack[] { plate });
        }
      }, 5L);
  }
  
  public static void Flash(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack plate = new ItemStack(Material.REDSTONE_TORCH_ON);
          p.getInventory().addItem(new ItemStack[] { plate });
        }
      }, 5L);
  }
  
  public static void Forger(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack plate = new ItemStack(Material.COAL, 3);
          p.getInventory().addItem(new ItemStack[] { plate });
        }
      }, 5L);
  }
  
  public static void Jumper(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack plate = new ItemStack(Material.ENDER_PEARL, 5);
          p.getInventory().addItem(new ItemStack[] { plate });
        }
      }, 5L);
  }
  
  public static void Kangaroo(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack plate = new ItemStack(Material.FIREWORK, 1);
          p.getInventory().addItem(new ItemStack[] { plate });
        }
      }, 5L);
  }
  
  public static void Backpacker(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack plate = new ItemStack(Material.ENDER_CHEST, 1);
          p.getInventory().setItem(9, plate);
        }
      }, 5L);
  }
  
  public static void Array(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack plate = new ItemStack(Material.BEACON, 3);
          p.getInventory().addItem(new ItemStack[] { plate });
        }
      }, 5L);
  }
  
  public static void Rider(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack monster = new ItemStack(Material.SADDLE);
          ItemMeta fourim = monster.getItemMeta();
          fourim.setDisplayName("Rider");
          monster.setItemMeta(fourim);
          p.getInventory().addItem(new ItemStack[] { monster });
        }
      }, 5L);
  }
  
  public static void Gambler(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack plate = new ItemStack(Material.STONE_BUTTON, 1);
          p.getInventory().addItem(new ItemStack[] { plate });
        }
      }, 5L);
  }
  
  public static void Grandpa(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack plate = new ItemStack(Material.STICK, 1);
          plate.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
          p.getInventory().addItem(new ItemStack[] { plate });
        }
      }, 5L);
  }
  
  public static void Milkman(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack plate = new ItemStack(Material.MILK_BUCKET, 5);
          p.getInventory().addItem(new ItemStack[] { plate });
        }
      }, 5L);
  }
  
  public static void Monk(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          ItemStack plate = new ItemStack(Material.BLAZE_ROD);
          p.getInventory().addItem(new ItemStack[] { plate });
        }
      }, 5L);
  }
  
  public static void Hermit(final Player p)
  {
    Bukkit.getScheduler().scheduleAsyncDelayedTask(
      plugin, new Runnable()
      {
        public void run()
        {
          Location loc = p.getLocation();
          loc.setX(FeastManager.randomInt(-500, 500));
          loc.setZ(FeastManager.randomInt(-500, 500));
          loc.setY(85.0D);
          p.teleport(loc);
        }
      }, 5L);
  }
  
  public Kit getKitName(Player p) {
	  return KitManager.getKitHashmap().get(p.getName());
  }
}
