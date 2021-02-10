package ui;

import java.io.IOException;

import javax.swing.*;

/** Classe representing the file part of the menu **/
@SuppressWarnings("serial")
public final class FileMenu extends JMenu{
	private final QuitMenuItem quitMenuItem;
	private final NewMenuItem newMenuItem;
	private final OpenMenuItem openMenuItem;
	private final SaveMenuItem saveMenuItem;
	private final SaveAsMenuItem saveAsMenuItem;
	
	public FileMenu(MazeApp mazeApp) throws IOException {
		super("File");

		add(newMenuItem = new NewMenuItem(mazeApp));
		add(openMenuItem = new OpenMenuItem(mazeApp));
		add(saveMenuItem = new SaveMenuItem(mazeApp));
		add(saveAsMenuItem = new SaveAsMenuItem(mazeApp));
		add(quitMenuItem = new QuitMenuItem(mazeApp));
	}
}