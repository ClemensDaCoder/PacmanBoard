package pacman.model;

import java.util.HashMap;
import java.util.Random;

import javax.swing.event.EventListenerList;

import pacman.event.BoardListener;
import pacman.event.FieldListener;
import pacman.event.HasmovedEvent;
import pacman.event.MoveNotPossibleEvent;
import pacman.event.ScoreChangedEvent;
import pacman.model.bonus.Cherry;
import pacman.model.bonus.Fruit;
import pacman.model.bonus.Peach;
import pacman.model.move.MovingObject;

public class Board {

	private static Board instance = null;

	private HashMap<Position, Field> gameArea;
	private EventListenerList listeners = new EventListenerList();
	private int score;

	public Board() {
		score = 0;
		// init();
	}

	/**
	 * Moves a movingObject from its current Position to the next one. Objects
	 * are only moved from one {@link Field} to another. Objects are not moved
	 * if {@link Field} is occupied by {@link Wall}.
	 * 
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

		} else {

			notifyListener(new MoveNotPossibleEvent(movingObject));
		}
	}

	/**
	 * @return the current score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Increases the current score by value.
	 * 
	 * @param value
	 */
	public void increaseScore(int value) {
		score += value;
		notifyListener(new ScoreChangedEvent(score));
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

	/**
	 * Initializes Board.
	 * 
	 */
	public void init() {
		gameArea = new HashMap<Position, Field>();
		initGameArea();
	}

	private void initGameArea() {
		// TODO: initialize gameArea
		Field f;
		for (Position position : Position.values()) {
			f = new Field();
			if (f.isEmpty()) {
				if ((position.getX() == 'A') || (position.getX() == 'Z') || (position.getY() == 1)
						|| (position.getY() == 35)) {
					f.addObject(new Wall());
				} else if ((position.getY() % 2 == 1) && (Character.getNumericValue(position.getX()) % 2 == 0)) {
					System.out.println(position.toString());
					f.addObject(new Wall());
				}
				gameArea.put(position, f);
			}
		}
	}

	private void initFruit() {
		Position randomPosition = getRandomPosition();
		Field field = gameArea.get(randomPosition);
		// look for emtpy field
		while (!field.isEmpty()) {
			randomPosition = getRandomPosition();
			field = gameArea.get(randomPosition);
		}
		//place fruit in random position
		Fruit fruit = createRandomFruit();
		field.addObject(fruit);
		// TODO: throw frucht platziert event
	}

	private Position getRandomPosition() {
		Random random = new Random();
		int randomPositionValue = random.nextInt((Position.ROWS * Position.COLUMNS) - 1);
		return Position.values()[randomPositionValue];
	}

	private Fruit createRandomFruit() {
		Random random = new Random();
		int randomFruitValue = random.nextInt(1);
		if (randomFruitValue == 0) {
			return new Peach();
		} else {
			return new Cherry();
		}
	}

	// TODO: remove this, as it is only for testing purposes
	public static void main(String[] args) {
		Board board = Board.getInstance();
		board.init();
	}

	public void addListener(BoardListener listener) {
		listeners.add(BoardListener.class, listener);

	}

	public void removeListener(BoardListener listener) {
		listeners.remove(BoardListener.class, listener);

	}

	protected void notifyListener(HasmovedEvent event) {
		System.out.println("Notify");
		for (BoardListener l : listeners.getListeners(BoardListener.class)) {
			// System.out.println("Listerner");
			l.hasmoved(event);
		}

	}

	protected void notifyListener(MoveNotPossibleEvent event) {
		// System.out.println("Notify");
		for (BoardListener l : listeners.getListeners(BoardListener.class)) {
			// System.out.println("Listerner");
			l.moveNotpossible(event);
		}

	}

	protected void notifyListener(ScoreChangedEvent event) {
		for (BoardListener l : listeners.getListeners(BoardListener.class)) {
			// System.out.println("Listerner");
			l.scoreChanged(event);
		}
	}

	public void addFieldListeners(FieldListener listener) {
		for (Field f : gameArea.values()) {
			f.addListener(listener);
		}
	}

	public void removeFieldListener(FieldListener listener) {
		for (Field f : gameArea.values()) {
			f.removeListener(listener);
		}

	}

}
