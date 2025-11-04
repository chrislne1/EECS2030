package model;

public class Blueprint {
	private Floor[] floors;
	private int numoffloors, comp;
	private double perc;

	public Blueprint(int numoffloors) {
		this.numoffloors = numoffloors;
		floors = new Floor[numoffloors];
		perc = 0.0;
		comp = 0;
	}
	
	//Copy a blueprint into another blueprint
	public Blueprint(Blueprint copy) {
		this.numoffloors = copy.getNumoffloors();
		this.floors = copy.getFloors();
		this.perc = copy.getPerc();
		this.comp = copy.getComp();
	}

	public String toString() {
		//"0.0 percents of building blueprint completed (0 out of 7 floors)"
		String str = perc + " percents of building blueprint completed (" + comp + " out of " + numoffloors + " floors)";
		return str;
	}

	public void addFloorPlan(Floor f) {
		for(int i =0; i< floors.length; i++) {
			if(floors[i] == null) {
				floors[i] = f;
				comp++;
				perc = Math.round(1000.0 * comp / numoffloors) / 10.0;
				break;
			}
		}
	}

	public Floor[] getFloors() {
		Floor[] temp = new Floor[numoffloors];
		int ind = 0;
		
		for(int i = 0; i< floors.length; i++) {
			if(floors[i] != null) {
				temp[ind] = new Floor(floors[i]);
				ind++;
			}
		}
		
		Floor[] f = new Floor[ind];
		
		for(int i =0; i < f.length; i++) {
			f[i] = temp[i];
		}
		
		return f;
	}

	public int getNumoffloors() {
		return numoffloors;
	}

	public void setNumoffloors(int numoffloors) {
		this.numoffloors = numoffloors;
	}

	public int getComp() {
		return comp;
	}

	public void setComp(int comp) {
		this.comp = comp;
	}

	public double getPerc() {
		return perc;
	}

	public void setPerc(double perc) {
		this.perc = perc;
	}

	public void setFloors(Floor[] floors) {
		this.floors = floors;
	}
}
