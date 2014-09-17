package game.dev.mechanics.building;

import game.dev.mechanics.city.City;
import game.dev.mechanics.requests.RequestConstants;

public class Church extends Building {
	private boolean applied = false;
	
	public Church() {
		super(RequestConstants.CHURCHGOLD/4,RequestConstants.CHURCHSTONE/4, RequestConstants.CHURCHWOOD/4,
				RequestConstants.CHURCHFOOD/4, true, RequestConstants.CHURCHID);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void update() {
		applyEffect();
	}

	@Override
	public void applyEffect() {
		myCity.incHappiness(3);
		myCity.haveChurch(true);
	}

	@Override
	public void removeEffect() {
		myCity.haveChurch(false);
	}
	
}
