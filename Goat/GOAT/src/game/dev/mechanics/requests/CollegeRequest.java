package game.dev.mechanics.requests;

import game.dev.mechanics.building.College;
import game.dev.mechanics.city.City;
import static game.dev.mechanics.requests.RequestConstants.*;

public class CollegeRequest extends Request {

	public CollegeRequest() {
		super(COLLEGEWOOD, COLLEGESTONE, COLLEGEFOOD, COLLEGEGOLD, COLLEGETURNS, COLLEGEID);
	}

	@Override
	public void create(City city) {
		super.create(city);
		city.addBuilding(new College());
	}


}
