package game.dev.mechanics.blocks.developedBlocks;

import game.dev.engine.Tex;
import game.dev.engine.TextureHolder;
import game.dev.mechanics.city.City;
import static game.dev.engine.LoadTex.meadow;
/**
 * @author Ivan Kesler
 *
 */

public class Meadow extends DevelopedBlock{
	
	@Override
	public void update() {
		myCity.changeFood(myFactor);
	}

	@Override
	public void develop(City myCity) {}
	
	public Meadow(int myFactor,City myCity,float coordX,float coordY){
		super(50,myCity, coordX, coordY, meadow);
	}

}
