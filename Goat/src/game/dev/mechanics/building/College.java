package game.dev.mechanics.building;

import game.dev.engine.GameState;
import game.dev.mechanics.Game;
import game.dev.mechanics.city.City;
import game.dev.mechanics.requests.RequestConstants;

public class College extends Building {
	
	public College() {
		super(RequestConstants.COLLEGEGOLD/4,
				RequestConstants.COLLEGESTONE/4,
				RequestConstants.COLLEGEWOOD/4,
				RequestConstants.COLLEGEFOOD/4,
				RequestConstants.COLLEGESELLABLE,
				RequestConstants.COLLEGEID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		applyEffect();
		
	}

	@Override
	public void applyEffect() {
		Game.setCurrentGameState(GameState.Victory);
	}

	@Override
	public void removeEffect() {
		// TODO Auto-generated method stub
		
	}
	
}
