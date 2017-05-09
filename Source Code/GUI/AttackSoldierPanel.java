import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AttackSoldierPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel mainPanel;
	private CardLayout cardLayout;
	private Image background;
	private JTextField soldierField[];
	private JButton attackBut;
	
	public AttackSoldierPanel(JPanel mP, CardLayout cl) {
		mainPanel=mP;
		cardLayout=cl;
		
		soldierField = new JTextField[8];
		for(int i=0; i<8; i++){
			soldierField[i] = new JTextField();
			add(soldierField[i]);
		}
		
		attackBut = new JButton();
		attackBut.setFocusPainted(false); 
		attackBut.setOpaque(false);
		attackBut.setContentAreaFilled(false);
		attackBut.setBorderPainted(false);	
		attackBut.setFocusable(false);
		add(attackBut);
		
		attackBut.setBounds(180, 480, 105, 30);
		attackBut.setIcon(new ImageIcon("images/attackbutton.png"));
		
		soldierField[0].setBounds(100, 153, 50, 20);
		soldierField[1].setBounds(100, 196, 50, 20);
		soldierField[2].setBounds(100, 237, 50, 20);
		soldierField[3].setBounds(100, 279, 50, 20);
		soldierField[4].setBounds(100, 321, 50, 20);
		soldierField[5].setBounds(100, 363, 50, 20);
		soldierField[6].setBounds(100, 403, 50, 20);
		soldierField[7].setBounds(100, 439, 50, 20);
		
		setVisible(true);
		setLayout(null);
		
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);		
		background = new ImageIcon("images/transferbackground.png").getImage(); //get background icon as image
		
		g.drawImage( background, 0, 0, null); //draw background
	}

}


