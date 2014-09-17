package game.dev.levelBuilder;



import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL11.*;



public class LevelBuilder {
	
	static boolean terminate=false;        //window kill flag
	private static LevelBuilderLevel myLvl;//myLevel

	
	//all the magic happens here!
	public static void startGame(){
			Mouse.setGrabbed(false);
		while(!Display.isCloseRequested() && !terminate){
			glClear(GL_COLOR_BUFFER_BIT);
			myLvl.update();
			myLvl.render();
			Display.update();
			Display.sync(60);
		}
		
	}
	
    
 
    public static void initGame() {
        myLvl = new LevelBuilderLevel();
    }

}



