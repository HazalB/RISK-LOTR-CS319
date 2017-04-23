/**
 * Created by Elena Cina
 * 22 April 2017
 */

public class MainGameManager extends Manager {
	private PersistentDataManager persistentDataManager;
	private DeploymentDataManager deploymentDataManager; 
	private MobilityPhaseManager mobilityPhaseManager; 
	private ExecutionPhaseManager executionPhaseManager; 
	private SoundManager soundManager; 
	public MainGameManager() {
	        super(null);
	    }
	Game game = new Game ();
	
	public void endPhase(){
		if (game.getCurPhase==1)//means that will end deployment phase
			
		if (game.getCurPhase==2)//means that will end mobility phase
			
		if (game.getCurPhase==3)//execution phase
	}
	public void endTurn(){
		game.getTurnNo = game.getTurnNo-1;
		
	}
	public void firstTurn(){
		
	}
	public void initializeGame(){
		
		persistentDataManager = new PersistentDataManager(game);
		deploymentDataManager = new DeploymentDataManager(game);
		mobilityPhaseManager = new MobilityPhaseManager(game);
		executionPhaseManager = new ExecutionPhaseManager(game);
		soundManager = new SoundManager(game);
	}
	public void getPermanentGameData(){
		int income = deploymentDataManager.calculateIncom();
		vector<vector<string>> unitInfo = persistentDataManager.getArmyUnitInfo();
		vector<vector<string>> factionInfo = persistentDataManager.getFactionInfo();
		vector <string> provinceInfo = persistentDataManager.getProvinceInfo();
		vector<vector<string>> areaInfo	= persistentDataManager.getAreaInfo();
		
	}
	
	public void resetGame(){
		
		
	}
	
	public void playSound(){
		soundManager.playBSound();
		
	}
	
	public void updateScreen(){
		//there should be a sreenManager 
	}

}
