package GUI;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import Manager.*;
import javax.swing.*;


public class GameMainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private CardLayout menuCardLayout, mapCardLayout;
	private LeftColumnPanel leftColumn;
	private RightColumnPanel rightColumn;
	private ImageIcon createSoldButImage;
	private JButton createSoldBut, attackBut, transferBut, doneBut, endPhase;
	private JPanel mainMenuPanel, mainMapPanel;
	private AddSoldierPanel addSoldierPanel;
	private JLabel showPhaseLabel[];
	private SoldierNumberPanel soldierNumberPanel;
	private TransferSoldierPanel transferSoldierPanel;
	private AttackSoldierPanel attackSoldierPanel;
	private MapPanel mapActivePanel;
	private TransferMapPanel transferMapPanel;
	private MobilityMapPanel mobilityMapPanel;
	private CreateSoldierMapPanel createSoldierMapPanel;
	private AttackMapPanel attackMapPanel;
	private MainGameManager game;
	
	public GameMainPanel(JPanel mP, CardLayout cl, MainGameManager mGM) {
		
		mainMenuPanel = mP;
		menuCardLayout = cl;
		game = mGM;
		
		showPhaseLabel = new JLabel[3];
		leftColumn = new LeftColumnPanel(game);
		
		for(int i=0; i<3; i++){
			showPhaseLabel[i] = new JLabel();
			leftColumn.add(showPhaseLabel[i]);
		}
		
		if(game.getCurPhase()==1){
			showPhaseLabel[0].setIcon(new ImageIcon("images/developmentonpic.png"));
			showPhaseLabel[1].setIcon(new ImageIcon("images/mobilityoffpic.png"));
			showPhaseLabel[2].setIcon(new ImageIcon("images/executionoffpic.png"));
		}
		else if(game.getCurPhase()==2){
			showPhaseLabel[0].setIcon(new ImageIcon("images/developmentoffpic.png"));
			showPhaseLabel[1].setIcon(new ImageIcon("images/mobilityonpic.png"));
			showPhaseLabel[2].setIcon(new ImageIcon("images/executionoffpic.png"));
		}
		else if(game.getCurPhase()==3){
			showPhaseLabel[0].setIcon(new ImageIcon("images/developmentonpic.png"));
			showPhaseLabel[1].setIcon(new ImageIcon("images/mobilityoffpic.png"));
			showPhaseLabel[2].setIcon(new ImageIcon("images/executiononpic.png"));
		}
		
		
		showPhaseLabel[0].setBounds(3, 10, 122, 18);
		showPhaseLabel[1].setBounds(3, 35, 103, 17);
		showPhaseLabel[2].setBounds(3, 60, 120, 18);
		
		addKeyListener(new BackToMenuListener());
		
		mapCardLayout = new CardLayout();
		mainMapPanel = new JPanel();
		
		mapActivePanel = new MapPanel(mainMapPanel, mapCardLayout, game, transferMapPanel, mobilityMapPanel, createSoldierMapPanel);
		addSoldierPanel = new AddSoldierPanel(mainMapPanel, mapCardLayout, game, soldierNumberPanel);
		soldierNumberPanel = new SoldierNumberPanel(mainMapPanel, mapCardLayout, game);
		transferSoldierPanel = new TransferSoldierPanel(mainMapPanel, mapCardLayout, game, mobilityMapPanel);
		attackSoldierPanel = new AttackSoldierPanel(mainMapPanel, mapCardLayout, game, mobilityMapPanel);
		transferMapPanel = new TransferMapPanel(mainMapPanel, mapCardLayout, mapActivePanel, game, transferSoldierPanel);
		mobilityMapPanel = new MobilityMapPanel(mainMapPanel, mapCardLayout, mapActivePanel, game, attackSoldierPanel, transferSoldierPanel);
		createSoldierMapPanel = new CreateSoldierMapPanel(mainMapPanel, mapCardLayout, mapActivePanel, game, soldierNumberPanel);
		attackMapPanel = new AttackMapPanel(mainMapPanel, mapCardLayout, game, attackSoldierPanel);
		
				
		rightColumn = new RightColumnPanel(game);
		mainMapPanel.setLayout(mapCardLayout);
		
		mainMapPanel.add("activeMapPanel", mapActivePanel);
		mainMapPanel.add("transferMapPanel", transferMapPanel);
		mainMapPanel.add("mobilityMapPanel", mobilityMapPanel);
		mainMapPanel.add("createSoldierMapPanel", createSoldierMapPanel);
		mainMapPanel.add("soldierNumberPanel", soldierNumberPanel);
		mainMapPanel.add("addSoldierPanel", addSoldierPanel);
		mainMapPanel.add("attackSoldierPanel", attackSoldierPanel);
		mainMapPanel.add("transferSoldierPanel", transferSoldierPanel);
		mainMapPanel.add("attackMapPanel", attackMapPanel);
		
		createSoldBut = new JButton();
		createSoldButImage = new ImageIcon("images/createsoldbut.png");
		createSoldBut.setIcon(createSoldButImage);
		
		createSoldBut.setBounds(0, 260, 122, 120);
		add(createSoldBut);
		
		createSoldBut.setFocusPainted(false); 
		createSoldBut.setOpaque(false);
		createSoldBut.setContentAreaFilled(false);
		createSoldBut.setBorderPainted(false);	
		createSoldBut.setFocusable(false);
		
		mainMapPanel.setBounds(127, 0, 442, 665);
		rightColumn.setBounds(569, 0, 650, 650);
		
		add(leftColumn);
		add(mainMapPanel);
		add(rightColumn);
		setLayout(null);
		setBackground(Color.black);
		setVisible(true);
		
		attackBut = new JButton();
		transferBut = new JButton();
		doneBut = new JButton();
		endPhase = new JButton();
		
		attackBut.setFocusPainted(false); 
		attackBut.setOpaque(false);
		attackBut.setContentAreaFilled(false);
		attackBut.setBorderPainted(false);	
		attackBut.setFocusable(false);
		
		transferBut.setFocusPainted(false); 
		transferBut.setOpaque(false);
		transferBut.setContentAreaFilled(false);
		transferBut.setBorderPainted(false);	
		transferBut.setFocusable(false);
		
		doneBut.setFocusPainted(false); 
		doneBut.setOpaque(false);
		doneBut.setContentAreaFilled(false);
		doneBut.setBorderPainted(false);	
		doneBut.setFocusable(false);
		
		endPhase.setFocusPainted(false); 
		endPhase.setOpaque(false);
		endPhase.setContentAreaFilled(false);
		endPhase.setBorderPainted(false);	
		endPhase.setFocusable(false);
		
		attackBut.setBounds(15, 315, 105, 29);
		attackBut.setIcon(new ImageIcon("images/attackButton.png"));
		mapActivePanel.add(attackBut);
		
		transferBut.setBounds(15, 350, 105, 29);
		transferBut.setIcon(new ImageIcon("images/transferButton.png"));
		mapActivePanel.add(transferBut);
		
		doneBut.setBounds(15, 385, 105, 29);
		doneBut.setIcon(new ImageIcon("images/doneButton.png"));
		mapActivePanel.add(doneBut);
		
		endPhase.setBounds(4, 550, 67, 62);
		endPhase.setIcon(new ImageIcon("images/endphasebut.png"));
		rightColumn.add(endPhase);
		
		createSoldBut.addActionListener(new CreateButList());
		
		setBounds(0, 0, 650, 687);
		
		addMouseMotionListener(new ButtonImageListener());
		GameMainButtonListener butLis = new GameMainButtonListener();
		createSoldBut.addActionListener(butLis);
		attackBut.addActionListener(butLis);
		transferBut.addActionListener(butLis);
		doneBut.addActionListener(butLis);
		endPhase.addActionListener(butLis);
	}
	
	private class BackToMenuListener implements KeyListener{
		public void keyPressed(KeyEvent event){
			if(event.getKeyCode() == KeyEvent.VK_ESCAPE){
				menuCardLayout.show(mainMenuPanel, "menu");
			}
		}
		public void keyTyped(KeyEvent event){}
		public void keyReleased(KeyEvent event){}
	}
	
	private class CreateButList implements ActionListener{
		public void actionPerformed(ActionEvent e){
			mapCardLayout.show(mainMapPanel, "addSoldierPanel");
		}
	}
	
	private class ButtonImageListener implements MouseMotionListener{
		public void mouseMoved(MouseEvent event){
			int x = event.getX();
			int y = event.getY();
			if(x>0 && x<122 && y>260 && y <380){
				createSoldBut.setIcon(new ImageIcon("images/createsoldbuton.png"));
			}
			else if(x>142 && x<247 && y>315 && y<344){
				attackBut.setIcon(new ImageIcon("images/attackButtonon.png"));
			}
			else if(x>142 && x<247 && y>350 && y<379){
				transferBut.setIcon(new ImageIcon("images/transferButtonon.png"));
			}
			else if(x>142 && x<247 && y>385 && y<414){
				doneBut.setIcon(new ImageIcon("images/doneButtonon.png"));
			}
			else if(x>573 && x<640 && y>550 && y<612){
				endPhase.setIcon(new ImageIcon("images/endphasebuton.png"));
			}
			else{
				createSoldBut.setIcon(new ImageIcon("images/createsoldbut.png"));
				attackBut.setIcon(new ImageIcon("images/attackButton.png"));
				transferBut.setIcon(new ImageIcon("images/transferButton.png"));
				doneBut.setIcon(new ImageIcon("images/doneButton.png"));
				endPhase.setIcon(new ImageIcon("images/endphasebut.png"));
			}
		}
		public void mouseDragged(MouseEvent event){
			int x = event.getX();
			int y = event.getY();
			if(x>0 && x<122 && y>260 && y <380){
				createSoldBut.setIcon(new ImageIcon("images/createsoldbuton.png"));
			}
			else if(x>142 && x<247 && y>315 && y<344){
				attackBut.setIcon(new ImageIcon("images/attackbuttonon.png"));
			}
			else if(x>142 && x<247 && y>350 && y<379){
				transferBut.setIcon(new ImageIcon("images/transferbuttonon.png"));
			}
			else if(x>142 && x<247 && y>385 && y<414){
				doneBut.setIcon(new ImageIcon("images/donebuttonon.png"));
			}
			else if(x>573 && x<640 && y>550 && y<612){
				endPhase.setIcon(new ImageIcon("images/endphasebuton.png"));
			}
			else{
				createSoldBut.setIcon(new ImageIcon("images/createsoldbut.png"));
				attackBut.setIcon(new ImageIcon("images/attackButton.png"));
				transferBut.setIcon(new ImageIcon("images/transferButton.png"));
				doneBut.setIcon(new ImageIcon("images/doneButton.png"));
				endPhase.setIcon(new ImageIcon("images/endphasebut.png"));
			}
		}
	}
	
	private class GameMainButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource()==createSoldBut && game.getCurPhase() == 1
					&& mapCardLayout.getClass().getName() == "activeMapPanel"){		//game'in phase'ini al
				ArrayList<Integer> visibleRedBoxIdList = game.getCurPlayerProvinces();					//aktif oyuncunun province idleri arraylist
				createSoldierMapPanel.setRedBoxesVisible(visibleRedBoxIdList);
				createSoldierMapPanel.repaintThis();
				mapCardLayout.show(mainMapPanel, "createSoldierMapPanel");			//redboxlarý sonra not visible yap tekrar create soldier paneli içinde
			}
			else if(event.getSource()==attackBut && game.getCurPhase() == 2
					&& mapCardLayout.getClass().getName() == "activeMapPanel"){	//game'in phaseini al
				int attackingid = mobilityMapPanel.getSelectedRedBoxId();
				ArrayList<Integer> visibleRedBoxIdList = game.getNotOwnedProvinceList(attackingid);					//aktif oyuncunun seçtiði id'nin komþusunda bulunan sahip olmadýðý province idleri
				attackMapPanel.setVisibleRedBoxes(visibleRedBoxIdList);
				attackMapPanel.showColor(attackingid, visibleRedBoxIdList);
				attackMapPanel.setAttackFrom(attackingid);
				attackMapPanel.repaint();
				mapCardLayout.show(mainMapPanel, "attackMapPanel");			//redboxlarý sonra not visible yap tekrar create soldier paneli içinde
			}
			else if(event.getSource()==transferBut && game.getCurPhase()==2
					&& mapCardLayout.getClass().getName() == "activeMapPanel"){	//game'in phaseini al
				int transferFromId = mobilityMapPanel.getSelectedRedBoxId();
				ArrayList<Integer> visibleRedBoxIdList = game.getCurPlayerProvinces();					//aktif oyuncunun province idleri arraylist
				for(int i=0; i<visibleRedBoxIdList.size(); i++){
					if(visibleRedBoxIdList.get(i)==transferFromId){
						visibleRedBoxIdList.remove(i);
					}
				}
				transferMapPanel.setRedBoxesVisible(visibleRedBoxIdList);
				transferMapPanel.repaintThis();
				mapCardLayout.show(mainMapPanel, "transferMapPanel");
			}
			else if(event.getSource()==doneBut && mapCardLayout.getClass().getName()=="attackMapPanel"
					&& game.getCurPhase()==2 && attackMapPanel.getSelectedRedBoxId()!=-1){
				attackMapPanel.setAttackMapStarter();
				mapCardLayout.show(mainMapPanel, "attackSoldierPanel");
			}
			else if(event.getSource()==endPhase){
				if(game.getCurPhase()==1 && mapCardLayout.getClass().getName()=="activeMapPanel"){
					game.nextPhase();
					showPhaseLabel[0].setIcon(new ImageIcon("images/developmentoffpic.png"));
					if(game.getCurPhase()==2){
						showPhaseLabel[1].setIcon(new ImageIcon("images/mobilityonpic.png"));
						mobilityMapPanel.setRedBoxesVisible(game.getCurPlayerProvinces());
						mapCardLayout.show(mainMapPanel, "mobilityMapPanel");
					}
					else if(game.getCurPhase()==3){
						showPhaseLabel[2].setIcon(new ImageIcon("images/executiononpic.png"));
						ArrayList<Integer> changedProvinces = game.changes();
						mapActivePanel.changeColors(changedProvinces);
						transferMapPanel.changeColors(changedProvinces);
						mobilityMapPanel.changeColors(changedProvinces);
						createSoldierMapPanel.changeColors(changedProvinces);
						attackMapPanel.changeColors(changedProvinces);
						mapCardLayout.show(mainMapPanel, "activeMapPanel");
					}
				}
				else if(game.getCurPhase()==2 && mapCardLayout.getClass().getName()=="mobilityMapPanel"){
					game.nextPhase();
					showPhaseLabel[1].setIcon(new ImageIcon("images/mobilityoffpic.png"));
					if(game.getCurPhase()==1){
						showPhaseLabel[0].setIcon(new ImageIcon("images/developmentonpic.png"));
						mapCardLayout.show(mainMapPanel, "activeMapPanel");
					}
					else if(game.getCurPhase()==3){
						showPhaseLabel[2].setIcon(new ImageIcon("images/executiononpic.png"));
						ArrayList<Integer> changedProvinces = game.changes();
						mapActivePanel.changeColors(changedProvinces);
						transferMapPanel.changeColors(changedProvinces);
						mobilityMapPanel.changeColors(changedProvinces);
						createSoldierMapPanel.changeColors(changedProvinces);
						attackMapPanel.changeColors(changedProvinces);
						mapCardLayout.show(mainMapPanel, "activeMapPanel");
					}
				}
				else if(game.getCurPhase()==3 && mapCardLayout.getClass().getName()=="activeMapPanel"){
					game.nextPhase();
					showPhaseLabel[3].setIcon(new ImageIcon("images/executionoffpic.png"));
					if(game.getCurPhase()==1){
						showPhaseLabel[0].setIcon(new ImageIcon("images/developmentonpic.png"));
						mapCardLayout.show(mainMapPanel, "activeMapPanel");
					}
					else if(game.getCurPhase()==2){
						showPhaseLabel[1].setIcon(new ImageIcon("images/mobilityonpic.png"));
						mobilityMapPanel.setRedBoxesVisible(game.getCurPlayerProvinces());
						mapCardLayout.show(mainMapPanel, "mobilityMapPanel");
					}
				}		
			}
			
		}
	}
	
	public void repaintMaps(){
		attackMapPanel.repaint();
		mapActivePanel.repaint();
		createSoldierMapPanel.repaint();
		transferMapPanel.repaint();
		mobilityMapPanel.repaint();
		
	}

}
