package pacman.model.move;

import pacman.model.Direction;

/** Provides a move direction for moving objects.
 *  Different implementations provide different moving strategies.
 *  A special implementation would allow human input.
 *  
 * @author mwe
 *
 */
public interface MovingStrategy {
	
	public Direction getMoveDirection();

}
