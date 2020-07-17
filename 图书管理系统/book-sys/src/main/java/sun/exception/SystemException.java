package sun.exception;

public class SystemException extends BaseException{
    public SystemException(String code, String message) {
        super("SYS"+code, "系统异常"+message);
    }

    public SystemException(String code, String message, Throwable cause) {
        super("SYS"+code, "系统异常"+message, cause);
    }
}
