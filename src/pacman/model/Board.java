package pacman.model;
import java.util.EventListener;
import java.util.HashMap;

import pacman.model.bonus.BonusObject;
import pacman.model.move.MovingObject;

public class Board {

	private HashMap<Position, Field> gameArea;
	
	private int score;
	
	public Board(){
		resetScore();
	}
	
	public void resetScore(){
		score = 0;
	}
	
	public void increaseScore(int points){
		score += points;
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
	
	public class BonusObjectEventListener implements EventListener{
		public BonusObjectEventListener(){
		}
		
		public void handleEvent(BonusObject o){
			increaseScore(o.getValue());
		}
	};

}