package game.dev.mechanics.requests;

import game.dev.mechanics.building.Church;
import game.dev.mechanics.building.Granary;
import game.dev.mechanics.city.City;
import static game.dev.mechanics.requests.RequestConstants.*;

public class ChurchRequest extends Request {

	public ChurchRequest() {
		super(CHURCHWOOD, CHURCHSTONE, CHURCHFOOD, CHURCHGOLD, CHURCHTURNS, CHURCHID);
	}

	@Override
	public void create(City city) {
		super.create(city);
		city.addBuilding(new Church());
	}


}
