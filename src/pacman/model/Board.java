package pacman.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.swing.event.EventListenerList;

import pacman.event.BoardListener;
import pacman.event.FieldListener;
import pacman.event.FruitPlacedEvent;
import pacman.event.HasMovedEvent;
import pacman.event.MoveNotPossibleEvent;
import pacman.event.MovingObjectPlacedEvent;
import pacman.event.NextLevelEvent;
import pacman.event.ScoreChangedEvent;
import pacman.model.bonus.Cherry;
import pacman.model.bonus.Fruit;
import pacman.model.bonus.Peach;
import pacman.model.bonus.Pellet;
import pacman.model.move.Ghost;
import pacman.model.move.MovingObject;
import pacman.model.move.MovingStrategy;
import pacman.model.move.PacMan;

/** Singleton which is responsible for moving around {@link MovingObject} instances on available {@link Field} instances.
 * Also keeps track of the game score.
 * 
 * @author mwe
 *
 */
public class Board {

	private static Board instance = null;

	private HashMap<Position, Field> gameArea;
	private EventListenerList listeners;
	private List<MovingObject> movingObjects;
	private int score;
	private int remainingPellets;
	private int level;
	private boolean gameOver;
	

	
	
	private Board() {
		score = 0;
		level = 1;
		gameOver = false;
		listeners = new EventListenerList();
		gameArea = new HashMap<Position, Field>();
		movingObjects = new ArrayList<MovingObject>();
		initGameArea();
	}
	
	/** Move all movable objects on board.
	 * 
	 */
	public void nextRound() {
		for (MovingObject movingObject : movingObjects) {
			moveObject(movingObject, movingObject.getMoveDirection());
			Field field = gameArea.get(movingObject.getCurrentPosition());
			field.computeState();
		}
	}

	/**
	 * Moves a movingObject from its current Position to the next one. Objects
	 * are only moved from one {@link Field} to another. Objects are not moved
	 * if {@link Field} is occupied by {@link Wall}.
	 * 
	 * @param movingObject
	 * @param direction
	 */
	private void moveObject(MovingObject movingObject, Direction direction) {

		Position current = movingObject.getCurrentPosition();
		Position next = current.next(direction);

		Field currentField = gameArea.get(current);
		Field nextField = gameArea.get(next);
		
		//if the game is not over yet
		if (!isGameOver()) {
			//check if move is possible
			if (!nextField.isWall()) {
				movingObject.setCurrentPosition(next);
				nextField.addObject(movingObject);
				currentField.removeObject(movingObject);
				notifyListener(new HasMovedEvent(current, next, movingObject));
			} else {
				notifyListener(new MoveNotPossibleEvent(movingObject));
			}			
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
	
	/** Adds a {@link Ghost} with a given {@link MovingStrategy}
	 * @param movingStrategy
	 */
	public void addGhost(MovingStrategy movingStrategy) {
		Position position = getRandomPosition();
		Field field = gameArea.get(position);
		while (field.isWall() || field.containsPacman()) {
			position = getRandomPosition();
			field = gameArea.get(position);
		}
		int ghostnumber = movingObjects.size();
		Ghost ghost = new Ghost(position,"Ghost" + ghostnumber, movingStrategy);
		movingObjects.add(ghost);
		notifyListener(new MovingObjectPlacedEvent(ghost,position));
	}
	
	/** Adds a {@link PacMan} with a given {@link MovingStrategy}<br>
	 * <b>IMPORTANT:</b> Only one PacMan can be added.<br>
	 * Returns true if {@link PacMan} was added, otherwise false
	 * @param movingStrategy
	 */
	public boolean addPacman(MovingStrategy movingStrategy) {
		for (MovingObject movingObject : movingObjects) {
			if (movingObject instanceof PacMan) {
				return false;
			}
		}
		Position pacManPosition = new Position('M', 24);
		PacMan pacman = new PacMan(pacManPosition, "PacMan", movingStrategy);
		movingObjects.add(pacman);
		notifyListener(new MovingObjectPlacedEvent(pacman, pacManPosition));
		return true;
	}

	/**
	 * Initializes Board.
	 * 
	 */
	public void initLevel() {
		initFruit();
		initPellets();
	}

	private void initGameArea() {
		Field field;
		for (Position position : Position.getAvailablePositionsAsList()) {
			field = new Field();
			if (field.isEmpty()) {
				if ((position.getX() == 'A') || (position.getX() == 'Z') || (position.getY() == 1)
						|| (position.getY() == 35)) {
					field.addObject(new Wall());
				} else if ((position.getY() % 2 == 1) && (Character.getNumericValue(position.getX()) % 2 == 0)) {
					field.addObject(new Wall());
				}
				gameArea.put(position, field);
			}
		}
	}

	private void initFruit() {
		Position randomPosition = getRandomPosition();
		Field field = gameArea.get(randomPosition);
		// look for empty field
		while (!field.isEmpty()) {
			randomPosition = getRandomPosition();
			field = gameArea.get(randomPosition);
		}
		// place fruit in random position
		Fruit fruit = createRandomFruit();
		field.addObject(fruit);
		notifyListener(new FruitPlacedEvent(fruit, randomPosition));
	}

	private Position getRandomPosition() {
		Random random = new Random();
		int randomPositionValue = random.nextInt(Position.getAvailablePositionsAsList().size());
		return Position.getAvailablePositionsAsList().get(randomPositionValue);
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

	private void initPellets() {
		Field field;
		remainingPellets = 0;
		for (Position position : Position.getAvailablePositionsAsList()) {
			field = gameArea.get(position);
			if (field.isEmpty()) {
				field.addObject(new Pellet());
				gameArea.put(position, field);
				remainingPellets++;
			}
		}
	}

	public int getRemainingPellets() {
		return remainingPellets;
	}

	public void decreaseRemainingPellets() {
		if (remainingPellets > 0)
			remainingPellets--;
		if (remainingPellets == 0) {
			notifyListener(new NextLevelEvent(this));
			//System.exit(0);
			//start next level
			nextLevel();
		}
	}
	
	private void nextLevel() {
		level++;
		initLevel();
	}
	
	/**
	 * @return true if the game is over
	 */
	public boolean isGameOver() {
		return gameOver;
	}
	
	/** true = gameOver
	 * @param gameOver
	 */
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	/** Adds listener for board.
	 * @param listener
	 */
	public void addListener(BoardListener listener) {
		listeners.add(BoardListener.class, listener);

	}

	/** Removes listener from board
	 * @param listener
	 */
	public void removeListener(BoardListener listener) {
		listeners.remove(BoardListener.class, listener);

	}

	protected void notifyListener(HasMovedEvent event) {
		for (BoardListener l : listeners.getListeners(BoardListener.class)) {
			l.hasmoved(event);
		}

	}

	protected void notifyListener(MoveNotPossibleEvent event) {
		for (BoardListener l : listeners.getListeners(BoardListener.class)) {
			l.moveNotpossible(event);
		}

	}
	
	protected void notifyListener(FruitPlacedEvent event){
		for (BoardListener l : listeners.getListeners(BoardListener.class)) {
			l.fruitwasplaced(event);
		}
	}

	protected void notifyListener(ScoreChangedEvent event) {
		for (BoardListener l : listeners.getListeners(BoardListener.class)) {
			l.scoreChanged(event);
		}
	}
	protected void notifyListener(MovingObjectPlacedEvent event) {
		for (BoardListener l : listeners.getListeners(BoardListener.class)) {
			l.movingobjectwasplaced(event);
		}
	}
	
	protected void notifyListener(NextLevelEvent event) {
		for (BoardListener l : listeners.getListeners(BoardListener.class)) {
			l.nextLevel(event);
		}
	}
	
	/** Registers listener for every {@link Field} of the game area.
	 * @param listener
	 */
	public void addFieldListeners(FieldListener listener) {
		for (Field f : gameArea.values()) {
			f.addListener(listener);
		}
	}

	/** Removes listener from every {@link Field} of the game area.
	 * @param listener
	 */
	public void removeFieldListener(FieldListener listener) {
		for (Field f : gameArea.values()) {
			f.removeListener(listener);
		}
	}	
}
