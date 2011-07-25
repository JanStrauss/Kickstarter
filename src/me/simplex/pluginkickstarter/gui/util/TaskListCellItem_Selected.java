package me.simplex.pluginkickstarter.gui.util;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import me.simplex.pluginkickstarter.storage.TaskContainer;

public class TaskListCellItem_Selected extends GraphicsPanel{
	private static final long serialVersionUID = 1L;
	private JLabel lbTaskname;
	private JLabel lbType;
	private JLabel lblRegisterOnStartup;
	private JLabel lbPeriod;
	private JLabel lbDelay;
	private JLabel lbTaskNameData;
	private JLabel lbTypeData;
	private JLabel lbRegisterOnStartupData;
	private JLabel lbDelayData;
	private JLabel lbPeriodData;
	private JLabel label;

	public TaskListCellItem_Selected() {
		super(false, "/me/simplex/pluginkickstarter/gui/images/bg_task.png");
		initialize();
	}
	private void initialize() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setPreferredSize(new Dimension(700, 60));
		setMinimumSize(getPreferredSize());
		setMaximumSize(getPreferredSize());
		setLayout(null);
		add(getLbTaskname());
		add(getLbTaskNameData());
		add(getLbType());
		add(getLbTypeData());
		add(getLbDelay());
		add(getLbDelayData());
		add(getLblRegisterOnStartup());
		add(getLbRegisterOnStartupData());
		add(getLbPeriod());
		add(getLbPeriodData());
		add(getLabel());
	}
	
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //setSize(100, 100); // doesn't change the bounds of the component
        //setBounds(0, 0, 100, 100); // this doesn't do any good either.
        g.fillRect(0, 0, getWidth(), getHeight());
}

	
	public void updateContent(TaskContainer c){
		lbTaskNameData.setText(c.getTaskname());
		lbTypeData.setText(c.getType().toString());
		lbDelayData.setText(""+c.getDelay());
		lbPeriodData.setText(""+c.getPeriod());
		lbRegisterOnStartupData.setText(""+c.isRegisterAtOnEnable());
		
		switch (c.getType()) {
		case AsyncDelayedTask: 
			lbDelayData.setVisible(true);
			lbDelay.setVisible(true);
			
			lbPeriodData.setVisible(false);
			lbPeriod.setVisible(false);
			break;
		case AsyncRepeatingTask:
			lbDelayData.setVisible(true);
			lbDelay.setVisible(true);
			
			lbPeriodData.setVisible(true);
			lbPeriod.setVisible(true);
			break;
		case AsyncTask:
			lbDelayData.setVisible(false);
			lbDelay.setVisible(false);
			
			lbPeriodData.setVisible(false);
			lbPeriod.setVisible(false);
			break;
		case SyncDelayedTask:
			lbDelayData.setVisible(true);
			lbDelay.setVisible(true);
			
			lbPeriodData.setVisible(false);
			lbPeriod.setVisible(false);
			break;
		case SyncRepeatingTask: 
			lbDelayData.setVisible(true);
			lbDelay.setVisible(true);
			
			lbPeriodData.setVisible(true);
			lbPeriod.setVisible(true);
			break;
		case SyncTask: 
			lbDelayData.setVisible(false);
			lbDelay.setVisible(false);
			
			lbPeriodData.setVisible(false);
			lbPeriod.setVisible(false);
			break;
		default:break;
		}
	}

	private JLabel getLbTaskname() {
		if (lbTaskname == null) {
			lbTaskname = new JLabel("Task:");
			lbTaskname.setBounds(10, 0, 50, 30);
			lbTaskname.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		}
		return lbTaskname;
	}
	
	private JLabel getLbType() {
		if (lbType == null) {
			lbType = new JLabel("Type:");
			lbType.setBounds(10, 30, 50, 30);
			lbType.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		}
		return lbType;
	}
	
	private JLabel getLblRegisterOnStartup() {
		if (lblRegisterOnStartup == null) {
			lblRegisterOnStartup = new JLabel("Start in onEnable():");
			lblRegisterOnStartup.setBounds(217, 30, 135, 30);
			lblRegisterOnStartup.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		}
		return lblRegisterOnStartup;
	}
	private JLabel getLbPeriod() {
		if (lbPeriod == null) {
			lbPeriod = new JLabel("Period:");
			lbPeriod.setBounds(560, 30, 50, 30);
			lbPeriod.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		}
		return lbPeriod;
	}
	
	private JLabel getLbDelay() {
		if (lbDelay == null) {
			lbDelay = new JLabel("Delay:");
			lbDelay.setBounds(420, 30, 50, 30);
			lbDelay.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		}
		return lbDelay;
	}
	private JLabel getLbTaskNameData() {
		if (lbTaskNameData == null) {
			lbTaskNameData = new JLabel("");
			lbTaskNameData.setFont(new Font("Segoe UI", Font.BOLD, 11));
			lbTaskNameData.setBounds(50, 0, 590, 30);
		}
		return lbTaskNameData;
	}
	
	private JLabel getLbTypeData() {
		if (lbTypeData == null) {
			lbTypeData = new JLabel("");
			lbTypeData.setFont(new Font("Segoe UI", Font.BOLD, 11));
			lbTypeData.setBounds(50, 30, 150, 30);
		}
		return lbTypeData;
	}
	private JLabel getLbRegisterOnStartupData() {
		if (lbRegisterOnStartupData == null) {
			lbRegisterOnStartupData = new JLabel("");
			lbRegisterOnStartupData.setFont(new Font("Segoe UI", Font.BOLD, 11));
			lbRegisterOnStartupData.setBounds(325, 30, 60, 30);
		}
		return lbRegisterOnStartupData;
	}
	
	private JLabel getLbDelayData() {
		if (lbDelayData == null) {
			lbDelayData = new JLabel("");
			lbDelayData.setFont(new Font("Segoe UI", Font.BOLD, 11));
			lbDelayData.setBounds(460, 30, 90, 30);
		}
		return lbDelayData;
	}
	
	private JLabel getLbPeriodData() {
		if (lbPeriodData == null) {
			lbPeriodData = new JLabel("");
			lbPeriodData.setFont(new Font("Segoe UI", Font.BOLD, 11));
			lbPeriodData.setBounds(610, 30, 90, 30);
		}
		return lbPeriodData;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBounds(0, 0, 700, 60);
		}
		return label;
	}
}