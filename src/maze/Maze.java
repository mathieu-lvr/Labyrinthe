package maze;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import dijkstra.Dijkstra;
import dijkstra.GraphInterface;
import dijkstra.VertexInterface;

/** Represent a new Graph (Maze) **/
public final class Maze implements GraphInterface{
	PrintStream out = System.out;
	private ArrayList<VertexInterface> shortestPath;

	boolean isSolvable;
	private MBox[][] boxes=null; //Contains every boxes in the maze, identified by their x and y coordonates
	
	public Maze() {
		this.shortestPath = null;
		this.boxes = null;
		this.isSolvable = false;
	}
	
	/* Read the text file labyrinthe.txt to create the maze */
	public final void initFromTextFile(File file) throws IOException {
		BufferedReader R = new BufferedReader(new FileReader(file));
		
		String line;
		char c;
		int y=0;
		line = R.readLine();
		int nbColumns = line.length();
		
		int nbLines=0;
		while(line != null){
			nbLines++;
			line = R.readLine();
		}
		R.close();
		
		MBox[][] m = new MBox[nbLines][nbColumns];
		
		BufferedReader R2 = new BufferedReader(new FileReader(file));
		line = R2.readLine();
		while(line != null){
			for(int x=0;x<nbColumns;x++) {
				c=line.charAt(x);
				switch(c) {
					case 'A' : m[y][x] = new ABox(y,x,this);break;
					case 'D' : m[y][x] = new DBox(y,x,this);break;
					case 'E': case'P' : m[y][x] = new EBox(y,x,this);break; //les case PBox sont initilis� en EBox (chemin non visible)
					case 'W' : m[y][x] = new WBox(y,x,this);break;
				}
			}
			line = R2.readLine();
			y++;
		}
		boxes = m;
		R2.close();
	}
	
	/*Write maze state to a file*/
	public final void saveToTextFile(File maze) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(maze);
		
		for(int y=0;y<getNbLines();y++) {
			for(int x=0; x<getNbColumns();x++) {
				pw.print(boxes[y][x].getLabel());
			}
			pw.println();
		}
		pw.close();
	}
	
	
	/*Send back number of lines*/
	public int getNbLines() {
		return boxes.length;
	}
	
	/*Send back number of columns*/
	public int getNbColumns() {
		return boxes[0].length;
	}
	
	public void setIsSolvable(boolean solvable) {
		isSolvable = solvable;
	}
	
	public boolean getIsSolvable() {
		return isSolvable;
	}
	
	/*Create an arrrayList containting every vertex of the maze */
	public ArrayList<VertexInterface> getAllVertex(){
		ArrayList<VertexInterface> list = new ArrayList<VertexInterface>();
		for (int i = 0 ; i < getNbLines() ; i++) {
			for (int j = 0 ; j < getNbColumns() ; j++) {
				list.add(boxes[i][j]);
			}
		}
		
		return list;
	}
	
	/* Send back an arrayList containing the successors of this vertex*/
	public ArrayList<VertexInterface> getSuccessors(VertexInterface v)
	{
		return v.getSuccessors();
	}
	/**Send back the valuation of an arc between 2 vertexes**/

	public int getValuation(VertexInterface x, VertexInterface y) {
		if(getSuccessors(x).contains(y)) {
			return 1;
		}
		else return 0;
	}


	/* Send back boxes number of the maze*/
	public int getSize() {
		return boxes.length*boxes[0].length;
	}
	
	public MBox[][] getBoxes() {
		return boxes;
	}

	public MBox getVertexBox(int y, int x) {
		return boxes[y][x];
	}
	
	public void setBoxes(MBox[][] mbox) {
		boxes = mbox;
	}

	public MBox getDeparture() {
		for(int i=0; i<getNbLines();i++) {
			for(int n=0; n<getNbColumns();n++) {
				if(boxes[i][n].getLabel() == "D") {
					return boxes[i][n];
				}
			}
		}
		return null;
	}

	public MBox getArrival() {
		for(int i=0; i<getNbLines();i++) {
			for(int n=0; n<getNbColumns();n++) {
				if(boxes[i][n].getLabel() == "A") {
					return boxes[i][n];
				}
			}
		}
		return null;
	}

	/** Find the shortest path from the departure to the arrival **/
	public void findPath() {
		MBox departure = getDeparture();
		MBox arrival = getArrival();
		if(departure == null) {
			JOptionPane.showMessageDialog(null,"The maze does not contain any departure box","Error",JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(arrival == null) {
			JOptionPane.showMessageDialog(null,"The maze does not contain any arrival box","Error",JOptionPane.WARNING_MESSAGE);
			return;
		}
		shortestPath = Dijkstra.dijkstra(this, departure).getShortestPathTo(arrival);
		if(shortestPath.size()>=2)
			isSolvable = true;
		else
			isSolvable = false;
	}
	
	/** Draw the path on the MazePanel **/
	public void drawPath() {
		initDrawPath();
		MBox departure = getDeparture();
		MBox arrival = getArrival();
		
		if(departure == null || arrival == null)
			return;
		
		int x=0;
		int y=0;		
		Iterator<VertexInterface> it = shortestPath.iterator();
		if(shortestPath != null)
		{
			while(it.hasNext())
			{
				MBox box = (MBox)it.next();
				x = box.getX();
				y = box.getY();
				if(boxes[y][x].getLabel() != "A" && boxes[y][x].getLabel() != "D")
					boxes[y][x] = new PBox(y,x,this);
				
			}			
		}
	}
	
	/** Replace the current path by empty boxes **/
	public void initDrawPath() {
		for(int line=0;line<getNbLines();line++){
			for(int column=0;column<getNbColumns();column++) {
				if(boxes[line][column].getLabel() == "P") {
					boxes[line][column] = new EBox(line,column,this);
				}
			}
		}
	}
}
