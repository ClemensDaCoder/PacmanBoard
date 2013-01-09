package pacman.event;

import java.util.EventObject;

import pacman.model.Position;
import pacman.model.move.MovingObject;

public class MovingObjectPlacedEvent extends EventObject {

	private MovingObject mov;
	private Position pos;

	public MovingObjectPlacedEvent(MovingObject mov, Position pos) {
		super(mov);
		this.mov = mov;
		this.pos = pos;
	}

	public MovingObject getMov() {
		return mov;
	}

	public Position getPos() {
		return pos;
	}

}
