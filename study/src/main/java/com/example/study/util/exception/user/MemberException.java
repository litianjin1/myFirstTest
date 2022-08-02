package com.example.study.util.exception.user;

public class MemberException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    protected final String message;

    public MemberException(String message)
    {
        this.message = message;
    }

    public MemberException(String message, Throwable e)
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
