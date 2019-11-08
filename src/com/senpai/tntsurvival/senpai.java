package com.senpai.tntsurvival;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class senpai implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String st, String[] arg3) {
		if(sender instanceof Player) {
			Player s = ((Player) sender).getPlayer();
			s.sendTitle(Main.PLUGINNAME,"Made by ImSenpai");
			
			return true;
		}
		return false;
	}

}
