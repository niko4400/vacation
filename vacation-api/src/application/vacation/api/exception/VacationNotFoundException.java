package application.vacation.api.exception;

public class VacationNotFoundException  extends Exception{
	private static final long serialVersionUID = 1L;

	public VacationNotFoundException() {
	}

	public VacationNotFoundException(String arg0) {
		super(arg0);
	}

	public VacationNotFoundException(Throwable arg0) {
		super(arg0);
	}

	public VacationNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public VacationNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
}	
