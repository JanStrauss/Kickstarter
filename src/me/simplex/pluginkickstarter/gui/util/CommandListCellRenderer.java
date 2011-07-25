package me.simplex.pluginkickstarter.gui.util;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

import me.simplex.pluginkickstarter.storage.CommandContainer;

public class CommandListCellRenderer implements ListCellRenderer {
	private static final long serialVersionUID = 1L;
	private CommandListCellItem_Selected selectedItem;
	private CommandListCellItem_Unselected unselectedItem;

	public CommandListCellRenderer() {
		selectedItem = new CommandListCellItem_Selected();
		unselectedItem = new CommandListCellItem_Unselected();
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		CommandContainer c = (CommandContainer)value;
		if (index == list.getSelectedIndex()) {
			selectedItem.updateContent(c);
			return selectedItem;
		}
		else {
			unselectedItem.updateContent(c);
			return unselectedItem;
		}
	}
}