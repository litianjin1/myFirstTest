package com.example.study.util.exception.user;

/**
 * 格式异常
 */
public class QuotationException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    protected final String message;

    public QuotationException(String message)
    {
        this.message = message;
    }

    public QuotationException(String message, Throwable e)
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
