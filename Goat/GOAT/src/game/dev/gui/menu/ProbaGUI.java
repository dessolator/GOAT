package game.dev.gui.menu;

import static game.dev.engine.LoadTex.mainMenu;
import game.dev.engine.DrawObject;
import game.dev.gui.*;
public class ProbaGUI extends Menu {

	private GameUserInterface gui;
	public ProbaGUI() {
		// TODO Auto-generated constructor stub
		background = mainMenu;
		gui = new GameUserInterface();
	}
	
	public void render() {
		DrawObject.draw(this);
		gui.render();
	}
	public void update(){
		gui.update();
	}

}
