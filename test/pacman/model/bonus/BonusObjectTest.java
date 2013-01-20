/**
 * 
 */
package pacman.model.bonus;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Manuel
 *
 */
public class BonusObjectTest {

	String nameCherry, namePeach, namePellet;
	int valPeach, valCherry, valPellet;
	Cherry cherry;
	Peach peach;
	Pellet pellet;
	
	@Before
	public void setUp(){
		nameCherry = "Cherry";
		valCherry = 150;
		namePeach = "Peach";
		valPeach = 100;
		namePellet = "Pellet";
		valPellet = 10;
		cherry = new Cherry();
		peach = new Peach();
		pellet = new Pellet();
	}

	@Test
	public void testCherry() {
		//test if it has the right name and value
		assertEquals(cherry.getName(), nameCherry);
		assertEquals(cherry.getValue(), valCherry);
	}

	@Test
	public void testPeach() {
		//test if it has the right name and value
		assertEquals(peach.getName(), namePeach);
		assertEquals(peach.getValue(), valPeach);
	}
	
	@Test
	public void testPellet() {
		//test if it has the right name and value
		assertEquals(pellet.getName(), namePellet);
		assertEquals(pellet.getValue(), valPellet);
	}
}
