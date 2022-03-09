import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;

//displays a mouse-draggable and key movable rectangle and oval
public class MoveObjects extends GraphicsProgram{
	//private instance variables
	private GObject gobj; //object to be moved
	private GPoint last; //last position of the mouse
	
	//intializing program 
	public void init() {
		GRect rect = new GRect(100, 100, 150, 100); 
		rect.setFilled(true);
		rect.setFillColor(Color.RED);
		add(rect);
		GOval oval = new GOval(300, 115, 100, 70);
		oval.setFilled(true);;
		oval.setFillColor(Color.GREEN);
		add(oval);
		addMouseListeners();
		addKeyListeners();
	}
	
	//calling on mouse press to record the coordinates of a user click
	public void mousePressed(MouseEvent e) { 
		last = new GPoint(e.getPoint());
		gobj = getElementAt(last);
	}
	
	//calling on mouse drag to move the object
	public void mouseDragged(MouseEvent e) {
		if (gobj != null) {
			gobj.move(e.getX() - last.getX(), e.getY() - last.getY());
			last = new GPoint(e.getPoint());
		}
	}
	
	//calling on mouse click to move this object to the front 
	public void mouseClicked(MouseEvent e) {
		if (gobj != null) gobj.sendToFront();
	}
	
	//calling on key pressed to move the object
	public void keyClicked(KeyEvent e) {
		if (gobj != null) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_UP: gobj.move(0, -1); break; 
			case KeyEvent.VK_DOWN: gobj.move(0,  +1); break; 
			case KeyEvent.VK_LEFT: gobj.move(-1,  0); break; 
			case KeyEvent.VK_RIGHT: gobj.move(+1, 0); break; 
			}
		}
	}
}
