package GUI;
import javax.swing.*;
import Manager.*;
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
	private boolean actionPerf;
	private MainGameManager game;
	private SoldierNumberPanel soldierNumberPanel;
	
	public AddSoldierPanel(JPanel mP, CardLayout cl, MainGameManager mGM, SoldierNumberPanel sNP) {
		mainPanel=mP;
		cardLayout=cl;
		game = mGM;
		
		actionPerf=false;
		soldierNumberPanel = sNP;
		
		swordsman = new JButton();
		axeman = new JButton();
		spearman = new JButton();
		archer = new JButton();
		wargRiders = new JButton();
		cavalry = new JButton();
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
		
		cavalry.setIcon(new ImageIcon("images/cavalarybut.png"));
		cavalry.setBounds(245, 250, 107, 107);
		cavalry.setFocusPainted(false); 
		cavalry.setOpaque(false);
		cavalry.setContentAreaFilled(false);
		cavalry.setBorderPainted(false);	
		cavalry.setFocusable(false);
		
		wargRiders.setIcon(new ImageIcon("images/warg-ridersbut.png"));
		wargRiders.setBounds(40, 365, 107, 107);
		wargRiders.setFocusPainted(false); 
		wargRiders.setOpaque(false);
		wargRiders.setContentAreaFilled(false);
		wargRiders.setBorderPainted(false);	
		wargRiders.setFocusable(false);
		
		mumakil.setIcon(new ImageIcon("images/mumakilbut.png"));
		mumakil.setBounds(175, 365, 107, 107);
		mumakil.setFocusPainted(false); 
		mumakil.setOpaque(false);
		mumakil.setContentAreaFilled(false);
		mumakil.setBorderPainted(false);	
		mumakil.setFocusable(false);
		
		nazgul.setIcon(new ImageIcon("images/nazgulbut.png"));
		nazgul.setBounds(310, 365, 107, 107);
		nazgul.setFocusPainted(false); 
		nazgul.setOpaque(false);
		nazgul.setContentAreaFilled(false);
		nazgul.setBorderPainted(false);	
		nazgul.setFocusable(false);
		
		add(swordsman);
		add(axeman);
		add(spearman);
		add(archer);
		add(cavalry);
		add(wargRiders);
		add(mumakil);
		add(nazgul);
		
		SoldierAddListener addSoldList = new SoldierAddListener();
		swordsman.addActionListener(addSoldList);
		axeman.addActionListener(addSoldList);
		spearman.addActionListener(addSoldList);
		archer.addActionListener(addSoldList);
		cavalry.addActionListener(addSoldList);
		wargRiders.addActionListener(addSoldList);
		mumakil.addActionListener(addSoldList);
		nazgul.addActionListener(addSoldList);
		
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
	
	private class SoldierAddListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource()==swordsman){
				soldierNumberPanel.setSoldierType(6);
				actionPerf=true;
				cardLayout.show(mainPanel, "soldierNumberPanel");
			}
			else if(event.getSource()==axeman){
				soldierNumberPanel.setSoldierType(1);
				actionPerf=true;
				cardLayout.show(mainPanel, "soldierNumberPanel");
			}
			else if(event.getSource()==spearman){
				soldierNumberPanel.setSoldierType(5);
				actionPerf=true;
				cardLayout.show(mainPanel, "soldierNumberPanel");
			}
			else if(event.getSource()==archer){
				soldierNumberPanel.setSoldierType(0);
				actionPerf=true;
				cardLayout.show(mainPanel, "soldierNumberPanel");
			}
			else if(event.getSource()==cavalry){
				soldierNumberPanel.setSoldierType(2);
				actionPerf=true;
				cardLayout.show(mainPanel, "soldierNumberPanel");
			}
			else if(event.getSource()==wargRiders){
				soldierNumberPanel.setSoldierType(7);
				actionPerf=true;
				cardLayout.show(mainPanel, "soldierNumberPanel");
			}
			else if(event.getSource()==mumakil){
				soldierNumberPanel.setSoldierType(3);
				actionPerf=true;
				cardLayout.show(mainPanel, "soldierNumberPanel");
			}
			else if(event.getSource()==nazgul){
				soldierNumberPanel.setSoldierType(4);
				actionPerf=true;
				cardLayout.show(mainPanel, "soldierNumberPanel");
			}
		}
	}

}
