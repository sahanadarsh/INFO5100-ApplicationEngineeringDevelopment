package Assignment4;

public class Cookie extends DessertItem {

	private int numberOfCookies;
	private double pricePerDozen;
	
	public Cookie(String name, int numberOfCookies, double pricePerDozen) {
		super(name);
		this.numberOfCookies = numberOfCookies;
		this.pricePerDozen = pricePerDozen;
	}

	public int getNumberOfCookies() {
		return numberOfCookies;
	}

	public void setNumberOfCookies(int numberOfCookies) {
		this.numberOfCookies = numberOfCookies;
	}

	public double getPricePerDozen() {
		return pricePerDozen;
	}

	public void setPricePerDozen(double pricePerDozen) {
		this.pricePerDozen = pricePerDozen;
	}

	@Override
	public int getCost() {
		int cost = (int) Math.round((getPricePerDozen() / 12) * getNumberOfCookies());
		return cost;
	}
	
	
	
}
