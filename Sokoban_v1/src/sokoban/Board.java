package sokoban;

import java.util.ArrayList;

// Class representing a figure Board for the Sokoban game.
public class Board extends Figure{
	
	private Figure[][] figures;
	private ArrayList<Position> finalPositions;
	private Player player;

	public Board(Position position, int rows, int cols) {
		super(position);
		figures = new Figure[rows][cols];
	}

	@Override
	public void draw() {
		
	}

	@Override
	public void move(Directions direction) {
		
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Figure getFigure(Position position) {
		return figures[position.getX()][position.getY()];
	}
	
	
	public void setFigure(Figure figure){
		if (figure instanceof Field){
			if ( ((Field) figure).isFinal() ) 
				finalPositions.add(figure.getPosition());
		}
		
		figures[figure.position.getX()][figure.position.getY()] = figure;
	}
	
	public ArrayList<Position> getFinalPositions(){
		return finalPositions;
	}
}
