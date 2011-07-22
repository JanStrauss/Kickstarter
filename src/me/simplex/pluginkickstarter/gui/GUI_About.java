package me.simplex.pluginkickstarter.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI_About extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lblTrollin;
	private JPanel panel;
	private String version;
	
	public GUI_About(String version) {
		this.version = version;
		initialize();
	}
	private void initialize() {
		this.setSize(360, 133);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Plugin Kickstarter - About");
		this.setIconImage(new ImageIcon(GUI_Main_Window.class.getResource("/me/simplex/pluginkickstarter/gui/images/icon_this.png")).getImage());
		setContentPane(getPanel());
	}
	private JLabel getLblTrollin() {
		if (lblTrollin == null) {
			lblTrollin = new JLabel(version);
			lblTrollin.setForeground(Color.WHITE);
			lblTrollin.setBounds(10, 83, 121, 25);
		}
		return lblTrollin;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0,360, 133, new ImageIcon(getClass().getResource("/me/simplex/pluginkickstarter/gui/images/about.png"))));
			panel.setLayout(null);
			panel.add(getLblTrollin());
			panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					setVisible(false);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});

		}
		return panel;
	}
}
