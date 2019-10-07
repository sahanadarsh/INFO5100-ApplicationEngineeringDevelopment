package Assignment4;

import java.util.Enumeration;
import java.util.Vector;

public class Checkout {

	Vector<DessertItem> dessertItemVector;

	public Checkout() {
		dessertItemVector = new Vector<>();
	}

	public int numberOfItems() {
		return dessertItemVector.size();
	}

	public void enterItem(DessertItem item) {
		dessertItemVector.addElement(item);
	}

	public void clear() {
		dessertItemVector.clear();
	}

	public int totalCost() {
		int totalCost = 0;
		Enumeration<DessertItem> enumer = dessertItemVector.elements();

		//calculating the total cost by getting each element cost
		while (enumer.hasMoreElements()) { 
			totalCost = totalCost + enumer.nextElement().getCost();
		}
		return totalCost;
	}

	public int totalTax() {
		int totalTax = 0;
		DessertShop dessertshop = new DessertShop();
		totalTax = (int) Math.round(totalCost() * (dessertshop.getTAX_RATE()/100));
		return totalTax;
	}

	public String toString() {

		StringBuilder s = new StringBuilder();

		DessertShop desshop =  new DessertShop();
		s.append("\n");
		s.append("\t" + desshop.getSTORE_NAME());
		s.append("\n");
		s.append("\t--------------------\n");

		//m represents the total width to display the item name and its cost
		int m = desshop.getITEMNAME_MAXSIZE()+desshop.getCOSTITEM_DISPLAYWIDTH();

		Enumeration<DessertItem> enu = dessertItemVector.elements();

		while(enu.hasMoreElements()) {

			DessertItem elem = enu.nextElement();

			StringBuilder name = new StringBuilder();

			int startIndex = 0;

			//if name length is greater than ITEM_NAME_MAXSIZE value, then
			//continuation of that name has to be displayed in subsequent lines
			//here "n" represents that number of lines
			int n = elem.getName().length() / desshop.getITEMNAME_MAXSIZE();

			for(int i = 0; i < n; i ++) {
				name.append(elem.getName().substring(startIndex,(startIndex + desshop.getITEMNAME_MAXSIZE())) + "\n");
				startIndex = startIndex + desshop.getITEMNAME_MAXSIZE();
			}

			name.append(elem.getName().substring(startIndex,(startIndex + elem.getName().length() % desshop.getITEMNAME_MAXSIZE())));

			String cost = String.valueOf(desshop.cents2dollarsAndCentsmethod(elem.getCost()));

			startIndex = (elem.getName().length() % desshop.getITEMNAME_MAXSIZE());

			while(startIndex < (m - cost.length()))
			{
				name.append(" ");
				startIndex++;
			}

			if(elem.getClass().equals(Candy.class)) {
				Candy candy = (Candy) elem;
				s.append("\n" + candy.getWeight() + " lbs. @ " + (candy.getPricePerPound()/100.0) + " /lb." );
				s.append("\n");
				s.append(name + cost);
			}

			if(elem.getClass().equals(Cookie.class)) {
				Cookie cookie = (Cookie) elem;
				s.append("\n" + cookie.getNumberOfCookies() + " @ " + (cookie.getPricePerDozen()/100.0) + " /dz.");
				s.append("\n");
				s.append(name + cost);
			}


			if(elem.getClass().equals(Sundae.class)) {
				Sundae sundae = (Sundae) elem;
				s.append("\n" + sundae.getTopping() + " Sundae with ");
				s.append("\n");
				s.append(name + cost);
			}

			if(elem.getClass().equals(IceCream.class)) {
				s.append("\n");
				s.append(name + cost);
			}

		}

		s.append("\n");
		s.append("\n");


		String taxPercent = Double.toString(totalTax()/100.0);

		StringBuilder tax = new StringBuilder("Tax");

		while(tax.length() < (m - taxPercent.length())) {
			tax.append(" ");
		}
		tax.append(taxPercent);

		String totalCost = Double.toString((totalCost()+totalTax())/100.0);

		StringBuilder total =new StringBuilder("Total Cost");

		while(total.length() < (m - totalCost.length())) {
			total.append(" ");
		}

		total.append(totalCost);

		s.append(tax);
		s.append("\n");
		s.append(total);
		return s.toString();
	}
}
