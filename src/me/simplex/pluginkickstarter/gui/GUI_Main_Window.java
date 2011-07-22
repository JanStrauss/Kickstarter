package me.simplex.pluginkickstarter.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import me.simplex.pluginkickstarter.PluginKickstarter;
import me.simplex.pluginkickstarter.gui.util.GraphicsPanel;

public class GUI_Main_Window extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private PluginKickstarter main;
	private GUI_PnGeneralInformation pnGeneral;
	private GUI_PnPluginInformation pnPlugin;
	
	private enum Selected{Step1,Step2,Step3};
	private Selected status;
	
	private JMenuBar lb_2;
	private JMenu menu_file;
	private JMenuItem menuitem_new;
	private JMenuItem menuitem_exit;
	private JMenu menu_help;
	private JMenuItem menuitem_help;
	private JMenuItem menuitem_about;
	private JMenuItem menuitem_github;
	private JPanel pnHeaderContainer;
	private JPanel pnContent;
	private JPanel pnHeader;
	private JLabel label;
	private GraphicsPanel pnFooter;
	private JButton btNextStep;
	private JLabel lbStatus;
	private JButton btLastStep;
	
	public GUI_Main_Window(PluginKickstarter pluginSeed) {
		this.main = pluginSeed;
		this.pnGeneral = new GUI_PnGeneralInformation();
		this.pnPlugin = new GUI_PnPluginInformation(this);
		status = Selected.Step1;
		initialize();
	}
	private void initialize() {
		this.setResizable(false);
		this.setSize(800, 566);
		this.setTitle("Plugin Kickstarter");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.lookAndFeel();
		this.setIconImage(new ImageIcon(GUI_Main_Window.class.getResource("/me/simplex/pluginkickstarter/gui/images/icon_this.png")).getImage());
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		this.getContentPane().add(getPnHeaderContainer(), BorderLayout.NORTH);
		this.getContentPane().add(getPnContent(), BorderLayout.CENTER);
		this.getContentPane().add(getPnFooter(), BorderLayout.SOUTH);
		this.setJMenuBar(getMenuBar_Main());
		this.validate();
	}
	

	private JMenuBar getMenuBar_Main() {
		if (lb_2 == null) {
			lb_2 = new JMenuBar();
			lb_2.add(getMenu_file());
			lb_2.add(getMenu_help());
		}
		return lb_2;
	}
	
	private JMenu getMenu_file() {
		if (menu_file == null) {
			menu_file = new JMenu("File");
			menu_file.add(getMenuitem_new());
			menu_file.addSeparator();
			menu_file.add(getMenuitem_exit());
		}
		return menu_file;
	}
	private JMenuItem getMenuitem_new() {
		if (menuitem_new == null) {
			menuitem_new = new JMenuItem("Start new Plugin");
		}
		return menuitem_new;
	}
	private JMenuItem getMenuitem_exit() {
		if (menuitem_exit == null) {
			menuitem_exit = new JMenuItem("Exit");
			menuitem_exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return menuitem_exit;
	}
	private JMenu getMenu_help() {
		if (menu_help == null) {
			menu_help = new JMenu("?");
			menu_help.add(getMenuitem_help());
			menu_help.add(getMenuitem_github());
			menu_help.addSeparator();
			menu_help.add(getMenuitem_about());

		}
		return menu_help;
	}
	private JMenuItem getMenuitem_help() {
		if (menuitem_help == null) {
			menuitem_help = new JMenuItem("Help");
		}
		return menuitem_help;
	}
	private JMenuItem getMenuitem_about() {
		if (menuitem_about == null) {
			menuitem_about = new JMenuItem("About");
			menuitem_about.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new GUI_About(main.getVersion());
				}
			});
		}
		return menuitem_about;
	}
	private JMenuItem getMenuitem_github() {
		if (menuitem_github == null) {
			menuitem_github = new JMenuItem("Source on GitHub");
			menuitem_github.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						URI uri;
						uri = new URI("http://github.com/s1mpl3x/Buildr");
						Desktop.getDesktop().browse(uri);
					} catch (URISyntaxException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			});
			menuitem_github.setIcon(new ImageIcon(GUI_Main_Window.class.getResource("/me/simplex/pluginkickstarter/gui/images/icon_github.png")));
		}
		return menuitem_github;
	}
	private JPanel getPnHeaderContainer() {
		if (pnHeaderContainer == null) {
			pnHeaderContainer = new JPanel();
			pnHeaderContainer.setBackground(Color.GREEN);
			pnHeaderContainer.setMinimumSize(new Dimension(800, 130));
			pnHeaderContainer.setPreferredSize(pnHeaderContainer.getMinimumSize());
			pnHeaderContainer.setLayout(new BorderLayout(0, 0));
			pnHeaderContainer.add(getPnHeader(), BorderLayout.CENTER);
		}
		return pnHeaderContainer;
	}
	private JPanel getPnContent() {
		if (pnContent == null) {
			pnContent = new JPanel();
			pnContent.setLayout(new BorderLayout(0, 0));
			pnContent.add(pnGeneral,0);
		}
		return pnContent;
	}
	private JPanel getPnHeader() {
		if (pnHeader == null) {
			pnHeader = new JPanel();
			pnHeader.setLayout(new BorderLayout(0, 0));
			pnHeader.add(getLabel(), BorderLayout.CENTER);
		}
		return pnHeader;
	}
	
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("New label");
			label.setIcon(new ImageIcon(GUI_Main_Window.class.getResource("/me/simplex/pluginkickstarter/gui/images/header.png")));
		}
		return label;
	}
	private GraphicsPanel getPnFooter() {
		if (pnFooter == null) {
			pnFooter = new GraphicsPanel(true, "/me/simplex/pluginkickstarter/gui/images/footer.png");
			pnFooter.setMinimumSize(new Dimension(800, 60));
			pnFooter.setPreferredSize(pnFooter.getMinimumSize());
			pnFooter.setLayout(null);
			pnFooter.add(getBtNextStep());
			pnFooter.add(getBtLastStep());
			pnFooter.add(getLbStatus());
		}
		return pnFooter;
	}
	
	private JButton getBtNextStep() {
		if (btNextStep == null) {
			btNextStep = new JButton("Continue");
			btNextStep.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switch (status) {
					case Step1:  // 1 to 2
						status = Selected.Step2;
						lbStatus.setText("Step 2 of 3: Enter Detailed Plugin Information");
						getPnContent().removeAll();
						getPnContent().add(pnPlugin);
						getPnContent().repaint();
						getPnFooter().changeBackground("/me/simplex/pluginkickstarter/gui/images/footer2.png");
						btLastStep.setVisible(true);
						
						break;
					case Step2: // 2 to 3
						status = Selected.Step3;
						getBtNextStep().setText("Exit");
						lbStatus.setText("Step 3 of 3: Confirm output and save plugin project");
						//getBtLastStep().setVisible(false);
						break;
					case Step3: // 3 to end
						System.out.println("end");
						System.exit(0);
						break;
					}
				}
			});
			btNextStep.setBounds(620, 11, 166, 40);
		}
		return btNextStep;
	}
	private JLabel getLbStatus() {
		if (lbStatus == null) {
			lbStatus = new JLabel("Step 1 of 3: Enter basic informations");
			lbStatus.setBounds(10, 11, 590, 40);
		}
		return lbStatus;
	}
	private JButton getBtLastStep() {
		if (btLastStep == null) {
			btLastStep = new JButton("Back");
			btLastStep.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch (status) {
					case Step1:  //nope
						System.out.println("wtf");
						break;
					case Step2: //2 to 1
						status = Selected.Step1;
						lbStatus.setText("Step 1 of 3: Enter basic informations");
						getPnContent().removeAll();
						getPnContent().add(pnGeneral);
						getPnContent().repaint();
						getPnFooter().changeBackground("/me/simplex/pluginkickstarter/gui/images/footer.png");
						btLastStep.setVisible(false);
						break;
					case Step3: //3 to 2
						status = Selected.Step2;
						lbStatus.setText("Step 2 of 3: Enter Detailed Plugin Information");
						getPnContent().removeAll();
						getPnContent().add(pnPlugin);
						getPnContent().repaint();
						getBtNextStep().setText("Continue");
						break;
					}
				}
			});
			btLastStep.setBounds(500, 11, 101, 40);
			btLastStep.setVisible(false);
		}
		return btLastStep;
	}
	
	public PluginKickstarter getMain() {
		return main;
	}
}
