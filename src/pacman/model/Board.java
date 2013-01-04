package pacman.model;
import java.util.ArrayList;

import pacman.model.move.Ghost;
import pacman.model.move.MovingObject;
import pacman.model.move.PacMan;

public class Board {

	private ArrayList<Field> fields;

	public void moveObject(MovingObject movingObject, Direction direction) {
		if (movingObject instanceof PacMan) {
			moveObject((PacMan)movingObject, direction);
		} else if (movingObject instanceof Ghost) {
			moveObject((Ghost)movingObject, direction);
		}
	}
	
	private void moveObject(PacMan pacman, Direction direction) {
		
	}
	
	private void moveObject(Ghost ghost, Direction direction) {

	}

}