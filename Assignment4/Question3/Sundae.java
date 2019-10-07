package Assignment4;

public class Sundae extends IceCream {

	private String topping;
	private double costOfTopping;

	public String getTopping() {
		return topping;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}

	public double getCostOfTopping() {
		return costOfTopping;
	}

	public void setCostOfTopping(double costOfTopping) {
		this.costOfTopping = costOfTopping;
	}

	public Sundae(String name, int cost, String topping, double costOfTopping) {
		super(name, cost);
		this.topping = topping;
		this.costOfTopping = costOfTopping;
	}

	public int getCost() {
		int cost = (int) Math.round(super.getCost() + getCostOfTopping());
		return cost;
	}

}
