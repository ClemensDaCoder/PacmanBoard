package pacman.model.move;

import pacman.model.Position;


/** Represents Pacman.
 * 
 * @author mwe
 *
 */
public class PacMan extends MovingObject {
	
	/** Creates a new PacMan object.
	 * 
	 * @param position
	 * @param name
	 * @param movingStrategy
	 */
	public PacMan(Position position, String name, MovingStrategy movingStrategy) {
		super(position, name, movingStrategy);
	}
	
}