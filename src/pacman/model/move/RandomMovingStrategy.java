package pacman.model.move;

import java.util.Random;

import pacman.model.Direction;

public class RandomMovingStrategy extends MovingStrategy {
	
	private Random random;
	
	public RandomMovingStrategy() {
		random = new Random();
	}
	
	@Override
	public Direction getMoveDirection() {
		int randomDirectionNumber = random.nextInt(Direction.values().length);
		return Direction.values()[randomDirectionNumber];
	}

}
