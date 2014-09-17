package game.dev.interfaces;

import org.newdawn.slick.opengl.Texture;

import game.dev.engine.DrawObject;

public interface Drawable {
	
	   public Texture getTexture();

       public void render();
       
       public float getX();
       
       public float getY();
       
       public float getDimX();
       
       public float getDimY();
       
       public float getTexX1();
       
       public float getTexX2();        
       
       public float getTexY1();
       
       public float getTexY2();
	
       public float getAngle();
}
