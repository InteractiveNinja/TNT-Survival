package com.senpai.tntsurvival;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
public class Main extends  JavaPlugin implements CommandExecutor {

	public static final String PLUGINNAME = "[TNT Survival]";
	
	@Override
    public void onEnable() {
		System.out.println(PLUGINNAME + "Aktiv");
		this.getCommand("who").setExecutor(new senpai());
		this.getCommand("stnt").setExecutor(new stnt());
		this.getCommand("tntrain").setExecutor(new tntrain());
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {
    	System.out.println(PLUGINNAME + "Deaktiviert");
    }
}
