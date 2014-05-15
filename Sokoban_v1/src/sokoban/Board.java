package sokoban;

// Class representing a figure Board for the Sokoban game.
public class Board extends Figure{
	
	private Figure[][] figures;
	private Player player;

	public Board(Position position) {
		super(position);
	}

	@Override
	public void draw() {
		
	}

	@Override
	public void move(Directions direction) {
		
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Figure getFigure(Position position) {
		return figures[position.getX()][position.getY()];
	}
}
