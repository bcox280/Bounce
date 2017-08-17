package bounce;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Ian Warren
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;

	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
	}

	/**
	 * @see bounce.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
	}

	/**
	 * @see bounce.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * @see bounce.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}

	public java.awt.Color getColor() {

		return _g.getColor();

	}

	@Override
	public void setColor(java.awt.Color color) {

		_g.setColor(color);

	}

	@Override
	public void fillRect(int x, int y, int width, int height, java.awt.Color color) {

		setColor(color);
		_g.fillRect(x, y, width, height);

	}

	@Override
	public void translate(int x, int y) {

		_g.translate(x, y);

	}

	@Override
	public void drawCentredText(String string, int x, int y) {

		_g.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		FontMetrics font = _g.getFontMetrics();
		int asc = font.getAscent();
		int desc = font.getDescent();
		int width = font.stringWidth(string);

		int adj = 0;

		adj = (asc - desc) / 2;

		_g.drawString(string, (x - width / 2), (y + adj));

	}

	@Override
	public void drawImage(Image img, int x, int y, int width, int height) {
		
		_g.drawImage(img, x, y, width, height, null);
		
	}

}
