package game.dev.mechanics.building;

import game.dev.mechanics.city.City;
import game.dev.mechanics.requests.RequestConstants;

public class Granary extends Building {
	private boolean applied=false;
	
	public Granary() {
		super(RequestConstants.GRANARYGOLD/4,
				RequestConstants.GRANARYSTONE/4 ,
				RequestConstants.GRANARYWOOD/4,
				RequestConstants.GRANARYFOOD/4,
				RequestConstants.GRANARYSELLABLE,
				RequestConstants.GRANARYID);
	}

	


	@Override
	public void update() {
		applyEffect();
	}
	
	public void removeEffect(){
		myCity.haveGranary(false);
	}
	
	public void applyEffect(){
		myCity.changeFood(150);
		myCity.haveGranary(true);
	}

}
