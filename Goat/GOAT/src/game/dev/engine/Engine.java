package game.dev.engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;


public class Engine {
	private static int width = 1280; 
	private static int height = 720;
	private static boolean fullscreen = false;
	private static boolean vsync = true;
	
	public static void init(){
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setFullscreen(fullscreen);
			Display.create();
			Keyboard.create();
			Mouse.create();
			Display.setVSyncEnabled(vsync);
			
			 glMatrixMode(GL_PROJECTION);//set projection mode 
             glLoadIdentity();//load identity matrix
             glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);//set the ortho left,right,bottom top....
             glMatrixMode(GL_MODELVIEW);//set the modelview
             glClearColor(0, 0, 0, 1);//set the color to black, and transparency not enabled
             glDisable(GL_DEPTH_TEST);//remove the artefacts
             glClear(GL_COLOR_BUFFER_BIT);//clear color buffer
             glLoadIdentity();
             glEnable(GL_TEXTURE_2D);  		
		} catch (LWJGLException e) {			
			e.printStackTrace();
		}	
	}
	
	public static void kill(){
		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
	}

}
