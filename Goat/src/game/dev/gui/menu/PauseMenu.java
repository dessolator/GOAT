package game.dev.gui.menu;

import static game.dev.engine.LoadTex.mainMenu;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import game.dev.engine.DrawObject;
import game.dev.gui.menu.misc.frame.BasicFrame;
import game.dev.gui.misc.buttons.Button;
import game.dev.gui.misc.buttons.ExitButton;
import game.dev.gui.misc.buttons.MainMenuButton;
import game.dev.gui.misc.buttons.ResumeGameButton;
import game.dev.gui.misc.buttons.StartButton;
import game.dev.mechanics.Game;
import game.dev.mechanics.Level;
import static game.dev.engine.LoadTex.pauseMenu;

public class PauseMenu extends Menu {
	
    public PauseMenu(){
    	float currentPosition = Display.getHeight()/2;
		myButtons=new ArrayList<Button>();
		background = pauseMenu;
		myFrame = new BasicFrame(Display.getWidth()/2,currentPosition,Display.getWidth()/3,Display.getHeight()/2);
		myButtons.add(new ResumeGameButton(Display.getWidth()/2,currentPosition+80,"Resume Game"));
		myButtons.add(new MainMenuButton(Display.getWidth()/2,currentPosition,"Main Menu"));	
		myButtons.add(new ExitButton(Display.getWidth()/2, currentPosition-80,"ExitGame"));
	}
    
    public void render(){    	
    	 Game.getMyLevel().render();
         DrawObject.drawRect(640f, 360f, 1280f, 720f, 1f, 1f, 0.87f, 0.5f);
         if(Mouse.isGrabbed())Mouse.setGrabbed(false);
         myFrame.render();
         for (Button b:myButtons)
                 b.render();
    		}
  }

