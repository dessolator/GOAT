package game.dev.engine;


import game.dev.mechanics.Game;
import game.dev.sounds.SEngine;
public class Main {
	
	
	//main 
	public static void main(String args[]){
	SEngine.init();
	Engine.init();
	LoadTex.init();
	Game.initGame();
	Game.startGame();
	Engine.kill();
	SEngine.getSoundSystem().cleanup();
	}	
	
	
}
