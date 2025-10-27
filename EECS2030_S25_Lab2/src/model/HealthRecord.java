package model;

public class HealthRecord {

	private String name;
	private int maxdoses;
	private Vaccine [] doseshad;
	private boolean hasappointmentbooked;
	private String [] hospitals;
	private String [] dates;
	private String str;
	
	public HealthRecord(String name, int maxdoses) {
		this.name = name;
		this.maxdoses = maxdoses;
		hasappointmentbooked = false;
		doseshad = new Vaccine[maxdoses];
		hospitals = new String[maxdoses];
		dates = new String[maxdoses];
		str = "No vaccination appointment for " + name + " yet";
	}
	
	public String getVaccinationReceipt() {
		//"Alan has not yet received any doses."
		 String str = "";
		 int counter = 0;
		 
		 for(int i= 0; i<maxdoses;i++) {
			 if(doseshad[i] != null) {
				 counter++;
			 }
		 }
		 
		if (counter == 0) {
			str = name + " has not yet received any doses.";
			return str;
		}
		
		else {
			//Number of doses Alan has received: 2 [Recognized vaccine: mRNA-1273 (RNA; Moderna) in 
			//North York General Hospital on April-20-2021; Recognized vaccine: BNT162b2 (RNA; Pfizer/BioNTech) in 
			//Humber River Hospital on June-30-2021]"
			
			str = "Number of doses " + name + " has received: " + counter + " [";
			for(int i=0; i<counter; i++) {
				str += doseshad[i].toString() + " in " + hospitals[i] + " on " + dates[i];
				
				if(i != counter-1) {
					str+="; ";
				}
			}
			
			str += "]";
			return str;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setAppointmentBooked(boolean booked) {
		hasappointmentbooked = booked;
	}
	
	public int getMaxDoses() {
		return maxdoses;
	}
	
	public String getAppointmentStatus() {

		//Last vaccination appointment for Alan with North York General Hospital succeeded

		
		return str;
	}
	
	public void setAppointmentStatus(String s) {
		str = s;
	}
	
	public void addRecord(Vaccine vax, String hospitalname, String date) {
		for(int i = 0; i<maxdoses;i++) {
			if(doseshad[i] == null) {
				doseshad[i] = vax;
				hospitals[i] = hospitalname;
				dates[i] = date;
				break;
			}
		}
		
	}
	
}
