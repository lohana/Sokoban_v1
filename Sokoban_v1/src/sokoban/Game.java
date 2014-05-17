package sokoban;

import javax.swing.JOptionPane;

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
					case 'a': figure = new Box(position, true); board.addFinal(position); break;
					case 'f': figure = new Field(position, false); break;
					case 'v': figure = new Field(position, true); board.addFinal(position); break;
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
		if (isGameEnd()) {
			JOptionPane.showMessageDialog(null, "You win!");
		}
	}
	
	// Checks if the game is over.
	private boolean isGameEnd(){
		for (Position position : board.getFinalPositions()) {
			Figure currentFigure = board.getFigure(position);
			if (!(currentFigure instanceof Box)) {
				return false;
			}
		}

		return true;
	}
}