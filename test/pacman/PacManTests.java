package pacman;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import pacman.model.FieldTest;
import pacman.model.PositionTest;
import pacman.model.bonus.BonusObjectTest;
import pacman.model.move.MovingObjectTest;

@RunWith(Suite.class)
@SuiteClasses({PositionTest.class, FieldTest.class, BonusObjectTest.class, MovingObjectTest.class })
public class PacManTests {

}
