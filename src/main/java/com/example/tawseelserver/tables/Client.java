package com.example.tawseelserver.tables;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Client")
public class Client
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name =  "email")
    private String email;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name =  "password")
    private String password;

    public Client(String firstName, String lastName, String email, LocalDate registrationDate, String password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.registrationDate = registrationDate;
        this.password = password;
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

    public LocalDate getRegistrationDate()
    {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate)
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


    @Override
    public String toString()
    {
        return "Clients{" + "id=" + id + ", firstName='" + firstName + '\'' + ", latName='" + lastName + '\'' + ", email='" + email + '\'' + ", registrationDate='" + registrationDate + '\'' + ", password='" + password + '\'' + '\'' + '}';
    }


}
