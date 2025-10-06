package model;

public class Entry {
	//Global variables
	private String serialNumber;
	private Product product;
	
	//Constructor that takes inputs to initialize
	public Entry (String serialNumber, Product product) {
		this.serialNumber = serialNumber;
		this.product = product;
	}

	//Generated getters nd setters
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	//Sets products model and price
	public void setProduct(String model, double origonalPrice) {
		this.product = new Product(model, origonalPrice);
	}
	
	//String statement
	public String toString() {
		return "[" + this.serialNumber + "] " + this.product.toString();
	}
}
