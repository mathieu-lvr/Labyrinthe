package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/** Button allowing us to choose the type of box to modify**/
@SuppressWarnings("serial")
public final class ChooseTypeButton extends JButton implements ActionListener {
	private final MazeApp mazeApp;
	private final String buttonIndicator;
	
	public ChooseTypeButton(MazeApp mazeApp, String buttonIndicator, String buttonName,Color backColor,Color foreColor) {
		super(buttonName);
		setBackground(backColor);
		setForeground(foreColor);
		this.mazeApp = mazeApp;
		this.buttonIndicator = buttonIndicator;
		setOpaque(true);
		setContentAreaFilled(true);
		setBorderPainted(false);
		addActionListener(this);
	}
	
	public final void actionPerformed(ActionEvent evt) {
		mazeApp.getModel().setSelectedColor(buttonIndicator);
		mazeApp.getModel().updateMaze();
	}
}