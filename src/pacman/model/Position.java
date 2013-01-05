package pacman.model;

public enum Position {
	
	A_1('A', 1), B_1('B', 1), C_1('C', 1), D_1('D', 1), E_1('E', 1), F_1('F', 1), G_1('G', 1), H_1('H', 1),  
	A_2('A', 2), B_2('B', 2), C_2('C', 2), D_2('D', 2), E_2('E', 2), F_2('F', 2), G_2('G', 2), H_2('H', 2),  
	A_3('A', 3), B_3('B', 3), C_3('C', 3), D_3('D', 3), E_3('E', 3), F_3('F', 3), G_3('G', 3), H_3('H', 3),  
	A_4('A', 4), B_4('B', 4), C_4('C', 4), D_4('D', 4), E_4('E', 4), F_4('F', 4), G_4('G', 4), H_4('H', 4),  
	A_5('A', 5), B_5('B', 5), C_5('C', 5), D_5('D', 5), E_5('E', 5), F_5('F', 5), G_5('G', 5), H_5('H', 5),  
	A_6('A', 6), B_6('B', 6), C_6('C', 6), D_6('D', 6), E_6('E', 6), F_6('F', 6), G_6('G', 6), H_6('H', 6),  
	A_7('A', 7), B_7('B', 7), C_7('C', 7), D_7('D', 7), E_7('E', 7), F_7('F', 7), G_7('G', 7), H_7('H', 7),  
	A_8('A', 8), B_8('B', 8), C_8('C', 8), D_8('D', 8), E_8('E', 8), F_8('F', 8), G_8('G', 8), H_8('H', 8);  
	
	private int y;
	
	private char x;
		
	
	//public
	private Position(char x, int y) {
		this.x = Character.toUpperCase(x);
		this.y = y;
	}
	
	public Position next(Direction direction) {
		switch(direction) {
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
		return Position.valueOf(x + "_" + Integer.toString(y));
	}
	
	private static Position nextRight(Position pos) {
		char newX = (char)(pos.x + 1);
		return getPosition(newX, pos.y);
	}
	
	private static Position nextLeft(Position pos) {
		char newX = (char)(pos.x -1);
		return getPosition(newX, pos.y);
	}	
	
	private static Position nextUp(Position pos) {
		return getPosition(pos.x, pos.y + 1);
	}
	
	private static Position nextDown(Position pos) {
		return getPosition(pos.x, pos.y - 1);
	}
	
//	public int getY() {
//		return y;
//	}
//	
//	public Character getX() {
//		return x;
//	}
	
	public static boolean isValidPosition(Position pos) {
		return Character.isAlphabetic(pos.x) && pos.y <= 100;
	}
	
	public String toString() {
		return "Position " + x + y;
	}

}
