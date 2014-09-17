package game.dev.mechanics.building;

import game.dev.interfaces.Createable;
import game.dev.interfaces.Updatable;
import game.dev.mechanics.Game;
import game.dev.mechanics.city.City;

public abstract  class Building implements Createable, Updatable {
	private int sellGold;
	private int sellStone;
	private int sellWood;
	private int sellFood;
	private boolean sellable;
	protected City myCity;	
	private final int typeId;
	
	
	public Building(int sellGold, int sellStone, int sellWood, int sellFood, boolean sellable, int type){
		this.sellGold=sellGold;
		this.sellStone=sellStone;
		this.sellWood=sellWood;
		this.sellable=sellable;
		this.typeId=type;
		this.myCity=Game.getMyLevel().getMyCity();
	}
	
	public abstract void applyEffect();
	public abstract void removeEffect();
	
	public int getSellGold(){return sellGold;}
	public int getSellStone(){return sellStone;}
	public int getSellWood(){return sellWood;}
	public int getSellFood(){ return sellFood;}
	public int getType(){return typeId;}
	public boolean isSellable(){return sellable;}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(City city) {
		city.addBuilding(this);
		myCity=city;
		
	}
	


}
