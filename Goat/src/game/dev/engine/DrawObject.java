package game.dev.engine;

import game.dev.interfaces.Drawable;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;

public class DrawObject{

	 // GL based drawing without the rotation
    public static void draw(Drawable d){
            draw(d,0);                        
    }

    // GL Based drawing with rotation
    public static void draw(Drawable d, float rotation){ 
	    	if(d.getTexture() != null){
	             d.getTexture().bind();
	    	}
	    	
            glPushMatrix();            
            glTranslatef(d.getX(),Display.getHeight()-d.getY(), 0);
            glRotatef((float)Math.toDegrees(d.getAngle()), 0, 0, 1 );
            glColor3f(1, 1, 1);
            glEnable(GL_TEXTURE_2D);
            glEnable(GL_BLEND);
            glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);                        
            //mapiranje teksture
            glBegin(GL_QUADS);
                    glTexCoord2f(d.getTexX1(), d.getTexY1());
                    glVertex2f(-d.getDimX()/2, -d.getDimY()/2);
                    glTexCoord2f(d.getTexX2(),d.getTexY1());
                    glVertex2f(d.getDimX()/2,-d.getDimY()/2);
                    glTexCoord2f(d.getTexX2(), d.getTexY2());
                    glVertex2f(d.getDimX()/2, d.getDimY()/2);
                    glTexCoord2f(d.getTexX1(), d.getTexY2());
                    glVertex2f(-d.getDimX()/2, d.getDimY()/2);                                                
            glEnd();
            glPopMatrix();                        
}
    
	//draw rectangle with color components R G B        
	public static void drawRect(float x, float y, float dimX, float dimY, float r, float g, float b,  float alpha){
	    glPushMatrix();//create new matrix for manipulation of the given rectangle.
	    glTranslatef(x,Display.getHeight()-y,0);//set starting point to the coordinates needed.                }
	    glEnable(GL_BLEND);//enable blending for transparency
	    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);//set alpha blend function                
	    //draw rectangle using gl	     
	    glDisable(GL_TEXTURE_2D);//Disable textures... why? no clue, doesn't actually take color into account without this    
	    glColor4f(r, g, b, alpha);
	    glBegin(GL_QUADS);
	    {
	            glVertex2f(-dimX/2, -dimY/2);
	            glVertex2f(dimX/2,-dimY/2);
	            glVertex2f(dimX/2, dimY/2);
	            glVertex2f(-dimX/2, dimY/2);                        
	    }
	    glEnd();
	    glPopMatrix();//when done with object manipulation merge model matrices.                
	}
	
	//draw rectangle wqithout color components R G B
	public static void drawRect(float x, float y, float dimX, float dimY, float alpha){
	    drawRect( x,  y,  dimX, dimY, 1, 1, 1, alpha);                
	}

}
