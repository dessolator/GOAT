package game.dev.mechanics.requests;

import game.dev.mechanics.building.Granary;
import game.dev.mechanics.city.City;
import static game.dev.mechanics.requests.RequestConstants.*;

public class GranaryRequest extends Request {

	public GranaryRequest() {
		super(GRANARYWOOD, GRANARYSTONE, GRANARYFOOD, GRANARYGOLD, GRANARYTURNS, GRANARYID);
	}

	@Override
	public void create(City city) {
		super.create(city);
		city.addBuilding(new Granary());
	}


}
