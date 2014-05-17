package sokoban;

// Class representing a figure Player for the Sokoban game.
public class Player extends Figure {

	public Player(Position position) {
		super(position);
	}

	@Override
	public void draw() {
		SokobanDrawer drawer = SokobanDrawer.getInstance();
		drawer.drawToSceen(this.position, Figures.Player);
	}

	@Override
	public void move(Directions direction) {
		Collision collision = Collision.getInstance();
		
		// Check the move and get the figure for the next position
		Figure figureToMove = collision.collision(this, direction);
		
		// If the result from the collision method is null, the player cannot move.
		if (figureToMove == null) {
			return;
		}
		
		// If the next figure is box, move it.
		if (figureToMove instanceof Box) {
			figureToMove.move(direction);
		}
		
		// Move the player and return field to the current place
		Position nextPosition = this.position.getNextPosition(direction);
		Position oldPosition = this.position;
		this.position = nextPosition;
		boolean isFinal = collision.isPositionFinal(oldPosition);
		collision.setFigure(new Field(oldPosition, isFinal));
		collision.setFigure(this);
	}
}
