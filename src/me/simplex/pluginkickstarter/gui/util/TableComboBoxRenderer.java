package me.simplex.pluginkickstarter.gui.util;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import me.simplex.pluginkickstarter.util.PriorityType;

public class TableComboBoxRenderer extends JComboBox implements TableCellRenderer {
	private static final long serialVersionUID = 1L;
	
	public TableComboBoxRenderer(PriorityType[] priorityTypes) {
        super(priorityTypes);
    }
	
	@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        if (isSelected) {
//            setForeground(table.getSelectionForeground());
//            setBackground(table.getSelectionBackground());
//        } else {
//            setForeground(table.getForeground());
//            setBackground(table.getBackground());
//        }
        this.setSelectedItem(value);
        return this;
    }
}