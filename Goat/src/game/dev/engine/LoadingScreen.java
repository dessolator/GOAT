package game.dev.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import game.dev.interfaces.Drawable;
import static game.dev.engine.LoadTex.tex;
import static game.dev.engine.LoadTex.loading1;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
public class LoadingScreen implements Drawable {	
	
	private TextureHolder myTextureHolder;
//    private static float x1;
//    private static float x2;
//    private static float y1;
//    private static float y2;
//    private static int i=0;
    private float  alpha = 0;
    
    public LoadingScreen(){
    	myTextureHolder= loading1;
 
    }        
    
            //        @Override
    public Texture getTexture() {
            return loading1.getMyTexture();
    }
    
    @Override
    public void render() {
    	glClear(GL_COLOR_BUFFER_BIT);
//            tex.getMyCoords().setX1(0);
//            tex.getMyCoords().setY1(0);
//            tex.getMyCoords().setX2(1);
//            tex.getMyCoords().setY2(1);
    		//for(int i=0; i<20; i++){
    		DrawObject.draw(this); 
//    		DrawObject.drawRect(640f, 360f, 1280f, 720f, 0f, 0f, 0f, 1 - alpha);                       
            Display.update(); 
//            alpha+=0.05; 
    		//}
     }
    

	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return Display.getWidth()/2;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return Display.getHeight()/2;
		
	}

	@Override
	public float getDimX() {
		// TODO Auto-generated method stub
		return Display.getWidth();
	}

	@Override
	public float getDimY() {
		// TODO Auto-generated method stub
		return Display.getHeight();
	}

	@Override
	public float getTexX1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getTexX2() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public float getTexY1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getTexY2() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public float getAngle() {
		// TODO Auto-generated method stub
		return 0;
	}
}
