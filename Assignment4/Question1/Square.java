package Assignment4;

public class Square extends Shape{

	private double side;

	public Square(double side) {
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	public double getPerimeter() {
		System.out.println(4*getSide());
		return 4*getSide();
	}

	public double getArea() {
		System.out.println(getSide()*getSide());
		return getSide()*getSide();
	}

	public void draw() {
		System.out.println("Drawing Square");
	}
}
