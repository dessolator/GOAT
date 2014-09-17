package game.dev.gui.misc.buttons;

import game.dev.mechanics.Game;

public class ExitButton extends Button {

	public ExitButton(float coordX, float coordY, String myText) {
		super(coordX, coordY, myText);
		// TODO Auto-generated constructor stub
	}

	public void pressed() {
		super.pressed();
		Game.setTerminate(true);
	}
}
