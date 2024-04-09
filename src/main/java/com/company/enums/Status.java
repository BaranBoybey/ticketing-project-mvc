package com.company.enums;

public enum Status {
    COMPLETED("Completed"), OPEN("Open"), IN_PROGRESS("IN PROGRESS");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
