package ui;

import javax.swing.*;

/** Put the name of the selected file on the top of the maze Panel **/
@SuppressWarnings("serial")
public final class FileLabel extends JLabel {
	private final MazeApp mazeApp;
	
	public FileLabel(MazeApp mazeApp) {
		super();
		this.mazeApp = mazeApp;
		setHorizontalAlignment(JLabel.CENTER);
		
		notifyForUpdate();
	}

	public void notifyForUpdate() {
		if(this.mazeApp.getModel().getCurrentFile() != null) {
			setText("File name : " + this.mazeApp.getModel().getCurrentFile().getName());
		} else {
			setText("No file selected");
		}
	}
}
