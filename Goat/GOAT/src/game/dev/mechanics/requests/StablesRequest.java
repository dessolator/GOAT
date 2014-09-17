package game.dev.mechanics.requests;

import game.dev.mechanics.building.Stables;
import game.dev.mechanics.city.City;
import static game.dev.mechanics.requests.RequestConstants.*;

public class StablesRequest extends Request {

	public StablesRequest() {
		super(STABLESWOOD, STABLESSTONE, STABLESFOOD, STABLESGOLD, STABLESTURNS, STABLESID);
	}

	@Override
	public void create(City city) {
		super.create(city);
		city.addBuilding(new Stables());
	}


}
