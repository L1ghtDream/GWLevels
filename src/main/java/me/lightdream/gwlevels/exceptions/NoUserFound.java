package me.lightdream.gwlevels.exceptions;

public class NoUserFound  extends RuntimeException {
    public NoUserFound(String errorMessage) {
        super(errorMessage);
    }
}