package me.simplex.pluginkickstarter.gui.util;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

import me.simplex.pluginkickstarter.util.PriorityType;

public class TableComboBoxEditor extends DefaultCellEditor {
	private static final long serialVersionUID = 1L;
	public TableComboBoxEditor(PriorityType[] priorityTypes) {
        super(new JComboBox(priorityTypes));
    }
}