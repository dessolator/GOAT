package game.dev.gui.menu.misc.text;

import java.awt.Font;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public abstract class Text{
	TrueTypeFont myFont;
	float coordX;
	float coordY;
	private String myString;
	Color myColor;

	public Text(float coordX, float coordY, String myString, String myFont, Color myColor, int size) {
		super();
		this.myFont=new TrueTypeFont(new Font(myFont,Font.PLAIN,size),true);
		this.coordX = coordX;
		this.coordY = coordY;
		this.myString = myString;
		this.myColor = myColor;
	}

	public void render() {
		myFont.drawString(
			coordX-myFont.getWidth(myString)/2,
			(Display.getHeight()-coordY)-myFont.getHeight(myString)/2,
			myString,
			myColor);
		
	}

	public String getMyString() {
		return myString;
	}

	public void setMyString(String myString) {
		this.myString = myString;
	}
	

}
