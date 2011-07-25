package me.simplex.pluginkickstarter.gui.util;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

import me.simplex.pluginkickstarter.storage.TaskContainer;

public class TaskListCellRenderer implements ListCellRenderer {
	private static final long serialVersionUID = 1L;
	private TaskListCellItem_Selected selectedItem;
	private TaskListCellItem_Unselected unselectedItem;

	public TaskListCellRenderer() {
		selectedItem = new TaskListCellItem_Selected();
		unselectedItem = new TaskListCellItem_Unselected();
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		
		TaskContainer c = (TaskContainer)value;
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