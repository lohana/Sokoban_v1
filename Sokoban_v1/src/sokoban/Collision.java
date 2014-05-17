package sokoban;

public class Collision {

	private static volatile Collision instance = null;
	private Board board;

	private  Collision() {

	}

	public static Collision getInstance() {
	      if(instance == null) {
	         instance = new Collision();
	      }
	      return instance;
	}

	public void setBoard(Board board){
		this.board = board;
	}
	
	public boolean isPositionFinal(Position position) {
		for (Position p : board.getFinalPositions()) {
			if (p.isEqualTo(position)) {
				return true;
			}
		}
		return false;
	}
	
	public void setFigure(Figure figure) {
		board.setFigure(figure);
	}

	// Checks if the player can move in the specified direction
	public Figure collision(Player player, Directions direction) {

		// Get the next position
		// If it is null, the player cannot move
		Position nextPosition = player.position.getNextPosition(direction);
		if (nextPosition == null) {
			return null;
		}

		// Get the figure of the next position
		Figure nextFigure = board.getFigure(nextPosition);

		// If it is a field, the player can move
		if (nextFigure instanceof Field) {
			return nextFigure;
		}

		// If it is a wall, the player cannot move
		if (nextFigure instanceof Wall) {
			return null;
		}

		// If it is a box, the next figure is checked
		if (nextFigure instanceof Box) {

			// Get the second next position
			// If it is null, the box and the player cannot move
			Position secondNextPosition = nextPosition.getNextPosition(direction);
			if (secondNextPosition == null) {
				return null;
			}

			// Get the figure in the second next position
			Figure secondNextFigure = board.getFigure(secondNextPosition);

			// If the figure is a field, the box and the player can move
			if (secondNextFigure instanceof Field) {
				return nextFigure;
			}
		}

		return null;
	}

}