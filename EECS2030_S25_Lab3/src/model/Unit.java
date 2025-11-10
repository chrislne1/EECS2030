package model;

import static org.junit.Assert.assertEquals;

public class Unit {
	private String name;
	private double length, width, area;
	private boolean feet = true;
	
	public Unit(String name, int width, int length) {
		this.name = name;
		this.width = width;
		this.length = length;
		area = width * length;
	}
	
	public String toString() {
		String str ="";
		
		//measured in feet
		//"A unit of 126 square feet (14' wide and 9' long) functioning as Master Room"
		if(feet) {
			area = (int) (length * width);
			str = "A unit of " + (int) area +" square feet (" + (int)width + "' wide and " + (int)length + "' long) functioning as " + name;
		}
		
		//measured in ms
		//"A unit of 11.71 square meters (4.27 m wide and 2.74 m long) functioning as Master Room"
		else {
			double templength =  Math.round(length * 100.0) / 100.0;
			double tempwidth  = Math.round(width * 100.0) / 100.0;
			area = Math.round(length * width * 100.0) / 100.0;
			
			str = "A unit of " + area + " square meters (" + tempwidth + " m wide and " + templength + " m long) functioning as "+ name;
		}
		return str;
	}
	
	public void toggleMeasurement() {
		//* Use this conversion formula: One foot is equal to 0.3048 meter.
		// * Each value of meters and square meters should be displayed with 2 digits after the decimal point.
		
		//feet to meters
		if (feet) {
			feet = false;
			length = length * 0.3048;
			width  = width  * 0.3048;
		}
		//meters to feet
		else {
			feet = true;
			length = (int) Math.round(length /.3048);
			width = (int) Math.round(width /.3048);
		}
	}
	
	public boolean equals(Object obj) {
		
		return (this.getName().equals(((Unit) obj).getName())) && (this.getArea() == ((Unit) obj).getArea());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public boolean isFeet() {
		return feet;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public void setFeet(boolean feet) {
		this.feet = feet;
	}
}
