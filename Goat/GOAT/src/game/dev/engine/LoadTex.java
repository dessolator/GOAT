package game.dev.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.opengl.TextureLoader;

import game.dev.engine.LoadingScreen;
import game.dev.sounds.SEngine;

public class LoadTex {	
    	//put some static textures here
		public static TextureHolder tex;
		public static TextureHolder basicFrame;
		public static TextureHolder myButtonTexture;
		public static TextureHolder notificationFrame;
		public static TextureHolder managementFrame;
		public static TextureHolder statusFrame;
		public static TextureHolder loading1;
		public static TextureHolder goldMine;
		public static TextureHolder meadow;
		public static TextureHolder quarry;
		public static TextureHolder lumberMill;
		public static TextureHolder undevelopedGoldMine;
		public static TextureHolder undevelopedLumberMill;
		public static TextureHolder undevelopedForest;
		public static TextureHolder undevelopedLand;
		public static TextureHolder undevelopedStone;
		public static TextureHolder undevelopedBlock;
		public static TextureHolder myTextureHolder;
		public static TextureHolder level;
		public static TextureHolder city;
		public static TextureHolder mainMenu;
		public static TextureHolder pauseMenu;
		public static TextureHolder lvltest;
		public static TextureHolder explorerUnactive;
		public static TextureHolder explorerActive;
		public static LoadingScreen ls;
		
		public static TextureHolder college;
		public static TextureHolder cross;
		public static TextureHolder granary;
		public static TextureHolder marketplace;
		public static TextureHolder stables;
		public static TextureHolder well;
		
		
		public static void init(){
		 //initialize above mentioned textures 
		 try {	
			
			college = new TextureHolder(TextureLoader.getTexture("PNG", new FileInputStream( new File("res/college64.png"))),new Tex(0,0,1,1));
			cross = new TextureHolder(TextureLoader.getTexture("PNG", new FileInputStream( new File("res/cross64.png"))),new Tex(0,0,1,1));
			granary = new TextureHolder(TextureLoader.getTexture("PNG", new FileInputStream( new File("res/granary64.png"))),new Tex(0,0,1,1));
			marketplace =  new TextureHolder(TextureLoader.getTexture("PNG", new FileInputStream( new File("res/marketplace64.png"))),new Tex(0,0,1,1));
			stables = new TextureHolder(TextureLoader.getTexture("PNG", new FileInputStream( new File("res/stables64.png"))),new Tex(0,0,1,1));
			well = new TextureHolder(TextureLoader.getTexture("PNG", new FileInputStream( new File("res/well64.png"))),new Tex(0,0,1,1));
//			tex = new TextureHolder(TextureLoader.getTexture("PNG", new FileInputStream( new File("res/tex64.png"))),new Tex(0,0,1,1));
			SEngine.getSoundSystem().quickPlay(false, "splashsound.ogg", false, 0, 0, 0, 0, 0);

			loading1 =new TextureHolder( TextureLoader.getTexture("PNG", new FileInputStream( new File("res/loading.png"))),new Tex(0,0,1,1));
			ls = new LoadingScreen();
			ls.render();
			tex = new TextureHolder(TextureLoader.getTexture("PNG", new FileInputStream( new File("res/loading.png"))),new Tex(0,0,1,1));
//			ls = new LoadingScreen();
//			ls.render();
			basicFrame = new TextureHolder(TextureLoader.getTexture("PNG", new FileInputStream( new File("res/mainFrame.png"))),new Tex(0,0,1,1));	
			//ls.render();
		 	mainMenu =new TextureHolder( TextureLoader.getTexture("PNG", new FileInputStream(new File("res/background.png"))), new Tex(0,0,1,1));
		 	//ls.render();
		 	pauseMenu = new TextureHolder( TextureLoader.getTexture("PNG", new FileInputStream(new File("res/background.png"))), new Tex(0,0,1,1));
		 	//ls.render();
		 	myButtonTexture = new TextureHolder( TextureLoader.getTexture("PNG", new FileInputStream(new File("res/button.png"))),new Tex(0,0,1,1));
		 	notificationFrame = new TextureHolder( TextureLoader.getTexture("PNG", new FileInputStream(new File("res/notification-frame.png"))),new Tex(0,0,1,1));
		 	managementFrame = new TextureHolder( TextureLoader.getTexture("PNG", new FileInputStream(new File("res/notification-frame.png"))),new Tex(0,0,1,1));
		 	statusFrame = new TextureHolder(TextureLoader.getTexture("PNG", new FileInputStream(new File("res/status-bar.png"))),new Tex(0,0,1,1));
			
			//test
			
			goldMine = new TextureHolder(TextureLoader.getTexture("PNG", new FileInputStream( new File("res/goldmine.png"))), new Tex(0 ,0, 1, 1));
			meadow = new TextureHolder(TextureLoader.getTexture("PNG", new FileInputStream( new File("res/meadow.png"))), new Tex(0 ,0, 1, 1));
			quarry = new TextureHolder(TextureLoader.getTexture("PNG", new FileInputStream( new File("res/quarry.png"))), new Tex(0 ,0, 1, 1));
			lumberMill = new TextureHolder(TextureLoader.getTexture("PNG", new FileInputStream( new File("res/lumbermill.png"))), new Tex(0 ,0, 1, 1));
			undevelopedGoldMine = new TextureHolder( TextureLoader.getTexture("PNG", new FileInputStream( new File("res/gold.png"))), new Tex(0 ,0, 1, 1));
			undevelopedLumberMill = new TextureHolder( TextureLoader.getTexture("PNG", new FileInputStream( new File("res/forest.png"))), new Tex(0 ,0, 1, 1));
			undevelopedForest = new TextureHolder( TextureLoader.getTexture("PNG", new FileInputStream( new File("res/forest.png"))), new Tex(0 ,0, 1, 1));
			undevelopedLand = new TextureHolder( TextureLoader.getTexture("PNG", new FileInputStream( new File("res/grass.png"))), new Tex(0 ,0, 1, 1));
			undevelopedStone = new TextureHolder( TextureLoader.getTexture("PNG", new FileInputStream( new File("res/grassWithStone.png"))), new Tex(0 ,0, 1, 1));
//			level=new TextureHolder( TextureLoader.getTexture("PNG", new FileInputStream( new File("res/level.png"))), new Tex(0 ,0, 1, 1));
//			myTextureHolder = new TextureHolder( TextureLoader.getTexture("PNG", new FileInputStream( new File("res/undevelopedBlocks.png"))), new Tex(5/32 ,0, 6/32, 1/32));
			city=new TextureHolder( TextureLoader.getTexture("PNG", new FileInputStream( new File("res/village.png"))), new Tex(0 ,0, 1, 1));
			explorerUnactive = new TextureHolder(TextureLoader.getTexture("PNG", new FileInputStream(new File("res/explorer.png"))), new Tex(0, 0, 1, 1));
			explorerActive = new TextureHolder(TextureLoader.getTexture("PNG", new FileInputStream(new File("res/explorer-inverse.png"))), new Tex(0, 0, 1, 1));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
}
