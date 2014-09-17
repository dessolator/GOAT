package game.dev.gui.misc.buttons;


import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import game.dev.engine.DrawObject;
import game.dev.engine.TextureHolder;
import game.dev.gui.menu.misc.text.Text;
import game.dev.gui.menu.misc.text.TimesNewRomanText;
import game.dev.interfaces.Drawable;
import game.dev.interfaces.Updatable;
import game.dev.sounds.SEngine;
import static game.dev.engine.LoadTex.myButtonTexture;;



public abstract class Button implements Drawable, Updatable{
	protected TextureHolder myTexture;
	protected TextureHolder pressedTexture;
	private Text myText;
	protected boolean clicked=false;
	private boolean previousMouseState=false;
	
	
	public Button(float coordX, float coordY,String myText) {
		this.myText=new TimesNewRomanText(coordX,coordY,myText);
		this.coordX = coordX;
		this.coordY = coordY;
		this.dimX = Display.getWidth()/5;
		this.dimY = Display.getHeight()/10;
		myTexture=  myButtonTexture;
//		pressedTexture=new TextureHolder(pushedButtonTextures,new Tex(0f,((float)9/10),1f,((float)1)));

	}
	private float coordX;
	private float coordY;
	protected float dimX;
	protected float dimY;
	public void render(){
		DrawObject.draw(this);
		myText.render();
	}
	public void click(){
		clicked=true;
	}
	public void unClick(){
		clicked=false;
	}
	public boolean isClicked(){
		return clicked;
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
	public Texture getTexture() {
		if(clicked)
			return myTexture.getMyTexture();
		return myTexture.getMyTexture();
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
	
	@Override
	public float getTexX1() {
		if(clicked)
			return myTexture.getMyCoords().getX1();
		return myTexture.getMyCoords().getX1();
	}
	@Override
	public float getTexX2() {
		if(clicked)
			return myTexture.getMyCoords().getX2();
		return myTexture.getMyCoords().getX2();
	}
	@Override
	public float getTexY1() {
		if(clicked)
			return myTexture.getMyCoords().getY1();
		return myTexture.getMyCoords().getY1();
	}
	@Override
	public float getTexY2() {
		if(clicked)
			return myTexture.getMyCoords().getY2();
		return myTexture.getMyCoords().getY2();
	}
	
	public void pressed(){
		SEngine.getSoundSystem().play("buttonclick");
		}
	
	@Override
	public void update() {
		if(Mouse.getEventButtonState()&&isInBounds(Mouse.getX(), Mouse.getY())){
			click();
			previousMouseState=true;
			return;
		}
		if(previousMouseState&&!Mouse.getEventButtonState()&&isInBounds(Mouse.getX(), Mouse.getY()) && isClicked()){
			pressed();
			previousMouseState=false;
			return;
		}
		unClick();		
	}
	@Override
	public float getAngle() {
		return 0;
	}
	public Text getMyText() {
		return myText;
	}
	public void setMyText(Text myText) {
		this.myText = myText;
	}
	

}

