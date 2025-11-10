package model;

public class App {

	private String name;
	private int[] ratings;
	private String news;	
	private Log[] updates;
	public int version;

	public App(String name, int maxratings) {
		this.name = name;
		this.ratings = new int[maxratings];
		updates = new Log[20];
	}
	
	public App() {
		ratings = new int[20];
	}

	public String getName() {
		return name;
	}
	
	public int getVersion() {
		version = 0;
		for(int i = 0; i < updates.length; i++) {
			if (updates[i] != null) {
				version++;
			}
		}
		return version;
	}
	
	public Log[] getUpdates() {
		return updates;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWhatIsNew() {

		news = "n/a";
		
		for(int i = 19; i >= 0; i--) {
			if(updates != null && updates[i] != null) {
				news = "Version " + updates[i].getVersion() + " contains " + updates[i].getNumberOfFixes() + " fixes " + updates[i].getFixes();
				break;
			}
		}
		return news;
	}

	public Log[] getUpdateHistory() {
		int length = 0;

		for(int i = 0; i < updates.length; i++) {
			if (updates[i]!= null) {
				length++;
			}
		}

		Log [] updateHistory = new Log[length];

		for(int i = 0; i < length; i++) {
			updateHistory[i] = updates[i];
		}

		return updateHistory;
	}

	public Log getVersionInfo(String version) {
		for(int i = 0; i < updates.length; i++) {
			if (updates[i] != null && updates[i].getVersion().equals(version)) {
				return updates[i];
			}
		}
		return null;
	}

	public String toString() {
		String avg = getRatingReport().substring(22, 25);
		if (getRatingReport().equals("No ratings submitted so far!"))
		{
			avg = "n/a";
		}
		return "" + name + " (Current Version: " + getWhatIsNew() + "; Average Rating: " + avg + ")";
	}

	public String getRatingReport() {
		if (ratings[0] == 0) {
			return "No ratings submitted so far!";
		}

		String str = "";
		double avg = 0.0;
		int numberOfRaters = 0;
		double totalRatingval = 0;
		int[] rateval = new int[6];

		//Average of 1 ratings: 3.0 (Score 5: 0, Score 4: 0, Score 3: 1, Score 2: 0, Score 1: 0)"

		for(int i = 0; i < ratings.length; i++) {
			if(ratings[i] != 0) {
				totalRatingval+= ratings[i];
				rateval[ratings[i]]++;
				numberOfRaters++;
			}
		}

		avg = (double) totalRatingval / numberOfRaters;

		str = "Average of " + numberOfRaters + " ratings: " + String.format("%.1f", avg) + " (Score 5: " + rateval[5] + 
				", Score 4: " + rateval[4] + ", Score 3: " + rateval[3] + ", Score 2: " + rateval[2] + ", Score 1: " + rateval[1] + ")";
		return str;
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public void releaseUpdate(String newupt) {
		for(int i = 0; i < updates.length; i++) {
			if(updates[i] == null) {
				updates[i] = new Log(newupt);
				break;
			}
		}
	}
	
	public void submitRating(int r) {
		for(int i = 0; i < 20; i++) {
			if (ratings[i] == 0) {
				ratings[i] = r;
				break;
			}
		}
	}
}
