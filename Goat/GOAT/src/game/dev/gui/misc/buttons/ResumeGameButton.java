package game.dev.gui.misc.buttons;

import game.dev.mechanics.Game;

public class ResumeGameButton extends Button {

	public ResumeGameButton(float coordX, float coordY, String myText) {
		super(coordX, coordY, myText);
		// TODO Auto-generated constructor stub
	}

	public void pressed() {
		super.pressed();
		Game.goBack();
	}
}
