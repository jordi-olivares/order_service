package mx.com.Axity.commons.exceptions;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

}
