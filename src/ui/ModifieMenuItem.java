package ui;

import java.awt.event.*;
import javax.swing.*;

/** Button to allow modifications **/
@SuppressWarnings("serial")
public final class ModifieMenuItem extends JMenuItem implements ActionListener {
	private final MazeApp mazeApp;
	
	public ModifieMenuItem(MazeApp mazeApp) {
		super("Edit Maze");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		mazeApp.getModel().setModifActive(true);
		mazeApp.getModel().setSelectedTab(2);
	}
}