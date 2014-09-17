package game.dev.engine;

import org.newdawn.slick.opengl.Texture;

import game.dev.interfaces.Collidable;
import game.dev.interfaces.Drawable;
import game.dev.interfaces.Updatable;

public abstract class GameObject implements Drawable, Collidable, Updatable  {
	protected float coordX;
	protected float coordY;
	protected float dimX;
	protected float dimY;
	protected TextureHolder myTextureHolder;
	
	

	 public GameObject(float x, float y, float dimx, float dimy,TextureHolder myTextureHolder){
		 this.coordX = x;
		 this.coordY = y;
		 this.dimX = dimx;
		 this.dimY = dimy;
		 this.myTextureHolder=myTextureHolder;
	 }
	
	@Override
	public void collided(GameObject o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return myTextureHolder.getMyTexture();
	}

	@Override
	public float getX() {
		return coordX;
	}

	@Override
	public float getY() {
		return coordY;
	}

	@Override
	public float getDimX() {
		return dimX;
	}

	@Override
	public float getDimY() {
		return dimY;
	}

	@Override
	public float getTexX1() {
		return myTextureHolder.getMyCoords().getX1();
	}

	@Override
	public float getTexX2() {
		return myTextureHolder.getMyCoords().getX2();	
	}

	@Override
	public float getTexY1() {
		return myTextureHolder.getMyCoords().getY1();	
	}

	@Override
	public float getTexY2(){
		return myTextureHolder.getMyCoords().getY2();
	}

	@Override
	public float getAngle() {
		return 0;
	}

}
