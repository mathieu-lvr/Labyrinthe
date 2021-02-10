package ui;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.*;
import dijkstra.ASet;
import dijkstra.Dijkstra;
import dijkstra.Pi;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;
import dijkstra.Previous;
import maze.EBox;
import maze.Maze;

/** Main window of the application **/
@SuppressWarnings("serial")
public final class WindowPanel extends JPanel {
	private final MazeApp mazeApp;
	private MazePanel mazePanel;
	private ControlPanel controlPanel;
	private FileLabel fileLabel;
	
	public WindowPanel(MazeApp mazeApp) throws IOException {
		super();
		this.mazeApp = mazeApp;
		this.mazeApp.getModel().setMazePopUp();
		initWindowPanel();
	}	
	
	/** initialization Main window of the application **/
	public void initWindowPanel() {
		setLayout(new BorderLayout());
		add(fileLabel = new FileLabel(mazeApp),BorderLayout.NORTH);
		try {
			add(mazePanel = new MazePanel(mazeApp),BorderLayout.CENTER);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		add(controlPanel = new ControlPanel(mazeApp, this),BorderLayout.EAST);
				
	}
	
	public void notifyForUpdate(){
		remove(mazePanel);
		add(mazePanel = new MazePanel(mazeApp),BorderLayout.CENTER);
		fileLabel.notifyForUpdate();
		controlPanel.notifyForUpdate();
		validate();
	}
	
	public ControlPanel getControlPanel() {
		return controlPanel;
	}
	
	public FileLabel getFileLabel() {
		return fileLabel;
	}
	
	public void setFileLabel() {
		fileLabel = new FileLabel(mazeApp);
	}
	
	public MazePanel getMazePanel() {
		return mazePanel;
	}
	
	public void setMazePanel(MazePanel mazePanel) {
		this.mazePanel = mazePanel;
	}
}
