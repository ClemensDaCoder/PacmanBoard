package pacman.model;
import java.util.EventListener;
import java.util.HashMap;

import javax.swing.event.EventListenerList;

import pacman.event.BoardListener;
import pacman.event.HasmovedEvent;
import pacman.event.MoveNotPossibleEvent;
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
		//init();
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

		}
		 else {
			 
			 notifyListener(new MoveNotPossibleEvent(movingObject));
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

	public void init() {
		gameArea = new HashMap<Position, Field>();
		
		for (Position position : Position.values()) {
			Field f = new Field();
			f.addObject(new Pellet());
			gameArea.put(position, f);
		}
		PacMan pac = new PacMan("Pacman", Position.F_3);
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
	
	public void addListener(BoardListener listener){
		listeners.add(BoardListener.class, listener);
		
	}
	public void removeListener(BoardListener listener){
		listeners.remove(BoardListener.class, listener);
		
		
	}
	protected void notifyListener(HasmovedEvent event){
		System.out.println("Notify");
		for(BoardListener l : listeners.getListeners(BoardListener.class))
		{
			//System.out.println("Listerner");
			l.hasmoved(event);
		}
		
		
	}
	protected void notifyListener(MoveNotPossibleEvent event){
		System.out.println("Notify");
		for(BoardListener l : listeners.getListeners(BoardListener.class))
		{
			//System.out.println("Listerner");
			l.moveNotpossible(event);
		}
		
		
	}	

}