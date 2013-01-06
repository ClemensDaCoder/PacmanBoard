package pacman.model.bonus;

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
		//empty because pellets do nothing special
		//Power Pellets - do		
	}
	
}