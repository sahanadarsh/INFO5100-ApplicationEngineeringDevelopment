package Assignment4;

public class ShapeTester {

	public static void main(String[] args) {
		Shape s = new Shape();
		Rectangle r = new Rectangle(2,3);
		Circle c = new Circle(4.0);
		Square sq = new Square(4.0);
		r.getArea();
		r.getPerimeter();
		c.getArea();
		c.getPerimeter();
		sq.getArea();
		sq.getPerimeter();
		r.draw();
		c.draw();
		s.draw();
		sq.draw();
	}
}
