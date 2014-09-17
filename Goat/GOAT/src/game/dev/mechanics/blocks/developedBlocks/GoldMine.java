package game.dev.mechanics.blocks.developedBlocks;

import game.dev.engine.Tex;
import game.dev.engine.TextureHolder;
import game.dev.mechanics.city.City;
import game.dev.sounds.SEngine;
import static game.dev.engine.LoadTex.goldMine;
/**
 * @author Ivan Kesler
 *
 */


public class GoldMine extends DevelopedBlock{
	
	@Override
	public void update() {
		myCity.changeGold(myFactor);
		
	}

	@Override
	public void develop(City myCity) {}
	
	public GoldMine(int myFactor,City myCity,float coordX,float coordY){
		super(20,myCity, coordX, coordY, goldMine);
		SEngine.getSoundSystem().play("mining");
	}


}
