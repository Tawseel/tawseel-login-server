package com.example.tawseelserver.tables;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "Client")
public class Client
{
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name =  "email")
    private String email;

    @Column(name =  "registrationDate")
    private String registrationDate;

    @Column(name =  "password")
    private String password;

    @Column(name =  "phoneNumber")
    private String phoneNumber;

    public Client(String firstName, String lastName, String email, String registrationDate, String password, String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.registrationDate = registrationDate;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public Client()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String latName)
    {
        this.lastName = latName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getRegistrationDate()
    {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate)
    {
        this.registrationDate = registrationDate;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString()
    {
        return "Clients{" + "id=" + id + ", firstName='" + firstName + '\'' + ", latName='" + lastName + '\'' + ", email='" + email + '\'' + ", registrationDate='" + registrationDate + '\'' + ", password='" + password + '\'' + ", phoneNumber='" + phoneNumber + '\'' + '}';
    }


}
