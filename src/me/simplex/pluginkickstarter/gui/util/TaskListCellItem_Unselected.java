package me.simplex.pluginkickstarter.gui.util;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import me.simplex.pluginkickstarter.storage.TaskContainer;

public class TaskListCellItem_Unselected extends GraphicsPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lbTaskname;
	private JLabel lbTaskNameData;

	public TaskListCellItem_Unselected() {
		super(false,"/me/simplex/pluginkickstarter/gui/images/bg_task.png");
		initialize();
	}
	private void initialize() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setPreferredSize(new Dimension(700, 30));
		setMinimumSize(getPreferredSize());
		setMaximumSize(getPreferredSize());
		setLayout(null);
		add(getLbTaskname());
		add(getLbTaskNameData());
	}
	
	public void updateContent(TaskContainer c){
		lbTaskNameData.setText(c.getTaskname());
	}

	private JLabel getLbTaskname() {
		if (lbTaskname == null) {
			lbTaskname = new JLabel("Task:");
			lbTaskname.setBounds(10, 0, 50, 30);
			lbTaskname.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		}
		return lbTaskname;
	}
	private JLabel getLbTaskNameData() {
		if (lbTaskNameData == null) {
			lbTaskNameData = new JLabel("");
			lbTaskNameData.setFont(new Font("Segoe UI", Font.BOLD, 11));
			lbTaskNameData.setBounds(50, 0, 590, 30);
		}
		return lbTaskNameData;
	}
}