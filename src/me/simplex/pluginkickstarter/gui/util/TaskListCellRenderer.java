package me.simplex.pluginkickstarter.gui.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import me.simplex.pluginkickstarter.storage.TaskContainer;

public class TaskListCellRenderer extends GraphicsPanel implements ListCellRenderer {
	private static final long serialVersionUID = 1L;
	private JLabel lbTaskname;
	private JLabel lbType;
	private JLabel lblRegisterOnStartup;
	private JLabel lbOffset;
	private JLabel lbDelay;
	private JLabel lbTaskNameData;
	private JLabel lbTypeData;
	private JLabel lbRegisterOnStartupData;
	private JLabel lbDelayData;
	private JLabel lbOffsetData;

	public TaskListCellRenderer() {
		super(false,"/me/simplex/pluginkickstarter/gui/images/bg_blank.png");
		initialize();
	}
	private void initialize() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		//this.setSize(500, 80);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 40, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lbTaskname = new GridBagConstraints();
		gbc_lbTaskname.insets = new Insets(0, 0, 5, 5);
		gbc_lbTaskname.gridx = 0;
		gbc_lbTaskname.gridy = 0;
		add(getLbTaskname(), gbc_lbTaskname);
		GridBagConstraints gbc_lbTaskNameData = new GridBagConstraints();
		gbc_lbTaskNameData.insets = new Insets(0, 0, 5, 5);
		gbc_lbTaskNameData.gridx = 1;
		gbc_lbTaskNameData.gridy = 0;
		add(getLbTaskNameData(), gbc_lbTaskNameData);
		GridBagConstraints gbc_lbType = new GridBagConstraints();
		gbc_lbType.anchor = GridBagConstraints.WEST;
		gbc_lbType.gridwidth = 2;
		gbc_lbType.insets = new Insets(0, 0, 5, 5);
		gbc_lbType.gridx = 3;
		gbc_lbType.gridy = 0;
		add(getLbType(), gbc_lbType);
		GridBagConstraints gbc_lbTypeData = new GridBagConstraints();
		gbc_lbTypeData.insets = new Insets(0, 0, 5, 5);
		gbc_lbTypeData.gridx = 5;
		gbc_lbTypeData.gridy = 0;
		add(getLbTypeData(), gbc_lbTypeData);
		GridBagConstraints gbc_lbDelay = new GridBagConstraints();
		gbc_lbDelay.anchor = GridBagConstraints.WEST;
		gbc_lbDelay.insets = new Insets(0, 0, 5, 5);
		gbc_lbDelay.gridx = 7;
		gbc_lbDelay.gridy = 0;
		add(getLbDelay(), gbc_lbDelay);
		GridBagConstraints gbc_lbDelayData = new GridBagConstraints();
		gbc_lbDelayData.insets = new Insets(0, 0, 5, 5);
		gbc_lbDelayData.gridx = 8;
		gbc_lbDelayData.gridy = 0;
		add(getLbDelayData(), gbc_lbDelayData);
		GridBagConstraints gbc_lblRegisterOnStartup = new GridBagConstraints();
		gbc_lblRegisterOnStartup.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblRegisterOnStartup.insets = new Insets(0, 0, 0, 5);
		gbc_lblRegisterOnStartup.gridx = 4;
		gbc_lblRegisterOnStartup.gridy = 1;
		add(getLblRegisterOnStartup(), gbc_lblRegisterOnStartup);
		GridBagConstraints gbc_lbRegisterOnStartupData = new GridBagConstraints();
		gbc_lbRegisterOnStartupData.insets = new Insets(0, 0, 0, 5);
		gbc_lbRegisterOnStartupData.gridx = 5;
		gbc_lbRegisterOnStartupData.gridy = 1;
		add(getLbRegisterOnStartupData(), gbc_lbRegisterOnStartupData);
		GridBagConstraints gbc_lbOffset = new GridBagConstraints();
		gbc_lbOffset.insets = new Insets(0, 0, 0, 5);
		gbc_lbOffset.anchor = GridBagConstraints.WEST;
		gbc_lbOffset.gridx = 7;
		gbc_lbOffset.gridy = 1;
		add(getLbOffset(), gbc_lbOffset);
		GridBagConstraints gbc_lbOffsetData = new GridBagConstraints();
		gbc_lbOffsetData.insets = new Insets(0, 0, 0, 5);
		gbc_lbOffsetData.gridx = 8;
		gbc_lbOffsetData.gridy = 1;
		add(getLbOffsetData(), gbc_lbOffsetData);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		if (isSelected) {
			setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255)), new EmptyBorder(10, 15, 10, 10)));
			changeBackground("/me/simplex/pluginkickstarter/gui/images/bg_sel.png");
			
		}
		else {
			setBorder(new EmptyBorder(10, 10, 10, 10));
			changeBackground("/me/simplex/pluginkickstarter/gui/images/bg_blank.png");
		}
			TaskContainer c = (TaskContainer)value;
			if (c.getType() != null) {
			lbTaskNameData.setText(c.getTaskname());
			lbTypeData.setText(c.getType().toString());
			lbDelayData.setText(""+c.getDelay());
			lbOffsetData.setText(""+c.getOffset());
			lbRegisterOnStartupData.setText(""+c.isRegisterAtOnEnable());
		}
		return this;
	}
	private JLabel getLbTaskname() {
		if (lbTaskname == null) {
			lbTaskname = new JLabel("Task:");
			lbTaskname.setFont(new Font("Segoe UI", Font.BOLD, 11));
		}
		return lbTaskname;
	}
	private JLabel getLbType() {
		if (lbType == null) {
			lbType = new JLabel("Type:");
			lbType.setFont(new Font("Segoe UI", Font.BOLD, 11));
		}
		return lbType;
	}
	private JLabel getLblRegisterOnStartup() {
		if (lblRegisterOnStartup == null) {
			lblRegisterOnStartup = new JLabel("Register on Startup:");
			lblRegisterOnStartup.setFont(new Font("Segoe UI", Font.BOLD, 11));
		}
		return lblRegisterOnStartup;
	}
	private JLabel getLbOffset() {
		if (lbOffset == null) {
			lbOffset = new JLabel("Offset:");
			lbOffset.setFont(new Font("Segoe UI", Font.BOLD, 11));
		}
		return lbOffset;
	}
	private JLabel getLbDelay() {
		if (lbDelay == null) {
			lbDelay = new JLabel("Delay:");
			lbDelay.setFont(new Font("Segoe UI", Font.BOLD, 11));
		}
		return lbDelay;
	}
	private JLabel getLbTaskNameData() {
		if (lbTaskNameData == null) {
			lbTaskNameData = new JLabel("");
		}
		return lbTaskNameData;
	}
	private JLabel getLbTypeData() {
		if (lbTypeData == null) {
			lbTypeData = new JLabel("");
		}
		return lbTypeData;
	}
	private JLabel getLbRegisterOnStartupData() {
		if (lbRegisterOnStartupData == null) {
			lbRegisterOnStartupData = new JLabel("");
		}
		return lbRegisterOnStartupData;
	}
	private JLabel getLbDelayData() {
		if (lbDelayData == null) {
			lbDelayData = new JLabel("");
		}
		return lbDelayData;
	}
	private JLabel getLbOffsetData() {
		if (lbOffsetData == null) {
			lbOffsetData = new JLabel("");
		}
		return lbOffsetData;
	}
}