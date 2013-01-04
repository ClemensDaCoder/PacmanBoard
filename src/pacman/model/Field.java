package pacman.model;
import java.util.List;


public class Field {

  public List<GridObject> objects;
  
  public void computeState() {
	  
  }
  
  public void addObject(GridObject object) {
	  objects.add(object);
  }
  
  public List<GridObject> getObjectsOnField() {
	  return objects;
  }
  
  public boolean isWall() {
	  for (GridObject object : objects) {
		  if (object instanceof Wall) {
			  return true;
		  }
	  }
	  return false;
  }
}