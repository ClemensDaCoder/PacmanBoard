package pacman;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import pacman.model.BoardTest;
import pacman.model.FieldTest;
import pacman.model.PositionTest;
import pacman.model.bonus.BonusObjectTest;
import pacman.model.move.MovingObjectTest;

/**
 * @author mwe
 *
 */
@RunWith(Suite.class)
@SuiteClasses({PositionTest.class, FieldTest.class, BonusObjectTest.class, BoardTest.class, MovingObjectTest.class })
public class PacManTests {

}
