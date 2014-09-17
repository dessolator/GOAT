package game.dev.mechanics.blocks.developedBlocks;

import game.dev.engine.Tex;
import game.dev.engine.TextureHolder;
import game.dev.mechanics.city.City;
import game.dev.sounds.SEngine;
import static game.dev.engine.LoadTex.quarry;
/**
 * @author Ivan Kesler
 *
 */
public class Quarry extends DevelopedBlock{
	
	@Override
	public void update() {
		myCity.changeStone(myFactor);
	}

	@Override
	public void develop(City myCity) {}
	
	public Quarry(int myFactor,City myCity,float coordX,float coordY){
		super(15,myCity, coordX, coordY, quarry);
		SEngine.getSoundSystem().play("mining");
	}

}
