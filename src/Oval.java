

/**
 * Oval.java
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of 
 * CSC-115 (Daniel Archambault and Liam O'Reilly)
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * Oval is an oval shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * oval's bounding rectangle
 */
public class Oval extends ClosedShape {
	//The width and height of the oval (major and minor axis)
	private int width, height;
	//The minimum width of the oval
	private int minW;
	//The maximum width of the oval
	private int maxW;
	//The minimum height of the oval
	private int minH;
	//The maximum height of the oval
	private int maxH;
	
	/**
	 * Creates an oval.
	 * @param x The display component's x position.
	 * @param y The display component's y position.
	 * @param vx The display component's x velocity.
	 * @param vy The display component's y velocity.
	 * @param width The width of the oval (in pixels).
	 * @param height The height of the oval (in pixels).
	 * @param colour The line colour or fill colour.
	 * @param isFilled True if the oval is filled with colour, false if opaque.
	 */
	public Oval (int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled, boolean isPulsing) {
		super (insertionTime, x, y, vx, vy, colour, isFilled, isPulsing);
		this.width = width;
		this.height = height;
		this.maxW = width*2;
		this.minW = width/2;
		this.maxH = height*2;
		this.minH = height/2;
	}

	/**
     * It makes the oval to pulse on the screen.
     */
	public void pulsing() {
    	if(isPulsing) {
    		if(width + ClosedShape.pulseRate > this.maxW) {
    			this.width = this.maxW;
    			ClosedShape.pulseRate = -1;
    		} else if(width + ClosedShape.pulseRate < this.minW){
    			this.width = this.minW;
    			ClosedShape.pulseRate = 1;
    		}	
    		
    		if(height + ClosedShape.pulseRate > this.maxH) {
    			this.height = this.maxH;
    			ClosedShape.pulseRate = -1;
    		} else if(height + ClosedShape.pulseRate < this.minH){
    			this.height = this.minH;
    			ClosedShape.pulseRate = 1;
    		}
    		
    		this.width += ClosedShape.pulseRate;
    		this.height += ClosedShape.pulseRate;
    	}
    	}
	
	/**
     * Method to convert an oval to a string.
     */
    public String toString () {
    	String result = "This is an oval\n";
    	result += super.toString ();
	result += "Its width is " + this.width + " and its height is " + this.height + "\n";
    	return result;
    }

	/**
	 * @param width Resets the width.
	 */
 	public void setWidth (int width) {
		this.width = width;
	}

 	/**
 	 * @param height Resets the height.
 	 */
 	public void setHeight (int height) {
		this.height = height;
	}

 	/**
 	 * @return The width of the oval.
 	 */
 	public int getWidth() {
		return width;
	}

 	/**
 	 * @return The height of the oval.
 	 */
 	public int getHeight() {
		return height;
	}

 	/**
 	 * Draw the oval.
 	 * @param g The graphics object of the drawable component.
 	 */
	public void draw (GraphicsContext g) {
		g.setFill (colour);
		g.setStroke( colour );
		if (isFilled) {
			g.fillOval( x, y, width, height );
		} 
		else {
			g.strokeOval( x, y, width, height );
		}
	}
}
