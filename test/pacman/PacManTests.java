package pacman;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import pacman.model.FieldTest;
import pacman.model.PositionTest;
import pacman.model.bonus.BonusObjectTest;

@RunWith(Suite.class)
@SuiteClasses({PositionTest.class, FieldTest.class, BonusObjectTest.class })
public class PacManTests {

}
