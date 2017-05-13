package GUI;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import Manager.*;

public class AttackSoldierPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel mainPanel;
	private CardLayout cardLayout;
	private Image background;
	private JTextField soldierField[];
	private JButton attackBut;
	private MainGameManager game;
	private int attackFrom, attackTo, axeman, archer,
			cavalry, spearman, swordsman, wargrider, mumakil, nazgul;
	private MobilityMapPanel mobilityMapPanel;
	
	public AttackSoldierPanel(JPanel mP, CardLayout cl, MainGameManager mGM, MobilityMapPanel mMP) {
		mainPanel=mP;
		cardLayout=cl;
		game = mGM;
		mobilityMapPanel=mMP;
		
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
		
		attackBut.addActionListener(new ButListener());
		for(int i=0; i<8; i++){
			soldierField[i].addActionListener(new FieldListener());
		}
		
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);		
		background = new ImageIcon("images/transferbackground.png").getImage(); //get background icon as image
		
		g.drawImage( background, 0, 0, null); //draw background
	}
	
	private class FieldListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			swordsman=Integer.parseInt(soldierField[0].getText());
			axeman=Integer.parseInt(soldierField[1].getText());
			spearman=Integer.parseInt(soldierField[2].getText());
			archer=Integer.parseInt(soldierField[3].getText());
			wargrider=Integer.parseInt(soldierField[4].getText());
			cavalry=Integer.parseInt(soldierField[5].getText());
			mumakil=Integer.parseInt(soldierField[6].getText());
			nazgul=Integer.parseInt(soldierField[7].getText());
		}
	}
	
	private class ButListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==attackBut){
				if(soldierField[0].getText()!="" && soldierField[1].getText()!="" &&
						soldierField[2].getText()!="" && soldierField[3].getText()!="" &&
						soldierField[4].getText()!="" && soldierField[5].getText()!="" &&
						soldierField[6].getText()!="" && soldierField[7].getText()!=""){
					game.transferOrder(attackFrom, attackTo, 
							game.setArmy(archer, axeman, cavalry, mumakil, nazgul, spearman, swordsman, wargrider));
					mobilityMapPanel.setRedBoxesVisible(game.getCurPlayerProvinces());
					for(int i=0; i<8; i++){
						soldierField[i].setText("");
					}
					cardLayout.show(mainPanel, "mobilityPanel");
				}
			}
		}
	}
	
	public void setFromId(int id){
		attackFrom=id;
	}
	
	public void setToId(int id){
		attackTo=id;
	}

}


