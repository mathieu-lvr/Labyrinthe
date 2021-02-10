package maze;

public class MazeReadingException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MazeReadingException(String fileName, int NumLine, String errorMsg) {
		super("File reading error" + fileName + Integer.toString(NumLine) + errorMsg);
	}
}
