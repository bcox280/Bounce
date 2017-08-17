package bounce;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class TestOvalShape {
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

	// OVAL TESTS
	// OVAL TESTS
	// OVAL TESTS
	@Test
	public void testOvalSimpleMove() {
		OvalShape shape2 = new OvalShape(120, 35, 20, 25);
		shape2.paint(_painter);
		shape2.move(500, 500);
		shape2.paint(_painter);
		assertEquals("(oval 120,35,25,35)(oval 140,60,25,35)", _painter.toString());
		//OUTPUT IS THE INPUT GIVEN, THEREFORE RENDERS CORRECTLY
	}

	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testOvalShapeMoveWithBounceOffRight() {
		OvalShape shape2 = new OvalShape(156, 50, 25, 13);
		shape2.paint(_painter);
		shape2.move(200, 10000);
		shape2.paint(_painter);
		shape2.move(200, 10000);
		shape2.paint(_painter);
		assertEquals("(oval 156,50,25,35)(oval 175,63,25,35)" + "(oval 150,76,25,35)", _painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testOvalShapeMoveWithBounceOffLeft() {
		OvalShape shape2 = new OvalShape(20, 100, -500, 0);
		shape2.paint(_painter);
		shape2.move(10000, 10000);
		shape2.paint(_painter);
		shape2.move(10000, 10000);
		shape2.paint(_painter);
		assertEquals("(oval 20,100,25,35)(oval 0,100,25,35)" + "(oval 500,100,25,35)", _painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the bottom right corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testOvalShapeMoveWithBounceOffBottomAndRight() {
		OvalShape shape2 = new OvalShape(50, 100, -75, 150);
		shape2.paint(_painter);
		shape2.move(120, 225);
		shape2.paint(_painter);
		shape2.move(120, 225);
		shape2.paint(_painter);
		assertEquals("(oval 50,100,25,35)(oval 0,190,25,35)" + "(oval 75,40,25,35)", _painter.toString());
	}


}
