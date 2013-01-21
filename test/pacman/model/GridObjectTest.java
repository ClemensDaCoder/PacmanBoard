/**
 * 
 */
package pacman.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Manuel
 * 
 */
public class GridObjectTest {

	private GridObject wall;
	private String wallName;

	@Before
	public void setUp() {
		wallName = "Wall1";
		wall = new Wall(wallName);
	}

	@Test
	public void testToString() {
		// checks if ToString method is correct
		assertEquals(wallName, wall.toString());
	}

}
