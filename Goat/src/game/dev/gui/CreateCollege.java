package game.dev.gui;

import game.dev.mechanics.*;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import static game.dev.engine.LoadTex.*;
import game.dev.gui.misc.buttons.Button;

public class CreateCollege extends Button {

	public CreateCollege(float coordX, float coordY, String myText) {
		super(coordX, coordY, myText);
		// TODO Auto-generated constructor stub
	}
	public Texture getTexture(){
		return college.getMyTexture();
	}

	public float getDimX() {
		return 64;
	}
	
	public float getDimY() {
		return 64;
	}
	
	public void pressed(){
		super.pressed();
	//	Game.createCollege();
	}
}
