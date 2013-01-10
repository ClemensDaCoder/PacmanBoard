package pacman.event;

import java.util.EventListener;

import pacman.model.Board;
import pacman.model.bonus.Fruit;
import pacman.model.move.MovingObject;

public interface BoardListener extends EventListener {

	/** Called when a {@link MovingObject} has moved.
	 * @param e
	 */
	public void hasmoved(HasMovedEvent e);

	/** Called when a move of a {@link MovingObject} is not possible.
	 * 
	 * @param mov
	 */
	public void moveNotpossible(MoveNotPossibleEvent mov);

	/** Called when the game score is changed.
	 * 
	 * @param event
	 */
	public void scoreChanged(ScoreChangedEvent event);

	/** Called when a {@link Fruit} is placed on the {@link Board}.
	 * @param event
	 */
	public void fruitwasplaced(FruitPlacedEvent event);

	/** Called when a level is finished.
	 * @param event
	 */
	public void nextLevel(NextLevelEvent event);
	
	/** Called when a {@link MovingObject} is placed on the {@link Board}.
	 * @param event
	 */
	public void movingobjectwasplaced(MovingObjectPlacedEvent event);

}
