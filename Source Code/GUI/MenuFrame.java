import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class MenuFrame extends JFrame {

	private int oldPanelID, newPanelID;
	private MenuPanel menuPanel;
	private HelpPanel helpPanel;
	private OptionsPanel optionsPanel;
	private CardLayout cardLayout;
	private JPanel mainPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MenuFrame frame = new MenuFrame();
		
		//frame.pack();
        frame.setVisible(true);
        frame.setSize(665, 687);
        frame.setBounds(0, 0, 665, 687);
        frame.setPreferredSize(new Dimension(665,687));
		
	}

	/**
	 * Create the frame.
	 */
	public MenuFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 665, 687);
		setLayout( new BorderLayout());
		
		mainPanel=new JPanel();
		add(mainPanel, BorderLayout.CENTER);
		
		setSize(665, 687);
		setVisible(true);
		setResizable(false);
		add(mainPanel, BorderLayout.CENTER);
		
		cardLayout = new CardLayout();
		mainPanel.setLayout(cardLayout);
		
		menuPanel= new MenuPanel(mainPanel, cardLayout);
		helpPanel = new HelpPanel(mainPanel, cardLayout);
		optionsPanel = new OptionsPanel(mainPanel, cardLayout);
		
		menuPanel.setPreferredSize(new Dimension(665, 687));
		helpPanel.setPreferredSize(new Dimension(665, 687));
		optionsPanel.setPreferredSize(new Dimension(665, 687));
		
		mainPanel.add("menu", menuPanel);
		mainPanel.add("help", helpPanel);
		mainPanel.add("options", optionsPanel);
		
		
	}


}
