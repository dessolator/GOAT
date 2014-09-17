package game.dev.mechanics;

import java.io.File;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import static game.dev.engine.LoadTex.level;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import game.dev.engine.DrawObject;
import game.dev.engine.Engine;
import game.dev.engine.TextureHolder;
import game.dev.gui.GameUserInterface;
import game.dev.interfaces.Drawable;
import game.dev.interfaces.Updatable;
import game.dev.mechanics.blocks.Block;
import game.dev.mechanics.blocks.undeveloedBlocks.UndevelopedForest;
import game.dev.mechanics.blocks.undeveloedBlocks.UndevelopedGoldMine;
import game.dev.mechanics.blocks.undeveloedBlocks.UndevelopedLand;
import game.dev.mechanics.blocks.undeveloedBlocks.UndevelopedStone;
import game.dev.mechanics.city.City;
import game.dev.sounds.SEngine;
/**
 * @author Ivan Kesler
 *
 */
public class Level implements Drawable,Updatable {
	private TextureHolder th;
	private ArrayList<City> myCities;
	private ArrayList<Block> myBlocks;
	private GameUserInterface myUserInterface;
	boolean endOfTurn=false;
	private static final int numOfGoldMines=24;
	private static final int numOfLand = 40;
	private static final int numOfForest = 40;
	private static final int numOfStone = 40;
	private static int gCnt=0;
	private static int lCnt=0;
	private static int fCnt=0;
	private static int sCnt=0;
	private static Random r = new Random(2000);
	
	
	@Override
	public void render() {
//		DrawObject.draw(this);
		
		for(int i=0;i<myBlocks.size();i++){
			myBlocks.get(i).render();
		}
		for(int j=0;j<myCities.size();j++){
			myCities.get(j).render();
		}
		myUserInterface.render();
	}

	

	public Level() {
		super();
		th=level;
		myBlocks=new ArrayList<Block>();
		myCities=new ArrayList<City>();
		myUserInterface=new GameUserInterface();
		//test
		load(new File("level1.xml"));
		//myBlocks.remove(myBlocks.size()/2);
		//myBlocks.add(new City(640, 400, "MudoVille"));
		
	}
	
	public GameUserInterface getGui() {
		return myUserInterface;
	}
	
	public Block randomBlock(int i, int j){		
		double r=Math.random();
		double d=Math.random();
		if(640 == i && 400 == j) myBlocks.add(new City(640,400,"MudoVille"));
		if(r<0.35){
			return new UndevelopedLand((int)d*1000,i,j);
		}
		if(r>=0.35&& r<0.7){
			return new UndevelopedForest((int)d*1000,i,j);
		}
		if(r>=0.7&&r<0.9){
			return new UndevelopedStone((int)d*1000,i,j);
		}
		if(r>=0.9){
			return new UndevelopedGoldMine((int)d*1000,i,j);
		}
//		Random rn = new Random();
//		int n = 3 - 0 + 1;
//		int z = rn.nextInt() % n;
//		int randomNum =  0 + z;	
//		int choice = randomNum;
//		System.out.println("choice:"+choice);
//		
//		
//		double d = r.nextDouble();
//		System.out.println(lCnt+" "+fCnt+" "+sCnt+" "+gCnt);
//		System.out.println(d);
//		int k=0;
//		while(true){
//			System.out.println("choice:"+choice);
//			
//			
//			if(choice==0 && lCnt<40){
//				lCnt++;
//				return new UndevelopedLand((int)d*1000,i,j);
//			}
//			if(choice==1 && fCnt<40){
//				fCnt++;
//				return new UndevelopedForest((int)d*1000,i,j);
//			}
//			if(choice==2 && sCnt<40){
//				sCnt++;
//				return new UndevelopedStone((int)d*1000,i,j);
//			}
//			if(choice==3 && gCnt<24){
//				gCnt++;
//				return new UndevelopedGoldMine((int)d*1000,i,j);
//			}
//			
//			if(lCnt>39 && fCnt>39 && sCnt>39 && gCnt>23) System.out.println("all fields created (Error?)");
//		}
		
		myBlocks.remove(myBlocks.size()/2);
		myCities.add(new City(640, 400, "MudoVille"));
		return null;
	}

	@Override
	public void update() {
		for(City c:myCities){
			c.update();
		}
		if(myCities.get(0).happiness<=0)
			System.exit(0);
		for(Block b:myBlocks){
			b.update();
		}
		while(!endOfTurn &&!Display.isCloseRequested()){
			glClear(GL_COLOR_BUFFER_BIT);
			
			
			render();
			Display.update();
			Display.sync(60);
			for(City c:myCities){
				c.updateUnits();
				myUserInterface.update();
				if(Display.isCloseRequested()){
					Engine.kill();
					SEngine.dispose();
					System.exit(0);
				}
			}
			
			
		}
		if(Display.isCloseRequested()){
			Engine.kill();
			System.exit(0);
		}
		endOfTurn=false;
		
		
		
	}
	
	@Override
	public Texture getTexture() {
		return th.getMyTexture();
	}
	@Override
	public float getX() {
		return Display.getWidth()/2;
	}

	@Override
	public float getY() {
		return Display.getHeight()/2;
	}

	@Override
	public float getDimX() {
		return Display.getWidth();
	}

	@Override
	public float getDimY() {
		return Display.getHeight();
	}

	@Override
	public float getTexX1() {
		return th.getMyCoords().getX1();
	}

	@Override
	public float getTexX2() {
		return th.getMyCoords().getX2();
	}

	@Override
	public float getTexY1() {
		return th.getMyCoords().getY1();
	}

	@Override
	public float getTexY2() {
		return th.getMyCoords().getY2();
	}

	@Override
	public float getAngle() {
		return 0;
	}



	public boolean removeBlock(Block b) {
		for(int i=0;i<myBlocks.size();i++){
			if(myBlocks.get(i)==b){
				myBlocks.remove(i);
				i--;
				return true;
			}
		}
		return false;
	}



	


	public ArrayList<Block> getMyBlocks() {
		return myBlocks;
	}
	public void load(File loadFile){//DONE
        myBlocks=new ArrayList<Block>();//init bricks.
        SAXBuilder reader=new SAXBuilder();
        Document doc=null;
        try {
                doc = reader.build(loadFile);
        } catch (JDOMException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
        } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
        }
        Element root=doc.getRootElement();
        for(Element e:root.getChildren()){
        	float coordX=Float.parseFloat(e.getAttributeValue("coordX"));
        	float coordY=Float.parseFloat(e.getAttributeValue("coordY"));
    		if(e.getName().equals("city")){
    			String name=e.getAttributeValue("name");
    			myCities.add(new City(coordX,coordY,name));
    		}
    		if(e.getName().equals("wood")){
    			int myFactor=Integer.parseInt(e.getAttributeValue("myFactor"));
    			myBlocks.add(new UndevelopedForest(myFactor,coordX,coordY));
    			//add a wood to blocks
    		}
    		if(e.getName().equals("gold")){
    			int myFactor=Integer.parseInt(e.getAttributeValue("myFactor"));
    			myBlocks.add(new UndevelopedGoldMine(myFactor,coordX,coordY));//add a gold to blocks
    		}
    		if(e.getName().equals("stone")){
    			int myFactor=Integer.parseInt(e.getAttributeValue("myFactor"));
    			myBlocks.add(new UndevelopedStone(myFactor,coordX,coordY));
    			//add a stone to blocks
    		}
    		if(e.getName().equals("land")){
    			int myFactor=Integer.parseInt(e.getAttributeValue("myFactor"));
    			myBlocks.add(new UndevelopedLand(myFactor,coordX,coordY));
    			//add a land to blocks
    		}
        }
}



	public City getMyCity() {
		return myCities.get(0);
	}

}
