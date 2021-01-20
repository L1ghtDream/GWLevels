package me.lightdream.gwlevels.exceptions;

public class NoUserFound  extends RuntimeException {
    public NoUserFound() {
        super("This user does not exist");
    }
}