package game.dev.gui;



import game.dev.engine.DrawObject;
import game.dev.gui.misc.buttons.*;
import game.dev.gui.menu.misc.frame.Frame;
import game.dev.interfaces.Updatable;
import static game.dev.engine.LoadTex.managementFrame;


public class ManagementFrame extends Frame implements Updatable {
	private Button endTurn;
//	private TimesNewRomanText text;
	
	public ManagementFrame(float coordX, float coordY, float dimX, float dimY) {
		super(coordX, coordY, dimX, dimY);
		frame = managementFrame;
		endTurn = new EndTurnButton(coordX,
				coordY,
				"End Turn");
		// TODO Auto-generated constructor stub
	}

	public void render() {
		DrawObject.draw(this);
		endTurn.render();
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

	@Override
	public void update() {
		endTurn.update();
		
	}

}
