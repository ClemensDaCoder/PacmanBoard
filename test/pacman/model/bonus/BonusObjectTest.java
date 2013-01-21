/**
 * 
 */
package pacman.model.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Manuel
 * 
 */
public class BonusObjectTest {

	String nameCherry, namePeach, namePellet;
	Cherry cherry;
	Peach peach;
	Pellet pellet;

	@Before
	public void setUp() {
		nameCherry = "Cherry";
		namePeach = "Peach";
		namePellet = "Pellet";
		cherry = new Cherry();
		peach = new Peach();
		pellet = new Pellet();
	}

	@Test
	public void testCherry() {
		// test if it has the right name and value
		assertEquals(nameCherry, cherry.getName());
		assertEquals(Fruit.CHERRY_VALUE, cherry.getValue());
	}

	@Test
	public void testPeach() {
		// test if it has the right name and value
		assertEquals(namePeach, peach.getName());
		assertEquals(Fruit.PEACH_VALUE, peach.getValue());
	}

	@Test
	public void testPellet() {
		// test if it has the right name and value
		assertEquals(namePellet, pellet.getName());
		assertEquals(Pellet.PELLET_VALUE, pellet.getValue());
	}
}
