import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.BasicSliderUI;
import java.io.File;
import java.io.IOException;


public class OptionsPanel extends JPanel {

	private Image background;
	private ImageIcon buttonImage;
	private JButton backButton;
	private JSlider soundSlider, musicSlider;
	private int musicLevel, soundLevel;
	private CardLayout cardLayout;
	private JPanel mainPanel;
	/**
	 * Create the panel.
	 */
	public OptionsPanel(JPanel mP, CardLayout cl){
		

		mainPanel=mP;
		cardLayout=cl;
		
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
		
		soundSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
		soundSlider.setMajorTickSpacing(10);
		soundSlider.setMinorTickSpacing(1);
		soundSlider.setPaintTicks(true);
		soundSlider.setPaintLabels(true);
		soundSlider.setAlignmentX(Component.LEFT_ALIGNMENT);
		soundSlider.setUI(new mySliderUI(soundSlider));
		
		musicSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
		musicSlider.setMajorTickSpacing(10);
		musicSlider.setMinorTickSpacing(1);
		musicSlider.setPaintTicks(true);
		musicSlider.setPaintLabels(true);
		musicSlider.setAlignmentX(Component.LEFT_ALIGNMENT);
		musicSlider.setUI(new mySliderUI(soundSlider));
		
		add(soundSlider);
		soundSlider.setBounds(230, 216, 330, 56);
		
		soundSlider.setOpaque(false);
		soundSlider.setFocusable(false);
		
		add(musicSlider);
		musicSlider.setBounds(230, 283, 330, 56);
		
		musicSlider.setOpaque(false);
		musicSlider.setFocusable(false);
		
		//listener for sliders
		SliderListener sListener = new SliderListener();
		soundSlider.addChangeListener(sListener);
		musicSlider.addChangeListener(sListener);
		
		//set the bounds of the panel
		setBounds(0, 0, 650, 650);
		
		//to change the places of buttons on the panel
		setLayout(null);
		setVisible(true);
        
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);		
		background = new ImageIcon("images/optionsbackground.png").getImage(); //get background icon as image
		
		g.drawImage( background, 0, 0, null); //draw background
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			cardLayout.show(mainPanel, "menu");
		}
	}
	
	private class mySliderUI extends BasicSliderUI {

        Image knobImage;

        public mySliderUI( JSlider aSlider ) {

            super( aSlider );

            try {
                this.knobImage = ImageIO.read( new File( "images/sliderbut.png") );

            } catch ( IOException e ) {

                e.printStackTrace();
            }
        }
        public void paintThumb(Graphics g)  {        

            g.drawImage( this.knobImage, thumbRect.x, thumbRect.y, 17, 17, null );

        }

    }
	
	public int getSoundLevel(){
		return soundLevel;
	}
	
	public int getMusicLevel(){
		return musicLevel;
	}
	
	private class SliderListener implements ChangeListener{
		public void stateChanged(ChangeEvent event){
			musicLevel=musicSlider.getValue();
			soundLevel=soundSlider.getValue();
		}
	}
	


}
