package pacman.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	
	private Board board;
	
	@Before
	public void setUp() {
		board = Board.getInstance();
	}
	
	/** resets the singleton instance back to null. It's not a good idea to use a Singleton if you want to do some unit tests.
	 * 
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	@Before
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
       //get Field "instance" from Board
	   java.lang.reflect.Field instance = Board.class.getDeclaredField("instance");
	   //make accessiable
       instance.setAccessible(true);
       //reset it (to null)
       instance.set(null, null);
    }

	
	@Test
	public void testRemainingPellets() {
		//board should be empty
		assertEquals(0, board.getRemainingPellets());
		//initialize the board
		board.initLevel();
		//find out how many pellets are one the board
		int remainingPellets = board.getRemainingPellets();
		//remove one pellet from board
		board.decreaseRemainingPellets();
		remainingPellets = remainingPellets - 1;
		assertEquals(remainingPellets, board.getRemainingPellets());
	}
	
	/** Negative values can also be passed to the increaseScore method which will result in a decreased score.
	 *  This should be fixed.
	 * 
	 */
	@Test
	public void testScore() {
		int scoreValue = 10;
		board.initLevel();
		//score should be 0
		assertEquals(board.getScore(), 0);
		board.increaseScore(scoreValue);
		//score should be 10
		assertEquals(scoreValue, board.getScore());
		
	}

}
