import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HelpPanel extends JPanel {

	private Image background;
	private ImageIcon buttonImage;
	private JButton backButton;
	private JPanel mainPanel;
	private CardLayout cardLayout;
	public int pageNo;
	
	/**
	 * Create the panel.
	 */
	public HelpPanel(JPanel main, CardLayout cl) {
		
		cardLayout=cl;
		mainPanel=main;
		
				
		buttonImage = new ImageIcon("images/go back to menu.png");
		backButton = new JButton("");
		add(backButton);
		backButton.setBounds(230, 583, 180, 56);
		backButton.setIcon(buttonImage);
		
		backButton.setFocusPainted(false); 
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);	
		backButton.setFocusable(false);
		
		ButtonListener buttonL = new ButtonListener();
		
		backButton.addActionListener(buttonL);
		
		//set the bounds of the panel
		setBounds(0, 0, 650, 650);
		
		//to change the places of buttons on the panel
		setVisible(true);
		setLayout(null);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		pageNo=0;
		
		background = new ImageIcon("images/help background0.png").getImage();
		
		g.drawImage( background, 0, 0, null); //draw background
	}

	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource()==backButton){
				cardLayout.show(mainPanel, "menu");
			}
		}
	}
}
