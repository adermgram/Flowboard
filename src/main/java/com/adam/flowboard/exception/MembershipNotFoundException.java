package com.adam.flowboard.exception;

public class MembershipNotFoundException extends RuntimeException {

    public MembershipNotFoundException(){
        super("Membership doesn't exist");
    }
    
}
