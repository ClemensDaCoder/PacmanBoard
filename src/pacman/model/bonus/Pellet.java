package pacman.model.bonus;

import pacman.model.Board;

/**
 * @author mwe
 *
 */
public class Pellet extends BonusObject {
	
	protected static int PELLET_VALUE = 10;
	
	public Pellet() {
		super("Pellet", PELLET_VALUE);
	}

	@Override
	public void executeAction() {
		Board.getInstance().decreaseRemainingPellets();
	}
	
}