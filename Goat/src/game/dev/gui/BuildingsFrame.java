package game.dev.gui;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;

import game.dev.engine.DrawObject;
import game.dev.gui.misc.buttons.*;
import game.dev.gui.menu.misc.frame.Frame;
import static game.dev.engine.LoadTex.*;

public class BuildingsFrame extends Frame {
	
	private static float width = Display.getWidth()/30;
	private static float height = Display.getHeight()/15;
	private ArrayList<Button> buttons;
	
	
	public BuildingsFrame(float coordX, float coordY, float dimX, float dimY) {
		super(coordX, coordY, dimX, dimY);
		buttons = new ArrayList<Button>();
		frame = notificationFrame;
		buttons.add(new CreateGranary(width,height,""));
		buttons.add(new CreateCollege(width+80,height,""));
		buttons.add(new CreateMarketplace(width+160,height,""));
		buttons.add(new CreateStables(width+240,height,""));
		buttons.add(new CreateWell(width+320,height,""));
		buttons.add(new CreateCross(width+=400,height,""));
		 
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() {
		DrawObject.draw(this);
		for(Button b: buttons) {
			if(b!=null) {
				b.render();
			}
		}
	}
	
	
	public void update() {
		for(Button b: buttons) {
			if(b!=null) {
				b.update();
			}
		}
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

}
