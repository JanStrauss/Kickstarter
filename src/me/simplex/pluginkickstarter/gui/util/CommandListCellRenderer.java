package me.simplex.pluginkickstarter.gui.util;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import me.simplex.pluginkickstarter.storage.CommandContainer;

public class CommandListCellRenderer extends DefaultListCellRenderer {
	private static final long serialVersionUID = 1L;

	public CommandListCellRenderer() {
		super();
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		setText("  "+((CommandContainer)value).getCommand());
		repaint();
		return this;
	}
}