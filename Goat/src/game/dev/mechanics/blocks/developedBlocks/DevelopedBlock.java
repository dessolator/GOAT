package game.dev.mechanics.blocks.developedBlocks;

import game.dev.engine.TextureHolder;
import game.dev.mechanics.blocks.Block;
import game.dev.mechanics.city.City;
/**
 * @author Ivan Kesler
 *
 */
public abstract class DevelopedBlock extends Block {
	public int myFactor;
	public DevelopedBlock(int myFactor,City myCity, float coordX,float coordY,TextureHolder myTextureHolder) {
		super(coordX, coordY, myTextureHolder);
		this.myCity=myCity;
		this.myFactor=myFactor;
	}
	City myCity;
	public void develop(City myCity){}// function called if the 

}
