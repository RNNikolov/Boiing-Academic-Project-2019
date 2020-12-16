
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadShapeFile {

	// TODO: You will likely need to write four methods here. One method to
	// construct each shape
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.

	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue<ClosedShape> readDataFile(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

		// read in the shape files and place them on the Queue
		while (in.hasNextLine()) {

			String line = in.nextLine();
			Scanner newLine = new Scanner(line);
			String shapeType = newLine.next();

			if (shapeType.equals("circle")) {

				Circle circle = createCircle(newLine);
				shapeQueue.enqueue(circle);

			} else if (shapeType.equals("oval")) {

				Oval oval = createOval(newLine);
				shapeQueue.enqueue(oval);

			} else if (shapeType.equals("square")) {

				Square square = createSquare(newLine);
				shapeQueue.enqueue(square);

			} else if (shapeType.equals("rect")) {

				Rect rectangle = createRect(newLine);
				shapeQueue.enqueue(rectangle);

			} else if (shapeType.equals("triangle")) {

				Triangle triangle = createTriangle(newLine);
				shapeQueue.enqueue(triangle);

			} else {
				System.out.println("Not found!");
			}
		}
		in.close();

		// Right now, returning an empty Queue. You need to change this.
		return shapeQueue;
	}

	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {
		// HINT: You might want to open a file here.
		File shapesFile = new File(filename);
		Scanner in = null;

		try {
			in = new Scanner(shapesFile);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open " + filename);
			System.exit(0);
		}

		return ReadShapeFile.readDataFile(in);

	}
	
	/**
	 * Method to take the data from a line of a specific file 
	 * and create a triangle with the data provided from the line.
	 * In the end, it returns the shape.
	 * 
	 * @param newLine the scanner of the file
	 * @return The triangle shape
	 */
	public static Triangle createTriangle(Scanner newLine) {
		int x = newLine.nextInt();
		int y = newLine.nextInt();
		int vx = newLine.nextInt();
		int vy = newLine.nextInt();
		boolean isFilled = newLine.nextBoolean();
		boolean isPulsing = newLine.nextBoolean();
		int width = newLine.nextInt();
		int height = newLine.nextInt();
		int r = newLine.nextInt();
		int g = newLine.nextInt();
		int b = newLine.nextInt();
		Color colour = Color.rgb(r, g, b);
		int insertionTime = newLine.nextInt();
		Triangle triangle = new Triangle(insertionTime, x, y, vx, vy, width, height, colour, isFilled, isPulsing);

		return triangle;
	}
	
	/**
	 * Method to take the data from a line of a specific file 
	 * and create a circle with the data provided from the line.
	 * In the end, it returns the shape.
	 * 
	 * @param newLine the scanner of the file
	 * @return The circle shape
	 */
	public static Circle createCircle(Scanner newLine) {

		int px = newLine.nextInt();
		int py = newLine.nextInt();
		int vx = newLine.nextInt();
		int vy = newLine.nextInt();
		boolean isFilled = newLine.nextBoolean();
		boolean isPulsing = newLine.nextBoolean();
		int diameter = newLine.nextInt();
		int r = newLine.nextInt();
		int g = newLine.nextInt();
		int b = newLine.nextInt();
		Color colour = Color.rgb(r, g, b);
		int insertionTime = newLine.nextInt();
		Circle circle = new Circle(insertionTime, px, py, vx, vy, diameter, colour, isFilled, isPulsing);

		return circle;
	}

	/**
	 * Method to take the data from a line of a specific file 
	 * and create a oval with the data provided from the line.
	 * In the end, it returns the shape.
	 * 
	 * @param newLine the scanner of the file
	 * @return The oval shape
	 */
	public static Oval createOval(Scanner newLine) {

		int px = newLine.nextInt();
		int py = newLine.nextInt();
		int vx = newLine.nextInt();
		int vy = newLine.nextInt();
		boolean isFilled = newLine.nextBoolean();
		boolean isPulsing = newLine.nextBoolean();
		int width = newLine.nextInt();
		int height = newLine.nextInt();
		int r = newLine.nextInt();
		int g = newLine.nextInt();
		int b = newLine.nextInt();
		Color colour = Color.rgb(r, g, b);
		int insertionTime = newLine.nextInt();
		Oval oval = new Oval(insertionTime, px, py, vx, vy, width, height, colour, isFilled, isPulsing);

		return oval;

	}

	/**
	 * Method to take the data from a line of a specific file 
	 * and create a square with the data provided from the line.
	 * In the end, it returns the shape.
	 * 
	 * @param newLine the scanner of the file
	 * @return The square shape
	 */
	public static Square createSquare(Scanner newLine) {

		int px = newLine.nextInt();
		int py = newLine.nextInt();
		int vx = newLine.nextInt();
		int vy = newLine.nextInt();
		boolean isFilled = newLine.nextBoolean();
		boolean isPulsing = newLine.nextBoolean();
		int side = newLine.nextInt();
		int r = newLine.nextInt();
		int g = newLine.nextInt();
		int b = newLine.nextInt();
		Color colour = Color.rgb(r, g, b);
		int insertionTime = newLine.nextInt();
		Square square = new Square(insertionTime, px, py, vx, vy, side, colour, isFilled, isPulsing);

		return square;
	}

	/**
	 * Method to take the data from a line of a specific file 
	 * and create a rectangle with the data provided from the line.
	 * In the end, it returns the shape.
	 * 
	 * @param newLine the scanner of the file
	 * @return The rectangle shape
	 */
	public static Rect createRect(Scanner newLine) {

		int px = newLine.nextInt();
		int py = newLine.nextInt();
		int vx = newLine.nextInt();
		int vy = newLine.nextInt();
		boolean isFilled = newLine.nextBoolean();
		boolean isPulsing = newLine.nextBoolean();
		int width = newLine.nextInt();
		int height = newLine.nextInt();
		int r = newLine.nextInt();
		int g = newLine.nextInt();
		int b = newLine.nextInt();
		Color colour = Color.rgb(r, g, b);
		int insertionTime = newLine.nextInt();
		Rect rectangle = new Rect(insertionTime, px, py, vx, vy, width, height, colour, isFilled, isPulsing);

		return rectangle;

	}
}
