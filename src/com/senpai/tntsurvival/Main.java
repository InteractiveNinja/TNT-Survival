package com.senpai.tntsurvival;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {

	public static final String PLUGINNAME = ChatColor.DARK_RED + "[TNT Survival]";

	@Override
	public void onEnable() {

		System.out.println(PLUGINNAME + "Aktiv");
		this.getCommand("who").setExecutor(new senpai());
		this.getCommand("stnt").setExecutor(new stnt());
		this.getCommand("tntrain").setExecutor(this);
	}

	// Fired when plugin is disabled
	@Override
	public void onDisable() {
		System.out.println(PLUGINNAME + "Deaktiviert");
	}

	private boolean aktiv = false;
	private long time = 1200L;

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			Player s = ((Player) sender).getPlayer();
			try {
				switch (args[0]) {
				case "on":
					s.sendMessage(Main.PLUGINNAME + " Du hast den TNT-Rain aktiviert");
					aktiv = true;
					playAktivSound(aktiv);
					break;
				case "off":
					s.sendMessage(Main.PLUGINNAME + " Du hast den TNT-Rain deaktiviert");
					aktiv = false;
					time = 1200L;
					playAktivSound(aktiv);
					break;
				default:
					s.sendMessage(Main.PLUGINNAME + " Bitte benutze entweder on oder off als Parameter");
					break;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				s.sendMessage(Main.PLUGINNAME + " Bitte benutze entweder on oder off als Parameter");
			}

		}

		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				if (!aktiv) {
					stopTasks();
				} else {
					sendCommandtoCOnsole();

				}

			}
		}, 20L, time);

		return true;

	}

	void stopTasks() {
		Bukkit.getScheduler().cancelTasks(this);
	}

	void sendCommandtoCOnsole() {
		if (time != 200) {
			
			switch ((int) time) {
			case 1200:
				sendMSGtoPlayers("TNT Spawnt alle 60s");
				break;
			case 1100:
				//sendMSGtoPlayers("TNT Spawnt alle 55s");
				break;
			case 1000:
				//sendMSGtoPlayers("TNT Spawnt alle 50s");
				break;
			case 900:
				//sendMSGtoPlayers("TNT Spawnt alle 45s");
				break;
			case 800:
				sendMSGtoPlayers("TNT Spawnt alle 40s");
				break;
			case 700:
				//sendMSGtoPlayers("TNT Spawnt alle 35s");
				break;
			case 600:
				//sendMSGtoPlayers("TNT Spawnt alle 30s");
				break;
			case 500:
				//sendMSGtoPlayers("TNT Spawnt alle 25s");
				break;
			case 400:
				sendMSGtoPlayers("TNT Spawnt alle 20s");
				break;
			case 300:
				//sendMSGtoPlayers("TNT Spawnt alle 15s");
				break;
			case 200:
				sendMSGtoPlayers("TNT Spawnt alle 10s");
				break;
			default:
				break;
			}
			time -= 50;
		}

		Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "stnt");
	}
	
	void playAktivSound(boolean status) {
		Iterable<? extends Player> s = Bukkit.getOnlinePlayers();
		for (Player player : s) {
			if(status) {
				player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 2f, 2f);
			} else {
				player.playSound(player.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 2f, 2f);
			}
			
		}
	}

	void sendMSGtoPlayers(String msg) {
		Iterable<? extends Player> s = Bukkit.getOnlinePlayers();
		for (Player player : s) {
			player.sendMessage(Main.PLUGINNAME + " " + msg);
		}
	}

}
