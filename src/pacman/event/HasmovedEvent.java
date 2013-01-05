package pacman.event;

import pacman.model.Position;
import pacman.model.move.MovingObject;


public class HasmovedEvent extends java.util.EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HasmovedEvent(Position oldPos, Position newPos, MovingObject mov){
		super(mov);
	}

}
