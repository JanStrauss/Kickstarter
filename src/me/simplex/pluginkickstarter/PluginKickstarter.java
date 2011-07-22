package me.simplex.pluginkickstarter;

import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import me.simplex.pluginkickstarter.data.ListenerData;
import me.simplex.pluginkickstarter.gui.GUI_Main_Window;
import me.simplex.pluginkickstarter.storage.CommandStorage;

public class PluginKickstarter {
	private GUI_Main_Window GUI;
	private DataStorage data;
	private FileBuilder builder;
	private ListenerData listener_data;
	private final String VERSION = "0.0.1";

	public PluginKickstarter() {
		lookAndFeel();
		GUI = new GUI_Main_Window(this);
		data = new DataStorage();
		builder = new FileBuilder(this);
		listener_data = new ListenerData();
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
		data.getCommands().add(new CommandStorage("hurrdurr", aliases , "does supercool stuff uknow lol", "just type dad thing in lolyk"));
		System.out.println(builder.build_Plugin_Content());
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return VERSION;
	}

	/**
	 * @return the listener_data
	 */
	public ListenerData getListener_data() {
		return listener_data;
	}
}
