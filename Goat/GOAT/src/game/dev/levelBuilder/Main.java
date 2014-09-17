package game.dev.levelBuilder;


import game.dev.engine.Engine;
import game.dev.engine.LoadTex;
import game.dev.mechanics.Game;
import game.dev.sounds.SEngine;
public class Main {
	
	//main 
	public static void main(String args[]){
	SEngine.init();
	SEngine.getSoundSystem().quickPlay(false, "splashsound.ogg", false, 0, 0, 0, 0, 0);
	Engine.init();
	LoadTex.init();
	LevelBuilder.initGame();
	LevelBuilder.startGame();
	Engine.kill();
	SEngine.getSoundSystem().cleanup();
	}	
	
	
}
