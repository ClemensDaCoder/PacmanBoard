/**
 * 
 */
package pacman.model.move;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pacman.model.Direction;
import pacman.model.Position;

/**
 * @author Manuel
 *
 */
public class MovingObjectTest {

	Ghost ghost;
	Position ghostPos;
	String ghostName;
	PacMan pacman;
	Position pacmanPos;
	String pacmanName;
	RandomMovingStrategy strategy;
	Position testPos;
	
	@Before
	public void setUp() {
		strategy = new RandomMovingStrategy();
		ghostName = "Blinky";
		ghostPos = new Position('A', 1);
		ghost = new Ghost(ghostPos, ghostName, strategy);
		pacmanPos = new Position('B', 2);
		pacmanName = "Pacman";
		pacman = new PacMan(pacmanPos, pacmanName, strategy);
		testPos = new Position('C', 3);
	}

	@Test
	public void testGhost() {
		//current position has to be initial position
		assertEquals(ghostPos, ghost.getCurrentPosition());
		ghost.setCurrentPosition(testPos);
		//check if new position is correct
		assertEquals(testPos, ghost.getCurrentPosition());
	}
	
	@Test
	public void testPacMan() {
		//current position has to be initial position
		assertEquals(pacmanPos, pacman.getCurrentPosition());
		pacman.setCurrentPosition(testPos);
		//check if new position is correct
		assertEquals(testPos, pacman.getCurrentPosition());
	}
	
	//TODO: RandomMovingStrategy, MovingObject.getMoveDirection

}
