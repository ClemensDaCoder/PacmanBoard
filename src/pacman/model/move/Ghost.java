package pacman.model.move;

import pacman.model.Position;

/** Represents a Ghost.
 * 
 * @author mwe
 *
 */
public class Ghost extends MovingObject {
	
	/** Creates a new Ghost object.
	 * 
	 * @param position
	 * @param name
	 * @param movingStrategy
	 */
	public Ghost(Position position, String name, MovingStrategy movingStrategy) {
		super(position, name, movingStrategy);
	}	
}