package com.asifsid88.myexpense.app.service;

/**
 * Created by mhussaa on 6/15/17.
 */

public enum ContentType {
    APPLICATION_JSON("application/json"),
    XML("xml");

    private String contentType;

    ContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return this.contentType;
    }
}
