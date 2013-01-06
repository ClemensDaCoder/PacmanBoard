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


	public HasMovedEvent(Position oldPos, Position newPos, MovingObject mov) {
		super(mov);
		this.oldPosition = oldPos;
		this.newPosition = newPos;
		this.movingObject = mov;
	}

}
