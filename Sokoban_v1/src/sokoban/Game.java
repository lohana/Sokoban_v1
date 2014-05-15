package sokoban;

import java.util.ArrayList;

public class Game {
	

	public Game(int rows, int cols) {
		
		Collision collision = Collision.getInstance();
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
	
	private boolean isGameEnd(){
		Collision collision = Collision.getInstance();
		Board currentBoard = collision.getBoard();
		ArrayList<Position> finalPositions = currentBoard.getFinalPositions();
		int finalsBox = 0;
		for (int i=0; i<=finalPositions.size();i++){
			Position currentPosition = finalPositions.get(i);
			Figure currentFigure = currentBoard.getFigure(currentPosition);
			if (currentFigure instanceof Box)
				finalsBox++;
		}
		
		if (finalsBox == finalPositions.size())
			return true;
		else
			return false;
	}
	

}
