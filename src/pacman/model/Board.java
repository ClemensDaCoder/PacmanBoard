package pacman.model;
import java.util.EventListener;
import java.util.HashMap;

import javax.swing.event.EventListenerList;

import pacman.event.HasMovedListener;
import pacman.event.HasmovedEvent;
import pacman.model.bonus.BonusObject;
import pacman.model.move.MovingObject;


public class Board {

	private static Board instance = null;

	private HashMap<Position, Field> gameArea;
	private EventListenerList listeners  = new EventListenerList();
	private int score;

	public Board() {
		score = 0;
		init();
	}

	/** Moves a movingObject from its current Position to the next one.
	 *  Objects are only moved from one {@link Field} to another.
	 *  Objects are not moved if {@link Field} is occupied by {@link Wall}.
	 * @param movingObject
	 * @param direction
	 */
	public void moveObject(MovingObject movingObject, Direction direction) {

		Position current = movingObject.getCurrentPosition();
		Position next = current.next(direction);

		Field currentField = gameArea.get(current);
		Field nextField = gameArea.get(next);

		if (!nextField.isWall()) {
			movingObject.setCurrentPosition(next);
			nextField.addObject(movingObject);
			currentField.removeObject(movingObject);
			notifyListener(new HasmovedEvent(current, next, movingObject));
			// TODO: object moved from current to next field .. event!
		} else {
			// TODO: object cannot move .. event!
		}
	}

	/**
	 * @return the current score
	 */
	public int getScore() {
		return score;
	}

	/** Increases the current score by value.
	 * @param value
	 */
	public void increaseScore(int value) {
		score += value;
	}

	/**
	 * @return instance of {@link Board}
	 */
	public static Board getInstance() {
		if (instance == null) {
			instance = new Board();
		}
		return instance;
	}

	private void init() {
		// TODO: initialize gameArea
	}

	//??
	public class BonusObjectEventListener implements EventListener {
		public BonusObjectEventListener() {
		}
		
		public void handleEvent(BonusObject o){
			increaseScore(o.getValue());
		}
	};
	
	public void addListener(HasMovedListener listener){
		listeners.add(HasMovedListener.class, listener);
		
	}
	public void removeListener(HasMovedListener listener){
		listeners.remove(HasMovedListener.class, listener);
		
		
	}
	protected void notifyListener(HasmovedEvent event){
		for(HasMovedListener l : listeners.getListeners(HasMovedListener.class))
		{
			l.hasmoved(event);
		}
		
		
	}
	

}