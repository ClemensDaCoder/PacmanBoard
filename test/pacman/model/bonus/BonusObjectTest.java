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
	public void setUp(){
		nameCherry = "Cherry";
		namePeach = "Peach";
		namePellet = "Pellet";
		cherry = new Cherry();
		peach = new Peach();
		pellet = new Pellet();
	}

	@Test
	public void testCherry() {
		//test if it has the right name and value
		assertEquals(cherry.getName(), nameCherry);
		assertEquals(cherry.getValue(), Fruit.CHERRY_VALUE);
	}

	@Test
	public void testPeach() {
		//test if it has the right name and value
		assertEquals(peach.getName(), namePeach);
		assertEquals(peach.getValue(), Fruit.PEACH_VALUE);
	}
	
	@Test
	public void testPellet() {
		//test if it has the right name and value
		assertEquals(pellet.getName(), namePellet);
		assertEquals(pellet.getValue(), Pellet.PELLET_VALUE);
	}
}
