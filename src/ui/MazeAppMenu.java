package ui;

import java.io.IOException;

import javax.swing.*;

/** Menu bar of the application **/
@SuppressWarnings("serial")
public final class MazeAppMenu extends JMenuBar {
	private FileMenu fileMenu;
	private MazeBarMenu mazeMenu;
	
	public MazeAppMenu(MazeApp mazeApp) throws IOException {
		super();
		
		add(fileMenu = new FileMenu(mazeApp));
		add(mazeMenu = new MazeBarMenu(mazeApp));
	}

}
