package sokoban;

import java.util.ArrayList;

public class Game implements IArrowKeyListener{
	
	private Player player;
	private Board board;

	public Game() {
		
	}

	public void initializeGame(int rows, int cols, String boardStore) {
		
		board = new Board(new Position(), rows, cols);
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				Position position = new Position(j, i);
				Figure figure = null;
				switch(boardStore.charAt(i * cols + j)) {
					case 'w': figure = new Wall(position); break;
					case 'b': figure = new Box(position, false); break;
					case 'a': figure = new Box(position, true); break;
					case 'f': figure = new Field(position, false); break;
					case 'v': figure = new Field(position, true); break;
					case 'p': this.player = new Player(position); figure = player; break;
				}
				board.setFigure(figure);
			}
		}
		
		Collision collision = Collision.getInstance();
		collision.setBoard(board);
		
		SokobanDrawer drawer = SokobanDrawer.getInstance();
		drawer.initializeScreen(rows, cols);
		drawer.addListener(this);
		
		board.draw();

	}

	@Override
	public void arrowPressed(Directions direction) {
		player.move(direction);
		board.draw();
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