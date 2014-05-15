package sokoban;

//Class representing a figure Empty field for the Sokoban game.
public class Field extends Figure {
	
	private boolean isFinal;

	public Field(Position position) {
		super(position);
		this.isFinal = false;
	}
	
	public Field(Position position, boolean isFinal) {
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
			drawer.drawToSceen(this.position, Figures.FinalField);
		} else {
			drawer.drawToSceen(this.position, Figures.Field);
		}
	}

	@Override
	public void move(Directions direction) {
		return;
	}
}
