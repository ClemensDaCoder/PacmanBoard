package pacman;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import pacman.model.FieldTest;
import pacman.model.PositionTest;

@RunWith(Suite.class)
@SuiteClasses({PositionTest.class, FieldTest.class })
public class PacManTests {

}
