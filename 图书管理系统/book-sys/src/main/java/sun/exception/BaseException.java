package sun.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException{
    protected String code;

    public BaseException(String code,String message ) {
        super(message);
        this.code = code;
    }

    public BaseException(String code,String message, Throwable cause ) {
        super(message, cause);
        this.code = code;
    }
}
