package game.dev.mechanics;



import java.util.ArrayList;

import game.dev.engine.GameState;
import game.dev.gui.menu.MainMenu;
import game.dev.gui.menu.PauseMenu;
import game.dev.gui.menu.ProbaGUI;
import game.dev.interfaces.Drawable;
import game.dev.interfaces.Updatable;
import game.dev.mechanics.blocks.Block;
import game.dev.mechanics.requests.ChurchRequest;
import game.dev.mechanics.requests.GranaryRequest;
import game.dev.mechanics.requests.MarketPlaceRequest;
import game.dev.mechanics.requests.Request;
import game.dev.mechanics.requests.StablesRequest;
import game.dev.mechanics.requests.WellRequest;

import org.lwjgl.opengl.Display;








import static org.lwjgl.opengl.GL11.*;



public class Game {
	
	public static void resetLevel(){
		myLvl=null;
	}
	private static MainMenu myMainMenu;//my main menu	

	

	private static ProbaGUI probagui;

	//private static PauseMenu myPauseMenu; 


	private static PauseMenu myPauseMenu;
	//private static PauseMenu myPauseMenu; 

	private static boolean terminate=false;        //window kill flag




	private static GameState currentGameState=GameState.MainMenu;//current game state



	private static Level myLvl;//myLevel
	
	private static boolean firstTimeGame=true;
	
	//all the magic happens here!
	public static void startGame(){
		while(!Display.isCloseRequested() && !terminate){
			glClear(GL_COLOR_BUFFER_BIT);
			getCurrentUpdate().update();
			getCurrentDraw().render();
			Display.update();
			
		}
		
	}
	
    
    //get current gemeState ...         
    private static Updatable getCurrentUpdate() {
            switch(currentGameState){
		            case ProbaGUI:
		            	return probagui;
                    case MainMenu:
                            return myMainMenu;
                    case Game:
                            return myLvl;
                    case PauseMenu:
                            return myPauseMenu;                 
                    case GameOver:
                            return myMainMenu ;
                    case SplashScreen:
                            return null;
                    default:
                            return null;
            }
    }
    
    //return to previous game state
    public static void goBack(){
            switch(currentGameState){
                    case MainMenu:
                            currentGameState= GameState.MainMenu;
                            setTerminate(true);
                            break;
                    case Game:
                            currentGameState= GameState.Game;
                            break; 
                    case PauseMenu: 
                    		currentGameState= GameState.Game;
                    		break;
                    case SplashScreen:
                            currentGameState= GameState.SplashScreen;
                            break;
                    default:
                            currentGameState= GameState.MainMenu;
                            break;
            	}
    }

    private static Drawable getCurrentDraw() {
            switch(currentGameState){
            case ProbaGUI:
            		return probagui;
            case MainMenu:
                    return myMainMenu;
            case Game:
                    return myLvl; 
            case PauseMenu:
            		return myPauseMenu;            
            case SplashScreen:
                    return null;            
            default:
                    return null;
            }
    }
    
    public static void setTerminate(boolean b) {
            terminate = true;
    }
    
    public static boolean isTerminate() {
            return terminate;
    }

    public static GameState getCurrentGameState() {
            return currentGameState;
    }

    public static void setCurrentGameState(GameState currentGameState) {           
            Game.currentGameState = currentGameState;
    } 
    
    public static Level getMyLevel(){
            return myLvl;
    }
    
    public static void initGame() {
    //                        myLvl=new Level();
                           
       // tex=new TextureHolder(loading1,new Tex(0f,0f,0f,0f));
       // ls.render();
        myMainMenu = new MainMenu();
        myPauseMenu = new PauseMenu();
        probagui = new ProbaGUI();
        myLvl = new Level();
       // ls.render();
     
        //ls.render();
      

       // ls.render();
    

       // ls.render();
       
        //ls.render();
        //mySettingsMenu=new SettingsMenu();
//                            myLvl = new Level();
                            //ls.render();
            
//            System.out.println("moo");
    }


	public static boolean removeBlock(Block b) {
		return myLvl.removeBlock(b);
		
	}


	
	

	public static void endTurn() {
		myLvl.endOfTurn=true;
		
		
	}


	public static void createCollege() {
		System.exit(0);
		Game.currentGameState=GameState.Victory;
		
	}


	public static  void createCross() {
		ArrayList<Request> temp=myLvl.getMyCity().getBuildingsICanBuild();
		for(int i=0;i<temp.size();i++){
			if(temp.get(i) instanceof ChurchRequest)
				myLvl.getMyCity().addToQueue(temp.get(i));
		}
	}


	public static void createGranary() { 
		ArrayList<Request> temp=myLvl.getMyCity().getBuildingsICanBuild();
		for(int i=0;i<temp.size();i++){
			if(temp.get(i) instanceof GranaryRequest)
				myLvl.getMyCity().addToQueue(temp.get(i));
		}
		
	}


	public static void createMarket() {
		ArrayList<Request> temp=myLvl.getMyCity().getBuildingsICanBuild();
		for(int i=0;i<temp.size();i++){
			if(temp.get(i) instanceof MarketPlaceRequest)
				myLvl.getMyCity().addToQueue(temp.get(i));
		}
		
	}


	public static void createStable() {
		ArrayList<Request> temp=myLvl.getMyCity().getBuildingsICanBuild();
		for(int i=0;i<temp.size();i++){
			if(temp.get(i) instanceof StablesRequest)
				myLvl.getMyCity().addToQueue(temp.get(i));
		}
		
	}


	public static void createWell() {
		ArrayList<Request> temp=myLvl.getMyCity().getBuildingsICanBuild();
		for(int i=0;i<temp.size();i++){
			if(temp.get(i) instanceof WellRequest)
				myLvl.getMyCity().addToQueue(temp.get(i));
		}
		
	}
}



