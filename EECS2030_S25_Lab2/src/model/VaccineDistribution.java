package model;

public class VaccineDistribution {

	private Vaccine vax;
	private int dosage;
	
	public VaccineDistribution(Vaccine vax, int dosage) {
		this.vax = vax;
		this.dosage = dosage;
	}
	
	public String toString() {
		//"10000 doses of mRNA-1273 by Moderna"
		return "" + dosage + " doses of " + vax.getCodename() + " by " + vax.getManufactor();
	}
}
