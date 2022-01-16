package com.example.foregroundbackgroundcell.model;

public class Message {
    public String sender;
    public String description;
    public int profile;

    public Message(String sender, String description, int profile) {
        this.sender = sender;
        this.description = description;
        this.profile = profile;
    }
}
