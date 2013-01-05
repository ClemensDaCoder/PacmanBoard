package pacman.event;

import java.util.EventListener;

import pacman.event.HasmovedEvent;
import pacman.model.move.MovingObject;


public interface BoardListener extends EventListener{
	
	void hasmoved(HasmovedEvent e);
	
	/**
	 * Prints, that the move is not possible
	 * @param mov
	 */
	void moveNotpossible(MoveNotPossibleEvent mov);
	
}
