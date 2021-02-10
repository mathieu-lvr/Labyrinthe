package ui;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

/** Button of the "maze" tab of the menu bar that allows you to modify a maze **/
@SuppressWarnings("serial")
public final class ResolveMenuItem extends JMenuItem implements ActionListener {
	private final MazeApp mazeApp;
	
	public ResolveMenuItem(MazeApp mazeApp) {
		super("Solve Maze");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		try {
			mazeApp.getModel().resolveMaze();
		} catch (InterruptedException | IOException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}