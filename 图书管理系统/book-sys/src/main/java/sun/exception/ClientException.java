package sun.exception;

public class ClientException extends BaseException{
    public ClientException(String code, String message) {
        super("CLT"+code, "客户端错误"+message);
    }

    public ClientException(String code, String message, Throwable cause) {
        super("CLT"+code, "客户端错误"+message, cause);
    }
}
