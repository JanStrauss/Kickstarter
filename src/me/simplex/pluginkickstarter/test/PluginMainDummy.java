package me.simplex.pluginkickstarter.test;

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
		getCommand("test").setExecutor(new Commandexe());
		getServer().getPluginManager().registerEvent(Type.PLAYER_INTERACT, null, Priority.Normal, this);
	}
}
