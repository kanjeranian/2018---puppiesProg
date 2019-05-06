package character;

public interface Fightable {
	//func ทำลายคู่ต่อสู้
	//func โดนทำลาย
	//func ตาย
	public void destroy(Fightable target);
	public void wasDestroyed();

}
