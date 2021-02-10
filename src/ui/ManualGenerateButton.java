package ui;

import java.awt.event.*;
import javax.swing.*;

/** Allow us to generate a new maze manually **/
@SuppressWarnings("serial")
public final class ManualGenerateButton extends JButton implements ActionListener{
	private final MazeApp mazeApp;
	
	public ManualGenerateButton(MazeApp mazeApp) {
		super("Manual Generate");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		mazeApp.getModel().setSelectedTab(2);
		mazeApp.getModel().setModifActive(true);
	}
}
