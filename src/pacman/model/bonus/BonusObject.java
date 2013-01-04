package pacman.model.bonus;

import pacman.model.GridObject;


/** Common ancestor of all available bonus objects like {@link Pellet}, {@link Cherry} or {@link Peach}
 * @author mwe
 *
 */
public abstract class BonusObject extends GridObject {
	
	protected static int PELLET_VALUE = 10;
	protected static int CHERRY_VALUE = 150;
	protected static int PEACH_VALUE = 100;
	
	
	protected int value;

	/**
	 * @return value of {@link BonusObject}
	 */
	public int getValue() {
		return value;
	}
	
	
}