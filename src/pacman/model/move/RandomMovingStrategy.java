package pacman.model.move;

import java.util.Random;

import pacman.model.Direction;

/** {@link MovingObjec}s that make use of RandomMovingStrategy move around random.
 * 
 * @author mwe
 *
 */
public class RandomMovingStrategy implements MovingStrategy {
	
	private Random random;
	
	public RandomMovingStrategy() {
		random = new Random();
	}

	public Direction getMoveDirection() {
		int randomDirectionNumber = random.nextInt(Direction.values().length);
		return Direction.values()[randomDirectionNumber];
	}

}
