package com.senpai.tntsurvival;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tntrain implements CommandExecutor {

	Player s;
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		//plugin = new Main();
		if (arg0 instanceof Player) {
			Player s = ((Player) arg0).getPlayer();
			
			s.sendMessage("Du hast den TNT-Rain aktiviert");
		}
		sendCommandtoCOnsole();
		return true;
		

	}

	void sendCommandtoCOnsole() {
		Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "stnt");
	}

}
