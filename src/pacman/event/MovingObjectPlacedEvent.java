package pacman.event;

import java.util.EventObject;

import pacman.model.Board;
import pacman.model.Position;
import pacman.model.move.MovingObject;

public class MovingObjectPlacedEvent extends EventObject {

	private MovingObject mov;
	private Position pos;

	/** Creates a new MovingObjectPlacedEvent.
	 * 
	 * @param mov
	 * @param pos
	 */
	public MovingObjectPlacedEvent(MovingObject mov, Position pos) {
		super(mov);
		this.mov = mov;
		this.pos = pos;
	}

	/**
	 * @return the {@link MovingObject} that has been placed on the {@link Board}.
	 */
	public MovingObject getMov() {
		return mov;
	}

	/**
	 * @return the {@link Position} the {@link MovingObject} that has been placed on the {@link Board}.
	 */
	public Position getPos() {
		return pos;
	}

}
