package pacman.event;

import java.util.EventObject;

import pacman.model.move.MovingObject;

/** Indicates that a {@link MovingObject} could not move.
 */

public class MoveNotPossibleEvent extends EventObject {


	MovingObject movingObject;

	/**
	 * 
	 * @return a {@link MovingObject} that cannot move
	 */
	public MovingObject getMovingObject() {
		return movingObject;
	}

	public MoveNotPossibleEvent(MovingObject movingObject) {
		super(movingObject);
		this.movingObject = movingObject;
	}

}
