package GUI;
import java.awt.*;
import javax.swing.*;
//import java.awt.event.*;


public class PickAFactionFrame extends JFrame {

	//private JPanel contentPane;
	private JLabel message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PickAFactionFrame frame = new PickAFactionFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PickAFactionFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		message = new JLabel("Pick a faction and enter name to go to next step!");
		//message.setBounds(0, 0, 250, 350);
		
		setBounds(0,0, 300, 100);
		add(message);
		message.setVisible(true);
		//setLayout(null);
	}

}
