
/**
 * Square.java
 * @author Radoslav Nikolov
 * @version 1.0.0
 * Added class to the coursework!
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends ClosedShape {

	//The width and height of the square, which are equal (major and minor axis)
	private int side;
	//The minimum size of the square
	private int min;
	//The maximum size of the square
	private int max;
	
	/**
	 * Creates a square.
	 * 
	 * @param x        The display component's x position.
	 * @param y        The display component's y position.
	 * @param vx       The display component's x velocity.
	 * @param vy       The display component's y velocity.
	 * @param side     The width/height of the square (in pixels).
	 * @param colour   The line colour or fill colour.
	 * @param isFilled True if the square is filled with colour, false if opaque.
	 */
	public Square(int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled, boolean isPulsing) {
		super(insertionTime, x, y, vx, vy, colour, isFilled, isPulsing);
		this.side = side;
		this.max = side*2;
		this.min = side/2;
	}
	
	/**
     * It makes the square to pulse on the screen.
     */
	public void pulsing() {
    	if(isPulsing) {
    		if(side + ClosedShape.pulseRate > this.max) {
    			this.side = this.max;
    			ClosedShape.pulseRate = -1;
    		} else if(side + ClosedShape.pulseRate < this.min){
    			this.side = this.min;
    			ClosedShape.pulseRate = 1;
    		}	
    		this.side += ClosedShape.pulseRate;
    	}
    	
    }

	/**
	 * Method to convert a square to a string.
	 */
	public String toString() {
		String result = "This is a square\n";
		result += super.toString();
		result += "Its side is " + this.side + "\n";
		return result;
	}

	/**
	 * @param side Resets the side.
	 */
	public void setSide(int side) {
		this.side = side;
	}

	/**
	 * @return The side of the square.
	 */
	public int getSide() {
		return this.side;
	}
	
	/**
	 * @return The height of the square.
	 */
	public int getHeight() {
		return side;
	}
	
	/**
	 * @return The width of the square.
	 */
	public int getWidth() {
		return side;
	}

	/**
	 * Draw the square.
	 * @param g The graphics object of the drawable component.
	 */
	public void draw(GraphicsContext g) {
		g.setFill(colour);
		g.setStroke(colour);
		if (isFilled) {
			g.fillRect(x, y, side, side);
		} else {
			g.strokeRect(x, y, side, side);
		}
	}

}
