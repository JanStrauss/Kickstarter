package me.simplex.pluginkickstarter.test;

import me.simplex.pluginkickstarter.test.commands.Commandexe;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginMainDummy extends JavaPlugin {

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onEnable() {
		//this.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, task, delay, period);
		getCommand("test").setExecutor(new Commandexe(this));
		getServer().getPluginManager().registerEvent(Type.PLAYER_INTERACT, null, Priority.Normal, this);
		
	}
    
	public boolean checkPermissions(Player player, String node){
		return player.hasPermission(node);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().toLowerCase().equals("$command")) {
			//TODO: Command $command
			return true;
		}
		return false;
	}
}
