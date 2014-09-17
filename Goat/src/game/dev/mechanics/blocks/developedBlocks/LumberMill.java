package game.dev.mechanics.blocks.developedBlocks;

import game.dev.engine.Tex;
import game.dev.engine.TextureHolder;
import game.dev.mechanics.city.City;
import static game.dev.engine.LoadTex.lumberMill;
/**
 * @author Ivan Kesler
 *
 */

public class LumberMill extends DevelopedBlock{
	
	@Override
	public void update() {
		myCity.changeWood(myFactor);
	}

	@Override
	public void develop(City myCity) {}
	
	public LumberMill(int myFactor,City myCity,float coordX,float coordY){
		super(5,myCity, coordX, coordY, lumberMill);
	}

}
