package com.adam.flowboard.exception;

public class ForbiddenException extends RuntimeException{
    
    public ForbiddenException(){
        super("Action is forbidden");
    }
    
}
