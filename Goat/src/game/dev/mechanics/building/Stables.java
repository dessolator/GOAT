package game.dev.mechanics.building;

import game.dev.mechanics.city.City;
import game.dev.mechanics.requests.RequestConstants;
public class Stables extends Building {
	private boolean applied = false;

	public Stables() {
		super(RequestConstants.STABLESGOLD/4,
				RequestConstants.STABLESSTONE/4, RequestConstants.STABLESWOOD/4,
				RequestConstants.STABLESFOOD/4, RequestConstants.STABLESSELLABLE,
				RequestConstants.STABLESID);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void update() {
		applyEffect();
	}

	@Override
	public void applyEffect() {
		myCity.changeFood(100);
		myCity.changeWood(150);
		myCity.changeStone(5);
		myCity.haveStables(true);

	}

	@Override
	public void removeEffect() {
		myCity.haveStables(false);
	}
	

}
