package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import maze.ABox;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Image;

/** represent the maze graphically **/
@SuppressWarnings("serial")
public final class BoxPanel extends JButton implements ActionListener {
	private MazeApp mazeApp;
	int x;
	int y;
	private BufferedImage cherry;
	private BufferedImage PacMan;
	private BufferedImage BlackBox;
	private BufferedImage YellowPoint;
	private BufferedImage Wall;

	BufferedImage bi;
	public String type = null;

	public BoxPanel(MazeApp mazeApp, int x, int y) {
		super(ABox.imageArrival);
		this.mazeApp = mazeApp;
		this.x = x;
		this.y = y;

		File fileCherry = new File("src/picture/ArrivalBoxTexture.PNG");
		try {
			cherry = ImageIO.read(fileCherry);
		} catch (IOException e) {
			System.out.println("Cannot read the image file");
		}

		File filePacMan = new File("src/picture/DepartureBoxTexture.png");
		try {
			PacMan = ImageIO.read(filePacMan);
		} catch (IOException e) {
			System.out.println("Cannot read the image file");
		}

		/*File fileBlackBox = new File("src/picture/EmptyBoxTexture.PNG");
		try {
			BlackBox = ImageIO.read(fileBlackBox);
		} catch (IOException e) {
			System.out.println("Cannot read the image file");
		}*/

		File fileYellowPoint = new File("src/picture/PathBoxTexture.png");
		try {
			YellowPoint = ImageIO.read(fileYellowPoint);
		} catch (IOException e) {
			System.out.println("Cannot read the image file");
		}

		File fileWall = new File("src/picture/WallTextureBox.png");
		try {
			Wall = ImageIO.read(fileWall);
		} catch (IOException e) {
			System.out.println("Cannot read the image file");
		}

		String label = mazeApp.getModel().getCurrentMaze().getVertexBox(y, x).getLabel();
		this.type = label;

		setOpaque(true);
		setContentAreaFilled(true);
		setBorderPainted(false);
		addActionListener(this);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (type.equals("A")) {
			setBackground(Color.RED);
			Image image = cherry.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			g.drawImage(image, (int) this.getWidth() / 4, (int) this.getHeight() / 4, null);
		}

		if (type.equals("D")) {
			setBackground(Color.GREEN);
			Image image = PacMan.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			g.drawImage(image, (int) this.getWidth() / 4, (int) this.getHeight() / 4, null);
		}

		if (type.equals("W")) {
			setBackground(Color.BLUE);
			Image image = Wall.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			g.drawImage(image, (int) this.getWidth() / 4, (int) this.getHeight() / 4, null);
		}

		if (type.equals("E")) {
			setBackground(Color.BLACK);
			/*Image image = BlackBox.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			g.drawImage(image, (int) this.getWidth() / 4, (int) this.getHeight() / 4, null);*/
		}

		if (type.equals("P")) {
			setBackground(Color.YELLOW);
			Image image = YellowPoint.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			g.drawImage(image, (int) this.getWidth() / 4, (int) this.getHeight() / 4, null);
		}

	}

	public final void actionPerformed(ActionEvent evt) {
		mazeApp.getModel().setSelectedBox(y, x);
		mazeApp.getModel().colorSelecteBoxPanel();
	}

}
