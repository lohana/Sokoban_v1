package sokoban;

// Class representing a figure Wall for the Sokoban game.
public class Wall extends Figure {

	public Wall(Position position, SokobanViewer viewer) {
		super(position, viewer);
	}

	@Override
	public void draw() {
		viewer.drawWall(position);
	}

	@Override
	public void move() {
		return;
	}

}
