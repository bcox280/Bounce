package bounce;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestGemShape {
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

	// GEM TESTS
	// GEM TESTS
	// GEM TESTS
	@Test
	//Test construction of big gem and movement
	public void testBigGemSimpleMove() {
		GemShape shape3 = new GemShape(120, 35, 20, 25, 50, 50, "word");
		shape3.paint(_painter);
		shape3.move(500, 500);
		shape3.paint(_painter);
		assertEquals("(line 120,60,140,35)(line 140,35,150,35)(line 150,35,170,60)(line 170,60,150,85)"
				+ "(line 150,85,140,85)(line 140,85,120,60)" + 
				"(line 140,85,160,60)(line 160,60,170,60)(line 170,60,190,85)(line 190,85,170,110)"
				+ "(line 170,110,160,110)(line 160,110,140,85)", _painter.toString());
	}
	@Test
	//Test construction of small gem and movement
	public void testSmallGemSimpleMove() {
		GemShape shape3 = new GemShape(120, 35, 20, 25, 20, 20, "word");
		shape3.paint(_painter);
		shape3.move(500, 500);
		shape3.paint(_painter);
		assertEquals("(line 120,45,130,35)(line 130,35,140,45)(line 140,45,130,55)(line 130,55,120,45)" + 
				"(line 140,70,150,60)(line 150,60,160,70)(line 160,70,150,80)(line 150,80,140,70)", _painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	//using Small gem so the test cases are easier to use
	@Test
	public void testGemShapeMoveWithBounceOffRight() {
		GemShape shape3 = new GemShape(120, 35, 20, 25, 20, 20, "word");
		shape3.paint(_painter);
		shape3.move(150, 10000);
		shape3.paint(_painter);
		shape3.move(150, 10000);
		shape3.paint(_painter);
		assertEquals("(line 120,45,130,35)(line 130,35,140,45)(line 140,45,130,55)(line 130,55,120,45)" + 
		"(line 130,70,140,60)(line 140,60,150,70)(line 150,70,140,80)(line 140,80,130,70)" +
				"(line 110,95,120,85)(line 120,85,130,95)(line 130,95,120,105)(line 120,105,110,95)", _painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testGemShapeMoveWithBounceOffLeft() {
		GemShape shape3 = new GemShape(10, 35, -20, 25, 20, 20, "word");
		shape3.paint(_painter);
		shape3.move(10000, 10000);
		shape3.paint(_painter);
		shape3.move(10000, 10000);
		shape3.paint(_painter);
		assertEquals("(line 10,45,20,35)(line 20,35,30,45)(line 30,45,20,55)(line 20,55,10,45)" +
		"(line 0,70,10,60)(line 10,60,20,70)(line 20,70,10,80)(line 10,80,0,70)" 
				+ "(line 20,95,30,85)(line 30,85,40,95)(line 40,95,30,105)(line 30,105,20,95)", _painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the bottom right corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testGemShapeMoveWithBounceOffBottomAndRight() {
		GemShape shape3 = new GemShape(90, 195, 20, 20, 20, 20, "word");
		shape3.paint(_painter);
		shape3.move(120, 225);
		shape3.paint(_painter);
		shape3.move(120, 225);
		shape3.paint(_painter);
		assertEquals("(line 90,205,100,195)(line 100,195,110,205)(line 110,205,100,215)(line 100,215,90,205)" 
		+ "(line 100,215,110,205)(line 110,205,120,215)(line 120,215,110,225)(line 110,225,100,215)" +
				"(line 80,195,90,185)(line 90,185,100,195)(line 100,195,90,205)(line 90,205,80,195)", _painter.toString());
	}

}
