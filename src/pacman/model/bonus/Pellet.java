package pacman.model.bonus;

import pacman.model.Board;

/** Represents a Pellet.
 * 
 * @author mwe
 *
 */
public class Pellet extends BonusObject {
	
	protected static int PELLET_VALUE = 10;
	
	/** Creates a new Pellet object.
	 * 
	 */
	public Pellet() {
		super("Pellet", PELLET_VALUE);
	}

	@Override
	public void executeAction() {
		Board.getInstance().decreaseRemainingPellets();
	}
	
}