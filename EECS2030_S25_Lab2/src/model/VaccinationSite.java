package model;

public class VaccinationSite {

	private String site;
	private int maxdoses, numofvaxs;
	private Vaccine [] vaxs;
	private int [] vaxct;
	private int appointmentsbooked;
	private int[] orderAdded; 
	private int orderCount;
	private HealthRecord[] bookedPatients;
    private int bookedCount;
    
	public VaccinationSite (String site, int maxdoses) {
		this.site = site;
		this.maxdoses = maxdoses;
		vaxs = new Vaccine[4];
		vaxct = new int[4];
		numofvaxs = 0;
		appointmentsbooked = 0;
		
		orderAdded = new int[4];
		orderCount = 0;
				
		vaxs[0] = new Vaccine("mRNA-1273", "", "Moderna");
		vaxs[1] = new Vaccine("BNT162b2", "", "Pfizer/BioNTech");
		vaxs[2] = new Vaccine("Ad26.COV2.S", "", "Janssen");
		vaxs[3] = new Vaccine("AZD1222", "", "Oxford/AstraZeneca");

		for (int i = 0; i < orderAdded.length; i++) {
			orderAdded[i] = -1;
		}
	}

	public String toString() {
	    String str = site + " has " + numofvaxs + " available doses: <";
	    int vaxshere = 0;

	    // count all vaccines in orderAdded (even if 0) for proper comma placement
	    for (int j = 0; j < orderCount; j++) vaxshere++;

	    for(int j = 0; j < orderCount; j++) {
	        int i = orderAdded[j];
	        str += vaxct[i] + " doses of " + vaxs[i].getManufactor();
	        vaxshere--;
	        if(vaxshere >= 1) str += ", ";
	    }

	    str += ">";
	    return str;
	}


	public int getNumberOfAvailableDoses() {
		return numofvaxs;
	}

	public int getNumberOfAvailableDoses(String vaxcode) {
		for(int i =0; i<vaxs.length; i++ ) {
			if(vaxs[i].getCodename().equals(vaxcode)) {
				numofvaxs = vaxct[i];
			}
		}
		return numofvaxs;
	}

	public void addDistribution(Vaccine v, int amount)  
			throws UnrecognizedVaccineCodeNameException, TooMuchDistributionException{

			boolean recognized = false;
			int index = -1; // 🔹 index of vaccine in vaxs

			if (v.getManufactor().equals("Moderna")) {
				index = 0; vaxct[0] += amount; recognized = true;
			}
			else if (v.getManufactor().equals("Pfizer/BioNTech")) {
				index = 1; vaxct[1] += amount; recognized = true;
			}
			else if (v.getManufactor().equals("Janssen")) {
				index = 2; vaxct[2] += amount; recognized = true;
			}
			else if (v.getManufactor().equals("Oxford/AstraZeneca")) {
				index = 3; vaxct[3] += amount; recognized = true;
			}

			if (!recognized) {
				throw new UnrecognizedVaccineCodeNameException();
			}

			if (!alreadyAdded(index)) {
				orderAdded[orderCount] = index;
				orderCount++;
			}

			numofvaxs = 0;
			for (int i = 0; i < vaxct.length; i++) {
			    numofvaxs += vaxct[i];
			}


			if (numofvaxs > maxdoses) {
				throw new TooMuchDistributionException();
			}
	}

	private boolean alreadyAdded(int idx) {
		for (int i = 0; i < orderCount; i++) {
			if (orderAdded[i] == idx) return true;
		}
		return false;
	}

	public void bookAppointment(HealthRecord person) throws InsufficientVaccineDosesException{
		
		if(appointmentsbooked >= numofvaxs) {
			person.setAppointmentBooked(false);
			person.setAppointmentStatus("Last vaccination appointment for " + person.getName() + " with " + site + " failed");
			person.addRecord(null, site, null);
			throw new InsufficientVaccineDosesException();
		}
		
		appointmentsbooked++;
		person.addRecord(null, site, null);
		person.setAppointmentBooked(true);
		person.setAppointmentStatus("Last vaccination appointment for " + person.getName() + " with " + site + " succeeded");
	}
	
	public void administer(String date) {
        int dosesRemaining = numofvaxs;
        for (int j = 0; j < orderCount; j++) {
            int vaxIndex = orderAdded[j];
            if (vaxct[vaxIndex] == 0) continue;

            for (int p = 0; p < bookedCount && dosesRemaining > 0; p++) {
                HealthRecord patient = bookedPatients[p];
                // check if patient already got dose? skip if null
                if (patient == null) continue;

                patient.addRecord(vaxs[vaxIndex], site, date);
                vaxct[vaxIndex]--;
                dosesRemaining--;
            }
        }

        // update total doses and reset appointments
        numofvaxs = 0;
        for(int i=0;i<vaxct.length;i++) numofvaxs += vaxct[i];

        // reset bookings
        for(int i=0;i<bookedCount;i++) bookedPatients[i]=null;
        bookedCount=0;
        appointmentsbooked=0;
    }

}
