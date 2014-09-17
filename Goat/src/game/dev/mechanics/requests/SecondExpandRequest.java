package game.dev.mechanics.requests;

import game.dev.mechanics.building.Granary;
import game.dev.mechanics.city.City;
import static game.dev.mechanics.requests.RequestConstants.*;

public class SecondExpandRequest extends Request {

	public SecondExpandRequest() {
		super(SECONDEXPANDWOOD, SECONDEXPANDSTONE, SECONDEXPANDFOOD, SECONDEXPANDGOLD, SECONDEXPANDTURNS, SECONDEXPANDID);
	}

	@Override
	public void create(City city) {
		super.create(city);
		city.addBuildable(new CollegeRequest());
	}


}
