package pacman.model.bonus;

/**
 * @author mwe
 *
 */
public class Pellet extends BonusObject {
	
	public Pellet() {
		this.value = BonusObject.PELLET_VALUE;
	}

	@Override
	public void executeAction() {
		//empty because pellets do nothing special
		//Power Pellets - do		
	}
	
	
}