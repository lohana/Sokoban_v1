package sokoban;

//Class representing a figure Empty field for the Sokoban game.
public class Field extends Figure {
	
	private boolean isFinal;

	public Field(Position position, boolean isFinal) {
		super(position);
		this.isFinal = isFinal;
	}

	@Override
	public void draw() {
		if (isFinal) {
			
		} else {
			
		}
	}

	@Override
	public void move(Directions direction) {
		return;
	}
	
	public boolean isFinal(){
		return isFinal;
	}
}
