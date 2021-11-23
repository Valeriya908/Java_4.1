package ru.netology.domain;

public class NonexistentIdException extends RuntimeException{

    public NonexistentIdException(String msg) {
        super(msg);
    }

}
