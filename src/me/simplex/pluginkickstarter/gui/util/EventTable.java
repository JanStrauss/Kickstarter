package me.simplex.pluginkickstarter.gui.util;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import me.simplex.pluginkickstarter.gui.GUI_Main_Window;
import me.simplex.pluginkickstarter.util.ListenerType;
import me.simplex.pluginkickstarter.util.PriorityType;

public class EventTable extends JTable {
	private static final long serialVersionUID = 1L;
	private GUI_Main_Window GUI;
	
	public EventTable(ListenerType type, GUI_Main_Window gui) {
		super();
		this.GUI = gui;
		this.setModel(new EventTableModel(GUI.getMain().getListenerData().getDataByType(type),GUI));		
		
		this.getTableHeader().setReorderingAllowed(false);
		this.getTableHeader().setResizingAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		this.setRowHeight(25);

		this.getColumnModel().getColumn(0).setMinWidth(30);
		this.getColumnModel().getColumn(0).setMaxWidth(30);
		this.getColumnModel().getColumn(0).setCellRenderer(new TableCheckboxRenderer());
		
		this.getColumnModel().getColumn(1).setMinWidth(150);
		this.getColumnModel().getColumn(1).setMaxWidth(150);
		this.getColumnModel().getColumn(1).setCellRenderer(new TableLabelRenderer());
		
		this.getColumnModel().getColumn(2).setCellRenderer(new TableLabelRenderer());
		
		this.getColumnModel().getColumn(3).setMinWidth(65);
		this.getColumnModel().getColumn(3).setMaxWidth(65);
		this.getColumnModel().getColumn(3).setCellEditor(new TableComboBoxEditor(PriorityType.values()));
		this.getColumnModel().getColumn(3).setCellRenderer(new TableComboBoxRenderer(PriorityType.values()));
	}
}
