package me.Girardcome.HG.Managers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import me.Girardcome.HG.Main.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;
@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
public class FeastManager {
	
	  public Main plugin;
	  
	  public FeastManager(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  
	  private Location feastLocation = null;
	  public int feastcd = 301;
	  
	ItemStack speed = new ItemStack(373, 2, (short)16386);
	  ItemStack regen = new ItemStack(373, 1, (short)16385);
	  ItemStack force2 = new ItemStack(373, 2, (short)16425);
	  ItemStack force = new ItemStack(373, 4, (short)16393);
	  ItemStack poison = new ItemStack(373, 4, (short)16420);
	  ItemStack damage = new ItemStack(373, 3, (short)16428);
	  ItemStack slow = new ItemStack(373, 3, (short)16426);
	private List<ItemStack> listItem = new LinkedList(
	    Arrays.asList(new ItemStack[] {new ItemStack(Material.DIAMOND_SWORD, 1), new ItemStack(Material.MUSHROOM_SOUP, 15), new ItemStack(Material.COOKED_BEEF, 30), new ItemStack(Material.GRILLED_PORK, 20), new ItemStack(Material.BOW, 5), new ItemStack(Material.ARROW, 100), new ItemStack(Material.WATER_BUCKET, 6), new ItemStack(Material.LAVA_BUCKET, 6), new ItemStack(Material.FLINT_AND_STEEL, 5), new ItemStack(Material.ENDER_PEARL, 30), new ItemStack(Material.DIAMOND_BOOTS, 2), new ItemStack(Material.DIAMOND_LEGGINGS, 2), new ItemStack(Material.DIAMOND_CHESTPLATE, 1), new ItemStack(Material.WEB, 30), new ItemStack(damage), new ItemStack(speed), new ItemStack(poison), new ItemStack(force), new ItemStack(force2), new ItemStack(regen), new ItemStack(slow), new ItemStack(Material.TNT, 5) }));
	  private List<ItemStack> listItem2 = listItem;
	  
	  public void feast(Location loc)
	  {
		  if(feastLocation == null){
			    feastLocation = new Location(Bukkit.getWorld("world"), randomInt(-100, 100), 0.0D, randomInt(-100, 100));
			    feastLocation.setY(feastLocation.getWorld().getHighestBlockYAt(feastLocation)); 
		  }
	    final World w = loc.getWorld();
	    final int groundy = (int)loc.getY();
	    final int fx = (int)loc.getX();
	    final int fz = (int)loc.getZ();
	    for (int x = -20; x <= 20; x++) {
	      for (int z = -20; z <= 20; z++) {
	        if (x * x + z * z <= 400) {
	          for (int y = groundy - 1; y > groundy - 0; y--)
	          {
	            Block bl = w.getBlockAt(x + fx, y, z + fz);
	            if ((bl.getType() == Material.AIR) || (bl.isLiquid()) || (bl.getType() == Material.DEAD_BUSH) || (bl.getType() == Material.SNOW) || (bl.getType() == Material.RED_ROSE) || (bl.getType() == Material.RED_MUSHROOM) || (bl.getType() == Material.YELLOW_FLOWER) || (bl.getType() == Material.BROWN_MUSHROOM))
	            {
	              Biome b1 = bl.getBiome();
	              Material m = Material.DIRT;
	              if ((b1 == Biome.BEACH) || (b1 == Biome.DESERT) || (b1 == Biome.DESERT_HILLS)) {
	                m = Material.SANDSTONE;
	              }
	              bl.setType(m);
	            }
	          }
	        }
	      }
	    }
	    for (int x = -20; x <= 20; x++) {
	      for (int z = -20; z <= 20; z++) {
	        if (x * x + z * z <= 400)
	        {
	          for (int yVide = groundy + 10; yVide > groundy; yVide--) {
	            w.getBlockAt(x + fx, yVide, z + fz).setType(Material.AIR);
	          }
	          w.getBlockAt(x + fx, groundy, z + fz).setType(Material.GRASS);
	        }
	      }
	    }
	    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
	    {
	      public void run()
	      {
	        spawnCoffre(w, groundy, fx, fz);
	      }
	    }, 1200L);
	  }
	  
	  public void spawnCoffre(World w, int groundy, int fx, int fz)
	  {
	    listItem2 = listItem;
	    w.getBlockAt(fx - 2, groundy + 1, fz + 2).setType(Material.CHEST);
	    itemCoffre(((Chest)w.getBlockAt(fx - 2, groundy + 1, fz + 2).getState()).getInventory());
	    
	    w.getBlockAt(fx + 2, groundy + 1, fz - 2).setType(Material.CHEST);
	    itemCoffre(((Chest)w.getBlockAt(fx + 2, groundy + 1, fz - 2).getState()).getInventory());
	    
	    w.getBlockAt(fx + 2, groundy + 1, fz + 2).setType(Material.CHEST);
	    itemCoffre(((Chest)w.getBlockAt(fx + 2, groundy + 1, fz + 2).getState()).getInventory());
	    
	    w.getBlockAt(fx - 2, groundy + 1, fz - 2).setType(Material.CHEST);
	    itemCoffre(((Chest)w.getBlockAt(fx - 2, groundy + 1, fz - 2).getState()).getInventory());
	    
	    w.getBlockAt(fx + 2, groundy + 1, fz - 2).setType(Material.CHEST);
	    itemCoffre(((Chest)w.getBlockAt(fx + 2, groundy + 1, fz - 2).getState()).getInventory());
	    
	    w.getBlockAt(fx - 1, groundy + 1, fz - 1).setType(Material.CHEST);
	    itemCoffre(((Chest)w.getBlockAt(fx - 1, groundy + 1, fz - 1).getState()).getInventory());
	    
	    w.getBlockAt(fx - 1, groundy + 1, fz + 1).setType(Material.CHEST);
	    itemCoffre(((Chest)w.getBlockAt(fx - 1, groundy + 1, fz + 1).getState()).getInventory());
	    
	    w.getBlockAt(fx + 1, groundy + 1, fz - 1).setType(Material.CHEST);
	    itemCoffre(((Chest)w.getBlockAt(fx + 1, groundy + 1, fz - 1).getState()).getInventory());
	    
	    w.getBlockAt(fx + 1, groundy + 1, fz + 1).setType(Material.CHEST);
	    itemCoffre(((Chest)w.getBlockAt(fx + 1, groundy + 1, fz + 1).getState()).getInventory());
	    
	    w.getBlockAt(fx, groundy + 1, fz - 2).setType(Material.CHEST);
	    itemCoffre(((Chest)w.getBlockAt(fx, groundy + 1, fz - 2).getState()).getInventory());
	    
	    w.getBlockAt(fx, groundy + 1, fz + 2).setType(Material.CHEST);
	    itemCoffre(((Chest)w.getBlockAt(fx, groundy + 1, fz + 2).getState()).getInventory());
	    
	    w.getBlockAt(fx + 2, groundy + 1, fz).setType(Material.CHEST);
	    itemCoffre(((Chest)w.getBlockAt(fx + 2, groundy + 1, fz).getState()).getInventory());
	    
	    w.getBlockAt(fx - 2, groundy + 1, fz).setType(Material.CHEST);
	    itemCoffre(((Chest)w.getBlockAt(fx - 2, groundy + 1, fz).getState()).getInventory());
	    
	    w.getBlockAt(fx, groundy + 1, fz).setType(Material.ENCHANTMENT_TABLE);
	    
	    Bukkit.broadcastMessage("§cLe Feast a commencé !");
	  }
	  public void itemCoffre(org.bukkit.inventory.Inventory inventory)
	  {
	    int nbItem = randomInt(3, 7);
	    for (int i = 0; i < nbItem; i++) {
	      if (listItem2.size() > 0)
	      {
	        ItemStack is = new ItemStack((ItemStack)listItem2.get(randomInt(0, listItem2.size() - 1)));
	        int amount;
	        if (is.getAmount() > is.getType().getMaxStackSize() / 6) {
	          amount = randomInt(1, is.getType().getMaxStackSize() / 4);
	        } else {
	          amount = randomInt(1, is.getAmount());
	        }
	        if (is.getType().equals(Material.MUSHROOM_SOUP)) {
	          amount = randomInt(1, 8);
	        }
	        removeIS(is, amount);
	        is.setAmount(amount);
	        inventory.addItem(new ItemStack[] { is });
	      }
	    }
	  }
	  
	  public void removeIS(ItemStack is, int amount)
	  {
	    if ((listItem2.contains(is)) && (is.getAmount() - amount > 0)) {
	      ((ItemStack)listItem2.get(listItem2.indexOf(is))).setAmount(is.getAmount() - amount);
	    } else if ((listItem2.contains(is)) && (is.getAmount() - amount <= 0)) {
	      listItem2.remove(is);
	    }
	  }
	  
	  public static int randomInt(int i, int j)
	  {
	    int r = (int)(Math.random() * (j - i + 1) + i);
	    return r;
	  }
	  public void TimerFeast()
	  {
	    Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable()
	    {
	      public void run()
	      {
	        int temps = feastcd;
	        int minutes = (int)Math.floor(temps / 60);
	        int secondes = temps % 60;
	        if (feastcd == 1) {
	          Bukkit.getServer().broadcastMessage("§cUn feast va commencer en (x:" + feastLocation.getBlockX() + ", y:" + feastLocation.getBlockY() + ", z:" + feastLocation.getBlockZ() + ") dans 1 seconde");
	        }
	        if ((feastcd == 2) || (feastcd == 3) || 
	          (feastcd == 4) || (feastcd == 5) || 
	          (feastcd == 10) || (feastcd == 15) || 
	          (feastcd == 30)) {
	          Bukkit.getServer().broadcastMessage("§cUn feast va commencer en (x:" + feastLocation.getBlockX() + ", y:" + feastLocation.getBlockY() + ", z:" + feastLocation.getBlockZ() + ") dans " + secondes + " secondes");
	        } else if (feastcd == 60) {
	          Bukkit.getServer().broadcastMessage("§cUn feast va commencer en (x:" + feastLocation.getBlockX() + ", y:" + feastLocation.getBlockY() + ", z:" + feastLocation.getBlockZ() + ") dans 1 minute");
	        } else if ((feastcd == 120) || (feastcd == 180) || 
	          (feastcd == 240)) {
	          Bukkit.getServer().broadcastMessage("§cUn feast va commencer en (x:" + feastLocation.getBlockX() + ", y:" + feastLocation.getBlockY() + ", z:" + feastLocation.getBlockZ() + ") dans " + minutes + " minutes");
	        }
	        feastcd -= 1;
	      }
	    }, 20L, 20L);
	  }
}
