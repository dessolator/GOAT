package game.dev.mechanics.building;

import game.dev.mechanics.requests.RequestConstants;

public class Expand2 extends Building {
	boolean isApplied=false;
	
	public Expand2() {
		super(RequestConstants.SECONDEXPANDGOLD/4,
				RequestConstants.SECONDEXPANDSTONE/4,
				RequestConstants.SECONDEXPANDWOOD/4,
				RequestConstants.SECONDEXPANDFOOD/4,
				false,
				RequestConstants.SECONDEXPANDID);
		// TODO Auto-generated constructor stub
	}
	
	
	public void update(){
		applyEffect();
	}
	
	@Override
	public void applyEffect() {
		if(isApplied==false){
			myCity.setExpand2();
			isApplied=true;
			myCity.setPopCap(5000);
		}

	}

	@Override
	public void removeEffect() {
		// TODO Auto-generated method stub

	}

	
	
}

