package cn.example.exception;

/**
 * 自定义异常类，用于处理异常
 */
public class SysException extends Exception{
    //用于存储错误提示信息的
    private String message;

    public SysException( String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
