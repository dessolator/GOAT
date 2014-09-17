package game.dev.mechanics.blocks.undeveloedBlocks;

import game.dev.engine.Tex;
import game.dev.engine.TextureHolder;
import game.dev.mechanics.Game;
import game.dev.mechanics.blocks.Block;
import game.dev.mechanics.city.City;
import static game.dev.engine.LoadTex.myTextureHolder;

/**
 * @author Ivan Kesler
 *
 */
public abstract class UndevelopedBlock extends Block{
	public int myFactor;
	
	
	public UndevelopedBlock(int myFactor,float coordX,float coordY,TextureHolder myTextureHolder) {
		super(coordX,coordY,myTextureHolder);
		this.myFactor=myFactor;
	}

	@Override
	public void update() {}
}
