/**
 * Class to represent a simple gem.
 * 
 * @author Blair Cox
 * 
 */
package bounce;

public class GemShape extends Shape {

	/**
	 * Default constructor that creates a GemShape instance whose instance
	 * variables are set to default values.
	 */
	public GemShape() {
		super();
	}

	/**
	 * Creates a GemShape instance with specified values for instance variables.
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
	public GemShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}

	/**
	 * Creates a GemShape instance with specified values for instance variables.
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
	public GemShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x, y, deltaX, deltaY, width, height, text);
	}

	/**
	 * Paints this GemShape object using the supplied Painter object.
	 */
	public void doPaint(Painter painter) {
		
		if (_width < 40) {
			
			//MATHS
			painter.drawLine(_x , (_height / 2) + _y, _x + (_width / 2),  _y);
			painter.drawLine(_x + (_width / 2),  _y, _x + _width, (_height / 2) + _y);
			painter.drawLine(_x + _width, (_height / 2) + _y , _x + (_width / 2),_height + _y);
			painter.drawLine(_x + (_width / 2), _height + _y, _x , (_height / 2) + _y);
			

		} else {

			//MATHS
			painter.drawLine(_x, (_height / 2) + _y, _x+20, _y);
			painter.drawLine(_x + 20, _y, _x + _width - 20, _y);
			painter.drawLine(_x + _width - 20, _y, _x + _width, (_height / 2) + _y);
			painter.drawLine(_x + _width, (_height / 2) + _y, _x + _width - 20, _height + _y);
			painter.drawLine(_x + _width - 20, _height + _y, _x + 20, _height + _y);
			painter.drawLine(_x + 20, _height + _y, _x + 0, (_height / 2) + _y);

		}
	}
}
