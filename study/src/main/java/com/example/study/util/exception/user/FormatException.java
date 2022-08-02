package com.example.study.util.exception.user;

/**
 * 格式异常
 */
public class FormatException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    protected final String message;

    public FormatException(String message)
    {
        this.message = message;
    }

    public FormatException(String message, Throwable e)
    {
        super(message, e);
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
