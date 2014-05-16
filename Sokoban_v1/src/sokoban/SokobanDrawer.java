package sokoban;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

// Singleton for drawing the figures
public class SokobanDrawer implements KeyListener{
	
	private static volatile SokobanDrawer instance = new SokobanDrawer();

	private ArrayList<IArrowKeyListener> listeners = new ArrayList<IArrowKeyListener>();
	
	private static final int ImageSize = 32;
	
	private int rows;
	private int cols;
	private JFrame window = new JFrame();
	
	private BufferedImage field;
	private BufferedImage finalField;
	private BufferedImage wall;
	private BufferedImage player;
	private BufferedImage box;
	private BufferedImage finalBox;
	 
    // private constructor
    private SokobanDrawer() {
    }
    
    public void initializeScreen(int rows, int cols) {
    	this.rows = rows;
    	this.cols = cols;
    	
    	this.window.setTitle("Sokoban");
		this.window.setBounds(0, 0, ImageSize * (this.rows + 1), ImageSize * (this.cols + 1));
		this.window.setSize(250, 250);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.getContentPane().setLayout(null);
		this.window.setLocationRelativeTo(null);
		this.window.addKeyListener(this);
		this.window.setResizable(false);
		
		try {
			field = ImageIO.read(new File("./Field.png"));
			finalField = ImageIO.read(new File("./FinalField.png"));
			wall = ImageIO.read(new File("./Wall.png"));
			player = ImageIO.read(new File("./Player.png"));
			box = ImageIO.read(new File("./Box.png"));
			finalBox = ImageIO.read(new File("./FinalBox.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				JLabel label = new JLabel();
				ImageIcon icon = new ImageIcon(wall);
				icon.setImage(icon.getImage());
				label.setIcon(icon);
				label.setBounds(i * ImageSize, j * ImageSize, ImageSize, ImageSize);
				label.setBorder(null);
				this.window.getContentPane().add(label);
			}
		}
    	
		this.window.setVisible(true);
    }
 
    public static SokobanDrawer getInstance() {
        return instance;
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
		icon.setImage(icon.getImage());
		label.setIcon(icon);
		label.setBorder(null);
		label.repaint();
		this.window.repaint();
	}
	
	public void keyPressed(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	        	fireEvent(Directions.Up);
	            break;
	        case KeyEvent.VK_DOWN:
	        	fireEvent(Directions.Down);
	            break;
	        case KeyEvent.VK_LEFT:
	        	fireEvent(Directions.Left);
	            break;
	        case KeyEvent.VK_RIGHT :
	        	fireEvent(Directions.Right);
	            break;
	     }
	}
	
	public void addListener(IArrowKeyListener toAdd) {
        listeners.add(toAdd);
    }
	
	private void fireEvent(Directions direction) {
		for (IArrowKeyListener listener : listeners) {
			listener.arrowPressed(direction);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {	
	} 
}
