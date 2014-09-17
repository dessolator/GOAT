package game.dev.gui;

import org.lwjgl.opengl.Display;

import game.dev.engine.GameState;
import game.dev.gui.misc.buttons.Button;
import game.dev.mechanics.Game;

public class MenuButton extends Button {

	public MenuButton(float coordX, float coordY, String myText) {
		super(coordX, coordY, myText);
		// TODO Auto-generated constructor stub
	}
	
	public float getDimX() {
		return Display.getWidth()/10;
	}
	
	public float getDimY() {
		return Display.getHeight()/15;
	}
	
	public void pressed() {
		super.pressed();
		Game.setCurrentGameState(GameState.PauseMenu);
	}

}
