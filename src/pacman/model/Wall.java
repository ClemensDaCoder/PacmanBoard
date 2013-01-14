package pacman.model;


/** Represents a wall in Pacman.
 * 
 * @author mwe
 *
 */
public class Wall extends GridObject {
	
	/** Creates a new Wall object.
	 * 
	 * @param name
	 */
	public Wall(String name) {
		super(name);
	}
	
	/**
	 *  Creates a new Wall object.
	 */
	public Wall() {
		super("Wall");
	}

	
}