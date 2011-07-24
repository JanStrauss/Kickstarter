package me.simplex.pluginkickstarter.test.commands;

import me.simplex.pluginkickstarter.test.PluginMainDummy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandexe implements CommandExecutor {
	private PluginMainDummy plugin;
	
	public Commandexe() {
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Y U NO PLAYER??!111");
			return true;
		}

		return false;
	}

}
