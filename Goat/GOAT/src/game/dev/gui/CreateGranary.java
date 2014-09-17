package game.dev.gui;

import static game.dev.engine.LoadTex.granary;
import game.dev.mechanics.*;
import org.newdawn.slick.opengl.Texture;

import game.dev.gui.misc.buttons.Button;

public class CreateGranary extends Button {

	public CreateGranary(float coordX, float coordY, String myText) {
		super(coordX, coordY, myText);
		// TODO Auto-generated constructor stub
	}
	
	public Texture getTexture(){
		return granary.getMyTexture();
	}
	public float getDimX() {
		return 64;
	}
	
	public float getDimY() {
		return 64;
	}
	
	public void presed() {
		super.pressed();
		Game.createGranary();
	}

}
