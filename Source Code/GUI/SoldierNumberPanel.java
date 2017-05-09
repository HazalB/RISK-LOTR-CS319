import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class SoldierNumberPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private Image background;
	private JPanel mainPanel;
	private CardLayout cardLayout;
	private JTextField soldierNumberField;
	private int soldierNum;
	private JButton nextBut, backBut;
	
	public SoldierNumberPanel(JPanel mP, CardLayout cl) {
		cardLayout = cl;
		mainPanel = mP;
		
		soldierNum=-1;
		
		nextBut = new JButton();
		backBut = new JButton();
		
		nextBut.setBounds(250, 250, 95, 38);
		nextBut.setFocusPainted(false); 
		nextBut.setOpaque(false);
		nextBut.setContentAreaFilled(false);
		nextBut.setBorderPainted(false);	
		nextBut.setFocusable(false);
		
		backBut.setBounds(115, 250, 95, 38);
		backBut.setFocusPainted(false); 
		backBut.setOpaque(false);
		backBut.setContentAreaFilled(false);
		backBut.setBorderPainted(false);	
		backBut.setFocusable(false);
		
		nextBut.setIcon(new ImageIcon("images/next.png"));
		backBut.setIcon(new ImageIcon("images/backtomap.png"));
		
		backBut.addActionListener(new ButtonListener());
		nextBut.addActionListener(new ButtonListener());
		
		soldierNumberField = new JTextField();
		soldierNumberField.addActionListener(new FieldListener());
		soldierNumberField.setBounds(200, 220, 50, 20);
		
		add(soldierNumberField);
		add(backBut);
		add(nextBut);
		
		setLayout(null);
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);		
		background = new ImageIcon("images/soldiernumberpanel.png").getImage(); //get background icon as image
		
		g.drawImage( background, 0, 0, null); //draw background
	}
	
	private class FieldListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			soldierNum = Integer.parseInt(soldierNumberField.getText());
		}
	}
	
	public int getSoldierNumber(){
		return soldierNum;
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==nextBut){
				if(soldierNumberField.getText()!="" && soldierNum!=-1){
					soldierNumberField.setText("");
					cardLayout.show(mainPanel, "activeMapPanel");
				}
			}
			else if(e.getSource()==backBut){
				cardLayout.show(mainPanel, "activeMapPanel");
			}
		}
	}

}
