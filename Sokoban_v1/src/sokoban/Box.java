package sokoban;

// Class representing a figure Box for the Sokoban game.
public class Box extends Figure {
	
	private boolean isFinal;

	public Box(Position position) {
		super(position);
		isFinal = false;
	}
	
	public Box(Position position, boolean isFinal) {
		super(position);
		this.isFinal = isFinal;
	}
	
	public boolean isFinal(){
		return isFinal;
	}

	@Override
	public void draw() {
		SokobanDrawer drawer = SokobanDrawer.getInstance();
		if (isFinal) {
			drawer.drawToSceen(this.position, Figures.FinalBox);
		} else {
			drawer.drawToSceen(this.position, Figures.Box);
		}
	}

	@Override
	public void move(Directions direction) {
		// Assumption: If the move method is called, then the move is valid
		Position nextPosition = this.position.getNextPosition(direction);
		Position oldPosition = this.position;
		this.position = nextPosition;
		Collision collision = Collision.getInstance();
		Board board = collision.getBoard();
		
		// If the current position is final restore a final field.
		boolean isFinal = collision.isPositionFinal(oldPosition);
		board.setFigure(new Field(oldPosition, isFinal));
		board.setFigure(this);
	}

}
