package sokoban;

public class Game {
	

	public Game(int rows, int cols) {
		//Board board = new Board(new Position());
		Collision collision = Collision.getInstance();
		//collision.setBoard(board);
		inicializeBoard(collision, rows,cols);
	}

	private void inicializeBoard(Collision collision,int rows, int cols) {
		Board board = new Board(new Position(),rows,cols);
				
		board.setFigure(new Player(new Position(0, 1)));
		board.setFigure(new Field(new Position(1, 1),false));
		board.setFigure(new Field(new Position(1, 0),false));
		board.setFigure(new Field(new Position(2, 0),false));
		board.setFigure(new Field(new Position(2, 2),true));
		
		board.setFigure(new Field(new Position(1, 2),false));
		board.setFigure(new Box(new Position(2, 1)));
				
		collision.setBoard(board);
		
	}
	

}
