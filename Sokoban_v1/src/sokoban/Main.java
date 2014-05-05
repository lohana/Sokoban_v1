package sokoban;

import java.awt.*;
import java.io.IOException;

import javax.swing.*; 

public class Main {
	public static void main(String args[]) throws IOException
	{
		GUI gui = new GUI();
		gui.setImage(1, 2, Figures.Field);
		gui.setImage(3, 2, Figures.Player);
		GUISokobanViewer viewer = new GUISokobanViewer(gui);
		//viewer.drawWall(new Position());
		
	}
}
