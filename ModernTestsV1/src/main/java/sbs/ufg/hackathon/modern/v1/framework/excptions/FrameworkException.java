package sbs.ufg.hackathon.modern.v1.framework.excptions;

public class FrameworkException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3921489514428593617L;

	public FrameworkException(String errorMessage) {
        super(errorMessage);
    }

}