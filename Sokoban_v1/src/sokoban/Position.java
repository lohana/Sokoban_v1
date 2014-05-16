package sokoban;

// Class that represents the position of a figure as coordinates in table
public class Position {

	private int x;
	private int y;
	 
	public Position(){		
		this.setLocation(0, 0);
	}
	
	public Position(int x, int y) {
		this.setLocation(x, y);
	}
	
	public Position(Position p){		
		this.setLocation(p.getX(), p.getY());			
	}
	
	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean isEqualTo(Position position) {
		if(position.getX()== this.x && position.getY()== this.y){
			return true;
		} else {
			return false;
		}
	}

	public Position getNextPosition(Directions direction) {
		switch (direction) {
			case Up:
				return new Position(x, y - 1);
			case Down:
				return new Position(x, y + 1);
			case Left:
				return new Position(x - 1, y);
			case Right:
				return new Position(x + 1, y);
		}
		return null;
	}

}