/**
 * Class to represent a simple Nesting Shape.
 * 
 * @author Blair Cox
 * 
 */
package bounce;

import java.util.ArrayList;

public class NestingShape extends Shape {

	private ArrayList<Shape> _listOfShapes = new ArrayList<Shape>();

	/**
	 * Default constructor that creates an OvalShape instance whose instance
	 * variables are set to default values.
	 */
	public NestingShape() {
		super();
	}

	/**
	 * Creates an OvalShape instance with specified values for instance
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
	public NestingShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}

	/**
	 * Creates an OvalShape instance with specified values for instance
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
	public NestingShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x, y, deltaX, deltaY, width, height, text);
	}
	
	public NestingShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height, null);
	}

	/**
	 * Paints this OvalShape object using the supplied Painter object.
	 */
	public void move(int width, int height) {

		super.move(width, height);

		for (int i = 0; i < _listOfShapes.size(); i++) {

			_listOfShapes.get(i).move(_width, _height);

		}

	}

	public void doPaint(Painter painter) {

		painter.drawRect(_x, _y, _width, _height);

		painter.translate(_x, _y);
		for (int i = 0; i < _listOfShapes.size(); i++) {

			_listOfShapes.get(i).paint(painter);

		}
		painter.translate(-_x, -_y);// Untranslate

	}

	void add(Shape shape) throws IllegalArgumentException {

		if (shape._width >= _width || shape._height >= _height || shape._x + shape._width >= _x + _width
				|| shape._y + shape._height >= _y + _height) {

			throw new IllegalArgumentException();

		}
		if (shape._parent != null) {

			throw new IllegalArgumentException();

		}

		_listOfShapes.add(shape);
		shape.makeParent(this);

	}

	void remove(Shape shape) {

		_listOfShapes.remove(shape);
		shape.removeParent();

	}

	public Shape shapeAt(int index) throws IndexOutOfBoundsException {

		if (index < 0 || index >= _listOfShapes.size()) {

			throw new IndexOutOfBoundsException();

		}
		Shape shapeGot = _listOfShapes.get(index);
		return shapeGot;
	}

	public int shapeCount() {

		
			return _listOfShapes.size();
		

	}

	public int indexOf(Shape shape) {

		return _listOfShapes.indexOf(shape);

	}

	public boolean contains(Shape shape) {

		return _listOfShapes.contains(shape);

	}

}
