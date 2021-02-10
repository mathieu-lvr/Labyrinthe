package ui;

import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**Window to choose the text file**/
@SuppressWarnings("serial")
public final class FileChooser extends JFileChooser {
	private File selectedFile;
	private int returnVal;
	
	public FileChooser() throws IOException {
		super(new File(".").getCanonicalFile() + "//data"); //Put the file chooser in the data folder of the project
		setDialogTitle("Open a new maze");
		this.setFileFilter(new FileNameExtensionFilter("file text","txt"));
        returnVal = showOpenDialog(null);
        if(returnVal == APPROVE_OPTION)
        	selectedFile = getSelectedFile();
	}
	
	public File getFile() {
		return selectedFile;
	}
	
	public int getReturnVal() {
		return returnVal;
	}
}
