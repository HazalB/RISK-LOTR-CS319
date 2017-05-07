import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class GameMainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private CardLayout menuCardLayout, mapCardLayout;
	private LeftColumnPanel leftColumn;
	private MapPanel mapActivePanel;
	private RightColumnPanel rightColumn;
	private ImageIcon createSoldButImage;
	private JButton createSoldBut;
	private JPanel mainMenuPanel, mainMapPanel;
	private AddSoldierPanel addSoldierPanel;
	
	public GameMainPanel(JPanel mP, CardLayout cl) {
		
		mainMenuPanel = mP;
		menuCardLayout = cl;
		
		addKeyListener(new BackToMenuListener());
		
		mapCardLayout = new CardLayout();
		mainMapPanel = new JPanel();
		
		leftColumn = new LeftColumnPanel();
		mapActivePanel = new MapPanel(mainMapPanel, mapCardLayout);
		addSoldierPanel = new AddSoldierPanel(mainMapPanel, mapCardLayout);
		rightColumn = new RightColumnPanel();
		mainMapPanel = new JPanel();
		
		mapCardLayout = new CardLayout();
		mainMapPanel.setLayout(mapCardLayout);
		
		
		mainMapPanel.add("ActiveMapPanel", mapActivePanel);
		mainMapPanel.add("addSoldierPanel", addSoldierPanel);
		
		createSoldBut = new JButton();
		createSoldButImage = new ImageIcon("images/createsoldbut.png");
		createSoldBut.setIcon(createSoldButImage);
		
		createSoldBut.setBounds(0, 260, 122, 120);
		add(createSoldBut);
		
		createSoldBut.setFocusPainted(false); 
		createSoldBut.setOpaque(false);
		createSoldBut.setContentAreaFilled(false);
		createSoldBut.setBorderPainted(false);	
		createSoldBut.setFocusable(false);
		
		mainMapPanel.setBounds(127, 0, 442, 665);
		rightColumn.setBounds(569, 0, 650, 650);
		
		add(leftColumn);
		add(mainMapPanel);
		add(rightColumn);
		setLayout(null);
		setBackground(Color.black);
		setVisible(true);
		
		setBounds(0, 0, 650, 687);
	}
	
	private class BackToMenuListener implements KeyListener{
		public void keyPressed(KeyEvent event){
			if(event.getKeyCode() == KeyEvent.VK_ESCAPE){
				menuCardLayout.show(mainMenuPanel, "menu");
			}
		}
		public void keyTyped(KeyEvent event){}
		public void keyReleased(KeyEvent event){}
	}

}
