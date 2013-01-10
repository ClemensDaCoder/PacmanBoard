package pacman.event;

import java.util.EventObject;

import pacman.model.Position;
import pacman.model.move.MovingObject;

public class HasMovedEvent extends EventObject {

	Position oldPosition;
	Position newPosition;
	MovingObject movingObject;

	/** Creates a new HasMovedEvent.
	 * 
	 * @param oldPosition
	 * @param newPosition
	 * @param movingObject
	 */
	public HasMovedEvent(Position oldPosition, Position newPosition, MovingObject movingObject) {
		super(movingObject);
		this.oldPosition = oldPosition;
		this.newPosition = newPosition;
		this.movingObject = movingObject;
	}
	
	/**
	 * @return the old {@link Position} of the {@link MovingObject}.
	 */
	public Position getOldPos() {
		return oldPosition;
	}

	/**
	 * @return the new {@link Position} of the {@link MovingObject}.
	 */
	public Position getNewPos() {
		return newPosition;
	}

	/**
	 * @return the {@link MovingObject} that has moved.
	 */
	public MovingObject getMov() {
		return movingObject;
	}

}
