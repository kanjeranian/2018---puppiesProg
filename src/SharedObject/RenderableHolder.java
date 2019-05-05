package SharedObject;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.Comparator;

public class RenderableHolder {
	
	private static final RenderableHolder instance = new RenderableHolder();
	
	private ArrayList<IRenderable> entities;
	private Comparator<IRenderable> comparator; //z-index 
	
	private RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if(o1.getZ()> o2.getZ()) return 1;
			return -1;
		};
	}

	
	public void add(IRenderable entity) {
		entities.add(entity);
//		Collections.sort(entities,comparator);
		entities.sort(comparator);
	}
	
	public void update() {
		for(IRenderable entity:entities) {
			if(entity.isDestroyed()) entities.remove(entity);
		}
	}
	
	public static RenderableHolder getInstance() {
		return instance;
	}


	public ArrayList<IRenderable> getEntities() {
		return entities;
	}
	
	public void clearEntities() {
		entities.clear();
	}
	
}
