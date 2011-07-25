package me.simplex.pluginkickstarter.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.NumberFormatter;
import javax.swing.text.PlainDocument;

import me.simplex.pluginkickstarter.gui.util.GraphicsPanel;
import me.simplex.pluginkickstarter.storage.TaskContainer;
import me.simplex.pluginkickstarter.util.TaskType;
import javax.swing.border.MatteBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI_TaskEditor extends JDialog {
	private static final long serialVersionUID = 1L;
	private GUI_PnPluginInformation GUI;
	private JPanel panel;
	private JLabel lblType;
	private JComboBox cbType;
	private JLabel lblDelay;
	private JLabel lblTaskname;
	private JTextField tfTaskname;
	private JLabel lpPeriod;
	private JFormattedTextField tfDelay;
	private JFormattedTextField tfPeriod;
	private JCheckBox chckbxRegisterInOnenable;
	private GraphicsPanel pnBtns;
	private JButton btnSave;
	private JButton btnCancel;
	
	private TaskContainer c;	
	private boolean isEditDialog;

	public GUI_TaskEditor(GUI_PnPluginInformation gui, boolean edit, TaskContainer container) {

		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(new Rectangle(0, 0, 360, 180));
		this.GUI = gui;
		this.c = container;
		this.isEditDialog = edit;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (!isEditDialog) {
					GUI.cancelTask(c);
				}
				dispose();
			}
		});
		initialize();
		if (edit) {
			this.setTitle("Edit Task");
			getTfTaskname().setText(c.getTaskname());
			getCbType().setSelectedItem(c.getType());
			getTfPeriod().setText(""+c.getPeriod());
			getTfDelay().setText(""+c.getDelay());
			getChckbxRegisterInOnenable().setSelected(c.isRegisterAtOnEnable());
		}
		else {
			this.setTitle("New Task");
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
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		getContentPane().add(getPnBtns(), BorderLayout.SOUTH);
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new EmptyBorder(10, 10, 10, 10));
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_lblTaskname = new GridBagConstraints();
			gbc_lblTaskname.anchor = GridBagConstraints.WEST;
			gbc_lblTaskname.insets = new Insets(0, 0, 5, 5);
			gbc_lblTaskname.gridx = 0;
			gbc_lblTaskname.gridy = 0;
			panel.add(getLblTaskname(), gbc_lblTaskname);
			GridBagConstraints gbc_tfTaskname = new GridBagConstraints();
			gbc_tfTaskname.gridwidth = 3;
			gbc_tfTaskname.insets = new Insets(0, 0, 5, 0);
			gbc_tfTaskname.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfTaskname.gridx = 1;
			gbc_tfTaskname.gridy = 0;
			panel.add(getTfTaskname(), gbc_tfTaskname);
			GridBagConstraints gbc_lblType = new GridBagConstraints();
			gbc_lblType.insets = new Insets(0, 0, 5, 5);
			gbc_lblType.anchor = GridBagConstraints.WEST;
			gbc_lblType.gridx = 0;
			gbc_lblType.gridy = 1;
			panel.add(getLblType(), gbc_lblType);
			GridBagConstraints gbc_cbType = new GridBagConstraints();
			gbc_cbType.gridwidth = 3;
			gbc_cbType.insets = new Insets(0, 0, 5, 0);
			gbc_cbType.fill = GridBagConstraints.HORIZONTAL;
			gbc_cbType.gridx = 1;
			gbc_cbType.gridy = 1;
			panel.add(getCbType(), gbc_cbType);
			GridBagConstraints gbc_lblDelay = new GridBagConstraints();
			gbc_lblDelay.anchor = GridBagConstraints.WEST;
			gbc_lblDelay.insets = new Insets(0, 0, 5, 5);
			gbc_lblDelay.gridx = 0;
			gbc_lblDelay.gridy = 2;
			panel.add(getLblDelay(), gbc_lblDelay);
			GridBagConstraints gbc_tfDelay = new GridBagConstraints();
			gbc_tfDelay.insets = new Insets(0, 0, 5, 5);
			gbc_tfDelay.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfDelay.gridx = 1;
			gbc_tfDelay.gridy = 2;
			panel.add(getTfDelay(), gbc_tfDelay);
			GridBagConstraints gbc_lpPeriod = new GridBagConstraints();
			gbc_lpPeriod.insets = new Insets(0, 0, 5, 5);
			gbc_lpPeriod.anchor = GridBagConstraints.WEST;
			gbc_lpPeriod.gridx = 2;
			gbc_lpPeriod.gridy = 2;
			panel.add(getLpPeriod(), gbc_lpPeriod);
			GridBagConstraints gbc_tfOffset = new GridBagConstraints();
			gbc_tfOffset.insets = new Insets(0, 0, 5, 0);
			gbc_tfOffset.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfOffset.gridx = 3;
			gbc_tfOffset.gridy = 2;
			panel.add(getTfPeriod(), gbc_tfOffset);
			GridBagConstraints gbc_chckbxRegisterInOnenable = new GridBagConstraints();
			gbc_chckbxRegisterInOnenable.gridwidth = 2;
			gbc_chckbxRegisterInOnenable.anchor = GridBagConstraints.WEST;
			gbc_chckbxRegisterInOnenable.insets = new Insets(0, 0, 0, 5);
			gbc_chckbxRegisterInOnenable.gridx = 1;
			gbc_chckbxRegisterInOnenable.gridy = 3;
			panel.add(getChckbxRegisterInOnenable(), gbc_chckbxRegisterInOnenable);
		}
		return panel;
	}
	private JLabel getLblType() {
		if (lblType == null) {
			lblType = new JLabel("Type:");
		}
		return lblType;
	}
	private JComboBox getCbType() {
		if (cbType == null) {
			cbType = new JComboBox(TaskType.values());
			cbType.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					TaskType t = (TaskType) cbType.getSelectedItem();	
					switch (t) {
					case AsyncDelayedTask: 
						getTfDelay().setEnabled(false);
						getTfPeriod().setEnabled(true);
						break;
					case AsyncRepeatingTask:
						getTfDelay().setEnabled(true);
						getTfPeriod().setEnabled(true);
						break;
					case AsyncTask:
						getTfDelay().setEnabled(false);
						getTfPeriod().setEnabled(false);
						break;
					case SyncDeplayedTask:
						getTfDelay().setEnabled(false);
						getTfPeriod().setEnabled(true);
						break;
					case SyncRepeatingTask: 
						getTfDelay().setEnabled(true);
						getTfPeriod().setEnabled(true);
						break;
					case SyncTask: 
						getTfDelay().setEnabled(false);
						getTfPeriod().setEnabled(false);
						break;
					default:break;
					}
				}
			});
		}
		return cbType;
	}
	private JLabel getLblDelay() {
		if (lblDelay == null) {
			lblDelay = new JLabel("Delay (in seconds):");
		}
		return lblDelay;
	}
	private JLabel getLblTaskname() {
		if (lblTaskname == null) {
			lblTaskname = new JLabel("Taskname:");
		}
		return lblTaskname;
	}
	private JTextField getTfTaskname() {
		if (tfTaskname == null) {
			tfTaskname = new JTextField();
			tfTaskname.setColumns(10);
			tfTaskname.setDocument(new PlainDocument(){
				private static final long serialVersionUID = 1L;

				@Override
				public void insertString(int offs, String str, AttributeSet a)throws BadLocationException {
					str=str.replace(" ", "");
					super.insertString(offs, str, a);
				}
			});
			tfTaskname.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					checkUnlockOk();
					
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					checkUnlockOk();
					
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					checkUnlockOk();
					
				}
			});
		}
		return tfTaskname;
	}
	
	private void checkUnlockOk(){
		if (getTfTaskname().getText().length() > 0 && getTfDelay().getText().length() > 0 && getTfPeriod().getText().length() > 0) {
			getBtnSave().setEnabled(true);
		}
		else {
			getBtnSave().setEnabled(false);
		}
	}
	
	private JLabel getLpPeriod() {
		if (lpPeriod == null) {
			lpPeriod = new JLabel("Period (in seconds):");
		}
		return lpPeriod;
	}
	private JFormattedTextField getTfDelay() {
		if (tfDelay == null) {
	        NumberFormat format = NumberFormat.getInstance();
			tfDelay = new JFormattedTextField(format);
			tfDelay.setText("5");
	        ((NumberFormatter)tfDelay.getFormatter()).setAllowsInvalid(false);
			tfDelay.setColumns(10);
		}
		return tfDelay;
	}
	private JFormattedTextField getTfPeriod() {
		if (tfPeriod == null) {
	        NumberFormat format = NumberFormat.getInstance();
			tfPeriod = new JFormattedTextField(format);
			tfPeriod.setText("5");
	        ((NumberFormatter)tfPeriod.getFormatter()).setAllowsInvalid(false);
			tfPeriod.setColumns(10);
		}
		return tfPeriod;
	}
	private JCheckBox getChckbxRegisterInOnenable() {
		if (chckbxRegisterInOnenable == null) {
			chckbxRegisterInOnenable = new JCheckBox("Start in onEnable()");
		}
		return chckbxRegisterInOnenable;
	}
	private GraphicsPanel getPnBtns() {
		if (pnBtns == null) {
			pnBtns = new GraphicsPanel(false, "/me/simplex/pluginkickstarter/gui/images/bg_sel.png");
			pnBtns.setBorder(new MatteBorder(3, 0, 0, 0, (Color) Color.DARK_GRAY));
			pnBtns.setBackground(new Color(105, 105, 105));
			FlowLayout fl_pnBtns = (FlowLayout) pnBtns.getLayout();
			fl_pnBtns.setAlignment(FlowLayout.RIGHT);
			pnBtns.add(getBtnSave());
			pnBtns.add(getBtnCancel());
		}
		return pnBtns;
	}
	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Save");
			btnSave.setEnabled(false);
			btnSave.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					c.setType((TaskType) cbType.getSelectedItem());
					c.setTaskname(tfTaskname.getText());
					c.setDelay(Long.valueOf(tfDelay.getText()));
					c.setPeriod(Long.valueOf(tfPeriod.getText()));
					c.setRegisterAtOnEnable(chckbxRegisterInOnenable.isSelected());
					GUI.updateTasks();
					dispose();
				}
			});
		}
		return btnSave;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (!isEditDialog) {
						GUI.cancelTask(c);
					}
					dispose();
				}
			});
		}
		return btnCancel;
	}
}
