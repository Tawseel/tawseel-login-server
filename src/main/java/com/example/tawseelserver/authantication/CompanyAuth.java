package com.example.tawseelserver.authantication;

public class CompanyAuth extends UsernameAndPassword{
    private String name;
    private String telephoneNumber;

    public CompanyAuth(String email, String password, String name, String telephoneNumber) {
        super(email, password);
        this.name = name;
        this.telephoneNumber = telephoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
