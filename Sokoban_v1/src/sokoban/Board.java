package sokoban;

import java.util.ArrayList;

// Class representing a figure Board for the Sokoban game.
public class Board extends Figure{

	private Figure[][] figures;
	private ArrayList<Position> finalPositions = new ArrayList<Position>();

	public Board(Position position, int rows, int cols) {
		super(position);
		figures = new Figure[rows][cols];
	}

	@Override
	public void draw() {
		for (int i = 0; i < figures.length; i++) {
			for (int j = 0; j < figures[0].length; j++) {
				figures[i][j].draw();
			}
		}
	}

	@Override
	public void move(Directions direction) {
		return;
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