package pacman.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import pacman.model.move.MovingStrategy;
import pacman.model.move.PacMan;
import pacman.model.move.RandomMovingStrategy;

public class FieldTest {
	
	private Field field;
	
	private Wall wall;
	private PacMan pacman;
	private Position posPacman;
	private RandomMovingStrategy strategyPacman;
	
	@Before
	public void setUp() {
		field = new Field();
		wall = new Wall();
		posPacman = new Position('A', 1);
		strategyPacman = new RandomMovingStrategy();
		pacman = new PacMan(posPacman, "Pacman", strategyPacman);
	}
	
	@Test
	public void testIsWall() {
		//initially, a field should not be a wall
		assertFalse(field.isWall());
		field.addObject(wall);
		//now field should be a wall
		assertTrue(field.isWall());
		field.removeObject(wall);
		//now field should not be a wall
		assertFalse(field.isWall());
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(field.isEmpty());
		field.addObject(wall);
		assertFalse(field.isEmpty());
		field.removeObject(wall);
		assertTrue(field.isEmpty());
	}
	
	@Test
	public void testContainsPacman() {
		assertFalse(field.containsPacman());
		field.addObject(pacman);
		assertTrue(field.containsPacman());
		field.removeObject(pacman);
		assertFalse(field.containsPacman());
	}

}
