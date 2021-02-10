package ui;

import java.awt.*;
import javax.swing.*;

/** Window needed to draw and modify our maze box per box **/
@SuppressWarnings("serial")
public final class MazeDrawPanel extends JPanel {
	private MazeApp mazeApp;
	private JLabel typeLabel;
	
	public MazeDrawPanel(MazeApp mazeApp) {
		super();
		this.mazeApp = mazeApp;
		
		setLayout(new GridLayout(6,1));
		
		add(new JLabel("Choose a box type", JLabel.CENTER));
		add(typeLabel = new JLabel("No type selected",JLabel.CENTER ));
		add(new ChooseTypeButton(this.mazeApp, "A", "Arrival box",Color.RED,Color.BLACK));
		add(new ChooseTypeButton(this.mazeApp, "D", "Departure box",Color.GREEN,Color.BLACK));
		add(new ChooseTypeButton(this.mazeApp, "W", "Wall box",Color.BLUE,Color.WHITE));
		add(new ChooseTypeButton(this.mazeApp, "E", "Empty box",Color.BLACK,Color.WHITE));
	}
	
	public void notifyForUpdate() {
		Color color = mazeApp.getModel().getSelectedColor();
		if(color == Color.RED) {
			typeLabel.setText("Selected type : arrival box");
			typeLabel.setBackground(color);
		} else if(color == Color.GREEN) {
			typeLabel.setText("Selected type : departure box");
			typeLabel.setBackground(color);
		} else if(color == Color.BLACK) {
			typeLabel.setText("Selected type : wall box");
			typeLabel.setBackground(color);
		} else if(color == Color.WHITE) {
			typeLabel.setText("Selected type : empty box");
			typeLabel.setBackground(color);
		} else if(color == null) {
			typeLabel.setText("No type selected");
			typeLabel.setBackground(Color.GRAY);
		}
		repaint();
	}
	
}
