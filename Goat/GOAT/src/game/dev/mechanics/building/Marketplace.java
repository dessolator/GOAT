package game.dev.mechanics.building;

import game.dev.mechanics.city.City;
import game.dev.mechanics.requests.RequestConstants;

public class Marketplace extends Building {
	private boolean applied = false;

	public Marketplace() {
		super(RequestConstants.MARKETPLACEGOLD/4, RequestConstants.MARKETPLACESTONE/4,
				RequestConstants.MARKETPLACEWOOD/4, RequestConstants.MARKETPLACEFOOD/4,
				RequestConstants.MARKETPLACESELLABLE, RequestConstants.MARKETPLACEID);
	}


	@Override
	public void update() {
		applyEffect();
	}

	@Override
	public void applyEffect() {//TO DO set trading allowed to true
		myCity.changeGold(10);
		myCity.haveMarketPlace(true);
	}

	@Override
	public void removeEffect() {
		myCity.haveMarketPlace(false);
	}
	
}
