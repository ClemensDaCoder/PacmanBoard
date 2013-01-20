package pacman.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class FieldTest {
	
	private Field field;
	
	private Wall wall;
	private GridObject gridObject2;
	
	@Before
	public void setUp() {
		field = new Field();
		wall = new Wall();
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

}
