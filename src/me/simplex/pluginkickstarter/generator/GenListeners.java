package me.simplex.pluginkickstarter.generator;

import java.util.ArrayList;

import me.simplex.pluginkickstarter.PluginKickstarter;
import me.simplex.pluginkickstarter.storage.ListenerContainer;
import me.simplex.pluginkickstarter.util.ListenerType;

public class GenListeners extends Generator {
	private ListenerType type;
	private ArrayList<ListenerContainer> listeners;

	public GenListeners(PluginKickstarter main, ListenerType type) {
		super(main);
		this.type = type;
		listeners = new ArrayList<ListenerContainer>();
		for (ListenerContainer c : main.getData().getListener()) {
			if (c.getFile().equals(type)) {
				listeners.add(c);
			}
		}
		System.out.println(type+" has to handle: "+listeners.size());
	}

	@Override
	public String buildClassname() {
		return "Listener_"+StringToClassName(type.toString());
	}

	public String buildImports() {
		String ret = "";
			for (ListenerContainer c : listeners) {
				if (c.getName().startsWith("onPaintingBreak")) {
					ret=ret+"import org.bukkit.event.painting.PaintingBreakEvent;\n";

				}
				else if (c.getName().startsWith("onPaintingPlace")) {
					ret=ret+"import org.bukkit.event.painting.PaintingPlaceEvent;\n";
				}
				else {
					ret=ret+"import org.bukkit.event."+c.getFile().toString().toLowerCase()+"."+c.getEvent()+";\n";
				}
			}
		return ret;
	}

	public String buildListeners() {
		String ret = "";
		for (ListenerContainer c : listeners) {
			ret=ret+"	@Override\n";
			ret=ret+"	public void "+c.getName()+"("+c.getEvent()+" event){"+"\n";
			ret=ret+"		// TODO handle that event\n";
			ret=ret+"	}\n\n";
		}
		return ret;
	}
	
	public String buildListenerImport(){
		switch (type) {
		case Block: return "import org.bukkit.event.block.BlockListener;\n";
		case Entity: return "import org.bukkit.event.entity.EntityListener;\n";
		case Inventory: return "import org.bukkit.event.inventory.InventoryListener;\n";
		case Player:  return "import org.bukkit.event.player.PlayerListener;\n";
		case Server: return "import org.bukkit.event.server.ServerListener;\n";
		case Vehicle: return "import org.bukkit.event.vehicle.VehicleListener;\n";
		case Weather: return "import org.bukkit.event.weather.WeatherListener;\n";
		case World: return "import org.bukkit.event.world.WorldListener;\n";
		}
		return "";
	}

	public CharSequence buildSuperclass() {
		switch (type) {
		case Block: return "BlockListener";
		case Entity: return "EntityListener";
		case Inventory: return "InventoryListener";
		case Player:  return "PlayerListener";
		case Server: return "ServerListener";
		case Vehicle: return "VehicleListener";
		case Weather: return "WeatherListener";
		case World: return "WorldListener";
		}
		return "";
	}
}