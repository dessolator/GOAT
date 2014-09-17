package game.dev.gui;

import static game.dev.engine.LoadTex.cross;
import game.dev.mechanics.*;
import org.newdawn.slick.opengl.Texture;

import game.dev.gui.misc.buttons.Button;

public class CreateCross extends Button {

	public CreateCross(float coordX, float coordY, String myText) {
		super(coordX, coordY, myText);
		// TODO Auto-generated constructor stub
	}
	public Texture getTexture(){
		return cross.getMyTexture();
	}
	public float getDimX() {
		return 64;
	}
	
	public float getDimY() {
		return 64;
	}
	
	public void pressed() {
		super.pressed();
		Game.createCross();
	}

}
