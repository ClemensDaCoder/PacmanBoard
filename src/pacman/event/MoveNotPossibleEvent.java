package pacman.event;

import pacman.model.move.MovingObject;

/**
 * 
 * @author Katharina Event if the Movement is not possible
 */

public class MoveNotPossibleEvent extends java.util.EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MovingObject mov;

	/**
	 * 
	 * @return Moving Object of the Event
	 */
	public MovingObject getMov() {
		return mov;
	}

	/**
	 * Konstruktor for the Event
	 * 
	 * @param mov
	 */
	public MoveNotPossibleEvent(MovingObject mov) {
		super(mov);
		this.mov = mov;
	}

}
