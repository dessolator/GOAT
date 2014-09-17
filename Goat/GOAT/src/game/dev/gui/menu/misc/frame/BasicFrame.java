package game.dev.gui.menu.misc.frame;



import static game.dev.engine.LoadTex.basicFrame;


public class BasicFrame extends Frame {

	public BasicFrame(float coordX, float coordY, float dimX, float dimY) {
		super(coordX, coordY, dimX, dimY);

			frame=basicFrame;
		
	}
	/*
	 * funkcije ispod ne moraju da budu implementirane za sada, po potrebi 
	 * vracaju koordinate dela teksture
	 * 
	 * */
	@Override
	public float getTexX1() {
		// TODO Auto-generated method stub
		return frame.getMyCoords().getX1();
	}

	@Override
	public float getTexX2() {
		// TODO Auto-generated method stub
		return frame.getMyCoords().getX2();
	}

	@Override
	public float getTexY1() {
		// TODO Auto-generated method stub
		return frame.getMyCoords().getY1();
	}

	@Override
	public float getTexY2() {
		// TODO Auto-generated method stub
		return frame.getMyCoords().getY2();
	}
	@Override
	public float getAngle() {
		// TODO Auto-generated method stub
		return 0;
	}

}
