package me.simplex.pluginkickstarter.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import me.simplex.pluginkickstarter.gui.util.GraphicsPanel;
import me.simplex.pluginkickstarter.storage.CommandContainer;

public class GUI_CommandEditor extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel pnCommandEdit;
	private JLabel lblCommandname;
	private JTextField tfCmd_Name;
	private JLabel lblAliases;
	private JTextField tfAliases;
	private JLabel lblDiscription;
	private JScrollPane spDesc;
	private JTextField tfUsage;
	private JLabel lblUsage;
	private GraphicsPanel pnBtns;
	private JButton btSaveCommand;
	private JTextArea taDescription;
	private JCheckBox cbPlayerOnly;
	
	private CommandContainer c;
	private GUI_PnPluginInformation GUI;
	private boolean isEditDialog;
	private JPanel pnConent;
	private JButton btCancelCommand;
	
	public GUI_CommandEditor(GUI_PnPluginInformation gui, boolean edit, CommandContainer container) {
		this.c = container;
		this.GUI = gui;
		this.isEditDialog = edit;
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.setBounds(new Rectangle(0, 0, 400, 280));
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (!isEditDialog) {
					GUI.cancelCommand(c);
				}
				dispose();
			}
		});

		if (edit) {
			String aliases="";
			for (String a : c.getAliases()) {
				aliases=aliases+a+" ";
			}
			
			this.setTitle("Edit Command");
			getTfCmd_Name().setText(c.getCommand());
			getTfAliases().setText(aliases.trim());
			getTfUsage().setText(c.getUsage());
			getTaDescription().setText(c.getDescription());
			getCbPlayerOnly().setSelected(c.isPlayerOnly());
		}
		else {
			this.setTitle("New Command");
		}
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(getPnConent(), BorderLayout.CENTER);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setLocationRelativeTo(GUI.getGUI());
		this.setResizable(false);
		this.setIconImage(new ImageIcon(GUI_Main_Window.class.getResource("/me/simplex/pluginkickstarter/gui/images/icon_this.png")).getImage());
		this.setModalExclusionType(ModalExclusionType.NO_EXCLUDE);
		this.setVisible(true);
	}



private JPanel getPnCommandEdit() {
	if (pnCommandEdit == null) {
		pnCommandEdit = new JPanel();
		pnCommandEdit.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_pnCommandEdit = new GridBagLayout();
		gbl_pnCommandEdit.columnWidths = new int[]{0, 0, 0};
		gbl_pnCommandEdit.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnCommandEdit.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pnCommandEdit.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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
		GridBagConstraints gbc_cbPlayerOnly = new GridBagConstraints();
		gbc_cbPlayerOnly.anchor = GridBagConstraints.WEST;
		gbc_cbPlayerOnly.gridx = 1;
		gbc_cbPlayerOnly.gridy = 4;
		pnCommandEdit.add(getCbPlayerOnly(), gbc_cbPlayerOnly);
	}
	return pnCommandEdit;
}
private JLabel getLblCommandname() {
	if (lblCommandname == null) {
		lblCommandname = new JLabel("Commandname:");
		lblCommandname.setLabelFor(getTfCmd_Name());
	}
	return lblCommandname;
}
private JTextField getTfCmd_Name() {
	if (tfCmd_Name == null) {
		tfCmd_Name = new JTextField();
		tfCmd_Name.setDocument(new PlainDocument(){
			private static final long serialVersionUID = 1L;

				@Override
				public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
					str = str.replace(" ", "_");
					str = str.toLowerCase();
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
					checkBtnOkEnable();
			}
			
		});
			

		tfCmd_Name.setColumns(10);
	}
	return tfCmd_Name;
}

private JLabel getLblAliases() {
	if (lblAliases == null) {
		lblAliases = new JLabel("Aliases:");
	}
	return lblAliases;
}

private JTextField getTfAliases() {
	if (tfAliases == null) {
		tfAliases = new JTextField();
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
		tfUsage.setColumns(10);
	}
	return tfUsage;
}
private JLabel getLblUsage() {
	if (lblUsage == null) {
		lblUsage = new JLabel("Usage:");
	}
	return lblUsage;
}
private GraphicsPanel getPnBtns() {
	if (pnBtns == null) {
		pnBtns = new GraphicsPanel(false,"/me/simplex/pluginkickstarter/gui/images/bg_edit_cmd.png");
		pnBtns.setBorder(null);
		pnBtns.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		pnBtns.add(getBtSaveCommand());
		pnBtns.add(getBtCancelCommand());
	}
	return pnBtns;
}
private JButton getBtSaveCommand() {
	if (btSaveCommand == null) {
		btSaveCommand = new JButton("Save");
		btSaveCommand.setEnabled(false);
		btSaveCommand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> aliases = new ArrayList<String>();
				for (String string : tfAliases.getText().trim().split(",")) {
					aliases.add(string);
				}
				
				c.setCommand(tfCmd_Name.getText());
				c.setDescription(taDescription.getText());
				c.setAliases(aliases);
				c.setPlayerOnly(cbPlayerOnly.isSelected());
				c.setUsage(tfUsage.getText());
				GUI.updateCommands();
				dispose();
			}
		});
	}
	return btSaveCommand;
}
private JTextArea getTaDescription() {
	if (taDescription == null) {
		taDescription = new JTextArea();
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

		if (getTfCmd_Name().getText().length() > 0 && getTaDescription().getText().trim().length() > 0) {
			getBtSaveCommand().setEnabled(true);
		}
		else {
			getBtSaveCommand().setEnabled(false);
		}
	
}

private JCheckBox getCbPlayerOnly() {
	if (cbPlayerOnly == null) {
		cbPlayerOnly = new JCheckBox("Player only");
		cbPlayerOnly.setSelected(true);
	}
	return cbPlayerOnly;
}

	private JPanel getPnConent() {
		if (pnConent == null) {
			pnConent = new JPanel();
			pnConent.setLayout(new BorderLayout(0, 0));
			pnConent.add(getPnCommandEdit(), BorderLayout.CENTER);
			pnConent.add(getPnBtns(), BorderLayout.SOUTH);
		}
		return pnConent;
	}
	private JButton getBtCancelCommand() {
		if (btCancelCommand == null) {
			btCancelCommand = new JButton("Cancel");
			btCancelCommand.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!isEditDialog) {
						GUI.cancelCommand(c);
					}
					dispose();
				}
			});
		}
		return btCancelCommand;
	}
}