package GUI;
import java.awt.Color;
import java.awt.Graphics;
import Manager.*;
import javax.swing.*;

import java.awt.*;


public class RightColumnPanel extends JPanel {

	private Image background;
	private MainGameManager game;
	/**
	 * Create the panel.
	 */
	public RightColumnPanel(MainGameManager mGM) {
		
		game = mGM;
		
		setVisible(true);
		setLayout(null);
		setBackground(Color.black);
		
		setBounds(0, 0, 76, 650);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);		
		background = new ImageIcon("images/col2.png").getImage(); //get background icon as image
		
		g.drawImage( background, 0, 0, null); //draw background
	}
	

}
