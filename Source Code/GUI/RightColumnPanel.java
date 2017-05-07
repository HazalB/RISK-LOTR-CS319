import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;


public class RightColumnPanel extends JPanel {

	private Image background;
	/**
	 * Create the panel.
	 */
	public RightColumnPanel() {

	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);		
		background = new ImageIcon("images/col2.png").getImage(); //get background icon as image
		
		g.drawImage( background, 0, 0, null); //draw background
	}
	

}
