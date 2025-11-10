package model;

public class TooMuchDistributionException extends Exception{
	
	public TooMuchDistributionException() {
		super("Number of Vaxcines exceeded");
	}
	
	public TooMuchDistributionException(String msg) {
		super(msg);
	}

}
