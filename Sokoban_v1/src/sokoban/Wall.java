package sokoban;

// Class representing a figure Wall for the Sokoban game.
public class Wall extends Figure {

	public Wall(Position position) {
		super(position);
	}

	@Override
	public void draw() {
		SokobanDrawer drawer = SokobanDrawer.getInstance();
		drawer.drawToSceen(this.position, Figures.Wall);
	}

	@Override
	public void move(Directions direction) {
		return;
	}
}
