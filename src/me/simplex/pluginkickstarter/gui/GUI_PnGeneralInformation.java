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
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

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
	private JCheckBox cbUsePermissions;
	private JCheckBox cbUseConfig;
	private JCheckBox cbEveryCommandownExecutor;
	private JCheckBox cbPluginYML;
	private JCheckBox chckbxGenerateProjectdataFor;
	private JLabel lbDepends;
	private JTextField tfDepends;
	private JLabel lbSoftdepends;
	private JTextField tfSoftdepends;
	
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
					checkData();
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					checkData();
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					checkData();
				}
				
			});
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
					checkData();
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					checkData();
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					checkData();
				}
				
			});
			tfAuthor.setText(System.getProperty("user.name"));
		}
		return tfAuthor;
	}
	
	private void checkData(){
		if (getTfAuthor().getText().trim().length() > 0 && getTfPluginname().getText().trim().length() > 0) {
			GUI.getBtNextStep().setEnabled(true);
		}
		else {
			GUI.getBtNextStep().setEnabled(false);
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
			gbl_pnLeft.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnLeft.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_pnLeft.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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
			GridBagConstraints gbc_lbWebsite = new GridBagConstraints();
			gbc_lbWebsite.anchor = GridBagConstraints.WEST;
			gbc_lbWebsite.insets = new Insets(0, 0, 5, 5);
			gbc_lbWebsite.gridx = 0;
			gbc_lbWebsite.gridy = 2;
			pnLeft.add(getLbWebsite(), gbc_lbWebsite);
			GridBagConstraints gbc_tfWebsite = new GridBagConstraints();
			gbc_tfWebsite.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfWebsite.insets = new Insets(0, 0, 5, 0);
			gbc_tfWebsite.gridx = 1;
			gbc_tfWebsite.gridy = 2;
			pnLeft.add(getTfWebsite(), gbc_tfWebsite);
			GridBagConstraints gbc_lbVersion = new GridBagConstraints();
			gbc_lbVersion.anchor = GridBagConstraints.WEST;
			gbc_lbVersion.insets = new Insets(0, 0, 5, 5);
			gbc_lbVersion.gridx = 0;
			gbc_lbVersion.gridy = 3;
			pnLeft.add(getLbVersion(), gbc_lbVersion);
			GridBagConstraints gbc_tfVersion = new GridBagConstraints();
			gbc_tfVersion.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfVersion.insets = new Insets(0, 0, 5, 0);
			gbc_tfVersion.gridx = 1;
			gbc_tfVersion.gridy = 3;
			pnLeft.add(getTfVersion(), gbc_tfVersion);
			GridBagConstraints gbc_lbDesc = new GridBagConstraints();
			gbc_lbDesc.anchor = GridBagConstraints.NORTHWEST;
			gbc_lbDesc.insets = new Insets(0, 0, 5, 5);
			gbc_lbDesc.gridx = 0;
			gbc_lbDesc.gridy = 4;
			pnLeft.add(getLabel_1(), gbc_lbDesc);
			GridBagConstraints gbc_spDesc = new GridBagConstraints();
			gbc_spDesc.insets = new Insets(0, 0, 5, 0);
			gbc_spDesc.fill = GridBagConstraints.BOTH;
			gbc_spDesc.gridx = 1;
			gbc_spDesc.gridy = 4;
			pnLeft.add(getSpDesc(), gbc_spDesc);
			GridBagConstraints gbc_lbDepends = new GridBagConstraints();
			gbc_lbDepends.anchor = GridBagConstraints.WEST;
			gbc_lbDepends.insets = new Insets(0, 0, 5, 5);
			gbc_lbDepends.gridx = 0;
			gbc_lbDepends.gridy = 5;
			pnLeft.add(getLbDepends(), gbc_lbDepends);
			GridBagConstraints gbc_tfDepends = new GridBagConstraints();
			gbc_tfDepends.insets = new Insets(0, 0, 5, 0);
			gbc_tfDepends.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfDepends.gridx = 1;
			gbc_tfDepends.gridy = 5;
			pnLeft.add(getTfDepends(), gbc_tfDepends);
			GridBagConstraints gbc_lbSoftdepends = new GridBagConstraints();
			gbc_lbSoftdepends.anchor = GridBagConstraints.WEST;
			gbc_lbSoftdepends.insets = new Insets(0, 0, 0, 5);
			gbc_lbSoftdepends.gridx = 0;
			gbc_lbSoftdepends.gridy = 6;
			pnLeft.add(getLbSoftdepends(), gbc_lbSoftdepends);
			GridBagConstraints gbc_tfSoftdepends = new GridBagConstraints();
			gbc_tfSoftdepends.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfSoftdepends.gridx = 1;
			gbc_tfSoftdepends.gridy = 6;
			pnLeft.add(getTfSoftdepends(), gbc_tfSoftdepends);
		}
		return pnLeft;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Generator Configuration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5)));
			panel.setBounds(400, 10, 380, 170);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_cbUsePermissions = new GridBagConstraints();
			gbc_cbUsePermissions.anchor = GridBagConstraints.WEST;
			gbc_cbUsePermissions.insets = new Insets(0, 0, 5, 5);
			gbc_cbUsePermissions.gridx = 0;
			gbc_cbUsePermissions.gridy = 0;
			panel.add(getCbUsePermissions(), gbc_cbUsePermissions);
			GridBagConstraints gbc_cbUseConfig = new GridBagConstraints();
			gbc_cbUseConfig.anchor = GridBagConstraints.WEST;
			gbc_cbUseConfig.insets = new Insets(0, 0, 5, 5);
			gbc_cbUseConfig.gridx = 0;
			gbc_cbUseConfig.gridy = 1;
			panel.add(getCbUseConfig(), gbc_cbUseConfig);
			GridBagConstraints gbc_cbEveryCommandownExecutor = new GridBagConstraints();
			gbc_cbEveryCommandownExecutor.anchor = GridBagConstraints.WEST;
			gbc_cbEveryCommandownExecutor.insets = new Insets(0, 0, 5, 5);
			gbc_cbEveryCommandownExecutor.gridx = 0;
			gbc_cbEveryCommandownExecutor.gridy = 2;
			panel.add(getCbEveryCommandownExecutor(), gbc_cbEveryCommandownExecutor);
			GridBagConstraints gbc_cbPluginYML = new GridBagConstraints();
			gbc_cbPluginYML.anchor = GridBagConstraints.WEST;
			gbc_cbPluginYML.insets = new Insets(0, 0, 5, 5);
			gbc_cbPluginYML.gridx = 0;
			gbc_cbPluginYML.gridy = 3;
			panel.add(getCbPluginYML(), gbc_cbPluginYML);
			GridBagConstraints gbc_chckbxGenerateProjectdataFor = new GridBagConstraints();
			gbc_chckbxGenerateProjectdataFor.anchor = GridBagConstraints.WEST;
			gbc_chckbxGenerateProjectdataFor.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxGenerateProjectdataFor.gridx = 0;
			gbc_chckbxGenerateProjectdataFor.gridy = 4;
			panel.add(getChckbxGenerateProjectdataFor(), gbc_chckbxGenerateProjectdataFor);
		}
		return panel;
	}
	private JCheckBox getCbUsePermissions() {
		if (cbUsePermissions == null) {
			cbUsePermissions = new JCheckBox("Setup Permissions");
			cbUsePermissions.setSelected(true);
		}
		return cbUsePermissions;
	}
	private JCheckBox getCbUseConfig() {
		if (cbUseConfig == null) {
			cbUseConfig = new JCheckBox("Generate Configloader *todo*");
			cbUseConfig.setEnabled(false);
			cbUseConfig.setSelected(true);
		}
		return cbUseConfig;
	}
	private JCheckBox getCbEveryCommandownExecutor() {
		if (cbEveryCommandownExecutor == null) {
			cbEveryCommandownExecutor = new JCheckBox("Generate a  own CommandExecutor for each command");
			cbEveryCommandownExecutor.setSelected(true);
			cbEveryCommandownExecutor.setToolTipText("Generate a CommandExecutor for each Command");
		}
		return cbEveryCommandownExecutor;
	}
	private JCheckBox getCbPluginYML() {
		if (cbPluginYML == null) {
			cbPluginYML = new JCheckBox("Generate the plugin.yml file");
			cbPluginYML.setSelected(true);
		}
		return cbPluginYML;
	}
	private JCheckBox getChckbxGenerateProjectdataFor() {
		if (chckbxGenerateProjectdataFor == null) {
			chckbxGenerateProjectdataFor = new JCheckBox("Generate .project file for Eclipse");
		}
		return chckbxGenerateProjectdataFor;
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
}
