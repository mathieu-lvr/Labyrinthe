package ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.*;
import javax.swing.*;

/** Launch the 2 things needed for the application, the Model, and the window Panel**/
@SuppressWarnings("serial")
public final class MazeApp extends JFrame implements Observer {
	private final MazeAppMenu mazeAppMenu;
	private final WindowPanel windowPanel;
	private MazeAppModel model = new MazeAppModel(this);
	
	public MazeApp() throws IOException {
		super("Maze App"); //title of the window
		
		
		
		setJMenuBar(mazeAppMenu = new MazeAppMenu(this));
		setContentPane(windowPanel = new WindowPanel(this));
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //stop the application when we close it
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(false);
		
		pack();
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent we) {
				  model.quitApp();
			  }
		});
	} 
	
	public final MazeAppModel getModel() {
		return model;
	}
	
	public void update(Observable observable, Object object) {
		try {
			notifyForUpdate();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		validate();
	}
	
	public void notifyForUpdate() throws IOException {
		windowPanel.notifyForUpdate();
	}
	
}
