package sokoban;

// Class representing a figure Board for the Sokoban game.
public class Board extends Figure{
	
	private Figure[][] figures;
	private Player player;

	public Board(Position position, int rows, int cols) {
		super(position);
		figures = new Figure[rows][cols];
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
	
	
	public void setFigure(Figure figure){
		
		figures[figure.position.getX()][figure.position.getY()] = figure;
	}
}
