/**
 * Class to represent a imagineshape.
 * 
 * @author Blair Cox
 * 
 */
package bounce;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ImagineShape extends Shape {

	private ArrayList<Shape> _listShapes = new ArrayList<Shape>();
	private ArrayList<java.awt.Color> _listColors = new ArrayList<java.awt.Color>();
	private int _index = 0;


	/**
	 * Default constructor that creates an ImagineShape instance whose instance
	 * variables are set to default values.
	 */
	public ImagineShape() {

		super();
		_listShapes.add(new DynamicRectangleShape());
		createColors();

	}

	/**
	 * Creates an ImagineShape instance with specified values for instance
	 * variables.
	 * 
	 * @param x
	 *            x position.
	 * @param y
	 *            y position.
	 * @param deltaX
	 *            speed and direction for horizontal axis.
	 * @param deltaY
	 *            speed and direction for vertical axis.
	 */
	public ImagineShape(int x, int y, int deltaX, int deltaY) {

		super(x, y, deltaX, deltaY);
		_listShapes.add(new DynamicRectangleShape(x, y, deltaX, deltaY,java.awt.Color.CYAN));
		createColors();
	}

	/**
	 * Creates an ImagineShape instance with specified values for instance
	 * variables.
	 * 
	 * @param x
	 *            x position.
	 * @param y
	 *            y position.
	 * @param deltaX
	 *            speed (pixels per move call) and direction for horizontal
	 *            axis.
	 * @param deltaY
	 *            speed (pixels per move call) and direction for vertical axis.
	 * @param width
	 *            width in pixels.
	 * @param height
	 *            height in pixels.
	 */
	public ImagineShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {

		super(x, y, deltaX, deltaY, width, height, text);
		_listShapes.add(new DynamicRectangleShape(x, y, deltaX, deltaY, width, height,text, java.awt.Color.magenta));
		createColors();
	}

	public void createColors() {

		_listColors.add(java.awt.Color.black);
		_listColors.add(java.awt.Color.blue);
		_listColors.add(java.awt.Color.red);
		_listColors.add(java.awt.Color.cyan);
		_listColors.add(java.awt.Color.darkGray);
		_listColors.add(java.awt.Color.gray);
		_listColors.add(java.awt.Color.green);
		_listColors.add(java.awt.Color.lightGray);
		_listColors.add(java.awt.Color.magenta);
		_listColors.add(java.awt.Color.orange);
		_listColors.add(java.awt.Color.pink);
		_listColors.add(java.awt.Color.red);
		_listColors.add(java.awt.Color.white);
		_listColors.add(java.awt.Color.yellow);

	}

	public void move(int width, int height) {

		_listShapes.get(_index).move(width, height);

	}

	/**
	 * Paints this ImagineShape object using the supplied Painter object.
	 */
	public void doPaint(Painter painter) {

		int dir = ThreadLocalRandom.current().nextInt(-2,3);
		int randomNum = ThreadLocalRandom.current().nextInt(0,_listColors.size());
		_listShapes.get(0).paint(painter);
		ArrayList<Integer> values = new ArrayList<Integer>(((DynamicRectangleShape) (_listShapes.get(0))).getValues());
		_listShapes.set(0, new DynamicRectangleShape(values.get(0).intValue(), values.get(1).intValue(), values.get(2).intValue(), values.get(3).intValue(),
				values.get(4).intValue()+dir, values.get(5).intValue()+dir, _outputString, _listColors.get(randomNum)));
		//Every tick we create a new dynamicRectobject, with a random color, and an incrementing or decrementing size randomly
		//as DynamicRectangleObjects are used, everytime it hits the right or left wall it will turn into a normal rect for 1 tick
		
	}
}
