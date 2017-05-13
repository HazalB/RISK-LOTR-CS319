package GUI;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Manager.*;

public class PlayerNumberPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private Image background;
	private CardLayout cardLayout;
	private JPanel mainPanel;
	private JButton nextBut;
	private JTextField playerNumField;
	private int playerNum;
	private AddPlayerPanel addPlayerPanel;
	private MainGameManager game;
	
	public PlayerNumberPanel(JPanel mP, CardLayout cl, AddPlayerPanel aP, MainGameManager mGM) {
		
		addPlayerPanel=aP;
		mainPanel = mP;
		cardLayout = cl;
		game = mGM;
		
		nextBut = new JButton();
		nextBut.setIcon(new ImageIcon("images/next.png"));
		
		nextBut.setFocusPainted(false); 
		nextBut.setOpaque(false);
		nextBut.setContentAreaFilled(false);
		nextBut.setBorderPainted(false);	
		nextBut.setFocusable(false);
		
		playerNumField = new JTextField();
		playerNumField.setBounds(303, 242, 60, 20);
		add(playerNumField);
		
		add(nextBut);
		nextBut.setBounds(283, 307, 95, 38);
		
		playerNumField.addActionListener(new PlayerNumListener());
		nextBut.addActionListener(new ButtonListener());
		
		setVisible(true);
		setLayout(null);
		setBounds(0,0,650,650);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);		
		background = new ImageIcon("images/asknumofplayerbackground.png").getImage(); //get background icon as image
		
		g.drawImage( background, 0, 0, null); //draw background
	}
	
	public int getNumOfPlayer(){
		return playerNum;
	}
	
	public class PlayerNumListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			playerNum = Integer.parseInt(playerNumField.getText());
			addPlayerPanel.setPlayerNum(playerNum);
		}
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(playerNum<8 && playerNum>1){
				cardLayout.show(mainPanel, "addPlayerPanel");
			}
		}
	}

}
