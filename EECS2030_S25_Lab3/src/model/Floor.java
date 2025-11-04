package model;


public class Floor {

	private int capacity, usedspace, arrlength;
	private Unit[] units;

	public Floor(int capacity) {
		this.capacity = capacity;
		arrlength = 0;
		usedspace = 0;
		units = new Unit[5];
	}

	//Copy constructor for blueprint to copy other floors but different refence type
	public Floor(Floor copy) {
		this.capacity = copy.getCapacity();
		this.arrlength = copy.getArrlength();
		this.usedspace = copy.getUsedspace();
		this.units = copy.getUnits();
	}

	public String toString() {
		String str = "";

		str = "Floor's utilized space is " + usedspace + " sq ft (" +(capacity - usedspace) +" sq ft remaining): [";

		for(int i = 0; i< units.length; i++) {
			if (units[i] != null) {
				//Master Bedroom: 144 sq ft (18' by 8')]
				str += units[i].getName() + ": ";

				//If its in feet
				if(units[i].isFeet()) {
					str += (int) units[i].getArea() + " sq ft (" + (int) units[i].getWidth() + "' by " + (int) units[i].getLength() + "')";
				}

				else {
					str += " sq meters (" + units[i].getWidth() + "m by " + units[i].getLength() + "m)";
				}

				if(i != arrlength-1) {
					str+= ", ";
				}
			}
		}

		str += "]";

		return str;
	}

	public void addUnit(String name, int width, int length) throws InsufficientFloorSpaceException{

		int area = width * length;

		if((capacity - area - usedspace) <0) {
			throw new InsufficientFloorSpaceException();
		}

		for(int i =0; i < units.length; i++) {
			if(units[i] == null) {
				units[i] = new Unit(name, width, length);
				usedspace += units[i].getArea();
				arrlength++;
				break;
			}
		}
	}

	public boolean equals(Object obj) {
		if (this.getCapacity() == ((Floor) obj).getCapacity() && this.getArrlength() == ((Floor)obj).getArrlength()
				&& this.getUsedspace() == ((Floor)obj).getUsedspace()){
			return true;
		}

		return false;

	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getUsedspace() {
		return usedspace;
	}

	public void setUsedspace(int usedspace) {
		this.usedspace = usedspace;
	}

	public int getArrlength() {
		return arrlength;
	}

	public void setArrlength(int arrlength) {
		this.arrlength = arrlength;
	}

	public Unit[] getUnits() {
		return units;
	}

	public void setUnits(Unit[] units) {
		this.units = units;
	}
}
