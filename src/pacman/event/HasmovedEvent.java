package pacman.event;

import pacman.model.Position;
import pacman.model.move.MovingObject;


public class HasmovedEvent extends java.util.EventObject {

	Position oldPos;
	Position newPos;
	MovingObject mov;
	
	public Position getOldPos() {
		return oldPos;
	}

	public Position getNewPos() {
		return newPos;
	}

	public MovingObject getMov() {
		return mov;
	}

	
	
	private static final long serialVersionUID = 1L;

	public HasmovedEvent(Position oldPos, Position newPos, MovingObject mov){
		super(mov);
	}

}
