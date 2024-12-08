package smartsofts.applicatif.elearning.exceptions;

public enum ErrorCodes {
	//students
	STUDENT_NOT_FOUND(1000),
	STUDENT_NOT_VALID(1001),
	//teachers
	TEACHER_NOT_FOUND(2000),
	TEACHER_NOT_VALID(2001),
	;
	
	private int code;
	
	private ErrorCodes(int code) {
		this.code=code;
	}

	public int getCode() {
		return code;
	}
	
	
	

}
