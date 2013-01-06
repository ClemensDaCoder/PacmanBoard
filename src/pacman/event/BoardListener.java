package pacman.event;

import java.util.EventListener;

public interface BoardListener extends EventListener {

	public void hasmoved(HasmovedEvent e);

	/**
	 * Prints, that the move is not possible
	 * 
	 * @param mov
	 */
	public void moveNotpossible(MoveNotPossibleEvent mov);

	public void scoreChanged(ScoreChangedEvent event);

	public void fruitwasplaced(FruitPlacedEvent event);

	public void nextLevel(NextLevelEvent event);

}
