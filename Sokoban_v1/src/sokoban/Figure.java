package sokoban;

// Abstract class representing a element that has position, can move and draw itself.
public abstract class Figure{
	
	protected SokobanViewer viewer;
	protected IPosition position;

	public Figure(Position position, SokobanViewer viewer)
	{
		this.viewer = viewer;
		this.position = position;
	}
	
	// This method have to be implemented by deriving classes.
	// Draws the figure using the viewer object passed in the constructor.
	public abstract void draw();
	
	// This method have to be implemented by deriving classes.
	public abstract void move();
}
