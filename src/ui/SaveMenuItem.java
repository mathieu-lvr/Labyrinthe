package ui;

import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

/** Button in the "file" tab of the menu bar to save the current maze in the current file or otherwise in another file**/
@SuppressWarnings("serial")
public final class SaveMenuItem extends JMenuItem implements ActionListener {
	private final MazeApp mazeApp;
	
	public SaveMenuItem(MazeApp mazeApp) {
		super("Save Maze");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		try {
			mazeApp.getModel().saveButtonAction();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}