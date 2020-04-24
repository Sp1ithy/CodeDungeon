package com.company.Exceptions;

public class LessThanZeroException extends Exception {
    public LessThanZeroException(Object element){
        super(String.format("'%s' can't be negative",element.toString()));
    }
}
