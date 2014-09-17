package game.dev.gui.misc.buttons;

import game.dev.engine.GameState;
import game.dev.mechanics.Game;

public class MainMenuButton extends Button {

	public MainMenuButton(float coordX, float coordY, String myText) {
		super(coordX, coordY, myText);
		// TODO Auto-generated constructor stub
	}
	public void pressed() {
		super.pressed();
		Game.setCurrentGameState(GameState.MainMenu);
		
	}

}
