package me.simplex.pluginkickstarter.gui.util;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import me.simplex.pluginkickstarter.storage.ConfigurationNodeContainer;

public class ConfigNodeListCellItem_Selected extends GraphicsPanel{
	private static final long serialVersionUID = 1L;
	private JLabel lbNode;
	private JLabel lbType;
	private JLabel lbDefault;
	private JLabel lbNodeData;
	private JLabel lbTypeData;
	private JLabel lbDefaultData;

	public ConfigNodeListCellItem_Selected() {
		super(false, "/me/simplex/pluginkickstarter/gui/images/bg_task.png");
		initialize();
	}
	private void initialize() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setPreferredSize(new Dimension(700, 60));
		setMinimumSize(getPreferredSize());
		setMaximumSize(getPreferredSize());
		setLayout(null);
		add(getLbNode());
		add(getLbNodeData());
		add(getLbType());
		add(getLbTypeData());
		add(getLbDefault());
		add(getLbDefaultData());
	}
	
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //setSize(100, 100); // doesn't change the bounds of the component
        //setBounds(0, 0, 100, 100); // this doesn't do any good either.
        g.fillRect(0, 0, getWidth(), getHeight());
}

	
	public void updateContent(ConfigurationNodeContainer c){
		lbNodeData.setText(c.getNode());
		lbDefaultData.setText(c.getDefaultValue());
		lbTypeData.setText(c.getType().toString());
	}

	private JLabel getLbNode() {
		if (lbNode == null) {
			lbNode = new JLabel("Node: ");
			lbNode.setBounds(10, 0, 70, 30);
			lbNode.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		}
		return lbNode;
	}
	
	private JLabel getLbType() {
		if (lbType == null) {
			lbType = new JLabel("Type:");
			lbType.setBounds(10, 30, 50, 30);
			lbType.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		}
		return lbType;
	}
	
	private JLabel getLbDefault() {
		if (lbDefault == null) {
			lbDefault = new JLabel("Default value:");
			lbDefault.setBounds(189, 30, 73, 30);
			lbDefault.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		}
		return lbDefault;
	}
	private JLabel getLbNodeData() {
		if (lbNodeData == null) {
			lbNodeData = new JLabel("");
			lbNodeData.setFont(new Font("Segoe UI", Font.BOLD, 11));
			lbNodeData.setBounds(51, 0, 560, 30);
		}
		return lbNodeData;
	}
	
	private JLabel getLbTypeData() {
		if (lbTypeData == null) {
			lbTypeData = new JLabel("");
			lbTypeData.setFont(new Font("Segoe UI", Font.BOLD, 11));
			lbTypeData.setBounds(45, 30, 120, 30);
		}
		return lbTypeData;
	}
	private JLabel getLbDefaultData() {
		if (lbDefaultData == null) {
			lbDefaultData = new JLabel("");
			lbDefaultData.setFont(new Font("Segoe UI", Font.BOLD, 11));
			lbDefaultData.setBounds(272, 30, 428, 30);
		}
		return lbDefaultData;
	}
}