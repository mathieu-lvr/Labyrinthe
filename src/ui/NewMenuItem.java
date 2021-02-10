package ui;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

/** Button in the "file" tab of the menu bar to create a new maze **/
public final class NewMenuItem extends JMenuItem implements ActionListener{
	private final MazeApp mazeApp;

	public NewMenuItem(MazeApp mazeApp) {
		super("New Maze");
		this.mazeApp = mazeApp;
		
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		try {
			this.mazeApp.getModel().openNewMaze();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}