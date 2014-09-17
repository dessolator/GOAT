package game.dev.gui;



import game.dev.engine.DrawObject;
import game.dev.engine.GameState;
import game.dev.gui.menu.misc.frame.Frame;
import game.dev.gui.misc.buttons.Button;
import game.dev.interfaces.Updatable;
import game.dev.mechanics.Game;
import static game.dev.engine.LoadTex.managementFrame;


public class MenuFrame extends Frame implements Updatable {
	private Button menuButton;
	
	public MenuFrame(float coordX, float coordY, float dimX, float dimY) {
		super(coordX, coordY, dimX, dimY);
		menuButton = new MenuButton (coordX,
				coordY,
				"Menu");
		frame = managementFrame;
		
		// TODO Auto-generated constructor stub
	}
	
	public void render() {
		DrawObject.draw(this);
		menuButton.render();
	}
	

	@Override
	public float getTexX1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getTexX2() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public float getTexY1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getTexY2() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public float getAngle() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void pressed() {
		Game.setCurrentGameState(GameState.PauseMenu);
	}

	@Override
	public void update() {
		menuButton.update();
		
	}

}
