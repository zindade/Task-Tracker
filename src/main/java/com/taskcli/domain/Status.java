package com.taskcli.domain;

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

    public static Status getStatus(String value) {
        try {
            return Status.valueOf(value.toUpperCase().replace("-", "_"));
        } catch (IllegalArgumentException e) {
            return TODO;
        }
    }
}
