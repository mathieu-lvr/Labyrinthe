package ui;

import java.awt.event.*;
import javax.swing.*;

/** Window button "GeneratePanel" to randomly generate a new labyrinth **/
@SuppressWarnings("serial")
public final class RandomGenerateButton extends JButton implements ActionListener {
	private final MazeApp mazeApp;
	
	public RandomGenerateButton(MazeApp mazeApp) {
		super("Random Generate");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		this.mazeApp.getModel().generateRandomMaze();
	}
}
