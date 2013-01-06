package pacman.event;

import java.util.EventObject;

import pacman.model.move.MovingObject;

/** Indicates that a {@link MovingObject} could not move.
 */

public class MoveNotPossibleEvent extends EventObject {


	public MoveNotPossibleEvent(MovingObject movingObject) {
		super(movingObject);
	}
	
	public MovingObject getSource() {
		return (MovingObject) source;
	}

}
