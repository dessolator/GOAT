package game.dev.mechanics.requests;


import game.dev.mechanics.building.Well;
import game.dev.mechanics.city.City;
import static game.dev.mechanics.requests.RequestConstants.*;

public class WellRequest extends Request {

	public WellRequest() {
		super(WELLWOOD, WELLSTONE, WELLFOOD, WELLGOLD, WELLTURNS, WELLID);
	}

	@Override
	public void create(City city) {
		super.create(city);
		city.addBuilding(new Well());
	}


}
