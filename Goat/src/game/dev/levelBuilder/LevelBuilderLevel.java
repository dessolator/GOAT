package game.dev.levelBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static game.dev.engine.LoadTex.level;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import game.dev.engine.TextureHolder;
import game.dev.interfaces.Drawable;
import game.dev.interfaces.Updatable;
import game.dev.mechanics.blocks.Block;
import game.dev.mechanics.blocks.undeveloedBlocks.UndevelopedBlock;
import game.dev.mechanics.blocks.undeveloedBlocks.UndevelopedForest;
import game.dev.mechanics.blocks.undeveloedBlocks.UndevelopedGoldMine;
import game.dev.mechanics.blocks.undeveloedBlocks.UndevelopedLand;
import game.dev.mechanics.blocks.undeveloedBlocks.UndevelopedStone;
import game.dev.mechanics.city.City;
/**
 * @author Ivan Kesler
 *
 */
public class LevelBuilderLevel implements Updatable {
	private ArrayList<City> myCities;
	private ArrayList<Block> myBlocks;
	private static int initialX=40;
	private static int initialY=40;	
	private static Block selectedType;
	private static long keyTriggered=0l;
	private static float selCoordX;
    private static float selCoordY;
	public LevelBuilderLevel() {
		super();
		myBlocks=new ArrayList<Block>();
		myCities=new ArrayList<City>();
//		selectionType=new UndevelopedLand((int)(Math.random()*99), Mouse.getX(), Mouse.getY());
		selectedType=new UndevelopedLand((int)(Math.random()*99), initialX, initialY);

	}
	
	public void render() {
		for(City c:myCities){
			c.render();
		}
		for(Block b:myBlocks){
			b.render();
		}
		renderSelected();
	}

	



	private void renderSelected() {
		this.selectedType.setX(initialX);
		this.selectedType.setY(initialY);
		this.selectedType.render();
		
	}
	
	public void save(File saveFile){//DONE
        Document doc=new Document();
        Element root=new Element("bricks");
        doc.setRootElement(root);
        for(Block b:myBlocks){
        	Element block = null;
        	if(b instanceof UndevelopedLand){
        		block=new Element("land");
        	}
        	if(b instanceof UndevelopedStone){
        		block=new Element("stone");
        	}
        	if(b instanceof UndevelopedGoldMine){
        		block=new Element("gold");
        	}
        	if(b instanceof UndevelopedForest){
        		block=new Element("wood");
        	}                
        	block.setAttribute("coordX",String.valueOf(b.getX()));
        	block.setAttribute("coordY",String.valueOf(b.getY()));
        	block.setAttribute("myFactor",String.valueOf(((UndevelopedBlock)b).myFactor));
        	root.addContent(block);                        
        }
        for(City c:myCities){
        	Element block=new Element("city");
        	block.setAttribute("coordX",String.valueOf(c.getX()));
        	block.setAttribute("coordY",String.valueOf(c.getY()));
        	block.setAttribute("name",String.valueOf(c.myName));
        	root.addContent(block);                        
        }
        XMLOutputter out=new XMLOutputter();
        try {
                out.output(doc, new FileOutputStream(saveFile));
        } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        
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
	
	
	
	
	
	
	

	@Override
	public void update() {//DONE
//		if(Mouse.isButtonDown(0)){
//			selectedType.setX(Mouse.getX());
//			selectedType.setY(Mouse.getY());
//            deployBlock(selectedType);
//            
//	    }
		if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
            if((((long)System.nanoTime()-keyTriggered)>150000000)){//if time passed
                    keyTriggered=System.nanoTime();
                    selectedType.setX(initialX);
        			selectedType.setY(initialY);
                    deployBlock(selectedType);
                    
            }
    }
	    if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
	            if((((long)System.nanoTime()-keyTriggered)>150000000)){//if time passed
	                    keyTriggered=System.nanoTime();
	                    initialY+=80;
	            }
	    }
	    if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
            if((((long)System.nanoTime()-keyTriggered)>150000000)){//if time passed
                    keyTriggered=System.nanoTime();
                    initialY-=80;
            }
    }
	    if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
            if((((long)System.nanoTime()-keyTriggered)>150000000)){//if time passed
                    keyTriggered=System.nanoTime();
                    initialX-=80;
            }
    }
	    if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
            if((((long)System.nanoTime()-keyTriggered)>150000000)){//if time passed
                    keyTriggered=System.nanoTime();
                    initialX+=80;
            }
    }
	    if(Keyboard.isKeyDown(Keyboard.KEY_G)){
	            if((((long)System.nanoTime()-keyTriggered)>150000000)){//if time passed
	                    keyTriggered=System.nanoTime();
	                    selectedType=new UndevelopedLand((int)(Math.random()*99), Mouse.getX(), Mouse.getY());
	            }
	    }
	    if(Keyboard.isKeyDown(Keyboard.KEY_M)){
	            if((((long)System.nanoTime()-keyTriggered)>150000000)){//if time passed
	                    keyTriggered=System.nanoTime();
	                    selectedType=new UndevelopedGoldMine((int)(Math.random()*99), Mouse.getX(), Mouse.getY());
	            }
	    }
	    if(Keyboard.isKeyDown(Keyboard.KEY_S)){
	            if((((long)System.nanoTime()-keyTriggered)>150000000)){//if time passed
	                    keyTriggered=System.nanoTime();
	                    selectedType=new UndevelopedStone((int)(Math.random()*99), Mouse.getX(), Mouse.getY());
	            }
	    }
	    if(Keyboard.isKeyDown(Keyboard.KEY_F)){
	            if((((long)System.nanoTime()-keyTriggered)>150000000)){//if time passed
	                    keyTriggered=System.nanoTime();
	                    selectedType=new UndevelopedForest((int)(Math.random()*99), Mouse.getX(), Mouse.getY());
	            }
	    }
	    if(Keyboard.isKeyDown(Keyboard.KEY_C)){
            if((((long)System.nanoTime()-keyTriggered)>150000000)){//if time passed
                    keyTriggered=System.nanoTime();
                    selectedType=new City(Mouse.getX(), Mouse.getY(),"playerCity");
            }
    }
	    if(Keyboard.isKeyDown(Keyboard.KEY_T)){
	            if((((long)System.nanoTime()-keyTriggered)>150000000)){//if time passed
	                    keyTriggered=System.nanoTime();
	                    this.save(new File("level1.xml"));
	            }
	    }
	    if(Keyboard.isKeyDown(Keyboard.KEY_P)){
	            if((((long)System.nanoTime()-keyTriggered)>150000000)){//if time passed
	                    keyTriggered=System.nanoTime();
	                    this.load(new File("level1.xml"));
	            }
	    }
	
			
	}

	private void deployBlock(Block something) {//done
		if(something instanceof City){
			myCities.add((City)something);
			selectedType=new City(Mouse.getX(), Mouse.getY(),"playerCity");
			
		}else{
			myBlocks.add(something);
			if(something instanceof UndevelopedLand){
				selectedType=new UndevelopedLand((int)(Math.random()*99), Mouse.getX(), Mouse.getY());
        	}
        	if(something instanceof UndevelopedStone){
        		selectedType=new UndevelopedStone((int)(Math.random()*99), Mouse.getX(), Mouse.getY());
        	}
        	if(something instanceof UndevelopedGoldMine){
        		selectedType=new UndevelopedGoldMine((int)(Math.random()*99), Mouse.getX(), Mouse.getY());
        	}
        	if(something instanceof UndevelopedForest){
        		selectedType=new UndevelopedForest((int)(Math.random()*99), Mouse.getX(), Mouse.getY());
        	}                
			
		}
	}

	
}
