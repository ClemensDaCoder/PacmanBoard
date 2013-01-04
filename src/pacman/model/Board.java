package pacman.model;
import java.util.HashMap;

import pacman.model.move.MovingObject;

public class Board {

	private HashMap<Position, Field> gameArea;

	public void moveObject(MovingObject movingObject, Direction direction) {
		
		Position current = movingObject.getCurrentPosition();
		Position next = current.next(direction);
		
		Field currentField = gameArea.get(current);
		Field nextField = gameArea.get(next);
		
		if (!nextField.isWall()) {
			movingObject.setCurrentPosition(next);
			nextField.addObject(movingObject);
			currentField.removeObject(movingObject);
		} else {
			//TODO: object cannot move .. event!
		}
		
//		if (movingObject instanceof PacMan) {
//			moveObject((PacMan)movingObject, direction);
//		} else if (movingObject instanceof Ghost) {
//			moveObject((Ghost)movingObject, direction);
//		}
	}
	
//	private void moveObject(PacMan pacman, Direction direction) {
//		//determine next Position of pacman
//		  //get current position of pacman
//		Position current = pacman.getCurrentPosition();
//		Position next = current.next(direction);
//		
//		Field field = gameArea.get(next);
//		//check if pacman can go to this field
//		
//	}
//	
//	private void moveObject(Ghost ghost, Direction direction) {
//
//	}

}