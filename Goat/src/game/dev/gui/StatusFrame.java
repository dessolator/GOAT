package game.dev.gui;

import org.lwjgl.opengl.Display;

import game.dev.engine.DrawObject;
import game.dev.gui.menu.misc.frame.Frame;
import game.dev.gui.menu.misc.text.ResizableTimesNewRoman;
import static game.dev.engine.LoadTex.statusFrame;


public class StatusFrame extends Frame {
	public ResizableTimesNewRoman food;
	public ResizableTimesNewRoman wood;
	public ResizableTimesNewRoman stone;
	public ResizableTimesNewRoman gold;
	public ResizableTimesNewRoman happiness;
	public ResizableTimesNewRoman population;
	public ResizableTimesNewRoman taxrate;
	
	
	

	private static float width = Display.getWidth();
	
	public StatusFrame(float coordX, float coordY, float dimX, float dimY) {
		super(coordX, coordY, dimX, dimY);
		frame = statusFrame;
		
		food = new ResizableTimesNewRoman(width/20,coordY,"Food: ",12);
		wood = new ResizableTimesNewRoman(3*width/20,coordY,"Wood: ", 12);
		stone = new ResizableTimesNewRoman(5*width/20,coordY,"Stone: ", 12);
		gold = new ResizableTimesNewRoman(7*width/20,coordY,"Gold: ",12);
		happiness = new ResizableTimesNewRoman(15*width/20, coordY, "Happiness: ", 12);
		population = new ResizableTimesNewRoman(17*width/20,coordY, "Population: ", 12);
		taxrate = new ResizableTimesNewRoman(19*width/20,coordY, "Taxrate: ", 12);
		
		
		// TODO Auto-generated constructor stub
	}


	
	public void updateFood(int broj) {
		food.setMyString("Food: "+ broj);
	}
	
	public void updateWood(int broj) {
		wood.setMyString("Wood: " + broj);
	}
	
	public void updateStone(int broj) {
		stone.setMyString("Stone: " + broj);
	}
	
	public void updateGold(int broj) { 
		gold.setMyString("Gold: " + broj);
	}
	
	public void updateHappiness(int broj) {
		happiness.setMyString("Happiness: " + broj);
	}
	
	public void updatePopulation(int broj) {
		population.setMyString("Population: " + broj);
	}
	
	public void updateTaxrate(float broj) {
		taxrate.setMyString("Taxrate: " + broj);
	}
	
	@Override
	public void render() {
		DrawObject.draw(this);
		food.render();
		wood.render();
		stone.render();
		gold.render();
		happiness.render();
		population.render();
		taxrate.render();
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
