package me.simplex.pluginkickstarter.test;

import me.simplex.pluginkickstarter.test.commands.Commandexe;

import org.bukkit.entity.Player;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;

public class PluginMainDummy extends JavaPlugin {
	private Configuration configuration;

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onEnable() {
		//this.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, task, delay, period);
		getCommand("test").setExecutor(new Commandexe(this));
		getServer().getPluginManager().registerEvent(Type.PLAYER_INTERACT, null, Priority.Normal, this);
		configuration = setupConfig();
		
		//TemplateType.Command.toString()
	}
    
	public boolean checkPermissions(Player player, String node){
		return player.hasPermission(node);
	}
	
	public Configuration getConfiguration(){
		return configuration;
	}
	
	private Configuration setupConfig(){
		Configuration cfg = getConfiguration();
		
		cfg.setHeader("# HURR");
		
		cfg.getBoolean("i.leik.turtles", false);

		cfg.save();
		return cfg;
	}
}
