package game.dev.mechanics.requests;


import game.dev.mechanics.building.Marketplace;
import game.dev.mechanics.city.City;
import static game.dev.mechanics.requests.RequestConstants.*;

public class MarketPlaceRequest extends Request {

	public MarketPlaceRequest() {
		super(MARKETPLACEWOOD, MARKETPLACESTONE, MARKETPLACEFOOD, MARKETPLACEGOLD, MARKETPLACETURNS, MARKETPLACEID);
	}

	@Override
	public void create(City city) {
		super.create(city);
		city.addBuilding(new Marketplace());
	}


}
