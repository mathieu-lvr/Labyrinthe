package ui;

import java.awt.event.*;
import javax.swing.*;

/** Button in the "file" tab of the menu bar to quit the application **/
public final class QuitMenuItem extends JMenuItem implements ActionListener {
	private final MazeApp mazeApp;
	
	public QuitMenuItem(MazeApp mazeApp) {
		super("Quit");
		this.mazeApp = mazeApp;
		
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		mazeApp.getModel().quitApp();
	}
}
