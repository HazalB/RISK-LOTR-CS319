import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
/*import java.io.File;
import java.io.IOException;
import java.util.*;*/


public class MenuPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public Image background;
	private ImageIcon[] buttonImages;
	private JButton button[];
	private JPanel mainPanel;
	private CardLayout cardLayout;
	
	public MenuPanel(JPanel mP, CardLayout cl) {
		
		
		cardLayout=cl;
		mainPanel=mP;
		
		button = new JButton[4]; //creating buttons

		buttonImages = new ImageIcon[4]; //button images created
		
		//button images loaded
		buttonImages[0]=new ImageIcon("images/play multiplayer mode.png");
		buttonImages[1]=new ImageIcon("images/options.png");
		buttonImages[2]=new ImageIcon("images/help.png");
		buttonImages[3]=new ImageIcon("images/quit game.png");
		
		//buttons created
		button[0] = new JButton("");
		button[1] = new JButton("");
		button[2] = new JButton("");
		button[3] = new JButton("");
		
		//buttons added to the menu panel
		add(button[0]);		
		add(button[1]);
		add(button[2]);
		add(button[3]);
		
		//the sizes and locations of the buttons set
		button[0].setBounds(185, 253, 252, 63);		
		button[1].setBounds(185, 327, 252, 63);
		button[2].setBounds(185, 401, 252, 63);
		button[3].setBounds(185, 475, 252, 63);
		
		//the images of the buttons set
		button[0].setIcon(buttonImages[0]);
		button[1].setIcon(buttonImages[1]);
		button[2].setIcon(buttonImages[2]);
		button[3].setIcon(buttonImages[3]);
		
		//makes frames of the buttons opac
		button[0].setFocusPainted(false); 
		button[0].setOpaque(false);
		button[0].setContentAreaFilled(false);
		button[0].setBorderPainted(false);	
		button[0].setFocusable(false);
		
		button[1].setFocusPainted(false); 
		button[1].setOpaque(false);
		button[1].setContentAreaFilled(false);
		button[1].setBorderPainted(false);	
		button[1].setFocusable(false);
		
		button[2].setFocusPainted(false); 
		button[2].setOpaque(false);
		button[2].setContentAreaFilled(false);
		button[2].setBorderPainted(false);	
		button[2].setFocusable(false);
		
		button[3].setFocusPainted(false); 
		button[3].setOpaque(false);
		button[3].setContentAreaFilled(false);
		button[3].setBorderPainted(false);	
		button[3].setFocusable(false);
		
		//button listener created
		ButtonListener listener = new ButtonListener();
		
		//add listener to buttons
		button[0].addActionListener(listener);
		button[1].addActionListener(listener);
		button[2].addActionListener(listener);
		button[3].addActionListener(listener);
		
		//set the bounds of the panel
		setBounds(0, 0, 650, 650);
		
		//to change the places of buttons on the panel
		setLayout(null);
		
		//background color of the panel
		setBackground(Color.black);
		setVisible(true);
		
	}
	
	//paint component to set background
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);		
		background = new ImageIcon("images/background.jpg").getImage(); //get background icon as image
		
		g.drawImage( background, 0, 0, null); //draw background
	}
	
	
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource()==button[0]){
				//start game
			}
			else if(event.getSource()==button[1]){
				cardLayout.show(mainPanel, "options");
			}
			else if(event.getSource()==button[2]){
				cardLayout.show(mainPanel, "help");
			}
			else if(event.getSource()==button[3]){
				System.exit(0);
			}
		}
	}
	
}
