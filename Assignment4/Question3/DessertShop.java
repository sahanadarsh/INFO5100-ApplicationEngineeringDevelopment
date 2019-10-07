package Assignment4;

public class DessertShop {

	private final double TAX_RATE = 6.5;
	private final String STORE_NAME = "M & M Dessert Shoppe";
	private final int ITEMNAME_MAXSIZE = 30;
	private final int COSTITEM_DISPLAYWIDTH = 10;

	public double getTAX_RATE() {
		return TAX_RATE;
	}

	public String getSTORE_NAME() {
		return STORE_NAME;
	}

	public int getITEMNAME_MAXSIZE() {
		return ITEMNAME_MAXSIZE;
	}

	public int getCOSTITEM_DISPLAYWIDTH() {
		return COSTITEM_DISPLAYWIDTH;
	}

	public String cents2dollarsAndCentsmethod(int cost) {
		String costInDollarsAndCents = Double.toString(cost/100.0);
		return costInDollarsAndCents;
	}

}
