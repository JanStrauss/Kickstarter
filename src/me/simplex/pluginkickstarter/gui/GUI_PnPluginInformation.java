package me.simplex.pluginkickstarter.gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import me.simplex.pluginkickstarter.gui.util.EventTableModel;
import me.simplex.pluginkickstarter.util.ListenerType;

import javax.swing.JScrollPane;

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
	
	private JTable tblBlockEvents;
	private JTable tblEntityEvents;
	private JTable tblInventoryEvents;
	private JTable tblPlayerEvents;
	private JTable tblServerEvents;
	private JTable tblVehicleEvents;
	private JTable tblWeatherEvents;
	private JTable tblWorldEvents;
	
	private JScrollPane spBlock;
	private JScrollPane spPlayer;
	private JScrollPane spEntity;
	private JScrollPane spWorld;
	private JScrollPane spWeather;
	private JScrollPane spInventory;
	private JScrollPane spVehicle;
	private JScrollPane spServer;

	
	public GUI_PnPluginInformation(GUI_Main_Window GUI) {
		this.GUI = GUI;
		initialize();
	}
	private void initialize() {
		this.setSize(800, 333);
		setLayout(null);
		this.setEnabled(true);
		add(getTpPluginData());
	}
	private JTabbedPane getTpPluginData() {
		if (tpPluginData == null) {
			tpPluginData = new JTabbedPane(JTabbedPane.TOP);
			tpPluginData.setBounds(10, 11, 760, 299);
			tpPluginData.addTab("Events", null, getPnEvents(), null);
			tpPluginData.addTab("Commands", null, getPnCommands(), null);
			tpPluginData.addTab("Configuration", null, getPnConfiguration(), null);
			
		}
		return tpPluginData;
	}
	private JPanel getPnEvents() {
		if (pnEvents == null) {
			pnEvents = new JPanel();
			pnEvents.setLayout(new BorderLayout(0, 0));
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
	private JTable getTblBlockEvents() {
		if (tblBlockEvents == null) {
			tblBlockEvents = new JTable();
			tblBlockEvents.setModel(new EventTableModel(GUI.getMain().getListener_data().getListenerData(ListenerType.Block)));		
			
			tblBlockEvents.getTableHeader().setReorderingAllowed(false);
			tblBlockEvents.getTableHeader().setResizingAllowed(false);
			
			tblBlockEvents.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

			tblBlockEvents.getColumnModel().getColumn(0).setMinWidth(30);
			tblBlockEvents.getColumnModel().getColumn(0).setMaxWidth(30);
			
			tblBlockEvents.getColumnModel().getColumn(1).setMinWidth(150);
			tblBlockEvents.getColumnModel().getColumn(1).setMaxWidth(150);
			
		}
		return tblBlockEvents;
	}
	
	private JTable getTblEntityEvents() {
		if (tblEntityEvents == null) {
			tblEntityEvents = new JTable();
			tblEntityEvents.setModel(new EventTableModel(GUI.getMain().getListener_data().getListenerData(ListenerType.Entity)));		
			
			tblEntityEvents.getTableHeader().setReorderingAllowed(false);
			tblEntityEvents.getTableHeader().setResizingAllowed(false);
			
			tblEntityEvents.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

			tblEntityEvents.getColumnModel().getColumn(0).setMinWidth(30);
			tblEntityEvents.getColumnModel().getColumn(0).setMaxWidth(30);
			
			tblEntityEvents.getColumnModel().getColumn(1).setMinWidth(150);
			tblEntityEvents.getColumnModel().getColumn(1).setMaxWidth(150);
			
		}
		return tblEntityEvents;
	}
	
	private JTable getTblInventoryEvents() {
		if (tblInventoryEvents == null) {
			tblInventoryEvents = new JTable();
			tblInventoryEvents.setModel(new EventTableModel(GUI.getMain().getListener_data().getListenerData(ListenerType.Inventory)));		
			
			tblInventoryEvents.getTableHeader().setReorderingAllowed(false);
			tblInventoryEvents.getTableHeader().setResizingAllowed(false);
			
			tblInventoryEvents.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

			tblInventoryEvents.getColumnModel().getColumn(0).setMinWidth(30);
			tblInventoryEvents.getColumnModel().getColumn(0).setMaxWidth(30);
			
			tblInventoryEvents.getColumnModel().getColumn(1).setMinWidth(150);
			tblInventoryEvents.getColumnModel().getColumn(1).setMaxWidth(150);
			
		}
		return tblInventoryEvents;
	}
	
	private JTable getTblWeatherEvents() {
		if (tblWeatherEvents == null) {
			tblWeatherEvents = new JTable();
			tblWeatherEvents.setModel(new EventTableModel(GUI.getMain().getListener_data().getListenerData(ListenerType.Weather)));		
			
			tblWeatherEvents.getTableHeader().setReorderingAllowed(false);
			tblWeatherEvents.getTableHeader().setResizingAllowed(false);
			
			tblWeatherEvents.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

			tblWeatherEvents.getColumnModel().getColumn(0).setMinWidth(30);
			tblWeatherEvents.getColumnModel().getColumn(0).setMaxWidth(30);
			
			tblWeatherEvents.getColumnModel().getColumn(1).setMinWidth(150);
			tblWeatherEvents.getColumnModel().getColumn(1).setMaxWidth(150);
			
		}
		return tblWeatherEvents;
	}
	
	private JTable getTblWorldEvents() {
		if (tblWorldEvents == null) {
			tblWorldEvents = new JTable();
			tblWorldEvents.setModel(new EventTableModel(GUI.getMain().getListener_data().getListenerData(ListenerType.World)));		
			
			tblWorldEvents.getTableHeader().setReorderingAllowed(false);
			tblWorldEvents.getTableHeader().setResizingAllowed(false);
			
			tblWorldEvents.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

			tblWorldEvents.getColumnModel().getColumn(0).setMinWidth(30);
			tblWorldEvents.getColumnModel().getColumn(0).setMaxWidth(30);
			
			tblWorldEvents.getColumnModel().getColumn(1).setMinWidth(150);
			tblWorldEvents.getColumnModel().getColumn(1).setMaxWidth(150);
			
		}
		return tblWorldEvents;
	}
	
	private JTable getTblServerEvents() {
		if (tblServerEvents == null) {
			tblServerEvents = new JTable();
			tblServerEvents.setModel(new EventTableModel(GUI.getMain().getListener_data().getListenerData(ListenerType.Server)));		
			
			tblServerEvents.getTableHeader().setReorderingAllowed(false);
			tblServerEvents.getTableHeader().setResizingAllowed(false);
			
			tblServerEvents.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

			tblServerEvents.getColumnModel().getColumn(0).setMinWidth(30);
			tblServerEvents.getColumnModel().getColumn(0).setMaxWidth(30);
			
			tblServerEvents.getColumnModel().getColumn(1).setMinWidth(150);
			tblServerEvents.getColumnModel().getColumn(1).setMaxWidth(150);
			
		}
		return tblServerEvents;
	}
	
	private JTable getTblVehicleEvents() {
		if (tblVehicleEvents == null) {
			tblVehicleEvents = new JTable();
			tblVehicleEvents.setModel(new EventTableModel(GUI.getMain().getListener_data().getListenerData(ListenerType.Vehicle)));		
			
			tblVehicleEvents.getTableHeader().setReorderingAllowed(false);
			tblVehicleEvents.getTableHeader().setResizingAllowed(false);
			
			tblVehicleEvents.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

			tblVehicleEvents.getColumnModel().getColumn(0).setMinWidth(30);
			tblVehicleEvents.getColumnModel().getColumn(0).setMaxWidth(30);
			
			tblVehicleEvents.getColumnModel().getColumn(1).setMinWidth(150);
			tblVehicleEvents.getColumnModel().getColumn(1).setMaxWidth(150);
			
		}
		return tblVehicleEvents;
	}
	
	private JTable getTblPlayerEvents() {
		if (tblPlayerEvents == null) {
			tblPlayerEvents = new JTable();
			tblPlayerEvents.setModel(new EventTableModel(GUI.getMain().getListener_data().getListenerData(ListenerType.Player)));		
			
			tblPlayerEvents.getTableHeader().setReorderingAllowed(false);
			tblPlayerEvents.getTableHeader().setResizingAllowed(false);
			
			tblPlayerEvents.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

			tblPlayerEvents.getColumnModel().getColumn(0).setMinWidth(30);
			tblPlayerEvents.getColumnModel().getColumn(0).setMaxWidth(30);
			
			tblPlayerEvents.getColumnModel().getColumn(1).setMinWidth(150);
			tblPlayerEvents.getColumnModel().getColumn(1).setMaxWidth(150);
			
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
}
