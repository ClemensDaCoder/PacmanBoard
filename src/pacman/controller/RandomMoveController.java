package pacman.controller;

import java.util.Random;

import pacman.model.Direction;
import pacman.model.move.MovingObject;

public class RandomMoveController extends MoveController {
	
	private Random random;
	
	public RandomMoveController(MovingObject movingObject) {
		super(movingObject);
		random = new Random();
	}

	@Override
	public Direction determineMoveDirection() {
		int randomDirectionNumber = random.nextInt(Direction.values().length);
		return Direction.values()[randomDirectionNumber];		
	}
}