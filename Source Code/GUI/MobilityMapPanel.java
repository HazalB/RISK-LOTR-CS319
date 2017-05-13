package GUI;

import javax.swing.*;

import Manager.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MobilityMapPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private MapPanel mapPanel;
	private CardLayout cardLayout;
	private JPanel mainPanel;
	private MainGameManager game;
	private ArrayList<Integer> rodboxes;
	private Image background;
	private JLabel provinceLabelsList[], name;
	private JButton provinceActionButton[];
	private int selectedRedBoxId;
	private AttackSoldierPanel attackSoldierPanel;
	private TransferSoldierPanel transferSoldierPanel;
	
	public MobilityMapPanel(JPanel mP, CardLayout cl, MapPanel mapP, MainGameManager mGM,
			AttackSoldierPanel aSP, TransferSoldierPanel tSP) {
		mainPanel = mP;
		cardLayout = cl;
		mapPanel = mapP;
		game = mGM;
		attackSoldierPanel=aSP;
		transferSoldierPanel=tSP;
		
		provinceLabelsList = mapPanel.provinceLabels();
		provinceActionButton = mapPanel.getActionButtons();
		name = mapPanel.getNameLabel();
		
		add(name);		
		
		setLayout(null);
		
		for(int i=1; i<67; i++){
			if(i!=6){
				add(provinceActionButton[i]);
				add(provinceLabelsList[i]);
				provinceActionButton[i].setVisible(false);
				provinceActionButton[i].addActionListener(new RedBoxListener());
			}
		}
		
	}
	
	private class RedBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			for(int i=1; i<67; i++){
				if(event.getSource()==provinceActionButton[i]){
					selectedRedBoxId = i;
					transferSoldierPanel.setFromId(i);
					attackSoldierPanel.setFromId(i);
				}
			}
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);		
		background = mapPanel.getMapBackground(); //get background icon as image
		
		g.drawImage( background, 0, 0, null); //draw background
	}
	
	public void repaintThis(){
		repaint();
	}
	
	public void setRedBoxesVisible(ArrayList<Integer> redboxlist){
		for(int i=0; i<redboxlist.size(); i++){
			int index = redboxlist.get(i);
			provinceActionButton[index].setVisible(true);
			cardLayout.show(mainPanel, "activeMapPanel");
		}
	}
	
	public void setRedBoxesNotVisible(ArrayList<Integer> redboxlist){
		for(int i=0; i<redboxlist.size(); i++){
			int index = redboxlist.get(i);
			provinceActionButton[index].setVisible(false);
		}
	}
	
	public void setEmptyProvinces(ArrayList<Integer> emptyProvinces){
		for(int i=0; i<emptyProvinces.size(); i++){
			int index = emptyProvinces.get(i);
			provinceLabelsList[index].setIcon(mapPanel.provinceorange[i]);
		}
	}
	
	public int getSelectedRedBoxId(){
		return selectedRedBoxId;
	}
	
	public void changeProvinceColor(int provId, String provCol){
		if(provCol == "mordor"){
			provinceLabelsList[provId].setIcon(mapPanel.provincemilitary[provId]);
		}
		else if(provCol == "gondor"){
			provinceLabelsList[provId].setIcon(mapPanel.provincemint[provId]);
		}
		else if(provCol == "rohan"){
			provinceLabelsList[provId].setIcon(mapPanel.provinceblue[provId]);
		}
		else if(provCol == "elves"){
			provinceLabelsList[provId].setIcon(mapPanel.provincegreen[provId]);
		}
		else if(provCol == "dwarves"){
			provinceLabelsList[provId].setIcon(mapPanel.provinceyellow[provId]);
		}
		else if(provCol == "harad"){
			provinceLabelsList[provId].setIcon(mapPanel.provincepink[provId]);
		}
		else if(provCol == "isengard"){
			provinceLabelsList[provId].setIcon(mapPanel.provincebrown[provId]);
		}
		else if(provCol == "empty"){
			provinceLabelsList[provId].setIcon(mapPanel.provinceorange[provId]);
		}
	}
	
	public void changeColors(ArrayList<Integer> provinceList){
		for(int i=0; i<provinceList.size(); i++){
			String faction = game.getProvinceFaction(provinceList.get(i));
			changeProvinceColor(i, faction);
		}
	}
	
	public void setName(){
		name.setText(game.getName());			//set the name
	}

}
