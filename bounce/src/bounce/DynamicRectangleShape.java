package bounce;

import java.util.ArrayList;

/**
 * Class to represent a simple dynamicrectangle.
 * 
 * @author Blair Cox
 * 
 */
public class DynamicRectangleShape extends Shape {
	/**
	 * Default constructor that creates a DynamicRectangleShape instance whose
	 * instance variables are set to default values.
	 */
	private int borderX = 0;
	private int borderY = 0;
	private boolean _solid = true;
	private java.awt.Color _color = java.awt.Color.black;

	public DynamicRectangleShape() {
		super();
	}

	/**
	 * Creates a DynamicRectangleShape instance with specified values for
	 * instance variables.
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
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	
	}
	
	
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, java.awt.Color color) {
		super(x, y, deltaX, deltaY);
		_color = color;
	}

	/**
	 * Creates a DynamicRectangleShape instance with specified values for
	 * instance variables.
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
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {

		super(x, y, deltaX, deltaY, width, height , text);
		
	}
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, String text, java.awt.Color color) {

		super(x, y, deltaX, deltaY, width, height, text);
		_color = color;
	}

	public void move(int width, int height) {

		borderX = width;
		borderY = height;

		super.move(width, height);

	}

	/**
	 * Paints this DynamicRectangleShape object using the supplied Painter
	 * object.
	 */
	public void doPaint(Painter painter) {
		if (_y == 0 || _y  == (borderY - _height)) {

			_solid = false;

		}
		if (_x == 0 || _x  == (borderX - _width)) {

			_solid = true;

		}//ORDERING IS IMPORTANT
		
		
		

		if (_solid) {

			painter.fillRect(_x, _y, _width, _height, _color);

		} else {

			painter.drawRect(_x, _y, _width, _height);

		}
		

	}

	
	public ArrayList<Integer> getValues(){
		
		//return the values as an arraylist for imagineshape to use
		ArrayList<Integer> values = new ArrayList<Integer>();
		values.add(_x);
		values.add(_y);
		values.add(_deltaX);
		values.add(_deltaY);
		values.add(_width);
		values.add(_height);
		return values;
	}
	
	public void setColor(java.awt.Color color) {

		_color = color;

	}
}
