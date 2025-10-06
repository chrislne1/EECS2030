package model;

public class Log {

	private String[] fixes;
	public final int MAXFIXLENGTH = 10;
	private String version;


	public Log(String version) {
		this.version = version;
		fixes = new String[MAXFIXLENGTH];
	}

	public String getFixes() {
		String str = "[";

		for(int i = 0; i < fixes.length; i++) {
			if(fixes[i] == null) {
				break;
			}
			
			str += fixes[i];
			
			if (fixes[i+1] != null) {	
				str+= ", ";
			}
		}

		str+= "]";

		return str;
	}

	public void addFix(String msg) {
		for(int i = 0; i < fixes.length; i++) {
			if (fixes[i] == null) {
				fixes[i] = msg;
				break;
			}
		}

	}

	public int getNumberOfFixes() {
		int count = 0;

		for(int i = 0; i< fixes.length; i++) {
			if (fixes[i] != null) {
				count++;
			}
		}
		return count;
	}

	public String toString() {
		return "Version " + version + " contains " + getNumberOfFixes() + " fixes "+ getFixes() + "";
	}

	public void setFixes(String[] fixes) {
		this.fixes = fixes;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}




}
