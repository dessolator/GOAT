package game.dev.mechanics.blocks;



import org.lwjgl.input.Mouse;
import game.dev.engine.DrawObject;
import game.dev.engine.GameObject;
import game.dev.engine.TextureHolder;
import game.dev.interfaces.Clickable;
import game.dev.mechanics.Game;
import game.dev.mechanics.city.City;

/**
 * @author Ivan Kesler
 *
 */
public abstract  class Block extends GameObject implements Clickable{
	
	
	public Block(float coordX,float coordY,TextureHolder myTextureHolder) {
		super(coordX, coordY, 80, 80, myTextureHolder);
	}

	public Block getBlockUnder() {
		for(int i=0;i<Game.getMyLevel().getMyBlocks().size();i++){
			if(Game.getMyLevel().getMyBlocks().get(i).getY()==this.getY()-80 && Game.getMyLevel().getMyBlocks().get(i).getX()==this.getX()){
				return Game.getMyLevel().getMyBlocks().get(i);
			}
		}
		for(int j=0;j<Game.getMyLevel().getMyCity().getMyBlocks().size();j++){
			if(Game.getMyLevel().getMyCity().getMyBlocks().get(j).getY()==this.getY()-80 && Game.getMyLevel().getMyCity().getMyBlocks().get(j).getX()==this.getX()){
				return Game.getMyLevel().getMyCity().getMyBlocks().get(j);
			}
			
		}
		return null;
	}

	public Block getBlockAbove() {
		for(int i=0;i<Game.getMyLevel().getMyBlocks().size();i++){
			if(Game.getMyLevel().getMyBlocks().get(i).getY()==this.getY()+80 && Game.getMyLevel().getMyBlocks().get(i).getX()==this.getX()){
				return Game.getMyLevel().getMyBlocks().get(i);
			}
		}
		for(int j=0;j<Game.getMyLevel().getMyCity().getMyBlocks().size();j++){
			if(Game.getMyLevel().getMyCity().getMyBlocks().get(j).getY()==this.getY()+80 && Game.getMyLevel().getMyCity().getMyBlocks().get(j).getX()==this.getX()){
				return Game.getMyLevel().getMyCity().getMyBlocks().get(j);
			}
			
		}
		return null;
	}
	public Block getBlockRight() {
		for(int i=0;i<Game.getMyLevel().getMyBlocks().size();i++){
			if(Game.getMyLevel().getMyBlocks().get(i).getY()==this.getY() && Game.getMyLevel().getMyBlocks().get(i).getX()==this.getX()+80){
				return Game.getMyLevel().getMyBlocks().get(i);
			}
		}
		for(int j=0;j<Game.getMyLevel().getMyCity().getMyBlocks().size();j++){
			if(Game.getMyLevel().getMyCity().getMyBlocks().get(j).getY()==this.getY() && Game.getMyLevel().getMyCity().getMyBlocks().get(j).getX()==this.getX()+80){
				return Game.getMyLevel().getMyCity().getMyBlocks().get(j);
			}
			
		}
		return null;
	}

	public Block getBlockLeft() {
		for(int i=0;i<Game.getMyLevel().getMyBlocks().size();i++){
			if(Game.getMyLevel().getMyBlocks().get(i).getY()==this.getY() && Game.getMyLevel().getMyBlocks().get(i).getX()==this.getX()-80){
				return Game.getMyLevel().getMyBlocks().get(i);
			}
		}
		for(int j=0;j<Game.getMyLevel().getMyCity().getMyBlocks().size();j++){
			if(Game.getMyLevel().getMyCity().getMyBlocks().get(j).getY()==this.getY() && Game.getMyLevel().getMyCity().getMyBlocks().get(j).getX()==this.getX()-80){
				return Game.getMyLevel().getMyCity().getMyBlocks().get(j);
			}
			
		}
		return null;
	}
	
	public abstract void develop(City myCity);// function called if the 
	@Override
	public void render(){
		DrawObject.draw(this);
	}


	@Override
	public float getTexX1() {
		return 0;
	}

	@Override
	public float getTexX2() {
		return 1;
	}

	@Override
	public float getTexY1() {
		return 0;
	}

	@Override
	public float getTexY2() {
		return 1;
	}




	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public boolean isInBounds(float x,float y){
		if (x<(coordX-(dimX/2)))
			return false;
		if (x>(coordX+(dimX/2)))
			return false;
		if (y>(coordY+(dimY/2)))
			return false;
		if (y<(coordY-(dimY/2)))
			return false;
		return true;
	}




	@Override
	public boolean isClicked() {
//		while(Mouse.next()){
			if(Mouse.getEventButtonState()&&isInBounds(Mouse.getX(), Mouse.getY())){
				return true;
			}
//		}
		return false;
		
	}



	public void setX(int x) {
		coordX=x;
		
	}



	public void setY(int y) {
		coordY=y;
		
	}


}
