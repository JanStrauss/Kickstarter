package me.simplex.pluginkickstarter.gui.util;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import me.simplex.pluginkickstarter.storage.CommandContainer;

public class CommandListCellItem_Unselected extends GraphicsPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lbCommandname;
	private JLabel lbCommandNameData;

	public CommandListCellItem_Unselected() {
		super(false,"/me/simplex/pluginkickstarter/gui/images/bg_task.png");
		initialize();
	}
	private void initialize() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setPreferredSize(new Dimension(700, 30));
		setMinimumSize(getPreferredSize());
		setMaximumSize(getPreferredSize());
		setLayout(null);
		add(getLbCommandname());
		add(getLbCommandNameData());
	}
	
	public void updateContent(CommandContainer c){
		lbCommandNameData.setText(c.getCommand());
	}

	private JLabel getLbCommandname() {
		if (lbCommandname == null) {
			lbCommandname = new JLabel("Command:");
			lbCommandname.setBounds(10, 0, 60, 30);
			lbCommandname.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		}
		return lbCommandname;
	}
	private JLabel getLbCommandNameData() {
		if (lbCommandNameData == null) {
			lbCommandNameData = new JLabel("");
			lbCommandNameData.setFont(new Font("Segoe UI", Font.BOLD, 11));
			lbCommandNameData.setBounds(80, 0, 560, 30);
		}
		return lbCommandNameData;
	}
}