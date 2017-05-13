package GUI;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import Manager.*;

public class AddPlayerPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel mainPanel;
	private CardLayout cardLayout;
	private JButton nextBut;
	private Image background;
	private JTextField askName;
	private String name;
	private JRadioButton rohan, gondor, elves, dwarves, mordor, harad, isengard;
	private int totalPlayerNum, currentFaction;
	private ButtonGroup bG;
	private ArrayList<String> nameList, factionList;
	private MainGameManager game;
	private GameMainPanel gameMainPanel;
	
	public AddPlayerPanel(JPanel mP, CardLayout cl) {
		
		currentFaction=0;
		bG=new ButtonGroup();
		
		
		nameList = new ArrayList<String>();
		factionList = new ArrayList<String>();		
		
		name = "";
		
		mainPanel = mP;
		cardLayout = cl;
		
		nextBut = new JButton();
		
		askName = new JTextField();
		askName.addActionListener(new NameListener());
		
		rohan = new JRadioButton("Rohan");
		gondor = new JRadioButton("Gondor");
		elves = new JRadioButton("Elves");
		dwarves = new JRadioButton("Dwarves");
		mordor = new JRadioButton("Mordor");
		harad = new JRadioButton("Harad");
		isengard = new JRadioButton("Isengard");
		
		add(rohan);
		add(gondor);
		add(elves);
		add(dwarves);
		add(mordor);
		add(harad);
		add(isengard);
		
		bG.add(rohan);
		bG.add(gondor);
		bG.add(elves);
		bG.add(dwarves);
		bG.add(mordor);
		bG.add(harad);
		bG.add(isengard);
		
		rohan.setBounds(218, 275, 67, 20);
		rohan.setFocusPainted(false); 
		rohan.setOpaque(false);
		rohan.setContentAreaFilled(false);
		rohan.setBorderPainted(false);	
		rohan.setFocusable(false);
		
		gondor.setBounds(392, 275, 67, 20);
		gondor.setFocusPainted(false); 
		gondor.setOpaque(false);
		gondor.setContentAreaFilled(false);
		gondor.setBorderPainted(false);	
		gondor.setFocusable(false);
		
		elves.setBounds(275, 275, 67, 20);
		elves.setFocusPainted(false); 
		elves.setOpaque(false);
		elves.setContentAreaFilled(false);
		elves.setBorderPainted(false);	
		elves.setFocusable(false);
		
		dwarves.setBounds(330, 275, 67, 20);
		dwarves.setFocusPainted(false); 
		dwarves.setOpaque(false);
		dwarves.setContentAreaFilled(false);
		dwarves.setBorderPainted(false);	
		dwarves.setFocusable(false);
		
		mordor.setBounds(218, 295, 67, 20);
		mordor.setFocusPainted(false); 
		mordor.setOpaque(false);
		mordor.setContentAreaFilled(false);
		mordor.setBorderPainted(false);	
		mordor.setFocusable(false);
		
		harad.setBounds(278, 295, 67, 20);
		harad.setFocusPainted(false); 
		harad.setOpaque(false);
		harad.setContentAreaFilled(false);
		harad.setBorderPainted(false);	
		harad.setFocusable(false);
		
		isengard.setBounds(333, 295, 75, 20);
		isengard.setFocusPainted(false); 
		isengard.setOpaque(false);
		isengard.setContentAreaFilled(false);
		isengard.setBorderPainted(false);	
		isengard.setFocusable(false);
		
		rohan.addActionListener(new FactionListener());
		mordor.addActionListener(new FactionListener());
		harad.addActionListener(new FactionListener());
		isengard.addActionListener(new FactionListener());
		dwarves.addActionListener(new FactionListener());
		elves.addActionListener(new FactionListener());
		gondor.addActionListener(new FactionListener());
		
		nextBut.setFocusPainted(false); 
		nextBut.setOpaque(false);
		nextBut.setContentAreaFilled(false);
		nextBut.setBorderPainted(false);	
		nextBut.setFocusable(false);
		
		nextBut.setIcon(new ImageIcon("images/next.png"));
		
		nextBut.addActionListener(new ButtonListener());
		
		addKeyListener(new BackToMenuListener());
		add(nextBut);
		add(askName);
		
		nextBut.setBounds(228, 335, 95, 38);
		askName.setBounds(241, 200, 100, 20);
		
		setLayout(null);
		setBackground(Color.black);
		setVisible(true);
		setBounds(0, 0, 650, 650);
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);		
		background = new ImageIcon("images/askforplayer.png").getImage(); //get background icon as image
		
		g.drawImage( background, 0, 0, null); //draw background
	}
	
	public void setPlayerNum(int i){
		totalPlayerNum =i;
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource()==nextBut){
				if(name!="" && currentFaction != 0){
					nameList.add(name);
					if(currentFaction==1){
						factionList.add("rohan");
						rohan.setSelected(false);
						rohan.setEnabled(false);
					}
					else if(currentFaction == 2){
						factionList.add("gondor");
						gondor.setSelected(false);
						gondor.setEnabled(false);
					}
					else if(currentFaction ==3){
						factionList.add("elves");
						elves.setSelected(false);
						elves.setEnabled(false);
					}
					else if(currentFaction==4){
						factionList.add("dwarves");
						dwarves.setSelected(false);
						dwarves.setEnabled(false);
					}
					else if(currentFaction==5){
						factionList.add("mordor");
						mordor.setSelected(false);
						mordor.setEnabled(false);
					}
					else if(currentFaction==6){
						factionList.add("harad");
						harad.setSelected(false);
						harad.setEnabled(false);
					}
					else if(currentFaction==7){
						factionList.add("isengard");
						isengard.setSelected(false);
						isengard.setEnabled(false);
					}
					askName.setText("");
					if(totalPlayerNum>1){
						totalPlayerNum--;
					}
					else if(totalPlayerNum==1){
						//faction ve nameleri game manager'a gir
						game= new MainGameManager();
						gameMainPanel = new GameMainPanel(mainPanel, cardLayout, game);
						game.enterNames(nameList);
						game.enterFactions(factionList);
						game.initializeGame();
						gameMainPanel.repaintMaps();
						cardLayout.show(mainPanel, "gameMainPanel");
					}
				}
				
			}
		}
	}
	
	
	private class BackToMenuListener implements KeyListener{
		public void keyPressed(KeyEvent event){
			if(event.getKeyCode() == KeyEvent.VK_ESCAPE){
				cardLayout.show(mainPanel, "menu");
			}
		}
		public void keyTyped(KeyEvent event){}
		public void keyReleased(KeyEvent event){}
	}
	
	private class NameListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			name = askName.getText();
		}
	}
	
	public ArrayList<String> getNameList(){
		return nameList;
	}
	
	public ArrayList<String> getFactionList(){
		return factionList;
	}
	
	private class FactionListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == rohan){
				currentFaction=1;
			}
			else if(event.getSource() == gondor){
				currentFaction=2;
			}
			else if(event.getSource() == elves){
				currentFaction=3;
			}
			else if(event.getSource() == dwarves){
				currentFaction=4;
			}
			else if(event.getSource() == mordor){
				currentFaction=5;
			}
			else if(event.getSource() == harad){
				currentFaction=6;
			}
			else if(event.getSource() == isengard){
				currentFaction=7;
			}
		}
	}
	
	public MainGameManager returnGame(){
		return game;
	}
	
	public GameMainPanel returnGamePanel(){
		return gameMainPanel;
	}
	

}
