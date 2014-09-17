package game.dev.gui;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;

import game.dev.engine.DrawObject;
import game.dev.gui.menu.misc.frame.Frame;
import game.dev.gui.menu.misc.text.ResizableTimesNewRoman;
import static game.dev.engine.LoadTex.notificationFrame;

public class NotificationFrame extends Frame  {
	
	private ResizableTimesNewRoman notification;
	private ArrayList<ResizableTimesNewRoman> notes = new ArrayList<ResizableTimesNewRoman>();
	private int numberOfNotes = 0;
	
	private float notesCoordX = 8*Display.getWidth()/9;
	
	public NotificationFrame() {
		super(((float)14*Display.getWidth())/15,
				(15*Display.getHeight())/16,
				Display.getWidth()/3,
				Display.getHeight()/4);
		notification = new ResizableTimesNewRoman(notesCoordX,
				(15*Display.getHeight())/16,"Notification:", 22);
		frame = notificationFrame;
	}

	public ArrayList<ResizableTimesNewRoman> getNotes() {
		return notes;
	}
	
	
	public void setNotification(String str) {
		notes.add(new ResizableTimesNewRoman(notesCoordX,(getY()-getDimY()/2),str,10));
	}
	
	
	
	@Override
	public void render() {
		DrawObject.draw(this);
		notification.render();
		for(ResizableTimesNewRoman t: notes){
			t.render();
		}
		
	}
	@Override
	public float getY(){
		
		
		return ((31*Display.getHeight()/32)-((Display.getHeight()/40)*notes.size()))-20;
	}
	
	@Override
	public float getDimY(){
		
		return(Display.getHeight()/16 + ((Display.getHeight()/20)*notes.size()));
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
