import java.awt.event.MouseEvent;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

public class DrawLines extends GraphicsProgram{
	//private instance variables
	private GLine line;
	
	//Enabling the mouse listeners
	public void init() {
		addMouseListeners();
	}
	
	//Calling on mouse press to create a new line 
	public void mousePressed(MouseEvent e) {
		line = new GLine(e.getX(), e.getY(), e.getX(), e.getY());
		add(line);
	}
	
	//Calling on mouse dragged to create a new line 
	public void mouseDragged(MouseEvent e) { 
		line.setEndPoint(e.getX(),  e.getY());
	}
	
}
