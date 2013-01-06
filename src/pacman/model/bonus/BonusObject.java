package pacman.model.bonus;

import pacman.model.GridObject;


/** Common ancestor of all available bonus objects like {@link Pellet}, {@link Cherry} or {@link Peach}
 * @author mwe
 *
 */
public abstract class BonusObject extends GridObject {
	
	protected static int PELLET_VALUE = 10;
	
	
	
	protected int value;

	/**
	 * @return value of {@link BonusObject}
	 */
	public int getValue() {
		return value;
	}
	
	/** Provides an entry point for any special action that a bonus object can start.
	 * 
	 */
	public abstract void executeAction();
	
	
}