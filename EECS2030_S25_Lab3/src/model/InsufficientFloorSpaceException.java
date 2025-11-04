package model;

public class InsufficientFloorSpaceException extends Exception{
	
	public InsufficientFloorSpaceException() {
		super("idk error");
	}
	
	public InsufficientFloorSpaceException(String msg) {
		super(msg);
	}

}
