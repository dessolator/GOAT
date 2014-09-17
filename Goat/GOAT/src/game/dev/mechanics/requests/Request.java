package game.dev.mechanics.requests;

import game.dev.mechanics.city.City;

public abstract class Request {
	
	private int reqWood;
	private int reqStone;
	private int reqFood;
	private int reqGold;
	private int turnsToComplete;
	private int buildId;
	
	
	
	public Request(int reqWood, int reqStone, int reqFood, int reqGold, int turns, int myId ){
		this.reqWood=reqWood;
		this.reqStone=reqStone;
		this.reqFood=reqFood;
		this.reqGold=reqGold;
		this.buildId=myId;
		this.turnsToComplete=turns;
		
	}
	
	public void create(City city){
		city.removeRequest(this);	
	}
	
	public int remainingTurns() {
		return turnsToComplete;
	}


	public int getId() {
		return buildId;
	}
	
	public int getReqWood() {
		return reqWood;
	}

	public int getReqStone() {
		return reqStone;
	}

	public int getReqFood() {
		return reqFood;
	}

	public int getReqGold() {
		return reqGold;
	}

	public void setRemainingTurns(int i) {
		turnsToComplete=i;
		
	}


}
