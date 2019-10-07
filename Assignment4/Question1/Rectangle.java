package Assignment4;

public class Rectangle extends Shape{
	private double width;
	private double height;

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public double getPerimeter() {
		System.out.println(2*getWidth() + 2*getHeight());
		return (2*getWidth() + 2*getHeight());
	}

	public double getArea() {
		System.out.println(width*height);
		return width*height;
	}

	public void draw() {
		System.out.println("Drawing Rectangle");
	}
}
