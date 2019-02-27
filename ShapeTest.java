import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for shapes and their comparators.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeTest
{
	//==================================================================================================================
	// Basic Shape Testing:
	//==================================================================================================================
    /**
     * Tests for the square class.
     */
	@Test
	public void SquareTest()
	{
		Shape sqr = new Square("Square1", 3.0);
		Assert.assertEquals("Square area incorrect.", 9.0, sqr.getArea(), 0.0001);
		Assert.assertEquals("Square perimeter incorrect.", 12.0, sqr.getPerimeter(), 0.0001);
		Assert.assertEquals("Square type incorrect.", "Square", sqr.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Square1", sqr.getId());
	}

	/**
     * Tests for the rectangle class.
     */
	@Test
	public void RectangleTest()
	{
		Shape rect = new Rectangle("Rectangle1", 3.0, 4.0);
		Assert.assertEquals("Rectangle area incorrect.", 12.0, rect.getArea(), 0.0001);
		Assert.assertEquals("Rectangle perimeter incorrect.", 14.0, rect.getPerimeter(), 0.0001);
		Assert.assertEquals("Rectangle type incorrect.", "Rectangle", rect.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Rectangle1", rect.getId());// TODO: complete this...
	}

	/**
     * Tests for the EquilateralTriangle class.
     */
	@Test
	public void TriangleTest()
	{
		Shape tri = new EquilateralTriangle("Triangle1", 4.0);
		Assert.assertEquals("Equilateral Triangle area incorrect.", 
				(4 * 4 * Math.sqrt(3)) / 4, tri.getArea(), 0.0001);
		Assert.assertEquals("Equilateral Triangle perimeter incorrect.", 12.0, tri.getPerimeter(), 0.0001);
		Assert.assertEquals("Equilateral Triangle type incorrect.", "EquilateralTriangle", tri.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Triangle1", tri.getId());// TODO: complete this...
	}

	/**
     * Tests for the trapezoid class. Also test that IDs are done correctly.
     */
	@Test
	public void TrapezoidTest()
	{
		Shape trap = new Trapezoid("Trapezoid1", 3.0, 3.0, 4.0, 5.0);
		Assert.assertEquals("Trapezoid area incorrect.", 13.3112, trap.getArea(), 0.0001);
		Assert.assertEquals("Trapezoid perimeter incorrect.", 15.0, trap.getPerimeter(), 0.0001);
		Assert.assertEquals("Trapezoid type incorrect.", "Trapezoid", trap.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Trapezoid1", trap.getId());
		

		Shape trap2 = new Trapezoid("Trapezoid2", 4.0, 4.0, 5.0, 6.0);
		Assert.assertEquals("Trapezoid area incorrect.", 21.8274, trap2.getArea(), 0.0001);
		Assert.assertEquals("Trapezoid perimeter incorrect.", 19.0, trap2.getPerimeter(), 0.0001);
		Assert.assertEquals("Trapezoid type incorrect.", "Trapezoid", trap2.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Trapezoid2", trap2.getId());// TODO: complete this...
	}

	/**
     * Tests for the ellipse class. Also test that IDs are done correctly.
     */
	@Test
	public void EllipseTest()
	{
		Shape circ = new Ellipse("Ellipse1", 3.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3.0*3.0, circ.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(3, 2) + Math.pow(3, 2)) / 2),
				circ.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse1", circ.getId());

		Shape circs = new Ellipse("Ellipse2", 5.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3*5, circs.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(5.0, 2) + Math.pow(3.0, 2)) / 2),
				circs.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circs.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse2", circs.getId());
	}

	/**
     * Tests for the circle class. Also test that IDs are done correctly.
     */
	@Test
	public void CircleTest()
	{
		Shape circle = new Circle("Circle1", 5.0);
		Assert.assertEquals("Circle area incorrect.", Math.PI * Math.pow(5.0, 2), circle.getArea(), 0.0001);
		Assert.assertEquals("Circle perimeter incorrect.", 2 * Math.PI * 5.0, circle.getPerimeter(), 0.0001);
		Assert.assertEquals("Circle type incorrect.", "Circle", circle.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Circle1", circle.getId());// TODO: complete this...
	}

	/**
	 * Tests for Shape's toString().
	 */
	@Test
	public void ShapeToStringTest()
	{
		Shape sqr = new Square("Square1", 3.0);
		Assert.assertEquals("Square:\t ID = Square1\t area = 9.000\t perimeter = 12.000", sqr.toString());// TODO: complete this...
	}

	//==================================================================================================================
	// Comparisons:
	//==================================================================================================================
	/**
     * Tests for the Shape Area Comparator class.
     */
	@Test
	public void CompareAreaTest()
	{
	    // Test equals:
		Shape rect = new Rectangle("R1", 3.0,3.0);
		Shape sqr = new Square("S1", 3.0);
		ShapeAreaComparator sc = new ShapeAreaComparator();
		Assert.assertEquals("ShapeAreaComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapeAreaComparator should find shapes equal.", sc.equals(rect, sqr));

		// Test equal perimeter, different area:
        Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr2 = new Square("S2", 5.0);
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect2, sqr2));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

        // Test unequal perimeter and area:
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
	}

	/**
     * Tests for the Shape Perimter Comparator class.
     */
	@Test
	public void ComparePerimeterTest()
	{
		// Test equals:
		Shape rect3 = new Rectangle("R3", 5.0, 5.0);
		Shape sqr3 = new Square("S3", 5.0);
		ShapePerimeterComparator sc = new ShapePerimeterComparator();
		Assert.assertEquals("ShapePerimeterComparator should find shapes equal.", 0, sc.compare(rect3, sqr3));
		Assert.assertTrue("ShapePerimeterComparator should find shapes equal.", sc.equals(rect3, sqr3));
		
		// Test equal area, different perimeter:
		Shape rect4 = new Rectangle("R4", 2.0, 8.0);
        Shape sqr4 = new Square("S4", 4.0);
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, sc.compare(rect4, sqr4));
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, sc.compare(sqr4, rect4));
        Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", sc.equals(rect4, sqr4));
        
     // Test unequal perimeter and area:
        Assert.assertEquals("ShapePerimeteraComparator gave incorrect ordering.", -1, sc.compare(sqr4, rect3));
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, sc.compare(rect3, sqr4));
        Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", sc.equals(sqr4, rect3));// TODO: complete this...
	}

	/**
	 * Tests the natural ordering of shapes (compareTo in shape)
	 */
	@Test
    public void NaturalCompareTest()
    {
		ShapeSorter sorter = new ShapeSorter();
		
		Shape s1 = new Square("A", 6.0);
		Shape s2 = new Rectangle("B", 3.0, 2.0);
		Shape s3 = new Rectangle("C", 1.0, 4.0);
		
		sorter.addShape(s1);
		sorter.addShape(s3);
		sorter.addShape(s2);
		
		sorter.sortShapes();// TODO: complete this...
    }
}
