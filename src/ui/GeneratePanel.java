package ui;

import java.awt.*;

import javax.swing.*;

/** Class representing 2 things : the random generation and the manual generation of the maze **/
@SuppressWarnings("serial")
public final class GeneratePanel extends JPanel {
	private final MazeApp mazeApp;
	private final RandomGenerateButton random;
	private final ManualGenerateButton manual;
	
	public GeneratePanel(MazeApp mazeApp) {
		super();
		this.mazeApp = mazeApp;
		setLayout(new GridLayout(3,1));
		
		add(new JLabel("How to generate the maze ?",JLabel.CENTER));
		add(random = new RandomGenerateButton(mazeApp));
		add(manual = new ManualGenerateButton(mazeApp));
	}
}