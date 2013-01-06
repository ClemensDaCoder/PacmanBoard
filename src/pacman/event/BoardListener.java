package pacman.event;

import java.util.EventListener;

public interface BoardListener extends EventListener{
	
	void hasmoved(HasmovedEvent e);
	
	/**
	 * Prints, that the move is not possible
	 * @param mov
	 */
	void moveNotpossible(MoveNotPossibleEvent mov);
	
	void scoreChanged(ScoreChangedEvent event);
	
	void fruitwasplaced(FruitPlacedEvent event);
	
	void nextLevel(NextLevelEvent event);
	
}
