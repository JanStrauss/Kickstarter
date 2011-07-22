package me.simplex.pluginkickstarter.gui.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import me.simplex.pluginkickstarter.data.ListenerContainer;

public class EventTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private ArrayList<ListenerContainer> container;
	private int rows;
	
	public EventTableModel(ArrayList<ListenerContainer> listener) {
		rows = listener.size();
		container = listener;
	}
	
	@SuppressWarnings("unchecked")
	public Class getColumnClass(int columnIndex)
	{
		if (columnIndex == 0)
			return Boolean.class;
		else{
			return String.class;
		}
	}

	public int getRowCount() {
		return rows;
	}

	public int getColumnCount() {
		return 3;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return true;
		}
		return false;
	}

	public Object getValueAt(int row, int col) {
		if (col == 0)
			return container.get(row).isSelected();
		else if (col == 1)
			return "  "+container.get(row).getName();
		else
			return "  "+container.get(row).getDesc();
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
		container.get(rowIndex).setSelected(!container.get(rowIndex).isSelected());
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0: return "Use";
		case 1: return "Name";
		case 2: return "Description";
		default: return "derp";
		}
	}
}