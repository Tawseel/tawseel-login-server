package com.example.tawseelserver.authantication;

public class ClientAuth extends UsernameAndPassword{
    private String firstName;
    private String lastName;

    public ClientAuth(String email, String password, String firstName, String lastName) {
        super(email, password);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
