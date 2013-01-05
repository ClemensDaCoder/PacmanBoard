package pacman.event;

import pacman.model.Position;
import pacman.model.move.MovingObject;


public class HasmovedEvent extends java.util.EventObject {


	public HasmovedEvent(Position oldPos, Position newPos, MovingObject mov){
		super(mov);
	}

}
