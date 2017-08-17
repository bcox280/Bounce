package bounce;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestDynamicShape {
	// Fixture object that is used by the tests.
	private MockPainter _painter;

	/**
	 * This method is called automatically by the JUnit test-runner immediately
	 * before each @Test method is executed. setUp() recreates the fixture so
	 * that there no side effects from running individual tests.
	 */
	@Before
	public void setUp() {
		_painter = new MockPainter();
	}

	/**
	 * Test to perform a simple (non-bouncing) movement, and to ensure that a
	 * Shape's position after the movement is correct.
	 */
	//Using pretty much the same tests as rectangle shape, just checking that it also become filled
	//WILL ONLY USE DEFAULT BLACK AFTER FIRST TEST
	@Test
	public void testSimpleMove() {
		DynamicRectangleShape shape = new DynamicRectangleShape(100, 20, 12, 15, java.awt.Color.blue);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(filled_rectangle 100,20,25,35,java.awt.Color[r=0,g=0,b=255])(filled_rectangle 112,35,25,35,java.awt.Color[r=0,g=0,b=255])"
				, _painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffRight() {
		DynamicRectangleShape shape = new DynamicRectangleShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(filled_rectangle 100,20,25,35,java.awt.Color[r=0,g=0,b=0])"
				+ "(filled_rectangle 110,35,25,35,java.awt.Color[r=0,g=0,b=0])" //Once it hits the wall it writes itself as anormal rect
				+ "(filled_rectangle 98,50,25,35,java.awt.Color[r=0,g=0,b=0])",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffLeft() {
		DynamicRectangleShape shape = new DynamicRectangleShape(10, 20, -12, 15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(filled_rectangle 10,20,25,35,java.awt.Color[r=0,g=0,b=0])"
				+ "(filled_rectangle 0,35,25,35,java.awt.Color[r=0,g=0,b=0])" +
				"(filled_rectangle 12,50,25,35,java.awt.Color[r=0,g=0,b=0])", _painter.toString());
	}
	//TEST to check the bounce movement off the bottom wall and to check if the behaviour is correct
	@Test
	public void testShapeMoveWithBounceOffBottom() {
		DynamicRectangleShape shape = new DynamicRectangleShape(50, 50 , 12 , 20);
		shape.paint(_painter);
		shape.move(1000, 100);
		shape.paint(_painter);
		shape.move(1000, 100);
		shape.paint(_painter);
		assertEquals("(filled_rectangle 50,50,25,35,java.awt.Color[r=0,g=0,b=0])"
				+ "(rectangle 62,65,25,35)" +
				"(rectangle 74,45,25,35)", _painter.toString());
	}

	//TEST to check the bounce movement off the Top wall and to check if the behaviour is correct
		@Test
		public void testShapeMoveWithBounceOffTop() {
			DynamicRectangleShape shape = new DynamicRectangleShape(50, 50 , 12 , -60);
			shape.paint(_painter);
			shape.move(1000, 100);
			shape.paint(_painter);
			shape.move(1000, 100);
			shape.paint(_painter);
			assertEquals("(filled_rectangle 50,50,25,35,java.awt.Color[r=0,g=0,b=0])"
					+ "(rectangle 62,0,25,35)" +
					"(rectangle 74,60,25,35)", _painter.toString());
		}

	/**
	 * Test to perform a bounce movement off the bottom right corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffBottomAndRight() {
		DynamicRectangleShape shape = new DynamicRectangleShape(10, 90, -12, 15);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(filled_rectangle 10,90,25,35,java.awt.Color[r=0,g=0,b=0])"
				+ "(filled_rectangle 0,100,25,35,java.awt.Color[r=0,g=0,b=0])" 
				+ "(filled_rectangle 12,85,25,35,java.awt.Color[r=0,g=0,b=0])", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the top right corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffTopAndRight() {
		DynamicRectangleShape shape = new DynamicRectangleShape(95, 50, 12, -60);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(filled_rectangle 95,50,25,35,java.awt.Color[r=0,g=0,b=0])"
				+ "(filled_rectangle 100,0,25,35,java.awt.Color[r=0,g=0,b=0])" 
				+ "(filled_rectangle 88,60,25,35,java.awt.Color[r=0,g=0,b=0])", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the top left corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffTopAndLeft() {
		DynamicRectangleShape shape = new DynamicRectangleShape(15, 50, -20, -60);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(filled_rectangle 15,50,25,35,java.awt.Color[r=0,g=0,b=0])"
				+ "(filled_rectangle 0,0,25,35,java.awt.Color[r=0,g=0,b=0])" 
				+ "(filled_rectangle 20,60,25,35,java.awt.Color[r=0,g=0,b=0])", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom left corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffBottomAndLeft() {
		DynamicRectangleShape shape = new DynamicRectangleShape(15, 90, -20, 65);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(filled_rectangle 15,90,25,35,java.awt.Color[r=0,g=0,b=0])"
				+ "(filled_rectangle 0,100,25,35,java.awt.Color[r=0,g=0,b=0])" 
				+ "(filled_rectangle 20,35,25,35,java.awt.Color[r=0,g=0,b=0])", _painter.toString());
	}



}


