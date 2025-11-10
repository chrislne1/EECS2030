package model;

public class UnrecognizedVaccineCodeNameException extends Exception{

	public UnrecognizedVaccineCodeNameException() {
		super("Vaccine is unreckognized");
	}
	
	public UnrecognizedVaccineCodeNameException(String msg) {
		super(msg);
	}

}
