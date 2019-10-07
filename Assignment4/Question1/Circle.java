package Assignment4;

public class Circle extends Shape {

	private double radius; 

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public double getPerimeter() {
		System.out.println(String.format ("%,.2f", 2*Math.PI*getRadius()));
		return (Math.round(2*Math.PI*getRadius()));
	}

	public double getArea() {
		System.out.println(String.format ("%,.2f", (Math.PI*getRadius()*getRadius())));
		return (Math.PI*getRadius()*getRadius());
	}

	public  void draw() {
		System.out.println("Drawing Circle");
	}

}
