package com.studymyself.exception;

//表示当用户的姓名有异常时，抛出NameException异常
public class NameException extends MyUserException{

    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }
}
