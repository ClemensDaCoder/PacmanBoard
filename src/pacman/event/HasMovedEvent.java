package pacman.event;

import java.util.EventObject;

import pacman.model.Position;
import pacman.model.move.MovingObject;

public class HasMovedEvent extends EventObject {

	Position oldPosition;
	Position newPosition;
	MovingObject movingObject;

	public Position getOldPos() {
		return oldPosition;
	}

	public Position getNewPos() {
		return newPosition;
	}

	public MovingObject getMov() {
		return movingObject;
	}


	public HasMovedEvent(Position oldPosition, Position newPosition, MovingObject movingObject) {
		super(movingObject);
		this.oldPosition = oldPosition;
		this.newPosition = newPosition;
		this.movingObject = movingObject;
	}

}
