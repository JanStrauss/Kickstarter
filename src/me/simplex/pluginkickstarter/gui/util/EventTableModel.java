package me.simplex.pluginkickstarter.gui.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import me.simplex.pluginkickstarter.gui.GUI_Main_Window;
import me.simplex.pluginkickstarter.storage.ListenerContainer;
import me.simplex.pluginkickstarter.util.PriorityType;

public class EventTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private ArrayList<ListenerContainer> container;
	private int rows;
	private GUI_Main_Window gui;
	
	public EventTableModel(ArrayList<ListenerContainer> listener, GUI_Main_Window gui) {
		rows = listener.size();
		container = listener;
		this.gui = gui;
	}
	
	@SuppressWarnings("unchecked")
	public Class getColumnClass(int columnIndex)
	{
		if (columnIndex == 0){
			return Boolean.class;
		}
		else if (columnIndex == 3) {
			return PriorityType.class;
		}
		else{
			return String.class;
		}
	}

	public int getRowCount() {
		return rows;
	}

	public int getColumnCount() {
		return 4;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 0 || columnIndex == 3) {
			return true;
		}
		return false;
	}

	public Object getValueAt(int row, int col) {
		if (col == 0){
			return container.get(row).isSelected();
		}
		else if (col == 1){
			return "  "+container.get(row).getName();
		}
		else if(col == 2) {
			return "  "+container.get(row).getDesc();
		}
		else {
			return container.get(row).getPriority();
		}
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			container.get(rowIndex).setSelected(!container.get(rowIndex).isSelected());
			gui.getMain().getData().toggleListener(container.get(rowIndex));
		}
		else {
			PriorityType prio = ((PriorityType)aValue);
			container.get(rowIndex).setPriority(prio);
		}
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0: return "Use";
		case 1: return "Name";
		case 2: return "Description";
		case 3: return "Priority";
		default: return "derp";
		}
	}
	
	public boolean isRowChecked(int row){
		return container.get(row).isSelected();
	}
}