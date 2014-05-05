package sokoban;

// 
public abstract class SokobanViewer {
	
	/*protected Board board;
	
	public SokobanViewer(Board board)
	{
		this.board = board;
	}*/
	
	public SokobanViewer()
	{
	}
	
	// Draws a player at specified position.
	public abstract void drawPlayer(IPosition position);
	
	// Draws an empty field at specified position.
	public abstract void drawEmptyField(IPosition position, boolean isFinalState);
	
	// Draws a box at specified position.
	public abstract void drawBox(IPosition position, boolean isFinalState);
		
	// Draws a wall at specified position.
	public abstract void drawWall(IPosition position);
}
