package game.dev.mechanics.building;

import game.dev.mechanics.requests.RequestConstants;

public class Expand1 extends Building {
	boolean isApplied=false;
	
	public Expand1() {
		super(RequestConstants.FIRSTEXPANDGOLD/4,
				RequestConstants.FIRSTEXPANDSTONE/4,
				RequestConstants.FIRSTEXPANDWOOD/4,
				RequestConstants.FIRSTEXPANDFOOD/4,
				false,
				RequestConstants.FIRSTEXPANDID);
		// TODO Auto-generated constructor stub
	}
	
	
	public void update(){
		applyEffect();
	}
	
	@Override
	public void applyEffect() {
		if(isApplied==false){
			myCity.setExpand1();
			isApplied=true;
			myCity.setPopCap(2000);
		}

	}

	@Override
	public void removeEffect() {
		// TODO Auto-generated method stub

	}

	
	
}
