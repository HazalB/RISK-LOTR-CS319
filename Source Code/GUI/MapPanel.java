import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;


public class MapPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private Image background;
	private JLabel provinceImage[];
	private JButton provinceActionButton[];
	private CardLayout cardLayout;
	private JPanel mainPanel;
	private JLabel nameLabel;
	
	public MapPanel(JPanel mP, CardLayout cl) {
		
		provinceImage = new JLabel[67];
		provinceActionButton = new JButton[67];
		cardLayout = cl;
		mainPanel=mP;
		
		nameLabel = new JLabel("Hazal");
		add(nameLabel);
		nameLabel.setBounds(10, 2, 150, 40);
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		nameLabel.setForeground(Color.BLUE);
		
		//set all the buttons image visible
		for(int i=1; i<67; i++){
			provinceImage[i] = new JLabel();
			provinceActionButton[i] = new JButton();
		}
		
		//locations of all the buttons
		
		provinceImage[1].setBounds(22, 85, 54, 84);
		provinceImage[2].setBounds(43, 128, 59, 71);
		provinceImage[3].setBounds(71, 31, 108, 110);
		provinceImage[4].setBounds(115, 76, 49, 62);
		provinceImage[5].setBounds(91, 111, 70, 102);
		provinceImage[7].setBounds(39, 177, 69, 96);
		provinceImage[8].setBounds(111, 162, 44, 63);
		provinceImage[9].setBounds(174, 0, 192, 68);
		provinceImage[10].setBounds(243 ,39, 81, 42);
		provinceImage[11].setBounds(197, 59, 67, 42);
		provinceImage[12].setBounds(150, 50, 110, 92);
		provinceImage[13].setBounds(156, 96, 48, 40);
		provinceImage[14].setBounds(221, 104, 63, 85);
		provinceImage[15].setBounds(146, 125, 55, 47);
		provinceImage[16].setBounds(181, 137, 54, 45);
		provinceImage[17].setBounds(163, 159, 44, 43);
		provinceImage[18].setBounds(140, 157, 33, 52);
		provinceImage[19].setBounds(147, 170, 80, 80);
		provinceImage[20].setBounds(270, 68, 57, 95);
		provinceImage[21].setBounds(302, 70, 56, 83);
		provinceImage[22].setBounds(284, 145, 49, 124);
		provinceImage[23].setBounds(313, 144, 67, 73);
		provinceImage[24].setBounds(308, 210, 70, 75);
		provinceImage[25].setBounds(359, 0, 83, 102);
		provinceImage[26].setBounds(345, 26, 65, 65);
		provinceImage[27].setBounds(334, 76, 67, 112);
		provinceImage[28].setBounds(377, 95, 65, 142);
		provinceImage[29].setBounds(340, 180, 102, 259);
		provinceImage[30].setBounds(378, 293, 64, 67);
		provinceImage[31].setBounds(262, 349, 112, 91);
		provinceImage[32].setBounds(287, 264, 69, 112);
		provinceImage[33].setBounds(262, 292, 57, 93);
		provinceImage[34].setBounds(239, 248, 59, 61);
		provinceImage[35].setBounds(259, 160, 49, 99);
		provinceImage[36].setBounds(226, 204, 50, 45);
		provinceImage[37].setBounds(190, 170, 86, 86);
		provinceImage[38].setBounds(170, 244, 75, 65);
		provinceImage[39].setBounds(94, 213, 90, 99);
		provinceImage[40].setBounds(148, 263, 72, 114);
		provinceImage[41].setBounds(209, 296, 68, 86);
		provinceImage[42].setBounds(190, 356, 93, 86);
		provinceImage[43].setBounds(120, 369, 101, 77);
		provinceImage[44].setBounds(81, 434, 76, 67);
		provinceImage[45].setBounds(53, 487, 81, 40);
		provinceImage[46].setBounds(121, 463, 47, 71);
		provinceImage[47].setBounds(158, 438, 50, 77);
		provinceImage[48].setBounds(183, 452, 55, 58);
		provinceImage[49].setBounds(225, 458, 59, 76);
		provinceImage[50].setBounds(241, 436, 44, 50);
		provinceImage[51].setBounds(174, 481, 68, 82);
		provinceImage[52].setBounds(266, 435, 52, 82);
		provinceImage[53].setBounds(265, 509, 59, 46);
		provinceImage[54].setBounds(311, 432, 59, 33);
		provinceImage[55].setBounds(324, 456, 62, 32);
		provinceImage[56].setBounds(377, 441, 65, 34);
		provinceImage[57].setBounds(310, 180, 54, 36);
		provinceImage[58].setBounds(352, 465, 90, 70);
		provinceImage[59].setBounds(337, 516, 66, 47);
		provinceImage[60].setBounds(204, 538, 47, 41);
		provinceImage[61].setBounds(252, 539, 76, 46);
		provinceImage[62].setBounds(180, 576, 113, 43);
		provinceImage[63].setBounds(140, 606, 156, 44);
		provinceImage[64].setBounds(279, 562, 84, 88);
		provinceImage[65].setBounds(334, 572, 108, 78);
		provinceImage[66].setBounds(377, 545, 66, 86);
		
		for(int i=1; i<67; i++){
			if(i!=6){
				add(provinceActionButton[i]);
				add(provinceImage[i]);
			}
		}
		
		/*for(int i=1; i<67; i++){
			if(i!=6){
				provinceActionButton[i].addActionListener(new ButtonListener());
			}
		}*/
		
		//set Buttons
		provinceImage[1].setIcon(new ImageIcon("images/regions/01green.png"));
		provinceImage[2].setIcon(new ImageIcon("images/regions/02green.png"));
		provinceImage[3].setIcon(new ImageIcon("images/regions/03green.png"));
		provinceImage[4].setIcon(new ImageIcon("images/regions/04green.png"));
		provinceImage[5].setIcon(new ImageIcon("images/regions/05green.png"));
		provinceImage[7].setIcon(new ImageIcon("images/regions/07green.png"));
		provinceImage[8].setIcon(new ImageIcon("images/regions/08green.png"));
		provinceImage[9].setIcon(new ImageIcon("images/regions/09green.png"));
		provinceImage[10].setIcon(new ImageIcon("images/regions/10green.png"));
		provinceImage[11].setIcon(new ImageIcon("images/regions/11green.png"));
		provinceImage[12].setIcon(new ImageIcon("images/regions/12green.png"));
		provinceImage[13].setIcon(new ImageIcon("images/regions/13green.png"));
		provinceImage[14].setIcon(new ImageIcon("images/regions/14green.png"));
		provinceImage[15].setIcon(new ImageIcon("images/regions/15green.png"));
		provinceImage[16].setIcon(new ImageIcon("images/regions/16green.png"));
		provinceImage[17].setIcon(new ImageIcon("images/regions/17green.png"));
		provinceImage[18].setIcon(new ImageIcon("images/regions/18green.png"));
		provinceImage[19].setIcon(new ImageIcon("images/regions/19green.png"));
		provinceImage[20].setIcon(new ImageIcon("images/regions/20brown.png"));
		provinceImage[21].setIcon(new ImageIcon("images/regions/21brown.png"));
		provinceImage[22].setIcon(new ImageIcon("images/regions/22brown.png"));
		provinceImage[23].setIcon(new ImageIcon("images/regions/23brown.png"));
		provinceImage[24].setIcon(new ImageIcon("images/regions/24brown.png"));
		provinceImage[25].setIcon(new ImageIcon("images/regions/25brown.png"));
		provinceImage[26].setIcon(new ImageIcon("images/regions/26brown.png"));
		provinceImage[27].setIcon(new ImageIcon("images/regions/27brown.png"));
		provinceImage[28].setIcon(new ImageIcon("images/regions/28brown.png"));
		provinceImage[29].setIcon(new ImageIcon("images/regions/29yellow.png"));
		provinceImage[30].setIcon(new ImageIcon("images/regions/30yellow.png"));
		provinceImage[31].setIcon(new ImageIcon("images/regions/31yellow.png"));
		provinceImage[32].setIcon(new ImageIcon("images/regions/32yellow.png"));
		provinceImage[33].setIcon(new ImageIcon("images/regions/33yellow.png"));
		provinceImage[34].setIcon(new ImageIcon("images/regions/34yellow.png"));
		provinceImage[35].setIcon(new ImageIcon("images/regions/35yellow.png"));
		provinceImage[36].setIcon(new ImageIcon("images/regions/36yellow.png"));
		provinceImage[37].setIcon(new ImageIcon("images/regions/37blue.png"));
		provinceImage[38].setIcon(new ImageIcon("images/regions/38blue.png"));
		provinceImage[39].setIcon(new ImageIcon("images/regions/39blue.png"));
		provinceImage[40].setIcon(new ImageIcon("images/regions/40blue.png"));
		provinceImage[41].setIcon(new ImageIcon("images/regions/41blue.png"));
		provinceImage[42].setIcon(new ImageIcon("images/regions/42blue.png"));
		provinceImage[43].setIcon(new ImageIcon("images/regions/43blue.png"));
		provinceImage[44].setIcon(new ImageIcon("images/regions/44mint.png"));
		provinceImage[45].setIcon(new ImageIcon("images/regions/45mint.png"));
		provinceImage[46].setIcon(new ImageIcon("images/regions/46mint.png"));
		provinceImage[47].setIcon(new ImageIcon("images/regions/47mint.png"));
		provinceImage[48].setIcon(new ImageIcon("images/regions/48mint.png"));
		provinceImage[49].setIcon(new ImageIcon("images/regions/49mint.png"));
		provinceImage[50].setIcon(new ImageIcon("images/regions/50mint.png"));
		provinceImage[51].setIcon(new ImageIcon("images/regions/51mint.png"));
		provinceImage[52].setIcon(new ImageIcon("images/regions/52mint.png"));
		provinceImage[53].setIcon(new ImageIcon("images/regions/53mint.png"));
		provinceImage[54].setIcon(new ImageIcon("images/regions/54military.png"));
		provinceImage[55].setIcon(new ImageIcon("images/regions/55military.png"));
		provinceImage[56].setIcon(new ImageIcon("images/regions/56military.png"));
		provinceImage[57].setIcon(new ImageIcon("images/regions/57military.png"));
		provinceImage[58].setIcon(new ImageIcon("images/regions/58military.png"));
		provinceImage[59].setIcon(new ImageIcon("images/regions/59military.png"));
		provinceImage[60].setIcon(new ImageIcon("images/regions/60military.png"));
		provinceImage[61].setIcon(new ImageIcon("images/regions/61pink.png"));
		provinceImage[62].setIcon(new ImageIcon("images/regions/62pink.png"));
		provinceImage[63].setIcon(new ImageIcon("images/regions/63pink.png"));
		provinceImage[64].setIcon(new ImageIcon("images/regions/64pink.png"));
		provinceImage[65].setIcon(new ImageIcon("images/regions/65pink.png"));
		provinceImage[66].setIcon(new ImageIcon("images/regions/66pink.png"));
		
		for(int i=1; i<67; i++){
			if(i!=6){
				provinceActionButton[i].setIcon(new ImageIcon("images/provinceActionButton.png"));
			}
		}
		
		
		provinceActionButton[1].setBounds(35, 100, 15, 15);
		provinceActionButton[2].setBounds(75, 148, 15, 15);
		provinceActionButton[3].setBounds(101, 80, 15, 15);
		provinceActionButton[4].setBounds(130, 107, 15, 15);
		provinceActionButton[5].setBounds(110, 152, 15, 15);
		provinceActionButton[7].setBounds(73, 225, 15, 15);
		provinceActionButton[8].setBounds(124, 194, 15, 15);
		provinceActionButton[9].setBounds(270, 20, 15, 15);
		provinceActionButton[10].setBounds(270, 55, 15, 15);
		provinceActionButton[11].setBounds(225, 80, 15, 15);
		provinceActionButton[12].setBounds(210, 110, 15, 15);
		provinceActionButton[13].setBounds(180, 101, 15, 15);
		provinceActionButton[14].setBounds(240, 140, 15, 15);
		provinceActionButton[15].setBounds(160, 140, 15, 15);
		provinceActionButton[16].setBounds(200, 150, 15, 15);
		provinceActionButton[17].setBounds(175, 175, 15, 15);
		provinceActionButton[18].setBounds(149, 175, 15, 15);
		provinceActionButton[19].setBounds(170, 210, 15, 15);
		provinceActionButton[20].setBounds(289, 110, 15, 15);
		provinceActionButton[21].setBounds(325, 110, 15, 15);
		provinceActionButton[22].setBounds(307, 200, 15, 15);
		provinceActionButton[23].setBounds(345, 180, 15, 15);
		provinceActionButton[24].setBounds(340, 245, 15, 15);
		provinceActionButton[25].setBounds(420, 30, 15, 15);
		provinceActionButton[26].setBounds(380, 60, 15, 15);
		provinceActionButton[27].setBounds(370, 120, 15, 15);
		provinceActionButton[28].setBounds(410, 170, 15, 15);
		provinceActionButton[29].setBounds(360, 310, 15, 15);
		provinceActionButton[30].setBounds(410, 320, 15, 15);
		provinceActionButton[31].setBounds(320, 390, 15, 15);
		provinceActionButton[32].setBounds(325, 320, 15, 15);
		provinceActionButton[33].setBounds(280, 320, 15, 15);
		provinceActionButton[34].setBounds(260, 270, 15, 15);
		provinceActionButton[35].setBounds(277, 210, 15, 15);
		provinceActionButton[36].setBounds(240, 220, 15, 15);
		provinceActionButton[37].setBounds(210, 220, 15, 15);
		provinceActionButton[38].setBounds(190, 260, 15, 15);
		provinceActionButton[39].setBounds(130, 250, 15, 15);
		provinceActionButton[40].setBounds(180, 330, 15, 15);
		provinceActionButton[41].setBounds(240, 340, 15, 15);
		provinceActionButton[42].setBounds(240, 400, 15, 15);
		provinceActionButton[43].setBounds(170, 385, 15, 15);
		provinceActionButton[44].setBounds(120, 450, 15, 15);
		provinceActionButton[45].setBounds(110, 500, 15, 15);
		provinceActionButton[46].setBounds(140, 480, 15, 15);
		provinceActionButton[47].setBounds(170, 460, 15, 15);
		provinceActionButton[48].setBounds(205, 470, 15, 15);
		provinceActionButton[49].setBounds(250, 490, 15, 15);
		provinceActionButton[50].setBounds(250, 450, 15, 15);
		provinceActionButton[51].setBounds(210, 510, 15, 15);
		provinceActionButton[52].setBounds(290, 470, 15, 15);
		provinceActionButton[53].setBounds(290, 520, 15, 15);
		provinceActionButton[54].setBounds(330, 440, 15, 15);
		provinceActionButton[55].setBounds(350, 465, 15, 15);
		provinceActionButton[56].setBounds(390, 450, 15, 15);
		provinceActionButton[57].setBounds(330, 490, 15, 15);
		provinceActionButton[58].setBounds(390, 490, 15, 15);
		provinceActionButton[59].setBounds(350, 535, 15, 15);
		provinceActionButton[60].setBounds(217, 554, 15, 15);
		provinceActionButton[61].setBounds(267, 554, 15, 15);
		provinceActionButton[62].setBounds(240, 590, 15, 15);
		provinceActionButton[63].setBounds(230, 630, 15, 15);
		provinceActionButton[64].setBounds(310, 600, 15, 15);
		provinceActionButton[65].setBounds(360, 600, 15, 15);
		provinceActionButton[66].setBounds(410, 570, 15, 15);
		
		for(int i=1; i<67; i++){
			if(i!=6)
				provinceActionButton[i].setVisible(false);
		}
		/*for(int i=37; i<44; i++){
			provinceActionButton[i].setVisible(true);
		}	*/	
		
		setVisible(true);
		setLayout(null);
		setBackground(Color.black);
		
		setBounds(0, 0, 442, 650);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);		
		background = new ImageIcon("images/maplast.png").getImage(); //get background icon as image
		
		g.drawImage( background, 0, 0, null); //draw background
	}
	

}
