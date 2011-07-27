package me.simplex.pluginkickstarter.gui;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import me.simplex.pluginkickstarter.storage.ConfigurationNodeContainer;
import me.simplex.pluginkickstarter.util.ConfigNodeDataType;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GUI_ConfigurationNodeEditor extends JDialog {
	private static final long serialVersionUID = 0L;
	private ConfigurationNodeContainer c;	
	private boolean isEditDialog;
	private GUI_PnPluginInformation GUI;
	
	private JPanel pnBtns;
	private JPanel panel_1;
	private JButton btSave;
	private JButton btCancel;
	private JLabel lbNode;
	private JLabel lbType;
	private JLabel lbDefault;
	private JTextField tfNode;
	private JComboBox cbType;
	private JTextField tfDefault;

	public GUI_ConfigurationNodeEditor(GUI_PnPluginInformation gui, boolean edit, ConfigurationNodeContainer container) {

		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(new Rectangle(0, 0, 360, 185));
		this.GUI = gui;
		this.c = container;
		this.isEditDialog = edit;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (!isEditDialog) {
					GUI.cancelConfigNode(c);
				}
				dispose();
			}

		});
		initialize();
		if (edit) {
			this.setTitle("Edit Node");
			getTfDefault().setText(c.getDefaultValue());
			getTfNode().setText(c.getNode());
			getCbType().setSelectedItem(c.getType());
		}
		else {
			this.setTitle("New Node");
		}
		this.setVisible(true);
		repaint();
	}
	
	private void initialize() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		this.setLocationRelativeTo(GUI.getGUI());
		this.setResizable(false);
		this.setIconImage(new ImageIcon(GUI_Main_Window.class.getResource("/me/simplex/pluginkickstarter/gui/images/icon_this.png")).getImage());
		this.setModalExclusionType(ModalExclusionType.NO_EXCLUDE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPnBtns(), BorderLayout.SOUTH);
		getContentPane().add(getPanel_1(), BorderLayout.CENTER);
	}

	private JPanel getPnBtns() {
		if (pnBtns == null) {
			pnBtns = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBtns.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBtns.add(getBtSave());
			pnBtns.add(getBtCancel());
		}
		return pnBtns;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{0, 0, 0};
			gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
			gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			GridBagConstraints gbc_lbNode = new GridBagConstraints();
			gbc_lbNode.anchor = GridBagConstraints.WEST;
			gbc_lbNode.insets = new Insets(0, 0, 5, 5);
			gbc_lbNode.gridx = 0;
			gbc_lbNode.gridy = 0;
			panel_1.add(getLbNode(), gbc_lbNode);
			GridBagConstraints gbc_tfNode = new GridBagConstraints();
			gbc_tfNode.insets = new Insets(0, 0, 5, 0);
			gbc_tfNode.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfNode.gridx = 1;
			gbc_tfNode.gridy = 0;
			panel_1.add(getTfNode(), gbc_tfNode);
			GridBagConstraints gbc_lbType = new GridBagConstraints();
			gbc_lbType.anchor = GridBagConstraints.WEST;
			gbc_lbType.insets = new Insets(0, 0, 5, 5);
			gbc_lbType.gridx = 0;
			gbc_lbType.gridy = 1;
			panel_1.add(getLbType(), gbc_lbType);
			GridBagConstraints gbc_cbType = new GridBagConstraints();
			gbc_cbType.insets = new Insets(0, 0, 5, 0);
			gbc_cbType.fill = GridBagConstraints.HORIZONTAL;
			gbc_cbType.gridx = 1;
			gbc_cbType.gridy = 1;
			panel_1.add(getCbType(), gbc_cbType);
			GridBagConstraints gbc_lbDefault = new GridBagConstraints();
			gbc_lbDefault.anchor = GridBagConstraints.WEST;
			gbc_lbDefault.insets = new Insets(0, 0, 0, 5);
			gbc_lbDefault.gridx = 0;
			gbc_lbDefault.gridy = 2;
			panel_1.add(getLbDefault(), gbc_lbDefault);
			GridBagConstraints gbc_tfDefault = new GridBagConstraints();
			gbc_tfDefault.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfDefault.gridx = 1;
			gbc_tfDefault.gridy = 2;
			panel_1.add(getTfDefault(), gbc_tfDefault);
		}
		return panel_1;
	}
	private JButton getBtSave() {
		if (btSave == null) {
			btSave = new JButton("Save");
			btSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<ConfigurationNodeContainer> cOnTainazZ = GUI.getGUI().getMain().getData().getConfigNodes();
					for (ConfigurationNodeContainer c : cOnTainazZ) {
						if (c.getNode() != null) {
							if (c.getNode().equalsIgnoreCase(getTfNode().getText().trim())) {

								JOptionPane.showMessageDialog(getContentPane().getParent(), "There is already a Node with this name", "Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
						}
					}
					c.setDefaultValue(getTfDefault().getText().trim());
					c.setNode(getTfNode().getText().trim());
					c.setType((ConfigNodeDataType) cbType.getSelectedItem());
					
					GUI.updateConfig();
					dispose();
				}
			});
		}
		return btSave;
	}
	private JButton getBtCancel() {
		if (btCancel == null) {
			btCancel = new JButton("Cancel");
			btCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!isEditDialog) {
						GUI.cancelConfigNode(c);
					}
					dispose();
				}
			});
		}
		return btCancel;
	}
	private JLabel getLbNode() {
		if (lbNode == null) {
			lbNode = new JLabel("Node:");
		}
		return lbNode;
	}
	private JLabel getLbType() {
		if (lbType == null) {
			lbType = new JLabel("Type:");
		}
		return lbType;
	}
	private JLabel getLbDefault() {
		if (lbDefault == null) {
			lbDefault = new JLabel("Default:");
		}
		return lbDefault;
	}
	private JTextField getTfNode() {
		if (tfNode == null) {
			tfNode = new JTextField();
			tfNode.setColumns(10);
		}
		return tfNode;
	}
	private JComboBox getCbType() {
		if (cbType == null) {
			cbType = new JComboBox(ConfigNodeDataType.values());
		}
		return cbType;
	}
	private JTextField getTfDefault() {
		if (tfDefault == null) {
			tfDefault = new JTextField();
			tfDefault.setColumns(10);
		}
		return tfDefault;
	}
}
