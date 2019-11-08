package com.senpai.tntsurvival;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class tntrain implements CommandExecutor {
	int i;
	Player s;
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if (arg0 instanceof Player) {
			Player s = ((Player) arg0).getPlayer();
			s.sendMessage("Du hast den TNT-Rain aktiviert");
		}
		while (true) {
			Bukkit.getScheduler().runTaskLater((Plugin) this, new Runnable() {

				@Override
				public void run() {
					
					s.sendMessage("Hello World");
				}
			}, 2000);
		}
	}

	void sendCommandtoCOnsole() {
		Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "stnt");
	}

}
