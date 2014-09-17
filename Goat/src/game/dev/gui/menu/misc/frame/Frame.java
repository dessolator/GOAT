package game.dev.gui.menu.misc.frame;




import game.dev.engine.DrawObject;
import game.dev.engine.TextureHolder;
import game.dev.interfaces.Drawable;

import org.newdawn.slick.opengl.Texture;

public abstract class Frame implements Drawable {
	protected TextureHolder frame;
	private float coordX;
	private float coordY;
	private float dimX;
	private float dimY;
	
	
	public Frame(float coordX, float coordY, float dimX, float dimY) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.dimX = dimX;
		this.dimY = dimY;
	}

	
	@Override
	public void render() {
		DrawObject.draw(this);
	}

	@Override
	public Texture getTexture() {
		return frame.getMyTexture();
	}

	@Override
	public float getX() {
		return coordX;
	}

	@Override
	public float getDimX() {
		return dimX;
	}

	@Override
	public float getY() {
		return coordY;
	}

	@Override
	public float getDimY() {
		return dimY;
	}

}
