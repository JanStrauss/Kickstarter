package me.simplex.pluginkickstarter.gui.util;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableLabelRenderer extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;
	
	public TableLabelRenderer() {
        super();
    }
	
	@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		boolean isChecked = ((EventTableModel)table.getModel()).isRowChecked(row);
        if (isSelected) {
        	this.setForeground(table.getSelectionForeground());
        	this.setBackground(table.getSelectionBackground());
        } else {
        	if (isChecked) {
        		this.setForeground(table.getForeground());
        		this.setBackground(new Color(120, 195, 230));
			}
        	else {
        		this.setForeground(table.getForeground());
        		this.setBackground(table.getBackground());
			}
        }
        setValue(value);
        return this;
    }
}