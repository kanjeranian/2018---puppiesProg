package SharedObject;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.Comparator;

public class RenderableObj {
	
	private static final RenderableObj instance = new RenderableObj();
	
	private ArrayList<Renderable> entities;
	private Comparator<Renderable> comparator; //z-index 
	
	private RenderableObj() {
		entities = new ArrayList<Renderable>();
		comparator = (Renderable o1, Renderable o2) -> {
			if(o1.getZ()> o2.getZ()) return 1;
			return -1;
		};
	}

	
	public void add(Renderable entity) {
		entities.add(entity);
		entities.sort(comparator);
	}
	
	public void update() {
		for(Renderable entity:entities) {
			if(entity.isDestroyed()) entities.remove(entity);
		}
	}
	
	public static RenderableObj getInstance() {
		return instance;
	}


	public ArrayList<Renderable> getEntities() {
		return entities;
	}
	
	public void clearEntities() {
		entities.clear();
	}
	
}
