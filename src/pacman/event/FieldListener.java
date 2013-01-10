package pacman.event;

import java.util.EventListener;

import pacman.model.bonus.BonusObject;
import pacman.model.move.Ghost;
import pacman.model.move.PacMan;

public interface FieldListener extends EventListener {

	/** Called when a {@link BonusObject} has been eaten by {@link PacMan}.
	 * 
	 * @param event
	 */
	public void bonusObjectEaten(BonusObjectEatenEvent event);

	/** Called when {@link PacMan} is killed by a {@link Ghost}.
	 * 
	 * @param event
	 */
	public void gameOver(GameOverEvent event);

}
