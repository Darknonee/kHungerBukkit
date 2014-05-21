package me.Girardcome.HG.Kits;

import java.io.File;
import java.util.List;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ReadConfig
{
  File CONFIG = new File("plugins/GirardcomeHG", "config.yml");
  FileConfiguration cfg = YamlConfiguration.loadConfiguration(CONFIG);
  
  public boolean defaultOn()
  {
    return cfg.getBoolean("defaultOn");
  }
  
  public boolean showMessages()
  {
    return cfg.getBoolean("showMessages");
  }
  
  public int throwStrength()
  {
    return cfg.getInt("throwStrength");
  }
  
  public List<String> worlds()
  {
    return cfg.getStringList("disableOnWorlds");
  }
}
