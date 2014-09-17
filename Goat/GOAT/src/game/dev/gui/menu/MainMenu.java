package game.dev.gui.menu;


import java.util.ArrayList;

// import static dev.game.engine.LoadTex.mainMenuBackground; // srediti kasnije :)


import org.lwjgl.opengl.Display;

import game.dev.gui.misc.buttons.*;
import game.dev.gui.menu.misc.frame.*;

import static game.dev.engine.LoadTex.*;

// dodati kasnije 


public class MainMenu extends Menu {
	public MainMenu(){
		float currentPosition = Display.getHeight()/2;
		myButtons=new ArrayList<Button>();
		background = mainMenu;
		myFrame = new BasicFrame(Display.getWidth()/2,Display.getHeight()/2,Display.getWidth()/3,Display.getHeight()/3);
		myButtons.add(new StartButton(Display.getWidth()/2,currentPosition+40,"Start Game"));
		myButtons.add(new ExitButton(Display.getWidth()/2,currentPosition-40,"Exit"));
		
	}

	@Override
	public float getAngle() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
