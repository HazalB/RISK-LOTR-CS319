import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

import java.awt.*;


public class LeftColumnPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public Image background;
	
	public LeftColumnPanel() {
		
		
		setVisible(true);
		setLayout(null);
		setBackground(Color.black);
		
		setBounds(0, 0, 127, 650);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);		
		background = new ImageIcon("images/col1.png").getImage(); //get background icon as image
		
		g.drawImage( background, 0, 0, null); //draw background
	}

}
