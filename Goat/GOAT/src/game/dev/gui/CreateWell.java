package game.dev.gui;

import static game.dev.engine.LoadTex.well;
import game.dev.mechanics.*;
import org.newdawn.slick.opengl.Texture;

import game.dev.gui.misc.buttons.Button;

public class CreateWell extends Button {

	public CreateWell(float coordX, float coordY, String myText) {
		super(coordX, coordY, myText);
		// TODO Auto-generated constructor stub
	}
	public Texture getTexture(){
		return well.getMyTexture();
	}
	public float getDimX() {
		return 64;
	}
	
	public float getDimY() {
		return 64;
	}
	
	public void pressed() {
		super.pressed();
		Game.createWell();
	}

}
