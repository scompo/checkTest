package it.scompo.checktest.exceptions;

public class MissingIdException extends MyExceptions {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4618458478932136881L;

	/**
	 * 
	 */
	public MissingIdException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public MissingIdException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MissingIdException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public MissingIdException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public MissingIdException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
