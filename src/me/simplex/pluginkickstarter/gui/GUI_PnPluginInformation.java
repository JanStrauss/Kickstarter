package me.simplex.pluginkickstarter.gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import me.simplex.pluginkickstarter.gui.util.EventTable;
import me.simplex.pluginkickstarter.util.ListenerType;

public class GUI_PnPluginInformation extends JPanel {
	private GUI_Main_Window GUI;
	private static final long serialVersionUID = 1L;
	private JTabbedPane tpPluginData;
	private JPanel pnEvents;
	private JPanel pnCommands;
	private JPanel pnConfiguration;
	
	private JTabbedPane tpEvents;
	
	private JPanel pnPlayerEvents;
	private JPanel pnBlockEvents;
	private JPanel pnEntityEvents;
	private JPanel pnWorldEvents;
	private JPanel pnWeatherEvents;
	private JPanel pnInventoryEvents;
	private JPanel pnVehicleEvents;
	private JPanel pnServerEvents;
	
	private EventTable tblBlockEvents;
	private EventTable tblEntityEvents;
	private EventTable tblInventoryEvents;
	private EventTable tblPlayerEvents;
	private EventTable tblServerEvents;
	private EventTable tblVehicleEvents;
	private EventTable tblWeatherEvents;
	private EventTable tblWorldEvents;
	
	private JScrollPane spBlock;
	private JScrollPane spPlayer;
	private JScrollPane spEntity;
	private JScrollPane spWorld;
	private JScrollPane spWeather;
	private JScrollPane spInventory;
	private JScrollPane spVehicle;
	private JScrollPane spServer;
	private JLabel lblSelectTheEvents;
	private JPanel pnTasks;
		
	public GUI_PnPluginInformation(GUI_Main_Window GUI) {
		this.GUI = GUI;
		initialize();
	}
	private void initialize() {
		this.setSize(800, 372);
		setLayout(null);
		this.setEnabled(true);
		add(getTpPluginData());
	}
	private JTabbedPane getTpPluginData() {
		if (tpPluginData == null) {
			tpPluginData = new JTabbedPane(JTabbedPane.TOP);
			tpPluginData.setBounds(10, 11, 780, 349);
			tpPluginData.addTab("Events", null, getPnEvents(), null);
			tpPluginData.addTab("Commands", null, getPnCommands(), null);
			tpPluginData.addTab("Configuration", null, getPnConfiguration(), null);
			tpPluginData.addTab("Tasks", null, getPnTasks(), null);
		}
		return tpPluginData;
	}
	
	private JPanel getPnEvents() {
		if (pnEvents == null) {
			pnEvents = new JPanel();
			pnEvents.setLayout(new BorderLayout(0, 0));
			pnEvents.add(getLblSelectTheEvents(), BorderLayout.NORTH);
			pnEvents.add(getTpEvents());
		}
		return pnEvents;
	}
	private JPanel getPnCommands() {
		if (pnCommands == null) {
			pnCommands = new JPanel();
		}
		return pnCommands;
	}
	private JPanel getPnConfiguration() {
		if (pnConfiguration == null) {
			pnConfiguration = new JPanel();
			pnConfiguration.setEnabled(false);
		}
		return pnConfiguration;
	}
	private JTabbedPane getTpEvents() {
		if (tpEvents == null) {
			tpEvents = new JTabbedPane(JTabbedPane.TOP);
			tpEvents.setBorder(new EmptyBorder(5, 5, 5, 5));
			tpEvents.addTab("Block events", null, getPnBlockEvents(), null);
			tpEvents.addTab("Entity events", null, getPnEntityEvents(), null);
			tpEvents.addTab("Inventory events", null, getPnInventoryEvents(), null);
			tpEvents.addTab("Player events", null, getPnPlayerEvents(), null);
			tpEvents.addTab("Server events", null, getPnVehicleEvents(), null);
			tpEvents.addTab("Vehicle events", null, getPnServerEvents(), null);
			tpEvents.addTab("Weather events", null, getPnWeatherEvents(), null);
			tpEvents.addTab("World events", null, getPnWorldEvents(), null);
		}
		return tpEvents;
	}
	private JPanel getPnPlayerEvents() {
		if (pnPlayerEvents == null) {
			pnPlayerEvents = new JPanel();
			pnPlayerEvents.setLayout(new BorderLayout(0, 0));
			pnPlayerEvents.add(getSpPlayer(), BorderLayout.CENTER);
		}
		return pnPlayerEvents;
	}
	private JPanel getPnBlockEvents() {
		if (pnBlockEvents == null) {
			pnBlockEvents = new JPanel();
			pnBlockEvents.setLayout(new BorderLayout(0, 0));
			pnBlockEvents.add(getSpBlock(), BorderLayout.CENTER);
		}
		return pnBlockEvents;
	}
	private JPanel getPnEntityEvents() {
		if (pnEntityEvents == null) {
			pnEntityEvents = new JPanel();
			pnEntityEvents.setLayout(new BorderLayout(0, 0));
			pnEntityEvents.add(getSpEntity(), BorderLayout.CENTER);
		}
		return pnEntityEvents;
	}
	private JPanel getPnWorldEvents() {
		if (pnWorldEvents == null) {
			pnWorldEvents = new JPanel();
			pnWorldEvents.setLayout(new BorderLayout(0, 0));
			pnWorldEvents.add(getSpWorld(), BorderLayout.CENTER);
		}
		return pnWorldEvents;
	}
	private JPanel getPnWeatherEvents() {
		if (pnWeatherEvents == null) {
			pnWeatherEvents = new JPanel();
			pnWeatherEvents.setLayout(new BorderLayout(0, 0));
			pnWeatherEvents.add(getSpWeather(), BorderLayout.CENTER);
		}
		return pnWeatherEvents;
	}
	private JPanel getPnInventoryEvents() {
		if (pnInventoryEvents == null) {
			pnInventoryEvents = new JPanel();
			pnInventoryEvents.setLayout(new BorderLayout(0, 0));
			pnInventoryEvents.add(getSpInventory(), BorderLayout.CENTER);
		}
		return pnInventoryEvents;
	}
	private EventTable getTblBlockEvents() {
		if (tblBlockEvents == null) {
			tblBlockEvents = new EventTable(ListenerType.Block, GUI);
		}
		return tblBlockEvents;
	}
	
	private EventTable getTblEntityEvents() {
		if (tblEntityEvents == null) {
			tblEntityEvents = new EventTable(ListenerType.Entity, GUI);
		}
		return tblEntityEvents;
	}
	
	private EventTable getTblInventoryEvents() {
		if (tblInventoryEvents == null) {
			tblInventoryEvents = new EventTable(ListenerType.Inventory, GUI);
		}
		return tblInventoryEvents;
	}
	
	private EventTable getTblWeatherEvents() {
		if (tblWeatherEvents == null) {
			tblWeatherEvents = new EventTable(ListenerType.Weather, GUI);
		}
		return tblWeatherEvents;
	}
	
	private EventTable getTblWorldEvents() {
		if (tblWorldEvents == null) {
			tblWorldEvents = new EventTable(ListenerType.World, GUI);
		}
		return tblWorldEvents;
	}
	
	private EventTable getTblServerEvents() {
		if (tblServerEvents == null) {
			tblServerEvents = new EventTable(ListenerType.Server, GUI);
		}
		return tblServerEvents;
	}
	
	private EventTable getTblVehicleEvents() {
		if (tblVehicleEvents == null) {
			tblVehicleEvents = new EventTable(ListenerType.Vehicle, GUI);
		}
		return tblVehicleEvents;
	}
	
	private EventTable getTblPlayerEvents() {
		if (tblPlayerEvents == null) {
			tblPlayerEvents = new EventTable(ListenerType.Player, GUI);
		}
		return tblPlayerEvents;
	}
	
	private JScrollPane getSpBlock() {
		if (spBlock == null) {
			spBlock = new JScrollPane();
			spBlock.setViewportView(getTblBlockEvents());
		}
		return spBlock;
	}
	private JPanel getPnVehicleEvents() {
		if (pnVehicleEvents == null) {
			pnVehicleEvents = new JPanel();
			pnVehicleEvents.setLayout(new BorderLayout(0, 0));
			pnVehicleEvents.add(getSpVehicle(), BorderLayout.CENTER);
		}
		return pnVehicleEvents;
	}
	private JPanel getPnServerEvents() {
		if (pnServerEvents == null) {
			pnServerEvents = new JPanel();
			pnServerEvents.setLayout(new BorderLayout(0, 0));
			pnServerEvents.add(getSpServer(), BorderLayout.NORTH);
		}
		return pnServerEvents;
	}
	private JScrollPane getSpPlayer() {
		if (spPlayer == null) {
			spPlayer = new JScrollPane();
			spPlayer.setViewportView(getTblPlayerEvents());
		}
		return spPlayer;
	}
	private JScrollPane getSpEntity() {
		if (spEntity == null) {
			spEntity = new JScrollPane();
			spEntity.setViewportView(getTblEntityEvents());
		}
		return spEntity;
	}
	private JScrollPane getSpWorld() {
		if (spWorld == null) {
			spWorld = new JScrollPane();
			spWorld.setViewportView(getTblWorldEvents());
		}
		return spWorld;
	}
	private JScrollPane getSpWeather() {
		if (spWeather == null) {
			spWeather = new JScrollPane();
			spWeather.setViewportView(getTblWeatherEvents());
		}
		return spWeather;
	}
	private JScrollPane getSpInventory() {
		if (spInventory == null) {
			spInventory = new JScrollPane();
			spInventory.setViewportView(getTblInventoryEvents());
		}
		return spInventory;
	}
	private JScrollPane getSpVehicle() {
		if (spVehicle == null) {
			spVehicle = new JScrollPane();
			spVehicle.setViewportView(getTblVehicleEvents());
		}
		return spVehicle;
	}
	private JScrollPane getSpServer() {
		if (spServer == null) {
			spServer = new JScrollPane();
			spServer.setViewportView(getTblServerEvents());
		}
		return spServer;
	}
	private JLabel getLblSelectTheEvents() {
		if (lblSelectTheEvents == null) {
			lblSelectTheEvents = new JLabel("Select the events you want to listen to.");
			lblSelectTheEvents.setBorder(new EmptyBorder(5, 5, 5, 0));
		}
		return lblSelectTheEvents;
	}
	private JPanel getPnTasks() {
		if (pnTasks == null) {
			pnTasks = new JPanel();
		}
		return pnTasks;
	}
}
