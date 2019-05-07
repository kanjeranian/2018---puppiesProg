package character;

import java.util.ArrayList;

import sun.security.jca.GetInstance;

public class AllGhost {
	private static AllGhost INSTANCE = new AllGhost();
	private ArrayList<Ghost> ghostsList;
	private AllGhost() {
		ghostsList = new ArrayList<>();
	}
	
	public static AllGhost getInstance() {
		return INSTANCE;
	}
	
	public static ArrayList<Ghost> getGhostsList(){
		return INSTANCE.ghostsList;
	}
	
	public static void addGhost(Ghost ghost){
		INSTANCE.ghostsList.add(ghost);
	}
	
	public static void updateGhostsList() {
		for(Ghost ghost: INSTANCE.ghostsList) {
			if(ghost.getHpValue()<=0) INSTANCE.ghostsList.remove(ghost);
		}
	}

}
