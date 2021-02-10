package ui;

import java.awt.*;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import maze.*;

/** Model of the application **/
public final class MazeAppModel extends Observable {
	private MazeApp mazeApp;
	private Maze currentMaze;
	private MBox selectedBox = null;
	private Color selectedColor = null;
	private File currentFile = null;
	private int dimX ;
	private int dimY ;
	private boolean modifActive;
	private boolean modifications ;
	
	/** To choose the current tab in the control panel : 1=generatePanel / 2=drawMazePanel / 3=resolveButton **/
	private int selectedTab;
	
	public MazeAppModel(MazeApp mazeApp) {
		this.mazeApp = mazeApp;
		this.currentMaze = new Maze();
		modifActive = false;
		modifications = false;
		selectedTab = 3;
		addObserver(this.mazeApp);
	}
	
	/**Initializaing the Maze**/
	public void initMaze() {
		MBox[][] box = new MBox[dimY][dimX];
		for(int line=0; line<dimY;line++) {
			for(int column=0;column<dimX;column++) {
				box[line][column] = new EBox(line,column,currentMaze);
			}
		}
		
		currentMaze.setBoxes(box);
		
	}
	
	/**activate or block the possibility to modify the maze**/
	public void setModifActive(boolean bool) {
		if(bool == false)
			modifActive = false;
		if(bool == true) {
			modifActive = true;
		}
	}
	
	public File getCurrentFile() {
		return currentFile;
	}
	
	public boolean getModifActive() {
		return modifActive;
	}
	
	public boolean getModifications() {
		return modifications;
	}
	
	public void setCurrentMaze(Maze maze) {
		currentMaze = maze;
	}
	
	public Maze getCurrentMaze() {
		return currentMaze;
	}
	
	public MBox getBox(int line,int column) {
		return (MBox) currentMaze.getBoxes()[line][column];
	}
	
	/**Change a box of the table manually**/
	public void setBox(int line, int column) {
		if(selectedColor == Color.RED ) {
			setABox(line,column);
		}
		if(selectedColor == Color.GREEN ) {
			setDBox(line,column);
		}
		if(selectedColor == Color.WHITE) {
			setEBox(line,column);
		}
		if(selectedColor == Color.BLACK) {
			setWBox(line,column);
		}
		if(selectedColor == Color.YELLOW) {
			setPBox(line,column);
		}
	}
	
	
	public void setEBox(int line,int column) {
		currentMaze.getBoxes()[line][column] = new EBox(line,column,currentMaze);
	}
	
	public void setABox(int line,int column) {
		currentMaze.getBoxes()[line][column] = new ABox(line,column,currentMaze);
	}
	
	public void setWBox(int line,int column) {
		currentMaze.getBoxes()[line][column] = new WBox(line,column,currentMaze);
	}
	
	public void setDBox(int line,int column) {
		currentMaze.getBoxes()[line][column] = new DBox(line,column,currentMaze);
	}
	
	public void setPBox(int line,int column) {
		currentMaze.getBoxes()[line][column] = new PBox(line,column,currentMaze);
	}
	
	public Color getSelectedColor() {
		return selectedColor;
	}
	
	public int getDimX() {
		return dimX;
	}
	
	public void setDimX(int dimX) {
		this.dimX = dimX;
	}
	
	public int getDimY() {
		return dimY;
	}
	
	public void setDimY(int dimY) {
		this.dimY = dimY;
	}

	public void setSelectedBox(int posY, int posX) {
		selectedBox = (MBox) currentMaze.getVertexBox(posY, posX);
	}
	
	public void setSelectedTab(int tab) {
		selectedTab = tab;
		updateMaze();
	}
	
	public int getSelectedTab() {
		return selectedTab;
	}
	
	/** ALlow us to choose the type of box we're gonna display**/
	public void setSelectedColor(String buttonIndicator){
		switch(buttonIndicator) {
			case "A":
				if(isTypeOk("A")){
					selectedColor = Color.RED;
				} else {
					JOptionPane.showMessageDialog(null, "The maze must contain only one arrival box \nTo select a different arrival box, replace the current one by an empty box or by a wall box","Arrival box information", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			case "D": 
				if(isTypeOk("D")) {
					selectedColor = Color.GREEN;
				} else {
					JOptionPane.showMessageDialog(null, "The maze must contain only one departure box \nTo select a different departure box, replace the current one by an empty box or by a wall box","Departure box information", JOptionPane.INFORMATION_MESSAGE);
				}				
				break;	
			case "E": 
				selectedColor = Color.WHITE;break;
			case "W": 
				selectedColor = Color.BLACK;break;
			case "P": 
				selectedColor = Color.YELLOW;break;
			case "null": 
				selectedColor = null;break;
		}
		updateMaze();
	}
	
	//Verify if there is already a departure or arrival box in the maze
	public boolean isTypeOk(String buttonIndicator) {
		for(int line = 0; line<dimY; line++) {
			for(int column=0;column<dimX;column++) {
				if(currentMaze.getVertexBox(line,column).getLabel() == buttonIndicator) 
				return false;
			}
			
		}
		return true;
	}
	
	/**Color a selected box if it is possible**/
	
	public void colorSelecteBoxPanel() {
		currentMaze.initDrawPath();
		int x = selectedBox.getX();
		int y = selectedBox.getY();
		if(modifActive == true) {
			if( (selectedColor == Color.WHITE) || (selectedColor == Color.BLACK) || (selectedColor == Color.RED && isTypeOk("A")==true) || (selectedColor == Color.GREEN && isTypeOk("D")==true) ) {
				setBox(y,x);
			} else {
				JOptionPane.showMessageDialog(null, "The maze can only contain one arrival box and one departure box \nTo choose another one, replace it by a wall or empty box", "Arrival box error / Departure", JOptionPane.INFORMATION_MESSAGE);
			}
			modifications = true;
		}
		
		selectedBox = null;
		updateMaze();
	}
	
	/**Generate a random maze**/
	public void generateRandomMaze()
	{
		initMaze();
		//this loop generate departure and arrival distinct boxes
		int i=0;
		while(i!=2) {
			int xRandom = (int) (Math.random() * dimX);
			int yRandom = (int) (Math.random() * dimY);
			if(i==0) {
				setDBox( yRandom , xRandom);
				i=1;
			}
			if( i==1 && getBox( yRandom , xRandom).getLabel() != "D") {
				setABox( yRandom , xRandom);
				i=2;
			}
		}
		
		//This loop generate the rest of the maze
		double random;
		for(int line=0;line<dimY;line++) {
			for(int column=0;column<dimX;column++) {
				random = Math.random();
				if(getBox(line,column).getLabel() == "E") {
					if(random <= 0.35) { //This value fix the percentage of wallbox
						setWBox(line,column);
					}
				}
			
			}
		}
		
		//Test if the maze is solvable, if it isn't, generate a new one
		currentMaze.findPath();
		if(currentMaze.getIsSolvable() == false) {
			for(int line=0;line<dimY;line++) {
				for(int column=0;column<dimX;column++) {
					setEBox(line,column);
				}
			}
			generateRandomMaze();
		}
		modifications = true;
		updateMaze();
	}
	
	/**Generate a popup window at the application initialization**/
	private void setDimPopUp() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
        JTextField txt1 = new JTextField();
        txt1.setColumns(10);
        JTextField txt2 = new JTextField();
        txt2.setColumns(10);
        panel.add(new JLabel("Number of line (between 3 and 50) : "));
        panel.add(txt1);
        panel.add(new JLabel("Number of colomn (between 3 and 50) : "));
        panel.add(txt2);
        
        Object[] option = {"OK"};
        int popup;
        popup = JOptionPane.showOptionDialog(null, panel,"Choice of maze size",0,JOptionPane.QUESTION_MESSAGE,null,option, null);
        if(popup == JOptionPane.CLOSED_OPTION) {
        	if(JOptionPane.showConfirmDialog(null, "Do you want quit this application", "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        		System.exit(0);
        	else 
        		setDimPopUp();
        }
        
        try {
			 Integer.parseInt(txt1.getText());
			 Integer.parseInt(txt2.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "The value entered is uncorrect, please write a correct value (Integer expected)","Size error", JOptionPane.INFORMATION_MESSAGE);
			setDimPopUp();
        }
        int Y = Integer.parseInt(txt1.getText());
        int X = Integer.parseInt(txt2.getText());
        
        if(Y<=50 && Y >= 3)
        	dimY =Y;
        else {
        	Object[] option1 = {"OK"};
        	JOptionPane.showOptionDialog(null, "Uncorrect number of lines","Choice of maze size",0,JOptionPane.QUESTION_MESSAGE,null,option1, null);
        	setDimPopUp();
        }
        if(X<=50 && X>=3)
        	dimX=X;
        else {
        	Object[] option1 = {"OK"};
        	JOptionPane.showOptionDialog(null, "Uncorrect number of columns","Choice of maze size",0,JOptionPane.QUESTION_MESSAGE,null,option1, null);
        	setDimPopUp();
        }
	}
	
	/**Generate a popup menu when generating a new maze**/
	public void setMazePopUp() throws IOException
	{
		String option[] = {"Load","Create"};
		int choice = JOptionPane.showOptionDialog(null, "Load an existing Maze or a new one ?", "Maze a choice", 0, 
										JOptionPane.INFORMATION_MESSAGE,null, option,null);
		
		if(choice == 1) {
			setDimPopUp();
			initMaze();
			selectedTab = 1;
		} else if(choice == 0) {
			modifActive = false;
			FileChooser fileChooser = new FileChooser();
			
			if(fileChooser.getReturnVal() != JFileChooser.APPROVE_OPTION) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to save the maze ?", "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
	        		System.exit(0);
	        	else 
	        		setMazePopUp();
			}
			
			currentFile = fileChooser.getSelectedFile();
			currentMaze.initFromTextFile(currentFile);
			
			dimY = currentMaze.getNbLines();
			dimX = currentMaze.getNbColumns();

			selectedTab = 3;
		} else if(choice == JOptionPane.CLOSED_OPTION) {
        	if(JOptionPane.showConfirmDialog(null, "Do you want to save the maze ?", "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        		System.exit(0);
        	else 
        		setMazePopUp();
        }
		
	}
	
	/** When activate the save menu button**/
	public void saveButtonAction() throws IOException {	
		if(currentFile == null) {
			saveAsButtonAction();
		} else {
			currentMaze.saveToTextFile(currentFile);
		}
		modifications = false;
	}
	
	/** Menu "save as" action button**/
	public void saveAsButtonAction() throws IOException {	
		JFileChooser fileChooser = new JFileChooser(new File(".").getCanonicalFile() + "//data");
		fileChooser.setFileFilter(new FileNameExtensionFilter("Text file","txt"));
		fileChooser.setDialogTitle("Save the actual Maze");
		int valRetour = fileChooser.showSaveDialog(null);
		
		if(valRetour == JFileChooser.APPROVE_OPTION) {
			currentFile = fileChooser.getSelectedFile();
			if(!currentFile.exists()) {
				currentMaze.saveToTextFile(currentFile);
			} else {
				String options[] = {"Replace","Change Maze name","Aboard"};
				int choice;
				choice = JOptionPane.showOptionDialog(null, "The file " + currentFile +" Already exists\nChoose one of the following option :" , "File already existing", 0, JOptionPane.INFORMATION_MESSAGE,null, options,null);
				
				switch(choice) {
				case 0 : 
					currentMaze.saveToTextFile(currentFile);
					break;
				case 1 : 
					saveAsButtonAction();break;
				case 2 : break;
				}
			}
		}
		modifications = false;
	}

	/** Open an existing maze that has been saved on the data folder**/
	public void openExistingMaze() throws IOException{
		if(modifications == true || currentFile == null) {
			String[] options = {"Save","Continue"};
			if(JOptionPane.showOptionDialog(null, "Do you want to save the current Maze?" , "Save", 0,JOptionPane.INFORMATION_MESSAGE,null,options, null) == 0) {
				saveButtonAction();
			} 
		}
		
		modifActive = false;
		FileChooser fileChooser = new FileChooser();
		Maze maze = new Maze();
		currentFile = fileChooser.getSelectedFile();
		maze.initFromTextFile(currentFile);
		currentMaze = maze;
		dimX = currentMaze.getNbColumns();
		dimY = currentMaze.getNbLines();
		modifications = false;
		selectedTab = 3;
		updateMaze();
	}
	/** Open a brand new Maze with empty boxes**/
	public void openNewMaze() throws IOException, UnsupportedLookAndFeelException {
		if(modifications == true || currentFile == null) {
			String[] options = {"Save","Continue"};
			if(JOptionPane.showOptionDialog(null, "Do you want to save the current Maze?" , "Save", 0,JOptionPane.INFORMATION_MESSAGE,null,options, null) == 0) {
				saveButtonAction();
			} 
		}
		currentFile = null;
		modifActive = true;
		currentMaze = new Maze();
		
		setDimPopUp();
		initMaze();
		selectedTab = 1;
		updateMaze();
	}
	/**  Resolve the maze, by achieving the dijkstra algorithm in the Maze **/
	public void resolveMaze() throws InterruptedException, IOException, UnsupportedLookAndFeelException {
		currentMaze.findPath();
		if(currentMaze.getIsSolvable()==true) {
			currentMaze.drawPath();
			updateMaze();
		} else {
			JOptionPane.showMessageDialog(null, "Maze does not have any solution", "Warning", JOptionPane.INFORMATION_MESSAGE);
			selectedTab = 2;
			currentMaze.initDrawPath();
			updateMaze();
			return;
		}

	}
	
	/**Allow us to quit the application, if maze has been saved**/
	public void quitApp() {
			String[] options = {"Save","Quit","Cancel"};
			int returnValue = JOptionPane.showOptionDialog(null, "Do you want to save this current maze ?" , "Save", 0,JOptionPane.INFORMATION_MESSAGE,null,options, null);
			if(returnValue == 0) {
				try {
					saveButtonAction();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.exit(0);
			} else if(returnValue == 1) {
				System.exit(0);
			} 
		}
	
	
	/**To replace the current maze by an empty maze with the same size
	 * @throws IOException */
	public void initMenuButtonAction() throws IOException {
		if(modifications == true || currentFile == null) {
			String[] options = {"Save","Continue"};
			if(JOptionPane.showOptionDialog(null, "Do you want to save the current Maze?" , "Save", 0,JOptionPane.INFORMATION_MESSAGE,null,options, null) == 0) {
				saveButtonAction();
			} 
		}
		initMaze();
		modifications = true;
		updateMaze();
	}
	
	public void updateMaze() {
		setChanged();
		notifyObservers();
	}
}
