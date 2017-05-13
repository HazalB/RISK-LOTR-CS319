package GUI;
import javax.swing.*;

import Manager.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class AttackMapPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private Image background;
	private JLabel provinceImage[];
	private JButton provinceActionButton[];
	private ImageIcon provincegreen[], provincegrey[], provincepink[], provinceyellow[], provincemint[];
	private ImageIcon provincebrown[], provincemilitary[], provinceorange[], provinceblue[];
	private CardLayout cardLayout;
	private JPanel mainPanel;
	private JLabel nameLabel;
	private MainGameManager game;
	private int attackFrom, attackTo;
	private AttackSoldierPanel attackSoldierPanel;
	private ArrayList<Integer> toGreyBackProv;
	
	public AttackMapPanel(JPanel mP, CardLayout cl, MainGameManager mGM, AttackSoldierPanel aSP) {
		provinceImage = new JLabel[67];
		provinceActionButton = new JButton[67];
		
		attackTo=-1;
		
		game = mGM;
		attackSoldierPanel = aSP;
		
		provincegreen = new ImageIcon[67];
		provincegrey = new ImageIcon[67];
		provincepink = new ImageIcon[67];
		provinceyellow = new ImageIcon[67];
		provincemint = new ImageIcon[67];
		provincebrown = new ImageIcon[67];
		provincemilitary = new ImageIcon[67];
		provinceorange = new ImageIcon[67];
		provinceblue = new ImageIcon[67];
		
		//all of the images for the provinces in here
		
		//green
		provincegreen[1] = new ImageIcon("images/regions/01green.png");
		provincegreen[2] = new ImageIcon("images/regions/02green.png");
		provincegreen[3] = new ImageIcon("images/regions/03green.png");
		provincegreen[4] = new ImageIcon("images/regions/04green.png");
		provincegreen[5] = new ImageIcon("images/regions/05green.png");
		provincegreen[7] = new ImageIcon("images/regions/07green.png");
		provincegreen[8] = new ImageIcon("images/regions/08green.png");
		provincegreen[9] = new ImageIcon("images/regions/09green.png");
		provincegreen[10] = new ImageIcon("images/regions/10green.png");
		provincegreen[11] = new ImageIcon("images/regions/11green.png");
		provincegreen[12] = new ImageIcon("images/regions/12green.png");
		provincegreen[13] = new ImageIcon("images/regions/13green.png");
		provincegreen[14] = new ImageIcon("images/regions/14green.png");
		provincegreen[15] = new ImageIcon("images/regions/15green.png");
		provincegreen[16] = new ImageIcon("images/regions/16green.png");
		provincegreen[17] = new ImageIcon("images/regions/17green.png");
		provincegreen[18] = new ImageIcon("images/regions/18green.png");
		provincegreen[19] = new ImageIcon("images/regions/19green.png");
		provincegreen[20] = new ImageIcon("images/regions/20green.png");
		provincegreen[21] = new ImageIcon("images/regions/21green.png");
		provincegreen[22] = new ImageIcon("images/regions/22green.png");
		provincegreen[23] = new ImageIcon("images/regions/23green.png");
		provincegreen[24] = new ImageIcon("images/regions/24green.png");
		provincegreen[25] = new ImageIcon("images/regions/25green.png");
		provincegreen[26] = new ImageIcon("images/regions/26green.png");
		provincegreen[27] = new ImageIcon("images/regions/27green.png");
		provincegreen[28] = new ImageIcon("images/regions/28green.png");
		provincegreen[29] = new ImageIcon("images/regions/29green.png");
		provincegreen[30] = new ImageIcon("images/regions/30green.png");
		provincegreen[31] = new ImageIcon("images/regions/31green.png");
		provincegreen[32] = new ImageIcon("images/regions/32green.png");
		provincegreen[33] = new ImageIcon("images/regions/33green.png");
		provincegreen[34] = new ImageIcon("images/regions/34green.png");
		provincegreen[35] = new ImageIcon("images/regions/35green.png");
		provincegreen[36] = new ImageIcon("images/regions/36green.png");
		provincegreen[37] = new ImageIcon("images/regions/37green.png");
		provincegreen[38] = new ImageIcon("images/regions/38green.png");
		provincegreen[39] = new ImageIcon("images/regions/39green.png");
		provincegreen[40] = new ImageIcon("images/regions/40green.png");
		provincegreen[41] = new ImageIcon("images/regions/41green.png");
		provincegreen[42] = new ImageIcon("images/regions/42green.png");
		provincegreen[43] = new ImageIcon("images/regions/43green.png");
		provincegreen[44] = new ImageIcon("images/regions/44green.png");
		provincegreen[45] = new ImageIcon("images/regions/45green.png");
		provincegreen[46] = new ImageIcon("images/regions/46green.png");
		provincegreen[47] = new ImageIcon("images/regions/47green.png");
		provincegreen[48] = new ImageIcon("images/regions/48green.png");
		provincegreen[49] = new ImageIcon("images/regions/49green.png");
		provincegreen[50] = new ImageIcon("images/regions/50green.png");
		provincegreen[51] = new ImageIcon("images/regions/51green.png");
		provincegreen[52] = new ImageIcon("images/regions/52green.png");
		provincegreen[53] = new ImageIcon("images/regions/53green.png");
		provincegreen[54] = new ImageIcon("images/regions/54green.png");
		provincegreen[55] = new ImageIcon("images/regions/55green.png");
		provincegreen[56] = new ImageIcon("images/regions/56green.png");
		provincegreen[57] = new ImageIcon("images/regions/57green.png");
		provincegreen[58] = new ImageIcon("images/regions/58green.png");
		provincegreen[59] = new ImageIcon("images/regions/59green.png");
		provincegreen[60] = new ImageIcon("images/regions/60green.png");
		provincegreen[61] = new ImageIcon("images/regions/61green.png");
		provincegreen[62] = new ImageIcon("images/regions/62green.png");
		provincegreen[63] = new ImageIcon("images/regions/63green.png");
		provincegreen[64] = new ImageIcon("images/regions/64green.png");
		provincegreen[65] = new ImageIcon("images/regions/65green.png");
		provincegreen[66] = new ImageIcon("images/regions/66green.png");
		
		//grey
		provincegrey[1] = new ImageIcon("images/regions/01grey.png");
		provincegrey[2] = new ImageIcon("images/regions/02grey.png");
		provincegrey[3] = new ImageIcon("images/regions/03grey.png");
		provincegrey[4] = new ImageIcon("images/regions/04grey.png");
		provincegrey[5] = new ImageIcon("images/regions/05grey.png");
		provincegrey[7] = new ImageIcon("images/regions/07grey.png");
		provincegrey[8] = new ImageIcon("images/regions/08grey.png");
		provincegrey[9] = new ImageIcon("images/regions/09grey.png");
		provincegrey[10] = new ImageIcon("images/regions/10grey.png");
		provincegrey[11] = new ImageIcon("images/regions/11grey.png");
		provincegrey[12] = new ImageIcon("images/regions/12grey.png");
		provincegrey[13] = new ImageIcon("images/regions/13grey.png");
		provincegrey[14] = new ImageIcon("images/regions/14grey.png");
		provincegrey[15] = new ImageIcon("images/regions/15grey.png");
		provincegrey[16] = new ImageIcon("images/regions/16grey.png");
		provincegrey[17] = new ImageIcon("images/regions/17grey.png");
		provincegrey[18] = new ImageIcon("images/regions/18grey.png");
		provincegrey[19] = new ImageIcon("images/regions/19grey.png");
		provincegrey[20] = new ImageIcon("images/regions/20grey.png");
		provincegrey[21] = new ImageIcon("images/regions/21grey.png");
		provincegrey[22] = new ImageIcon("images/regions/22grey.png");
		provincegrey[23] = new ImageIcon("images/regions/23grey.png");
		provincegrey[24] = new ImageIcon("images/regions/24grey.png");
		provincegrey[25] = new ImageIcon("images/regions/25grey.png");
		provincegrey[26] = new ImageIcon("images/regions/26grey.png");
		provincegrey[27] = new ImageIcon("images/regions/27grey.png");
		provincegrey[28] = new ImageIcon("images/regions/28grey.png");
		provincegrey[29] = new ImageIcon("images/regions/29grey.png");
		provincegrey[30] = new ImageIcon("images/regions/30grey.png");
		provincegrey[31] = new ImageIcon("images/regions/31grey.png");
		provincegrey[32] = new ImageIcon("images/regions/32grey.png");
		provincegrey[33] = new ImageIcon("images/regions/33grey.png");
		provincegrey[34] = new ImageIcon("images/regions/34grey.png");
		provincegrey[35] = new ImageIcon("images/regions/35grey.png");
		provincegrey[36] = new ImageIcon("images/regions/36grey.png");
		provincegrey[37] = new ImageIcon("images/regions/37grey.png");
		provincegrey[38] = new ImageIcon("images/regions/38grey.png");
		provincegrey[39] = new ImageIcon("images/regions/39grey.png");
		provincegrey[40] = new ImageIcon("images/regions/40grey.png");
		provincegrey[41] = new ImageIcon("images/regions/41grey.png");
		provincegrey[42] = new ImageIcon("images/regions/42grey.png");
		provincegrey[43] = new ImageIcon("images/regions/43grey.png");
		provincegrey[44] = new ImageIcon("images/regions/44grey.png");
		provincegrey[45] = new ImageIcon("images/regions/45grey.png");
		provincegrey[46] = new ImageIcon("images/regions/46grey.png");
		provincegrey[47] = new ImageIcon("images/regions/47grey.png");
		provincegrey[48] = new ImageIcon("images/regions/48grey.png");
		provincegrey[49] = new ImageIcon("images/regions/49grey.png");
		provincegrey[50] = new ImageIcon("images/regions/50grey.png");
		provincegrey[51] = new ImageIcon("images/regions/51grey.png");
		provincegrey[52] = new ImageIcon("images/regions/52grey.png");
		provincegrey[53] = new ImageIcon("images/regions/53grey.png");
		provincegrey[54] = new ImageIcon("images/regions/54grey.png");
		provincegrey[55] = new ImageIcon("images/regions/55grey.png");
		provincegrey[56] = new ImageIcon("images/regions/56grey.png");
		provincegrey[57] = new ImageIcon("images/regions/57grey.png");
		provincegrey[58] = new ImageIcon("images/regions/58grey.png");
		provincegrey[59] = new ImageIcon("images/regions/59grey.png");
		provincegrey[60] = new ImageIcon("images/regions/60grey.png");
		provincegrey[61] = new ImageIcon("images/regions/61grey.png");
		provincegrey[62] = new ImageIcon("images/regions/62grey.png");
		provincegrey[63] = new ImageIcon("images/regions/63grey.png");
		provincegrey[64] = new ImageIcon("images/regions/64grey.png");
		provincegrey[65] = new ImageIcon("images/regions/65grey.png");
		provincegrey[66] = new ImageIcon("images/regions/66grey.png");
		
		//pink
		provincepink[1] = new ImageIcon("images/regions/01pink.png");
		provincepink[2] = new ImageIcon("images/regions/02pink.png");
		provincepink[3] = new ImageIcon("images/regions/03pink.png");
		provincepink[4] = new ImageIcon("images/regions/04pink.png");
		provincepink[5] = new ImageIcon("images/regions/05pink.png");
		provincepink[7] = new ImageIcon("images/regions/07pink.png");
		provincepink[8] = new ImageIcon("images/regions/08pink.png");
		provincepink[9] = new ImageIcon("images/regions/09pink.png");
		provincepink[10] = new ImageIcon("images/regions/10pink.png");
		provincepink[11] = new ImageIcon("images/regions/11pink.png");
		provincepink[12] = new ImageIcon("images/regions/12pink.png");
		provincepink[13] = new ImageIcon("images/regions/13pink.png");
		provincepink[14] = new ImageIcon("images/regions/14pink.png");
		provincepink[15] = new ImageIcon("images/regions/15pink.png");
		provincepink[16] = new ImageIcon("images/regions/16pink.png");
		provincepink[17] = new ImageIcon("images/regions/17pink.png");
		provincepink[18] = new ImageIcon("images/regions/18pink.png");
		provincepink[19] = new ImageIcon("images/regions/19pink.png");
		provincepink[20] = new ImageIcon("images/regions/20pink.png");
		provincepink[21] = new ImageIcon("images/regions/21pink.png");
		provincepink[22] = new ImageIcon("images/regions/22pink.png");
		provincepink[23] = new ImageIcon("images/regions/23pink.png");
		provincepink[24] = new ImageIcon("images/regions/24pink.png");
		provincepink[25] = new ImageIcon("images/regions/25pink.png");
		provincepink[26] = new ImageIcon("images/regions/26pink.png");
		provincepink[27] = new ImageIcon("images/regions/27pink.png");
		provincepink[28] = new ImageIcon("images/regions/28pink.png");
		provincepink[29] = new ImageIcon("images/regions/29pink.png");
		provincepink[30] = new ImageIcon("images/regions/30pink.png");
		provincepink[31] = new ImageIcon("images/regions/31pink.png");
		provincepink[32] = new ImageIcon("images/regions/32pink.png");
		provincepink[33] = new ImageIcon("images/regions/33pink.png");
		provincepink[34] = new ImageIcon("images/regions/34pink.png");
		provincepink[35] = new ImageIcon("images/regions/35pink.png");
		provincepink[36] = new ImageIcon("images/regions/36pink.png");
		provincepink[37] = new ImageIcon("images/regions/37pink.png");
		provincepink[38] = new ImageIcon("images/regions/38pink.png");
		provincepink[39] = new ImageIcon("images/regions/39pink.png");
		provincepink[40] = new ImageIcon("images/regions/40pink.png");
		provincepink[41] = new ImageIcon("images/regions/41pink.png");
		provincepink[42] = new ImageIcon("images/regions/42pink.png");
		provincepink[43] = new ImageIcon("images/regions/43pink.png");
		provincepink[44] = new ImageIcon("images/regions/44pink.png");
		provincepink[45] = new ImageIcon("images/regions/45pink.png");
		provincepink[46] = new ImageIcon("images/regions/46pink.png");
		provincepink[47] = new ImageIcon("images/regions/47pink.png");
		provincepink[48] = new ImageIcon("images/regions/48pink.png");
		provincepink[49] = new ImageIcon("images/regions/49pink.png");
		provincepink[50] = new ImageIcon("images/regions/50pink.png");
		provincepink[51] = new ImageIcon("images/regions/51pink.png");
		provincepink[52] = new ImageIcon("images/regions/52pink.png");
		provincepink[53] = new ImageIcon("images/regions/53pink.png");
		provincepink[54] = new ImageIcon("images/regions/54pink.png");
		provincepink[55] = new ImageIcon("images/regions/55pink.png");
		provincepink[56] = new ImageIcon("images/regions/56pink.png");
		provincepink[57] = new ImageIcon("images/regions/57pink.png");
		provincepink[58] = new ImageIcon("images/regions/58pink.png");
		provincepink[59] = new ImageIcon("images/regions/59pink.png");
		provincepink[60] = new ImageIcon("images/regions/60pink.png");
		provincepink[61] = new ImageIcon("images/regions/61pink.png");
		provincepink[62] = new ImageIcon("images/regions/62pink.png");
		provincepink[63] = new ImageIcon("images/regions/63pink.png");
		provincepink[64] = new ImageIcon("images/regions/64pink.png");
		provincepink[65] = new ImageIcon("images/regions/65pink.png");
		provincepink[66] = new ImageIcon("images/regions/66pink.png");
		
		//yellow
		provinceyellow[1] = new ImageIcon("images/regions/01yellow.png");
		provinceyellow[2] = new ImageIcon("images/regions/02yellow.png");
		provinceyellow[3] = new ImageIcon("images/regions/03yellow.png");
		provinceyellow[4] = new ImageIcon("images/regions/04yellow.png");
		provinceyellow[5] = new ImageIcon("images/regions/05yellow.png");
		provinceyellow[7] = new ImageIcon("images/regions/07yellow.png");
		provinceyellow[8] = new ImageIcon("images/regions/08yellow.png");
		provinceyellow[9] = new ImageIcon("images/regions/09yellow.png");
		provinceyellow[10] = new ImageIcon("images/regions/10yellow.png");
		provinceyellow[11] = new ImageIcon("images/regions/11yellow.png");
		provinceyellow[12] = new ImageIcon("images/regions/12yellow.png");
		provinceyellow[13] = new ImageIcon("images/regions/13yellow.png");
		provinceyellow[14] = new ImageIcon("images/regions/14yellow.png");
		provinceyellow[15] = new ImageIcon("images/regions/15yellow.png");
		provinceyellow[16] = new ImageIcon("images/regions/16yellow.png");
		provinceyellow[17] = new ImageIcon("images/regions/17yellow.png");
		provinceyellow[18] = new ImageIcon("images/regions/18yellow.png");
		provinceyellow[19] = new ImageIcon("images/regions/19yellow.png");
		provinceyellow[20] = new ImageIcon("images/regions/20yellow.png");
		provinceyellow[21] = new ImageIcon("images/regions/21yellow.png");
		provinceyellow[22] = new ImageIcon("images/regions/22yellow.png");
		provinceyellow[23] = new ImageIcon("images/regions/23yellow.png");
		provinceyellow[24] = new ImageIcon("images/regions/24yellow.png");
		provinceyellow[25] = new ImageIcon("images/regions/25yellow.png");
		provinceyellow[26] = new ImageIcon("images/regions/26yellow.png");
		provinceyellow[27] = new ImageIcon("images/regions/27yellow.png");
		provinceyellow[28] = new ImageIcon("images/regions/28yellow.png");
		provinceyellow[29] = new ImageIcon("images/regions/29yellow.png");
		provinceyellow[30] = new ImageIcon("images/regions/30yellow.png");
		provinceyellow[31] = new ImageIcon("images/regions/31yellow.png");
		provinceyellow[32] = new ImageIcon("images/regions/32yellow.png");
		provinceyellow[33] = new ImageIcon("images/regions/33yellow.png");
		provinceyellow[34] = new ImageIcon("images/regions/34yellow.png");
		provinceyellow[35] = new ImageIcon("images/regions/35yellow.png");
		provinceyellow[36] = new ImageIcon("images/regions/36yellow.png");
		provinceyellow[37] = new ImageIcon("images/regions/37yellow.png");
		provinceyellow[38] = new ImageIcon("images/regions/38yellow.png");
		provinceyellow[39] = new ImageIcon("images/regions/39yellow.png");
		provinceyellow[40] = new ImageIcon("images/regions/40yellow.png");
		provinceyellow[41] = new ImageIcon("images/regions/41yellow.png");
		provinceyellow[42] = new ImageIcon("images/regions/42yellow.png");
		provinceyellow[43] = new ImageIcon("images/regions/43yellow.png");
		provinceyellow[44] = new ImageIcon("images/regions/44yellow.png");
		provinceyellow[45] = new ImageIcon("images/regions/45yellow.png");
		provinceyellow[46] = new ImageIcon("images/regions/46yellow.png");
		provinceyellow[47] = new ImageIcon("images/regions/47yellow.png");
		provinceyellow[48] = new ImageIcon("images/regions/48yellow.png");
		provinceyellow[49] = new ImageIcon("images/regions/49yellow.png");
		provinceyellow[50] = new ImageIcon("images/regions/50yellow.png");
		provinceyellow[51] = new ImageIcon("images/regions/51yellow.png");
		provinceyellow[52] = new ImageIcon("images/regions/52yellow.png");
		provinceyellow[53] = new ImageIcon("images/regions/53yellow.png");
		provinceyellow[54] = new ImageIcon("images/regions/54yellow.png");
		provinceyellow[55] = new ImageIcon("images/regions/55yellow.png");
		provinceyellow[56] = new ImageIcon("images/regions/56yellow.png");
		provinceyellow[57] = new ImageIcon("images/regions/57yellow.png");
		provinceyellow[58] = new ImageIcon("images/regions/58yellow.png");
		provinceyellow[59] = new ImageIcon("images/regions/59yellow.png");
		provinceyellow[60] = new ImageIcon("images/regions/60yellow.png");
		provinceyellow[61] = new ImageIcon("images/regions/61yellow.png");
		provinceyellow[62] = new ImageIcon("images/regions/62yellow.png");
		provinceyellow[63] = new ImageIcon("images/regions/63yellow.png");
		provinceyellow[64] = new ImageIcon("images/regions/64yellow.png");
		provinceyellow[65] = new ImageIcon("images/regions/65yellow.png");
		provinceyellow[66] = new ImageIcon("images/regions/66yellow.png");
		
		//mint
		provincemint[1] = new ImageIcon("images/regions/01mint.png");
		provincemint[2] = new ImageIcon("images/regions/02mint.png");
		provincemint[3] = new ImageIcon("images/regions/03mint.png");
		provincemint[4] = new ImageIcon("images/regions/04mint.png");
		provincemint[5] = new ImageIcon("images/regions/05mint.png");
		provincemint[7] = new ImageIcon("images/regions/07mint.png");
		provincemint[8] = new ImageIcon("images/regions/08mint.png");
		provincemint[9] = new ImageIcon("images/regions/09mint.png");
		provincemint[10] = new ImageIcon("images/regions/10mint.png");
		provincemint[11] = new ImageIcon("images/regions/11mint.png");
		provincemint[12] = new ImageIcon("images/regions/12mint.png");
		provincemint[13] = new ImageIcon("images/regions/13mint.png");
		provincemint[14] = new ImageIcon("images/regions/14mint.png");
		provincemint[15] = new ImageIcon("images/regions/15mint.png");
		provincemint[16] = new ImageIcon("images/regions/16mint.png");
		provincemint[17] = new ImageIcon("images/regions/17mint.png");
		provincemint[18] = new ImageIcon("images/regions/18mint.png");
		provincemint[19] = new ImageIcon("images/regions/19mint.png");
		provincemint[20] = new ImageIcon("images/regions/20mint.png");
		provincemint[21] = new ImageIcon("images/regions/21mint.png");
		provincemint[22] = new ImageIcon("images/regions/22mint.png");
		provincemint[23] = new ImageIcon("images/regions/23mint.png");
		provincemint[24] = new ImageIcon("images/regions/24mint.png");
		provincemint[25] = new ImageIcon("images/regions/25mint.png");
		provincemint[26] = new ImageIcon("images/regions/26mint.png");
		provincemint[27] = new ImageIcon("images/regions/27mint.png");
		provincemint[28] = new ImageIcon("images/regions/28mint.png");
		provincemint[29] = new ImageIcon("images/regions/29mint.png");
		provincemint[30] = new ImageIcon("images/regions/30mint.png");
		provincemint[31] = new ImageIcon("images/regions/31mint.png");
		provincemint[32] = new ImageIcon("images/regions/32mint.png");
		provincemint[33] = new ImageIcon("images/regions/33mint.png");
		provincemint[34] = new ImageIcon("images/regions/34mint.png");
		provincemint[35] = new ImageIcon("images/regions/35mint.png");
		provincemint[36] = new ImageIcon("images/regions/36mint.png");
		provincemint[37] = new ImageIcon("images/regions/37mint.png");
		provincemint[38] = new ImageIcon("images/regions/38mint.png");
		provincemint[39] = new ImageIcon("images/regions/39mint.png");
		provincemint[40] = new ImageIcon("images/regions/40mint.png");
		provincemint[41] = new ImageIcon("images/regions/41mint.png");
		provincemint[42] = new ImageIcon("images/regions/42mint.png");
		provincemint[43] = new ImageIcon("images/regions/43mint.png");
		provincemint[44] = new ImageIcon("images/regions/44mint.png");
		provincemint[45] = new ImageIcon("images/regions/45mint.png");
		provincemint[46] = new ImageIcon("images/regions/46mint.png");
		provincemint[47] = new ImageIcon("images/regions/47mint.png");
		provincemint[48] = new ImageIcon("images/regions/48mint.png");
		provincemint[49] = new ImageIcon("images/regions/49mint.png");
		provincemint[50] = new ImageIcon("images/regions/50mint.png");
		provincemint[51] = new ImageIcon("images/regions/51mint.png");
		provincemint[52] = new ImageIcon("images/regions/52mint.png");
		provincemint[53] = new ImageIcon("images/regions/53mint.png");
		provincemint[54] = new ImageIcon("images/regions/54mint.png");
		provincemint[55] = new ImageIcon("images/regions/55mint.png");
		provincemint[56] = new ImageIcon("images/regions/56mint.png");
		provincemint[57] = new ImageIcon("images/regions/57mint.png");
		provincemint[58] = new ImageIcon("images/regions/58mint.png");
		provincemint[59] = new ImageIcon("images/regions/59mint.png");
		provincemint[60] = new ImageIcon("images/regions/60mint.png");
		provincemint[61] = new ImageIcon("images/regions/61mint.png");
		provincemint[62] = new ImageIcon("images/regions/62mint.png");
		provincemint[63] = new ImageIcon("images/regions/63mint.png");
		provincemint[64] = new ImageIcon("images/regions/64mint.png");
		provincemint[65] = new ImageIcon("images/regions/65mint.png");
		provincemint[66] = new ImageIcon("images/regions/66mint.png");
		
		//brown
		provincebrown[1] = new ImageIcon("images/regions/01brown.png");
		provincebrown[2] = new ImageIcon("images/regions/02brown.png");
		provincebrown[3] = new ImageIcon("images/regions/03brown.png");
		provincebrown[4] = new ImageIcon("images/regions/04brown.png");
		provincebrown[5] = new ImageIcon("images/regions/05brown.png");
		provincebrown[7] = new ImageIcon("images/regions/07brown.png");
		provincebrown[8] = new ImageIcon("images/regions/08brown.png");
		provincebrown[9] = new ImageIcon("images/regions/09brown.png");
		provincebrown[10] = new ImageIcon("images/regions/10brown.png");
		provincebrown[11] = new ImageIcon("images/regions/11brown.png");
		provincebrown[12] = new ImageIcon("images/regions/12brown.png");
		provincebrown[13] = new ImageIcon("images/regions/13brown.png");
		provincebrown[14] = new ImageIcon("images/regions/14brown.png");
		provincebrown[15] = new ImageIcon("images/regions/15brown.png");
		provincebrown[16] = new ImageIcon("images/regions/16brown.png");
		provincebrown[17] = new ImageIcon("images/regions/17brown.png");
		provincebrown[18] = new ImageIcon("images/regions/18brown.png");
		provincebrown[19] = new ImageIcon("images/regions/19brown.png");
		provincebrown[20] = new ImageIcon("images/regions/20brown.png");
		provincebrown[21] = new ImageIcon("images/regions/21brown.png");
		provincebrown[22] = new ImageIcon("images/regions/22brown.png");
		provincebrown[23] = new ImageIcon("images/regions/23brown.png");
		provincebrown[24] = new ImageIcon("images/regions/24brown.png");
		provincebrown[25] = new ImageIcon("images/regions/25brown.png");
		provincebrown[26] = new ImageIcon("images/regions/26brown.png");
		provincebrown[27] = new ImageIcon("images/regions/27brown.png");
		provincebrown[28] = new ImageIcon("images/regions/28brown.png");
		provincebrown[29] = new ImageIcon("images/regions/29brown.png");
		provincebrown[30] = new ImageIcon("images/regions/30brown.png");
		provincebrown[31] = new ImageIcon("images/regions/31brown.png");
		provincebrown[32] = new ImageIcon("images/regions/32brown.png");
		provincebrown[33] = new ImageIcon("images/regions/33brown.png");
		provincebrown[34] = new ImageIcon("images/regions/34brown.png");
		provincebrown[35] = new ImageIcon("images/regions/35brown.png");
		provincebrown[36] = new ImageIcon("images/regions/36brown.png");
		provincebrown[37] = new ImageIcon("images/regions/37brown.png");
		provincebrown[38] = new ImageIcon("images/regions/38brown.png");
		provincebrown[39] = new ImageIcon("images/regions/39brown.png");
		provincebrown[40] = new ImageIcon("images/regions/40brown.png");
		provincebrown[41] = new ImageIcon("images/regions/41brown.png");
		provincebrown[42] = new ImageIcon("images/regions/42brown.png");
		provincebrown[43] = new ImageIcon("images/regions/43brown.png");
		provincebrown[44] = new ImageIcon("images/regions/44brown.png");
		provincebrown[45] = new ImageIcon("images/regions/45brown.png");
		provincebrown[46] = new ImageIcon("images/regions/46brown.png");
		provincebrown[47] = new ImageIcon("images/regions/47brown.png");
		provincebrown[48] = new ImageIcon("images/regions/48brown.png");
		provincebrown[49] = new ImageIcon("images/regions/49brown.png");
		provincebrown[50] = new ImageIcon("images/regions/50brown.png");
		provincebrown[51] = new ImageIcon("images/regions/51brown.png");
		provincebrown[52] = new ImageIcon("images/regions/52brown.png");
		provincebrown[53] = new ImageIcon("images/regions/53brown.png");
		provincebrown[54] = new ImageIcon("images/regions/54brown.png");
		provincebrown[55] = new ImageIcon("images/regions/55brown.png");
		provincebrown[56] = new ImageIcon("images/regions/56brown.png");
		provincebrown[57] = new ImageIcon("images/regions/57brown.png");
		provincebrown[58] = new ImageIcon("images/regions/58brown.png");
		provincebrown[59] = new ImageIcon("images/regions/59brown.png");
		provincebrown[60] = new ImageIcon("images/regions/60brown.png");
		provincebrown[61] = new ImageIcon("images/regions/61brown.png");
		provincebrown[62] = new ImageIcon("images/regions/62brown.png");
		provincebrown[63] = new ImageIcon("images/regions/63brown.png");
		provincebrown[64] = new ImageIcon("images/regions/64brown.png");
		provincebrown[65] = new ImageIcon("images/regions/65brown.png");
		provincebrown[66] = new ImageIcon("images/regions/66brown.png");
		
		//military
		provincemilitary[1] = new ImageIcon("images/regions/01military.png");
		provincemilitary[2] = new ImageIcon("images/regions/02military.png");
		provincemilitary[3] = new ImageIcon("images/regions/03military.png");
		provincemilitary[4] = new ImageIcon("images/regions/04military.png");
		provincemilitary[5] = new ImageIcon("images/regions/05military.png");
		provincemilitary[7] = new ImageIcon("images/regions/07military.png");
		provincemilitary[8] = new ImageIcon("images/regions/08military.png");
		provincemilitary[9] = new ImageIcon("images/regions/09military.png");
		provincemilitary[10] = new ImageIcon("images/regions/10military.png");
		provincemilitary[11] = new ImageIcon("images/regions/11military.png");
		provincemilitary[12] = new ImageIcon("images/regions/12military.png");
		provincemilitary[13] = new ImageIcon("images/regions/13military.png");
		provincemilitary[14] = new ImageIcon("images/regions/14military.png");
		provincemilitary[15] = new ImageIcon("images/regions/15military.png");
		provincemilitary[16] = new ImageIcon("images/regions/16military.png");
		provincemilitary[17] = new ImageIcon("images/regions/17military.png");
		provincemilitary[18] = new ImageIcon("images/regions/18military.png");
		provincemilitary[19] = new ImageIcon("images/regions/19military.png");
		provincemilitary[20] = new ImageIcon("images/regions/20military.png");
		provincemilitary[21] = new ImageIcon("images/regions/21military.png");
		provincemilitary[22] = new ImageIcon("images/regions/22military.png");
		provincemilitary[23] = new ImageIcon("images/regions/23military.png");
		provincemilitary[24] = new ImageIcon("images/regions/24military.png");
		provincemilitary[25] = new ImageIcon("images/regions/25military.png");
		provincemilitary[26] = new ImageIcon("images/regions/26military.png");
		provincemilitary[27] = new ImageIcon("images/regions/27military.png");
		provincemilitary[28] = new ImageIcon("images/regions/28military.png");
		provincemilitary[29] = new ImageIcon("images/regions/29military.png");
		provincemilitary[30] = new ImageIcon("images/regions/30military.png");
		provincemilitary[31] = new ImageIcon("images/regions/31military.png");
		provincemilitary[32] = new ImageIcon("images/regions/32military.png");
		provincemilitary[33] = new ImageIcon("images/regions/33military.png");
		provincemilitary[34] = new ImageIcon("images/regions/34military.png");
		provincemilitary[35] = new ImageIcon("images/regions/35military.png");
		provincemilitary[36] = new ImageIcon("images/regions/36military.png");
		provincemilitary[37] = new ImageIcon("images/regions/37military.png");
		provincemilitary[38] = new ImageIcon("images/regions/38military.png");
		provincemilitary[39] = new ImageIcon("images/regions/39military.png");
		provincemilitary[40] = new ImageIcon("images/regions/40military.png");
		provincemilitary[41] = new ImageIcon("images/regions/41military.png");
		provincemilitary[42] = new ImageIcon("images/regions/42military.png");
		provincemilitary[43] = new ImageIcon("images/regions/43military.png");
		provincemilitary[44] = new ImageIcon("images/regions/44military.png");
		provincemilitary[45] = new ImageIcon("images/regions/45military.png");
		provincemilitary[46] = new ImageIcon("images/regions/46military.png");
		provincemilitary[47] = new ImageIcon("images/regions/47military.png");
		provincemilitary[48] = new ImageIcon("images/regions/48military.png");
		provincemilitary[49] = new ImageIcon("images/regions/49military.png");
		provincemilitary[50] = new ImageIcon("images/regions/50military.png");
		provincemilitary[51] = new ImageIcon("images/regions/51military.png");
		provincemilitary[52] = new ImageIcon("images/regions/52military.png");
		provincemilitary[53] = new ImageIcon("images/regions/53military.png");
		provincemilitary[54] = new ImageIcon("images/regions/54military.png");
		provincemilitary[55] = new ImageIcon("images/regions/55military.png");
		provincemilitary[56] = new ImageIcon("images/regions/56military.png");
		provincemilitary[57] = new ImageIcon("images/regions/57military.png");
		provincemilitary[58] = new ImageIcon("images/regions/58military.png");
		provincemilitary[59] = new ImageIcon("images/regions/59military.png");
		provincemilitary[60] = new ImageIcon("images/regions/60military.png");
		provincemilitary[61] = new ImageIcon("images/regions/61military.png");
		provincemilitary[62] = new ImageIcon("images/regions/62military.png");
		provincemilitary[63] = new ImageIcon("images/regions/63military.png");
		provincemilitary[64] = new ImageIcon("images/regions/64military.png");
		provincemilitary[65] = new ImageIcon("images/regions/65military.png");
		provincemilitary[66] = new ImageIcon("images/regions/66military.png");
		

		//blue
		provinceblue[1] = new ImageIcon("images/regions/01blue.png");
		provinceblue[2] = new ImageIcon("images/regions/02blue.png");
		provinceblue[3] = new ImageIcon("images/regions/03blue.png");
		provinceblue[4] = new ImageIcon("images/regions/04blue.png");
		provinceblue[5] = new ImageIcon("images/regions/05blue.png");
		provinceblue[7] = new ImageIcon("images/regions/07blue.png");
		provinceblue[8] = new ImageIcon("images/regions/08blue.png");
		provinceblue[9] = new ImageIcon("images/regions/09blue.png");
		provinceblue[10] = new ImageIcon("images/regions/10blue.png");
		provinceblue[11] = new ImageIcon("images/regions/11blue.png");
		provinceblue[12] = new ImageIcon("images/regions/12blue.png");
		provinceblue[13] = new ImageIcon("images/regions/13blue.png");
		provinceblue[14] = new ImageIcon("images/regions/14blue.png");
		provinceblue[15] = new ImageIcon("images/regions/15blue.png");
		provinceblue[16] = new ImageIcon("images/regions/16blue.png");
		provinceblue[17] = new ImageIcon("images/regions/17blue.png");
		provinceblue[18] = new ImageIcon("images/regions/18blue.png");
		provinceblue[19] = new ImageIcon("images/regions/19blue.png");
		provinceblue[20] = new ImageIcon("images/regions/20blue.png");
		provinceblue[21] = new ImageIcon("images/regions/21blue.png");
		provinceblue[22] = new ImageIcon("images/regions/22blue.png");
		provinceblue[23] = new ImageIcon("images/regions/23blue.png");
		provinceblue[24] = new ImageIcon("images/regions/24blue.png");
		provinceblue[25] = new ImageIcon("images/regions/25blue.png");
		provinceblue[26] = new ImageIcon("images/regions/26blue.png");
		provinceblue[27] = new ImageIcon("images/regions/27blue.png");
		provinceblue[28] = new ImageIcon("images/regions/28blue.png");
		provinceblue[29] = new ImageIcon("images/regions/29blue.png");
		provinceblue[30] = new ImageIcon("images/regions/30blue.png");
		provinceblue[31] = new ImageIcon("images/regions/31blue.png");
		provinceblue[32] = new ImageIcon("images/regions/32blue.png");
		provinceblue[33] = new ImageIcon("images/regions/33blue.png");
		provinceblue[34] = new ImageIcon("images/regions/34blue.png");
		provinceblue[35] = new ImageIcon("images/regions/35blue.png");
		provinceblue[36] = new ImageIcon("images/regions/36blue.png");
		provinceblue[37] = new ImageIcon("images/regions/37blue.png");
		provinceblue[38] = new ImageIcon("images/regions/38blue.png");
		provinceblue[39] = new ImageIcon("images/regions/39blue.png");
		provinceblue[40] = new ImageIcon("images/regions/40blue.png");
		provinceblue[41] = new ImageIcon("images/regions/41blue.png");
		provinceblue[42] = new ImageIcon("images/regions/42blue.png");
		provinceblue[43] = new ImageIcon("images/regions/43blue.png");
		provinceblue[44] = new ImageIcon("images/regions/44blue.png");
		provinceblue[45] = new ImageIcon("images/regions/45blue.png");
		provinceblue[46] = new ImageIcon("images/regions/46blue.png");
		provinceblue[47] = new ImageIcon("images/regions/47blue.png");
		provinceblue[48] = new ImageIcon("images/regions/48blue.png");
		provinceblue[49] = new ImageIcon("images/regions/49blue.png");
		provinceblue[50] = new ImageIcon("images/regions/50blue.png");
		provinceblue[51] = new ImageIcon("images/regions/51blue.png");
		provinceblue[52] = new ImageIcon("images/regions/52blue.png");
		provinceblue[53] = new ImageIcon("images/regions/53blue.png");
		provinceblue[54] = new ImageIcon("images/regions/54blue.png");
		provinceblue[55] = new ImageIcon("images/regions/55blue.png");
		provinceblue[56] = new ImageIcon("images/regions/56blue.png");
		provinceblue[57] = new ImageIcon("images/regions/57blue.png");
		provinceblue[58] = new ImageIcon("images/regions/58blue.png");
		provinceblue[59] = new ImageIcon("images/regions/59blue.png");
		provinceblue[60] = new ImageIcon("images/regions/60blue.png");
		provinceblue[61] = new ImageIcon("images/regions/61blue.png");
		provinceblue[62] = new ImageIcon("images/regions/62blue.png");
		provinceblue[63] = new ImageIcon("images/regions/63blue.png");
		provinceblue[64] = new ImageIcon("images/regions/64blue.png");
		provinceblue[65] = new ImageIcon("images/regions/65blue.png");
		provinceblue[66] = new ImageIcon("images/regions/66blue.png");
		
		//orange
		provinceorange[1] = new ImageIcon("images/regions/01orange.png");
		provinceorange[2] = new ImageIcon("images/regions/02orange.png");
		provinceorange[3] = new ImageIcon("images/regions/03orange.png");
		provinceorange[4] = new ImageIcon("images/regions/04orange.png");
		provinceorange[5] = new ImageIcon("images/regions/05orange.png");
		provinceorange[7] = new ImageIcon("images/regions/07orange.png");
		provinceorange[8] = new ImageIcon("images/regions/08orange.png");
		provinceorange[9] = new ImageIcon("images/regions/09orange.png");
		provinceorange[10] = new ImageIcon("images/regions/10orange.png");
		provinceorange[11] = new ImageIcon("images/regions/11orange.png");
		provinceorange[12] = new ImageIcon("images/regions/12orange.png");
		provinceorange[13] = new ImageIcon("images/regions/13orange.png");
		provinceorange[14] = new ImageIcon("images/regions/14orange.png");
		provinceorange[15] = new ImageIcon("images/regions/15orange.png");
		provinceorange[16] = new ImageIcon("images/regions/16orange.png");
		provinceorange[17] = new ImageIcon("images/regions/17orange.png");
		provinceorange[18] = new ImageIcon("images/regions/18orange.png");
		provinceorange[19] = new ImageIcon("images/regions/19orange.png");
		provinceorange[20] = new ImageIcon("images/regions/20orange.png");
		provinceorange[21] = new ImageIcon("images/regions/21orange.png");
		provinceorange[22] = new ImageIcon("images/regions/22orange.png");
		provinceorange[23] = new ImageIcon("images/regions/23orange.png");
		provinceorange[24] = new ImageIcon("images/regions/24orange.png");
		provinceorange[25] = new ImageIcon("images/regions/25orange.png");
		provinceorange[26] = new ImageIcon("images/regions/26orange.png");
		provinceorange[27] = new ImageIcon("images/regions/27orange.png");
		provinceorange[28] = new ImageIcon("images/regions/28orange.png");
		provinceorange[29] = new ImageIcon("images/regions/29orange.png");
		provinceorange[30] = new ImageIcon("images/regions/30orange.png");
		provinceorange[31] = new ImageIcon("images/regions/31orange.png");
		provinceorange[32] = new ImageIcon("images/regions/32orange.png");
		provinceorange[33] = new ImageIcon("images/regions/33orange.png");
		provinceorange[34] = new ImageIcon("images/regions/34orange.png");
		provinceorange[35] = new ImageIcon("images/regions/35orange.png");
		provinceorange[36] = new ImageIcon("images/regions/36orange.png");
		provinceorange[37] = new ImageIcon("images/regions/37orange.png");
		provinceorange[38] = new ImageIcon("images/regions/38orange.png");
		provinceorange[39] = new ImageIcon("images/regions/39orange.png");
		provinceorange[40] = new ImageIcon("images/regions/40orange.png");
		provinceorange[41] = new ImageIcon("images/regions/41orange.png");
		provinceorange[42] = new ImageIcon("images/regions/42orange.png");
		provinceorange[43] = new ImageIcon("images/regions/43orange.png");
		provinceorange[44] = new ImageIcon("images/regions/44orange.png");
		provinceorange[45] = new ImageIcon("images/regions/45orange.png");
		provinceorange[46] = new ImageIcon("images/regions/46orange.png");
		provinceorange[47] = new ImageIcon("images/regions/47orange.png");
		provinceorange[48] = new ImageIcon("images/regions/48orange.png");
		provinceorange[49] = new ImageIcon("images/regions/49orange.png");
		provinceorange[50] = new ImageIcon("images/regions/50orange.png");
		provinceorange[51] = new ImageIcon("images/regions/51orange.png");
		provinceorange[52] = new ImageIcon("images/regions/52orange.png");
		provinceorange[53] = new ImageIcon("images/regions/53orange.png");
		provinceorange[54] = new ImageIcon("images/regions/54orange.png");
		provinceorange[55] = new ImageIcon("images/regions/55orange.png");
		provinceorange[56] = new ImageIcon("images/regions/56orange.png");
		provinceorange[57] = new ImageIcon("images/regions/57orange.png");
		provinceorange[58] = new ImageIcon("images/regions/58orange.png");
		provinceorange[59] = new ImageIcon("images/regions/59orange.png");
		provinceorange[60] = new ImageIcon("images/regions/60orange.png");
		provinceorange[61] = new ImageIcon("images/regions/61orange.png");
		provinceorange[62] = new ImageIcon("images/regions/62orange.png");
		provinceorange[63] = new ImageIcon("images/regions/63orange.png");
		provinceorange[64] = new ImageIcon("images/regions/64orange.png");
		provinceorange[65] = new ImageIcon("images/regions/65orange.png");
		provinceorange[66] = new ImageIcon("images/regions/66orange.png");
				
		
		cardLayout = cl;
		mainPanel=mP;
		
		nameLabel = new JLabel(game.getName());
		add(nameLabel);
		nameLabel.setBounds(10, 2, 150, 40);
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		nameLabel.setForeground(Color.WHITE);
		
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
		for(int i=1; i<67; i++){
			if(i!=6){
				provinceImage[i].setIcon(provincegrey[i]);
			}
		}
		
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
			if(i!=6){
				provinceActionButton[i].setVisible(false);
				provinceActionButton[i].addActionListener(new ProvinceActionListener());
			}
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
	
	private class ProvinceActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			for(int i=1; i<67; i++){
				if(i!=6){
					if(e.getSource()==provinceActionButton[i]){
						attackSoldierPanel.setToId(i);
						attackTo = i;
					}
				}
			}
		}
	}
	
	public void showColor(int prov, ArrayList<Integer> provList){
		provList.add(prov);
		toGreyBackProv=provList;
		for(int i=0; i<provList.size(); i++){
			int id = provList.get(i);
			if(game.isProvinceEmpty(id)){
				provinceImage[id].setIcon(provinceorange[id]);
			}
			else{
				String faction = game.getProvinceFaction(id);
				if(faction == "mordor"){
					provinceImage[id].setIcon(provincemilitary[id]);
				}
				else if(faction == "gondor"){
					provinceImage[id].setIcon(provincemint[id]);
				}
				else if(faction == "rohan"){
					provinceImage[id].setIcon(provinceblue[id]);
				}
				else if(faction == "elves"){
					provinceImage[id].setIcon(provincegreen[id]);
				}
				else if(faction == "dwarves"){
					provinceImage[id].setIcon(provinceyellow[id]);
				}
				else if(faction == "harad"){
					provinceImage[id].setIcon(provincepink[id]);
				}
				else if(faction == "isengard"){
					provinceImage[id].setIcon(provincebrown[id]);
				}
			}
		}
	}
	
	public void makeGrey(ArrayList<Integer> provList){
		for(int i=0; i<provList.size(); i++){
			int id= provList.get(i);
			provinceImage[id].setIcon(provincegrey[id]);
		}
	}
	
	public void setVisibleRedBoxes(ArrayList<Integer> provList){
		for(int i=0; i<provList.size(); i++){
			provinceActionButton[provList.get(i)].setVisible(true);
		}
	}
	
	public void setNotVisibleRedBoxes(ArrayList<Integer> provList){
		for(int i=0; i<provList.size(); i++){
			provinceActionButton[provList.get(i)].setVisible(false);
		}
	}
	
	public int getSelectedRedBoxId(){
		return attackTo;
	}
	
	public void setAttackMapStarter(){
		attackTo = -1;
		makeGrey(toGreyBackProv);
		toGreyBackProv.remove(toGreyBackProv.size()-1);
		setNotVisibleRedBoxes(toGreyBackProv);
	}
	
	public void setName(){
		nameLabel.setText(game.getName());			//set the name
	}
	
	public void setAttackFrom(int i){
		attackFrom=i;
	}
	
	public void changeColors(ArrayList<Integer> provList){
		for(int i=0; i<provList.size(); i++){
			String faction = game.getProvinceFaction(provList.get(i));
			if(faction=="mordor"){
				provinceImage[provList.get(i)].setIcon(provincemilitary[i]);
			}
			else if(faction=="gondor"){
				provinceImage[provList.get(i)].setIcon(provincemint[i]);
			}
			else if(faction=="rohan"){
				provinceImage[provList.get(i)].setIcon(provinceblue[i]);
			}
			else if(faction=="elves"){
				provinceImage[provList.get(i)].setIcon(provincegreen[i]);
			}
			else if(faction=="dwarves"){
				provinceImage[provList.get(i)].setIcon(provinceyellow[i]);
			}
			else if(faction=="harad"){
				provinceImage[provList.get(i)].setIcon(provincepink[i]);
			}
			else if(faction=="isengard"){
				provinceImage[provList.get(i)].setIcon(provincebrown[i]);
			}
		}
	}
}


	
