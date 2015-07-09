package net.zz.validator.exception;



public class CommonException extends RuntimeException {


	private int code = 0;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public CommonException(int code, String message) {
        super(message);
        this.code = code;
    }
}
