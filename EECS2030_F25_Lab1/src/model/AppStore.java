package model;

public class AppStore {

	private String country;
	private App[] apps;
	private int maxapps;


	public AppStore(String country, int maxapps) {
		this.country = country;
		this.maxapps = maxapps;
		apps = new App[10];
	}

	public void addApp(App app) {
		for(int i = 0; i < apps.length; i++) {
			if (apps[i] == null) {
				apps[i] = app;
				break;
			}
		}
	}
	
	public int getMaxApps() {
		return maxapps;
	}

	public String getBranch() {
		return country;
	}

	public App getApp(String name) {
		for(int i = 0; i < apps.length; i++) {
			if (apps[i] != null && apps[i].getName().equals(name)) {
				return apps[i];
			}
		}
		return null;
	}

	public String[] getStableApps(int numofupts) {

		String[] tempapps = new String[apps.length];
		int upts = 0;
		int length = 0;
		for(int i = 0; i < apps.length; i++) {
			if(apps[i] != null) {
				Log[] updates = apps[i].getUpdates();
				upts = 0;

				for(int j = 0; j < updates.length; j++) {
					if (updates[j] != null) {
						upts++;
					}
				}

				if (upts >= numofupts) {
					tempapps[i] = "nonempty";
					length++;
				}
			}
		}

		String[] stableapps = new String[length];
		int ind = 0;
		
		for(int i = 0; i< apps.length; i++) {
			if(tempapps[i] != null) {
				stableapps[ind] = "" + apps[i].getName() + " (" + apps[i].getVersion() + " versions; Current Version: " +
						apps[i].getWhatIsNew() + ")";
						//return "" + name + " (Current Version: " + getWhatIsNew() + "; Average Rating: " + avg + ")";
				ind++;
			}
		}

		return stableapps;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public App[] getApps() {
		return apps;
	}

	public void setApps(App[] apps, int index) {
		apps[index] = null;
	}
}

