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
			ret=ret+"import org.bukkit.event."+c.getFile().toString().toLowerCase()+"."+c.getEvent()+";\n";
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
}