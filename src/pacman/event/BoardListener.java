package pacman.event;

import java.util.EventListener;

public interface BoardListener extends EventListener {

	public void hasmoved(HasMovedEvent e);

	/**
	 * Prints that the move is not possible
	 * 
	 * @param mov
	 */
	public void moveNotpossible(MoveNotPossibleEvent mov);

	public void scoreChanged(ScoreChangedEvent event);

	public void fruitwasplaced(FruitPlacedEvent event);

	public void nextLevel(NextLevelEvent event);
	
	public void movingobjectwasplaced(MovingObjectPlacedEvent event);

}
