import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class AddSoldierPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel mainPanel;
	private CardLayout cardLayout;
	private Image background;
	private JButton swordsman, axeman, spearman, archer, cavalry, wargRiders, mumakil, nazgul;
	
	public AddSoldierPanel(JPanel mP, CardLayout cl) {
		mainPanel=mP;
		cardLayout=cl;
		
		swordsman = new JButton();
		axeman = new JButton();
		spearman = new JButton();
		archer = new JButton();
		wargRiders = new JButton();
		mumakil = new JButton();
		nazgul = new JButton();
		
		swordsman.setIcon(new ImageIcon("images/swordsmanbut.png"));
		swordsman.setBounds(40, 131, 107, 107);
		swordsman.setFocusPainted(false); 
		swordsman.setOpaque(false);
		swordsman.setContentAreaFilled(false);
		swordsman.setBorderPainted(false);	
		swordsman.setFocusable(false);
		
		axeman.setIcon(new ImageIcon("images/axemanbut.png"));
		axeman.setBounds(175, 131, 107, 107);
		axeman.setFocusPainted(false); 
		axeman.setOpaque(false);
		axeman.setContentAreaFilled(false);
		axeman.setBorderPainted(false);	
		axeman.setFocusable(false);
		
		spearman.setIcon(new ImageIcon("images/spearmanbut.png"));
		spearman.setBounds(310, 131, 107, 107);
		spearman.setFocusPainted(false); 
		spearman.setOpaque(false);
		spearman.setContentAreaFilled(false);
		spearman.setBorderPainted(false);	
		spearman.setFocusable(false);
		
		archer.setIcon(new ImageIcon("images/archerbut.png"));
		archer.setBounds(110, 250, 107, 107);
		archer.setFocusPainted(false); 
		archer.setOpaque(false);
		archer.setContentAreaFilled(false);
		archer.setBorderPainted(false);	
		archer.setFocusable(false);
		
		wargRiders.setIcon(new ImageIcon("images/warg-ridersbut.png"));
		wargRiders.setBounds(245, 250, 107, 107);
		wargRiders.setFocusPainted(false); 
		wargRiders.setOpaque(false);
		wargRiders.setContentAreaFilled(false);
		wargRiders.setBorderPainted(false);	
		wargRiders.setFocusable(false);
		
		
		
		add(swordsman);
		add(axeman);
		add(spearman);
		add(archer);
		add(wargRiders);
		
		setVisible(true);
		setLayout(null);
		setBounds(0,0,442,650);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);		
		background = new ImageIcon("images/addsoldierpanel.png").getImage(); //get background icon as image
		
		g.drawImage( background, 0, 0, null); //draw background
	}

}
