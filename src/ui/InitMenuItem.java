package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JMenuItem;
import javax.swing.UnsupportedLookAndFeelException;

public final class InitMenuItem extends JMenuItem implements ActionListener {
	private final MazeApp mazeApp;
	
	public InitMenuItem(MazeApp mazeApp) {
		super("Init Maze");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		try {
			mazeApp.getModel().initMenuButtonAction();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

