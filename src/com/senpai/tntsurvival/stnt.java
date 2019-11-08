package com.senpai.tntsurvival;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class stnt implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
		
		if(sender instanceof Player) {
			Player p = ((Player) sender).getPlayer();
			p.sendMessage(Main.PLUGINNAME + " Du hast TNT gespawnt");
		}
			
			Iterable<? extends Player> s = Bukkit.getOnlinePlayers();
			for (Player player : s) {
				player.sendMessage(Main.PLUGINNAME + " TNT SPAWN!");
				tntSpawn(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player);
			}
			return true;
			}
	
	
	
	
	void tntSpawn(double x, double y, double z, Player s) {
	s.getWorld().spawnEntity(new Location(s.getWorld(), x, y, z),EntityType.PRIMED_TNT);	
	}

}
