package game.dev.mechanics.units;


import game.dev.engine.DrawObject;
import game.dev.interfaces.Createable;
import game.dev.interfaces.Drawable;
import game.dev.interfaces.Updatable;
import game.dev.mechanics.blocks.Block;
import game.dev.mechanics.city.City;

public abstract class Unit implements Createable,Updatable,Drawable {
	boolean active=false;
	City myCity;
	Block myBlock;
	float myCoordX;
	float myCoordY;
	
	
	
	public Unit(){}

	

	
	@Override
	public void create(City city) {
		city.addUnit(this);
		myBlock=city.getBlockUnder();//TESTED
		if (myBlock==null)
			myBlock=city.getBlockAbove();//TESTED
    	myCoordX=myBlock.getX();
    	myCoordY=myBlock.getY();
		myCity=city;
	}
	
	@Override
	public void render() {
		DrawObject.draw(this);
	}
	@Override
	public float getX() {
		return myCoordX;
	}
	@Override
	public float getY() {
		return myCoordY;
	}
	@Override
	public float getDimX() {
		return 80;
	}
	@Override
	public float getDimY() {
		return 80;
	}
	@Override
	public float getTexX1() {
		return 0;
	}
	@Override
	public float getTexX2() {
		return 1;
	}
	@Override
	public float getTexY1() {
		return 0;
	}
	@Override
	public float getTexY2() {
		return 1;
	}
	@Override
	public float getAngle() {
		return 0;
	}

	
}
