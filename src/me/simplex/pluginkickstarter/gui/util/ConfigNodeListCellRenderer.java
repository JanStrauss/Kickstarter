package me.simplex.pluginkickstarter.gui.util;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

import me.simplex.pluginkickstarter.storage.ConfigurationNodeContainer;

public class ConfigNodeListCellRenderer implements ListCellRenderer {
	private static final long serialVersionUID = 1L;
	private ConfigNodeListCellItem_Selected selectedItem;
	private ConfigNodeListCellItem_Unselected unselectedItem;

	public ConfigNodeListCellRenderer() {
		selectedItem = new ConfigNodeListCellItem_Selected();
		unselectedItem = new ConfigNodeListCellItem_Unselected();
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		ConfigurationNodeContainer c = (ConfigurationNodeContainer)value;
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