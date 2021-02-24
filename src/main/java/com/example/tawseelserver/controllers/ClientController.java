package com.example.tawseelserver.controllers;


import com.example.tawseelserver.services.ClientService;
import com.example.tawseelserver.tables.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/client")
public class ClientController
{
    @Autowired
    ClientService clientService;

    @GetMapping(path="/{email}/{password}")
    public ResponseEntity<Boolean> signIn(
            @PathVariable("email") String email,
            @PathVariable("password") String password)
    {
        boolean isSignInSucceeded  = clientService.signIn(email, password);
        return new ResponseEntity<>(isSignInSucceeded, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> signUp(@RequestBody Client client)
    {
        System.out.println("hello");
        clientService.signUp(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
