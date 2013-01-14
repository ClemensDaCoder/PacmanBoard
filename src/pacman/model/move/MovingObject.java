package pacman.model.move;

import pacman.model.Direction;
import pacman.model.GridObject;
import pacman.model.Position;

/** Abstract super class for all objects that can move in Pacman.
 * 
 * @author mwe
 *
 */
public abstract class MovingObject extends GridObject {
	
	private Position currentPosition;
	private MovingStrategy movingStrategy;
	
	/** Creates a new MovingObject.
	 * 
	 * @param position
	 * @param name
	 * @param movingStrategy
	 */
	public MovingObject(Position position, String name, MovingStrategy movingStrategy) {
		super(name);
		this.currentPosition = position;
		this.movingStrategy = movingStrategy;
	}

	/**
	 * @return current {@link Position} of MovingObject.
	 */
	public Position getCurrentPosition() {
		return currentPosition;
	}

	/** Sets the current {@link Position} of MovingObject.
	 * 
	 * @param currentPosition
	 */
	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}	
	
	/**
	 * @return the {@link Direction} the MovingObject is heading.
	 */
	public Direction getMoveDirection() {
		return movingStrategy.getMoveDirection();
	}
	
}