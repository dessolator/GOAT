package game.dev.gui;

import org.lwjgl.opengl.Display;

import game.dev.gui.misc.buttons.Button;
import game.dev.mechanics.Game;

public class EndTurnButton extends Button {

	public EndTurnButton(float coordX, float coordY, String myText) {
		super(coordX, coordY, myText);
		// TODO Auto-generated constructor stub
	}

	public void pressed() {
		Game.endTurn();
		Game.getMyLevel().getGui().getNotificationFrame().getNotes().clear();
		
	}
	
	public float getDimX() {
		return Display.getWidth()/10;
	}
	
	public float getDimY() {
		return Display.getHeight()/15;
	}
}
