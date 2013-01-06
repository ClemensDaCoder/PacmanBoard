package pacman.model;

/** All objects that can occur on a {@link Field}
 * @author mwe
 *
 */
public abstract class GridObject {
	
	private String name;
	
	public GridObject(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return getName();
	}
	
	
}