package ui;

import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

/** Button in the "file" tab of the menu bar to save the current maze in a file **/
@SuppressWarnings("serial")
public final class SaveAsMenuItem extends JMenuItem implements ActionListener {
	private final MazeApp mazeApp;
	
	public SaveAsMenuItem(MazeApp mazeApp) {
		super("Save Maze as");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		try {
			mazeApp.getModel().saveAsButtonAction();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}