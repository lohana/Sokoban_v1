package sokoban;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI {

	private final int rows = 4;
	private final int cols = 3;
	private JFrame window = new JFrame();
	// JPanel panel = new JPanel(new GridLayout(rows, rows, cols, cols));
	
	private BufferedImage field;
	private BufferedImage finalField;
	private BufferedImage wall;
	private BufferedImage player;
	private BufferedImage box;
	private BufferedImage finalBox;
	
	public GUI() throws IOException {

		this.window.setTitle("Sokoban");
		this.window.setBounds(0, 0, 100, 160);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.getContentPane().setLayout(new GridLayout(rows, cols));
		this.window.getContentPane().setSize(96, 128);
		this.window.setLocationRelativeTo(null);
		this.window.setResizable(false);
		
		field = ImageIO.read(new File("./Field.png"));
		finalField = ImageIO.read(new File("./FinalField.png"));
		wall = ImageIO.read(new File("./Wall.png"));
		player = ImageIO.read(new File("./Player.png"));
		box = ImageIO.read(new File("./Box.png"));
		finalBox = ImageIO.read(new File("./FinalBox.png"));

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				JLabel label = new JLabel();
				label.setSize(32, 32);
				ImageIcon icon = new ImageIcon(wall);
				icon.setImage(icon.getImage());
				label.setIcon(icon);
				this.window.getContentPane().add(label);
			}
		}

		this.window.setVisible(true);
	}
	
	public void setImage(int x, int y, Figures figure)
	{
		JLabel label = (JLabel)this.window.getContentPane().getComponent(x * cols + y);
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
		icon.setImage(icon.getImage().getScaledInstance(32, 32, 10));
		label.setIcon(icon);
		label.repaint();
		this.window.repaint();
	}
	
}
