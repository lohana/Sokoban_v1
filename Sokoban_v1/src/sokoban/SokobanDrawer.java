package sokoban;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

// Singleton for drawing the figures
public class SokobanDrawer {
	
	private static volatile SokobanDrawer instance = new SokobanDrawer();
	
	private static final int ImageSize = 32;
	
	private final int rows = 4;
	private final int cols = 3;
	private JFrame window = new JFrame();
	
	private BufferedImage field;
	private BufferedImage finalField;
	private BufferedImage wall;
	private BufferedImage player;
	private BufferedImage box;
	private BufferedImage finalBox;
	private Game game;
	 
    // private constructor
    private SokobanDrawer() {
    	this.window.setTitle("Sokoban");
		this.window.setBounds(0, 0, ImageSize * rows, ImageSize * cols);
		this.window.setSize(ImageSize * rows, ImageSize * cols);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.getContentPane().setLayout(null);
		this.window.setLocationRelativeTo(null);
		//this.window.setResizable(false);
		
		try {
			field = ImageIO.read(new File("./Field.png"));
			finalField = ImageIO.read(new File("./FinalField.png"));
			wall = ImageIO.read(new File("./Wall.png"));
			player = ImageIO.read(new File("./Player.png"));
			box = ImageIO.read(new File("./Box.png"));
			finalBox = ImageIO.read(new File("./FinalBox.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Game game = new Game(rows, cols);
		Collision collision = Collision.getInstance();
		Board board = collision.getBoard();
		BufferedImage currentIcon = null;
		
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				JLabel label = new JLabel();
				label.setSize(ImageSize, ImageSize);
				Figure currentFigure = board.getFigure(new Position(i,j));
				if (currentFigure instanceof Field){
					if (((Field) currentFigure).isFinal())
						currentIcon = finalField;
					else
						currentIcon = field;
				} else if (currentFigure instanceof Wall)
					currentIcon = wall;
				else if (currentFigure instanceof Player)
					currentIcon = player;
				else if (currentFigure instanceof Box)
					currentIcon = box;
				else
					currentIcon = wall;
				
				ImageIcon icon = new ImageIcon(currentIcon);
				icon.setImage(icon.getImage());
				label.setIcon(icon);
				label.setBounds(i * ImageSize, j * ImageSize, i * ImageSize + ImageSize, j * ImageSize + ImageSize);
				this.window.getContentPane().add(label);
				
			}
		}

		this.window.setVisible(true);
    }
 
    public static SokobanDrawer getInstance() {
        return instance;
    }
    
    public int getRows(){
    	return rows;
    }
    
    public int getCols(){
    	return cols;
    } 

	public void drawToSceen(Position position, Figures figure) {
		JLabel label = (JLabel)this.window.getContentPane().getComponent(position.getX() * cols + position.getY());
		BufferedImage image = wall;
		switch (figure) {
			case Box: image = box; break;
			case FinalBox: image = finalBox; break;
			case Field: image = field; break;
			case FinalField: image = finalField; break;
			case Player: image = player; break;
			case Wall: image = wall; break;
		}
		ImageIcon icon = new ImageIcon(image);
		icon.setImage(icon.getImage().getScaledInstance(ImageSize, ImageSize, 10));
		label.setIcon(icon);
		label.repaint();
		this.window.repaint();
	}
}
