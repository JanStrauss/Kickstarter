package me.simplex.pluginkickstarter.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import me.simplex.pluginkickstarter.gui.util.CommandListCellRenderer;
import me.simplex.pluginkickstarter.gui.util.EventTable;
import me.simplex.pluginkickstarter.storage.CommandContainer;
import me.simplex.pluginkickstarter.util.ListenerType;

public class GUI_PnPluginInformation extends JPanel {
	private GUI_Main_Window GUI;
	private static final long serialVersionUID = 1L;
	private JTabbedPane tpPluginData;
	private JPanel pnEvents;
	private JPanel pnCommands;
	private JPanel pnConfiguration;
	
	private JTabbedPane tpEvents;
	
	private JPanel pnPlayerEvents;
	private JPanel pnBlockEvents;
	private JPanel pnEntityEvents;
	private JPanel pnWorldEvents;
	private JPanel pnWeatherEvents;
	private JPanel pnInventoryEvents;
	private JPanel pnVehicleEvents;
	private JPanel pnServerEvents;
	
	private EventTable tblBlockEvents;
	private EventTable tblEntityEvents;
	private EventTable tblInventoryEvents;
	private EventTable tblPlayerEvents;
	private EventTable tblServerEvents;
	private EventTable tblVehicleEvents;
	private EventTable tblWeatherEvents;
	private EventTable tblWorldEvents;
	
	private JScrollPane spBlock;
	private JScrollPane spPlayer;
	private JScrollPane spEntity;
	private JScrollPane spWorld;
	private JScrollPane spWeather;
	private JScrollPane spInventory;
	private JScrollPane spVehicle;
	private JScrollPane spServer;
	
	private JLabel lblSelectTheEvents;
	private JPanel pnTasks;
	private JSplitPane splitCommands;
	private JScrollPane spCommands;
	private JList listCommands;
	private JPanel pnRight;
	private JPanel pnLeft;
	private JPanel pnCommandLabel;
	private JPanel pnButtonsCmd;
	private JButton btNewCommand;
	private JButton btRemoveCommand;
	private JLabel lblItsSimpleWe;
	private JPanel pnCommandEdit;
	private JLabel lblCommandname;
	private JTextField tfCmd_Name;
	private JLabel lblAliases;
	private JTextField tfAliases;
	private JLabel lblDiscription;
	private JScrollPane spDesc;
	private JTextField tfUsage;
	private JLabel lblUsage;
	private JLabel lblPermissions;
	private JTextField tfPermission;
	private JPanel panel;
	private JButton btSaveCommand;
	private JTextArea taDescription;
	
	private DefaultListModel list_data;
	private JCheckBox cbPlayerOnly;
	private JButton btEdit;
	
	private boolean editIsOn = false;
	private boolean editHasStarted = false;
	private JPanel pnScroll;
		
	public GUI_PnPluginInformation(GUI_Main_Window GUI) {
		this.GUI = GUI;
		initialize();
	}
	private void initialize() {
		this.setSize(800, 372);
		setLayout(null);
		this.setEnabled(true);
		add(getTpPluginData());
	}
	private JTabbedPane getTpPluginData() {
		if (tpPluginData == null) {
			tpPluginData = new JTabbedPane(JTabbedPane.TOP);
			tpPluginData.setBounds(10, 11, 780, 349);
			tpPluginData.addTab("Events", null, getPnEvents(), null);
			tpPluginData.addTab("Commands", null, getPnCommands(), null);
			tpPluginData.addTab("Configuration", null, getPnConfiguration(), null);
			tpPluginData.addTab("Tasks", null, getPnTasks(), null);
		}
		return tpPluginData;
	}
	
	private JPanel getPnEvents() {
		if (pnEvents == null) {
			pnEvents = new JPanel();
			pnEvents.setLayout(new BorderLayout(0, 0));
			pnEvents.add(getLblSelectTheEvents(), BorderLayout.NORTH);
			pnEvents.add(getTpEvents());
		}
		return pnEvents;
	}
	private JPanel getPnCommands() {
		if (pnCommands == null) {
			pnCommands = new JPanel();
			pnCommands.setLayout(new BorderLayout(0, 0));
			pnCommands.add(getSplitCommands());
			pnCommands.add(getPnCommandLabel(), BorderLayout.NORTH);
		}
		return pnCommands;
	}
	private JPanel getPnConfiguration() {
		if (pnConfiguration == null) {
			pnConfiguration = new JPanel();
			pnConfiguration.setEnabled(false);
		}
		return pnConfiguration;
	}
	private JTabbedPane getTpEvents() {
		if (tpEvents == null) {
			tpEvents = new JTabbedPane(JTabbedPane.TOP);
			tpEvents.setBorder(new EmptyBorder(5, 5, 5, 5));
			tpEvents.addTab("Block events", null, getPnBlockEvents(), null);
			tpEvents.addTab("Entity events", null, getPnEntityEvents(), null);
			tpEvents.addTab("Inventory events", null, getPnInventoryEvents(), null);
			tpEvents.addTab("Player events", null, getPnPlayerEvents(), null);
			tpEvents.addTab("Server events", null, getPnVehicleEvents(), null);
			tpEvents.addTab("Vehicle events", null, getPnServerEvents(), null);
			tpEvents.addTab("Weather events", null, getPnWeatherEvents(), null);
			tpEvents.addTab("World events", null, getPnWorldEvents(), null);
		}
		return tpEvents;
	}
	private JPanel getPnPlayerEvents() {
		if (pnPlayerEvents == null) {
			pnPlayerEvents = new JPanel();
			pnPlayerEvents.setLayout(new BorderLayout(0, 0));
			pnPlayerEvents.add(getSpPlayer(), BorderLayout.CENTER);
		}
		return pnPlayerEvents;
	}
	private JPanel getPnBlockEvents() {
		if (pnBlockEvents == null) {
			pnBlockEvents = new JPanel();
			pnBlockEvents.setLayout(new BorderLayout(0, 0));
			pnBlockEvents.add(getSpBlock(), BorderLayout.CENTER);
		}
		return pnBlockEvents;
	}
	private JPanel getPnEntityEvents() {
		if (pnEntityEvents == null) {
			pnEntityEvents = new JPanel();
			pnEntityEvents.setLayout(new BorderLayout(0, 0));
			pnEntityEvents.add(getSpEntity(), BorderLayout.CENTER);
		}
		return pnEntityEvents;
	}
	private JPanel getPnWorldEvents() {
		if (pnWorldEvents == null) {
			pnWorldEvents = new JPanel();
			pnWorldEvents.setLayout(new BorderLayout(0, 0));
			pnWorldEvents.add(getSpWorld(), BorderLayout.CENTER);
		}
		return pnWorldEvents;
	}
	private JPanel getPnWeatherEvents() {
		if (pnWeatherEvents == null) {
			pnWeatherEvents = new JPanel();
			pnWeatherEvents.setLayout(new BorderLayout(0, 0));
			pnWeatherEvents.add(getSpWeather(), BorderLayout.CENTER);
		}
		return pnWeatherEvents;
	}
	private JPanel getPnInventoryEvents() {
		if (pnInventoryEvents == null) {
			pnInventoryEvents = new JPanel();
			pnInventoryEvents.setLayout(new BorderLayout(0, 0));
			pnInventoryEvents.add(getSpInventory(), BorderLayout.CENTER);
		}
		return pnInventoryEvents;
	}
	private EventTable getTblBlockEvents() {
		if (tblBlockEvents == null) {
			tblBlockEvents = new EventTable(ListenerType.Block, GUI);
		}
		return tblBlockEvents;
	}
	
	private EventTable getTblEntityEvents() {
		if (tblEntityEvents == null) {
			tblEntityEvents = new EventTable(ListenerType.Entity, GUI);
		}
		return tblEntityEvents;
	}
	
	private EventTable getTblInventoryEvents() {
		if (tblInventoryEvents == null) {
			tblInventoryEvents = new EventTable(ListenerType.Inventory, GUI);
		}
		return tblInventoryEvents;
	}
	
	private EventTable getTblWeatherEvents() {
		if (tblWeatherEvents == null) {
			tblWeatherEvents = new EventTable(ListenerType.Weather, GUI);
		}
		return tblWeatherEvents;
	}
	
	private EventTable getTblWorldEvents() {
		if (tblWorldEvents == null) {
			tblWorldEvents = new EventTable(ListenerType.World, GUI);
		}
		return tblWorldEvents;
	}
	
	private EventTable getTblServerEvents() {
		if (tblServerEvents == null) {
			tblServerEvents = new EventTable(ListenerType.Server, GUI);
		}
		return tblServerEvents;
	}
	
	private EventTable getTblVehicleEvents() {
		if (tblVehicleEvents == null) {
			tblVehicleEvents = new EventTable(ListenerType.Vehicle, GUI);
		}
		return tblVehicleEvents;
	}
	
	private EventTable getTblPlayerEvents() {
		if (tblPlayerEvents == null) {
			tblPlayerEvents = new EventTable(ListenerType.Player, GUI);
		}
		return tblPlayerEvents;
	}
	
	private JScrollPane getSpBlock() {
		if (spBlock == null) {
			spBlock = new JScrollPane();
			spBlock.setViewportView(getTblBlockEvents());
		}
		return spBlock;
	}
	private JPanel getPnVehicleEvents() {
		if (pnVehicleEvents == null) {
			pnVehicleEvents = new JPanel();
			pnVehicleEvents.setLayout(new BorderLayout(0, 0));
			pnVehicleEvents.add(getSpVehicle(), BorderLayout.CENTER);
		}
		return pnVehicleEvents;
	}
	private JPanel getPnServerEvents() {
		if (pnServerEvents == null) {
			pnServerEvents = new JPanel();
			pnServerEvents.setLayout(new BorderLayout(0, 0));
			pnServerEvents.add(getSpServer(), BorderLayout.NORTH);
		}
		return pnServerEvents;
	}
	private JScrollPane getSpPlayer() {
		if (spPlayer == null) {
			spPlayer = new JScrollPane();
			spPlayer.setViewportView(getTblPlayerEvents());
		}
		return spPlayer;
	}
	private JScrollPane getSpEntity() {
		if (spEntity == null) {
			spEntity = new JScrollPane();
			spEntity.setViewportView(getTblEntityEvents());
		}
		return spEntity;
	}
	private JScrollPane getSpWorld() {
		if (spWorld == null) {
			spWorld = new JScrollPane();
			spWorld.setViewportView(getTblWorldEvents());
		}
		return spWorld;
	}
	private JScrollPane getSpWeather() {
		if (spWeather == null) {
			spWeather = new JScrollPane();
			spWeather.setViewportView(getTblWeatherEvents());
		}
		return spWeather;
	}
	private JScrollPane getSpInventory() {
		if (spInventory == null) {
			spInventory = new JScrollPane();
			spInventory.setViewportView(getTblInventoryEvents());
		}
		return spInventory;
	}
	private JScrollPane getSpVehicle() {
		if (spVehicle == null) {
			spVehicle = new JScrollPane();
			spVehicle.setViewportView(getTblVehicleEvents());
		}
		return spVehicle;
	}
	private JScrollPane getSpServer() {
		if (spServer == null) {
			spServer = new JScrollPane();
			spServer.setViewportView(getTblServerEvents());
		}
		return spServer;
	}
	private JLabel getLblSelectTheEvents() {
		if (lblSelectTheEvents == null) {
			lblSelectTheEvents = new JLabel("Select the events you want to listen to.");
			lblSelectTheEvents.setBorder(new EmptyBorder(5, 5, 5, 0));
		}
		return lblSelectTheEvents;
	}
	private JPanel getPnTasks() {
		if (pnTasks == null) {
			pnTasks = new JPanel();
		}
		return pnTasks;
	}
	private JSplitPane getSplitCommands() {
		if (splitCommands == null) {
			splitCommands = new JSplitPane();
			splitCommands.setRightComponent(getPnRight());
			splitCommands.setLeftComponent(getPnLeft());
			splitCommands.setContinuousLayout(true);
		}
		return splitCommands;
	}
	private JScrollPane getSpCommands() {
		if (spCommands == null) {
			spCommands = new JScrollPane();
			spCommands.setViewportView(getPnScroll());
		}
		return spCommands;
	}
	private JList getListCommands() {
		if (listCommands == null) {
			list_data = new DefaultListModel();
			listCommands = new JList(list_data);
			listCommands.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listCommands.setCellRenderer(new CommandListCellRenderer());
			listCommands.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (listCommands.getSelectedValue() != null) {
						if (!editIsOn) {
							getBtEdit().setEnabled(true);
							getBtRemoveCommand().setEnabled(true);
							CommandContainer c = (CommandContainer)listCommands.getSelectedValue();
							getTfCmd_Name().setText(c.getCommand());
							String aliases="";
							for (String alias : c.getAliases()) {
								aliases= aliases+alias+" "; 
							}
							aliases = aliases.trim().replace(' ', ',');
							getTfAliases().setText(aliases);
							getTaDescription().setText(c.getDescription());
							getTfUsage().setText(c.getUsage());
							getTfPermission().setText(c.getPermission());
							getCbPlayerOnly().setSelected(c.isPlayerOnly());
						}
					}
					else {
						getBtEdit().setEnabled(false);
						getBtRemoveCommand().setEnabled(false);
					}
					
				}
			});
		}
		return listCommands;
	}
	private JPanel getPnRight() {
		if (pnRight == null) {
			pnRight = new JPanel();
			pnRight.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnRight.setLayout(new BorderLayout(0, 0));
			pnRight.add(getPnCommandEdit(), BorderLayout.CENTER);
		}
		return pnRight;
	}
	private JPanel getPnLeft() {
		if (pnLeft == null) {
			pnLeft = new JPanel();
			pnLeft.setLayout(new BorderLayout(0, 0));
			pnLeft.setPreferredSize(new Dimension(120, 0));
			pnLeft.add(getSpCommands());
			pnLeft.add(getPnButtonsCmd(), BorderLayout.SOUTH);
		}
		return pnLeft;
	}
	private JPanel getPnCommandLabel() {
		if (pnCommandLabel == null) {
			pnCommandLabel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnCommandLabel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			pnCommandLabel.add(getLblItsSimpleWe());
		}
		return pnCommandLabel;
	}
	private JPanel getPnButtonsCmd() {
		if (pnButtonsCmd == null) {
			pnButtonsCmd = new JPanel();
			pnButtonsCmd.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnButtonsCmd.add(getBtNewCommand());
			pnButtonsCmd.add(getBtEdit());
			pnButtonsCmd.add(getBtRemoveCommand());
		}
		return pnButtonsCmd;
	}
	private JButton getBtNewCommand() {
		if (btNewCommand == null) {
			btNewCommand = new JButton("New");
			btNewCommand.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					editHasStarted = false;
					CommandContainer newCommand = new CommandContainer("New Command");
					list_data.addElement(newCommand);
					getListCommands().setSelectedValue(newCommand, true);
					getTfCmd_Name().requestFocus();
					setEditEnabled(true,false);
					getBtNewCommand().setEnabled(false);
					getBtEdit().setEnabled(false);
					getBtRemoveCommand().setEnabled(false);
					editIsOn = true;
				}
			});
		}
		return btNewCommand;
	}
	
	private void setEditEnabled(boolean general, boolean ok){
		for (Component comp : getPnCommandEdit().getComponents()) {
			comp.setEnabled(general);
		}
		getTaDescription().setEnabled(general);
		getBtSaveCommand().setEnabled(ok);
	}
	
	private JButton getBtRemoveCommand() {
		if (btRemoveCommand == null) {
			btRemoveCommand = new JButton("Remove");
			btRemoveCommand.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int input = JOptionPane.showConfirmDialog(GUI, "Delete this command?", "Confirm command delete", JOptionPane.OK_CANCEL_OPTION);
					if (input != 0) {
						return;
					}
					CommandContainer c = (CommandContainer)getListCommands().getSelectedValue();
					GUI.getMain().getData().getCommands().remove(c);
					list_data.removeElement(c);
					
					getTfAliases().setText("");
					getTfCmd_Name().setText("");
					getTfPermission().setText("");
					getTfUsage().setText("");
					getTaDescription().setText("");
					getCbPlayerOnly().setSelected(true);
				}
			});
			
			btRemoveCommand.setEnabled(false);
		}
		return btRemoveCommand;
	}
	private JLabel getLblItsSimpleWe() {
		if (lblItsSimpleWe == null) {
			lblItsSimpleWe = new JLabel("It's simple. We kill the batman. You may add some commands here also.");
		}
		return lblItsSimpleWe;
	}
	private JPanel getPnCommandEdit() {
		if (pnCommandEdit == null) {
			pnCommandEdit = new JPanel();
			pnCommandEdit.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Edit command", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(5, 5, 0, 5)));
			GridBagLayout gbl_pnCommandEdit = new GridBagLayout();
			gbl_pnCommandEdit.columnWidths = new int[]{0, 0, 0};
			gbl_pnCommandEdit.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnCommandEdit.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_pnCommandEdit.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			pnCommandEdit.setLayout(gbl_pnCommandEdit);
			GridBagConstraints gbc_lblCommandname = new GridBagConstraints();
			gbc_lblCommandname.insets = new Insets(0, 0, 5, 5);
			gbc_lblCommandname.anchor = GridBagConstraints.EAST;
			gbc_lblCommandname.gridx = 0;
			gbc_lblCommandname.gridy = 0;
			pnCommandEdit.add(getLblCommandname(), gbc_lblCommandname);
			GridBagConstraints gbc_tfCmd_Name = new GridBagConstraints();
			gbc_tfCmd_Name.insets = new Insets(0, 0, 5, 0);
			gbc_tfCmd_Name.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfCmd_Name.gridx = 1;
			gbc_tfCmd_Name.gridy = 0;
			pnCommandEdit.add(getTfCmd_Name(), gbc_tfCmd_Name);
			GridBagConstraints gbc_lblAliases = new GridBagConstraints();
			gbc_lblAliases.anchor = GridBagConstraints.WEST;
			gbc_lblAliases.insets = new Insets(0, 0, 5, 5);
			gbc_lblAliases.gridx = 0;
			gbc_lblAliases.gridy = 1;
			pnCommandEdit.add(getLblAliases(), gbc_lblAliases);
			GridBagConstraints gbc_tfAliases = new GridBagConstraints();
			gbc_tfAliases.insets = new Insets(0, 0, 5, 0);
			gbc_tfAliases.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfAliases.gridx = 1;
			gbc_tfAliases.gridy = 1;
			pnCommandEdit.add(getTfAliases(), gbc_tfAliases);
			GridBagConstraints gbc_lblDiscription = new GridBagConstraints();
			gbc_lblDiscription.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblDiscription.insets = new Insets(0, 0, 5, 5);
			gbc_lblDiscription.gridx = 0;
			gbc_lblDiscription.gridy = 2;
			pnCommandEdit.add(getLblDiscription(), gbc_lblDiscription);
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 1;
			gbc_scrollPane.gridy = 2;
			pnCommandEdit.add(getSpDesc(), gbc_scrollPane);
			GridBagConstraints gbc_lblUsage = new GridBagConstraints();
			gbc_lblUsage.insets = new Insets(0, 0, 5, 5);
			gbc_lblUsage.anchor = GridBagConstraints.WEST;
			gbc_lblUsage.gridx = 0;
			gbc_lblUsage.gridy = 3;
			pnCommandEdit.add(getLblUsage(), gbc_lblUsage);
			GridBagConstraints gbc_tfUsage = new GridBagConstraints();
			gbc_tfUsage.insets = new Insets(0, 0, 5, 0);
			gbc_tfUsage.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfUsage.gridx = 1;
			gbc_tfUsage.gridy = 3;
			pnCommandEdit.add(getTfUsage(), gbc_tfUsage);
			GridBagConstraints gbc_lblPermissions = new GridBagConstraints();
			gbc_lblPermissions.anchor = GridBagConstraints.WEST;
			gbc_lblPermissions.insets = new Insets(0, 0, 5, 5);
			gbc_lblPermissions.gridx = 0;
			gbc_lblPermissions.gridy = 4;
			pnCommandEdit.add(getLblPermissions(), gbc_lblPermissions);
			GridBagConstraints gbc_tfPermission = new GridBagConstraints();
			gbc_tfPermission.insets = new Insets(0, 0, 5, 0);
			gbc_tfPermission.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfPermission.gridx = 1;
			gbc_tfPermission.gridy = 4;
			pnCommandEdit.add(getTfPermission(), gbc_tfPermission);
			GridBagConstraints gbc_cbPlayerOnly = new GridBagConstraints();
			gbc_cbPlayerOnly.anchor = GridBagConstraints.WEST;
			gbc_cbPlayerOnly.insets = new Insets(0, 0, 5, 0);
			gbc_cbPlayerOnly.gridx = 1;
			gbc_cbPlayerOnly.gridy = 5;
			pnCommandEdit.add(getCbPlayerOnly(), gbc_cbPlayerOnly);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.gridwidth = 2;
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 6;
			pnCommandEdit.add(getPanel(), gbc_panel);
		}
		return pnCommandEdit;
	}
	private JLabel getLblCommandname() {
		if (lblCommandname == null) {
			lblCommandname = new JLabel("Commandname:");
			lblCommandname.setEnabled(false);
			lblCommandname.setLabelFor(getTfCmd_Name());
		}
		return lblCommandname;
	}
	private JTextField getTfCmd_Name() {
		if (tfCmd_Name == null) {
			tfCmd_Name = new JTextField();
			tfCmd_Name.setEnabled(false);
			tfCmd_Name.setDocument(new PlainDocument(){
				private static final long serialVersionUID = 1L;

				@Override
				public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
					str = str.replace(" ", "_");
					str = str.toLowerCase();
					if (!editHasStarted) {
						editHasStarted = true;
						return;
					}
					super.insertString(offs, str, a);
				}
			});
			
			tfCmd_Name.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent arg0) {
					handleUpdate();
				}
				
				@Override
				public void insertUpdate(DocumentEvent arg0) {
					handleUpdate();
				}
				
				@Override
				public void changedUpdate(DocumentEvent arg0) {
					handleUpdate();
				}
				
				private void handleUpdate(){
					if (editIsOn) {
						System.out.println(tfCmd_Name.getText());
						CommandContainer cont = (CommandContainer)list_data.getElementAt(list_data.size()-1);
						cont.setCommand(tfCmd_Name.getText());
						list_data.setElementAt(cont, list_data.size()-1);
						checkBtnOkEnable();
					}
				}
				
			});
			tfCmd_Name.setColumns(10);
		}
		return tfCmd_Name;
	}
	
	private JLabel getLblAliases() {
		if (lblAliases == null) {
			lblAliases = new JLabel("Aliases:");
			lblAliases.setEnabled(false);
		}
		return lblAliases;
	}
	
	private JTextField getTfAliases() {
		if (tfAliases == null) {
			tfAliases = new JTextField();
			tfAliases.setEnabled(false);
			tfAliases.setDocument(new PlainDocument(){
				private static final long serialVersionUID = 1L;

				@Override
				public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
					str = str.replace(" ", ",");
					str = str.toLowerCase();
					super.insertString(offs, str, a);
				}
			});
		}
		return tfAliases;
	}
	
	private JLabel getLblDiscription() {
		if (lblDiscription == null) {
			lblDiscription = new JLabel("Description:");
			lblDiscription.setEnabled(false);
		}
		return lblDiscription;
	}
	private JScrollPane getSpDesc() {
		if (spDesc == null) {
			spDesc = new JScrollPane();
			spDesc.setViewportView(getTaDescription());
		}
		return spDesc;
	}
	private JTextField getTfUsage() {
		if (tfUsage == null) {
			tfUsage = new JTextField();
			tfUsage.setText("/<command> ");
			tfUsage.setEnabled(false);
			tfUsage.setColumns(10);
		}
		return tfUsage;
	}
	private JLabel getLblUsage() {
		if (lblUsage == null) {
			lblUsage = new JLabel("Usage:");
			lblUsage.setEnabled(false);
		}
		return lblUsage;
	}
	private JLabel getLblPermissions() {
		if (lblPermissions == null) {
			lblPermissions = new JLabel("Permission:");
			lblPermissions.setEnabled(false);
		}
		return lblPermissions;
	}
	private JTextField getTfPermission() {
		if (tfPermission == null) {
			tfPermission = new JTextField();
			tfPermission.setEnabled(false);
			tfPermission.setColumns(10);
		}
		return tfPermission;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new CompoundBorder(new MatteBorder(1, 0, 0, 0, new Color(221, 221, 221)), new EmptyBorder(3, 0, 0, 0)));
			panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
			panel.add(getBtSaveCommand());
		}
		return panel;
	}
	private JButton getBtSaveCommand() {
		if (btSaveCommand == null) {
			btSaveCommand = new JButton("OK");
			btSaveCommand.setEnabled(false);
			btSaveCommand.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					editIsOn = false;
					ArrayList<String> aliases = new ArrayList<String>();
					for (String string : tfAliases.getText().split(",")) {
						aliases.add(string);
					}
					
					CommandContainer c = (CommandContainer)listCommands.getSelectedValue();
					
					c.setCommand(tfCmd_Name.getText());
					c.setDescription(taDescription.getText());
					c.setAliases(aliases);
					c.setPermission(tfPermission.getText());
					c.setPlayerOnly(cbPlayerOnly.isSelected());
					c.setUsage(tfUsage.getText());
					
//					getTfAliases().setText("");
//					getTfCmd_Name().setText("");
//					getTfPermission().setText("");
//					getTfUsage().setText("");
//					getTaDescription().setText("");
//					getCbPlayerOnly().setEnabled(true);
					
					editIsOn = false;
					//editHasStarted = false;
					setEditEnabled(false, false);
					getBtNewCommand().setEnabled(true);
					getListCommands().setEnabled(true);
					//getListCommands().clearSelection();
				}
			});
		}
		return btSaveCommand;
	}
	private JTextArea getTaDescription() {
		if (taDescription == null) {
			taDescription = new JTextArea();
			taDescription.setEnabled(false);
			taDescription.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					checkBtnOkEnable();
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					checkBtnOkEnable();
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					checkBtnOkEnable();
				}
			});
			taDescription.setLineWrap(true);
		}
		return taDescription;
	}
	
	private void checkBtnOkEnable(){
		if (editIsOn) {
			if (getTfCmd_Name().getText().length() > 0 && getTaDescription().getText().trim().length() > 0) {
				getBtSaveCommand().setEnabled(true);
			}
			else {
				getBtSaveCommand().setEnabled(false);
			}
		}
	}
	
	private JCheckBox getCbPlayerOnly() {
		if (cbPlayerOnly == null) {
			cbPlayerOnly = new JCheckBox("Player only");
			cbPlayerOnly.setSelected(true);
			cbPlayerOnly.setEnabled(false);
		}
		return cbPlayerOnly;
	}
	private JButton getBtEdit() {
		if (btEdit == null) {
			btEdit = new JButton("Edit");
			btEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					editHasStarted = true;

					//CommandContainer newCommand = (CommandContainer) getListCommands().getSelectedValue();
					getTfCmd_Name().requestFocus();
					setEditEnabled(true,false);
					getBtNewCommand().setEnabled(false);
					getBtEdit().setEnabled(false);
					getBtRemoveCommand().setEnabled(false);
					editIsOn = true;
				}
			});
			btEdit.setEnabled(false);
		}
		return btEdit;
	}
	private JPanel getPnScroll() {
		if (pnScroll == null) {
			pnScroll = new JPanel();
			pnScroll.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if (!editIsOn) {
						getListCommands().clearSelection();
						getTfAliases().setText("");
						getTfCmd_Name().setText("");
						getTfPermission().setText("");
						getTfUsage().setText("");
						getTaDescription().setText("");
						getCbPlayerOnly().setSelected(true);
					}

				}
			});
			pnScroll.setLayout(new BorderLayout(0, 0));
			pnScroll.add(getListCommands(), BorderLayout.NORTH);
		}
		return pnScroll;
	}
}

