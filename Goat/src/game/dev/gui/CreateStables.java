package game.dev.gui;

import static game.dev.engine.LoadTex.stables;
import game.dev.mechanics.*;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import game.dev.gui.misc.buttons.Button;

public class CreateStables extends Button {

	public CreateStables(float coordX, float coordY, String myText) {
		super(coordX, coordY, myText);
		// TODO Auto-generated constructor stub
	}
	
	public Texture getTexture(){
		return stables.getMyTexture();
	}
	public float getDimX() {
		return 64;
	}
	
	public float getDimY() {
		return 64;
	}
	
	public void pressed() {
		super.pressed();
		Game.createStable();
	}

}
