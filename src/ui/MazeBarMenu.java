package ui;

import java.io.IOException;

import javax.swing.*;

/** "Maze" tab of the Maze menu **/
@SuppressWarnings("serial")
public final class MazeBarMenu extends JMenu{
	private final ModifieMenuItem modifieMenuItem;
	private final ResolveMenuItem resolveMenuItem;
	private final InitMenuItem initMenuItem;
	
	public MazeBarMenu(MazeApp mazeApp) throws IOException {
		super("maze");

		add(modifieMenuItem = new ModifieMenuItem(mazeApp));
		add(resolveMenuItem = new ResolveMenuItem(mazeApp));
		add(initMenuItem = new InitMenuItem(mazeApp));
	}
}