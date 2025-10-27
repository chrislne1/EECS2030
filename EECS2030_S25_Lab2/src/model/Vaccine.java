package model;

public class Vaccine {

	private String codename;
	private String manufactor;
	private String type;
	
	public Vaccine(String codename, String type, String manufactor){
		this.codename = codename;
		this.type = type;
		this.manufactor = manufactor;
	}
	
	public String toString() {
		//"Recognized vaccine: mRNA-1273 (RNA; Moderna)"
		//mRNA-1273, BNT162b2, Ad26.COV2.S, and AZD1222
		String str ="";
		if(codename == "mRNA-1273" || codename == "BNT162b2" || codename == "Ad26.COV2.S" || codename == "AZD1222") {
			str+= "Recognized vaccine: ";
		}
		else {
			str+="Unrecognized vaccine: ";
		}
		
		str+= codename + " ("  + type + "; " + manufactor + ")";
		return str;
	}

	public String getCodename() {
		return codename;
	}

	public void setCodename(String codename) {
		this.codename = codename;
	}

	public String getManufactor() {
		return manufactor;
	}

	public void setManufactor(String manufactor) {
		this.manufactor = manufactor;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
