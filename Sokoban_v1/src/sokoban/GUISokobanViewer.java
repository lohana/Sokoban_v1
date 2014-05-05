package sokoban;

public class GUISokobanViewer extends SokobanViewer{

	/*public GUISokobanViewer(Board board) {
		super(board);
		// TODO Auto-generated constructor stub
	}*/
	private GUI gui;
	
	public GUISokobanViewer(GUI gui)
	{
		super();
		this.gui = gui;
	}

	@Override
	public void drawPlayer(IPosition position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawEmptyField(IPosition position, boolean isFinalState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawBox(IPosition position, boolean isFinalState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawWall(IPosition position) {
		// TODO Auto-generated method stub
		
	}

}
