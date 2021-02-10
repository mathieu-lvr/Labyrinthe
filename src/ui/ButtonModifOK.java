package ui;

import java.awt.event.*;
import javax.swing.*;

/** Allow us to validate the changes done to the Maze **/
@SuppressWarnings("serial")
public final class ButtonModifOK extends JButton implements ActionListener {
	private final MazeApp mazeApp;
	
	public ButtonModifOK(MazeApp mazeApp) {
		super("creation of the maze is complete");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	public final void actionPerformed(ActionEvent evt) {
		if(JOptionPane.showConfirmDialog(null,"Please confirm your modification are finished","Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
			mazeApp.getModel().setModifActive(false);
			mazeApp.getModel().setSelectedTab(3);
		}
	}
}
