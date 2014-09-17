package game.dev.mechanics.units;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import game.dev.mechanics.Game;
import game.dev.mechanics.blocks.Block;
import static game.dev.engine.LoadTex.explorerActive;
import static game.dev.engine.LoadTex.explorerUnactive;

public class Explorer extends Unit {
	int movesToMake=3;
	private long keyTriggered;
	public Explorer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public Texture getTexture() {
		if(active)
			return explorerActive.getMyTexture();
		return explorerUnactive.getMyTexture();
	}

	@Override
	public void update() {
		active=true;
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
            if((((long)System.nanoTime()-keyTriggered)>150000000)){//if time passed
                    keyTriggered=System.nanoTime(); 
                    if(movesToMake>0){
                    	Block b=myBlock.getBlockAbove();
                    	if(b!=null){
                    	myBlock=b;
                    	myCoordX=myBlock.getX();
                    	myCoordY=myBlock.getY();
                    	movesToMake--;
                    	}
                    }
            }
	    }
	    if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
	        if((((long)System.nanoTime()-keyTriggered)>150000000)){//if time passed
	                keyTriggered=System.nanoTime();
	                if(movesToMake>0){
	                	Block b=myBlock.getBlockUnder();
                    	if(b!=null){
                    	myBlock=b;
                    	myCoordX=myBlock.getX();
                    	myCoordY=myBlock.getY();
                    	movesToMake--;
                    	}
	                }
	        }
	    }
	    if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
	        if((((long)System.nanoTime()-keyTriggered)>150000000)){//if time passed
	                keyTriggered=System.nanoTime();
	                if(movesToMake>0){
	                	Block b=myBlock.getBlockLeft();
                    	if(b!=null){
                    	myBlock=b;
                    	myCoordX=myBlock.getX();
                    	myCoordY=myBlock.getY();
                    	movesToMake--;
                    	}
	                }
	        }
	    }
	    if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
	        if((((long)System.nanoTime()-keyTriggered)>150000000)){//if time passed
	                keyTriggered=System.nanoTime();
	                if(movesToMake>0){
	                	Block b=myBlock.getBlockRight();
                    	if(b!=null){
                    	myBlock=b;
                    	myCoordX=myBlock.getX();
                    	myCoordY=myBlock.getY();
                    	movesToMake--;
                    	}
	                }
	        }
	    }
	    if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
	        if((((long)System.nanoTime()-keyTriggered)>150000000)){//if time passed
	                keyTriggered=System.nanoTime();
	                if(movesToMake>1){
                    	myBlock.develop(myCity);
                    	movesToMake-=2;
	                }
	        }
	    }
		
		
		
 
		
		
		
		
		
//		while(!closeEnough){
//			Mouse.next();
//			Block clicked=Game.listenForClicks();
//			if(clicked!=null){
//				System.out.println("moo");
//				double distanceClicked=Math.sqrt(
//						Math.pow(clicked.getX()-this.getX(),2)+
//						Math.pow(clicked.getY()-this.getY(),2)
//						);
//				if(distanceClicked<=(1.41*movesToMake*80)){
//					myBlock=clicked;
//					active=false;
					//I'm sure this could be done better.... but it's been a long while without sleep...
//					if(distanceClicked>=(1.41*(1)*80))
//						movesToMake-=1;
//					if(distanceClicked>=(1.41*(2)*80))
//						movesToMake-=2;
//					if(distanceClicked>=(1.41*(3)*80))
//						movesToMake-=3;
//				}
//			}
				
//		}
//		System.out.println("moo");
	}
	public void setMyBlock(Block b) {
		myBlock=b;
		
	}

	public void resetTurns(){movesToMake=3;} 		
	
	

}
