package com.collage.model;

public class AuthRequest {

    private String contact;
    private String password;

    public AuthRequest(String contact, String password) {
        this.contact = contact;
        this.password = password;
    }

    public AuthRequest() {
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "contact='" + contact + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
