package model;

public class Account {

	private String username;
	private AppStore store;
	private String status;
	private boolean downloaded;
	private App[] downloadedapps;

	public Account(String name, AppStore s) {
		username = name;
		store = s;
		downloadedapps = new App[20];
		status = "An account linked to the " + store.getBranch() + " store is created for " + username + ".";
		downloaded = false;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AppStore getStore() {
		return store;
	}

	public void setStore(AppStore store) {
		this.store = store;
	}

	public void download(String appName) {
		App storeApp = store.getApp(appName);
		if (storeApp == null) {
			status = "Error: " + appName + " does not exist in the store.";
			return;
		}

		for (App app : downloadedapps) {
			if (app != null && app.getName().equals(appName)) {
				status = "Error: " + appName + " has already been downloaded for " + username + ".";
				return;
			}
		}

		// add to first null slot
		for (int i = 0; i < downloadedapps.length; i++) {
			if (downloadedapps[i] == null) {
				downloadedapps[i] = storeApp;  // ⚡ reference the store’s app
				status = appName + " is successfully downloaded for " + username + ".";
				return;
			}
		}
	}

	public String[] getNamesOfDownloadedApps() {
		String[] temp = new String[downloadedapps.length];
		int ind = 0;

		for(int i = 0; i < downloadedapps.length; i++) {
			if (downloadedapps[i] != null) {
				temp[ind] = downloadedapps[i].getName();
				ind++;
			}
		}

		String[] appnames = new String[ind];

		for(int i = 0; i < appnames.length; i++) {
			appnames[i] = temp[i];
		}

		return appnames;
	}

	public App[] getObjectsOfDownloadedApps() {
		App[] temp = new App[downloadedapps.length];
		int ind = 0;

		for(int i = 0; i < downloadedapps.length; i++) {
			if (downloadedapps[i] != null) {
				temp[ind] = downloadedapps[i];
				ind++;
			}
		}

		App[] downapps = new App[ind];

		for(int i = 0; i < downapps.length; i++) {
			downapps[i] = temp[i];
		}

		return downapps;
	}

	public void uninstall(String appname) {
		for(int i = 0; i < downloadedapps.length; i++) {
			if (downloadedapps[i] != null && downloadedapps[i].getName().equals(appname)) {
				downloadedapps[i] = null;
				downloaded = true;
			}
		}

		if (downloaded == false) {
			status = "Error: " + appname + " has not been downloaded for " + username + ".";
		}
		else {
			status = appname + " is successfully uninstalled for " + username + ".";
		}
	}

	public void submitRating(String appName, int rating) {
		App target = null;
		for (App app : downloadedapps) {
			if (app != null && app.getName().equals(appName)) {
				target = app;
				break;
			}
		}

		if (target == null) {
			status = "Error: " + appName + " is not a downloaded app for " + username + ".";
			return;
		}

		target.submitRating(rating);
		status = "Rating score " + rating + " of " + username +
				" is successfully submitted for " + appName + ".";
	}

	public String toString() {
		return status;
	}

	public void switchStore (AppStore region) {
		store = new AppStore(region.getBranch(), region.getMaxApps());
		status = "Account for " + username + " is now linked to the " + region.getBranch() + " store.";
	}
}
