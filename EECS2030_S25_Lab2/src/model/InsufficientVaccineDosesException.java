package model;


public class InsufficientVaccineDosesException extends Exception {
	public InsufficientVaccineDosesException() {
		super("");
	}
	
	public InsufficientVaccineDosesException(String msg) {
		super(msg);
	}

}
