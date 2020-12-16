
/**
 * Triangle.java
 * @author Radoslav Nikolov
 * @version 1.0.0
 * Added class to the coursework!
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends ClosedShape {

	//The width and height of the triangle (major and minor axis)
	private int width, height;
	//The minimum width of the triangle
	private int minW;
	//The maximum width of the triangle
	private int maxW;
	//The minimum height of the triangle
	private int minH;
	//The maximum height of the triangle
	private int maxH;
	
	/**
	 * Creates a triangle.
	 * 
	 * @param x        The display component's x position.
	 * @param y        The display component's y position.
	 * @param vx       The display component's x velocity.
	 * @param vy       The display component's y velocity.
	 * @param width    The width (in pixels).
	 * @param height   The height (in pixels).
	 * @param colour   The line colour or fill colour.
	 * @param isFilled True if the triangle is filled with colour, false if opaque.
	 */
	public Triangle(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour,
			boolean isFilled, boolean isPulsing) {
		super(insertionTime, x, y, vx, vy, colour, isFilled, isPulsing);
		this.width = width;
		this.height = height;
		this.maxW = width*2;
		this.minW = width/2;
		this.maxH = height*2;
		this.minH = height/2;
	}
	
	/**
     * It makes the triangle to pulse on the screen.
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
	 * Method to convert a triangle to a string.
	 */
	public String toString() {
		String result = "This is a triangle\n";
		result += super.toString();
		result += "Its width is " + this.width + " and its height is " + this.height + "\n";
		return result;
	}

	/**
	 * @return The width.
	 */
	public int getWidth() {

		return this.width;
	}

	/**
	 * @return The height.
	 */
	public int getHeight() {

		return this.height;
	}

	/**
	 * Draw the triangle.
	 * 
	 * @param g The graphics object of the drawable component.
	 */
	public void draw(GraphicsContext g) {
		g.setFill(colour);
		g.setStroke(colour);

		double[] xPoints = { x + this.getWidth() / 2, x + this.getWidth(), x };
		double[] yPoints = { y, y + this.getHeight(), y + this.getHeight() };

		if (isFilled) {
			g.fillPolygon(xPoints, yPoints, 3);
		} else {
			g.strokePolygon(xPoints, yPoints, 3);
		}
	}
}
