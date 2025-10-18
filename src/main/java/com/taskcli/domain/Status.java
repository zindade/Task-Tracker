package main.java.com.taskcli.domain;

import java.nio.ReadOnlyBufferException;

public enum Status {
    TODO("task needs to be concluded"),
    IN_PROGRESS("task in progress"),
    DONE("task already done");

    private final String message;

    Status(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
