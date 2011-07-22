package me.simplex.pluginkickstarter.gui.util;

import java.util.HashMap;

import javax.swing.table.AbstractTableModel;

public class EventTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private HashMap<Integer, Boolean> data;
	
	public EventTableModel() {
		data = new HashMap<Integer, Boolean>();
		data.put(0, true);
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
		return 3;
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
			return data.get(row);
		else if (col == 1)
			return "onPlayerInteract";
		else
			return "Fired when a player interacts with a block";
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		System.out.println("setVal");
		super.setValueAt(aValue, rowIndex, columnIndex);
		data.put(rowIndex, !((Boolean)data.get(rowIndex)));
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