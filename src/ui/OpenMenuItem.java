package ui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import maze.*;

/** Button in the "file" tab of the menu bar to load an existing maze **/
public final class OpenMenuItem extends JMenuItem implements ActionListener{
	private MazeApp mazeApp;
	
	public OpenMenuItem(MazeApp mazeApp) throws IOException {
		super("Open an existing Maze");
		this.mazeApp = mazeApp;
		
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		try {
			mazeApp.getModel().openExistingMaze();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
