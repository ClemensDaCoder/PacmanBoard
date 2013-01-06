package pacman.controller;

import pacman.model.Board;
import pacman.model.Direction;
import pacman.model.move.MovingObject;

public abstract class MoveController {

  public MovingObject movingObject;

  public Board board;
  
  public MoveController(MovingObject movingObject) {
	  this.movingObject = movingObject;
  }

  public abstract Direction determineMoveDirection();
  
  public void moveObject() {
	  board.moveObject(movingObject, determineMoveDirection());
  }
  
}