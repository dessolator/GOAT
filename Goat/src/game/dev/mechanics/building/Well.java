package game.dev.mechanics.building;

import game.dev.mechanics.requests.RequestConstants;

public class Well extends Building {
	private boolean applied = false;

	public Well() {
		super(RequestConstants.WELLGOLD/4, RequestConstants.WELLSTONE/4,
				RequestConstants.WELLWOOD/4, RequestConstants.WELLFOOD/4,
				RequestConstants.WELLSELLABLE, RequestConstants.WELLID);
	}



	@Override
	public void update() {
		applyEffect();
	}

	@Override
	public void applyEffect() {
		myCity.changeFood(100);
		myCity.haveWell(true);
		
	}

	@Override
	public void removeEffect() {
		myCity.haveWell(false);
	}
	

}
