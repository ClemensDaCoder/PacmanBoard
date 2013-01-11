package pacman.model;

import java.util.ArrayList;
import java.util.List;

public final class Position {

	public static int ROWS_MAX = 35;
	public static int ROWS_MIN = 1;
	public static char COLUMNS_MIN = 'A';
	public static char COLUMINS_MAX = 'Z';

	private static final List<Position> availablePositions = new ArrayList<Position>();
	
	private final int y;

	private final char x;
	
	static {
		//initialize static list of available positions
		for (char x = Position.COLUMNS_MIN; x <= Position.COLUMINS_MAX; x++ ) {
			for (int y = Position.ROWS_MIN; y <= Position.ROWS_MAX; y++) {
				availablePositions.add(new Position(x,y));
			}
		}
	}
	
	public Position(char x, int y) {
		this.x = Character.toUpperCase(x);
		this.y = y;
	}

	/** 
	 * @param direction
	 * @return Position next to current Position in given {@link Direction}
	 */
	public Position next(Direction direction) {
		switch (direction) {
		case UP:
			return Position.nextUp(this);
		case DOWN:
			return Position.nextDown(this);
		case LEFT:
			return Position.nextLeft(this);
		case RIGHT:
			return Position.nextRight(this);
		default:
			return this;
		}
	}

	private static Position getPosition(char x, int y) {
		return new Position(x, y);
	}

	private static Position nextRight(Position pos) {
		char newX = (char) (pos.x + 1);
		return (Position.isValidPosition(newX, pos.y)) ? getPosition(newX, pos.y) : pos;
	}

	private static Position nextLeft(Position pos) {
		char newX = (char) (pos.x - 1);
		return (Position.isValidPosition(newX, pos.y)) ? getPosition(newX, pos.y) : pos;
	}

	private static Position nextUp(Position pos) {
		return (Position.isValidPosition(pos.x, pos.y +1)) ?  getPosition(pos.x, pos.y + 1) : pos;
	}

	private static Position nextDown(Position pos) {
		return (Position.isValidPosition(pos.x, pos.y -1)) ? getPosition(pos.x, pos.y - 1) : pos;
	}

	/**
	 * @return row value of Position
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return column value of Position
	 */
	public char getX() {
		return x;
	}
	
	private static boolean isValidPosition(char x, int y) {
		return Character.isAlphabetic(x) && y >= Position.ROWS_MIN && y <= Position.ROWS_MAX;
	}

	public String toString() {
		return "Position " + x + y;
	}
	
	public boolean equals (Object object) {
		if (object == this) {
			return true;
		}
		if (object != null && object instanceof Position) {
			Position pObject = (Position) object;
			if (this.x == pObject.getX() && this.y == pObject.getY()) {
				return true;
			}
		}
		return false;
	}
	
	public int hashCode() {
		int hash = 1;
		hash = hash * 17 + this.x;
		hash = hash * 31 + this.y;
		return hash;
	}
	
	/**
	 * @return list of all available {@link Position}s
	 */
	public static List<Position> getAvailablePositionsAsList() {
		return availablePositions;
	}
	

}
