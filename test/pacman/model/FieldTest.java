package pacman.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import pacman.model.bonus.BonusObject;
import pacman.model.bonus.Cherry;
import pacman.model.bonus.Peach;
import pacman.model.bonus.Pellet;
import pacman.model.move.Ghost;
import pacman.model.move.PacMan;
import pacman.model.move.RandomMovingStrategy;

/**
 * @author mwe
 *
 */
public class FieldTest {
	
	private Field field;
	
	private Wall wall;
	private PacMan pacman;
	private Position posPacman;
	private RandomMovingStrategy strategyPacman;
	
	@Before
	public void setUp() {
		//initializes variables for testing
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
		//field has to be empty
		assertTrue(field.isEmpty());
		field.addObject(wall);
		//now field should be not empty
		assertFalse(field.isEmpty());
		field.removeObject(wall);
		//now field should be empty again
		assertTrue(field.isEmpty());
	}
	
	@Test
	public void testContainsPacman() {
		//field should not contain pacman
		assertFalse(field.containsPacman());
		field.addObject(pacman);
		//now the field should contain pacman
		assertTrue(field.containsPacman());
		field.removeObject(pacman);
		//now the field should not contain pacman
		assertFalse(field.containsPacman());
	}
	
	@Test
	public void testContainsGhost() {
		//initially, a field should not be a Ghost
		assertFalse(field.containsGhost());
		Ghost ghost1 = new Ghost(new Position('a',13), "Ghost1", new RandomMovingStrategy());
		field.addObject(ghost1);
		//now field should be a Ghost
		assertTrue(field.containsGhost());
		field.removeObject(ghost1);
		//now field should not be a Ghost
		assertFalse(field.containsGhost());
	}
	
	@Test
	public void testContainsBonusObject() {
		//initially, a field should not be a BonusObject
		assertFalse(field.containsBonusObject());
		BonusObject bo = new Cherry();
		field.addObject(bo);
		//now field should be a BonusObject
		assertTrue(field.containsBonusObject());
		field.removeObject(bo);
		//now field should not be a BonusObject
		assertFalse(field.containsBonusObject());
	}
	
	@Test
	public void testComputeState() {
		//add pacman and pellet to field
		field.addObject(pacman);
		Pellet pellet = new Pellet();
		field.addObject(pellet);
		
		field.computeState();
		//now field should only contain pacman - pellet should be gone
		assertTrue(field.containsPacman());
		assertFalse(field.containsBonusObject());
		assertFalse(field.isEmpty());
		
		//pacman should also be able to eat multiple bonus objects on one field
		field.addObject(pellet);
		field.addObject(new Peach());
		field.computeState();
		assertTrue(field.containsPacman());
		assertFalse(field.containsBonusObject());
		assertFalse(field.isEmpty());
		
		//pacman is killed by ghost cannot be tested properly without modifying code - see our "Fehlerprotokoll"
	}

}
