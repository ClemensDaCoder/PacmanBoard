package pacman.model.bonus;

/** Commons ancestor of all bonus fruits.
 * e.g.: {@link Peach}, {@link Cherry}
 * 
 * @author mwe
 *
 */
public abstract class Fruit extends BonusObject {

	protected static int CHERRY_VALUE = 150;
	protected static int PEACH_VALUE = 100;
	
	/** Creates a new Fruit object.
	 * 
	 * @param name
	 * @param value
	 */
	public Fruit(String name, int value) {
		super(name, value);
	}

	@Override
	public void executeAction() {
		//empty because fruits do nothing special		
	}

}
