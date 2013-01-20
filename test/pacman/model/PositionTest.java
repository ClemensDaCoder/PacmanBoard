package pacman.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PositionTest {
	
	private Position position;
	private Position nextUpPosition;
	private char startXCoordinate;
	private int startYCoordinate;
	
	@Before
	public void setUp() {
		startXCoordinate = 'D';
		startYCoordinate = 5;
		position = new Position(startXCoordinate, startYCoordinate);
		nextUpPosition = new Position(startXCoordinate, startYCoordinate+1);
	}
	
	@Test
	public void testNextUp() {
		Position newPosition = position.next(Direction.UP);
		assertEquals(newPosition, nextUpPosition);
	}
	
	@Test
	public void testInvalidPosition() {
		//creating an invalid position is possible (please look at our "Fehlerprotokoll")
		Position invalidPosition = new Position('A', 45);
		//moving into a direction that is not in the range of valid positions results in not moving at all
		Position moreInvalidPosition = invalidPosition.next(Direction.DOWN);
		assertEquals(invalidPosition, moreInvalidPosition);
	}

}
