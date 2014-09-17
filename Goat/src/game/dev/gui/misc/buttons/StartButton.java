package game.dev.gui.misc.buttons;

import game.dev.engine.GameState;
import game.dev.mechanics.Game;

public class StartButton extends Button {

	public StartButton(float coordX, float coordY, String myText) {
		super(coordX, coordY, myText);

	}
	
	public void pressed () {
		super.pressed();
		Game.setCurrentGameState(GameState.Game);
	}

}
