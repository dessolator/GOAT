

package game.dev.mechanics.requests;

import game.dev.mechanics.building.Granary;
import game.dev.mechanics.city.City;
import static game.dev.mechanics.requests.RequestConstants.*;

public class FirstExpandRequest extends Request {

	public FirstExpandRequest() {
		super(FIRSTEXPANDWOOD, FIRSTEXPANDSTONE, FIRSTEXPANDFOOD, FIRSTEXPANDGOLD, FIRSTEXPANDTURNS, FIRSTEXPANDID);
	}

	@Override
	public void create(City city) {
		super.create(city);
		city.addBuildable(new ChurchRequest());
		city.addBuildable(new MarketPlaceRequest());
		city.addBuildable(new SecondExpandRequest());
	}


}
