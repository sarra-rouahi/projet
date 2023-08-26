package com.projett.backendprojet.Response;

public class Reponse {
    private String message;

    public Reponse(String message) {
        this.message = message;
    }

    public Reponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
