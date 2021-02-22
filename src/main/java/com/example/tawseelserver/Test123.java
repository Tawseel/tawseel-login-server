package com.example.tawseelserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="tawseel")
public class Test123
{
    @GetMapping
    public String hello()
    {
        System.out.println("hello");
        return "Hello word!";
    }

    @GetMapping(path="{email}/{password}")
    public boolean login(
            @PathVariable("email") String email,
            @PathVariable("password") String password)
    {
        System.out.printf("login with email=%s, password=%s\n", email, password);
        return email.equals("admin@admin.com") && password.equals("admin");
    }
}
