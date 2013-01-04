package pacman.model.bonus;

import pacman.model.GridObject;


public abstract class BonusObject extends GridObject {
	
	protected static int PELLET_VALUE = 10;
	protected static int CHERRY_VALUE = 150;
	protected static int PEACH_VALUE = 100;
	
	
	protected int value;

	public int getValue() {
		return value;
	}
	
	
}