package ui;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**Window which has all the menus to configure the maze, and to resolve it**/
@SuppressWarnings("serial")
public final class ControlPanel extends JTabbedPane {
	private final MazeApp mazeApp;
	private GeneratePanel generatePanel;
	private MazeDrawPanel mazeDrawPanel;
	private ResolveDijkstraButton resolveDijkstraButton;
	private final WindowPanel windowPanel;
	
	public ControlPanel(MazeApp mazeApp,WindowPanel windowPanel ) {
		super();
		this.mazeApp = mazeApp;
		this.windowPanel = windowPanel;
		this.mazeDrawPanel = new MazeDrawPanel(this.mazeApp);
		this.generatePanel = new GeneratePanel(this.mazeApp);
		this.resolveDijkstraButton = new ResolveDijkstraButton(this.mazeApp,this.windowPanel);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(256,512));		
		addTab("generate", generatePanel);
		addTab("draw", mazeDrawPanel);
		addTab("resolve", resolveDijkstraButton);
		setVisible(true);
		notifyForUpdate();
		
		//listener to detect a tab change
		addChangeListener(new ChangeListener() {
		    public void stateChanged(ChangeEvent e) {
		        if(getSelectedIndex()==1) {
		        	mazeApp.getModel().setSelectedTab(2);
					mazeApp.getModel().setModifActive(true);
					mazeApp.getModel().setSelectedColor("null");
				} else if(getSelectedIndex()==2){
					mazeApp.getModel().setSelectedTab(3);
					mazeApp.getModel().setModifActive(false);
				} else if(getSelectedIndex()==0){
					mazeApp.getModel().setSelectedTab(1);
					mazeApp.getModel().setModifActive(false);
				}
		    }
		});
	}

	public void notifyForUpdate() {
		int index = mazeApp.getModel().getSelectedTab();
		setSelectedIndex(index-1);
		mazeDrawPanel.notifyForUpdate();
		validate();
	}
	
}
