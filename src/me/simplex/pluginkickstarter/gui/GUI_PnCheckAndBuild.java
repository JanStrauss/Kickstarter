package me.simplex.pluginkickstarter.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import me.simplex.pluginkickstarter.DataStorage;

public class GUI_PnCheckAndBuild extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private GUI_Main_Window GUI;
	private JPanel pnCheck;
	private JPanel pnExport;
	private JLabel lblEventsToGenerate;
	private JLabel lblCommandsToGenerate;
	private JLabel lblConfignodesToGenerate;
	private JLabel lblTasksToGenerate;
	private JLabel lbPluginnameFull;
	private JLabel lbEventsCount;
	private JLabel lbCommandsCount;
	private JLabel lbConfigNodesCount;
	private JLabel lbTaskcount;
	private JLabel lbFiles;
	private JLabel lbFileCount;
	private JPanel panel;
	@SuppressWarnings("unused")
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btChooseDir;
	private JTextField tfDirectory;
	private JFileChooser chooser;
	
	public GUI_PnCheckAndBuild(GUI_Main_Window gui) {
		// TODO Auto-generated constructor stub
		this.GUI = gui;
		initialize();
	}
	
	private void initialize() {
		this.setSize(800, 360);
		setLayout(null);
		add(getPnCheck());
		add(getPnExport());
	}
	
	public void updateExportOverview(){
		DataStorage s = GUI.getMain().getData();
		
		lbCommandsCount.setText(""+s.getCommands().size());
		lbConfigNodesCount.setText(""+s.getConfigNodes().size());
		lbEventsCount.setText(""+s.getListener().size());
		lbTaskcount.setText(""+s.getTasks().size());
		lbPluginnameFull.setText(s.getPluginname()+" version: "+s.getVersion());
		
		tfDirectory.setText(System.getProperty("user.home")+File.separator+GUI.getMain().getData().getPluginname());

	}
	
	private JPanel getPnCheck() {
		if (pnCheck == null) {
			pnCheck = new JPanel();
			pnCheck.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Check data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5))));
			pnCheck.setBounds(0, 0, 250, 360);
			GridBagLayout gbl_pnCheck = new GridBagLayout();
			gbl_pnCheck.columnWidths = new int[]{0, 0, 0};
			gbl_pnCheck.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnCheck.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_pnCheck.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			pnCheck.setLayout(gbl_pnCheck);
			GridBagConstraints gbc_lbPluginnameFull = new GridBagConstraints();
			gbc_lbPluginnameFull.gridwidth = 2;
			gbc_lbPluginnameFull.anchor = GridBagConstraints.WEST;
			gbc_lbPluginnameFull.insets = new Insets(0, 0, 5, 0);
			gbc_lbPluginnameFull.gridx = 0;
			gbc_lbPluginnameFull.gridy = 0;
			pnCheck.add(getLbPluginnameFull(), gbc_lbPluginnameFull);
			GridBagConstraints gbc_lblEventsToGenerate = new GridBagConstraints();
			gbc_lblEventsToGenerate.anchor = GridBagConstraints.WEST;
			gbc_lblEventsToGenerate.insets = new Insets(0, 0, 5, 5);
			gbc_lblEventsToGenerate.gridx = 0;
			gbc_lblEventsToGenerate.gridy = 1;
			pnCheck.add(getLblEventsToGenerate(), gbc_lblEventsToGenerate);
			GridBagConstraints gbc_lbEventsCount = new GridBagConstraints();
			gbc_lbEventsCount.anchor = GridBagConstraints.WEST;
			gbc_lbEventsCount.insets = new Insets(0, 0, 5, 0);
			gbc_lbEventsCount.gridx = 1;
			gbc_lbEventsCount.gridy = 1;
			pnCheck.add(getLbEventsCount(), gbc_lbEventsCount);
			GridBagConstraints gbc_lblCommandsToGenerate = new GridBagConstraints();
			gbc_lblCommandsToGenerate.anchor = GridBagConstraints.WEST;
			gbc_lblCommandsToGenerate.insets = new Insets(0, 0, 5, 5);
			gbc_lblCommandsToGenerate.gridx = 0;
			gbc_lblCommandsToGenerate.gridy = 2;
			pnCheck.add(getLblCommandsToGenerate(), gbc_lblCommandsToGenerate);
			GridBagConstraints gbc_lbCommandsCount = new GridBagConstraints();
			gbc_lbCommandsCount.anchor = GridBagConstraints.WEST;
			gbc_lbCommandsCount.insets = new Insets(0, 0, 5, 0);
			gbc_lbCommandsCount.gridx = 1;
			gbc_lbCommandsCount.gridy = 2;
			pnCheck.add(getLbCommandsCount(), gbc_lbCommandsCount);
			GridBagConstraints gbc_lblConfignodesToGenerate = new GridBagConstraints();
			gbc_lblConfignodesToGenerate.anchor = GridBagConstraints.WEST;
			gbc_lblConfignodesToGenerate.insets = new Insets(0, 0, 5, 5);
			gbc_lblConfignodesToGenerate.gridx = 0;
			gbc_lblConfignodesToGenerate.gridy = 3;
			pnCheck.add(getLblConfignodesToGenerate(), gbc_lblConfignodesToGenerate);
			GridBagConstraints gbc_lbConfigNodesCount = new GridBagConstraints();
			gbc_lbConfigNodesCount.anchor = GridBagConstraints.WEST;
			gbc_lbConfigNodesCount.insets = new Insets(0, 0, 5, 0);
			gbc_lbConfigNodesCount.gridx = 1;
			gbc_lbConfigNodesCount.gridy = 3;
			pnCheck.add(getLbConfigNodesCount(), gbc_lbConfigNodesCount);
			GridBagConstraints gbc_lblTasksToGenerate = new GridBagConstraints();
			gbc_lblTasksToGenerate.insets = new Insets(0, 0, 5, 5);
			gbc_lblTasksToGenerate.anchor = GridBagConstraints.WEST;
			gbc_lblTasksToGenerate.gridx = 0;
			gbc_lblTasksToGenerate.gridy = 4;
			pnCheck.add(getLblTasksToGenerate(), gbc_lblTasksToGenerate);
			GridBagConstraints gbc_lbTaskcount = new GridBagConstraints();
			gbc_lbTaskcount.insets = new Insets(0, 0, 5, 0);
			gbc_lbTaskcount.anchor = GridBagConstraints.WEST;
			gbc_lbTaskcount.gridx = 1;
			gbc_lbTaskcount.gridy = 4;
			pnCheck.add(getLbTaskcount(), gbc_lbTaskcount);
			GridBagConstraints gbc_lbFiles = new GridBagConstraints();
			gbc_lbFiles.anchor = GridBagConstraints.WEST;
			gbc_lbFiles.insets = new Insets(0, 0, 5, 5);
			gbc_lbFiles.gridx = 0;
			gbc_lbFiles.gridy = 5;
			pnCheck.add(getLabel_2(), gbc_lbFiles);
			GridBagConstraints gbc_lbFileCount = new GridBagConstraints();
			gbc_lbFileCount.gridx = 1;
			gbc_lbFileCount.gridy = 6;
			pnCheck.add(getLabel_3(), gbc_lbFileCount);
		}
		return pnCheck;
	}
	private JPanel getPnExport() {
		if (pnExport == null) {
			pnExport = new JPanel();
			pnExport.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Export Plugin", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5))));
			pnExport.setBounds(250, 0, 550, 360);
			pnExport.setLayout(new BoxLayout(pnExport, BoxLayout.Y_AXIS));
			pnExport.add(getPanel());
		}
		return pnExport;
	}
	private JLabel getLblEventsToGenerate() {
		if (lblEventsToGenerate == null) {
			lblEventsToGenerate = new JLabel("Events to generate:");
		}
		return lblEventsToGenerate;
	}
	private JLabel getLblCommandsToGenerate() {
		if (lblCommandsToGenerate == null) {
			lblCommandsToGenerate = new JLabel("Commands to generate:");
		}
		return lblCommandsToGenerate;
	}
	private JLabel getLblConfignodesToGenerate() {
		if (lblConfignodesToGenerate == null) {
			lblConfignodesToGenerate = new JLabel("ConfigNodes to generate:");
		}
		return lblConfignodesToGenerate;
	}
	private JLabel getLblTasksToGenerate() {
		if (lblTasksToGenerate == null) {
			lblTasksToGenerate = new JLabel("Tasks to generate:");
		}
		return lblTasksToGenerate;
	}
	private JLabel getLbPluginnameFull() {
		if (lbPluginnameFull == null) {
			lbPluginnameFull = new JLabel("");
			lbPluginnameFull.setFont(new Font("Segoe UI", Font.BOLD, 11));
		}
		return lbPluginnameFull;
	}
	private JLabel getLbEventsCount() {
		if (lbEventsCount == null) {
			lbEventsCount = new JLabel("");
		}
		return lbEventsCount;
	}
	private JLabel getLbCommandsCount() {
		if (lbCommandsCount == null) {
			lbCommandsCount = new JLabel("");
		}
		return lbCommandsCount;
	}
	private JLabel getLbConfigNodesCount() {
		if (lbConfigNodesCount == null) {
			lbConfigNodesCount = new JLabel("");
		}
		return lbConfigNodesCount;
	}
	private JLabel getLbTaskcount() {
		if (lbTaskcount == null) {
			lbTaskcount = new JLabel("");
		}
		return lbTaskcount;
	}
	private JLabel getLabel_2() {
		if (lbFiles == null) {
			lbFiles = new JLabel("Output files:");
		}
		return lbFiles;
	}
	private JLabel getLabel_3() {
		if (lbFileCount == null) {
			lbFileCount = new JLabel("");
		}
		return lbFileCount;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{121, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_tfDirectory = new GridBagConstraints();
			gbc_tfDirectory.insets = new Insets(0, 0, 0, 5);
			gbc_tfDirectory.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfDirectory.gridx = 0;
			gbc_tfDirectory.gridy = 0;
			panel.add(getTfDirectory(), gbc_tfDirectory);
			GridBagConstraints gbc_btChooseDir = new GridBagConstraints();
			gbc_btChooseDir.gridx = 1;
			gbc_btChooseDir.gridy = 0;
			panel.add(getBtChooseDir(), gbc_btChooseDir);
		}
		return panel;
	}
	private JButton getBtChooseDir() {
		if (btChooseDir == null) {
			btChooseDir = new JButton("Choose directory");
			btChooseDir.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
		        
				    chooser = new JFileChooser(); 
				    chooser.setCurrentDirectory(new File(System.getProperty("user.home")+File.separator+GUI.getMain().getData().getPluginname()));
				    chooser.setDialogTitle("Chooser");
				    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				    //
				    // disable the "All files" option.
				    //
				    chooser.setAcceptAllFileFilterUsed(false);
				    //    
				    if (chooser.showOpenDialog(GUI) == JFileChooser.APPROVE_OPTION) { 
				      System.out.println("getCurrentDirectory(): " +  chooser.getCurrentDirectory());
				      tfDirectory.setText(""+chooser.getSelectedFile()+File.separator+GUI.getMain().getData().getPluginname());
				      System.out.println("getSelectedFile() : " +  chooser.getSelectedFile());
				      }
				    else {
				      System.out.println("No Selection ");
				      }
				     }
				});
			}
		return btChooseDir;
	}

	private JTextField getTfDirectory() {
		if (tfDirectory == null) {
			tfDirectory = new JTextField();
			tfDirectory.setColumns(10);
		}
		return tfDirectory;
	}
}
