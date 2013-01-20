package pacman.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PositionTest {

	private Position position;
	private Position nextUpPosition;
	private Position nextDownPosition;
	private Position nextLeftPosition;
	private Position nextRightPosition;
	private char startXCoordinate;
	private int startYCoordinate;

	@Before
	public void setUp() {
		startXCoordinate = 'D';
		startYCoordinate = 5;
		position = new Position(startXCoordinate, startYCoordinate);
		nextUpPosition = new Position(startXCoordinate, startYCoordinate + 1);
		nextDownPosition = new Position(startXCoordinate, startYCoordinate - 1);
		nextLeftPosition = new Position((char) (startXCoordinate - 1), startYCoordinate);
		nextRightPosition = new Position((char) (startXCoordinate + 1), startYCoordinate);
	}

	@Test
	public void testNextUp() {
		Position newPosition = position.next(Direction.UP);
		assertEquals(nextUpPosition, newPosition);
	}

	@Test
	public void testNextDown() {
		Position newPosition = position.next(Direction.DOWN);
		assertEquals(nextDownPosition, newPosition);
	}

	@Test
	public void testNextLeft() {
		Position newPosition = position.next(Direction.LEFT);
		assertEquals(nextLeftPosition, newPosition);
	}

	@Test
	public void testNextRight() {
		Position newPosition = position.next(Direction.RIGHT);
		assertEquals(nextRightPosition, newPosition);
	}

	@Test
	public void testInvalidPosition() {
		// creating an invalid position is possible (please look at our
		// "Fehlerprotokoll")
		Position invalidPosition = new Position('A', 45);
		// moving into a direction that is not in the range of valid positions
		// results in not moving at all
		Position moreInvalidPosition = invalidPosition.next(Direction.DOWN);
		assertEquals(invalidPosition, moreInvalidPosition);
	}

}
