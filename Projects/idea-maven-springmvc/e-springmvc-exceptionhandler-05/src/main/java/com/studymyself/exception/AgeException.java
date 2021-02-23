package com.studymyself.exception;

//表示当输入的age属性不符合要求时，抛出AgeException异常
public class AgeException extends MyUserException{

    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
