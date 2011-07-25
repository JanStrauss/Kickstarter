package me.simplex.pluginkickstarter.gui.util;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import me.simplex.pluginkickstarter.storage.CommandContainer;

public class CommandListCellItem_Selected extends GraphicsPanel{
	private static final long serialVersionUID = 1L;
	private JLabel lbCommandname;
	private JLabel lbAliases;
	private JLabel lpPlayerOnly;
	private JLabel lbCommandNameData;
	private JLabel lbAliasData;
	private JLabel lbPlayerOnlyData;
	private JLabel lbUsage;
	private JLabel lbUsageData;
	private JLabel lblDescription;
	private JLabel lbDescriptionData;

	public CommandListCellItem_Selected() {
		super(false, "/me/simplex/pluginkickstarter/gui/images/bg_task.png");
		initialize();
	}
	private void initialize() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setPreferredSize(new Dimension(700, 90));
		setMinimumSize(getPreferredSize());
		setMaximumSize(getPreferredSize());
		setLayout(null);
		add(getLbCommandname());
		add(getLbCommandNameData());
		add(getLbAliases());
		add(getLbAliasData());
		add(getLpPlayerOnly());
		add(getLbPlayerOnlyData());
		add(getLabel_1());
		add(getLabel_2());
		add(getLblDescription());
		add(getLbDescriptionData());
	}
	
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //setSize(100, 100); // doesn't change the bounds of the component
        //setBounds(0, 0, 100, 100); // this doesn't do any good either.
        g.fillRect(0, 0, getWidth(), getHeight());
}

	
	public void updateContent(CommandContainer c){
		String aliases="";
		for (String a : c.getAliases()) {
			aliases=aliases+a+" ";
		}
		aliases = aliases.trim().replace(" ", ",");
		lbCommandNameData.setText(c.getCommand());
		lbAliasData.setText("["+aliases+"]");
		lbDescriptionData.setText(c.getDescription());
		lbPlayerOnlyData.setText(""+c.isPlayerOnly());
		lbUsageData.setText(c.getUsage());
	}

	private JLabel getLbCommandname() {
		if (lbCommandname == null) {
			lbCommandname = new JLabel("Command:");
			lbCommandname.setBounds(10, 0, 70, 30);
			lbCommandname.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		}
		return lbCommandname;
	}
	
	private JLabel getLbAliases() {
		if (lbAliases == null) {
			lbAliases = new JLabel("Aliases:");
			lbAliases.setBounds(10, 30, 50, 30);
			lbAliases.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		}
		return lbAliases;
	}
	
	private JLabel getLpPlayerOnly() {
		if (lpPlayerOnly == null) {
			lpPlayerOnly = new JLabel("Player only:");
			lpPlayerOnly.setBounds(217, 30, 73, 30);
			lpPlayerOnly.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		}
		return lpPlayerOnly;
	}
	private JLabel getLbCommandNameData() {
		if (lbCommandNameData == null) {
			lbCommandNameData = new JLabel("");
			lbCommandNameData.setFont(new Font("Segoe UI", Font.BOLD, 11));
			lbCommandNameData.setBounds(80, 0, 560, 30);
		}
		return lbCommandNameData;
	}
	
	private JLabel getLbAliasData() {
		if (lbAliasData == null) {
			lbAliasData = new JLabel("[]");
			lbAliasData.setFont(new Font("Segoe UI", Font.BOLD, 11));
			lbAliasData.setBounds(70, 30, 120, 30);
		}
		return lbAliasData;
	}
	private JLabel getLbPlayerOnlyData() {
		if (lbPlayerOnlyData == null) {
			lbPlayerOnlyData = new JLabel("");
			lbPlayerOnlyData.setFont(new Font("Segoe UI", Font.BOLD, 11));
			lbPlayerOnlyData.setBounds(292, 30, 60, 30);
		}
		return lbPlayerOnlyData;
	}
	private JLabel getLabel_1() {
		if (lbUsage == null) {
			lbUsage = new JLabel("Usage:");
			lbUsage.setFont(new Font("Segoe UI", Font.PLAIN, 11));
			lbUsage.setBounds(362, 30, 46, 30);
		}
		return lbUsage;
	}
	private JLabel getLabel_2() {
		if (lbUsageData == null) {
			lbUsageData = new JLabel("/<command>");
			lbUsageData.setFont(new Font("Segoe UI", Font.BOLD, 11));
			lbUsageData.setBounds(418, 31, 270, 30);
		}
		return lbUsageData;
	}
	private JLabel getLblDescription() {
		if (lblDescription == null) {
			lblDescription = new JLabel("Description:");
			lblDescription.setFont(new Font("Segoe UI", Font.PLAIN, 11));
			lblDescription.setBounds(10, 60, 70, 30);
		}
		return lblDescription;
	}
	private JLabel getLbDescriptionData() {
		if (lbDescriptionData == null) {
			lbDescriptionData = new JLabel("");
			lbDescriptionData.setFont(new Font("Segoe UI", Font.BOLD, 11));
			lbDescriptionData.setBounds(80, 60, 620, 30);
		}
		return lbDescriptionData;
	}
}