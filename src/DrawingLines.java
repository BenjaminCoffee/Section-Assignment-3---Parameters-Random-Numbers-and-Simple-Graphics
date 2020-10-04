import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.peer.MouseInfoPeer;

import acm.graphics.GCanvas;
import acm.graphics.GLine;
import acm.graphics.GPoint;
import acm.program.*;

public class DrawingLines extends GraphicsProgram {
	
	private GLine theLine;
	private GCanvas theCanvas = getColoredCanvas(Color.white);
	
	public void run() {
		addMouseListeners();
	}
	
	/*
	 * (non-Javadoc)
	 * @see acm.program.Program#mouseDragged(java.awt.event.MouseEvent)
	 * 
	 * A MouseEvent object is generated and passed to event.
	 * The coordinates of the end point of theLine are changed
	 * to the x and y coordinates of the mouse.
	 */
	public void mouseDragged(MouseEvent event) {
		theLine.setEndPoint(event.getX(), event.getY());
		
		add(theLine);
	}
	
	/*(non-Javadoc)
	 * @see acm.program.Program#mousePressed(java.awt.event.MouseEvent)
	 * 
	 * A MouseEvent object is generated when the mouse is pressed.
	 * the line at this point, represents a single point on the canvas
	 * because the dimensions of the line are such, x1 = x0 and y1 = y0;
	 */
	public void mousePressed(MouseEvent event) {
		theLine = new GLine(event.getX(),
							event.getY(),
							event.getX(),
							event.getY());
		
		add(theLine);
	}
	
	/*
	 * returns a new colored GCanvas object.
	 */
	public GCanvas getColoredCanvas(Color color) {
		// create a canvas object
		GCanvas canvas = this.getGCanvas();
		// set the background color of the canvas object
		canvas.setBackground(color);

		return canvas;
	}
}
