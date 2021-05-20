package com.example.pharmacy.resources;

public class MessageResource extends BaseResource{

    private String message;

    public MessageResource() {
    }

    public MessageResource(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
