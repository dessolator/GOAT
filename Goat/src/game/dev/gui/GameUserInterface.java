package game.dev.gui;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;


import game.dev.gui.menu.Menu;


public class GameUserInterface extends Menu {

	private ManagementFrame managementFrame;
	private NotificationFrame notificationFrame;
	private MenuFrame menuFrame;
	private StatusFrame statusFrame;
	private BuildingsFrame buildingsFrame;
//	private Button menu; // TODO kreirati desno dugme u donjem desnom uglu
	
	public GameUserInterface() {
		managementFrame = new ManagementFrame(Display.getWidth()/8,
				Display.getHeight()/16,
				((float)1*Display.getWidth())/8,
				((float)1*Display.getHeight())/12);
		
		notificationFrame = new NotificationFrame();
		menuFrame = new MenuFrame(7*Display.getWidth()/8,
				Display.getHeight()/16,
				((float)1*Display.getWidth())/8,
				((float)1*Display.getHeight())/12);
		statusFrame = new StatusFrame(Display.getWidth()/2,
				710,
				Display.getWidth(),
				Display.getHeight()/30
				);
		buildingsFrame = new BuildingsFrame(Display.getWidth()/2,
				Display.getHeight()/15,
				Display.getWidth()/2,
				Display.getHeight()/8);
	}
	
	public NotificationFrame getNotificationFrame() {
		return notificationFrame;
	}
	
	public StatusFrame getStatusFrame() {
		return statusFrame;
	}
	
	public void update() {
		if(System.nanoTime()<(long)menuCalled+(long)125000000){	
			Mouse.next();//if the cooldown hasn't passed flip to next mouse event.
		}
		else{
			while(Mouse.next()){
				managementFrame.update();
				menuFrame.update();
				buildingsFrame.update();
			}
		}
	}

	



	

	
	public void render() {
		// TODO Auto-generated method stub
		managementFrame.render();
		notificationFrame.render();
		menuFrame.render();
		statusFrame.render();
		buildingsFrame.render();
	}


}
