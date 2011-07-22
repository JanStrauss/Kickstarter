package me.simplex.pluginkickstarter.gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import me.simplex.pluginkickstarter.gui.util.EventTableModel;

import javax.swing.JScrollPane;

public class GUI_PnPluginInformation extends JPanel {
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
	private JTable tblBlockEvents;
	private JScrollPane scrollPane;
	
	public GUI_PnPluginInformation() {
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
			tpEvents.addTab("Player events", null, getPnPlayerEvents(), null);
			tpEvents.addTab("Entity events", null, getPnEntityEvents(), null);
			tpEvents.addTab("World events", null, getPnWorldEvents(), null);
			tpEvents.addTab("Weather events", null, getPnWeatherEvents(), null);
			tpEvents.addTab("Inventory events", null, getPnInventoryEvents(), null);
		}
		return tpEvents;
	}
	private JPanel getPnPlayerEvents() {
		if (pnPlayerEvents == null) {
			pnPlayerEvents = new JPanel();
		}
		return pnPlayerEvents;
	}
	private JPanel getPnBlockEvents() {
		if (pnBlockEvents == null) {
			pnBlockEvents = new JPanel();
			pnBlockEvents.setLayout(new BorderLayout(0, 0));
			pnBlockEvents.add(getScrollPane(), BorderLayout.CENTER);
		}
		return pnBlockEvents;
	}
	private JPanel getPnEntityEvents() {
		if (pnEntityEvents == null) {
			pnEntityEvents = new JPanel();
		}
		return pnEntityEvents;
	}
	private JPanel getPnWorldEvents() {
		if (pnWorldEvents == null) {
			pnWorldEvents = new JPanel();
		}
		return pnWorldEvents;
	}
	private JPanel getPnWeatherEvents() {
		if (pnWeatherEvents == null) {
			pnWeatherEvents = new JPanel();
		}
		return pnWeatherEvents;
	}
	private JPanel getPnInventoryEvents() {
		if (pnInventoryEvents == null) {
			pnInventoryEvents = new JPanel();
		}
		return pnInventoryEvents;
	}
	private JTable getTblBlockEvents() {
		if (tblBlockEvents == null) {
			tblBlockEvents = new JTable();
			tblBlockEvents.setModel(new EventTableModel());		
			
			//tblBlockEvents.setDefaultRenderer(Boolean.class, new EventTableCellRenderer_Boolean());
			//
			
			tblBlockEvents.getTableHeader().setReorderingAllowed(false);
			tblBlockEvents.getTableHeader().setResizingAllowed(false);
			
			tblBlockEvents.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

			tblBlockEvents.getColumnModel().getColumn(0).setMinWidth(30);
			tblBlockEvents.getColumnModel().getColumn(0).setMaxWidth(30);
			
			tblBlockEvents.getColumnModel().getColumn(1).setMinWidth(200);
			tblBlockEvents.getColumnModel().getColumn(1).setMaxWidth(200);
			
		}
		return tblBlockEvents;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTblBlockEvents());
		}
		return scrollPane;
	}
}
