package com.adam.flowboard.exception;

/**
 * UserNotFoundException
 */
public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException(){
        super("User not found");
    }

}
