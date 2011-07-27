package me.simplex.pluginkickstarter.gui.util;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import me.simplex.pluginkickstarter.storage.ConfigurationNodeContainer;

public class ConfigNodeListCellItem_Unselected extends GraphicsPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lbNode;
	private JLabel lbNodeData;

	public ConfigNodeListCellItem_Unselected() {
		super(false,"/me/simplex/pluginkickstarter/gui/images/bg_task.png");
		initialize();
	}
	private void initialize() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setPreferredSize(new Dimension(700, 30));
		setMinimumSize(getPreferredSize());
		setMaximumSize(getPreferredSize());
		setLayout(null);
		add(getLbNode());
		add(getLbNodeData());
	}
	
	public void updateContent(ConfigurationNodeContainer c){
		lbNodeData.setText(c.getNode());
	}

	private JLabel getLbNode() {
		if (lbNode == null) {
			lbNode = new JLabel("Node:");
			lbNode.setBounds(10, 0, 60, 30);
			lbNode.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		}
		return lbNode;
	}
	private JLabel getLbNodeData() {
		if (lbNodeData == null) {
			lbNodeData = new JLabel("");
			lbNodeData.setFont(new Font("Segoe UI", Font.BOLD, 11));
			lbNodeData.setBounds(52, 0, 560, 30);
		}
		return lbNodeData;
	}
}