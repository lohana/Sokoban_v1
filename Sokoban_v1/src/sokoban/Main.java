package sokoban;

public class Main {
	
	public static int rows = 6;
	public static int cols = 6;
	
	// w - wall
	// f - field
	// v - final field
	// b - box
	// a - final box
	// p - player
	public static String BoardStore = "wwwwwwwpffvwwffbfwwffffwwfbfvwwwwwww";
	
	
	public static void main(String args[])
	{
		Game game = new Game();
		game.initializeGame(rows, cols, BoardStore);
	}
}
