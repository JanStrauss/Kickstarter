package me.simplex.pluginkickstarter.gui;

import java.awt.Component;
import javax.swing.*;
import javax.swing.table.TableCellEditor;

public class EventTableCellEditor extends AbstractCellEditor implements TableCellEditor {
	private static final long serialVersionUID = 1L;
	private JCheckBox component = new JCheckBox();

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int rowIndex, int colIndex) {
		component.setSelected(!component.isSelected());
		return component;
	}

	@Override
	public Object getCellEditorValue() {
		return component;
	}
}