import java.awt.Color;

import acm.graphics.GCanvas;
import acm.graphics.GOval;
import acm.program.*;
import acm.util.RandomGenerator;

/*
 * RandomCircles.java extends GraphicsProgram.java
 * 
 * This program displays ten circles on the canvas of random
 * size, color and placement within the bounds of the canvas.
 */
public class RandomCircles extends GraphicsProgram {
	public void run() {
		
		// place ten random circles on the canvas
		addTenCirclesToCanvas();
	}
	
	/*
	 * adds ten circles to the canvas.
	 */
	public void addTenCirclesToCanvas() {
		addCirclesToCanvas(10);
	}
	
	/*
	 * adds a specified number of circles to the canvas.
	 */
	public void addCirclesToCanvas(int numOfCircles) {
		
		GCanvas canvas = getColoredCanvas(Color.white);
		
		for(int i = 0; i <= numOfCircles; i++) {
			GOval theCircle = getRandomCircle();
			canvas.add(theCircle);
		}
		
	}
	
	/*
	 * returns a circle of random color, size and bounds.
	 */
	public GOval getRandomCircle() {
		GOval randomSizedCircle = getCircleOfRandomSizeAndLocation();
		randomSizedCircle = getColoredCircle(randomSizedCircle);
		
		return randomSizedCircle;
	}
	
	/*
	 * returns a GCanvas object of specified color
	 */
	public GCanvas getColoredCanvas(Color color) {
		// create a canvas object
		GCanvas canvas = this.getGCanvas();
		// set the background color of the canvas object
		canvas.setBackground(color);

		return canvas;
	}
	
	/*
	 * receives a GOval object and assigns a random Color value
	 * to it.
	 */
	public GOval getColoredCircle (GOval aCircle) {
		
		Color randomColor = getRandomColor();
		
		aCircle.setColor(randomColor);
		aCircle.setFillColor(randomColor);
		aCircle.setFilled(true);
		aCircle.setVisible(true);
		
		return aCircle;
	}
	
	/*
	 * returns a circle with random size and random bounds
	 */
	public GOval getCircleOfRandomSizeAndLocation() {
		double radiusMax = 50;
		double radiusMin = 5;
		
		double radius = getRandomDouble(radiusMin * 2, radiusMax * 2);
		double circleSize = radius * 2;
		
		double x = getBounds(getWidth(), radius);
	
		double y = getBounds(getHeight(), radius);
		// get a randomly sized circle with random bounds less than canvas size.
		GOval theCircle = new GOval(x, y, circleSize, circleSize);
		
		return theCircle;
	}
	
	/*
	 * returns a random Color from the enum Color
	 */
	public Color getRandomColor()  {
		RandomGenerator random = new RandomGenerator();
		
		return random.nextColor();
	}
	
	/*
	 * returns a random double between min and max parameters
	 */
	public double getRandomDouble(double min, double max) {
		RandomGenerator random = new RandomGenerator();
		
		return random.nextDouble(min, max);
	}
	
	/*
	 * returns a random double between 0 and the radius * 2
	 * designed to receive either the width or height of the canvas in to
	 * the limitation parameter and the radius of the circle in to
	 * the radius parameter.
	 */
	public double getBounds(double limitation, double radius) {
		double bounds = getRandomDouble(0, (limitation - radius * 2));
		
		return bounds;
	}
	
}
