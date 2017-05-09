import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class MenuFrame extends JFrame {

	private MenuPanel menuPanel;
	private HelpPanel helpPanel;
	private OptionsPanel optionsPanel;
	private CardLayout cardLayout;
	private JPanel mainPanel;
	private static MenuFrame frame;
	private GameMainPanel gameMainPanel;
	private AddPlayerPanel addPlayerPanel;
	private PlayerNumberPanel playerNumberPanel;
	private int playerNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		frame = new MenuFrame();
		
		frame.pack();
        frame.setVisible(true);
        frame.setSize(650, 679);
        frame.setBounds(0, 0, 650, 679);
        frame.setPreferredSize(new Dimension(650,679));
		
	}

	/**
	 * Create the frame.
	 */
	public MenuFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 665, 687);
		setLayout( new BorderLayout());
		
		mainPanel=new JPanel();
		add(mainPanel, BorderLayout.CENTER);
		
		setSize(665, 687);
		setVisible(true);
		setResizable(false);
		add(mainPanel, BorderLayout.CENTER);
		
		cardLayout = new CardLayout();
		mainPanel.setLayout(cardLayout);
		
		gameMainPanel = new GameMainPanel(mainPanel, cardLayout);
		menuPanel= new MenuPanel(mainPanel, cardLayout);
		helpPanel = new HelpPanel(mainPanel, cardLayout);
		optionsPanel = new OptionsPanel(mainPanel, cardLayout);
		addPlayerPanel = new AddPlayerPanel(mainPanel, cardLayout);
		playerNumberPanel = new PlayerNumberPanel(mainPanel, cardLayout, addPlayerPanel);		
		
		menuPanel.setPreferredSize(new Dimension(665, 687));
		helpPanel.setPreferredSize(new Dimension(665, 687));
		optionsPanel.setPreferredSize(new Dimension(665, 687));
		
		mainPanel.add("gameMainPanel", gameMainPanel);
		mainPanel.add("menu", menuPanel);
		mainPanel.add("playerNumPanel", playerNumberPanel);
		//playerNum=playerNumberPanel.getNumOfPlayer();
		
		//addPlayerPanel.setPlayerNum(playerNumberPanel.getNumOfPlayer());
		//mainPanel.add("gameMainPanel", gameMainPanel);
		mainPanel.add("addPlayerPanel", addPlayerPanel);
		mainPanel.add("help", helpPanel);
		mainPanel.add("options", optionsPanel);
		//mainPanel.add("gameMainPanel", gameMainPanel);
		
		
	}	


}
