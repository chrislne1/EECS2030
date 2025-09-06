package model;

//Template for apple products
public class Product {

	private String model;
	private String finish;
	private int storage;
	private boolean hasCellularConnectivity;
	private double origonalPrice;
	private double discountValue;
	
	public Product() {
		
	}
	
	public Product(String model, double origonalPrice) {
		this.model = model;
		this.origonalPrice = origonalPrice;
	}
	
	public double getPrice() {
		double price = 0.0;
		price = origonalPrice - discountValue;
		return price;
	}
	
	public String toString(){
		String s = "";
		s += model + " " + finish + " " + storage + "GB" + " (cellular connectivity: " 
				+ this.hasCellularConnectivity + "):  $(" 
				+ String.format("%.2f", origonalPrice)
				+ " - " + String.format("%.2f", discountValue) + ")";
		return s;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public boolean hasCellularConnectivity() {
		return hasCellularConnectivity;
	}

	public void setHasCellularConnectivity(boolean hasCellularConnectivity) {
		this.hasCellularConnectivity = hasCellularConnectivity;
	}

	public double getOrigonalPrice() {
		return origonalPrice;
	}

	public void setOrigonalPrice(double origonalPrice) {
		this.origonalPrice = origonalPrice;
	}

	public double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}
}
