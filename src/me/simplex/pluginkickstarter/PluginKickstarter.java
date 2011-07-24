package me.simplex.pluginkickstarter;

import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import me.simplex.pluginkickstarter.gui.GUI_Main_Window;
import me.simplex.pluginkickstarter.storage.CommandContainer;
import me.simplex.pluginkickstarter.storage.ListenerData;
import me.simplex.pluginkickstarter.util.ListenerType;

public class PluginKickstarter {
	private GUI_Main_Window GUI;
	private DataStorage data;
	private FileBuilder builder;
	private ListenerData listener_data;
	private final String VERSION = "0.0.1 PREALPHA";

	public PluginKickstarter() {
		lookAndFeel();
		data = new DataStorage();
		builder = new FileBuilder(this);
		listener_data = new ListenerData();
		GUI = new GUI_Main_Window(this);
		
		//test();
	}
	
	public static void main(String[] args) {
		new PluginKickstarter();
	}
	
	public GUI_Main_Window getGUI() {
		return GUI;
	}

	public DataStorage getData() {
		return data;
	}
	
	private void lookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	
	public void test(){
		data.setAuthor("simplex");
		data.setPluginname("Testplugin");
		data.setVersion("0.1.3.3.7");
		data.setWebsite("http://derp.over9000.eu");
		data.setDescription("awesome testplugin");
		ArrayList<String> aliases = new ArrayList<String>();
		aliases.add("derp");
		aliases.add("herp");
		data.getCommands().add(new CommandContainer("hurrdurr"));
		System.out.println(builder.build_Plugin_File());
	}
	
	public void buildPlugin(){
		data.getBuildFiles().clear();
		// plugin.yml
		data.getBuildFiles().add(builder.build_Plugin_File());
		
		// commandExecutors
		for (CommandContainer c : data.getCommands()) {
			data.getBuildFiles().add(builder.build_Command_File(c));
		}
		// listeners
		for (ListenerType type: ListenerType.values()) {
			data.getBuildFiles().add(builder.build_Listener_File(type));
		}
		data.removeNullListener();
		
		// tasks
		
		//<Pluginname>.java
		data.getBuildFiles().add(builder.build_MainClass_File());
	}

	public String getVersion() {
		return VERSION;
	}

	public ListenerData getListenerData() {
		return listener_data;
	}
}
