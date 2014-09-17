package game.dev.mechanics.city;

import game.dev.engine.DrawObject;
import game.dev.engine.GameState;
import game.dev.interfaces.Drawable;
import game.dev.interfaces.Updatable;
import game.dev.mechanics.Game;
import game.dev.mechanics.blocks.Block;
import game.dev.mechanics.blocks.developedBlocks.DevelopedBlock;
import game.dev.mechanics.blocks.developedBlocks.GoldMine;
import game.dev.mechanics.blocks.developedBlocks.LumberMill;
import game.dev.mechanics.blocks.developedBlocks.Meadow;
import game.dev.mechanics.blocks.developedBlocks.Quarry;
import game.dev.mechanics.blocks.undeveloedBlocks.UndevelopedForest;
import game.dev.mechanics.blocks.undeveloedBlocks.UndevelopedGoldMine;
import game.dev.mechanics.blocks.undeveloedBlocks.UndevelopedLand;
import game.dev.mechanics.blocks.undeveloedBlocks.UndevelopedStone;
import game.dev.mechanics.building.Building;
import game.dev.mechanics.building.Church;
import game.dev.mechanics.building.Granary;
import game.dev.mechanics.building.Marketplace;
import game.dev.mechanics.building.Stables;
import game.dev.mechanics.building.Well;
import game.dev.mechanics.requests.ChurchRequest;
import game.dev.mechanics.requests.ExplorerRequest;
import game.dev.mechanics.requests.FirstExpandRequest;
import game.dev.mechanics.requests.GranaryRequest;
import game.dev.mechanics.requests.MarketPlaceRequest;
import game.dev.mechanics.requests.Request;
import game.dev.mechanics.requests.SecondExpandRequest;
import game.dev.mechanics.requests.StablesRequest;
import game.dev.mechanics.requests.WellRequest;
import game.dev.mechanics.units.Explorer;
import game.dev.mechanics.units.Unit;
import game.dev.sounds.SEngine;
import static game.dev.engine.LoadTex.city;
import static game.dev.mechanics.requests.RequestConstants.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.newdawn.slick.opengl.Texture;

public class City extends Block{
//	private static boolean isInited = false;
	private float taxRate=0.5f;
	private int foodCap=1000;
	
	private int wood= STARTWOOD;
	private int stone = STARTSTONE;
	private int food = STARTFOOD;
	private int gold = STARTGOLD;
	
	public int happiness = STARTHAPPINESS; //current happiness
	private int population = STARTPOPULATION;
	private ArrayList<DevelopedBlock> myDevelopedBlocks;
	public String myName;
	private ArrayList<Building> myBuildings;
	private ArrayList<Unit> myUnits;
	private ArrayList<Request> buildable;
	private ArrayList<Request> recruitable;
	private Queue<Request> myProductionQueue;
	private boolean firstExpand=false;
	private boolean secondExpand=false;
	
	private boolean haveChurch = false;
	private boolean haveGranary = false;
	private boolean haveMarketPlace= false;
	private boolean haveStables = false;
	private boolean haveWell = false;
	private boolean init=false;
	private boolean isRiot=false;
	private boolean isWinter=false;
	
	private boolean badEvent=false;
	private int popCap=1000;
	private int turnCounter=0;
	
	private int foodIncome=0;
	private int woodIncome=0;
	private int stoneIncome=0;
	private int goldIncome=0;
	
	public City (float coordX,float coordY,String name){
		super(coordX, coordY, city);
		myDevelopedBlocks=new ArrayList<DevelopedBlock>();
		myBuildings=new ArrayList<Building>();
		myUnits = new ArrayList<Unit>();
		myProductionQueue = new LinkedList<Request>();
		buildable=new ArrayList<Request>();
		recruitable= new ArrayList<Request>();
		myName=name;
		buildable.add(new GranaryRequest());
		buildable.add(new StablesRequest());
		buildable.add(new WellRequest());
		buildable.add(new FirstExpandRequest());
		recruitable.add(new ExplorerRequest());
		myTextureHolder=city;
	}
	
	public void render(){
		DrawObject.draw(this);
		for(int j=0;j<myDevelopedBlocks.size();j++){
			myDevelopedBlocks.get(j).render();
		}
		for(int i=0;i<myUnits.size();i++){
			myUnits.get(i).render();
		}
	}
//	public boolean buyBuilding(Request r){
//		return addToQueue(r);
//	}
//	
//	public boolean buyUnit(Request r){
//		return addToQueue(r);
//	}
	
	public boolean addToQueue(Request r){
		if(r.getReqWood()>wood) return false;
		if(r.getReqStone()>stone)return false;
		if(r.getReqFood()>food)return false;
		if(r.getReqGold()>gold)return false;
		wood-=r.getReqWood();
		stone-=r.getReqStone();
		food-=r.getReqFood();
		gold-=r.getReqGold();

		updateStatus();

		myProductionQueue.add(r);

		return true;
	}
	
	public String getName(){return myName;}
	

	public boolean sellBuilding(Building b){
		if (!b.isSellable())return false;
		gold+=b.getSellGold();
		wood+=b.getSellWood();
		stone+=b.getSellStone();
		for(int i=0; i<myBuildings.size();i++){
			if(myBuildings.get(i)==b){
				myBuildings.get(i).removeEffect();
				myBuildings.remove(i);//TODO when building removed bonus must disappear;
				i--;
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Request> getBuildingsICanBuild(){
		return buildable;
	}
	
	public ArrayList<Request> getUnitsICanMake(){
		return recruitable;
	}
	
	//Update
	public void update(){
		EventGenerator(); //bind events
		if(!init){
			new Explorer().create(this);
			init=true;
		}
		for(int i=0;i<myDevelopedBlocks.size();i++){
			myDevelopedBlocks.get(i).update();
		}
		for(int j=0;j<myBuildings.size();j++){
			myBuildings.get(j).update();
		}	
		calcTaxes();
		
		if(isWinter)foodIncome*=0.25f;
		if(isRiot){
			float f = 0.5f;
			if(haveChurch)f=0.7f;
			woodIncome*=f;
			foodIncome*=f;
			stoneIncome*=f;
			goldIncome*=f;
		}
		wood+=woodIncome;
		food+=foodIncome;
		stone+=stoneIncome;
		gold+=goldIncome;
		
		updateHappiness();
		updatePopulation();
		updateQueue();
		getExplorer().resetTurns();
		updateStatus();
		
		
	}
	
	public void updateStatus(){
		Game.getMyLevel().getGui().getStatusFrame().updateFood(food);
		Game.getMyLevel().getGui().getStatusFrame().updateWood(wood);
		Game.getMyLevel().getGui().getStatusFrame().updateStone(stone);
		Game.getMyLevel().getGui().getStatusFrame().updateGold(gold);
		Game.getMyLevel().getGui().getStatusFrame().updateHappiness(happiness);
		Game.getMyLevel().getGui().getStatusFrame().updatePopulation(population);
		
	}
	
	
	public void updateUnits(){
		for(Unit u:myUnits){
			u.update();//basically read player input
		}
	}
	private void updatePopulation() {
		population= (int) ((int)population * 1.2f);
	}

	private void calcTaxes(){
		gold+=(population*taxRate*0.1f);
	}
	
	private void updateHappiness(){
		if(food>population)happiness++;
		if(getChurch()){happiness=happiness+3;}
		if(getMarketPlace()){happiness=happiness+2;}
		if(food<population)happiness=happiness-10;
		if(badEvent){happiness=happiness-10;badEvent=false;}
		if(population>popCap)happiness=happiness-10;

				
	}
	
	private void updateQueue(){
		for(Request re : myProductionQueue){
			re.setRemainingTurns(re.remainingTurns()-1);
		}
		Request r = myProductionQueue.peek();
		if(r!=null){
			if (r.remainingTurns()==0){ //if I complete on this turn create me
				r=myProductionQueue.poll();
				r.create(this);
			}
		}

	}
	
	public void setTaxRate(float val){
		if(val>1)taxRate=1;
		if(val<=0)taxRate=0;
		if(0<val && val<1)taxRate=val;
		Game.getMyLevel().getGui().getStatusFrame().updateTaxrate(taxRate);
	}



	public void addBlock(DevelopedBlock b){
		myDevelopedBlocks.add(b);
	}
	
	public void addBuilding(Building b){
		myBuildings.add(b);
	}
	
	public void addUnit(Unit u){
		myUnits.add(u);
	}
	
	public ArrayList<Unit> getUnits(){
		return myUnits;
	}
	
	public ArrayList<Building> getBuildings(){
		return myBuildings;
	}

	public void changeWood(int inc){
		woodIncome+=inc;
	}

	public void changeStone(int inc){
		stoneIncome+=inc;
	}

	public void changeFood(int inc){
		foodIncome+=inc;
	}

	public void changeGold(int inc){
		goldIncome+=inc;
	}


	public boolean removeRequest(Request request) {
		myProductionQueue.poll();
		return true;
	}

	@Override
	public void develop(City myCity) {}

	public void addBuildable(Request r) {
		buildable.add(r);
	}

	public void incFoodCap(int i) {
		foodCap+=i;
		
	}

	public void incHappiness(int inc){
		happiness+=inc;
	}
	
	public void riotCheck(){ //TODO implement properly
		if(happiness>=50) isRiot=false;
		if(happiness<15){
			isRiot=true;
			riot();SEngine.getSoundSystem().play("protest");
			Game.getMyLevel().getGui().getNotificationFrame().setNotification("Riot has struck your town. -50% production"); // TODO need 30% version too
			if(Math.random()>0.95){
				SEngine.getSoundSystem().play("protest");
				Game.getMyLevel().getGui().getNotificationFrame().setNotification("You have lost the game.");
				Game.setCurrentGameState(GameState.GameOver);
			}
		}
		if(happiness==0){
			SEngine.getSoundSystem().play("protest"); 
			Game.setCurrentGameState(GameState.GameOver);
			Game.getMyLevel().getGui().getNotificationFrame().setNotification("You have lost the game.");
			}

	}

	
	public void EventGenerator(){
		turnCounter++;
		if(turnCounter==0)setWinter(false);
		if(turnCounter==4){
			turnCounter=turnCounter%4;
			setWinter(true);
		}
		double factor=Math.random();
		if (factor>0.15 && factor<=0.2) {
			plague();
			
		}
		if (factor>0.75 && factor<=0.8) {
			riot();
		}
		if(factor>0.3 && factor <= 0.35){
			flood();
		}
		if(factor>0.55 && factor <=0.6){
			earthQuake();
		}
		if(factor>0.35 && factor <=0.4 ){
			banditAttack();
		}
		if(factor>0.2 && factor <=0.25){
			tradeCaravan();
		}
	}
	
	private void setWinter(boolean b) {
		isWinter = b;
		
	}


	public void plague(){
		population -= (int)(0.15*population);
		Game.getMyLevel().getGui().getNotificationFrame().setNotification("Plague has struck your town. -15% pop loss.");
		SEngine.getSoundSystem().play("plague");
	}
	
	public void riot(){
		goldIncome =  (int)(0.5*goldIncome);
		stoneIncome = (int)(0.5*stoneIncome);
		woodIncome = (int)(0.5*woodIncome);
		foodIncome = (int)(0.5*foodIncome);		
	}
	
	public void flood(){
		int factor = (int)(Math.random()*(myDevelopedBlocks.size()));	
		if(factor>0){
			if(myDevelopedBlocks.get(factor) instanceof Meadow){
				Game.getMyLevel().getMyBlocks().add(new UndevelopedLand(myDevelopedBlocks.get(factor).myFactor, myDevelopedBlocks.get(factor).getX(), myDevelopedBlocks.get(factor).getY()));
			}
			if(myDevelopedBlocks.get(factor) instanceof Quarry){
				Game.getMyLevel().getMyBlocks().add(new UndevelopedStone(myDevelopedBlocks.get(factor).myFactor, myDevelopedBlocks.get(factor).getX(), myDevelopedBlocks.get(factor).getY()));
			}
			if(myDevelopedBlocks.get(factor) instanceof GoldMine){
				Game.getMyLevel().getMyBlocks().add(new UndevelopedGoldMine(myDevelopedBlocks.get(factor).myFactor, myDevelopedBlocks.get(factor).getX(), myDevelopedBlocks.get(factor).getY()));
			}
			if(myDevelopedBlocks.get(factor) instanceof LumberMill){
				Game.getMyLevel().getMyBlocks().add(new UndevelopedForest(myDevelopedBlocks.get(factor).myFactor, myDevelopedBlocks.get(factor).getX(), myDevelopedBlocks.get(factor).getY()));
			}
			myDevelopedBlocks.remove(factor);
		}
		Game.getMyLevel().getGui().getNotificationFrame().setNotification("Flood has destroyed crops and flooded mines.");
		SEngine.getSoundSystem().play("flood");
	}
	
	public void earthQuake(){
		int factor = (int)(Math.random()*myBuildings.size());
		if(factor>0){
			if(myBuildings.get(factor) instanceof Church){
				buildable.add(new ChurchRequest());
			}
			if(myBuildings.get(factor) instanceof Marketplace){
				buildable.add(new MarketPlaceRequest());
			}
			if(myBuildings.get(factor) instanceof Well){
				buildable.add(new WellRequest());
			}
			if(myBuildings.get(factor) instanceof Granary){
				buildable.add(new GranaryRequest());
			}
			if(myBuildings.get(factor) instanceof Stables){
				buildable.add(new StablesRequest());
			}
		
			myBuildings.get(factor).removeEffect();
			myBuildings.remove(factor);
		}
		Game.getMyLevel().getGui().getNotificationFrame().setNotification("An Earthquake has destroyed a building inside your town.");
		SEngine.getSoundSystem().play("earthquake");
		happiness -= 5;
	}
	
	public void banditAttack(){
		int factor = (int)(Math.random()*myDevelopedBlocks.size());	
		if(factor>0){
			if(myDevelopedBlocks.get(factor) instanceof Meadow){
				Game.getMyLevel().getMyBlocks().add(new UndevelopedLand(myDevelopedBlocks.get(factor).myFactor, myDevelopedBlocks.get(factor).getX(), myDevelopedBlocks.get(factor).getY()));
			}
			if(myDevelopedBlocks.get(factor) instanceof Quarry){
				Game.getMyLevel().getMyBlocks().add(new UndevelopedStone(myDevelopedBlocks.get(factor).myFactor, myDevelopedBlocks.get(factor).getX(), myDevelopedBlocks.get(factor).getY()));
			}
			if(myDevelopedBlocks.get(factor) instanceof GoldMine){
				Game.getMyLevel().getMyBlocks().add(new UndevelopedGoldMine(myDevelopedBlocks.get(factor).myFactor, myDevelopedBlocks.get(factor).getX(), myDevelopedBlocks.get(factor).getY()));
			}
			if(myDevelopedBlocks.get(factor) instanceof LumberMill){
				Game.getMyLevel().getMyBlocks().add(new UndevelopedForest(myDevelopedBlocks.get(factor).myFactor, myDevelopedBlocks.get(factor).getX(), myDevelopedBlocks.get(factor).getY()));
			}
			myDevelopedBlocks.remove(factor);
		}
		population-=(int)(0.05*population);
		Game.getMyLevel().getGui().getNotificationFrame().setNotification("Bandits have destroyed your fields and killed 5% of your population.");
	}
	
	public void tradeCaravan(){
		gold += 5;
		food += 10;
		wood += 30;
		stone += 20;
	}

	

	
	
	public void haveChurch(boolean b){
		haveChurch=b;
		}


	public void haveGranary(boolean b) {
		haveGranary = b;
		
	}


	public void haveMarketPlace(boolean b) {
		haveMarketPlace = b;
		
	}
	
	public void haveStables(boolean b){
		haveStables = b;
	}


	public void haveWell(boolean b) {
		haveWell=b;
	}
	public boolean getChurch(){
		return haveChurch;
	}
	public boolean getGranary(){
		return haveGranary;
	}
	public boolean getMarketPlace(){
		return haveMarketPlace;
	}
	public boolean getStables(){
		return haveStables;
	}
	
	public void setExpand1(){
		firstExpand=true;
	}
	
	public void setExpand2(){
		secondExpand=true;
	}
	
	public void setPopCap(int asd){
		popCap=asd;
	}

	public Explorer getExplorer() {
		return (Explorer)myUnits.get(0);//UGLYYYYYYYYYYYYYYYYYYYYY
	}

	public ArrayList<DevelopedBlock> getMyBlocks() {
		return myDevelopedBlocks;
	}
	
}
