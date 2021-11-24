package sit.integrated.project.exceptions;

public class ProductsException extends RuntimeException {
    ExceptionResponse.ERROR_CODE errorCode;
    public ProductsException (ExceptionResponse.ERROR_CODE errorCode, String s) {
        super(s);
        this.errorCode = errorCode;
    }

    public ExceptionResponse.ERROR_CODE getErrorCode() {
        return this.errorCode;
    }
}
