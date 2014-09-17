package game.dev.mechanics.blocks.undeveloedBlocks;

import game.dev.engine.Tex;
import game.dev.engine.TextureHolder;
import game.dev.mechanics.Game;
import game.dev.mechanics.blocks.developedBlocks.DevelopedBlock;
import game.dev.mechanics.blocks.developedBlocks.Meadow;
import game.dev.mechanics.blocks.developedBlocks.Quarry;
import game.dev.mechanics.city.City;
import static game.dev.engine.LoadTex.undevelopedStone;
/**
 * @author Ivan Kesler
 *
 */
public class UndevelopedStone extends UndevelopedBlock{
	


	@Override
	public void develop(City myCity) {
//		super.develop(myCity);
		DevelopedBlock b=new Quarry(myFactor,myCity,coordX,coordY);
		myCity.addBlock(b);
		myCity.getExplorer().setMyBlock(b);
		Game.removeBlock(this);
		
	}
	
	public UndevelopedStone(int myFactor,float coordX,float coordY){
		super(myFactor, coordX, coordY, undevelopedStone);
	}

}
