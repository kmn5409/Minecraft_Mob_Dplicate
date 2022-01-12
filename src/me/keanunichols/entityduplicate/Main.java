package me.keanunichols.entityduplicate;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new entityDeathListener(), this);  
		
	}


}
