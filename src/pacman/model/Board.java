package pacman.model;
import java.util.EventListener;
import java.util.HashMap;

import javax.swing.event.EventListenerList;

import pacman.event.HasMovedListener;
import pacman.event.HasmovedEvent;
import pacman.model.bonus.BonusObject;
import pacman.model.bonus.Pellet;
import pacman.model.move.MovingObject;
import pacman.model.move.PacMan;


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
		
		Field currentField = gameArea.get(new Position('h',13));
		Field nextField = gameArea.get(next);

		if (!nextField.isWall()) {
			movingObject.setCurrentPosition(next);
			nextField.addObject(movingObject);
			currentField.removeObject(movingObject);
			notifyListener(new HasmovedEvent(current, next, movingObject));
		}
			// TODO: object moved from current to next field .. event!
		 else {
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
		gameArea = new HashMap<Position, Field>();
		
		for(int i = 1; i < 27 ;i++)
		{
			for ( char c = 'a'; c <= 'z' ; c ++ )
			{
				Field f = new Field();
				f.addObject(new Pellet());
				gameArea.put(new Position(c,i), f);
			}
		}
		gameArea.put(new Position('h',13), new Field("Hallo"));
		PacMan pac = new PacMan("Pacman", new Position('h',13));
		moveObject(pac,Direction.RIGHT);
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