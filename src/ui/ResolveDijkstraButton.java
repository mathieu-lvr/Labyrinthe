package ui;

import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.UnsupportedLookAndFeelException;

/** Button which allow us to resolve the maze **/
@SuppressWarnings("serial")
public final class ResolveDijkstraButton extends JButton 
implements ActionListener
{
	private final MazeApp mazeApp;
	private final WindowPanel windowPanel;
	
	public ResolveDijkstraButton(MazeApp mazeApp,WindowPanel windowPanel) {
		super("Find the best path");
		setBackground(Color.YELLOW);
		setForeground(Color.BLACK);
		this.mazeApp = mazeApp;
		this.windowPanel = windowPanel;
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