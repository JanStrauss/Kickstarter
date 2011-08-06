package me.simplex.pluginkickstarter.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import me.simplex.pluginkickstarter.DataStorage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_PnGeneralInformation extends JPanel {
	private static final long serialVersionUID = 1L;
	private GUI_Main_Window GUI;
	
	private JTextField tfPluginname;
	private JTextField tfAuthor;
	private JLabel lblPluginname;
	private JLabel lbAuthor;
	private JLabel lbWebsite;
	private JTextField tfWebsite;
	private JTextField tfVersion;
	private JLabel lbVersion;
	private JLabel lbDesc;
	private JTextArea taDesc;
	private JScrollPane spDesc;
	private JPanel pnLeft;
	private JPanel panel;
	private JCheckBox cbGenerateListeners;
	private JCheckBox cbGenerateConfiguration;
	private JCheckBox cbGenerateCommands;
	private JCheckBox cbGenerateTasks;
	private JLabel lbDepends;
	private JTextField tfDepends;
	private JLabel lbSoftdepends;
	private JTextField tfSoftdepends;
	private JPanel panel_1;
	private JLabel lbPackage;
	private JTextField tfPackage;
	
	public GUI_PnGeneralInformation(GUI_Main_Window gui) {
		this.GUI = gui;
		initialize();
	}
	private void initialize() {
		this.setSize(800, 333);
		setLayout(null);
		this.add(getPnLeft());
		add(getPanel());
		this.setEnabled(true);
		getTfPluginname().requestFocus();
		add(getPanel_1());
	}
	
	public void updataData() {
		DataStorage s = GUI.getMain().getData();

		s.setAuthor(getTfAuthor().getText());
		s.setPluginname(getTfPluginname().getText());
		s.setDescription(getTaDesc().getText());
		s.setWebsite(getTfWebsite().getText());
		s.setVersion(getTfVersion().getText());
		s.setSoftdepends(getTfSoftdepends().getText());
		s.setDepends(getTfDepends().getText());
		s.setPackage(getTfPackage().getText());
	}
	
	private JTextField getTfPluginname() {
		if (tfPluginname == null) {
			tfPluginname = new JTextField();
			tfPluginname.setColumns(10);
			tfPluginname.setDocument(new PlainDocument(){
				private static final long serialVersionUID = 1L;
				@Override
				public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
					str = str.replace(",", "");
					str = str.replace(" ", "");
					str = str.replace(".", "");
					super.insertString(offs, str, a);
				}
			});
			tfPluginname.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					checkData(false);
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					checkData(false);
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					checkData(false);
				}
				
			});
			tfPluginname.setText("NewPlugin");
		}
		return tfPluginname;
	}
	private JTextField getTfAuthor() {
		if (tfAuthor == null) {
			tfAuthor = new JTextField();
			tfAuthor.setColumns(10);
			tfAuthor.setDocument(new PlainDocument(){
				private static final long serialVersionUID = 1L;
				@Override
				public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
					str = str.replace(",", "");
					str = str.replace(" ", "");
					str = str.replace(".", "");
					super.insertString(offs, str, a);
				}
			});
			tfAuthor.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					checkData(false);
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					checkData(false);
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					checkData(false);
				}
				
			});
			tfAuthor.setText(System.getProperty("user.name"));
		}
		return tfAuthor;
	}
	
	private void checkData(boolean TFpackage){
		if (getTfAuthor().getText().trim().length() > 0 && getTfPluginname().getText().trim().length() > 0 && getTfPackage().getText().trim().length() > 0) {
			GUI.getBtNextStep().setEnabled(true);
		}
		else {
			GUI.getBtNextStep().setEnabled(false);
		}
		
		if (!TFpackage) {
			if (!getTfPackage().hasFocus() && (getTfAuthor().hasFocus() || getTfPluginname().hasFocus())) {
				SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					tfPackage.setText("me."+getTfAuthor().getText().toLowerCase()+"."+getTfPluginname().getText().toLowerCase());
					System.out.println("derp");
				}
				});
			}
		}
	}
	
	private JLabel getLblPluginname() {
		if (lblPluginname == null) {
			lblPluginname = new JLabel("Pluginname:");
			lblPluginname.setLabelFor(getTfPluginname());
		}
		return lblPluginname;
	}
	private JLabel getLbAuthor() {
		if (lbAuthor == null) {
			lbAuthor = new JLabel("Author:");
			lbAuthor.setLabelFor(getTfAuthor());
		}
		return lbAuthor;
	}
	private JLabel getLbWebsite() {
		if (lbWebsite == null) {
			lbWebsite = new JLabel("Website:");
			lbWebsite.setLabelFor(getTfWebsite());
		}
		return lbWebsite;
	}
	private JTextField getTfWebsite() {
		if (tfWebsite == null) {
			tfWebsite = new JTextField();
			tfWebsite.setText("http://");
			tfWebsite.setColumns(10);
		}
		return tfWebsite;
	}
	private JTextField getTfVersion() {
		if (tfVersion == null) {
			tfVersion = new JTextField();
			tfVersion.setText("0.1");
			tfVersion.setColumns(10);
		}
		return tfVersion;
	}
	private JLabel getLbVersion() {
		if (lbVersion == null) {
			lbVersion = new JLabel("Version:");
			lbVersion.setLabelFor(getTfVersion());
		}
		return lbVersion;
	}
	private JLabel getLabel_1() {
		if (lbDesc == null) {
			lbDesc = new JLabel("Description:");
		}
		return lbDesc;
	}
	private JTextArea getTaDesc() {
		if (taDesc == null) {
			taDesc = new JTextArea();
			taDesc.setFont(UIManager.getFont("TextField.font"));
			taDesc.setLineWrap(true);
			taDesc.setText("i can haz awsum plugin plx k thx!!!1 ");
			taDesc.setEditable(true);
		}
		return taDesc;
	}
	
	private JScrollPane getSpDesc(){
		if (spDesc == null) {
			spDesc = new JScrollPane();
			spDesc.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			spDesc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			spDesc.setViewportView(getTaDesc());
		}
		return spDesc;
	}
	private JPanel getPnLeft() {
		if (pnLeft == null) {
			pnLeft = new JPanel();
			pnLeft.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Plugin Metainformation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5)));
			pnLeft.setBounds(10, 10, 380, 300);
			GridBagLayout gbl_pnLeft = new GridBagLayout();
			gbl_pnLeft.columnWidths = new int[]{0, 0, 0};
			gbl_pnLeft.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnLeft.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_pnLeft.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
			pnLeft.setLayout(gbl_pnLeft);
			GridBagConstraints gbc_lblPluginname = new GridBagConstraints();
			gbc_lblPluginname.anchor = GridBagConstraints.WEST;
			gbc_lblPluginname.insets = new Insets(0, 0, 5, 5);
			gbc_lblPluginname.gridx = 0;
			gbc_lblPluginname.gridy = 0;
			pnLeft.add(getLblPluginname(), gbc_lblPluginname);
			GridBagConstraints gbc_tfPluginname = new GridBagConstraints();
			gbc_tfPluginname.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfPluginname.insets = new Insets(0, 0, 5, 0);
			gbc_tfPluginname.gridx = 1;
			gbc_tfPluginname.gridy = 0;
			pnLeft.add(getTfPluginname(), gbc_tfPluginname);
			GridBagConstraints gbc_lbAuthor = new GridBagConstraints();
			gbc_lbAuthor.anchor = GridBagConstraints.WEST;
			gbc_lbAuthor.insets = new Insets(0, 0, 5, 5);
			gbc_lbAuthor.gridx = 0;
			gbc_lbAuthor.gridy = 1;
			pnLeft.add(getLbAuthor(), gbc_lbAuthor);
			GridBagConstraints gbc_tfAuthor = new GridBagConstraints();
			gbc_tfAuthor.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfAuthor.insets = new Insets(0, 0, 5, 0);
			gbc_tfAuthor.gridx = 1;
			gbc_tfAuthor.gridy = 1;
			pnLeft.add(getTfAuthor(), gbc_tfAuthor);
			GridBagConstraints gbc_lbPackage = new GridBagConstraints();
			gbc_lbPackage.anchor = GridBagConstraints.WEST;
			gbc_lbPackage.insets = new Insets(0, 0, 5, 5);
			gbc_lbPackage.gridx = 0;
			gbc_lbPackage.gridy = 2;
			pnLeft.add(getLbPackage(), gbc_lbPackage);
			GridBagConstraints gbc_tfPackage = new GridBagConstraints();
			gbc_tfPackage.insets = new Insets(0, 0, 5, 0);
			gbc_tfPackage.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfPackage.gridx = 1;
			gbc_tfPackage.gridy = 2;
			pnLeft.add(getTfPackage(), gbc_tfPackage);
			GridBagConstraints gbc_lbWebsite = new GridBagConstraints();
			gbc_lbWebsite.anchor = GridBagConstraints.WEST;
			gbc_lbWebsite.insets = new Insets(0, 0, 5, 5);
			gbc_lbWebsite.gridx = 0;
			gbc_lbWebsite.gridy = 3;
			pnLeft.add(getLbWebsite(), gbc_lbWebsite);
			GridBagConstraints gbc_tfWebsite = new GridBagConstraints();
			gbc_tfWebsite.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfWebsite.insets = new Insets(0, 0, 5, 0);
			gbc_tfWebsite.gridx = 1;
			gbc_tfWebsite.gridy = 3;
			pnLeft.add(getTfWebsite(), gbc_tfWebsite);
			GridBagConstraints gbc_lbVersion = new GridBagConstraints();
			gbc_lbVersion.anchor = GridBagConstraints.WEST;
			gbc_lbVersion.insets = new Insets(0, 0, 5, 5);
			gbc_lbVersion.gridx = 0;
			gbc_lbVersion.gridy = 4;
			pnLeft.add(getLbVersion(), gbc_lbVersion);
			GridBagConstraints gbc_tfVersion = new GridBagConstraints();
			gbc_tfVersion.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfVersion.insets = new Insets(0, 0, 5, 0);
			gbc_tfVersion.gridx = 1;
			gbc_tfVersion.gridy = 4;
			pnLeft.add(getTfVersion(), gbc_tfVersion);
			GridBagConstraints gbc_lbDesc = new GridBagConstraints();
			gbc_lbDesc.anchor = GridBagConstraints.NORTHWEST;
			gbc_lbDesc.insets = new Insets(0, 0, 5, 5);
			gbc_lbDesc.gridx = 0;
			gbc_lbDesc.gridy = 5;
			pnLeft.add(getLabel_1(), gbc_lbDesc);
			GridBagConstraints gbc_spDesc = new GridBagConstraints();
			gbc_spDesc.insets = new Insets(0, 0, 5, 0);
			gbc_spDesc.fill = GridBagConstraints.BOTH;
			gbc_spDesc.gridx = 1;
			gbc_spDesc.gridy = 5;
			pnLeft.add(getSpDesc(), gbc_spDesc);
			GridBagConstraints gbc_lbDepends = new GridBagConstraints();
			gbc_lbDepends.anchor = GridBagConstraints.WEST;
			gbc_lbDepends.insets = new Insets(0, 0, 5, 5);
			gbc_lbDepends.gridx = 0;
			gbc_lbDepends.gridy = 6;
			pnLeft.add(getLbDepends(), gbc_lbDepends);
			GridBagConstraints gbc_tfDepends = new GridBagConstraints();
			gbc_tfDepends.insets = new Insets(0, 0, 5, 0);
			gbc_tfDepends.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfDepends.gridx = 1;
			gbc_tfDepends.gridy = 6;
			pnLeft.add(getTfDepends(), gbc_tfDepends);
			GridBagConstraints gbc_lbSoftdepends = new GridBagConstraints();
			gbc_lbSoftdepends.anchor = GridBagConstraints.WEST;
			gbc_lbSoftdepends.insets = new Insets(0, 0, 0, 5);
			gbc_lbSoftdepends.gridx = 0;
			gbc_lbSoftdepends.gridy = 7;
			pnLeft.add(getLbSoftdepends(), gbc_lbSoftdepends);
			GridBagConstraints gbc_tfSoftdepends = new GridBagConstraints();
			gbc_tfSoftdepends.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfSoftdepends.gridx = 1;
			gbc_tfSoftdepends.gridy = 7;
			pnLeft.add(getTfSoftdepends(), gbc_tfSoftdepends);
		}
		return pnLeft;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Generator Configuration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5)));
			panel.setBounds(400, 10, 380, 150);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_cbGenerateListeners = new GridBagConstraints();
			gbc_cbGenerateListeners.anchor = GridBagConstraints.WEST;
			gbc_cbGenerateListeners.insets = new Insets(0, 0, 5, 5);
			gbc_cbGenerateListeners.gridx = 0;
			gbc_cbGenerateListeners.gridy = 0;
			panel.add(getCbGenerateListeners(), gbc_cbGenerateListeners);
			GridBagConstraints gbc_cbGenerateConfiguration = new GridBagConstraints();
			gbc_cbGenerateConfiguration.anchor = GridBagConstraints.WEST;
			gbc_cbGenerateConfiguration.insets = new Insets(0, 0, 5, 5);
			gbc_cbGenerateConfiguration.gridx = 0;
			gbc_cbGenerateConfiguration.gridy = 1;
			panel.add(getCbGenerateConfiguration(), gbc_cbGenerateConfiguration);
			GridBagConstraints gbc_cbGenerateCommands = new GridBagConstraints();
			gbc_cbGenerateCommands.anchor = GridBagConstraints.WEST;
			gbc_cbGenerateCommands.insets = new Insets(0, 0, 5, 5);
			gbc_cbGenerateCommands.gridx = 0;
			gbc_cbGenerateCommands.gridy = 2;
			panel.add(getCbGenerateCommands(), gbc_cbGenerateCommands);
			GridBagConstraints gbc_cbGenerateTasks = new GridBagConstraints();
			gbc_cbGenerateTasks.anchor = GridBagConstraints.WEST;
			gbc_cbGenerateTasks.insets = new Insets(0, 0, 0, 5);
			gbc_cbGenerateTasks.gridx = 0;
			gbc_cbGenerateTasks.gridy = 3;
			panel.add(getCbGenerateTasks(), gbc_cbGenerateTasks);
		}
		return panel;
	}
	private JCheckBox getCbGenerateListeners() {
		if (cbGenerateListeners == null) {
			cbGenerateListeners = new JCheckBox("Generate Listeners");
			cbGenerateListeners.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI.getMain().getData().setGen_listener(cbGenerateListeners.isSelected());
				}
			});
			cbGenerateListeners.setSelected(true);
		}
		return cbGenerateListeners;
	}
	private JCheckBox getCbGenerateConfiguration() {
		if (cbGenerateConfiguration == null) {
			cbGenerateConfiguration = new JCheckBox("Generate Configuration");
			cbGenerateConfiguration.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI.getMain().getData().setGen_configuration(cbGenerateConfiguration.isSelected());
				}
			});
			cbGenerateConfiguration.setSelected(true);
		}
		return cbGenerateConfiguration;
	}
	private JCheckBox getCbGenerateCommands() {
		if (cbGenerateCommands == null) {
			cbGenerateCommands = new JCheckBox("Generate Commands");
			cbGenerateCommands.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI.getMain().getData().setGen_commands(cbGenerateCommands.isSelected());
				}
			});
			cbGenerateCommands.setSelected(true);
			cbGenerateCommands.setToolTipText("");
		}
		return cbGenerateCommands;
	}
	private JCheckBox getCbGenerateTasks() {
		if (cbGenerateTasks == null) {
			cbGenerateTasks = new JCheckBox("Generate Tasks");
			cbGenerateTasks.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI.getMain().getData().setGen_tasks(cbGenerateTasks.isSelected());
				}
			});
			cbGenerateTasks.setSelected(true);
		}
		return cbGenerateTasks;
	}
	private JLabel getLbDepends() {
		if (lbDepends == null) {
			lbDepends = new JLabel("Depends:");
			lbDepends.setToolTipText("Comma seperated");
		}
		return lbDepends;
	}
	private JTextField getTfDepends() {
		if (tfDepends == null) {
			tfDepends = new JTextField();
			tfDepends.setColumns(10);
		}
		return tfDepends;
	}
	private JLabel getLbSoftdepends() {
		if (lbSoftdepends == null) {
			lbSoftdepends = new JLabel("Softdepends:");
			lbSoftdepends.setToolTipText("Comma seperated");
		}
		return lbSoftdepends;
	}
	private JTextField getTfSoftdepends() {
		if (tfSoftdepends == null) {
			tfSoftdepends = new JTextField();
			tfSoftdepends.setColumns(10);
		}
		return tfSoftdepends;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Advanced Configuration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5)));
			panel_1.setBounds(400, 165, 380, 145);
		}
		return panel_1;
	}
	private JLabel getLbPackage() {
		if (lbPackage == null) {
			lbPackage = new JLabel("Package:");
		}
		return lbPackage;
	}
	private JTextField getTfPackage() {
		if (tfPackage == null) {
			tfPackage = new JTextField();
			tfPackage.setColumns(10);
			tfPackage.setDocument(new PlainDocument(){
				private static final long serialVersionUID = 1L;
				@Override
				public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
					str = str.replace(",", "");
					str = str.replace(" ", "");
					str = str.replace(";", "");
					str = str.replace("!", "");
					super.insertString(offs, str, a);
				}
			});
			tfPackage.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					checkData(true);
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					checkData(true);
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					checkData(true);
				}
				
			});
			tfPackage.setText("me."+getTfAuthor().getText().toLowerCase()+"."+getTfPluginname().getText().toLowerCase());
		}
		return tfPackage;
	}
}
