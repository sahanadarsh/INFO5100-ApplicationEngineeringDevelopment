package Assignment4;

public class Shape {

	protected String name;
	protected double perimeter;
	protected double area;

	public Shape(String name, double perimeter, double area) {
		this.name = name;
		this.perimeter = perimeter;
		this.area = area;
	}


	public Shape() {
	}

	public double getPerimeter() {
		return perimeter;
	}

	public double getArea() {
		return area;
	}

	public void draw() {
		System.out.println("Drawing Shape");
	}
}
