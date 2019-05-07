package SharedObject;

import java.util.ArrayList;

import character.Ghost;
import character.Puppy;
import item.Item;

public class SharedObject {

	//field
	private static ArrayList<Ghost> ghostsList = new ArrayList<Ghost>();
	private static ArrayList<Puppy> puppiesList = new ArrayList<Puppy>();
	private static ArrayList<Item> itemsList = new ArrayList<Item>();
	
	//constructor
	public SharedObject() {} 

	//method
	public static void update() {
		// delete destroy objected inList
		updatePuppiesList();
		updateGhostsLis();
		updateItemsList();
	}
	
	public static ArrayList<Ghost> getGhostsList() {
		return ghostsList;
	}

	public static ArrayList<Puppy> getPuppiesList() {
		return puppiesList;
	}

	public static ArrayList<Item> getItemsList() {
		return itemsList;
	}
	
	public static void addToGhostsList(Ghost ghost) {
		getGhostsList().add(ghost);
	}
	
	public static void addToPuppiesList(Puppy puppy) {
		getPuppiesList().add(puppy);
	}
	
	public static void addToItemsList(Item item) {
		getItemsList().add(item);
	}
	
	public static void updateGhostsLis() {
		for(Ghost ghost: getGhostsList()) {
			if(ghost.isDestroyed()) getGhostsList().remove(ghost);
		}
	}
	
	public static void updatePuppiesList() {
		for(Puppy puppy: getPuppiesList()) {
			if(puppy.isDestroyed()) getPuppiesList().remove(puppy);
		}
	}
	
	public static void updateItemsList() {
		for(Item item: getItemsList()) {
			if(item.isDestroyed()) getItemsList().remove(item);
		}
	}
	
	
	
 
}
