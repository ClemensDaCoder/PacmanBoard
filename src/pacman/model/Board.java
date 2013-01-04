package pacman.model;
import java.util.HashMap;

import pacman.model.move.MovingObject;

public class Board {

	private static Board instance = null; 
	
	private HashMap<Position, Field> gameArea;
	
	private int score;
	
	private Board()  {
		score = 0;
		init();
	}

	public void moveObject(MovingObject movingObject, Direction direction) {
		
		Position current = movingObject.getCurrentPosition();
		Position next = current.next(direction);
		
		Field currentField = gameArea.get(current);
		Field nextField = gameArea.get(next);
		
		if (!nextField.isWall()) {
			movingObject.setCurrentPosition(next);
			nextField.addObject(movingObject);
			currentField.removeObject(movingObject);
			//TODO: object moved from current to next field .. event!
		} else {
			//TODO: object cannot move .. event!
		}
	}
	
	
	public int getScore() {
		return score;
	}
	
	public void increaseScore(int value) {
		score += value;
	}
	
	public Board getInstance() {
		if (instance == null) {
			instance = new Board();
		}
		return instance;
	}
	
	private void init() {
		//TODO: initialize gameArea
	}
	

}